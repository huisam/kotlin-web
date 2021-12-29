package com.huisam.kotlinweb.domain

class PostsDomain(
    val id: Long,
    val title: String,
    val content: String,
    val author: AuthorDomain? = null,

    ) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PostsDomain) return false

        if (id != other.id) return false
        if (title != other.title) return false
        if (content != other.content) return false
        if (author != other.author) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + content.hashCode()
        result = 31 * result + (author?.hashCode() ?: 0)
        return result
    }
}