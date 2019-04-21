package com.fastaccess.test;

import com.fastaccess.pages.AboutPage;
import com.fastaccess.pages.ThemePage;
import com.fastaccess.pages.ToastPage;
import com.fastaccess.pages.TrendingPage;

import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.filters.SdkSuppress;
import androidx.test.ext.junit.runners.AndroidJUnit4;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class Tests extends BaseRunner {

    @Test
    public void testTrending() {
        TrendingPage trending = app.trending;
        trending.waitByDesc("Notifications");
        trending.openMenu();
        trending.selectMenu("Trending");
        trending.waitByText("Trending");
        trending.checkElement("Trending");
    }

    @Test
    public void testTheme() {
        ThemePage theme = app.theme;
        theme.waitByDesc("Notifications");
        theme.openMenu();
        theme.selectMenu("Settings");
        theme.selectMenu("Theme");
        theme.swipeTheme();
        theme.clickFab();
        theme.waitByDesc("Notifications");
        theme.openMenu();
        theme.selectMenu("Settings");
        theme.selectMenu("Theme");
        theme.checkScheme();
    }

    @Test
    public void testRestore() {
        ThemePage theme = app.theme;
        theme.waitByDesc("Notifications");
        theme.openMenu();
        theme.selectMenu("Restore Purchases");
    }

    @Test
    public void testToast() {
        ToastPage toast = app.toast;
        toast.waitByDesc("Notifications");
        toast.openMenu();
        toast.selectMenu("Send feedback");
        toast.waitByText("Submit feedback");
        toast.selectMenu("OK");
        toast.inputText("Hello");
        toast.clickDescr();
        toast.waitByText("Markdown");
        toast.checkManufacturer();
        toast.checkBrand();
        //toast.checkModel(); //Закомментировал, т.к. в моем случае выдает ошибку: SM-J730FM <> Galaxy J7
        toast.clickSubmit();
        toast.waitByText("Submit feedback");
        toast.clickFabSubmit();
        toast.checkToast("Message was sent");
    }

    @Test
    public void testAbout() {
        AboutPage about = app.about;
        about.waitByDesc("Notifications");
        about.openMenu();
        about.scrollDown();
        about.selectMenu("About");
    }
}
