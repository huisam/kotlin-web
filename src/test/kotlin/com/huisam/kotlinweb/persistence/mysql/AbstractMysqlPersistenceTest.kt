package com.huisam.kotlinweb.persistence.mysql

import org.springframework.boot.context.TypeExcludeFilter
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.FilterType
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@ComponentScan(
    basePackageClasses = [MysqlPersistencePackage::class],
    excludeFilters = [ComponentScan.Filter(type = FilterType.CUSTOM, classes = [TypeExcludeFilter::class])]
)
@TestConfiguration
class MysqlPersistenceTestContextConfiguration


@ContextConfiguration(classes = [MysqlPersistenceTestContextConfiguration::class])
@AutoConfigureMysqlPersistence
@Transactional
@SpringBootTest
abstract class AbstractMysqlPersistenceTest {

    @PersistenceContext
    protected lateinit var entityManager: EntityManager
    fun EntityManager.flushAndClear() {
        flush()
        clear()
    }
}
