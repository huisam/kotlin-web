package com.huisam.kotlinweb.persistence.comment

import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, Long>
