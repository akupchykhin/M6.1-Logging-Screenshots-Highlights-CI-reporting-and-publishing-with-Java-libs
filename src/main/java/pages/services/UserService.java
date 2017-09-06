package pages.services;

import pages.LoginPage;
import pages.business_objects.User;

import static pages.AbstractPage.LOGGER;
import static pages.AbstractPage.highlightElement;
import static pages.utils.WebDriverSingleton.getWebDriverInstance;


public class UserService {

    public static void login(User user) {
        LOGGER.info("Trying to login");
        getWebDriverInstance().get(user.getEmailUrl());
        getWebDriverInstance().findElement(LoginPage.LOGIN_INPUT_FIELD_LOCATOR).sendKeys(user.getLogin());
        highlightElement(LoginPage.LOGIN_BUTTON_LOCATOR);
        getWebDriverInstance().findElement(LoginPage.PASSWORD_INPUT_FIELD_LOCATOR).sendKeys(user.getPassword());
        getWebDriverInstance().findElement(LoginPage.LOGIN_BUTTON_LOCATOR).click();
        LOGGER.warn("User was logged in");
    }
}
