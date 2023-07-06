package de.nogaemer.java.backend.test.webshop.model

data class CustomerResponse(
    private val id: String,
    val fristName: String,
    val lastName: String,
    val email: String,
): Model {
    override fun getId(): String {
        return id
    }

}