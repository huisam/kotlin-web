package com.huisam.kotlinweb.domain.student

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.repository.findByIdOrNull
import javax.persistence.EntityManager

@DataJpaTest
internal class TeacherTest {

    @Autowired
    private lateinit var teacherRepository: TeacherRepository

    @Autowired
    private lateinit var entityManager: EntityManager

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
