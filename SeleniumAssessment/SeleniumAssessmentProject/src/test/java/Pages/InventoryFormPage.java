package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryFormPage {

    @FindBy(xpath = "//*[@id=\"tab-btn-web\"]")
    WebElement webAutomationAdButton;

    @FindBy(id = "inventory-title")
    WebElement inventoryFormTitle;

    @FindBy(id = "deviceType")
    WebElement deviceTypeDropdown;

    @FindBy(xpath = "//*[@id=\"deviceType\"]/option[2]")
    WebElement phoneOption;

    @FindBy(css = "div > svg > rect:nth-child(2)")
    WebElement phoneImage;

    @FindBy(id = "brand")
    WebElement brandDropdown;

    @FindBy(xpath = "//*[@id=\"brand\"]/option[2]")
    WebElement appleOption;

    @FindBy(css = "#device-preview > div > div > div:nth-child(2)")
    WebElement appleImage;

    @FindBy(id = "storage-128GB")
    WebElement storage128GBOption;

    @FindBy(id = "color")
    WebElement colorDropdown;

    @FindBy(id = "quantity")
    WebElement quantityInput;

    @FindBy(id = "address")
    WebElement addressInput;

    @FindBy(xpath = "//span[contains(.,'R480.00')]")
    WebElement initialUnitPrice;

    @FindBy(xpath = "//label[contains(.,'Qty: 2')]")
    WebElement quantityLabel;

    @FindBy(id = "inventory-next-btn")
    WebElement nextButton;

    @FindBy(xpath = "//*[@id=\"shipping-label\"]")
    WebElement shippingLabel;

    @FindBy(id = "shipping-express")
    WebElement expressShippingRadioBtn;

    @FindBy(id = "warranty-1yr")
    WebElement warranty1YrRadioBtn;



}
