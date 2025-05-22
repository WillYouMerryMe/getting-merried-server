package org.example.married.global.util

import java.util.UUID

fun generateDocumentId(): String = UUID.randomUUID().toString().replace("-", "")
