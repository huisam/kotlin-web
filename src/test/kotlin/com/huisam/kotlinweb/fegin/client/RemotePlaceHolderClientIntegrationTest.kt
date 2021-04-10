package com.huisam.kotlinweb.fegin.client

import com.github.tomakehurst.wiremock.client.WireMock.*
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

internal class RemotePlaceHolderClientIntegrationTest : FeignWireMockTest() {

    @Autowired
    private lateinit var client: RemotePlaceHolderClient

    @Test
    fun `503이면 IllegalStateException을 던진다`() {
        // given
        stubFor(
            get(anyUrl())
                .willReturn(serviceUnavailable())
        )
        // when
        val exception = catchThrowable { client.posts() }
        // then
        verify(
            getRequestedFor(urlEqualTo("/posts"))
        )
        assertThat(exception).isInstanceOf(IllegalStateException::class.java)
    }
}