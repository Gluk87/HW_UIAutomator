package com.fastaccess.espresso.test;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import com.fastaccess.ui.modules.main.MainActivity;
import com.fastaccess.ui.modules.main.donation.CheckPurchaseActivity;

import org.junit.Rule;


public class BaseRunnerEs {

    @Rule
    public ActivityTestRule<MainActivity> activityScenarioRule
            = new ActivityTestRule<>(MainActivity.class);
    ActivityTestRule<MainActivity> getActivityRule() {
        return activityScenarioRule;
    }

    @Rule
    public IntentsTestRule<CheckPurchaseActivity> intentsTestRule =
            new IntentsTestRule<>(CheckPurchaseActivity.class);
}
