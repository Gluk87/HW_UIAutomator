package com.fastaccess.pages;

import android.util.Log;

import java.util.List;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.Direction;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.Until;

import static org.junit.Assert.assertEquals;

public class ThemePage extends Page {

    public ThemePage(UiDevice mDevice) {
        super(mDevice);
    }

    public void swipeTheme() {
        UiObject2 element = mDevice.wait(Until.findObject(By.res("com.fastaccess.github.debug:id/toolbar")),LAUNCH_TIMEOUT);
        element.swipe(Direction.LEFT,1.0f);
        Log.i("Test_QA","Свайп до второй темы");
    }

    public void clickFab() {
        List<UiObject2> elements = mDevice.wait(Until.findObjects(By.res("com.fastaccess.github.debug:id/apply")),LAUNCH_TIMEOUT);
        for (int i=0;i<elements.size();i++){
            if (i==1) elements.get(i).click();
        }
        Log.i("Test_QA","Кликнули на кнопку смены темы");
    }

    public void checkScheme() {
        List<UiObject2> elements = mDevice.wait(Until.findObjects(By.res("com.fastaccess.github.debug:id/coordinatorLayout")),LAUNCH_TIMEOUT);
        assertEquals(3, elements.size());
        Log.i("Test_QA","Если количество объектов равно 3, то тема изменилась:" +elements.size());
    }
}
