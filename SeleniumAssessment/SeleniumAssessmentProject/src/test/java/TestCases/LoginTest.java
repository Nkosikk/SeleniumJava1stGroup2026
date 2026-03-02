package TestCases;


import Base.BaseTest;
import LoginPage.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void setUpLoginPage() {
        loginPage = new LoginPage();
    }

    @Test(dataProvider = "testData")
    public void loginWithValidDetails(String email, String password, String expectedMessage) throws InterruptedException{
        loginPage.clickLoginButton();
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();
        loginPage.verifyLoginSuccess(expectedMessage);
    }

    @DataProvider(name = "testData")
    public Object[][] getLoginData() {
        return new Object[][]{
                {"testerrm@gmail.com", "Tester2026!", "Here's an overview of your learning journey"},
        };
    }

}
