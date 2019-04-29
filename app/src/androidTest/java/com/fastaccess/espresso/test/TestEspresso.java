package com.fastaccess.espresso.test;

import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import com.fastaccess.espresso.pages.AboutPageEs;
import com.fastaccess.espresso.pages.PageEs;
import com.fastaccess.espresso.pages.RestorePageEs;
import com.fastaccess.espresso.pages.ThemePageEs;
import com.fastaccess.espresso.pages.ToastPageEs;
import com.fastaccess.espresso.pages.TrendingPageEs;

import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class TestEspresso extends BaseRunnerEs {

    @Test
    public void testTrending() {
        new PageEs()
                .openMenu()
                .selectMenu("Trending");
        new TrendingPageEs()
                .checkTrending();
    }

    @Test
    public void testTheme() {
        new PageEs()
                .openMenu()
                .selectMenu("Settings")
                .selectMenu("Theme");
        new ThemePageEs()
                .swipeTheme()
                .clickFab()
                .checkColor();
    }

    @Test
    public void testRestore() {
        new PageEs()
                .openMenu()
                .selectMenu("Restore Purchases");
        new RestorePageEs()
                .checkIntent();
    }

    @Test
    public void testToast() {
        new PageEs()
                .openMenu()
                .selectMenu("Send feedback")
                .selectMenu("OK");
        new ToastPageEs()
                .inputText("hello")
                .clickDescr()
                .checkManufacturer()
                .checkBrand()
                .clickSubmit()
                .clickSubmit()
                .checkToast(getActivityRule());
    }

    @Test
    public void testAbout() {
        new PageEs()
                .openMenu()
                .scrollDown()
                .selectMenu("About");
        new AboutPageEs()
                .scrollToElement()
                .searchElement();
    }
}
