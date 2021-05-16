package com.huisam.kotlinweb.fegin.config

import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJson
import org.springframework.cloud.commons.httpclient.HttpClientConfiguration
import org.springframework.cloud.openfeign.FeignAutoConfiguration
import org.springframework.context.annotation.Import

@Import(HttpClientConfiguration::class)
@ImportAutoConfiguration(
    value = [FeignAutoConfiguration::class]
)
@AutoConfigureJson
annotation class AutoConfigureTestFeign