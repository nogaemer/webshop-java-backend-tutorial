package de.nogaemer.java.backend.test.webshop.exceptions

import de.nogaemer.java.backend.test.webshop.logger.TextFormatter
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ApiExceptionHandler {
    val formatter: TextFormatter = TextFormatter()
//    @ExceptionHandler(WebshopException::class)
//    fun handleErrors(request: HttpServletRequest, exception: WebshopException): ResponseEntity<ErrorInfo> {
//
//        println(formatter.errorInverted("WebshopException"))
//        println(formatter.subErrorInverted("Message") + exception.message)
//        println(formatter.subErrorInverted("Exception") + exception + "\n")
//
//        val errorInfo = ErrorInfo(exception.message, request.requestURI)
//        return ResponseEntity.status(exception.statusCode).body(errorInfo)
//    }

    @ExceptionHandler(Throwable::class)
    fun handleErrors(request: HttpServletRequest, exception: Throwable): ResponseEntity<ErrorInfo> {
        val errorMsg = exception.message ?: "An error occurred"

        println(formatter.errorInverted(exception.javaClass.simpleName))
        println(formatter.subErrorInverted("Message") + errorMsg)
        println(formatter.subErrorInverted("Exception") + exception + "\n")

        val (code, message) = when (exception) {
            is WebshopException -> exception.statusCode to errorMsg
            is IdNotFoundException -> HttpStatus.NOT_FOUND to errorMsg
            else -> HttpStatus.INTERNAL_SERVER_ERROR to errorMsg
        }

        val errorInfo = ErrorInfo(message, request.requestURI)
        return ResponseEntity.status(code).body(errorInfo)
    }
}

data class ErrorInfo(
    val error: String,
    val path: String
)