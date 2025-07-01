//package org.example.married.domain.s3.service
//
//import com.amazonaws.HttpMethod
//import com.amazonaws.services.s3.AmazonS3Client
//import com.amazonaws.services.s3.Headers
//import com.amazonaws.services.s3.model.AmazonS3Exception
//import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest
//import org.springframework.beans.factory.annotation.Value
//import org.springframework.http.HttpStatus
//import org.springframework.stereotype.Service
//import java.time.Instant
//import java.time.temporal.ChronoUnit
//import java.util.*
//
//data class UrlResponse(val uploadUrl: String, val downloadUrl: String?)
//
//@Service
//class FileService(
//    private val amazonS3Client: AmazonS3Client,
//    @Value("\${spring.cloud.aws.s3.bucket}") private val bucket: String
//) {
//
//    fun getUploadPresignedUrl(
//        folder: String,
//        fileName: String,
//        metadata: FileMetadata,
//        validator: FileValidator,
//    ): String {
//        validator.validate(metadata)
//        val key = "$folder/$fileName"
//        val request = GeneratePresignedUrlRequest(bucket, key).apply {
//            method = HttpMethod.PUT
//            expiration = expirationMinutes(3)
//            putCustomRequestHeader(Headers.CONTENT_TYPE, metadata.mediaType)
//            putCustomRequestHeader(Headers.CONTENT_LENGTH, metadata.fileSize.toString())
//        }
//        return amazonS3Client.generatePresignedUrl(request).toString()
//    }
//
//    fun getDownloadPresignedUrl(folder: String, fileName: String): String? {
//        val key = "$folder/$fileName"
//        return try {
//            amazonS3Client.getObjectMetadata(bucket, key)
//            GeneratePresignedUrlRequest(bucket, key).apply {
//                method = HttpMethod.GET
//                expiration = expirationMinutes(10)
//            }.let(amazonS3Client::generatePresignedUrl)
//                .toString()
//        } catch (e: AmazonS3Exception) {
//            if (e.statusCode == HttpStatus.NOT_FOUND.value()) null else throw e
//        }
//    }
//
//    fun getPresignedUrl(
//        folder: String,
//        fileName: String,
//        metadata: FileMetadata,
//        validator: FileValidator,
//    ): UrlResponse = UrlResponse(
//        uploadUrl = getUploadPresignedUrl(folder, fileName, metadata, validator),
//        downloadUrl = getDownloadPresignedUrl(folder, fileName)
//    )
//
//    private fun expirationMinutes(minutes: Long): Date =
//        Date.from(Instant.now().plus(minutes, ChronoUnit.MINUTES))
//}
