package com.huisam.kotlinweb.dto

import com.huisam.kotlinweb.domain.author.Author
import com.huisam.kotlinweb.domain.posts.Posts

data class PostsSaveRequestsDto(
    val title: String,
    val content: String,
    val author: String? = null,
    val authorPhone: String? = null,
) {
    fun toEntity(): Posts = Posts(title = title, content = content,
        author = author?.let { Author(name = it, phone = authorPhone) }
    )
}
