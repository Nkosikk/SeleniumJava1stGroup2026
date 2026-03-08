package Tests;

import Base.BaseTest;
import Pages.*;
import Utilities.ReadXLSXFile;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestXslxAll extends BaseTest {

    //
    ReadXLSXFile readXLSXFile;
    LoginPage loginPage;
    LearnPage welcomePage;
    InventoryFormPage inv;
    ShippingPage shippingPage;
    PurchaseSuccessPage purchaseSuccessPage;
    InvoiceHistoryPage invoiceHistoryPage;

    // Initialize all page objects before any tests run
    @BeforeClass
    public void setUpAllPages() {
        // Initialize all page objects once
        loginPage = new LoginPage(driver);
        inv = new InventoryFormPage(driver);
        welcomePage = new LearnPage(driver);
        shippingPage = new ShippingPage(driver);
        purchaseSuccessPage = new PurchaseSuccessPage(driver);
        invoiceHistoryPage = new InvoiceHistoryPage(driver);
        readXLSXFile = new ReadXLSXFile();
    }

    // Test method to perform login using data from Excel sheet "loginData"
    @Test(dataProviderClass = ReadXLSXFile.class, dataProvider = "loginData")
    public void loginWithValidDetails(String email, String password, String expectedMessage) {
        loginPage.clickLoginButton();
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();
        loginPage.verifyLoginSuccess(expectedMessage);
    }

    // Test method to verify welcome page elements and text, depends on successful login, using data from Excel sheet "learnData"
    @Test(dependsOnMethods = "loginWithValidDetails", dataProviderClass = ReadXLSXFile.class, dataProvider = "learnData")
    public void TestWelcomePage(String expectedText) {
        welcomePage.learnDDButton();
        welcomePage.learningMatButton();
        welcomePage.landingPageText(expectedText);
    }

    // Test method to fill inventory form and verify details, depends on welcome page test, using data from Excel sheet "inventoryData"
    @Test(dependsOnMethods = "TestWelcomePage", dataProviderClass = ReadXLSXFile.class, dataProvider = "inventoryData")
    public void TestInventoryForm(String expectedTitle, String deviceType, String brand, String expectedBrandText,
                                  String expectedUPText, String color, String quantity, String address, String expectedSubTotal) throws IOException {
        inv.clickWebAutButton();
        inv.verifyInventoryFormTitle(expectedTitle);
        inv.selectDeviceType(deviceType);
        inv.selectBrand(brand);
        inv.verifyImagePreview(expectedBrandText);
        inv.selectStorage128GB();
        inv.verifyUnitPriceText(expectedUPText);
        inv.selectColor(color);
        inv.enterQuantity(quantity);
        inv.verifyQuantity(expectedSubTotal);
        inv.enterAddress(address);
        inv.clickNextButton();
    }

    // Test method to verify shipping page details, select shipping method, warranty, apply discount code, and confirm purchase, depends on inventory form test, using data from Excel sheet "shippingData"
    @Test(dependsOnMethods = "TestInventoryForm", dataProviderClass = ReadXLSXFile.class, dataProvider = "shippingData")
    public void TestShippingPage(String expectedShippingLabel, String expectedUPText, String expectedWarrantyPrice,
                                  String expectedWarrantyText, String discountCode, String expectedDiscountFBText,
                                  String expectedDiscountLabel, String expectedDiscountValue) throws IOException {
        shippingPage.verifyQuantity(expectedShippingLabel);
        shippingPage.selectShippingMethod();
        shippingPage.verifyUnitPriceText(expectedUPText);
        shippingPage.selectWarranty();
        shippingPage.verifyWarrantyLabel(expectedWarrantyText);
        shippingPage.verifyWarrantyPrice(expectedWarrantyPrice);
        shippingPage.enterDiscountCode(discountCode);
        shippingPage.clickApplyDiscount();
        shippingPage.verifyDiscountFeedback(expectedDiscountFBText);
        shippingPage.verifyDiscountLabel(expectedDiscountLabel);
        shippingPage.verifyDiscountValue(expectedDiscountValue);
        shippingPage.clickConfirmPurchase();
    }

    // Test method to verify purchase success details, order details, total amount, and navigate to invoice history, depends on shipping page test, using data from Excel sheet "purchaseData"
    @Test(dependsOnMethods = "TestShippingPage", dataProviderClass = ReadXLSXFile.class, dataProvider = "purchaseData")
    public void TestPurchaseSuccessPage(String expectedSuccessMessage, String expectedOrderDetails, String expectedtotalAmount) throws IOException {
        purchaseSuccessPage.verifyPurchaseSuccessToastHeader(expectedSuccessMessage);
        purchaseSuccessPage.verifyOrderDetails(expectedOrderDetails);
        purchaseSuccessPage.verifyTotalAmount(expectedtotalAmount);
        purchaseSuccessPage.clickViewHistoryButton();
    }

    // Test method to verify invoice history page title and view invoice details, depends on purchase success page test, using data from Excel sheet "InvHisData"
    @Test(dependsOnMethods = "TestPurchaseSuccessPage", dataProviderClass = ReadXLSXFile.class, dataProvider = "InvHisData")
    public void TestInvoiceHistoryPage(String expectedInvoiceHistoryTitle) throws IOException {
        invoiceHistoryPage.verifyInvoiceHistoryTitle(expectedInvoiceHistoryTitle);
        invoiceHistoryPage.clickViewInvoiceButton();
    }


}

