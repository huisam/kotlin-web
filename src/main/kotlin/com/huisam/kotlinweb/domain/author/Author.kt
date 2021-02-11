package com.huisam.kotlinweb.domain.author

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class Author(
    @Column
    val name: String,
    @Column
    val phone: String? = null,

) {
    fun toDomain(): AuthorDomain = AuthorDomain(name = this.name, phone = this.phone)
}