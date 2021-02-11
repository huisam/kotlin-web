package com.huisam.kotlinweb.domain.posts

import com.huisam.kotlinweb.domain.comment.Comment
import javax.persistence.*

@Entity
class Posts(
    @Column(length = 500, nullable = false)
    var title: String,

    @Column(columnDefinition = "TEXT", nullable = false)
    var content: String,

    @Column
    @OneToMany(fetch = FetchType.LAZY)
    val comments: MutableList<Comment> = mutableListOf(),

    var author: String? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    ) {

    @Column
    var text: String? = null
        get() = if (field != null && field!!.length == 1 ) {
            "length 1"
        } else
            field ?: "not found"

    fun addComments(comment: Comment) {
        comments.add(comment)
        comment.posts = this

    }

    fun toDomain(): PostsDomain {
        return PostsDomain(id = this.id!!, title = this.title, content = this.content, author = this.author)
    }
}