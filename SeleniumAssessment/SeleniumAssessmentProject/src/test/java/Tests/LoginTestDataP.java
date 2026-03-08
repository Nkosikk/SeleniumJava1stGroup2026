package Tests;


import Base.BaseTest;
import Pages.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;


public class LoginTestDataP extends BaseTest {

    //region Test Login
    LoginPage loginPage;
    LearnPage learnPage;
    InventoryFormPage inv;
    ShippingPage shippingPage;
    PurchaseSuccessPage purchaseSuccessPage;
    InvoiceHistoryPage invoiceHistoryPage;

    @BeforeClass
    public void setUpLoginPage() {
        loginPage = new LoginPage(driver);
        inv = new InventoryFormPage(driver);
        learnPage = new LearnPage(driver);
        shippingPage = new ShippingPage(driver);
        purchaseSuccessPage = new PurchaseSuccessPage(driver);
        invoiceHistoryPage = new InvoiceHistoryPage(driver);

    }


    @Test(dataProvider = "testData")
    public void loginWithValidDetails(String email, String password, String expectedMessage){
        loginPage.clickLoginButton();
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();
        loginPage.verifyLoginSuccess(expectedMessage);
    }

    @Test(dependsOnMethods = "loginWithValidDetails", dataProvider = "testData2")
    public void TestLearnPage(String expectedText) {
        learnPage.learnDDButton();
        learnPage.learningMatButton();
        learnPage.landingPageText(expectedText);
    }


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

    @Test(dependsOnMethods = "TestShippingPage", dataProvider = "testData5")
    public void TestPurchaseSuccessPage(String expectedSuccessMessage, String expectedOrderDetails, String expectedtotalAmount) throws IOException{
        purchaseSuccessPage.verifyPurchaseSuccessToastHeader(expectedSuccessMessage);
        purchaseSuccessPage.verifyOrderDetails(expectedOrderDetails);
        purchaseSuccessPage.verifyTotalAmount(expectedtotalAmount);
        purchaseSuccessPage.clickViewHistoryButton();

    }

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
    //endregion





}
