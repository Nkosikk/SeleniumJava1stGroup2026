package Utilities;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadXLSXFile {

    public void readXLSXFile(String page) throws EncryptedDocumentException, IOException {
        String[][] data = getDataFromXLSXFile(page);

        for (String[] row : data) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public String[][] getDataFromXLSXFile(String excelSheet) throws EncryptedDocumentException, IOException {

        File file = new File(System.getProperty("user.dir") + "/src/test/resources/TestData/testdata.xlsx");

        try (FileInputStream fis = new FileInputStream(file);
             Workbook wb = WorkbookFactory.create(fis)) {

            Sheet sheet = wb.getSheet(excelSheet);

            if (sheet == null) {
                throw new RuntimeException("Sheet not found: " + excelSheet);
            }

            int totalRows = sheet.getLastRowNum();
            System.out.println("Total Rows: " + totalRows);

            // Ensure we have at least 1 data row (excluding header)
            int dataRows = totalRows; // Since we start from row 1
            if (dataRows < 1) {
                throw new RuntimeException("Excel sheet must have at least 1 data row (excluding header). Found: " + dataRows);
            }

            Row headerRow = sheet.getRow(0);
            if (headerRow == null) {
                throw new RuntimeException("Header row is missing in sheet: " + excelSheet);
            }

            int totalCols = headerRow.getLastCellNum();
            System.out.println("Total Columns: " + totalCols);
            System.out.println("Reading " + dataRows + " data rows from Excel sheet: " + excelSheet);

            DataFormatter formatter = new DataFormatter();
            String[][] testData = new String[totalRows][totalCols];

            for (int a = 1; a <= totalRows; a++) {
                Row currentRow = sheet.getRow(a);

                for (int b = 0; b < totalCols; b++) {
                    if (currentRow == null || currentRow.getCell(b) == null) {
                        testData[a - 1][b] = "";
                    } else {
                        testData[a - 1][b] = formatter.formatCellValue(currentRow.getCell(b));
                    }

                    System.out.println(testData[a - 1][b]);
                }
                System.out.println();
            }

            return testData;
        }
    }

    //Methods to use above returned excelfile
    @DataProvider(name = "loginData")
    public String[][] getLoginTestData() throws EncryptedDocumentException, IOException {
        return getDataFromXLSXFile("login");
    }


    @DataProvider(name = "learnData")
    public String[][] getLearnTestData() throws EncryptedDocumentException, IOException {
        return getDataFromXLSXFile("learn");
    }

    @DataProvider(name = "inventoryData")
    public String[][] getInventoryTestData() throws EncryptedDocumentException, IOException {
        return getDataFromXLSXFile("inventory");
    }

    @DataProvider(name = "shippingData")
    public String[][] getShippingTestData() throws EncryptedDocumentException, IOException {
        return getDataFromXLSXFile("shipping");
    }

    @DataProvider(name = "purchaseData")
    public String[][] getPurchaseTestData() throws EncryptedDocumentException, IOException {
        return getDataFromXLSXFile("purchase");
    }

    @DataProvider(name = "InvHisData")
    public String[][] getInvHistoryTestData() throws EncryptedDocumentException, IOException {
        return getDataFromXLSXFile("invHistory");
    }

}