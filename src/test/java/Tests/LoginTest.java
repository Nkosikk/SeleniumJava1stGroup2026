package Test;

import Base.BaseTest;
import Utilities.ReadXSLdata;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test(priority = 0)
    public void clickLoginButton() {
        loginPageWithWaits.clickLoginButton();
        screenshots.takesSnapShot(driver,"clickLoginButton");
    }

    @Test(dataProviderClass = ReadXSLdata.class, dataProvider = "testData", priority = 1)
    public void enterUsernameAndPassword(String email, String password) {
        loginPageWithWaits.enterEmailAddress(email);
        loginPageWithWaits.enterPassword(password);
        screenshots.takesSnapShot(driver,"enterUsernameAndPassword");
    }

    @Test(priority = 2)
    public void clickSubmitButton() {
        loginPageWithWaits.clickSubmitButton();
    }

    @Test(priority = 3)
    public void verifyLoginSuccess() {
        loginPageWithWaits.verifyLoginSuccess("Here's an overview of your learning journey");
        screenshots.takesSnapShot(driver,"verifyLoginSuccess");
    }
    @Test(priority = 4)
    public void verifyLoginPageTitle() {
        String expectedTitle = "Ndosi Test Automation";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title doesn't match!");
        screenshots.takesSnapShot(driver,"verifyLoginPageTitle");
    }

}


