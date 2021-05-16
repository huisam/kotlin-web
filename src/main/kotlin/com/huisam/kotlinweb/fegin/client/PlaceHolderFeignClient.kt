package com.huisam.kotlinweb.fegin.client

import com.fasterxml.jackson.databind.ObjectMapper
import com.huisam.kotlinweb.fegin.client.rest.RestPlaceHolderPost
import com.huisam.kotlinweb.objectmapper.readValue
import feign.FeignException
import feign.Response
import org.apache.commons.io.IOUtils
import org.hibernate.annotations.common.util.impl.LoggerFactory.logger
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.HttpStatus
import org.springframework.retry.annotation.Backoff
import org.springframework.retry.annotation.Retryable
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Component
class RemotePlaceHolderClient(
    private val placeHolderFeignClient: PlaceHolderFeignClient,
    private val objectMapper: ObjectMapper,
) {
    private val log = logger(RemotePlaceHolderClient::class.java)

    @Retryable(backoff = Backoff(delay = 150L), maxAttempts = 3)
    fun posts(): List<RestPlaceHolderPost> {
        val response = try {
            placeHolderFeignClient.posts().throwIfError()
        } catch (feignException: FeignException) {
            // custom your exception
            throw IllegalStateException(feignException)
        }
        val responseBody = IOUtils.toString(response.body().asInputStream())
        log.info("request : ${response.request()}, response : $responseBody")

        return objectMapper.readValue(responseBody)
    }

    fun post(id: Long): RestPlaceHolderPost {
        val response = try {
            placeHolderFeignClient.post(id).throwIfError()
        } catch (feignException: FeignException) {
            // custom your exception
            throw IllegalStateException(feignException)
        }
        log.info("request : ${response.request()}, response : ${response.body()}")

        return objectMapper.readValue(response.body().toString())
    }

    private fun Response.throwIfError(): Response {
        if (HttpStatus.OK !== HttpStatus.valueOf(status())) {
            throw IllegalStateException("remote http status code : ${status()}")
        }
        return this
    }
}

@FeignClient(value = "placeholder", url = "\${external.api.placeHolder}")
interface PlaceHolderFeignClient {

    @GetMapping("/posts")
    fun posts(): Response

    @GetMapping("/posts/{id}")
    fun post(@PathVariable("id") id: Long): Response
}
