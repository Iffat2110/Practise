package helpers;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations 
{
	XSSFSheet sheetName;
	public void GetSheetName() throws Exception
	{
		File file= new File(".\\TestData\\excel.xlsx");
		FileInputStream fs =new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		 sheetName = wb.getSheet("Sheet1");
		
	}
	
	public int FindTotalRows()
	{
		int totalrows=sheetName.getLastRowNum()+1;
		return totalrows;
	}
	
	public String GetCellData(int row, int column)
	{
		String data=sheetName.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
}
