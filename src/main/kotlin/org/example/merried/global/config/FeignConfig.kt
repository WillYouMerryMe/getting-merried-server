package org.example.merried.global.config

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration

@EnableFeignClients(basePackages = ["org.example.merried.global.feign"])
@Configuration
class FeignConfig {
}