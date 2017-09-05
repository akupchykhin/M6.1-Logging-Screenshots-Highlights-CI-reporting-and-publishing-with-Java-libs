package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.utils.WebDriverSingleton;

import static pages.utils.WebDriverSingleton.getWebDriverInstance;

public class SentPage extends AbstractPage {

    public static final String SENT_PAGE_URL = "https://mail.yandex.by/?uid=512863941&login=yalogintest#sent";
    public static final By SENDED_ELEMENT_LOCATOR = By.cssSelector(".mail-MessageSnippet-FromText");
    public static final By SENT_FOLDER_ELEMENT_LOCATOR = By.cssSelector(".b-mail-pager__label");
    public static final By RECEIVER_NAME = By.cssSelector(".mail-MessageSnippet-FromText");
    public static final String RECEIVER  = "test2.asd@yandex.ru";

    public SentPage(WebDriver driver) {
        super(driver);
    }

    public static SentPage goToSentPage() {
        getWebDriverInstance().get(SENT_PAGE_URL);
        WebElement sentFolderElement = getWebDriverInstance().findElement(SENT_FOLDER_ELEMENT_LOCATOR);
        Assert.assertTrue(sentFolderElement.isDisplayed(), "Cannot reach sent folder");
        return new SentPage(getWebDriverInstance());
    }

    public static SentPage verifyThatEmailIsInSentFolder() {
        waitForElementEnabled(SENDED_ELEMENT_LOCATOR);
        WebElement emailIsInSent = WebDriverSingleton.getWebDriverInstance().findElement(SENDED_ELEMENT_LOCATOR);
        Assert.assertTrue(emailIsInSent.isDisplayed(), "Email  not in sent folder");
        return new SentPage(getWebDriverInstance());
    }
}
