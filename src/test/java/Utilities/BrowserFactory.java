package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
    static WebDriver driver;

    public static WebDriver startBrowser(String browserChoice, String url){
        if(browserChoice.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if (browserChoice.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browserChoice.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserChoice.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else {
            System.out.println("Invalid browser name");
        }
        return driver;
    }



}
