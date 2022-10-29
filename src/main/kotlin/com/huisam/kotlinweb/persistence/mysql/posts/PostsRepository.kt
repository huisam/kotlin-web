package com.huisam.kotlinweb.persistence.mysql.posts

import org.springframework.data.jpa.repository.JpaRepository

interface PostsRepository : JpaRepository<Posts, Long>
