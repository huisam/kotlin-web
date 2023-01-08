package com.huisam.kotlinweb.persistence.mysql

import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.context.TypeExcludeFilter
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.FilterType
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.transaction.annotation.Transactional


@EnableJpaRepositories(
    basePackageClasses = [MysqlPersistencePackage::class],
    excludeFilters = [ComponentScan.Filter(type = FilterType.CUSTOM, classes = [TypeExcludeFilter::class])]
)
@TestConfiguration
class MysqlPersistenceTestContextConfiguration


@ContextConfiguration(classes = [MysqlPersistenceTestContextConfiguration::class])
@AutoConfigureMysqlPersistence
@Transactional
@EnableAutoConfiguration
@ExtendWith(SpringExtension::class)
abstract class AbstractMysqlPersistenceTest {

    @PersistenceContext
    protected lateinit var entityManager: EntityManager
    fun EntityManager.flushAndClear() {
        flush()
        clear()
    }
}
