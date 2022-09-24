package com.huisam.kotlinweb.persistence

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@ComponentScan(basePackageClasses = [PersistencePackage::class])
@TestConfiguration
class PersistenceTestContextConfiguration


@ContextConfiguration(classes = [PersistenceTestContextConfiguration::class])
@AutoConfigurePersistence
@Transactional
@SpringBootTest
abstract class AbstractPersistenceTest {

    @PersistenceContext
    protected lateinit var entityManager: EntityManager
    fun EntityManager.flushAndClear() {
        flush()
        clear()
    }
}
