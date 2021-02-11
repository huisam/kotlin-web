package com.huisam.kotlinweb.service

import com.huisam.kotlinweb.domain.posts.PostsDomain
import com.huisam.kotlinweb.domain.posts.PostsRepository
import com.huisam.kotlinweb.dto.PostsSaveRequestsDto
import com.huisam.kotlinweb.exception.EntityNotFoundException
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class PostsService (
    val postsRepository: PostsRepository
) {

    @Transactional
    fun save(dto: PostsSaveRequestsDto): Long {
        return postsRepository.save(dto.toEntity())
            .id ?: 0
    }

    @Transactional
    fun findById(id: Long): PostsDomain {
        return postsRepository.findById(id)
            .map { it -> it.toDomain() }
            .orElseThrow { EntityNotFoundException(id) }
    }
}