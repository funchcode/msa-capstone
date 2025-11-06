package com.example.order.core.service;

import com.example.order.core.domain.Order;
import com.example.order.core.domain.OrderItem;
import com.example.order.core.repo.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderOrchestrator {

    private final RestClient restClient;
    private final OrderRepository orderRepository;

    @Transactional
    public String create(String customerId, List<OrderItem> items) {
        log.debug("[in] create order service. customerId -> {}, items -> {}", customerId, items);
        var orderId = UUID.randomUUID().toString();
        var order = Order.create(orderId, customerId, items);
        orderRepository.save(order);

        /* todo 재고 예약
        fixme 실패 시 재시도 처리
        fixme 최종 실패에 대한 처리
         */
        var reservationId = restClient.post()
                .uri("/v1/reservations")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ReservationReq())
                .retrieve()
                .body(String.class);

        var amount = -1;
        /* todo 결제 의도 & 승인
        fixme 실패 시 재시도 처리
        fixme 최종 실패에 대한 처리
         */
        var intentId = restClient.post()
                        .uri("/v1/intents")
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(new IntentReq())
                        .retrieve()
                        .body(String.class);

        order.doConfirm();
        orderRepository.save(order);

        return orderId;
    }

    @Transactional
    public void cancel(String orderId) {
        log.debug("[in] cancel order service. orderId -> {}", orderId);
        orderRepository.findById(orderId).ifPresent(order -> {
            order.doCancel();
            orderRepository.save(order);

            // todo 결제 취소 전파(재고, 결제)
        });
    }

    private class ReservationItemReq {
        private String sku;
        private int qty;
    }

    private class ReservationReq {
        private String orderId;
        private List<ReservationReq> items;
    }

    private class IntentReq {
        private String orderId;
        private long amount;
    }

}
