package Base;

import Pages.LocatorTask;
import Pages.LoginPage;
import Utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseTest {
    BrowserFactory browserFactory = new BrowserFactory();

     public final String url = "https://ndosisimplifiedautomation.vercel.app/";
     public final String browserChoice = "chrome";

     public final WebDriver driver = browserFactory.startBrowser(browserChoice, url);

     //Call my pages
     public LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    public LocatorTask locatorTask = PageFactory.initElements(driver, LocatorTask.class);

}
