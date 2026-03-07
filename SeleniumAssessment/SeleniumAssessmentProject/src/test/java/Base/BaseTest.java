package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

    // Set up the WebDriver before any tests are run
    @BeforeClass
    public void setUp() throws IOException {

        if (driver == null) {
            frprop = new FileReader(System.getProperty("user.dir") + "/src/test/resources/configfiles/config.properties");
            frloc = new FileReader(System.getProperty("user.dir") + "/src/test/resources/configfiles/locators.properties");

            prop.load(frprop);
            locators.load(frloc);

        }

        if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(prop.getProperty("testurl"));
            //driver.manage().window().maximize();
        }

    }




    // Close the browser after all tests in the class are done
    @AfterClass
    public void tearDown() {

       /*
       if (driver != null) {
            driver.quit();
            driver = null;
        }

        */
    }




}
