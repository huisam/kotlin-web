package com.huisam.kotlinweb.persistence.student

import com.huisam.kotlinweb.persistence.AbstractPersistenceTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull

internal class StudentRepositoryIntegrationTest : AbstractPersistenceTest() {

    @Autowired
    private lateinit var studentRepository: StudentRepository

    @Autowired
    private lateinit var personRepository: PersonRepository

    @Test
    fun `student를 sequence로 생성한다`() {
        // given
        val student1 = Student(name = "huisam").apply { address = "home" }
        val student2 = Student(name = "hong")
        val student3 = Student(name = "jin")
        val student4 = Student(name = "test")

        // when
        studentRepository.save(student1)
        studentRepository.save(student2)
        studentRepository.save(student3)
        studentRepository.save(student4)
        entityManager.flush()
        entityManager.clear()

        // then
        val result = studentRepository.findByIdOrNull(student1.id!!)
        assertThat(result).isEqualTo(student1)
    }

    @Test
    fun `person은 student와 동일한 id를 가진다`() {
        // given
        val student1 = Student(name = "huisam").apply { address = "home" }
        val person = Person(student = student1)

        // when
        studentRepository.save(student1)
        personRepository.save(person)
        entityManager.flush()
        entityManager.clear()

        // then
        val result = personRepository.findByIdOrNull(person.id)
        assertThat(result!!.id).isEqualTo(student1.id)
    }
}