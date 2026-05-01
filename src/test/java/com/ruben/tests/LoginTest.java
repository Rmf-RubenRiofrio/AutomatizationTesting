package com.ruben.tests;

import com.ruben.framework.core.BaseTest;
import com.ruben.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    void validLogin_shouldShowSuccessMessage() {
        step("Open login page");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();

        step("Login with valid credentials");
        loginPage.login("tomsmith", "SuperSecretPassword!");

        step("Verify success message");
        assertTrue(
                loginPage.getFlashMessage().toLowerCase().contains("you logged into a secure area"),
                "Expected success message, but got: " + loginPage.getFlashMessage()
        );
    }

    @Test
    void invalidLogin_shouldShowErrorMessage() {
        step("Open login page");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();

        step("Login with invalid password");
        loginPage.login("tomsmith", "WrongPassword");

        step("Verify error message");
        assertTrue(
                loginPage.getFlashMessage().toLowerCase().contains("your password is invalid"),
                "Expected invalid password message, but got: " + loginPage.getFlashMessage()
        );
    }
}