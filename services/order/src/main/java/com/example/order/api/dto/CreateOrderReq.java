package com.example.order.api.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CreateOrderReq {

    /* 주문자 정보 */
    private String customerId; // todo 이동 필요(빠른 구현을 위하여 바디에 위치)
    private List<CreateOrderItem> items;

}
