package com.huisam.kotlinweb.domain.comment

import com.huisam.kotlinweb.domain.AbstractPersistenceTest
import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

internal class CommentTest : AbstractPersistenceTest() {
    @Autowired
    private lateinit var commentRepository: CommentRepository

    @Test
    @Transactional(readOnly = true)
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