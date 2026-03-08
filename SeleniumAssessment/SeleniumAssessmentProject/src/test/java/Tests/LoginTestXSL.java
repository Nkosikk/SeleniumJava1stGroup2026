package Tests;


import Base.BaseTest;
import Pages.LoginPage;
import Utilities.ReadXLSXFile;
import org.testng.annotations.Test;

import java.io.IOException;


public class LoginTestXSL extends BaseTest {


    // Test method to verify login functionality with valid details, using data from Excel sheet "loginData"
    @Test(dataProviderClass = ReadXLSXFile.class, dataProvider = "loginData")
    public void loginWithValidDetails(String email, String password, String expectedMessage) throws IOException {
       LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();
        loginPage.verifyLoginSuccess(expectedMessage);
    }
}
