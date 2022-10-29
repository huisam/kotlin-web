package com.huisam.kotlinweb.persistence.mysql.comment

import com.huisam.kotlinweb.persistence.mysql.AbstractMysqlPersistenceTest
import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import java.time.LocalDateTime

internal class CommentRepositoryIntegrationTest : AbstractMysqlPersistenceTest() {
    @Autowired
    private lateinit var commentRepository: CommentRepository

    @Test
    fun `post가 없어도 comment는 저장된다`() {
        // given
        val comment = Comment(name = "huisam", content = "안녕하세요", createdAt = LocalDateTime.now())

        // when
        commentRepository.save(comment)
        entityManager.flush()
        entityManager.clear()
        val result = commentRepository.findById(comment.id!!)
        result.get().id = 2L

        // then
        then(result).isNotEmpty
    }

}