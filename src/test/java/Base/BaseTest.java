package Base;

import Utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    BrowserFactory browserFactory = new BrowserFactory();

    public final String URL = "https://ndosisimplifiedautomation.vercel.app/";
    public final String browserChoice = "chrome";

    public final WebDriver driver = browserFactory.startBrowser(browserChoice, URL);

}
