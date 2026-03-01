package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocatorTask {
    @FindBy(xpath = "//button[contains(@class, 'nav-dropdown-trigger') and .//span[contains(text(), 'My Learning')]]")
    public WebElement myLearningButton;

    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[4]/div/button[2]")
    WebElement myCoursesButton;

    //Verify my course button is working
    @FindBy(xpath = "//*[@id='app-main-content']/div/div[1]/h1")
    WebElement myEnrolments;

    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/button[3]")
    WebElement testimonialsButton;

    //Methods to interact with the elements
    //Method to click the My Learning button

    public void clickMyLearningButton() {
        myLearningButton.click();
    }

    //Method to click the My Courses button
    public void clickMyCoursesButton() {
        myCoursesButton.click();
    }

    //Verifying method
    public void verifyMyEnrolmentsDisplayed(String expectedText) {
        myEnrolments.isDisplayed();
        String actualText = myEnrolments.getText();

        // Compare the actual message with the expected message and throw an assertion error if they do not match
        if (!actualText.equals(expectedText)) {
            throw new AssertionError("Expected text: '" + expectedText + "', but got: '" + actualText + "'");
        }
    }

    //Method to click the My Courses button
    public void clicktestimonialsButton() {
        testimonialsButton.click();
    }

    //Verifying method
    public void verifytestimonialsButton(String expectedText) {
        testimonialsButton.isDisplayed();
        String actualText = testimonialsButton.getText();

    }
}

