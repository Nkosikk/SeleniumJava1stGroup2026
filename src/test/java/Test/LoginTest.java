package Test;

import Base.BaseTest;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {



    @Test
    public void loginWithValidDetails() throws InterruptedException {

loginPage.clickLoginButton();
loginPage.enterEmailAddress("azania@gmail.com");
loginPage.enterPassword("Newlands@12345");
loginPage.clickSubmitButton();

Thread.sleep(3000);

loginPage.verifyLoginSuccess("Welcome back, Boika! \uD83D\uDC4B");


        


    }


}
