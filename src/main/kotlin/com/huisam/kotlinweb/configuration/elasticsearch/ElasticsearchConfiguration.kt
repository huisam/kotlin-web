package com.huisam.kotlinweb.configuration.elasticsearch

import com.huisam.kotlinweb.persistence.elasticsearch.ElasticSearchPersistencePackage
import org.springframework.boot.context.TypeExcludeFilter
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType
import org.springframework.data.elasticsearch.config.EnableElasticsearchAuditing
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories

@EnableElasticsearchRepositories(
    basePackageClasses = [ElasticSearchPersistencePackage::class],
    excludeFilters = [ComponentScan.Filter(type = FilterType.CUSTOM, classes = [TypeExcludeFilter::class])]
)
@EnableElasticsearchAuditing
@Configuration
class ElasticsearchConfiguration