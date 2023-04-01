package com.huisam.kotlinweb.fegin

import com.fasterxml.jackson.databind.ObjectMapper
import com.huisam.kotlinweb.fegin.config.AutoConfigureTestFeign
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension

@ActiveProfiles("wiremock")
@TestPropertySource(properties = ["external.api.placeHolder=http://localhost:\${wiremock.server.port}"])
@AutoConfigureWireMock(port = 0)
@AutoConfigureTestFeign
@ContextConfiguration(classes = [FeignTestContextConfiguration::class])
@ExtendWith(SpringExtension::class)
abstract class AbstractFeignWireMockTest {
    @Autowired
    protected lateinit var objectMapper: ObjectMapper
}