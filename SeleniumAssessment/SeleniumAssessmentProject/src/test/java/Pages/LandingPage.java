package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {


    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"practice-section\"]/p/text()")
    WebElement landingPageText;

    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/button")
    WebElement learnDDButton;

    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/div/button[2]/span[2]")
    WebElement learningMatDDButton;


    public  void learnDDButton() {
        wait.until(ExpectedConditions.elementToBeClickable(learnDDButton)).click();
    }

    public void learningMatButton() {
        wait.until(ExpectedConditions.elementToBeClickable(learningMatDDButton)).click();
    }

    public void landingPageText(String expectedText){
        wait.until(ExpectedConditions.visibilityOf(landingPageText));
        String actualText = landingPageText.getText();
        if (!actualText.equals(expectedText)) {
            throw new AssertionError("Expected text: " + expectedText + ", but got: " + actualText);
        }
    }

}
