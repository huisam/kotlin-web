package com.huisam.kotlinweb.fegin.client

import com.fasterxml.jackson.databind.ObjectMapper
import com.huisam.kotlinweb.fegin.config.AutoConfigureTestFeign
import com.huisam.kotlinweb.fegin.config.FeignClientConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@AutoConfigureTestFeign
@SpringBootTest(classes = [FeignClientConfiguration::class])
abstract class FeignContractTest {
    @Autowired
    protected lateinit var objectMapper: ObjectMapper
}