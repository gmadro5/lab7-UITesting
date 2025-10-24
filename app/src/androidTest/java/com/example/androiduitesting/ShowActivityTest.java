package com.example.androiduitesting;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ShowActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> scenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    // Test1: Switch Activity
    @Test
    public void testActivitySwitch() {
        // Add a city
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(androidx.test.espresso.action.ViewActions.typeText("Edmonton"));
        onView(withId(R.id.button_confirm)).perform(click());

        // Click the city
        onView(withText("Edmonton")).perform(click());

        // Check if ShowActivity is displayed by verifying city name text
        onView(allOf(withId(R.id.textView_cityName), withText("Edmonton"))).check(matches(isDisplayed()));
    }

    // Test2 City Name Consistency
    @Test
    public void testCityNameConsistency() {
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(androidx.test.espresso.action.ViewActions.typeText("Tokyo"));
        onView(withId(R.id.button_confirm)).perform(click());

        onView(withText("Tokyo")).perform(click());
        onView(withText("Tokyo")).check(matches(isDisplayed()));
    }

    // Test3 Back Button Functionality
    @Test
    public void testBackButton() {
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(androidx.test.espresso.action.ViewActions.typeText("Berlin"));
        onView(withId(R.id.button_confirm)).perform(click());

        onView(withText("Berlin")).perform(click());
        onView(withId(R.id.button_back)).perform(click());

        // Verify MainActivity is back on screen (the Add button is visible again)
        onView(withId(R.id.button_add)).check(matches(isDisplayed()));
    }
}