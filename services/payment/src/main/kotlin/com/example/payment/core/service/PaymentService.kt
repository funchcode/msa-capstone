package com.example.payment.core.service

import com.example.payment.core.repo.PaymentRepository
import org.springframework.stereotype.Service

@Service
class PaymentService(
    private val paymentRepository: PaymentRepository
) {
}