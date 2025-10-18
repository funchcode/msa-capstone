package com.example.order.api.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateOrderItem {

    /* 단위 */
    private String sku;
    /* 수량 */
    private Integer qty;
    /* 단가 */
    private Long unitPrice;

}
