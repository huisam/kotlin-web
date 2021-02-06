package com.huisam.kotlinweb.fegin

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class FeignController(
    val commentFeignClient: CommentFeignClient,
    val postFeignClient: PostFeignClient,
) {

    @GetMapping("/feign/comment")
    fun getCommentFromFeign(
        @RequestParam(required = false, name = "key", defaultValue = "") key: String,
    ): String = commentFeignClient.comment()

    @GetMapping("/feign/post")
    fun getPostFromFeign(
        @RequestParam(required = false, name = "key", defaultValue = "") key: String,
    ): String = postFeignClient.comment()
}