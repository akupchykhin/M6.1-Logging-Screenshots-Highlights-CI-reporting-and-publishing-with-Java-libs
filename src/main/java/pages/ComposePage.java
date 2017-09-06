package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.utils.WebDriverSingleton;

import static pages.utils.WebDriverSingleton.getWebDriverInstance;

public class ComposePage extends AbstractPage{

    public static final By TO_FIELD_LOCATOR = By.cssSelector(".js-compose-field.mail-Bubbles");
    public static final By SUBJECT_FIELD_LOCATOR = By.cssSelector(".mail-Compose-Field-Input-Controller.js-compose-field.js-editor-tabfocus-prev");
    public static final By MESSAGE_BODY_FIELD_LOCATOR = By.xpath(".//*[@id='cke_1_contents']/div");
    public static final By AUTOSAVE_STATUS_LOCATOR = By.xpath("//span[@data-key='view=compose-autosave-status']");
    public static final By RESIZE_FIELD_ELEMENT_LOCATOR = By.cssSelector("#cke_1_resizer");
    public static final By DEFAULT_FIELD_FOR_SENDING_LOCATOR = By.xpath("//div[@role='textbox']");
    public static final By SENT_NOTIFICATION_LOCATOR = By.cssSelector(" .mail-Done-Title.js-title-info");
    public static final By COMPOSE_BUTTON_LOCATOR = By.cssSelector(".mail-ComposeButton-Text");
    public static final String INBOX_PAGE = "https://mail.yandex.by/?uid=512863941&login=yalogintest#inbox";


    public ComposePage(WebDriver webDriverInstance) {
        super(webDriverInstance);
    }

    public static ComposePage saveEmailAsDraft() {
        String saveButton = Keys.chord(Keys.CONTROL, "s");
        getWebDriverInstance().findElement(MESSAGE_BODY_FIELD_LOCATOR).sendKeys(saveButton);
        WebDriverWait waitForAutosaveStatusElement = new WebDriverWait(getWebDriverInstance(), 12);
        waitForAutosaveStatusElement.until(ExpectedConditions.visibilityOfElementLocated(AUTOSAVE_STATUS_LOCATOR));
        AbstractPage.waitForElementVisible(AUTOSAVE_STATUS_LOCATOR);
        return new ComposePage(getWebDriverInstance());
    }

    public static ComposePage sendTheEmail() {
        waitForElementEnabled(ComposePage.DEFAULT_FIELD_FOR_SENDING_LOCATOR);
        WebElement sendSaveButtons = WebDriverSingleton.getWebDriverInstance().findElement(ComposePage.DEFAULT_FIELD_FOR_SENDING_LOCATOR);
        new Actions(WebDriverSingleton.getWebDriverInstance()).sendKeys(sendSaveButtons,Keys.CONTROL, Keys.ENTER).build().perform();
        return new ComposePage(WebDriverSingleton.getWebDriverInstance());
    }

    public static ComposePage messageWasSendedNotificationAppears() {
        WebDriverWait waitForSentNotificationElement = new WebDriverWait(WebDriverSingleton.getWebDriverInstance(), 5);
        waitForSentNotificationElement.until(ExpectedConditions.visibilityOfElementLocated(ComposePage.SENT_NOTIFICATION_LOCATOR));
        return new ComposePage(WebDriverSingleton.getWebDriverInstance());
    }

    public static ComposePage clickOnComposeButton() {
        AbstractPage.waitForElementEnabled(ComposePage.COMPOSE_BUTTON_LOCATOR);
        AbstractPage.highlightElement(ComposePage.COMPOSE_BUTTON_LOCATOR);
        getWebDriverInstance().findElement(COMPOSE_BUTTON_LOCATOR).click();
        return new ComposePage(getWebDriverInstance());
    }
}
