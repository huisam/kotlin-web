package com.huisam.kotlinweb.tag

import org.assertj.core.api.WithAssertions
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

@Tags(
    Tag("math"),
    Tag("minus"),
)
class MinusTest : WithAssertions {
    @Test
    fun minus_test() {
        // given
        val number1 = 10
        val number2 = 30

        // when
        val actual = number2 - number1

        // then
        assertThat(actual).isEqualTo(20)
        println("[Test] minus executed")
    }
}