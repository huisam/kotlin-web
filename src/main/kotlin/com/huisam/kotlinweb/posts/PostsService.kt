package com.huisam.kotlinweb.posts

import com.huisam.kotlinweb.posts.domain.PostsDomain
import com.huisam.kotlinweb.posts.domain.PostsRepository
import com.huisam.kotlinweb.posts.dto.PostsSaveRequestsDto
import com.huisam.kotlinweb.posts.exception.EntityNotFoundException
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