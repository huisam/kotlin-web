package com.huisam.kotlinweb.tag

import org.assertj.core.api.WithAssertions
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

@Tags(
    Tag("math"),
    Tag("plus"),
)
class PlusTest : WithAssertions {
    @Test
    fun plus_test() {
        // given
        val number1 = 10
        val number2 = 30

        // when
        val actual = number1 + number2

        // then
        assertThat(actual).isEqualTo(40)
        println("[Test] plus executed")
    }
}