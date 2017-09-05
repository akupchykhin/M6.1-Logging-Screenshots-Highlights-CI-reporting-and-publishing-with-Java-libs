package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AbstractPage;
import pages.HomePage;
import pages.LoginPage;
import pages.business_objects.User;
import org.testng.Assert;
import pages.business_objects.UserFactory;
import sun.rmi.runtime.Log;

import static pages.ComposePage.*;
import static pages.HomePage.HOME_LOGO_LOCATOR;
import static pages.InboxPage.*;
import static pages.LoginPage.*;
import static pages.utils.WebDriverSingleton.getWebDriverInstance;

public class LoginAndLogoffStepDefinitions {

    User user = new UserFactory().createUser();

    @Given("^user on login page$")
    public void userOnLoginPage() {
        getWebDriverInstance()
                .get(user.getEmailUrl());
}

    @And("^user click on login button$")
    public void userClickOnLoginButton() {
        LoginPage.userClickOnLoginButton();
}

    @Then("^user is logged in$")
    public void userIsLoggedIn() {
        LoginPage.userWasLogInSuccessfully();
    }

    @When("^user click on logoff button$")
    public void userClickOnLogoffButton() {
        HomePage.clickLogOff();
    }

    @And("^confirm exit$")
    public void confirmExit() {
        HomePage.exitConfirmation();

    }

    @Then("^user logged out successfully$")
    public void userLoggedOutSuccessfully() {
        HomePage.userLoggedOutSuccessfullyConfirmation();
    }

    @When("^user fill login with (\\w+)$")
    public void userFillLogin(String login) {
        getWebDriverInstance()
                .findElement(LOGIN_INPUT_FIELD_LOCATOR)
                .sendKeys(login);
    }

    @And("^user fill password with (\\w+)$")
    public void userFillPassword(String password) {
        getWebDriverInstance()
                .findElement(PASSWORD_INPUT_FIELD_LOCATOR)
                .sendKeys(password);
    }
}
