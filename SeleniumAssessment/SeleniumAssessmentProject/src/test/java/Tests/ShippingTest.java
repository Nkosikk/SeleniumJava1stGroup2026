package Tests;

import Base.BaseTest;
import Pages.ShippingPage;
import Utilities.ReadXLSXFile;
import org.testng.annotations.Test;

import java.io.IOException;

public class ShippingTest extends BaseTest {


    // Test method to verify shipping page details, select shipping method, warranty, apply discount code, and confirm purchase, depends on inventory form test, using data from Excel sheet "shippingData"
    //@Test(dependsOnMethods = "Tests.InventoryFormTest.TestInventoryForm", dataProviderClass = ReadXLSXFile.class, dataProvider = "shippingData")
    @Test(dataProviderClass = ReadXLSXFile.class, dataProvider = "shippingData")
    public void TestShippingPage(String expectedShippingLabel, String expectedUPText, String expectedWarrantyPrice,
                                 String expectedWarrantyText, String discountCode, String expectedDiscountFBText,
                                 String expectedDiscountLabel, String expectedDiscountValue) throws IOException {
        ShippingPage shippingPage = new ShippingPage(driver);
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
}
