package com.huisam.kotlinweb.persistence.elasticsearch.member

import jakarta.persistence.*
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

@Document(indexName = "member")
@Entity
class MemberSearchTable(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,

    @Column(nullable = false)
    val name: String,

    ) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MemberSearchTable) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}

interface MemberSearchTableRepository : ElasticsearchRepository<MemberSearchTable, Long>
