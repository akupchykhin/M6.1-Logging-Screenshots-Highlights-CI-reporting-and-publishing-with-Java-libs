package steps;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.SentPage;

public class ChecksStepDefinisions {
    @When("^user go to sent page")
    public void userGoToSentFolder() throws InterruptedException {
        SentPage.goToSentPage();
    }

    @Then("^an email is in sent folder$")
    public void anEmailIsInSentFolder() {
        SentPage.verifyThatEmailIsInSentFolder();
    }
}
