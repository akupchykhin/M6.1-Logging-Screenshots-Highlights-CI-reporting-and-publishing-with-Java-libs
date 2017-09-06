package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.utils.WebDriverSingleton;
import static pages.utils.WebDriverSingleton.getWebDriverInstance;

public class InboxPage extends AbstractPage {

    public static final By LOGOFF_SELECTOR_LOCATOR = By.xpath("//div[@class='mail-User-Name']");
    public static final By LOGOFF_BUTTON_LOCATOR = By.xpath("//a[@data-metric='Меню сервисов:Выход']");
    public static final String INBOX_PAGE_URL = "https://mail.yandex.by/?uid=512863941&login=yalogintest#inbox";

    public InboxPage(WebDriver driver) {
        super(driver);
    }

    public static HomePage logoff() {
        WebDriverSingleton.getWebDriverInstance().findElement(LOGOFF_SELECTOR_LOCATOR).click();
        WebDriverWait waitForLogoffButton = new WebDriverWait(WebDriverSingleton.getWebDriverInstance(), 2);
        waitForLogoffButton.until(ExpectedConditions.elementToBeClickable(LOGOFF_BUTTON_LOCATOR)).click();
        return new HomePage(WebDriverSingleton.getWebDriverInstance());
    }

    public static HomePage goToInboxPage() {
        getWebDriverInstance()
                .get(INBOX_PAGE_URL);
        AbstractPage.waitForElementEnabled(ComposePage.COMPOSE_BUTTON_LOCATOR);
        return new HomePage(getWebDriverInstance());
    }
}
