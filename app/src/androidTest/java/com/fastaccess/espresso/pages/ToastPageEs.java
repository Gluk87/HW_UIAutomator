package com.fastaccess.espresso.pages;

import android.os.Build;
import android.support.test.rule.ActivityTestRule;
import android.widget.EditText;

import com.fastaccess.R;
import com.fastaccess.ui.modules.main.MainActivity;

import org.hamcrest.Matchers;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSubstring;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class ToastPageEs extends PageEs {
    public ToastPageEs inputText(String text) {
        onView(isAssignableFrom(EditText.class)).perform(typeText(text));
        return this;
    }

    public ToastPageEs clickDescr() {
        onView(withId(R.id.description)).perform(click());
        return this;
    }

    public ToastPageEs clickSubmit() {
        onView(withId(R.id.submit)).perform(click());
        return this;
    }

    public void checkToast(ActivityTestRule<MainActivity> activityRule) {
        onView(withText("Message was sent")).inRoot(withDecorView(Matchers.not(Matchers.is(activityRule.getActivity().getWindow().getDecorView())))).
                check(matches(isDisplayed()));
    }

    public ToastPageEs checkManufacturer() {
        onView(withId(R.id.editText)).check(matches(withSubstring(Build.MANUFACTURER)));
        return this;
    }

    public ToastPageEs checkBrand() {
        onView(withId(R.id.editText)).check(matches(withSubstring(Build.BRAND)));
        return this;
    }
}
