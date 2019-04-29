package com.fastaccess.uiautomator.test;

import com.fastaccess.uiautomator.app.TestApplication;
import org.junit.Before;


public class BaseRunner {
    TestApplication app;

    @Before
    public void setUp() {
        app = new TestApplication();
    }
}
