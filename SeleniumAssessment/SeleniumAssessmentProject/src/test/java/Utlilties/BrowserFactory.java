package Utlilties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    static WebDriver driver;

    //Open browser with either chrome, firefox or edge and navigate to the url
    public static WebDriver startBrowser(String browserName, String url) {
        if (browserName.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
           // driver = BrowserFactoryChrome.startChromeDriver(url);
        }
        else if (browserName.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
           // driver = BrowserFactoryFirefox.startFirefoxDriver(url);
        }
        else if (browserName.equalsIgnoreCase("safari"))
        {
            driver = new SafariDriver();
            // driver = BrowserFactoryFirefox.startFirefoxDriver(url);
        }
        else if (browserName.equalsIgnoreCase("edge"))
        {
            driver = new EdgeDriver();
            //driver = BrowserFactoryEdge.startEdgeDriver(url);
        }
        else
        {
            System.out.println("Browser name is not correct");
        }
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    //Close the browser
    public void closeBrowser() {
        if (driver != null
        ) {
            driver.close();
        }

    }

}
