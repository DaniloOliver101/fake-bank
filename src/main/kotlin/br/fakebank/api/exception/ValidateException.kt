package br.fakebank.api.exception

import org.springframework.http.HttpStatus
import kotlin.RuntimeException

open class ValidateException(
    open val httpStatusCode: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR, override val message: String? = ""


) : RuntimeException()