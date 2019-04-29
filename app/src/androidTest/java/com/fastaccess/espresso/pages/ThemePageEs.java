package com.fastaccess.espresso.pages;

import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.fastaccess.R;

import org.hamcrest.Matchers;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasTextColor;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.core.AllOf.allOf;

public class ThemePageEs extends PageEs {
    public ThemePageEs swipeTheme() {
        onView(isAssignableFrom(ViewPager.class)).perform(swipeLeft());
        return this;
    }

    public ThemePageEs clickFab() {
        onView(allOf(withId(R.id.apply),isCompletelyDisplayed())).perform(click());
        return this;
    }

    public void checkColor() {
        onView(Matchers.allOf(withParent(withId(R.id.toolbar)),isAssignableFrom(TextView.class)))
                .check(matches(hasTextColor(R.color.white)));
    }
}
