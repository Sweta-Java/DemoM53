package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoSoftAssert {
	@Test
	public void softAssert()
	{
		String expectedTitle = "Faceboo";
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		String actualTitle = driver.getTitle();
		SoftAssert sof=new SoftAssert();
		sof.assertEquals(actualTitle,expectedTitle);
		System.out.println("hi");
		sof.assertAll();
	}
}
