package pages.business_objects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.ComposePage;

import static pages.AbstractPage.highlightElement;
import static pages.AbstractPage.waitForElementEnabled;
import static pages.AbstractPage.waitForElementVisible;
import static pages.utils.WebDriverSingleton.getWebDriverInstance;

public class LetterBuilder {

    private Letter letter = new Letter();

    public LetterBuilder address(String address) {
        letter.setAddress(address);
        return this;
    }

    public LetterBuilder subject(String subject) {
        letter.setSubject(subject);
        return this;
    }

    public LetterBuilder body(String body) {
        letter.setAddress(body);
        return this;
    }

    public Letter build() {
        return letter;
    }



}
