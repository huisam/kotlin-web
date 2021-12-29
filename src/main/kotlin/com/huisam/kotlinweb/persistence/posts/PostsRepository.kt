package com.huisam.kotlinweb.persistence.posts

import org.springframework.data.jpa.repository.JpaRepository

interface PostsRepository : JpaRepository<Posts, Long>
