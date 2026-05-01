package com.ruben.framework.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {

    private static final DateTimeFormatter TS =  DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");

    public static Path takeScreenshot(WebDriver driver, String testName){
        try{
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            Path outDir = Path.of("test-output", "screenshots");
            Files.createDirectories(outDir);

            String fileName = testName+ "-" + LocalDateTime.now().format(TS) + ".png";
            Path dest = outDir.resolve(fileName);

            Files.copy(src.toPath(), dest, StandardCopyOption.REPLACE_EXISTING);
            return dest;
        }catch(Exception e){
            System.out.println("ScreenshotUtil takeScreenshot failed" + e.getMessage());
            return  null;
        }
    }
}
