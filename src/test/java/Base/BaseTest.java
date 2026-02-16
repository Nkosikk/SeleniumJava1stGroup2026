package Base;

import Utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    BrowserFactory browserFactory = new BrowserFactory();

     public final String url = "https://www.ndosiautomation.co.za/";
     public final String browserChoice = "chrome";

     public final WebDriver driver = browserFactory.startBrowser(browserChoice, url);
}
