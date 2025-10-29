package com.example.payment.core.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant

@Entity
class Payment(
    @Id
    val id: String? = null,
    @Column(name = "order_id")
    val orderId: String,
    val amount: Int,
    val status: Int,
    @Column(name = "created_at")
    @CreatedDate
    val createdAt: Instant? = null,
    @Column(name = "updated_at")
    @LastModifiedDate
    val updatedAt: Instant? = null,
)