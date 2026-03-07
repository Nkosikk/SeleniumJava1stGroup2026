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
    WebDriver driver;

    public LearnPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/button")
    WebElement learnDDButton;

    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/div/button[2]/span[2]")
    WebElement learningMatDDButton;

    @FindBy(xpath = "//section[@id='practice-section']/p")
    WebElement landingPageText;


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
