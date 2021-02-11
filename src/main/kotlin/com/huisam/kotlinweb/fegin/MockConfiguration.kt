package com.huisam.kotlinweb.fegin

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock
import com.huisam.kotlinweb.domain.author.Author
import com.huisam.kotlinweb.domain.comment.Comment
import com.huisam.kotlinweb.domain.posts.Posts
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import java.time.LocalDateTime

@Configuration
class MockConfiguration(
    private val objectMapper: ObjectMapper,
) {

    @Bean(initMethod = "start", destroyMethod = "stop")
    fun mockCommentService(): WireMockServer {
        return WireMockServer(1234)
            .apply {
                stubFor(WireMock.get(WireMock.urlEqualTo("/feign/comment"))
                    .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBody(
                            objectMapper.writeValueAsString(Comment(id = 1L,
                                name = "hi",
                                content = "안녕",
                                createdAt = LocalDateTime.now()))
                        )
                    )
                )
            }
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    fun mockPostsService(): WireMockServer {
        return WireMockServer(1235)
            .apply {
                stubFor(WireMock.get(WireMock.urlEqualTo("/feign/post"))
                    .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBody(
                            objectMapper.writeValueAsString(Posts(id = 1L, title = "book", content = "책",
                                author = Author(name = "huisam"), comments = mutableListOf(Comment(name = "hi", content = "content", createdAt = LocalDateTime.now()))
                            ))
                        )
                    )
                )
            }
    }


}