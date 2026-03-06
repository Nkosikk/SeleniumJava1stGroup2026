package TestCases;

import org.testng.annotations.Test;

public class LandingPageTest {

    @Test(priority = 1)
    public void learnDDSelectable() {
        landingPage.learnDDButton();
    }

    @Test(priority = 2)
    public void learningMatSelectable() {
        landingpage.learningMatDDButton();
    }

    @Test(dataProvider = "testdata", priority = 3)
    public void verifyLandingPageText(String expectedText) {
        landingPage.verifyLandingPageText(expectedText);
    }
}
