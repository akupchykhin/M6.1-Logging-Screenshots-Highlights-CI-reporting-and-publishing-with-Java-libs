package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.utils.WebDriverSingleton;

import static pages.utils.WebDriverSingleton.getWebDriverInstance;

public class DraftsPage extends AbstractPage {

    public static final String GO_TO_DRAFT_URL = "https://mail.yandex.by/?uid=512863941&login=yalogintest#draft";
    public static final By EMAIL_IN_DRAFT_FOLDER_LOCATOR = By.cssSelector(".mail-MessageSnippet-Item.mail-MessageSnippet-Item_body.js-message-snippet-body");
    public static final By BUBBLE_BLOCK_TEXT_LOCATOR = By.className("mail-Bubble-Block_text");
    public static final String RECEIVER  = "test2.asd@yandex.ru";

    public DraftsPage(WebDriver driver) {
        super(driver);
    }

    public static DraftsPage draftUrl() {
        WebDriverSingleton.getWebDriverInstance().get(GO_TO_DRAFT_URL);
        return new DraftsPage(WebDriverSingleton.getWebDriverInstance());
    }

    public static DraftsPage findAnEmailInDraftFolder() {
        getWebDriverInstance().get(GO_TO_DRAFT_URL);
//        WebElement emailIsInSent = getWebDriverInstance().findElement(EMAIL_IN_DRAFT_FOLDER_LOCATOR);
//        Assert.assertTrue(emailIsInSent.isDisplayed(), "Email was not sent");
        return new DraftsPage(getWebDriverInstance());
    }
}
