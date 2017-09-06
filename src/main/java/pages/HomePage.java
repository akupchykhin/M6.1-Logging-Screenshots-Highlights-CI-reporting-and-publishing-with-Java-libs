package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.utils.WebDriverSingleton;

import static pages.InboxPage.LOGOFF_BUTTON_LOCATOR;
import static pages.InboxPage.LOGOFF_SELECTOR_LOCATOR;
import static pages.utils.WebDriverSingleton.getWebDriverInstance;

public class HomePage extends AbstractPage {

    public static final By HOME_LOGO_LOCATOR = By.cssSelector(".home-logo__default");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static HomePage userOnHomePageVerify() {
        waitForElementPresent(HOME_LOGO_LOCATOR);
        LOGGER.warn("User on home page");
        return new HomePage(WebDriverSingleton.getWebDriverInstance());
    }
    public static HomePage clickLogOff() {
        LOGGER.info("Click on logoff selector");
        WebDriverWait waitForLogoffButton = new WebDriverWait(getWebDriverInstance(), 5);
        waitForLogoffButton.until(ExpectedConditions.elementToBeClickable(LOGOFF_SELECTOR_LOCATOR)).click();
        return new HomePage(getWebDriverInstance());
    }

    public static HomePage exitConfirmation() {
        LOGGER.info("confirm logoff");
        WebDriverWait waitForLogoffButton = new WebDriverWait(getWebDriverInstance(), 5);
        waitForLogoffButton.until(ExpectedConditions.elementToBeClickable(LOGOFF_BUTTON_LOCATOR)).click();
        LOGGER.warn("User was logged out");
        return new HomePage(getWebDriverInstance());
    }

    public static HomePage userLoggedOutSuccessfullyConfirmation() {
        WebElement userLoggedOut = getWebDriverInstance().findElement(HOME_LOGO_LOCATOR);
        return new HomePage(getWebDriverInstance());
    }
}
