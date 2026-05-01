package com.ruben.framework.core;

import com.ruben.framework.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    public static WebDriver getDriver(){
       String browser = ConfigReader.getProperty("browser").toLowerCase();
       WebDriver  driver = switch (browser) {
           case "chrome" -> createChromeDriver();
           case "firefox" -> createFireFoxDriver();
           case "edge" -> createEdgeDriver();
           case "safari" -> createSafariDriver();
           default -> throw new RuntimeException("Unsupported browser: " + browser);
       };

        return driver;
    }


    private static WebDriver createChromeDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =  new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver createFireFoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver =  new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver createSafariDriver(){
        WebDriverManager.safaridriver().setup();
        WebDriver driver =  new SafariDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver createEdgeDriver(){
        WebDriverManager.edgedriver().setup();
        WebDriver driver =  new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

}
