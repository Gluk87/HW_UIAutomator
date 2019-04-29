package com.fastaccess.uiautomator.pages;

import android.util.Log;

import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiScrollable;
import androidx.test.uiautomator.UiSelector;


public class AboutPage extends Page {

    public AboutPage(UiDevice mDevice) {
        super(mDevice);
    }

    public void scrollDown() {
        UiScrollable scroll = new UiScrollable(new UiSelector().scrollable(true));
        scroll.setAsVerticalList();
        try {
            scroll.scrollToEnd(1);
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
        Log.i("Test_QA","Прокрутили меню");
    }
}
