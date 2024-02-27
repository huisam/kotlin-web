import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.scripting.compiler.plugin.impl.failure

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.jpa)
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.noarg)
    alias(libs.plugins.kotlin.allopen)
}

group = "com.huisam"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
    maven {
        url = uri("https://repo.spring.io/milestone")
    }

}

dependencies {
    implementation(platform(rootProject.libs.spring.cloud.dependencies))

    // spring
    implementation(libs.spring.boot.data.jpa)
    implementation(libs.spring.boot.web)
    implementation(libs.spring.boot.validation)
    implementation(libs.spring.boot.json)
    implementation(libs.spring.boot.data.elasticsearch)
    implementation(libs.spring.retry)
    implementation(libs.spring.cloud.openfeign)
    implementation(libs.spring.cloud.feign.httpclient)
    implementation(libs.spring.cloud.feign.okhttp)

    // database
    runtimeOnly(libs.h2)
    runtimeOnly(libs.mysql)

    // kotlin
    implementation(libs.jackson)
    implementation(libs.kotlin.reflect)
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.coroutine.core)
    implementation(libs.kotlin.datetime)

    // test
    testImplementation(libs.kotlin.coroutine.test)
    testImplementation(libs.spring.boot.test)
    testImplementation(libs.spring.cloud.contract.wiremock)
    testImplementation(libs.bundles.test.containers)
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.register("test1") {
    println("hi test1")
}

tasks.register("test2") {
    println("hi test2")
}

tasks.register("test3") {
    println("hi test3")
}

tasks.register("test4") {
    println("hi test4")
}

allOpen {
    annotation("jakarta.persistence.Entity")
}

noArg {
    annotation("jakarta.persistence.Entity")
}