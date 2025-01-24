package DominikBernas.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ScreenshotUtil {
    private static final Logger logger = LogManager.getLogger(ScreenshotUtil.class);

    public static String takeScreenshot(WebDriver driver, String screenshotName) {
        // Ścieżka do katalogu resources/screenshots
        String resourcesPath = System.getProperty("user.dir") + "/src/test/resources/screenshots/";
        createDirectoryIfNotExists(resourcesPath);

        // Dynamiczna nazwa pliku
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String destinationPath = resourcesPath + screenshotName + "_" + timestamp + ".png";

        try {
            // Wykonanie zrzutu ekranu
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(destinationPath)); // Zapis pliku
            logger.info("Screenshot saved at: " + destinationPath);
        } catch (IOException e) {
            logger.error("Failed to save screenshot: ", e);
            return null;
        }
        return destinationPath; // Zwraca ścieżkę do zapisanego zrzutu
    }

    private static void createDirectoryIfNotExists(String resourcesPath) {
    }

}