package com.huisam.kotlinweb.fegin

import com.fasterxml.jackson.databind.ObjectMapper
import com.huisam.kotlinweb.fegin.config.AutoConfigureTestFeign
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.context.TypeExcludeFilter
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.FilterType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension

@TestConfiguration
@ComponentScan(
    basePackageClasses = [FeignPackage::class],
    excludeFilters = [
        ComponentScan.Filter(type = FilterType.CUSTOM, classes = [TypeExcludeFilter::class])
    ]
)
@EnableAutoConfiguration
class FeignTestContextConfiguration

@TestPropertySource(properties = ["external.api.placeHolder=https://jsonplaceholder.typicode.com"])
//@TestPropertySource(locations = ["classpath:application-feign.yml"])
@AutoConfigureTestFeign
@ContextConfiguration(classes = [FeignTestContextConfiguration::class])
@ExtendWith(SpringExtension::class)
abstract class AbstractFeignContractTest {
    @Autowired
    protected lateinit var objectMapper: ObjectMapper
}
