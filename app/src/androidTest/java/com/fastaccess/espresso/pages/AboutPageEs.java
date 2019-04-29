package com.fastaccess.espresso.pages;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.widget.TextView;

import com.fastaccess.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

public class AboutPageEs extends PageEs {

    public AboutPageEs scrollToElement() {
        onView(withId(R.id.mal_recyclerview)).perform(RecyclerViewActions.scrollToPosition(3));
        return this;
    }

    public void searchElement() {
        onView(allOf(isAssignableFrom(TextView.class), withText("Changelog"))).check(matches(isDisplayed()));
    }
}
