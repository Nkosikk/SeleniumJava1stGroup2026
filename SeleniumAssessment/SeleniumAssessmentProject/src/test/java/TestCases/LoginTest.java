package TestCases;


import Base.BaseTest;
import LoginPage.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest  extends BaseTest {

    LoginPage loginPage;

    @BeforeClass
    public void setUpLoginPage() {
        loginPage = new LoginPage(BaseTest.driver);
    }

    @Test(dataProvider = "testData")
    public void loginWithValidDetails(String email, String password, String expectedMessage){
        loginPage.clickLoginButton();
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();
        loginPage.verifyLoginSuccess(expectedMessage);
    }

    @DataProvider(name = "testData")
    public Object[][] getLoginData() {
        return new Object[][]{
                {"testerref@nsa.com", "Tester2026!", "Here's an overview of your learning journey"},
        };
    }

}
