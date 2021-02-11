package com.huisam.kotlinweb.dto

import com.huisam.kotlinweb.domain.posts.Posts

data class PostsSaveRequestsDto(
    var title: String,
    var content: String,
    var author: String,
) {
    fun toEntity(): Posts = Posts(title = title, content = content, author = author)
}
