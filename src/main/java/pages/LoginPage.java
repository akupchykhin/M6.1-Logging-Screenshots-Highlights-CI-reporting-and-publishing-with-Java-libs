package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import static pages.ComposePage.*;
import static pages.utils.WebDriverSingleton.getWebDriverInstance;


public class LoginPage {

    public static final By LOGIN_INPUT_FIELD_LOCATOR = By.xpath(".//*[@id='nb-1']/span/input");
    public static final By PASSWORD_INPUT_FIELD_LOCATOR = By.xpath(".//*[@id='nb-6']/span/input");
    public static final By LOGIN_BUTTON_LOCATOR = By.cssSelector(".nb-button._nb-action-button.nb-group-start");

    public static LoginPage userClickOnLoginButton() {
        AbstractPage.highlightElement(LOGIN_BUTTON_LOCATOR);
        getWebDriverInstance()
                .findElement(LOGIN_BUTTON_LOCATOR)
                .click();
        return new LoginPage();
    }
    public static LoginPage userWasLogInSuccessfully() {
        WebElement userWasLoggedIn = getWebDriverInstance()
                .findElement(COMPOSE_BUTTON_LOCATOR);
        return new LoginPage();
    }
}
