package com.huisam.kotlinweb.exception

class EntityNotFoundException(id: Long) : RuntimeException("Not Found Entity $id")