package com.example.payment.api.dto

data class IntentReq(
    val orderId: String,
    val amount: Int,
)
