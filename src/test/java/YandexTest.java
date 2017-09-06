import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import pages.business_objects.*;
import pages.services.LetterService;
import pages.services.UserService;
import pages.utils.DriverDecorator;
import pages.utils.ScreenshotsMaker;
import pages.utils.WebDriverSingleton;

import static pages.utils.WebDriverSingleton.getWebDriverInstance;

public class YandexTest {
    private static final Logger LOGGER = Logger.getLogger(ComposePage.class.getSimpleName());


    @BeforeMethod(description = "Start browser")
     public void browserStart() {
        getWebDriverInstance();
    }

    @BeforeMethod
    public void login() {
        User user = new UserFactory().createUser();
        UserService.login(user);
    }

    @AfterMethod
    public void driverClose() {
        WebDriverSingleton.kill();
    }

    @Test(description = "Create a new mail and save it as draft")
    public void newMailCreation() {
        Letter letter = new LetterFactory().defaultLetter();
        LetterService.newEmailCreation(letter);
        ComposePage.saveEmailAsDraft();
        ScreenshotsMaker.makeScreenshot();
        WebElement emailWasCreated = getWebDriverInstance().findElement(ComposePage.AUTOSAVE_STATUS_LOCATOR);
        Assert.assertTrue(emailWasCreated.isDisplayed(), "Email was not created");
}

    @Test(description = "Verify, that the mail presents in ‘Drafts’ folder")
    public void emailInDraftVerify() throws Exception {
        Letter letter = new LetterFactory().defaultLetter();
        LetterService.newEmailCreation(letter);
        DraftsPage.draftUrl();
        String emailInDraft = getWebDriverInstance().findElement(DraftsPage.BUBBLE_BLOCK_TEXT_LOCATOR).getText();
        Assert.assertEquals(emailInDraft, DraftsPage.RECEIVER, "Email not in Drafts folder");
        ScreenshotsMaker.makeScreenshot();
    }

    @Test(description = "Send the mail")
    public void sendTheEmail() throws Exception {
        Letter letter = new LetterFactory().defaultLetter();
        LetterService.newEmailCreation(letter);
        ComposePage.sendTheEmail();
        WebElement emaisWasSent = getWebDriverInstance().findElement(ComposePage.SENT_NOTIFICATION_LOCATOR);
        Assert.assertTrue(emaisWasSent.isDisplayed(), "Email was not sent");
        ScreenshotsMaker.makeScreenshot();
    }

    @Test(description = "Verify, that the mail is in ‘Sent’ folder.")
    public void emailIsInSent() throws Exception {
        Letter letter = new LetterFactory().defaultLetter();
        LetterService.newEmailCreation(letter);
        ComposePage.sendTheEmail();
        SentPage.goToSentPage().verifyThatEmailIsInSentFolder();
        String emailIsInSent = getWebDriverInstance().findElement(SentPage.RECEIVER_NAME).getText();
        Assert.assertEquals(emailIsInSent, SentPage.RECEIVER, "Email not in Sent folder");
        ScreenshotsMaker.makeScreenshot();
    }

    @Test(description = "Log off")
    public void logOff() {
        getWebDriverInstance().getTitle();
        InboxPage.logoff();
        HomePage.userOnHomePageVerify();
        WebElement userLoggedOut = getWebDriverInstance().findElement(HomePage.HOME_LOGO_LOCATOR);
        Assert.assertTrue(userLoggedOut.isDisplayed(), "User can not log out");
        ScreenshotsMaker.makeScreenshot();
    }
}