package com.huisam.kotlinweb.persistence.elasticsearch.member

import com.huisam.kotlinweb.persistence.elasticsearch.AbstractElasticSearchPersistenceTest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull

internal class MemberSearchTableIntegrationTest : AbstractElasticSearchPersistenceTest() {

    @Autowired
    private lateinit var memberSearchTableRepository: MemberSearchTableRepository

    @Test
    fun `저장하고 조회한다`() {
        // given
        val memberSearchTable = MemberSearchTable(id = 1L, name = "tester")
        memberSearchTableRepository.save(memberSearchTable)

        // when
        val result = memberSearchTableRepository.findByIdOrNull(memberSearchTable.id)

        // then
        assertThat(result).usingRecursiveComparison()
            .isEqualTo(memberSearchTable)
    }
}