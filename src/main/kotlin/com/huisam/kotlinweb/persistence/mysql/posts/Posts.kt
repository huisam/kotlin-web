package com.huisam.kotlinweb.persistence.mysql.posts

import com.huisam.kotlinweb.domain.PostsDomain
import com.huisam.kotlinweb.persistence.mysql.author.Author
import com.huisam.kotlinweb.persistence.mysql.comment.Comment
import jakarta.persistence.*

@Entity
@Table(name = "posts")
class Posts(
    @Column(length = 500, nullable = false)
    var title: String,

    @Column(columnDefinition = "TEXT", nullable = false)
    var content: String,

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    val comments: MutableList<Comment> = mutableListOf(),

    @Embedded
    var author: Author? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "posts_id")
    var id: Long? = null,

    ) {

    @Column
    var text: String? = null
        get() = if (field != null && field!!.length == 1) {
            "length 1"
        } else
            field ?: "not found"

    fun addComments(comment: Comment) {
        comments.add(comment)
        comment.posts = this
    }

    fun toDomain(): PostsDomain {
        return PostsDomain(id = this.id!!, title = this.title, content = this.content, author = this.author?.toDomain())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Posts) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}