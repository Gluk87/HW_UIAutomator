package com.fastaccess.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import com.fastaccess.pages.AboutPage;
import com.fastaccess.pages.ThemePage;
import com.fastaccess.pages.ToastPage;
import com.fastaccess.pages.TrendingPage;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.Until;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static com.fastaccess.pages.Page.mDevice;
import static com.fastaccess.pages.Page.LAUNCH_TIMEOUT;
import static com.fastaccess.pages.Page.BASIC_SAMPLE_PACKAGE;

public class TestApplication {

    public TrendingPage trending;
    public ThemePage theme;
    public ToastPage toast;
    public AboutPage about;

    public TestApplication(){
        mDevice = UiDevice.getInstance(getInstrumentation());
        mDevice.pressHome();
        final String launcherPackage = getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT);
        Context context = getApplicationContext();
        final Intent intent = context.getPackageManager()
              .getLaunchIntentForPackage(BASIC_SAMPLE_PACKAGE);
        assert intent != null;
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);    // Clear out any previous instances
        context.startActivity(intent);
        mDevice.wait(Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)), LAUNCH_TIMEOUT);
        trending = new TrendingPage(mDevice);
        theme = new ThemePage(mDevice);
        toast = new ToastPage(mDevice);
        about = new AboutPage(mDevice);
    }

    private String getLauncherPackageName() {
        // Create launcher Intent
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        // Use PackageManager to get the launcher package name
        PackageManager pm = getApplicationContext().getPackageManager();
        ResolveInfo resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return resolveInfo.activityInfo.packageName;
    }
}
