package com.huisam.kotlinweb.comment.service

import com.huisam.kotlinweb.comment.domain.Comment
import com.huisam.kotlinweb.comment.domain.CommentRepository
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