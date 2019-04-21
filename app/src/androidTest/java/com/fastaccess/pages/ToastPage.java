package com.fastaccess.pages;

import android.os.Build;
import android.util.Log;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.Until;

import static org.junit.Assert.assertEquals;

public class ToastPage extends Page {

    public ToastPage(UiDevice mDevice) {
        super(mDevice);
    }

    public void inputText(String text) {
        UiObject2 element = mDevice.wait(Until.findObject(By.clazz("android.widget.EditText")),LAUNCH_TIMEOUT);
        element.setText(text);
        Log.i("Test_QA","Ввели в поле текст = "+text);
    }

    public void clickDescr() {
        UiObject2 element = mDevice.wait(Until.findObject(By.res("com.fastaccess.github.debug:id/description")),LAUNCH_TIMEOUT);
        element.click();
        Log.i("Test_QA","Кликнули по второму блоку ввода текста");
    }

    public void checkManufacturer() {
        UiObject2 element = mDevice.wait(Until.findObject(By.clazz("android.widget.EditText")),LAUNCH_TIMEOUT);
        assertEquals(Build.MANUFACTURER, element.getText().substring(element.getText().indexOf("**Manufacturer:**")+18,
                element.getText().indexOf("**Brand:**")-5));
        Log.i("Test_QA","Проверили соответствие Manufacturer");
    }

    public void checkBrand() {
        UiObject2 element = mDevice.wait(Until.findObject(By.clazz("android.widget.EditText")),LAUNCH_TIMEOUT);
        assertEquals(Build.BRAND, element.getText().substring(element.getText().indexOf("**Brand:**")+11,
                element.getText().indexOf("**Model:**")-5));
        Log.i("Test_QA","Проверили соответствие Brand");
    }

    public void checkModel() {
        UiObject2 element = mDevice.wait(Until.findObject(By.clazz("android.widget.EditText")),LAUNCH_TIMEOUT);
        assertEquals(Build.MODEL, element.getText().substring(element.getText().indexOf("**Model:**")+11,
                element.getText().indexOf("---")-3));
        Log.i("Test_QA","Проверили соответствие Model");
    }

    public void clickSubmit() {
        UiObject2 element = mDevice.wait(Until.findObject(By.desc("Submit")),LAUNCH_TIMEOUT);
        element.click();
        Log.i("Test_QA","Нажали на элемент Submit");
    }

    public void clickFabSubmit() {
        UiObject2 element = mDevice.wait(Until.findObject(By.res("com.fastaccess.github.debug:id/submit")),LAUNCH_TIMEOUT);
        element.click();
        Log.i("Test_QA","Нажали на FAB");
    }

    public void checkToast(String text) {
        UiObject2 element = mDevice.wait(Until.findObject(By.res("android:id/message")),LAUNCH_TIMEOUT);
        assertEquals(text, element.getText());
        Log.i("Test_QA","Проверили сообщение в toast: "+text+" = "+element.getText());
    }
}
