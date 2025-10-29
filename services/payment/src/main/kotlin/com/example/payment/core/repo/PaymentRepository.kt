package com.example.payment.core.repo

import com.example.payment.core.domain.Payment
import org.springframework.data.repository.CrudRepository

interface PaymentRepository : CrudRepository<Payment, String> {
}