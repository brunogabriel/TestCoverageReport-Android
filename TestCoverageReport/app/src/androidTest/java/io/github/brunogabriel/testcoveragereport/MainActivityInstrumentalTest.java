package io.github.brunogabriel.testcoveragereport;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by brunogabriel on 25/01/17.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityInstrumentalTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void shouldHideButtonAfterClick() {
        // then
        onView(withId(R.id.button_hide)).perform(click());

        // when
        onView(withId(R.id.button_hide)).
                check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
    }
}
