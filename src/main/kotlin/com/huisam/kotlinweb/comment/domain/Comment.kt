package com.huisam.kotlinweb.comment.domain

import com.huisam.kotlinweb.posts.domain.Posts
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posts_id")
    var posts: Posts? = null,

    @Column
    val name: String,


    @Column
    val content: String,

    @Column
    val createdAt: LocalDateTime,

    ) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Comment) return false

        if (id != other.id) return false
        if (posts != other.posts) return false
        if (name != other.name) return false
        if (content != other.content) return false
        if (createdAt != other.createdAt) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (posts?.hashCode() ?: 0)
        result = 31 * result + name.hashCode()
        result = 31 * result + content.hashCode()
        result = 31 * result + createdAt.hashCode()
        return result
    }

    override fun toString(): String {
        return "Comment(id=$id, posts=$posts, name='$name', content='$content', createdAt=$createdAt)"
    }

}