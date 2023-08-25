package de.nogaemer.java.backend.test.webshop.repository

import de.nogaemer.java.backend.test.webshop.model.OrderPositionResponse
import org.springframework.stereotype.Service

@Service
class OrderPositionRepository {

    private val orderPositions = mutableListOf<OrderPositionResponse>()

    fun save(orderPositionResponse: OrderPositionResponse) {
        orderPositions.add(orderPositionResponse)
    }

    fun findAllByOrdersIds(orderIds: List<String>): List<OrderPositionResponse> {
        return orderPositions.filter { orderIds.contains(it.orderId) }
    }

}
