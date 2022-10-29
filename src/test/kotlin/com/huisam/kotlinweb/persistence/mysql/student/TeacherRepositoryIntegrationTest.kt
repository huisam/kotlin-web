package com.huisam.kotlinweb.persistence.mysql.student

import com.huisam.kotlinweb.persistence.mysql.AbstractMysqlPersistenceTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull

internal class TeacherRepositoryIntegrationTest : AbstractMysqlPersistenceTest() {

    @Autowired
    private lateinit var teacherRepository: TeacherRepository

    @Test
    fun `teacher를 uuid기반으로 저장한다`() {
        // given
        val teacher = Teacher(name = "teach")

        // when
        teacherRepository.save(teacher)
        entityManager.flush()
        entityManager.clear()

        // then
        val result = teacherRepository.findByIdOrNull(teacher.id)
        assertThat(result).isEqualTo(teacher)
    }
}
