package com.huisam.kotlinweb.fegin.config

import com.huisam.kotlinweb.fegin.BaseFeignPackage
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.retry.annotation.EnableRetry

@EnableRetry(proxyTargetClass = true)
@Configuration
@EnableFeignClients(basePackageClasses = [BaseFeignPackage::class])
@ComponentScan(basePackageClasses = [BaseFeignPackage::class])
class FeignClientConfiguration
