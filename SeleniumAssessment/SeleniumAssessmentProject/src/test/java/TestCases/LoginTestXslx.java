package TestCases;

import Base.BaseTest;
import Pages.*;
import Utilities.ReadXLSXFile;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestXslx extends BaseTest {

    ReadXLSXFile readXLSXFile;
    LoginPage loginPage;
    LearnPage welcomePage;
    InventoryFormPage inv;
    ShippingPage shippingPage;
    PurchaseSuccessPage purchaseSuccessPage;
    InvoiceHistoryPage invoiceHistoryPage;

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

    @Test(dataProviderClass = ReadXLSXFile.class, dataProvider = "loginData")
    public void loginWithValidDetails(String email, String password, String expectedMessage) {
        loginPage.clickLoginButton();
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();
        loginPage.verifyLoginSuccess(expectedMessage);
    }

    @Test(dependsOnMethods = "loginWithValidDetails", dataProviderClass = ReadXLSXFile.class, dataProvider = "learnData")
    public void TestWelcomePage(String expectedText) {
        welcomePage.learnDDButton();
        welcomePage.learningMatButton();
        welcomePage.landingPageText(expectedText);
    }

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

    @Test(dependsOnMethods = "TestShippingPage", dataProviderClass = ReadXLSXFile.class, dataProvider = "purchaseData")
    public void TestPurchaseSuccessPage(String expectedSuccessMessage, String expectedOrderDetails, String expectedtotalAmount) throws IOException {
        purchaseSuccessPage.verifyPurchaseSuccessToastHeader(expectedSuccessMessage);
        purchaseSuccessPage.verifyOrderDetails(expectedOrderDetails);
        purchaseSuccessPage.verifyTotalAmount(expectedtotalAmount);
        purchaseSuccessPage.clickViewHistoryButton();
    }

    @Test(dependsOnMethods = "TestPurchaseSuccessPage", dataProviderClass = ReadXLSXFile.class, dataProvider = "InvHisData")
    public void TestInvoiceHistoryPage(String expectedInvoiceHistoryTitle) throws IOException {
        invoiceHistoryPage.verifyInvoiceHistoryTitle(expectedInvoiceHistoryTitle);
        invoiceHistoryPage.clickViewInvoiceButton();
    }


}

