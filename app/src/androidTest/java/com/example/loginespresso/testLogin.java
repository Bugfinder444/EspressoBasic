package com.example.loginespresso;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import android.content.Context;

import com.example.loginespresso.ui.login.LoginActivity;

@RunWith(AndroidJUnit4.class)
public class testLogin {

    @Rule
    public ActivityScenarioRule<LoginActivity> mActivityRule = new ActivityScenarioRule<>(LoginActivity.class);

    @Test
    public void testLoginSuccess() {
        onView(withId(R.id.username)).perform(typeText("testuser@example.com"), closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("password"), closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
    }

    @Test
    public void testLoginFailure() {
        onView(withId(R.id.username)).perform(typeText("invalid@example.com"), closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("password"), closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
    }

    @Test
    public void testEmptyFields() {
        onView(withId(R.id.username)).perform(clearText(), closeSoftKeyboard());
        onView(withId(R.id.password)).perform(clearText(), closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
    }
}

