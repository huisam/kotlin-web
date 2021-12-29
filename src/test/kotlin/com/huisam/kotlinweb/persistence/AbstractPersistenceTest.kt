package com.huisam.kotlinweb.persistence

import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@ImportAutoConfiguration(
    JpaRepositoriesAutoConfiguration::class,
    DataSourceAutoConfiguration::class,
    DataSourceTransactionManagerAutoConfiguration::class,
    JdbcTemplateAutoConfiguration::class,
    HibernateJpaAutoConfiguration::class,
    TransactionAutoConfiguration::class,
)
@Transactional
@ComponentScan(basePackageClasses = [PersistencePackage::class])
abstract class AbstractPersistenceTest {

    @PersistenceContext
    protected lateinit var entityManager: EntityManager

    fun EntityManager.flushAndClear() {
        flush()
        clear()
    }
}