package org.example.married.global.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("spring.cloud.aws")
data class S3Properties(
    val s3: S3,
    val credentials: Credentials,
) {
    data class S3(
        val bucket: String,
    )

    data class Credentials(
        val accessKey: String,
        val secretKey: String,
    )
}
