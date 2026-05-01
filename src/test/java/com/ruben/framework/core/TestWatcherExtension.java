package com.ruben.framework.core;

import com.ruben.framework.utils.ScreenshotUtil;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class TestWatcherExtension implements TestExecutionExceptionHandler {

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable)throws Throwable {
        Object testInstance = context.getRequiredTestInstance();

        if(testInstance instanceof BaseTest baseTest && baseTest.driver != null) {
            var path = ScreenshotUtil.takeScreenshot(
                    baseTest.driver,
                    context.getRequiredTestMethod().getName()
            );

            if(path != null) {
                System.out.println(" [SCREENSHOT] Saved: " + path);
            }
        }

        throw throwable;
    }
}
