package Tests;

import Base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {


    @Test(dataProvider = "testdata")
    public void loginWithValidDetails(String email,String password) throws InterruptedException {

        loginPage.clickLoginButton();
        Thread.sleep(2000);
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
        Thread.sleep(2000);
        loginPage.clickSubmitButton();
        Thread.sleep(5000);
        loginPage.verifyLoginSuccess("Welcome back, Avela! \uD83D\uDC4B");

    }

    @DataProvider(name = "testdata")
    public Object[][] getData() {
        return new Object[][]{
                {"aveetestuser@gmail.com", "Testing123456!"},
                {"Funda@gmail.com", "Funda@2026"},
                {"Kingmolebatsi2@gmail.com", "!2345678"},
                {"tumi@dima.com", "123@4567"}
        };
    }
}


