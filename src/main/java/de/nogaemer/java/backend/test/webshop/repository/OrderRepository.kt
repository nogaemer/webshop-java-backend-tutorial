package de.nogaemer.java.backend.test.webshop.repository

import de.nogaemer.java.backend.test.webshop.model.Model
import de.nogaemer.java.backend.test.webshop.model.OrderCreateRequest
import de.nogaemer.java.backend.test.webshop.model.OrderResponse
import de.nogaemer.java.backend.test.webshop.model.OrderStatus
import de.nogaemer.java.backend.test.webshop.utils.UUIDUtils
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Suppress("UNCHECKED_CAST")
@Service
class OrderRepository {

    private val orders = mutableListOf<OrderResponse>()
    fun save(request: OrderCreateRequest): OrderResponse {

        val orderResponse = OrderResponse(
            UUIDUtils.randomUUID(orders as ArrayList<Model>?),
            request.customerId,
            LocalDateTime.now(),
            OrderStatus.ORDERED,
            emptyList()
        )

        orders.add(orderResponse)
        return orderResponse
    }

    fun findAll(): List<OrderResponse>{
        return orders
    }

    fun findById(orderId: String): OrderResponse? {
        return orders.find { it.id == orderId}
    }

}
