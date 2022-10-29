package com.huisam.kotlinweb.persistence.mysql.index

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component

interface CafeRepository : JpaRepository<CafeTable, Long>

@Component
class CafeDataInitializer(
    private val cafeRepository: CafeRepository,
) {
//    @PostConstruct
//    fun init() {
//        cafeRepository.saveAll(
//            (0..100).map {
//                val type = CafeType.values()[it % 4]
//                CafeTable(name = "$type name $it", type = type)
//            }
//        )
//    }
}