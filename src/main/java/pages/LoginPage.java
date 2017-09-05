package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.business_objects.User;
import pages.utils.WebDriverSingleton;

import static pages.ComposePage.COMPOSE_BUTTON_LOCATOR;
import static pages.utils.WebDriverSingleton.getWebDriverInstance;


public class LoginPage {

    public static final By LOGIN_INPUT_FIELD_LOCATOR = By.xpath(".//*[@id='nb-1']/span/input");
    public static final By PASSWORD_INPUT_FIELD_LOCATOR = By.xpath(".//*[@id='nb-6']/span/input");
    public static final By LOGIN_BUTTON_LOCATOR = By.cssSelector(".nb-button._nb-action-button.nb-group-start");

//    public static void login(User user) {
//        WebDriverSingleton.getWebDriverInstance().get(user.getEmailUrl());
//        WebDriverSingleton.getWebDriverInstance().findElement(LoginPage.LOGIN_INPUT_FIELD_LOCATOR).sendKeys(user.getLogin());
//        AbstractPage.highlightElement(LoginPage.LOGIN_BUTTON_LOCATOR);
//        WebDriverSingleton.getWebDriverInstance().findElement(LoginPage.PASSWORD_INPUT_FIELD_LOCATOR).sendKeys(user.getPassword());
//        WebDriverSingleton.getWebDriverInstance().findElement(LoginPage.LOGIN_BUTTON_LOCATOR).click();
//    }
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
        Assert.assertTrue(userWasLoggedIn.isDisplayed(), "Usernot logged in");
        return new LoginPage();
    }
}
