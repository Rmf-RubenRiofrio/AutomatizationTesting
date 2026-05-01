package com.ruben.framework.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestWatcherExtension.class)
public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        log("Start: " + testInfo.getDisplayName());
        driver = DriverFactory.getDriver();
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        if (driver != null) {
            driver.quit();
        }
        log("END: " + testInfo.getDisplayName());
    }

    protected void log(String message) {
        System.out.println("[TEST] " + message);
    }

    protected void step(String message) {
        System.out.println(" [STEP] " + message);
    }
}
