package Pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvoiceHistoryPage {

    WebDriverWait wait;

    // Constructor to initialize WebDriverWait and PageFactory
    public  InvoiceHistoryPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    //14. Invoice History Page Title Elements
    @FindBy(id="invoice-history-title")
    WebElement invoiceHistoryTitle;

    public void verifyInvoiceHistoryTitle(String expectedIHTitle) {
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf(invoiceHistoryTitle));
        String actualText = invoiceHistoryTitle.getText();
        if (!actualText.equals(expectedIHTitle)) {
            throw new AssertionError("Expected title: " + expectedIHTitle + ", but got: " + actualText);
        }
    }

    //15. View Invoice Button Elements
    @FindBy(xpath="//div[2]/div/div[3]/button")
    WebElement viewInvoiceButton;

    //Method to click the View Invoice Button
    public void clickViewInvoiceButton() {
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(viewInvoiceButton)).click();
    }

}
