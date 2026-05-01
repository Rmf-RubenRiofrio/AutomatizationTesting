package com.ruben.tests;

import com.ruben.framework.core.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    void validLogin_shouldShowSuccessMessage() {
        String testName = "validLogin_shouldShowSuccessMessage";

        step("Open login page");
        driver.get("https://the-internet.herokuapp.com/login");

        step("Enter username");
        driver.findElement(By.id("username")).sendKeys("tomsmith");

        step("Enter password");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //driver.findElement(By.id("password")).sendKeys("WrongPassword");

        step("Click login button");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        step("Verify success message");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        var flash = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));

        assertTrue(flash.getText().toLowerCase().contains("you logged into a secure area"),
                "Expected success message, But got: " + flash.getText());
    }
}


