package com.mktbsh.ktdemo.app.config

import com.mktbsh.ktdemo.app.handler.SampleHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

@Configuration
class Router(private val sampleHandler: SampleHandler) {

    @Bean
    fun apis() = router {
        (accept(MediaType.APPLICATION_JSON)).nest {
            GET("/sample", sampleHandler::getJson)
        }
    }
}