package com.banking.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    public static String captureScreenshot(
            WebDriver driver,
            String testName) {

        String folderPath = "screenshots";

        String filePath =
                folderPath + File.separator + testName + ".png";

        try {

            Path folder = Paths.get(folderPath);

            if (!Files.exists(folder)) {
                Files.createDirectories(folder);
            }

            File source =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.FILE);

            File destination = new File(filePath);

            Files.copy(
                    source.toPath(),
                    destination.toPath()
            );

            return destination.getAbsolutePath();

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to capture screenshot",
                    e
            );
        }
    }
}