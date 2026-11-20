package BaseTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import genericUtility.PropertiesFileUtil;
import genericUtility.WebDriverUtility;
import objectRepository.CartPage;
import objectRepository.LoginPage;

public class BaseClass {
	public WebDriver driver=null;
	public static WebDriver sdriver;
	public PropertiesFileUtil putil=new PropertiesFileUtil();
	
//	@Parameters("BROWSER")
	@BeforeClass(groups = {"smoke","regression"})
	public void beforeClass() throws Throwable
	{
//		String BROWSER = putil.toReadDataFromPropFile("Browser");
		String BROWSER = System.getProperty("Browser"); //cmd line
		if(BROWSER.equals("Edge"))
			driver=new EdgeDriver();
		else if (BROWSER.equals("Chrome")) 
			driver=new ChromeDriver();
		else if (BROWSER.equals("Firefox")) 
			driver=new FirefoxDriver();
		sdriver=driver;
		Reporter.log("launch browser",true);
	}
	
	@BeforeMethod(groups = {"smoke","regression"})
	public void beforeMethod() throws Throwable
	{
		WebDriverUtility wutil= new WebDriverUtility();
		String URL=putil.toReadDataFromPropFile("Url");
		String USERNAME=putil.toReadDataFromPropFile("Username");
		String PASSWORD=putil.toReadDataFromPropFile("Password");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		//login
		LoginPage lp=new LoginPage(driver);
		lp.getUn().sendKeys(USERNAME);
		lp.getPwd().sendKeys(PASSWORD);
		lp.getLgnbtn().click();
		Reporter.log("login",true);
	}
	@AfterMethod(groups = {"smoke","regression"})
	public void afterMethod()
	{
		CartPage cp=new CartPage(driver);
		cp.getBurgerIcon().click();
		cp.getLogout().click();
		Reporter.log("logout",true);
	}
	@AfterClass(groups = {"smoke","regression"})
	public void afterClass()
	{
		driver.quit();
		Reporter.log("close browser",true);
	}

}
