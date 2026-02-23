package Base;

import Pages.LoginPage;
import Utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BaseTest {

    BrowserFactory browserFactory = new BrowserFactory();
    public final String url = "https://ndosisimplifiedautomation.vercel.app/";
    public final String browserChoice = "chrome";

    public WebDriver driver; // initialized per test
    public LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = browserFactory.startBrowser(browserChoice, url);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @AfterMethod
    public void tearDown() {
        browserFactory.closeBrowser();
    }

}
