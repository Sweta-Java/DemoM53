package testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import BaseTest.BaseClass;
import genericUtility.ExcelUtility;
import objectRepository.CartPage;
import objectRepository.ProductPage;

@Listeners(ListenersUtility.ListenerImplementation.class)
public class AddProductToCart extends BaseClass	
{
	@Test(groups = "smoke")
	public void toaddprodTest() throws Throwable 
	{
		
//		PropertiesFileUtil putil= new PropertiesFileUtil();
		ExcelUtility eutil=new ExcelUtility();
//		WebDriverUtility wutil= new WebDriverUtility();
//		
//		String BROWSER=putil.toReadDataFromPropFile("Browser");
//		String URL=putil.toReadDataFromPropFile("Url");
//		String USERNAME=putil.toReadDataFromPropFile("Username");
//		String PASSWORD=putil.toReadDataFromPropFile("Password");
//		
//		WebDriver driver=null;
//		if(BROWSER.equals("Edge"))
//			driver=new EdgeDriver();
//		if(BROWSER.equals("Chrome"))
//			driver=new ChromeDriver();
//		if(BROWSER.equals("Firefox"))
//			driver=new FirefoxDriver();
//		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get(URL);
//		
//		//login
////		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
////		driver.findElement(By.id("password")).sendKeys(PASSWORD);
////		driver.findElement(By.id("login-button")).click();
//		LoginPage lp=new LoginPage(driver);
//		lp.getUn().sendKeys(USERNAME);
//		lp.getPwd().sendKeys(PASSWORD);
//		lp.getLgnbtn().click();
		
		
		String prodname = eutil.toReadDataFromExcel("Products",1,2);
		System.out.println("product name is: " + prodname);
		
		//Add product
//		driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']")).click();
//		driver.findElement(By.id("add-to-cart")).click();
		ProductPage pp=new ProductPage(driver);
		pp.getProdname().click();
		pp.getAddtocartBtn().click();
		pp.getCartIcon().click();
		
		CartPage cp=new CartPage(driver);
		
		
		//validation
//		driver.findElement(By.className("shopping_cart_link")).click();
//		String cartItem = driver.findElement(By.className("inventory_item_name")).getText();
		String cartItem = cp.getcItem().getText();
		System.out.println("cart item is: " +cartItem);
		
//		if(cartItem.equals(prodname))
//			System.out.println("pass");
//		else
//			System.out.println("fail");
		Assert.assertEquals(cartItem, prodname); 

		//logout 
//		driver.findElement(By.id("react-burger-menu-btn")).click();
//		driver.findElement(By.id("logout_sidebar_link")).click();
//		cp.getBurgerIcon().click();
//		cp.getLogout().click();
//		
		//close all windows
//		driver.quit();
	}
}
