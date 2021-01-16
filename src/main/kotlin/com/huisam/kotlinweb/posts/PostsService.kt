package com.huisam.kotlinweb.posts

import com.huisam.kotlinweb.posts.domain.PostsRepository
import com.huisam.kotlinweb.posts.dto.PostsSaveRequestsDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class PostsService @Autowired constructor(
    val postsRepository: PostsRepository
) {

    @Transactional
    fun save(dto: PostsSaveRequestsDto): Long {
        return postsRepository.save(dto.toEntity())
            .id ?: 0
    }
}