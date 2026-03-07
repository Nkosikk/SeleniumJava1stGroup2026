package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class InventoryFormPage {

    WebDriverWait wait;

    //1. Constructor to initialize WebDriver and WebDriverWait
    public InventoryFormPage(WebDriver driver) {
        //LoginPage loginPage = new LoginPage(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    //2. Web Automation Advance button element
    @FindBy(xpath = "//*[@id=\"tab-btn-web\"]")
    WebElement webAutomationAdButton;

    // Method to click Web Automation Advance button
    public  void clickWebAutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(webAutomationAdButton)).click();
    }

    //2. Inventory form element
    @FindBy(id = "inventory-title")
    WebElement inventoryFormTitle;

    // Method to verify inventory form title
    public  void verifyInventoryFormTitle(String expectedTitle) {
        wait.until(ExpectedConditions.visibilityOf(inventoryFormTitle));
        String actualTitle = inventoryFormTitle.getText();
        if (!actualTitle.equals(expectedTitle)) {
            throw new AssertionError("Expected message: " + expectedTitle + ", but got: " + actualTitle);
        }
    }

    //3. Device Type dropdown element
    @FindBy(id = "deviceType")
    WebElement deviceTypeDropdown;

    // Method to select device type from dropdown
    public void  selectDeviceType(String deviceType) {
        Select device = new Select(deviceTypeDropdown);
        device.selectByVisibleText(deviceType);
    }

    //4. Brand dropdown element
    @FindBy(id = "brand")
    WebElement brandDropdown;

    // Method to select brand from dropdown
    public void selectBrand(String brand) {
        Select device = new Select(brandDropdown);
        device.selectByVisibleText(brand);
    }


    //4. Brand preview image element
    @FindBy(xpath = "//img[@alt='Apple phone']")
    WebElement phoneImage;

    // Method to verify Brand Preview displayed
    public  void verifyImagePreview(String expectedBrandText) {
        wait.until(ExpectedConditions.visibilityOf(phoneImage));
        if (!phoneImage.isDisplayed()) {
            throw new AssertionError("Expected image preview for brand: " + expectedBrandText + " is not displayed.");
        }
    }

    //5. Storage options elements
    @FindBy(id = "storage-128GB")
    WebElement storage128GBOption;

    // Method to select storage option
    public void selectStorage128GB() {
        wait.until(ExpectedConditions.elementToBeClickable(storage128GBOption)).click();
    }

    //5. Unit price display element
    @FindBy(id = "unit-price-value")
    WebElement unitPriceValue;

    // Method to verify Unit Price displayed
    public void verifyUnitPriceText(String expectedUPText) {
        wait.until(ExpectedConditions.visibilityOf(unitPriceValue));
        String actualText = unitPriceValue.getText();
        if (!actualText.equals(expectedUPText)) {
            throw new AssertionError("Expected message: " + expectedUPText + ", but got: " + actualText);
        }
    }

    //6. Color dropdown element
    @FindBy(id = "color")
    WebElement colorDropdown;

    // Method to select color from dropdown
    public void selectColor(String color) {
        Select colorSelect = new Select(colorDropdown);
        colorSelect.selectByVisibleText(color);
    }

    //7. Quantity input field element
    @FindBy(id = "quantity")
    WebElement quantityInput;

    // Method to enter quantity
    public void enterQuantity(String quantity) {
        wait.until(ExpectedConditions.visibilityOf(quantityInput));
        quantityInput.sendKeys(quantity);
    }

    //7. Subtotal element
    @FindBy(id="subtotal-value")
    WebElement subtotalValue;

    //7. Method to verify Unit Price displayed
    public  void verifyQuantity(String expectedSubTotal) {
        wait.until(ExpectedConditions.visibilityOf(subtotalValue));
        String actualText = subtotalValue.getText();
        if (!actualText.equals(expectedSubTotal)) {
            throw new AssertionError("Expected message: " + expectedSubTotal + ", but got: " + actualText);
        }
    }

    //8. Address input field element
    @FindBy(id = "address")
    WebElement addressInput;

    // Method to enter address
    public void enterAddress(String address) {
        wait.until(ExpectedConditions.visibilityOf(addressInput));
        addressInput.sendKeys(address);
    }

    //9. Next button element
    @FindBy(id = "inventory-next-btn")
    WebElement nextButton;

    // Method to click Next button
    public void clickNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }
}
