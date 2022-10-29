package com.huisam.kotlinweb.persistence.mysql.index

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(
    name = "cafe_table",
    indexes = [
        Index(name = "cafe_table_type_index", columnList = "type", unique = false)
    ]
)
@EntityListeners(AuditingEntityListener::class)
class CafeTable(
    @Id
    @GeneratedValue
    private val id: Long? = null,

    @Column(name = "name")
    private val name: String,

    @Column(name = "type", length = 20)
    @Enumerated(EnumType.STRING)
    private val type: CafeType,
) {
    @CreatedDate
    @Column(name = "created_at", nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    @Column(name = "modified_at")
    var modifiedAt: LocalDateTime? = null


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CafeTable) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}

enum class CafeType {
    COFFEE, BLENDED, JUICE, ICE_CREAM
}