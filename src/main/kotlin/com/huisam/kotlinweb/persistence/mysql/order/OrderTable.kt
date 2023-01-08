package com.huisam.kotlinweb.persistence.mysql.order

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import java.math.BigDecimal
import java.time.ZonedDateTime

@Entity
@Table(name = "order_table")
class OrderTable(
    @Id
    @GeneratedValue
    val id: Long? = null,

    @Column(name = "purchaser_id", nullable = false)
    val purchaser: Long,

    @Column(name = "seller_id", nullable = false)
    val seller: Long,

    @Column(name = "gift", nullable = false)
    val isGift: Boolean,

    @Column(name = "service_location", length = 20)
    val serviceLocation: String?,

    @Column(name = "pay_amount", scale = 2)
    val payAmount: BigDecimal,
) {
    @CreatedDate
    @Column(name = "created_at", nullable = false)
    var createdAt: ZonedDateTime = ZonedDateTime.now()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is OrderTable) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}