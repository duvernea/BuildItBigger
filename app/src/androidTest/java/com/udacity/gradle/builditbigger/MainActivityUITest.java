package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.test.ActivityUnitTestCase;
import android.test.AndroidTestCase;
import android.support.test.runner.AndroidJUnit4;
import android.test.UiThreadTest;
import android.test.suitebuilder.annotation.LargeTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.util.Log;
import android.util.Pair;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by duvernea on 12/17/15.
 */

@RunWith(AndroidJUnit4.class)
@SmallTest
public class MainActivityUITest  {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testStringResponse() {
        // Verify button text exists and perform click
        String expectedText = mActivityRule.getActivity().getString(R.string.joke_button_text);
        onView(withId(R.id.tell_joke_button)).check(matches(withText(expectedText)));
        onView(withId(R.id.tell_joke_button)).perform(click());
    }
}
