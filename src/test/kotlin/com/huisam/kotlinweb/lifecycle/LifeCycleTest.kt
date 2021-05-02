package com.huisam.kotlinweb.lifecycle

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation
import org.junit.jupiter.api.extension.ExtendWith
import java.util.concurrent.atomic.AtomicLong

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // 생명주기는 클래스
@TestMethodOrder(OrderAnnotation::class) // 순서에 의해서 테스트 실행
@ExtendWith(LifeCycleExtension::class) // 커스텀 Extension Import
class ClassLifeCycleTest {

    private val count = AtomicLong(0L)

    @BeforeEach
    internal fun setUp() {
        count.getAndAdd(1) // 테스트 실행 전마다 +1
    }

    @Test
    @Order(1) // 처음 실행되는 테스트
    fun `자원 공유 테스트`() {
        assertThat(count).hasValue(1L)
    }

    @Test
    @Order(2) // 두번째에 실행되는 테스트
    fun `자원 공유 테스트2`() {
        assertThat(count).hasValue(2L)
    }
}

@TestMethodOrder(OrderAnnotation::class)
@ExtendWith(LifeCycleExtension::class)
class MethodLifeCycleTest {

    private val count = AtomicLong(0L)

    @BeforeEach
    internal fun setUp() {
        count.getAndAdd(1)
    }

    @Test
    @Order(1)
    fun `자원 공유 하지 않는 테스트`() {
        assertThat(count).hasValue(1L)
    }

    @Test
    @Order(2)
    fun `자원 공유 하지 않는 테스트2`() {
        assertThat(count).hasValue(1L)
    }
}