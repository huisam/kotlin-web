package com.huisam.kotlinweb.fegin.config

import com.huisam.kotlinweb.fegin.client.BaseFeignClientPackage
import feign.Retryer
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.retry.annotation.EnableRetry

@Configuration
@EnableRetry
@EnableFeignClients(basePackageClasses = [BaseFeignClientPackage::class])
@ComponentScan(basePackageClasses = [BaseFeignClientPackage::class])
class FeignClientConfiguration {
    @Bean
    fun retryer() = Retryer.Default(1000, 2000, 3)
}
