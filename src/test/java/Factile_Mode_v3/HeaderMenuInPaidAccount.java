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

public class HeaderMenuInPaidAccount extends Base {
	WebDriver driver;	
	int int2;
	Actions act;
	WebDriverWait wait;

	public static Logger Log = LogManager.getLogger(HeaderMenuInPaidAccount.class.getName());

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
	public void Fetching_Header_menu_From_FreeAccount() throws InterruptedException
	{
		
		Log_in_Elements lobj1= new Log_in_Elements(driver);
		lobj1.Log_in_button().click();
		lobj1.getenterEmail().sendKeys(prop.getProperty("username"));
		lobj1.getenterPwd().sendKeys(prop.getProperty("pwd"));
		lobj1.getlogin().click();
		Thread.sleep(3000);
		List<WebElement> allLinks=	driver.findElements(By.xpath("//div[@class='collapse navbar-collapse']//ul//li//a"));
		System.out.println("Total menus in paid account inside header:-"+allLinks.size());
		for(WebElement link:allLinks)
		{
		String myString=link.getText();
		System.out.println(link.getText());
		assertTrue(myString.equals("My Games") || myString.equals("Customize")||myString.equals("Account")||myString.equals("Support") || myString.equals("Sign Out"));		 
		}
	
	}
	
	


	@AfterTest
	public void close()
	{ 
		driver.quit();
	}
	
}
