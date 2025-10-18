package com.example.order.api;

import com.example.order.api.dto.CreateOrderReq;
import com.example.order.core.domain.OrderItem;
import com.example.order.core.service.OrderOrchestrator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/v1/orders")
@RestController
public class OrderController {

    private OrderOrchestrator orderOrchestrator;

    @PostMapping
    public ResponseEntity<Object> create(
            @RequestBody CreateOrderReq req
    ) {
        var items = req.getItems().stream()
                .map(item -> new OrderItem(item.getSku(), item.getQty(), item.getUnitPrice()))
                .toList();
        var orderId = orderOrchestrator.create(req.getCustomerId(), items);
        return ResponseEntity.accepted().body(Map.of("orderId", orderId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOrder(
            @PathVariable("id") String id
    ) {
        return ResponseEntity.ok("");
    }

    @PostMapping("/{id}/cancel")
    public ResponseEntity<Object> cancelOrder(
            @PathVariable("id") String id
    ) {
        return ResponseEntity.ok("");
    }

}
