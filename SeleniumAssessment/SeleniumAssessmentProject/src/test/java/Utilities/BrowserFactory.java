package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    private static WebDriver driver;

    public static WebDriver startBrowser() {
        if (driver != null) {
            // reuse existing session
            return driver;
        }

        String browserName = ReadPropertyFile.getProperty("browser");
        String url = ReadPropertyFile.getProperty("testurl");

        if ("chrome".equalsIgnoreCase(browserName)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browserName)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if ("safari".equalsIgnoreCase(browserName)) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        } else if ("edge".equalsIgnoreCase(browserName)) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }

        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }

}
