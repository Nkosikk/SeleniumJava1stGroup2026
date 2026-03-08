package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

public class ShippingPage {

    WebDriverWait wait;

    //1. Constructor to initialize WebDriver and WebDriverWait
    public ShippingPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    //10. Shipping Page Elements
    @FindBy(xpath = "//*[@id=\"shipping-label\"]")
    WebElement shippingLabel;

    // Method to verify shipping label
    public  void verifyQuantity(String expectedShippingLabel) {
        wait.until(ExpectedConditions.visibilityOf(shippingLabel));
        String actualText = shippingLabel.getText();
        if (!actualText.equals(expectedShippingLabel)) {
            throw new AssertionError("Expected message: " + expectedShippingLabel + ", but got: " + actualText);
        }
    }

    //10. Shipping options radio button elements
    @FindBy(id = "shipping-express")
    WebElement expressShippingRadioBtn;

    // Method to select shipping option
    public void selectShippingMethod() {
        wait.until(ExpectedConditions.elementToBeClickable(expressShippingRadioBtn)).click();
    }

    //10. Shipping fee element
    @FindBy(id = "breakdown-shipping-value")
    WebElement shippingFeeValue;

    // Method to verify Unit Price displayed
    public void verifyUnitPriceText(String expectedUPText) {
        wait.until(ExpectedConditions.visibilityOf(shippingFeeValue));
        String actualText = shippingFeeValue.getText();
        if (!actualText.equals(expectedUPText)) {
            throw new AssertionError("Expected message: " + expectedUPText + ", but got: " + actualText);
        }
    }

    //11. Warranty options radio button elements
    @FindBy(id = "warranty-1yr")
    WebElement warranty1YrRadioBtn;

    // Method to select warranty option
    public void selectWarranty() {
        wait.until(ExpectedConditions.elementToBeClickable(warranty1YrRadioBtn)).click();
    }

    //11. Warranty label element
    @FindBy(id = "breakdown-warranty-label")
    WebElement warrantyLabel;

    // Method to verify Warranty Label is displayed
    public void verifyWarrantyLabel(String expectedWarrantyText) {
        wait.until(ExpectedConditions.visibilityOf(warrantyLabel));
        String actualText = warrantyLabel.getText();
        if (!actualText.equals(expectedWarrantyText)) {
            throw new AssertionError("Expected message: " + expectedWarrantyText + ", but got: " + actualText);
        }
    }

    //11. Warranty fee element
    @FindBy(id = "breakdown-warranty-value")
    WebElement warrantyFeeValue;


    // Method to verify Warranty Price displayed
    public void verifyWarrantyPrice(String expectedWarrantyText) {
        wait.until(ExpectedConditions.visibilityOf(warrantyFeeValue));
        String actualText = warrantyFeeValue.getText();
        if (!actualText.equals(expectedWarrantyText)) {
            throw new AssertionError("Expected message: " + expectedWarrantyText + ", but got: " + actualText);
        }
    }

    //12. Discount code input field element
    @FindBy(id="discount-code")
    WebElement discountCodeInput;

    public  void enterDiscountCode(String discountCode) {
        wait.until(ExpectedConditions.visibilityOf(discountCodeInput)).sendKeys(discountCode);
    }

    //12. Apply button element
    @FindBy(id = "apply-discount-btn")
    WebElement applyDiscountButton;

    // Method to select warranty option
    public void clickApplyDiscount() {
        wait.until(ExpectedConditions.elementToBeClickable(applyDiscountButton)).click();
    }

    //12. Discount feedback message element
    @FindBy(id="discount-feedback")
    WebElement discountFeedbackMessage;


    // Method to verify Warranty Price displayed
    public void verifyDiscountFeedback(String expectedDiscountFBText) {
        wait.until(ExpectedConditions.visibilityOf(discountFeedbackMessage));
        String actualText = discountFeedbackMessage.getText();
        if (!actualText.equals(expectedDiscountFBText)) {
            throw new AssertionError("Expected message: " + expectedDiscountFBText + ", but got: " + actualText);
        }
    }

    //12. Discount label element
    @FindBy(id="breakdown-discount-label")
    WebElement discountLabel;

    // Method to verify Warranty Price displayed
    public void verifyDiscountLabel(String expectedDiscountLabel) {
        wait.until(ExpectedConditions.visibilityOf(discountLabel));
        String actualText = discountLabel.getText();
        if (!actualText.equals(expectedDiscountLabel)) {
            throw new AssertionError("Expected message: " + expectedDiscountLabel + ", but got: " + actualText);
        }
    }

    //12. Discount value element
    @FindBy(id="breakdown-discount-value")
    WebElement discountValue;


    // Method to verify Warranty Price displayed
    public void verifyDiscountValue(String expectedDiscountValue) {
        wait.until(ExpectedConditions.visibilityOf(discountValue));
        String actualText = discountValue.getText();
        if (!actualText.equals(expectedDiscountValue)) {
            throw new AssertionError("Expected message: " + expectedDiscountValue + ", but got: " + actualText);
        }
    }

    //13. Confirm Purchase button element
    @FindBy(id="purchase-device-btn")
    WebElement purchaseDeviceButton;

    // Method to click Confirm Purchase button
    public void clickConfirmPurchase() {
        wait.until(ExpectedConditions.elementToBeClickable(purchaseDeviceButton)).click();
    }

}
