package io.github.brunogabriel.testcoveragekotlin.validator

import io.github.brunogabriel.testcoveragekotlin.model.UserLogin
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test

/**
 * Created by brunogabriel on 2019-10-09.
 */
class LoginValidatorTest {
    private lateinit var loginValidator: LoginValidator

    @Before
    fun shouldBeInvalidWhenSizeIsLessThanMin() {
        // given
        loginValidator = LoginValidator()

        // then
        assertFalse(
            loginValidator.validate(
                UserLogin(
                    "12345",
                    "123456"
                )
            )
        )

        assertFalse(
            loginValidator.validate(
                UserLogin(
                    "123456",
                    "12345"
                )
            )
        )
    }

    @Test
    fun shouldBeValid() {
        // given
        loginValidator = LoginValidator()

        // then
        assertTrue(
            loginValidator.validate(
                UserLogin(
                    "123456",
                    "123456"
                )
            )
        )

        assertTrue(
            loginValidator.validate(
                UserLogin(
                    "1234567",
                    "123456"
                )
            )
        )

        assertTrue(
            loginValidator.validate(
                UserLogin(
                    "123456",
                    "1234567"
                )
            )
        )

        assertTrue(
            loginValidator.validate(
                UserLogin(
                    "1234567",
                    "1234567"
                )
            )
        )
    }
}