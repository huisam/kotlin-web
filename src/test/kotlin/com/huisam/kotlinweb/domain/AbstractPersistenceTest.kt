package com.huisam.kotlinweb.domain

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@Transactional
@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
abstract class AbstractPersistenceTest {
    @Autowired
    protected lateinit var entityManager: EntityManager

    fun EntityManager.flushAndClear() {
        flush()
        clear()
    }
}