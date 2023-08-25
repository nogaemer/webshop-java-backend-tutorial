package de.nogaemer.java.backend.test.webshop.controller

import de.nogaemer.java.backend.test.webshop.model.CustomerResponse
import de.nogaemer.java.backend.test.webshop.model.ShoppingCardResponse
import de.nogaemer.java.backend.test.webshop.repository.CustomerRepository
import de.nogaemer.java.backend.test.webshop.service.ShoppingCardService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController(
    private val customerRepository: CustomerRepository,
    private val shoppingCardService: ShoppingCardService
) {

    @GetMapping("/customers/{id}")
    fun getCustomerById(
        @PathVariable id: String
    ): ResponseEntity<CustomerResponse> {
        val response = customerRepository.findById(id)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/customers/{id}/shoppingcart")
    fun getShoppingCartByCustomerId(
        @PathVariable id: String
    ): ShoppingCardResponse {
        return shoppingCardService.getShoppingCardByCustomerId(id)
    }

    @GetMapping("/customers")
    fun getAllProducts(): List<CustomerResponse?> {
        return customerRepository.findAll()
    }

}