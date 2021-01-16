package com.huisam.kotlinweb.posts.domain

import java.math.BigDecimal
import javax.persistence.*

@Entity
class Posts(
    @Column(length = 500, nullable = false)
    var title: String,

    @Column(columnDefinition = "TEXT", nullable = false)
    var content: String,

    var author: String? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
)