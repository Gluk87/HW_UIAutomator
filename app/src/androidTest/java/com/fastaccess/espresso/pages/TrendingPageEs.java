package com.fastaccess.espresso.pages;

import android.widget.TextView;

import com.fastaccess.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

public class TrendingPageEs extends PageEs {
    public void checkTrending() {
        onView(allOf(withParent(withId(R.id.toolbar)), isAssignableFrom(TextView.class), withText("Trending"))).check(matches(isDisplayed()));
    }
}
