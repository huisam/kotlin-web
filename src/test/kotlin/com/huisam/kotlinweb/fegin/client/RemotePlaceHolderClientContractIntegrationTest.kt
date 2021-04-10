package com.huisam.kotlinweb.fegin.client

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

internal class RemotePlaceHolderClientContractIntegrationTest : FeignContractTest() {

    @Autowired
    private lateinit var client: RemotePlaceHolderClient

    @Test
    fun `제대로 post 들을 가져온다`() {
        // given & when
        val result = client.posts()
        // then
        assertThat(result).isNotEmpty
        assertThat(result)
    }

    @Test
    fun `제대로 post 1번을 가져온다`() {
        // given
        val postId = 1L
        // when
        val result = client.post(postId)
        // then
        assertThat(result.id).isEqualTo(1L)
    }
}