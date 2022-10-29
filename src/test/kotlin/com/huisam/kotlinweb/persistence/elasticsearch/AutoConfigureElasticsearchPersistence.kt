package com.huisam.kotlinweb.persistence.elasticsearch

import com.huisam.kotlinweb.configuration.elasticsearch.ElasticsearchConfiguration
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchRepositoriesAutoConfiguration
import org.springframework.context.annotation.Import

@ImportAutoConfiguration(
    ElasticsearchDataAutoConfiguration::class,
    ElasticsearchRepositoriesAutoConfiguration::class
)
@Import(ElasticsearchConfiguration::class)
annotation class AutoConfigureElasticsearchPersistence
