package pages.services;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.ComposePage;
import pages.business_objects.Letter;
import static pages.AbstractPage.*;
import static pages.utils.WebDriverSingleton.getWebDriverInstance;

public class LetterService {

    public static void newEmailCreation(Letter letter) {
        waitForElementEnabled(ComposePage.COMPOSE_BUTTON_LOCATOR);
        highlightElement(ComposePage.COMPOSE_BUTTON_LOCATOR);
        getWebDriverInstance().findElement(ComposePage.COMPOSE_BUTTON_LOCATOR).click();
        getWebDriverInstance().findElement(ComposePage.TO_FIELD_LOCATOR).sendKeys(letter.getAddress());
        getWebDriverInstance().findElement(ComposePage.SUBJECT_FIELD_LOCATOR).sendKeys(letter.getSubject());
        getWebDriverInstance().findElement(ComposePage.MESSAGE_BODY_FIELD_LOCATOR).sendKeys(letter.getBody());
        waitForElementVisible(ComposePage.RESIZE_FIELD_ELEMENT_LOCATOR);
        WebElement resize = getWebDriverInstance().findElement(ComposePage.RESIZE_FIELD_ELEMENT_LOCATOR);
        new Actions(getWebDriverInstance()).clickAndHold(resize).moveByOffset(150, -1500).release().build().perform();
    }
}
