package com.huisam.kotlinweb.posts.exception

class EntityNotFoundException(id: Long) : RuntimeException("Not Found Entity $id")