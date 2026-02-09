import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class loginToNdosiWebSite {

    WebDriver driver;

    @Test
    public void loginWithValidDetailsb() throws InterruptedException {

        driver= new ChromeDriver();
        driver.get("https://ndosisimplifiedautomation.vercel.app/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[3]/button/span[2]")).click();
        driver.findElement(By.id("login-email")).sendKeys("nkosi@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("@12345678");
        driver.findElement(By.id("login-submit")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"app-main-content\"]/section/div[1]/h2")).isDisplayed();

        String myCoursesText = driver.findElement(By.xpath("//*[@id=\"app-main-content\"]/section/div[1]/h2")).getText();
        System.out.println(myCoursesText);
        Assert.assertEquals(myCoursesText,"Welcome back, Nkosingiphile! \uD83D\uDC4B");

    }
    @Test(dependsOnMethods = "loginWithValidDetailsb")
    public void loginWithValidDetailsa() throws InterruptedException {

        driver= new ChromeDriver();
        driver.get("https://ndosisimplifiedautomation.vercel.app/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[3]/button/span[2]")).click();
        driver.findElement(By.id("login-email")).sendKeys("nkosi@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("@12345678");
        driver.findElement(By.id("login-submit")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"app-main-content\"]/section/div[1]/h2")).isDisplayed();


        String myCoursesText = driver.findElement(By.xpath("//*[@id=\"app-main-content\"]/section/div[1]/h2")).getText();
        System.out.println(myCoursesText);
        Assert.assertEquals(myCoursesText,"Welcome back, Nkosingiphile! \uD83D\uDC4B");

    }

    @Test(priority = 1)
    public void loginWithValidDetailsafff() throws InterruptedException {

        driver= new ChromeDriver();
        driver.get("https://ndosisimplifiedautomation.vercel.app/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[3]/button/span[2]")).click();
        driver.findElement(By.id("login-email")).sendKeys("nkosi@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("@12345678");
        driver.findElement(By.id("login-submit")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"app-main-content\"]/section/div[1]/h2")).isDisplayed();


        String myCoursesText = driver.findElement(By.xpath("//*[@id=\"app-main-content\"]/section/div[1]/h2")).getText();
        System.out.println(myCoursesText);
        Assert.assertEquals(myCoursesText,"Welcome back, Nkosingiphile! \uD83D\uDC4B");

    }

}
