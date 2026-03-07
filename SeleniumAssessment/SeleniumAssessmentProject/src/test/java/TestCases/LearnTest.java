package TestCases;

import Base.BaseTest;
import Pages.LearnPage;
import Utilities.ReadXLSXFile;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LearnTest extends BaseTest {


    LearnPage learnPage;

    @Test(dependsOnMethods = "TestCases.LoginTest.loginWithValidDetails", dataProviderClass = ReadXLSXFile.class, dataProvider = "learnData")
    public void learnPageTest(String expectedText) {
        learnPage.learnDDButton();
        learnPage.learningMatButton();
        learnPage.landingPageText(expectedText);
    }
}
