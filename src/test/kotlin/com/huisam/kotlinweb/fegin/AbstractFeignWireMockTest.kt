package com.huisam.kotlinweb.fegin

import com.fasterxml.jackson.databind.ObjectMapper
import com.huisam.kotlinweb.fegin.config.AutoConfigureTestFeign
import com.huisam.kotlinweb.fegin.config.FeignClientConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.context.ActiveProfiles

@ComponentScan(basePackageClasses = [FeignPackage::class])
@ActiveProfiles("wiremock")
@AutoConfigureWireMock(port = 0)
@AutoConfigureTestFeign
@SpringBootTest(
    classes = [FeignClientConfiguration::class]
)
abstract class AbstractFeignWireMockTest {
    @Autowired
    protected lateinit var objectMapper: ObjectMapper
}