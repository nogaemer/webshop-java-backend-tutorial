package de.nogaemer.java.backend.test.webshop.service

import de.nogaemer.java.backend.test.webshop.exceptions.IdNotFoundException
import de.nogaemer.java.backend.test.webshop.model.*
import de.nogaemer.java.backend.test.webshop.repository.CustomerRepository
import de.nogaemer.java.backend.test.webshop.repository.OrderPositionRepository
import de.nogaemer.java.backend.test.webshop.repository.OrderRepository
import de.nogaemer.java.backend.test.webshop.repository.ProductRepository
import de.nogaemer.java.backend.test.webshop.utils.UUIDUtils
import org.springframework.stereotype.Service

@Suppress("UNCHECKED_CAST")
@Service
class OrderService (
    private val productRepository: ProductRepository,
    private val orderRepository: OrderRepository,
    private val orderPositionRepository: OrderPositionRepository,
    private val customerRepository: CustomerRepository
){
    fun createOrder(order: OrderCreateRequest): OrderResponse {
        customerRepository.findById(order.customerId)
            ?: throw IdNotFoundException("Customer with id ${order.customerId} not found")

        return orderRepository.save(order)
    }

    fun createNewPostionForOrder(
        orderId: String,
        request: OrderPositionCreateRequest
    ): OrderPositionResponse {
        orderRepository.findById(orderId)
            ?: throw IdNotFoundException("Order with id $orderId not found")

        productRepository.findById(request.productId)
            ?: throw IdNotFoundException("Product with id ${request.productId} not found")

        val orderPositionResponse = OrderPositionResponse(
            id = UUIDUtils.randomUUID(orderRepository.findAll() as ArrayList<Model>?),
            productId = request.productId,
            quantity = request.quantity
        )
        orderPositionRepository.save(orderPositionResponse)

        return orderPositionResponse
    }


}