package com.huisam.kotlinweb.domain

data class PostsDomain(
    val id: Long,
    val title: String,
    val content: String,
    val author: AuthorDomain?,
)