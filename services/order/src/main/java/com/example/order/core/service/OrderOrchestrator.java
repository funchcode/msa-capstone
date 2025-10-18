package com.example.order.core.service;

import com.example.order.core.domain.OrderItem;
import com.example.order.core.repo.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderOrchestrator {

    private final OrderRepository orderRepository;

    @Transactional
    public String create(String customerId, List<OrderItem> items) {
        log.debug("[in] create order service. customerId -> {}, items -> {}", customerId, items);
        return "";
    }

}
