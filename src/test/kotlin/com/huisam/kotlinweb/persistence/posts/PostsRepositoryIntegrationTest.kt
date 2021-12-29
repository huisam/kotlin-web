package com.huisam.kotlinweb.persistence.posts

import com.huisam.kotlinweb.persistence.AbstractPersistenceTest
import com.huisam.kotlinweb.persistence.author.Author
import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class PostsRepositoryIntegrationTest : AbstractPersistenceTest() {

    @Autowired
    private lateinit var postsRepository: PostsRepository

    @Test
    fun `게시글을 제대로 만들고 저장한다`() {
        // given
        val posts = Posts(
            title = "title", content = "content",
            author = Author(name = "huisam", phone = "010-2222-3333")
        ).apply { text = "1" }

        // when
        postsRepository.save(posts)
        entityManager.flushAndClear()
        val result = postsRepository.findById(1L)

        // then
        then(result.get().text).isEqualTo("length 1")
        then(result).hasValue(posts)

    }

    @AfterEach
    internal fun tearDown() {
        postsRepository.deleteAll()
    }
}