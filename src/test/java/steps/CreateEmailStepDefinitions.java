package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ComposePage;
import pages.DraftsPage;
import pages.InboxPage;
import pages.business_objects.Letter;
import pages.business_objects.LetterFactory;

import static pages.ComposePage.*;
import static pages.utils.WebDriverSingleton.getWebDriverInstance;

public class CreateEmailStepDefinitions {

    @When("^user click on Compose button$")
    public void userClickOnComposeButton() {
        ComposePage.clickOnComposeButton();
    }

    @And("^fill receiver$")
    public void fillReceiver() {
        Letter letter = new LetterFactory().defaultLetter();
        getWebDriverInstance().findElement(TO_FIELD_LOCATOR).sendKeys(letter.getAddress());
    }
    
    @And("^fill subject$")
    public void fillSubject() {
        Letter letter = new LetterFactory().defaultLetter();
        getWebDriverInstance().findElement(SUBJECT_FIELD_LOCATOR).sendKeys(letter.getSubject());
    }

    @And("^fill message body$")
    public void fillMessageBody() {
        Letter letter = new LetterFactory().defaultLetter();
        getWebDriverInstance().findElement(MESSAGE_BODY_FIELD_LOCATOR).sendKeys(letter.getBody());
    }

    @And("^save en email as draft$")
    public void saveEnEmailAsDraft() {
        ComposePage.saveEmailAsDraft();
    }

    @Then("^an email is saved in draft folder$")
    public void anEmailIsSavedInDraftFolder(){
        DraftsPage.findAnEmailInDraftFolder();
    }

    @When("^user go to inbox page$")
    public void userGoToInboxPage() {
        InboxPage.goToInboxPage();
    }
}
