package com.huisam.kotlinweb.jpa

import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource
import org.springframework.transaction.support.TransactionSynchronizationManager
import javax.sql.DataSource

@Configuration
class MasterSlaveConfiguration {

    @Bean(name = ["masterDataSource"])
    @ConfigurationProperties(prefix = "spring.datasource.master")
    fun masterDataSource(): DataSource = DataSourceBuilder.create()
        .type(HikariDataSource::class.java)
        .build()

    @Bean(name = ["slaveDataSource"])
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    fun slaveDataSource(): DataSource = DataSourceBuilder.create()
        .type(HikariDataSource::class.java)
        .build()
        .apply {
            isReadOnly = true
        }

    @Bean
    @ConditionalOnBean(name = ["masterDataSource", "slaveDataSource"])
    fun routingDataSource(
        @Qualifier("masterDataSource") masterDataSource: DataSource,
        @Qualifier("slaveDataSource") slaveDataSource: DataSource
    ): DataSource {
        val routingDataSource = RoutingDataSource()
        val dataSources: Map<Any, Any> = mapOf("master" to masterDataSource, "slave" to slaveDataSource)
        routingDataSource.setTargetDataSources(dataSources)
        routingDataSource.setDefaultTargetDataSource(masterDataSource)
        return routingDataSource
    }

    @Primary
    @Bean(name = ["dataSource"])
    @ConditionalOnBean(name = ["routingDataSource"])
    fun currentDataSource(routingDataSource: DataSource) = LazyConnectionDataSourceProxy(routingDataSource)
}

internal open class RoutingDataSource : AbstractRoutingDataSource() {
    override fun determineCurrentLookupKey(): Any = when {
        TransactionSynchronizationManager.isCurrentTransactionReadOnly() -> "slave"
        else -> "master"
    }
}