package com.fastaccess.uiautomator.pages;

import android.util.Log;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.Until;

import static org.junit.Assert.assertEquals;

public class TrendingPage extends Page {

    public TrendingPage(UiDevice mDevice) {
        super(mDevice);
    }

    public void checkElement(String item){
        UiObject2 element = mDevice.wait(Until.findObject(By.text("Trending")),LAUNCH_TIMEOUT);
        assertEquals(item, element.getText());
        Log.i("Test_QA","Проверили, что "+item+" = "+element.getText());
    }
}
