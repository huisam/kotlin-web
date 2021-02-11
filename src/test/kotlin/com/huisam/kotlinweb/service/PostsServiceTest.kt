package com.huisam.kotlinweb.service

import com.huisam.kotlinweb.domain.posts.PostsDomain
import com.huisam.kotlinweb.dto.PostsSaveRequestsDto
import com.huisam.kotlinweb.exception.EntityNotFoundException
import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.concurrent.ThreadLocalRandom
import javax.transaction.Transactional

@Transactional
@SpringBootTest
internal class PostsServiceTest (
    @Autowired
    val postsService: PostsService,
) {
    @Test
    internal fun `게시글을 제대로 저장하고 꺼내온다`() {
        // given
        val postsId = postsService.save(PostsSaveRequestsDto(title = "제목", content = "내용", author = "나"))

        // when
        val result = postsService.findById(postsId)

        then(result).isEqualTo(PostsDomain(id = postsId, title = "제목", content = "내용", author = "나"))
    }

    @Test
    internal fun `없는 아이디면 예외를 던진다`() {
        // given
        val randomPostsId = ThreadLocalRandom.current().nextLong(100)

        // when & then
        assertThrows<EntityNotFoundException> {
            postsService.findById(randomPostsId)
        }
    }
}