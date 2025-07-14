package org.example.married.global.web

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedMethods(
                HttpMethod.GET.name(),
                HttpMethod.POST.name(),
                HttpMethod.PUT.name(),
                HttpMethod.PATCH.name(),
                HttpMethod.DELETE.name(),
                HttpMethod.HEAD.name(),
                HttpMethod.OPTIONS.name(),
            )
            .allowedOrigins(
                "http://localhost:3000",
                "https://married.blink-deploy.site",
                "https://gettingmarried.vercel.app",
            )
            .allowedHeaders("*")
            .allowCredentials(true)
    }
}
