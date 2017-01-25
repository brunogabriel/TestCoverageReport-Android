package io.github.brunogabriel.testcoveragereport;

import android.os.Build;
import android.support.v7.widget.AppCompatTextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertTrue;
/**
 * Created by brunogabriel on 25/01/17.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class MainActivityUnitTest {

    @Test
    public void shouldChangeTextAfterClick() {
        // given
        MainActivity mainActivity = Robolectric.setupActivity(MainActivity.class);

        // when
        mainActivity.findViewById(R.id.button_msg).performClick();

        // then
        assertTrue(mainActivity.isTextHelloWorld());
    }

}
