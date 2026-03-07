package TestCases;

import Base.BaseTest;
import Pages.InventoryFormPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InventoryFormTest extends BaseTest {

    InventoryFormPage inventoryFormPage;

    @BeforeClass
    public void setUpPages() {
        inventoryFormPage = new InventoryFormPage(driver);
    }

    @Test()
    public void fillInventoryForm() {

    }
}
