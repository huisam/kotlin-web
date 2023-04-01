package com.huisam.kotlinweb.fegin.config

import com.huisam.kotlinweb.fegin.FeignPackage
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration
import org.springframework.retry.annotation.EnableRetry

@EnableRetry(proxyTargetClass = true)
@Configuration
@EnableFeignClients(basePackageClasses = [FeignPackage::class])
class FeignClientConfiguration
