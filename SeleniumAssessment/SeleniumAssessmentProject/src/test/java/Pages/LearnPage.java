package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LearnPage {


    WebDriverWait wait;

    public LearnPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/button")
    WebElement learnDDButton;

    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/div/button[2]/span[2]")
    WebElement learningMatDDButton;

    @FindBy(xpath = "//section[@id='practice-section']/p")
    WebElement landingPageText;


    //Clicks on the "Learn" dropdown button in the navigation bar and Waits until the button is clickable before performing the click action.
    public  void learnDDButton() {
        wait.until(ExpectedConditions.elementToBeClickable(learnDDButton)).click();
    }

    //Clicks on the "Learning Materials" button in the dropdown menu and Waits until the button is clickable before performing the click action.
    public void learningMatButton() {
        wait.until(ExpectedConditions.elementToBeClickable(learningMatDDButton)).click();
    }

    // Verifies that the text on the landing page matches the expected text. It waits until the text element is visible, retrieves the actual text, and compares it to the expected text. If they do not match, an AssertionError is thrown with a message indicating the expected and actual text.
    public void landingPageText(String expectedText){
        wait.until(ExpectedConditions.visibilityOf(landingPageText));
        String actualText = landingPageText.getText();
        if (!actualText.equals(expectedText)) {
            throw new AssertionError("Expected text: " + expectedText + ", but got: " + actualText);
        }
    }

}
