package de.nogaemer.java.backend.test.webshop.model

data class ShoppingCardResponse(
    val customerId: String,
    val orderPositions: List<OrderPositionResponse>,
    val totalPrice: Long,
    val deliveryCosts: Long,
    val deliveryOptions: String
)
