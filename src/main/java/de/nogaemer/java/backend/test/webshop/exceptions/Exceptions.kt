package de.nogaemer.java.backend.test.webshop.exceptions

import org.springframework.http.HttpStatus

data class WebshopException(
    override val message: String,
    val statusCode: HttpStatus
): RuntimeException(message)

data class IdNotFoundException(
    override val message: String,
): RuntimeException(message)

