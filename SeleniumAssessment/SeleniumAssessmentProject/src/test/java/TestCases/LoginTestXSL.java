package TestCases;


import Base.BaseTest;
import Pages.LoginPage;
import Utilities.ReadXLSXFile;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginTestXSL extends BaseTest {

    LoginPage loginPage;

    @BeforeClass
    public void setUpLoginPage() {
        loginPage = new LoginPage(driver);
    }

    @Test()
    public void clickLoginBTN() {
        loginPage.clickLoginButton();
    }

    @Test(dependsOnMethods = "clickLoginBTN", dataProviderClass = ReadXLSXFile.class, dataProvider = "loginData")
    public void loginTest(String email, String password) {
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
    }

    @Test(dependsOnMethods = "loginTest")
    public void clickSubmitButton() {
        loginPage.clickSubmitButton();
    }
}
