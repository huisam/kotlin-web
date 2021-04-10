package com.huisam.kotlinweb.fegin.controller

import com.huisam.kotlinweb.fegin.client.RemotePlaceHolderClient
import com.huisam.kotlinweb.fegin.client.rest.RestPlaceHolderPost
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FeignController(
    private val remotePlaceHolderClient: RemotePlaceHolderClient
) {

    @GetMapping("/placeHolder/posts")
    fun posts(): ResponseEntity<List<RestPlaceHolderPost>> {
        return ResponseEntity.ok(
            remotePlaceHolderClient.posts()
        )
    }

    @GetMapping("/placeHolder/post/{id}")
    fun post(
        @PathVariable("id") id: Long
    ): ResponseEntity<RestPlaceHolderPost> {
        return ResponseEntity.ok(
            remotePlaceHolderClient.post(id)
        )
    }
}