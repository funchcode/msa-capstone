package com.example.payment.api

import com.example.payment.api.dto.IntentReq
import com.example.payment.core.service.PaymentService
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Slf4j
@RestController
@RequestMapping("/v1")
class PaymentController(
    private val paymentService: PaymentService
) {
    private val log = LoggerFactory.getLogger(javaClass)

    @PostMapping("/intents")
    fun createIntent(@RequestBody dto: IntentReq) {
        log.debug("{}", dto);
    }

    @PostMapping("/intents/{id}/authorize")
    fun authorizeIntent(@PathVariable id: String) {

    }

    @PostMapping("/intents/{id}/cancel")
    fun cancelIntent(@PathVariable id: String) {

    }

    @GetMapping("/intents/{id}")
    fun getIntent(@PathVariable id: String) {

    }

}