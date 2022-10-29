package com.huisam.kotlinweb.persistence.mysql.order

import org.springframework.stereotype.Component

@Component
class OrderTableInit(
    private val orderTableRepository: OrderTableRepository,
) {

//    @PostConstruct
//    fun init() {
//        (1..1_500_000).asSequence()
//            .forEach {
//                OrderTable(
//                    purchaser = Random.nextLong(1, 100),
//                    seller = Random.nextLong(1, 10000),
//                    isGift = Random.nextBoolean(),
//                    serviceLocation = if (it % 10 == 0) "SEOUL" else null,
//                    payAmount = it.toBigDecimal()
//                ).run {
//                    orderTableRepository.save(this)
//                }
//            }
//    }
}