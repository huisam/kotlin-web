package com.huisam.kotlinweb.persistence.mysql.author

import com.huisam.kotlinweb.domain.AuthorDomain
import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
class Author(
    @Column
    val name: String,
    @Column
    val phone: String? = null,

) {
    fun toDomain(): AuthorDomain = AuthorDomain(name = this.name, phone = this.phone)
}