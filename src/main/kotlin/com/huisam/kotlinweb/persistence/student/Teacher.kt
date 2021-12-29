package com.huisam.kotlinweb.persistence.student

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*
import javax.persistence.*

interface TeacherRepository : JpaRepository<Teacher, UUID>

@Entity
@Table(name = "teacher")
class Teacher(
    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID? = null,

    val name: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Teacher) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}