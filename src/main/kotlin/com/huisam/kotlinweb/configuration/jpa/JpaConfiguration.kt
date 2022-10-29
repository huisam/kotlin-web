package com.huisam.kotlinweb.configuration.jpa

import com.huisam.kotlinweb.persistence.mysql.MysqlPersistencePackage
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories(basePackageClasses = [MysqlPersistencePackage::class])
@EnableJpaAuditing
@Configuration
class JpaConfiguration