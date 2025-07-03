package org.example.married.domain.s3.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity

@Tag(name = "File API")
interface QueryFileController {

    @Operation(
        summary = "presignedUrl 발급 API 입니다.",
        description = "등록시킬 파일명과 함께 요청을 보낼 시 등록 가능한 presignedUrl이 발급됩니다.",
    )
    fun getPresignedUrl(
        fileName: String,
    ): ResponseEntity<String>

    @Operation(
        summary = "등록시킨 이미지 다운로드 API 입니다.",
        description = "경로와 함께 요청을 보낼 시 다운로드 가능한 url이 발급됩니다.",
    )
    fun getPresignedUrlToDownload(
        fileDomain: String,
    ): ResponseEntity<String>
}