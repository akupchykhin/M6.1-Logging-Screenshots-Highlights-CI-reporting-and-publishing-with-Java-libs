package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ComposePage;
import pages.DraftsPage;



public class SaveAndSendStepDefinitions {
    @When("^user go to drafts folder$")
    public void userGoToDraftsFolder() {
        DraftsPage.draftUrl();
    }

    @And("^user send the email by pressing send button$")
    public void userSendTheEmailByPressingSendButton() {
        ComposePage.sendTheEmail();
    }

    @Then("^message was sent notification appears$")
    public void messageWasSendedNotificationAppears() {
        ComposePage.messageWasSendedNotificationAppears();
    }
}
