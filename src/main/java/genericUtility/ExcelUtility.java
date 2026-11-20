package genericUtility;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	public String toReadDataFromExcel(String sheetname, int rowNo, int cellNo) throws Throwable 
	{
		FileInputStream fis1=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb= WorkbookFactory.create(fis1);
		String data = wb.getSheet(sheetname).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return data;
	}
}
