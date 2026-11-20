package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoHardAssert {
	@Test
	public void demo()
	{
		//hard assert- if it fails the under line codes are not going to execute
		String expectedTitle="Facebook"; //"facebook - login page" error
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		String actualTitle= driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Step1");
		System.out.println("Step2");
	}

}
