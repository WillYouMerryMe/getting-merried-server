package org.example.married.domain.s3.presentation

import org.example.married.domain.s3.service.S3PresignedUrlService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.Duration

@RestController
@RequestMapping("/files")
class FileController(
    private val presignedUrlService: S3PresignedUrlService
) {
    @GetMapping("/presigned")
    fun getPresignedUrl(
        @RequestParam bucket: String,
        @RequestParam key: String
    ): ResponseEntity<String> {
        val url = presignedUrlService.generateUploadPresignedUrl(bucket, key, Duration.ofMinutes(10))
        return ResponseEntity.ok(url.toString())
    }
}