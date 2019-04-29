package com.fastaccess.espresso.pages;

import android.widget.ImageButton;

import com.fastaccess.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

public class PageEs {
    public PageEs openMenu(){
        onView(allOf(withParent(withId(R.id.toolbar)), isAssignableFrom(ImageButton.class))).perform(click());
        return this;
    }

    public PageEs selectMenu(String item) {
        onView(withText(item)).perform(click());
        return this;
    }

    public PageEs scrollDown() {
        onView(withId(R.id.mainNav)).perform(swipeUp());
        return this;
    }
}
