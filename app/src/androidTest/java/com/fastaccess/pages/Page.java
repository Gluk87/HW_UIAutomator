package com.fastaccess.pages;

import android.util.Log;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.Until;

public class Page {
    public static UiDevice mDevice;
    public static final int LAUNCH_TIMEOUT = 5000;
    public static final String BASIC_SAMPLE_PACKAGE = "com.fastaccess.github.debug";

    Page(UiDevice mDevice) {
        Page.mDevice = mDevice;
    }

    public void waitByDesc(String item){
        mDevice.wait(Until.findObject(By.desc(item)),LAUNCH_TIMEOUT);
        Log.i("Test_QA","Ожидаем появления объекта с ContentDescription = "+item);
    }

    public void waitByText(String item){
        mDevice.wait(Until.findObject(By.text(item)),LAUNCH_TIMEOUT);
        Log.i("Test_QA","Ожидаем появления объекта с text = "+item);
    }

    public void openMenu() {
        UiObject2 element = mDevice.wait(Until.findObject(By.clazz("android.widget.ImageButton")),LAUNCH_TIMEOUT);
        element.click();
        Log.i("Test_QA","Открыли меню");
    }

    public void selectMenu(String itemMenu) {
        UiObject2 element = mDevice.wait(Until.findObject(By.text(itemMenu)),LAUNCH_TIMEOUT);
        element.click();
        Log.i("Test_QA","Выбрали в меню пункт = "+itemMenu);
    }
}
