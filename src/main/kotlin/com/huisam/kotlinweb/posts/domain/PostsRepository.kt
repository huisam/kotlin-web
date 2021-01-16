package com.huisam.kotlinweb.posts.domain

import org.springframework.data.jpa.repository.JpaRepository

interface PostsRepository : JpaRepository<Posts, Long>
