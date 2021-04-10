package com.huisam.kotlinweb.objectmapper

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper

inline fun <reified T> ObjectMapper.readValue(body: String): T = readValue(body, object : TypeReference<T>() {})