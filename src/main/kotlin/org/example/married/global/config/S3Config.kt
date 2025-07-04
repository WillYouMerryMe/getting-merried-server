package org.example.married.global.config

import org.example.married.global.config.properties.S3Properties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.AwsCredentials
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider

@Configuration
class S3Config(
    private val s3Properties: S3Properties,
) {

    @Bean
    @Primary
    fun awsCredentials(): AwsCredentials {
        return AwsBasicCredentials.create(s3Properties.credentials.accessKey, s3Properties.credentials.secretKey)
    }

    @Bean
    fun credentialsProvider(): AwsCredentialsProvider {
        return AwsCredentialsProvider { awsCredentials() }
    }
}