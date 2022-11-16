package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import helpers.BrowserOperations;
import helpers.ExcelOperations;

public class LoginTest
{
WebDriver driver;
	@Test(dataProvider = "GetDataFromExcel")
	public void LoginTestMethod(String Username,String Password)
	{
		BrowserOperations browserOperations =new BrowserOperations();
		driver=browserOperations.LaunchApplication();
		driver.findElement(By.id("txtUsername")).sendKeys(Username);
		driver.findElement(By.id("txtPassword")).sendKeys(Password);
		driver.findElement(By.id("btnLogin")).click();
	}
	@DataProvider
	public Object[][] GetDataFromExcel() throws Exception
	{
		// Main Objective to Copy the excel data in object array
		
		//1. Find sheet name in which the data is present.
		ExcelOperations excelOperations =new ExcelOperations();
		excelOperations.GetSheetName();
		//2.Find total rows in excel
		int rows=excelOperations.FindTotalRows();
		Object[][] data=new Object[rows][2];
		// 3. Get each cell data in array
		for(int i=0;i<rows;i++)
		{
			data[i][0]=excelOperations.GetCellData(i,0);
			data[i][1]=excelOperations.GetCellData(i,1);
		}
		return data;
	}
}
