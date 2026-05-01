package com.ruben.tests;

import com.ruben.framework.core.BaseTest;
import com.ruben.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    void validLogin_shouldShowSuccessMessage() {
        step("Open login page");
        driver.get("https://the-internet.herokuapp.com/login");

        LoginPage loginPage = new LoginPage(driver);

        step("Enter username");
        loginPage.enterUsername("tomsmith");

        step("Enter password");
        loginPage.enterPassword("SuperSecretPassword!");

        step("Click login button");
        loginPage.clickLoginButton();

        step("Verify success message");
        assertTrue(
                loginPage.getFlashMessage().toLowerCase().contains("you logged into a secure area"),
                "Expected success message, but got: " + loginPage.getFlashMessage()
        );
    }
}