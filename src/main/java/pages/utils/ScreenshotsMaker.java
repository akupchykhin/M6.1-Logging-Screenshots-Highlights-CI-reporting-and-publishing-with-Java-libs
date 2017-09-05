package pages.utils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.AbstractPage;

import java.io.File;
import java.io.IOException;

import static pages.utils.WebDriverSingleton.getWebDriverInstance;

public class ScreenshotsMaker extends AbstractPage {
    public ScreenshotsMaker(WebDriver driver) {
        super(driver);
    }
    private static final String SCREENSHOTS_NAME_TPL = "screenshots/scr";

    public static ScreenshotsMaker makeScreenshot() {
        WebDriver driver = getWebDriverInstance();
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenshotName = SCREENSHOTS_NAME_TPL + System.nanoTime();
            File copy = new File(screenshotName + ".png");
            FileUtils.copyFile(screenshot, copy);
        } catch (IOException e) {

            e.printStackTrace();
        }
        return new ScreenshotsMaker(getWebDriverInstance());
    }
}
