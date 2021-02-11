package com.huisam.kotlinweb.service

import com.huisam.kotlinweb.domain.comment.Comment
import com.huisam.kotlinweb.domain.comment.CommentRepository
import org.springframework.stereotype.Service

@Service
class CommentService(
    val commentRepository: CommentRepository,
) {
    fun findById(id: Long): Comment {
        return commentRepository.findById(id).orElseThrow {
            throw IllegalArgumentException("Not found id : $id")
        }
    }
}