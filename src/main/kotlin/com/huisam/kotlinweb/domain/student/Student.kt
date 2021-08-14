package com.huisam.kotlinweb.domain.student

import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.*

interface StudentRepository : JpaRepository<Student, Long>
interface PersonRepository : JpaRepository<Person, Long>

/**
 * 시퀀스 제너레이터 기반의 학생
 */
@Entity
@Table(name = "student")
class Student(
    @Id
    @SequenceGenerator(
        name = "student_seq_gen",
        sequenceName = "student_seq",
        initialValue = 1,
        allocationSize = 2
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq_gen")
    val id: Long? = null,

    @Column
    val name: String

) {
    @Column
    var address: String? = null
        get() = "address: $field"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Student) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}

/**
 * Maps Id를 기반으로 동일한 Id를 사용
 */
@Entity
@Table(name = "person")
class Person(
    @Id
    val id: Long? = null,

    @OneToOne
    @MapsId
    val student: Student
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Person) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}
