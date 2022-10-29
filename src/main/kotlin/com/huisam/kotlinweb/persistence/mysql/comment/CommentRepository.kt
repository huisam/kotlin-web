package com.huisam.kotlinweb.persistence.mysql.comment

import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, Long>
