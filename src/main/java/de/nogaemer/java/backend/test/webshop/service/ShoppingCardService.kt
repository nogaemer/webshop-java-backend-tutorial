package de.nogaemer.java.backend.test.webshop.service

import de.nogaemer.java.backend.test.webshop.model.OrderPositionResponse
import de.nogaemer.java.backend.test.webshop.model.OrderResponse
import de.nogaemer.java.backend.test.webshop.model.ShoppingCardResponse
import de.nogaemer.java.backend.test.webshop.repository.OrderPositionRepository
import de.nogaemer.java.backend.test.webshop.repository.OrderRepository
import de.nogaemer.java.backend.test.webshop.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ShoppingCardService(
    private val orderRepository: OrderRepository,
    private val orderPositionRepository: OrderPositionRepository,
    private val productRepository: ProductRepository
) {
    fun getShoppingCardByCustomerId(customerId: String): ShoppingCardResponse {
        val orders: List<OrderResponse> = orderRepository.findAllByCustomerIdWhereOrderStatusIsNew(customerId)
        val orderIds = orders.map { it.id }
        val orderPositions: List<OrderPositionResponse> = orderPositionRepository.findAllByOrdersIds(orderIds)

        val deliveryCosts: Long = if (orderPositions.isEmpty()) 0 else 800
        val positionSum = orderPositions.sumOf { (productRepository.findById(it.productId).priceInCents * it.quantity) }
        val totalPrice = positionSum + deliveryCosts

        return ShoppingCardResponse(
            customerId = customerId,
            orderPositions = orderPositions,
            totalPrice = totalPrice,
            deliveryCosts = deliveryCosts,
            deliveryOptions = "STANDARD"
        )
    }

}
