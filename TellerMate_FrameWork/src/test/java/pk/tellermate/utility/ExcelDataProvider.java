/**
 * 
 */
package pk.tellermate.utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author saif.khan
 *
 */
public class ExcelDataProvider 
{
	XSSFWorkbook wb;
	XSSFSheet sheet;

	//	Constructor 
	public ExcelDataProvider()
	{
		try {
			File res = new File(".\\TestData\\testData.xlsx");
			FileInputStream fis = new FileInputStream(res);

			//		Load the Workbook
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to load file" + e.getMessage());
		}
	}
	
	// To read String Data from SheetName
	public String getStringData(String sheet, int row, int col){
		
		return wb.getSheet(sheet).getRow(row).getCell(col).getStringCellValue();
	}
	// To read String Data from SheetNumber
	public String getStringData(int sheetIndex, int row, int col){
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
	}
	
	// To read Numeric Data
	public double getNumericData(String sheetName, int row, int col) {
		return wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
		
	}
}
