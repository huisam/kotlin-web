package com.huisam.kotlinweb.domain.comment

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import javax.persistence.EntityManager

@DataJpaTest(showSql = true)
internal class CommentTest @Autowired constructor(
    val commentRepository: CommentRepository,
    val entityManager: EntityManager,
) {

    @Test
    @Transactional(readOnly = true)
    internal fun `post가 없어도 comment는 저장된다`() {
        // given
        val comment = Comment(name = "huisam", content = "안녕하세요", createdAt = LocalDateTime.now())

        // when
        commentRepository.save(comment)
        entityManager.flush()
        entityManager.clear()
        val result = commentRepository.findById(comment.id!!)
        result.get().id = 2L

        // then
        then(result)
            .isNotEmpty

    }

}