package de.nogaemer.java.backend.test.webshop.controller

import de.nogaemer.java.backend.test.webshop.model.OrderCreateRequest
import de.nogaemer.java.backend.test.webshop.model.OrderPositionCreateRequest
import de.nogaemer.java.backend.test.webshop.model.OrderPositionResponse
import de.nogaemer.java.backend.test.webshop.model.OrderResponse
import de.nogaemer.java.backend.test.webshop.service.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController(
    private val orderService: OrderService
) {
    @PostMapping("/orders")
    fun createOrder(
        @RequestBody order: OrderCreateRequest
    ): ResponseEntity<*> {
        return responseEntity(order)
    }

    private fun responseEntity(order: OrderCreateRequest): ResponseEntity<OrderResponse> {
        return ResponseEntity.ok(orderService.createOrder(order))
    }

    @PostMapping("/orders/{id}/positions")
    fun createOrderPosition(
        @PathVariable(name = "id") orderId: String,
        @RequestBody request: OrderPositionCreateRequest
    ): OrderPositionResponse {
        return orderService.createNewPostionForOrder(orderId, request)
    }

}