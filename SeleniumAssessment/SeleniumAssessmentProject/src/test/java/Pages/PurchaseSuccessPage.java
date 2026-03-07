package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PurchaseSuccessPage {


    WebDriverWait wait;

    public  PurchaseSuccessPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }


    //13. Purchase Success Pop up Elements
    @FindBy(xpath = "//*[@id=\"purchase-success-toast\"]/div[1]/h4")
    WebElement purchaseSuccessToastHeader;

    // Method to verify Success toast header
    public void verifyPurchaseSuccessToastHeader(String expectedSuccessToastHeader) {
        wait.until(ExpectedConditions.visibilityOf(purchaseSuccessToastHeader));
        String actualText = purchaseSuccessToastHeader.getText();
        if (!actualText.equals(expectedSuccessToastHeader)) {
            throw new AssertionError("Expected message: " + expectedSuccessToastHeader + ", but got: " + actualText);
        }
    }

    // Order Details Elements
    @FindBy(xpath = "//div[@id='purchase-success-toast']/div[2]/p")
    WebElement orderDetails;

    // Method to verify Order Details
    public void verifyOrderDetails(String expectedOrderDetails) {
        wait.until(ExpectedConditions.visibilityOf(orderDetails));
        String actualText = orderDetails.getText();
        if (!actualText.equals(expectedOrderDetails)) {
            throw new AssertionError("Expected message: " + expectedOrderDetails + ", but got: " + actualText);
        }
    }

    //Total Amount Elements
    @FindBy(xpath = "//div[@id='purchase-success-toast']/p[2]")
    WebElement totalAmount;

    // Method to verify Order Details
    public void verifyTotalAmount(String expectedTotalAmount) {
        wait.until(ExpectedConditions.visibilityOf(totalAmount));
        String actualText = totalAmount.getText();
        if (!actualText.equals(expectedTotalAmount)) {
            throw new AssertionError("Expected message: " + expectedTotalAmount + ", but got: " + actualText);
        }
    }


    // View History Button Element
    @FindBy(id = "view-history-btn")
    WebElement viewHistoryButton;

    // Method to click View History Button
    public void clickViewHistoryButton() {
        wait.until(ExpectedConditions.elementToBeClickable(viewHistoryButton)).click();
    }







}
