package de.nogaemer.java.backend.test.webshop.controller

import de.nogaemer.java.backend.test.webshop.model.CustomerResponse
import de.nogaemer.java.backend.test.webshop.repository.CustomerRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController(
    private val customerRepository: CustomerRepository
) {

    @GetMapping("/customers/{id}")
    fun getCustomerById(
        @PathVariable id: String
    ): ResponseEntity<CustomerResponse> {
        val response = customerRepository.findById(id)
        return if (response != null)
            ResponseEntity.ok(response)
        else
            ResponseEntity.notFound().build()
    }

    @GetMapping("/customers")
    fun getAllProducts(): List<CustomerResponse?> {
        return customerRepository.findAll()
    }

}