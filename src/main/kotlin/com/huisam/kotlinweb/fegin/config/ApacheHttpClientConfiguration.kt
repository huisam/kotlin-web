package com.huisam.kotlinweb.fegin.config

import feign.Feign
import org.springframework.boot.autoconfigure.AutoConfigureBefore
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.cloud.openfeign.FeignAutoConfiguration
import org.springframework.context.annotation.Configuration

@Configuration
@ConditionalOnClass(Feign::class)
@AutoConfigureBefore(FeignAutoConfiguration::class)
class ApacheHttpClientConfiguration