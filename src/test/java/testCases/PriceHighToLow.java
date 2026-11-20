package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import genericUtility.ExcelUtility;
import genericUtility.PropertiesFileUtil;
import genericUtility.WebDriverUtility;

public class PriceHighToLow 
{
	public static void main(String[] args) throws Throwable 
	{
		PropertiesFileUtil putil=new PropertiesFileUtil();
		ExcelUtility eutil=new ExcelUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		
		String BROWSER = putil.toReadDataFromPropFile("Browser");
		String URL = putil.toReadDataFromPropFile("Url");
		String USERNAME = putil.toReadDataFromPropFile("Username");
		String PASSWORD = putil.toReadDataFromPropFile("Password");
		
		WebDriver driver=null;
		if(BROWSER.equals("Edge"))
		{
			driver=new EdgeDriver();
		}
		else if (BROWSER.equals("Chrome")) 
		{
			driver=new ChromeDriver();
		}
		else if (BROWSER.equals("Firefox")) 
		{
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(URL);
		
//		login
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		
		WebElement dropDown = driver.findElement(By.className("product_sort_container"));
		Select select=new Select(dropDown);
//		select.selectByValue("za");
//		select.selectByContainsVisibleText("Z to A");
//		select.selectByIndex(1);
		select.selectByVisibleText("Name (Z to A)");
		
		driver.quit();
	}
}
