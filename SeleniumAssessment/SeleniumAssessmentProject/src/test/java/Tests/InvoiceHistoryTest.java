package Tests;

import Base.BaseTest;
import Pages.InvoiceHistoryPage;
import Pages.ShippingPage;
import Utilities.ReadXLSXFile;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class InvoiceHistoryTest extends BaseTest {


    // Test method to verify invoice history page title and view invoice details, depends on purchase success page test, using data from Excel sheet "InvHisData"
    @Test(dependsOnMethods = "Tests.PurchaseSuccessTest.TestPurchaseSuccessPage", dataProviderClass = ReadXLSXFile.class, dataProvider = "InvHisData")
    //@Test(dataProviderClass = ReadXLSXFile.class, dataProvider = "InvHisData")
    public void TestInvoiceHistoryPage(String expectedInvoiceHistoryTitle) throws IOException {
        InvoiceHistoryPage invoiceHistoryPage = new InvoiceHistoryPage(driver);
        invoiceHistoryPage.verifyInvoiceHistoryTitle(expectedInvoiceHistoryTitle);
        invoiceHistoryPage.clickViewInvoiceButton();
    }


}

