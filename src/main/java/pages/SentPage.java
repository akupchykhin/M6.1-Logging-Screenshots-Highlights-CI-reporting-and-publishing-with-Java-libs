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
        LOGGER.info("Go to sent page");
        getWebDriverInstance().get(SENT_PAGE_URL);
        WebElement sentFolderElement = getWebDriverInstance().findElement(SENT_FOLDER_ELEMENT_LOCATOR);
        return new SentPage(getWebDriverInstance());
    }

    public static SentPage verifyThatEmailIsInSentFolder() {
        LOGGER.info("Is email in sent folder?");
        waitForElementEnabled(SENDED_ELEMENT_LOCATOR);
        WebElement emailIsInSent = WebDriverSingleton.getWebDriverInstance().findElement(SENDED_ELEMENT_LOCATOR);
        LOGGER.info("Yes!");
        return new SentPage(getWebDriverInstance());
    }
}
