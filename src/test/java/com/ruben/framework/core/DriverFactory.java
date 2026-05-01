package com.ruben.framework.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    public static WebDriver createChromeDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =  new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver createFireFoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver =  new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver createSafariDriver(){
        WebDriverManager.safaridriver().setup();
        WebDriver driver =  new SafariDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver createEdgeDriver(){
        WebDriverManager.edgedriver().setup();
        WebDriver driver =  new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

}
