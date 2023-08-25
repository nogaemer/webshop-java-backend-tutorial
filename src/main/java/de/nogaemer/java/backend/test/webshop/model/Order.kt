package de.nogaemer.java.backend.test.webshop.model

import java.time.LocalDateTime

data class OrderResponse(
    private val id: String,
    val customerId: String,
    val orderTime: LocalDateTime,
    val status: OrderStatus,
    val orderPositions: List<OrderPositionResponse>
): Model {
    override fun getId(): String {
        return id
    }
}

data class OrderPositionResponse(
    val id: String,
    val orderId: String,
    val productId: String,
    val quantity: Long
)

enum class OrderStatus {
    ORDERED,
    PAYED,
    SHIPPED,
    DELIVERED,
    CANCELED
}