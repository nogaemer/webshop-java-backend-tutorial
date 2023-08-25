package de.nogaemer.java.backend.test.webshop.repository

import de.nogaemer.java.backend.test.webshop.exceptions.IdNotFoundException
import de.nogaemer.java.backend.test.webshop.model.CustomerResponse
import de.nogaemer.java.backend.test.webshop.model.Model
import de.nogaemer.java.backend.test.webshop.utils.UUIDUtils
import org.springframework.stereotype.Service

@Service
@Suppress("UNCHECKED_CAST")
class CustomerRepository {
    private var customers: ArrayList<CustomerResponse> = ArrayList()

    init {
        customers =
            arrayListOf(
                CustomerResponse(
                    UUIDUtils.randomUUID(
                        customers as ArrayList<Model>?
                    ),
                    fristName = "Max",
                    lastName = "Mustermann",
                    email = "test Mail"
                ),
                CustomerResponse(
                    UUIDUtils.randomUUID(
                        customers as ArrayList<Model>?
                    ),
                    fristName = "Max",
                    lastName = "Mustermann",
                    email = ""
                )
            )
    }

    fun findById(id: String): CustomerResponse {
        return customers.find { it.id == id }
            ?: throw IdNotFoundException("Customer with id $id not found")
    }

    fun findAll(): List<CustomerResponse> {
        return customers
    }

}
