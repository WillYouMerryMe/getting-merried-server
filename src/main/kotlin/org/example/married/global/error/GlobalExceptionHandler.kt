package org.example.married.global.error

import com.fasterxml.jackson.databind.exc.MismatchedInputException
import jakarta.servlet.http.HttpServletRequest
import org.example.married.global.error.exception.BusinessException
import org.example.married.global.error.exception.ErrorCode
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.BindException
import org.springframework.web.HttpMediaTypeNotSupportedException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import org.springframework.web.multipart.MaxUploadSizeExceededException
import org.springframework.web.multipart.MultipartException
import org.springframework.web.multipart.support.MissingServletRequestPartException
import org.springframework.web.servlet.NoHandlerFoundException
import org.springframework.web.servlet.resource.NoResourceFoundException

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(
        request: HttpServletRequest,
        exception: BusinessException,
    ): ResponseEntity<ErrorResponse> {
        val response = ErrorResponse.of(
            request = request,
            exception = exception,
        )
        response.errorLogging()
        return makeResponse(response)
    }

    @ExceptionHandler(
        IllegalArgumentException::class,
        IllegalStateException::class,
    )
    fun handleKotlinRequiredAndCheckException(
        request: HttpServletRequest,
        exception: Exception,
    ): ResponseEntity<ErrorResponse> {
        val errorCode = ErrorCode.VALIDATION_ERROR
        val response = ErrorResponse.of(
            request = request,
            errorCode = errorCode,
            detail = exception.message,
        )
        response.errorLogging()
        return makeResponse(response)
    }

    @ExceptionHandler(NoHandlerFoundException::class)
    fun handleNoHandlerFoundException(
        request: HttpServletRequest,
        exception: NoHandlerFoundException,
    ): ResponseEntity<ErrorResponse> {
        val errorCode = ErrorCode.NOT_SUPPORTED_URI_ERROR
        val response = ErrorResponse.of(
            request = request,
            errorCode = errorCode,
            detail = null,
        )
        response.errorLogging()
        return makeResponse(response)
    }

    @ExceptionHandler(
        HttpMessageNotReadableException::class,
        MismatchedInputException::class,
    )
    fun handleHttpMessageNotReadableException(
        request: HttpServletRequest,
        exception: Exception,
    ): ResponseEntity<ErrorResponse> {
        val errorCode = ErrorCode.VALIDATION_ERROR
        val response = ErrorResponse.of(
            request = request,
            errorCode = errorCode,
            detail = exception.message,
        )
        response.errorLogging()
        return makeResponse(response)
    }

    @ExceptionHandler(
        UnsatisfiedServletRequestParameterException::class,
        MissingServletRequestPartException::class,
        MissingServletRequestParameterException::class,
        MultipartException::class,
    )
    fun handleUnsatisfiedServletRequestParameterException(
        request: HttpServletRequest,
        exception: Exception,
    ): ResponseEntity<ErrorResponse> {
        val errorCode = ErrorCode.VALIDATION_ERROR
        val response = ErrorResponse.of(
            request = request,
            errorCode = errorCode,
            detail = exception.message,
        )
        response.errorLogging()
        return makeResponse(response)
    }

    @ExceptionHandler(
        MethodArgumentNotValidException::class,
        BindException::class,
    )
    fun handleMethodArgumentNotValidException(
        request: HttpServletRequest,
        exception: MethodArgumentNotValidException,
    ): ResponseEntity<ErrorResponse> {
        val details = exception.fieldErrors.map {
            mapOf(
                "field" to it.field,
                "rejectedValue" to it.rejectedValue,
                "message" to (it.defaultMessage ?: "invalid value")
            )
        }
        val errorCode = ErrorCode.VALIDATION_ERROR
        val response = ErrorResponse.of(
            request = request,
            errorCode = errorCode,
            detail = details,
        )
        response.errorLogging()
        return makeResponse(response)
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    fun handleMethodArgumentTypeMismatchException(
        request: HttpServletRequest,
        exception: MethodArgumentTypeMismatchException,
    ): ResponseEntity<ErrorResponse> {
        val errorCode = ErrorCode.VALIDATION_ERROR
        val response = ErrorResponse.of(
            request = request,
            errorCode = errorCode,
            detail = exception.message,
        )
        response.errorLogging()
        return makeResponse(response)
    }

    @ExceptionHandler(MaxUploadSizeExceededException::class)
    fun handleMaxUploadSizeExceededException(
        request: HttpServletRequest,
        exception: MaxUploadSizeExceededException,
    ): ResponseEntity<ErrorResponse> {
        val errorCode = ErrorCode.VALIDATION_ERROR
        val response = ErrorResponse.of(
            request = request,
            errorCode = errorCode,
            detail = "${exception.body.detail}: allow=${exception.maxUploadSize}",
        )
        response.errorLogging()
        return makeResponse(response)
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    fun handleHttpRequestMethodNotSupportedException(
        request: HttpServletRequest,
        exception: HttpRequestMethodNotSupportedException,
    ): ResponseEntity<ErrorResponse> {
        val errorCode = ErrorCode.NOT_SUPPORTED_METHOD_ERROR
        val response = ErrorResponse.of(request = request, errorCode = errorCode)
        response.errorLogging()
        return makeResponse(response)
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException::class)
    fun handleHttpMediaTypeNotSupportedException(
        request: HttpServletRequest,
        exception: HttpMediaTypeNotSupportedException,
    ): ResponseEntity<ErrorResponse> {
        val errorCode = ErrorCode.UNSUPPORTED_MEDIA_TYPE_ERROR
        val response = ErrorResponse.of(request = request, errorCode = errorCode)
        response.errorLogging()
        return makeResponse(response)
    }

    @ExceptionHandler(DataIntegrityViolationException::class)
    fun handleDataIntegrityViolationException(
        request: HttpServletRequest,
        exception: DataIntegrityViolationException,
    ): ResponseEntity<ErrorResponse> {
        val errorCode = ErrorCode.UNEXPECTED_SERVER_ERROR
        val response = ErrorResponse.of(
            request = request,
            errorCode = errorCode,
            detail = exception.message,
        )
        response.errorLogging()
        return makeResponse(response)
    }

    @ExceptionHandler(NoResourceFoundException::class)
    fun handleNoResourceFoundException(
        request: HttpServletRequest,
        exception: NoResourceFoundException,
    ): ResponseEntity<ErrorResponse> {
        val errorCode = ErrorCode.UNEXPECTED_SERVER_ERROR
        val response = ErrorResponse.of(request = request, errorCode = errorCode)
        response.errorLogging()
        return makeResponse(response)
    }

    @ExceptionHandler(Exception::class)
    fun handleAnonymousException(
        request: HttpServletRequest,
        exception: Exception,
    ): ResponseEntity<ErrorResponse> {
        val errorCode = ErrorCode.UNEXPECTED_SERVER_ERROR
        val response = ErrorResponse.of(request = request, errorCode = errorCode)
        response.errorLogging()
        return makeResponse(response)
    }

    private fun makeResponse(
        response: ErrorResponse,
    ): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(response.status.value()).body(response)
    }
}