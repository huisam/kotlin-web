package com.huisam.kotlinweb.fegin

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(value = "simple-comment", url = "\${comment.service.url}")
interface CommentFeignClient {

    @GetMapping("/feign/comment")
    fun comment(): String
}
