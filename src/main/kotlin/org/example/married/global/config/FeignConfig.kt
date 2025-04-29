package org.example.married.global.config

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration

@EnableFeignClients(basePackages = ["org.example.married.global.feign"])
@Configuration
class FeignConfig {
}