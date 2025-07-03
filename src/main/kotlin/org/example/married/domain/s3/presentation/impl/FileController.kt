package org.example.married.domain.s3.presentation.impl

import org.example.married.domain.s3.presentation.QueryFileController
import org.example.married.domain.s3.service.QueryFileService
import org.example.married.domain.user.domain.facade.UserFacade
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/files")
class FileController(
    private val queryFileService: QueryFileService,
): QueryFileController {

    @GetMapping("/presigned")
    override fun getPresignedUrl(
        @RequestParam fileName: String,
    ): ResponseEntity<String> {
        val url = queryFileService.generatePreSignedUrlToUpload(fileName, UserFacade.Companion.getCurrentUser())
        return ResponseEntity.ok(url)
    }

    @GetMapping("/download")
    override fun getPresignedUrlToDownload(
        @RequestParam fileDomain: String
    ): ResponseEntity<String> {
        val url = queryFileService.generatePreSignedUrlToDownload(fileDomain)
        return ResponseEntity.ok(url)
    }
}