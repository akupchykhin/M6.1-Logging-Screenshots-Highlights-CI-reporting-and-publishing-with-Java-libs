import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.business_objects.User;
import pages.business_objects.UserFactory;
import pages.utils.WebDriverSingleton;


@CucumberOptions(strict = true,
        plugin = { "json:target/cucumber-report.json","html:target/cucumber-report"  },
        features = "src/test/java/cucumber_features/")

public class YandexTestRunner extends AbstractTestNGCucumberTests{
}
