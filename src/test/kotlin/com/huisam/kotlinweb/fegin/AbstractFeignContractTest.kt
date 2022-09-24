package com.huisam.kotlinweb.fegin

import com.fasterxml.jackson.databind.ObjectMapper
import com.huisam.kotlinweb.fegin.config.AutoConfigureTestFeign
import com.huisam.kotlinweb.fegin.config.FeignClientConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.ComponentScan

@ComponentScan(basePackageClasses = [FeignPackage::class])
@AutoConfigureTestFeign
@SpringBootTest(classes = [FeignClientConfiguration::class])
abstract class AbstractFeignContractTest {
    @Autowired
    protected lateinit var objectMapper: ObjectMapper
}