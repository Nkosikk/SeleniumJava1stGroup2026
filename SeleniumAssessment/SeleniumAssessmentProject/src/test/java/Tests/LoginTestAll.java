package Tests;


import Base.BaseTest;
import Pages.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;


public class LoginTestAll extends BaseTest {


    LoginPage loginPage;
    LearnPage welcomePage;
    InventoryFormPage inv;
    ShippingPage shippingPage;
    PurchaseSuccessPage purchaseSuccessPage;
    InvoiceHistoryPage invoiceHistoryPage;

    // Initialize all page objects before any tests run
    @BeforeClass
    public void setUpLoginPage() {
        loginPage = new LoginPage(driver);
        inv = new InventoryFormPage(driver);
        welcomePage = new LearnPage(driver);
        shippingPage = new ShippingPage(driver);
        purchaseSuccessPage = new PurchaseSuccessPage(driver);
        invoiceHistoryPage = new InvoiceHistoryPage(driver);

    }


    // Test method to perform login using data from data provider "testData"
    @Test(dataProvider = "testData")
    public void loginWithValidDetails(String email, String password, String expectedMessage){
        loginPage.clickLoginButton();
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();
        loginPage.verifyLoginSuccess(expectedMessage);
    }

    // Test method to verify welcome page elements and text, depends on successful login, using data from data provider "testData2"
    @Test(dependsOnMethods = "loginWithValidDetails", dataProvider = "testData2")
    public void TestWelcomePage(String expectedText) {
        welcomePage.learnDDButton();
        welcomePage.learningMatButton();
        welcomePage.landingPageText(expectedText);
    }

    // Test method to fill inventory form and verify details, depends on welcome page test, using data from data provider "testData3"
    @Test(dependsOnMethods = "TestWelcomePage", dataProvider = "testData3")
    public void TestInventoryForm(String expectedTitle, String deviceType, String brand, String expectedBrandText
                                  ,String expectedUPText, String color, String quantity, String address, String expectedSubTotal) throws IOException {
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

    // Test method to verify shipping page details, select shipping method and warranty, apply discount code, and confirm purchase, depends on inventory form test, using data from data provider "testData4"
    @Test(dependsOnMethods = "TestInventoryForm", dataProvider = "testData4")
    public void TestShippingPage(String expectedShippingLabel, String expectedUPText, String expectedWarrantyPrice
                                  , String expectedWarrantyText, String discountCode, String expectedDiscountFBText
                                  , String expectedDiscountLabel, String expectedDiscountValue) throws IOException{
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

    // Test method to verify purchase success page details, order details, total amount, and navigate to invoice history, depends on shipping page test, using data from data provider "testData5"
    @Test(dependsOnMethods = "TestShippingPage", dataProvider = "testData5")
    public void TestPurchaseSuccessPage(String expectedSuccessMessage, String expectedOrderDetails, String expectedtotalAmount) throws IOException{
        purchaseSuccessPage.verifyPurchaseSuccessToastHeader(expectedSuccessMessage);
        purchaseSuccessPage.verifyOrderDetails(expectedOrderDetails);
        purchaseSuccessPage.verifyTotalAmount(expectedtotalAmount);
        purchaseSuccessPage.clickViewHistoryButton();

    }

    // Test method to verify invoice history page title and view invoice details, depends on purchase success page test, using data from data provider "testData6"
    @Test(dependsOnMethods = "TestPurchaseSuccessPage", dataProvider = "testData6")
    public void TestInvoiceHistoryPage(String expectedInvoiceHistoryTitle) throws IOException
    {
        invoiceHistoryPage.verifyInvoiceHistoryTitle(expectedInvoiceHistoryTitle);
        invoiceHistoryPage.clickViewInvoiceButton();
    }


    @DataProvider(name = "testData6")
    public Object[][] getInvoiceHistoryData() {
        return new Object[][]{
                {"\uD83D\uDCC4 Invoice History"},
        };
    }

    @DataProvider(name = "testData5")
    public Object[][] getPSPData() {
        return new Object[][]{
                {"ORDER SUCCESSFUL! \uD83C\uDF89", "Order Details:\n" +
                        "2 x Apple, phone, 128GB, blue, express ship, 1yr warranty",
                        "Total: R930.60"
                },

        };
    }

    @DataProvider(name = "testData4")
    public Object[][] getShData() {
        return new Object[][]{
                {"Shipping Method", "R25.00", "R49.00", "Warranty", "SAVE10", "Code SAVE10 applied: -10%", "Discount (10%)", "- R103.40"},
        };
    }



    @DataProvider(name = "testData")
    public Object[][] getLoginData() {
        return new Object[][]{
                {"testerref@nsa.com", "Tester2026!", "Here's an overview of your learning journey"},
        };
    }



    @DataProvider(name = "testData2")
    public Object[][] getWelData() {
        return new Object[][]{
                {"Ready to practice, Tester? Choose a category below to sharpen your automation skills!"},
        };
    }

    @DataProvider(name = "testData3")
    public Object[][] getInvfData() {
        return new Object[][]{
                {"Inventory Form", "Phone", "Apple", "Apple", "R480.00", "Blue", "2", "123 Test Street", "R960.00"},
        };
    }






}
