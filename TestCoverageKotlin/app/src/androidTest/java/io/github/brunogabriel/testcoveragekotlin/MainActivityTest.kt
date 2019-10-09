package io.github.brunogabriel.testcoveragekotlin

import androidx.annotation.StringRes
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by brunogabriel on 2019-10-09.
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Test
    fun shouldShowLoginFail() {
        // given
        displayScreen()
        closeKeyboard()

        // when
        onView(withId(R.id.login_button)).perform(click())

        // then
        verifyTextDisplay(R.string.login_fail)
        onClickAtOk()
    }

    @Test
    fun shouldShowLoginSuccess() {
        // given
        displayScreen()
        onView(withId(R.id.username_edit_text)).perform(
            typeText("1234567")
        )
        onView(withId(R.id.password_edit_text)).perform(
            typeText("1234567"),
            ViewActions.closeSoftKeyboard()
        )
        closeKeyboard()

        // when
        onView(withId(R.id.login_button)).perform(click())

        // then
        verifyTextDisplay(R.string.login_success)
        onClickAtOk()
    }

    private fun closeKeyboard() {
        Espresso.closeSoftKeyboard()
    }

    private fun verifyTextDisplay(@StringRes stringRes: Int) {
        onView(withText(stringRes)).check(matches(isDisplayed()))
    }

    private fun displayScreen() {
        activityTestRule.launchActivity(null)

    }

    private fun onClickAtOk() {
        onView(withText(android.R.string.ok)).perform(click())
    }
}