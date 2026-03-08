package Tests;

import Base.BaseTest;
import Pages.InventoryFormPage;
import Pages.PurchaseSuccessPage;
import Utilities.ReadXLSXFile;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class PurchaseSuccessTest extends BaseTest {


    // Test method to verify purchase success page text, using data from Excel sheet "purchaseData"
    @Test( dataProviderClass = ReadXLSXFile.class, dataProvider = "purchaseData")
    //@Test(dependsOnMethods = "Tests.ShippingTest.TestShippingPage", dataProviderClass = ReadXLSXFile.class, dataProvider = "purchaseData")
    public void TestPurchaseSuccessPage(String expectedSuccessMessage, String expectedOrderDetails, String expectedtotalAmount) throws IOException {
        PurchaseSuccessPage purchaseSuccessPage = new PurchaseSuccessPage(driver);
        purchaseSuccessPage.verifyPurchaseSuccessToastHeader(expectedSuccessMessage);
        purchaseSuccessPage.verifyOrderDetails(expectedOrderDetails);
        purchaseSuccessPage.verifyTotalAmount(expectedtotalAmount);
        purchaseSuccessPage.clickViewHistoryButton();
    }


}
