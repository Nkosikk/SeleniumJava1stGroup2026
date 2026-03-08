package Tests;

import Base.BaseTest;
import Pages.InventoryFormPage;
import Utilities.ReadXLSXFile;
import org.testng.annotations.Test;

import java.io.IOException;

public class InventoryFormTest extends BaseTest {

    //@Test(dependsOnMethods = "Tests.LearnTest.TestLearnPage", dataProviderClass = ReadXLSXFile.class, dataProvider = "inventoryData")
    // Test method to fill inventory form and verify details, depends on welcome page test, using data from Excel sheet "inventoryData"
    @Test( dataProviderClass = ReadXLSXFile.class, dataProvider = "inventoryData")
    public void TestInventoryForm(String expectedTitle, String deviceType, String brand, String expectedBrandText,
                                  String expectedUPText, String color, String quantity, String address, String expectedSubTotal) throws IOException {
        InventoryFormPage inv = new InventoryFormPage(driver);
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
}
