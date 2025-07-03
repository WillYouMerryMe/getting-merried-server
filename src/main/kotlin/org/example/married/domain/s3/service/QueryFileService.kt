package org.example.married.domain.s3.service

import org.example.married.domain.user.domain.User
import org.example.married.global.config.properties.S3Properties
import org.springframework.stereotype.Service
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.s3.model.GetObjectRequest
import software.amazon.awssdk.services.s3.model.PutObjectRequest
import software.amazon.awssdk.services.s3.presigner.S3Presigner
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest
import java.time.Duration
import java.util.*


@Service
class QueryFileService(
    private val s3Properties: S3Properties,
    private val awsCredentialsProvider: AwsCredentialsProvider,
) {

    companion object {
        private const val DURATION_OF_PRESIGNED_URL_MINUTE = 30L
    }

    fun generatePreSignedUrlToUpload(fileName: String, user: User): String {
        val encodedFileName = "${createUUID()}_${fileName}"
        val objectName = "${user.id}/$encodedFileName"
        S3Presigner.builder()
            .credentialsProvider(awsCredentialsProvider)
            .region(Region.AP_NORTHEAST_2)
            .build().use { presigner ->
                PutObjectPresignRequest.builder()
                    .signatureDuration(Duration.ofMinutes(DURATION_OF_PRESIGNED_URL_MINUTE))
                    .putObjectRequest(
                        PutObjectRequest.builder()
                            .bucket(s3Properties.s3.bucket)
                            .key(objectName)
                            .build()
                    )
                    .build().run {
                        return presigner.presignPutObject(this).url().toExternalForm()
                    }
            }
    }

    fun generatePreSignedUrlToDownload(objectName: String): String {
        S3Presigner.builder()
            .credentialsProvider(awsCredentialsProvider)
            .region(Region.AP_NORTHEAST_2)
            .build().use { presigner ->
                GetObjectPresignRequest.builder()
                    .signatureDuration(Duration.ofHours(DURATION_OF_PRESIGNED_URL_MINUTE))
                    .getObjectRequest(
                        GetObjectRequest.builder()
                            .bucket(s3Properties.s3.bucket)
                            .key(objectName)
                            .build()
                    )
                    .build().run {
                        return presigner.presignGetObject(this).url().toExternalForm()
                    }
            }
    }

    private fun createUUID() = UUID.randomUUID().toString()
}
