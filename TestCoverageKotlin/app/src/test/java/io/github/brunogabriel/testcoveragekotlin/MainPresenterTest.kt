package io.github.brunogabriel.testcoveragekotlin

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.check
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.github.brunogabriel.testcoveragekotlin.validator.LoginValidator
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Created by brunogabriel on 2019-10-09.
 */
class MainPresenterTest {
    private lateinit var mainPresenter: MainPresenter
    private lateinit var view: MainContract.View
    private lateinit var validator: LoginValidator

    @Before
    fun setup() {
        view = mock()
        validator = mock()
        mainPresenter = MainPresenter(view, validator)
    }

    @Test
    fun shouldShowLoginSuccessWhenOnLoginClicked() {
        // given
        val username = "username"
        val password = "password"
        whenever(validator.validate(check {
            assertEquals(username, it.username)
            assertEquals(password, it.password)
        })).thenReturn(true)

        // when
        mainPresenter.onLoginClicked(username, password)

        // then
        verify(view).showLoginSuccess()
    }

    @Test
    fun shouldShowLoginFailWhenOnLoginClicked() {
        // given
        val username = "username"
        val password = "password"
        whenever(validator.validate(check {
            assertEquals(username, it.username)
            assertEquals(password, it.password)
        })).thenReturn(false)

        // when
        mainPresenter.onLoginClicked(username, password)

        // then
        verify(view).showLoginFail()
    }
}