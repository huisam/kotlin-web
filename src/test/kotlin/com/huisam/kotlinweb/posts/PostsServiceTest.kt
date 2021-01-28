package com.huisam.kotlinweb.posts

import com.huisam.kotlinweb.posts.domain.PostsDomain
import com.huisam.kotlinweb.posts.dto.PostsSaveRequestsDto
import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
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
}