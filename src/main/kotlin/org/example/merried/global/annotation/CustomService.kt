package org.example.merried.global.annotation

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.CLASS

@Target(CLASS)
@Retention(RUNTIME)
@Service
@Transactional
annotation class CustomService(
    val readOnly: Boolean = false
)
