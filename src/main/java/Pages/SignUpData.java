package Pages;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class SignUpData {

	@DataProvider (name ="signup-data")
	public static Object[][] getLoginData() throws IOException {
	    String excelPath = "TestData\\Testdata.xlsx";
	    String sheetName = "src\\main\\java\\Pages\\SignUpData.java";
	    String[] columnsToRetrieve = {"Username", "Password", "Day", "FirstName"}; // specify column names

	    FileInputStream file = new FileInputStream(excelPath);
	    XSSFWorkbook workbook = new XSSFWorkbook(file);
	    XSSFSheet sheet = workbook.getSheet(sheetName);

	    int rowCount = sheet.getLastRowNum(); // get last row number
	    int colCount = columnsToRetrieve.length; // set column count
	    
	    System.out.println("Row count: " + rowCount);
	    System.out.println("Column count: " + colCount);

	    Object[][] data = new Object[rowCount][colCount];

	    XSSFRow headerRow = sheet.getRow(0);
	    int[] columnIndex = new int[colCount];
	    for (int i = 0; i < colCount; i++) {
	        String columnName = columnsToRetrieve[i];
	        XSSFCell cell = headerRow.getCell(i);

	        if (cell != null && cell.getCellType() == CellType.STRING) {
	            String headerCellValue = cell.getStringCellValue();
	            if (headerCellValue.equalsIgnoreCase(columnName)) {
	                columnIndex[i] = cell.getColumnIndex();
	            }
	        }
	    }

	    for (int i = 1; i <= rowCount; i++) {
	        XSSFRow row = sheet.getRow(i);

	        if (row == null) {
	            continue; // skip null rows
	        }

	        for (int j = 0; j < colCount; j++) {
	            XSSFCell cell = row.getCell(columnIndex[j]);

	            switch (cell.getCellType()) {
	                case STRING:
	                    data[i-1][j] = cell.getStringCellValue();
	                    break;
	                case NUMERIC:
	                    data[i-1][j]= String.valueOf((int) cell.getNumericCellValue());
	                    break;
	                case BOOLEAN:
	                    data[i-1][j] = cell.getBooleanCellValue();
	                    break;
	                default:
	                    data[i-1][j] = null;
	            }
	        }
	    }

	    workbook.close();
	    file.close();

	    return data;
	}

}
