package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;
    public static Properties prop = new Properties();
    public static Properties locators = new Properties();
    public static FileReader frprop;
    public static FileReader frloc;

    // Set up the WebDriver before any tests in the class are run
    @BeforeClass
    public void setUp() throws IOException {

        if (driver == null) {
            frprop = new FileReader("/Users/refilwemakume/Documents/Assessment/SeleniumAssessment/SeleniumAssessmentProject/src/test/resources/configfiles/config.properties");
            frloc = new FileReader("/Users/refilwemakume/Documents/Assessment/SeleniumAssessment/SeleniumAssessmentProject/src/test/resources/configfiles/locators.properties");

            prop.load(frprop);
            locators.load(frloc);

        }

        if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(prop.getProperty("testurl"));
        }
        else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get(prop.getProperty("testurl"));
        }
        else if (prop.getProperty("browser").equalsIgnoreCase("safari"))
        {
            // SafariDriver is provided by the Safari browser on macOS and typically does not require WebDriverManager
            driver = new SafariDriver();
            driver.get(prop.getProperty("testurl"));
        }
        else if (prop.getProperty("browser").equalsIgnoreCase("edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.get(prop.getProperty("testurl"));
        }
        else {
            System.out.println("Browser name is not correct");
        }
    }

    // Close the browser after all tests in the class are done
   /* @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


    */
}
