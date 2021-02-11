package com.huisam.kotlinweb.domain

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import javax.persistence.EntityManager

@DataJpaTest(showSql = true)
class PersistenceTest {
    @Autowired
    lateinit var entityManager: EntityManager

    fun EntityManager.flushAndClear() {
        flush()
        clear()
    }
}