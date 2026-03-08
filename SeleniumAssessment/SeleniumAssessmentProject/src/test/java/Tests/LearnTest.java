package Tests;

import Base.BaseTest;
import Pages.LearnPage;
import Utilities.ReadXLSXFile;
import org.testng.annotations.Test;

public class LearnTest extends BaseTest {


   // @Test(dependsOnMethods = "Tests.LoginTestXSL.loginWithValidDetails", dataProviderClass = ReadXLSXFile.class, dataProvider = "learnData")
    //Method to verify learn page text, depends on successful login, using data from Excel sheet "learnData"
    @Test(dataProviderClass = ReadXLSXFile.class, dataProvider = "learnData")
    public void TestLearnPage(String expectedText) throws InterruptedException{
        LearnPage learnPage = new LearnPage(driver);
        learnPage.learnDDButton();
        learnPage.learningMatButton();
        learnPage.landingPageText(expectedText);
    }

}
