package com.fastaccess.espresso.pages;

import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;

public class RestorePageEs extends PageEs {
    public void checkIntent() {
        intended(hasComponent(hasClassName("com.fastaccess.ui.modules.main.donation.CheckPurchaseActivity")));
    }
}
