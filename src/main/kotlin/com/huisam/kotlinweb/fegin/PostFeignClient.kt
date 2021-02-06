package com.huisam.kotlinweb.fegin

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(value = "simple-post", url = "\${post.service.url}")
interface PostFeignClient {

    @GetMapping("/feign/post")
    fun comment(): String
}
