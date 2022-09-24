package com.huisam.kotlinweb.fegin

import com.fasterxml.jackson.databind.ObjectMapper
import com.huisam.kotlinweb.fegin.config.AutoConfigureTestFeign
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.TypeExcludeFilter
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.FilterType
import org.springframework.test.context.ContextConfiguration

@TestConfiguration
@ComponentScan(
    basePackageClasses = [FeignPackage::class],
    excludeFilters = [ComponentScan.Filter(type = FilterType.CUSTOM, classes = [TypeExcludeFilter::class])]
)
class FeignTestContextConfiguration

@ContextConfiguration(classes = [FeignTestContextConfiguration::class])
@AutoConfigureTestFeign
@SpringBootTest
abstract class AbstractFeignContractTest {
    @Autowired
    protected lateinit var objectMapper: ObjectMapper
}
