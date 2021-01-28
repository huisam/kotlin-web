package com.huisam.kotlinweb.posts.domain

import javax.persistence.*

@Entity
class Posts(
    @Column(length = 500, nullable = false)
    var title: String,

    @Column(columnDefinition = "TEXT", nullable = false)
    var content: String,

    var author: String? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

) {
    fun toDomain(): PostsDomain {
        return PostsDomain(id = this.id!!, title = this.title, content = this.content, author = this.author)
    }
}