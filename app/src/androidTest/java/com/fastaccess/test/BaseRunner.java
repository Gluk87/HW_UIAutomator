package com.fastaccess.test;

import com.fastaccess.app.TestApplication;
import org.junit.Before;


public class BaseRunner {
    TestApplication app;

    @Before
    public void setUp() {
        app = new TestApplication();
    }
}
