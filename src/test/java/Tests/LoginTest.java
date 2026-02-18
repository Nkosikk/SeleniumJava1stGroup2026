package Tests;

import Base.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test
    public void loginWithValidDetails() throws InterruptedException {

        loginPage.clickLoginButton();
            Thread.sleep(2000);
        loginPage.enterEmailAddress("aveetestuser@gmail.com");
        loginPage.enterPassword("Testing123456!");
        Thread.sleep(2000);
        loginPage.clickSubmitButton();
        Thread.sleep(3000);
        loginPage.verifyLoginSuccess("Welcome back, Avela! \uD83D\uDC4B");
    }
}
