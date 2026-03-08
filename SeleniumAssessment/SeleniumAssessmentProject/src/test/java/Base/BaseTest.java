package Base;

import Utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    // Static WebDriver instance to be shared across all test classes
    protected static WebDriver driver;

    // Initialize the WebDriver before any tests run
    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        if (driver == null) {
            driver = BrowserFactory.startBrowser();
        }
    }

    // Clean up and close the WebDriver after all tests have run
    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            BrowserFactory.closeBrowser();
            driver = null;
        }
    }
}
