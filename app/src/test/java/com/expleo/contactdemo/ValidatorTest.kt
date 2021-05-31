package com.expleo.contactdemo

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ValidatorTest {

    @Test
    fun whetherValidInput() {

        var number = 100
        var result = Validator.validateInput(number)
        assertEquals(result, false)

    }

}