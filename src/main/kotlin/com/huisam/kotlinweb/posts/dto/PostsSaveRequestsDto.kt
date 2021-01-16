package com.huisam.kotlinweb.posts.dto

import com.huisam.kotlinweb.posts.domain.Posts

data class PostsSaveRequestsDto(
    var title: String,
    var content: String,
    var author: String,
) {
    fun toEntity(): Posts = Posts(title = title, content = content, author = author)
}
