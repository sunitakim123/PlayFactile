package Factile_Mode_v3;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Page_Object_v3.Log_in_Elements;
import resources.Base;

public class HeaderMenuInFreeAccount extends Base {
	WebDriver driver;	
	int int2;
	Actions act;
	WebDriverWait wait;

	public static Logger Log = LogManager.getLogger(HeaderMenuInFreeAccount.class.getName());

	@BeforeTest
	public void initilize() throws IOException, InterruptedException {		
	
		driver = IntilizeDriver();
		Log.info("Driver is Initilize");
		driver.get(prop.getProperty("rooturl"));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 40);
		Log.info("Navigated to homePage");
		
	}
	
	
	@Test
	public void Fetching_Header_menus_From_Paid_Account() throws InterruptedException
	{
		
		Log_in_Elements lobj1 = new Log_in_Elements(driver);
		lobj1.Log_in_button().click();
		lobj1.getenterEmail().sendKeys("playfactiletest@gmail.com");
		lobj1.getenterPwd().sendKeys("12345678");
		lobj1.getlogin().click();
		Thread.sleep(3000);
		List<WebElement> allLinks=	driver.findElements(By.xpath("//div[@class='collapse navbar-collapse']//ul//li"));
	System.out.println("total menus in free account inside header:-"+allLinks.size());
	for(WebElement link:allLinks){
		String myString=link.getText();
		 System.out.println(link.getText());
		 assertTrue(myString.equals("Go Pro") || myString.equals("My Games") || myString.equals("Customize")||myString.equals("Account")||myString.equals("Support") || myString.equals("Sign Out"));		 }
	
	}
	
	

	private Object assertThat(String string) {
		// TODO Auto-generated method stub
		return null;
	}


	@AfterTest
	public void close()
	{ 
		driver.quit();
	}
	
}
