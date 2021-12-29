package com.huisam.kotlinweb.persistence.student

import org.hibernate.engine.spi.SharedSessionContractImplementor
import org.hibernate.id.enhanced.TableGenerator
import org.hibernate.service.ServiceRegistry
import org.hibernate.type.StandardBasicTypes
import org.hibernate.type.Type
import java.io.Serializable
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class DatePrefixIdGenerator : TableGenerator() {
    override fun configure(type: Type, params: Properties, serviceRegistry: ServiceRegistry) {
        super.configure(StandardBasicTypes.LONG, params, serviceRegistry)
    }

    override fun generate(session: SharedSessionContractImplementor, obj: Any): Serializable {
        val value = super.generate(session, obj)
        val sequence = cycle(value as Long)
        return generateFormat(getToday(), sequence)
    }


    companion object {
        const val MAX = 1_000_000_000_000L
        private const val POSTFIX_NUMBER_COUNT = 12
        private const val SEQUENCE_FORMAT = "%s%0${POSTFIX_NUMBER_COUNT}d" // yyyyMMdd%012d
        fun generateFormat(prefix: String, sequence: Long) = String.format(SEQUENCE_FORMAT, prefix, sequence)
        fun cycle(sequence: Long): Long {
            return sequence % MAX
        }
    }

    private fun getToday(): String {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))
    }
}