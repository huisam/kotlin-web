package com.huisam.kotlinweb.posts.domain

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest(showSql = true)
internal class PostsTest @Autowired constructor(
    val postsRepository: PostsRepository,
    val entityManager: TestEntityManager
) {

    @Test
    internal fun `게시글을 제대로 만들고 저장한다`() {
        // given
        val posts = Posts("title", "content")
        entityManager.persist(posts)
        entityManager.flush()

        // when
        val result = postsRepository.findById(1L)

        // then
        then(result).hasValue(posts)
    }

    @AfterEach
    internal fun tearDown() {
        postsRepository.deleteAll()
    }
}