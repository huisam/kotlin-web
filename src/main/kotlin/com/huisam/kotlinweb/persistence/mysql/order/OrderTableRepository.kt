package com.huisam.kotlinweb.persistence.mysql.order

import org.springframework.data.jpa.repository.JpaRepository

interface OrderTableRepository : JpaRepository<OrderTable, Long>