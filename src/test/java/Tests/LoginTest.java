package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test(priority = 1)
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

    @Test
    public void signUpButtonShouldBeVisible() {
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isSignUpVisible(), "Sign Up button should be visible on the login page.");
    }

    @Test
    public void showPasswordButtonShouldBeVisible() {
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isShowPasswordVisible(), "Show password button should be visible on the login page.");
    }

    @Test
    public void forgotPasswordLinkShouldBeVisible() {
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isForgotPasswordVisible(), "Forgot password link should be visible on the login page.");
    }

    @Test
    public void loginHeadingShouldBeVisible() {
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isLoginHeadingVisible(), "Login heading should be visible on the login page.");
    }

    @Test
    public void navigationBarShouldBeVisible() {
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isNavigationBarVisible(), "Navigation bar should be visible on the login page.");
        Assert.assertEquals(loginPage.getNavigationBarText(),"\uD83C\uDFE0 Home \uD83D\uDCD6 About Us ⭐ Testimonials \uD83D\uDCDA Learn ▼ \uD83D\uDC65 Community ▼ \uD83D\uDD17 Connect ▼");
    }
}
