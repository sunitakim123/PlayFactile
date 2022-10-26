package Factile_Mode_v3;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Page_Object_v3.Log_in_Elements;
import Page_Object_v3.SignUP_elements;
import resources.Base;

public class Sign_Out extends Base {
	WebDriver driver;	
	int int2;
	Actions act;
	WebDriverWait wait;
	//String expectedURL = "https://awspf.com/signin";
	String expectedURL = "https://playfactile.com/signin";
	public static Logger Log = LogManager.getLogger(Sign_Out.class.getName());

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
	public void Sign_Out() throws InterruptedException
	{
		//driver.navigate().to("http://www.yopmail.com/en/");

		Log_in_Elements lobj1= new Log_in_Elements(driver);
		lobj1.Log_in_button().click();
		lobj1.getenterEmail().sendKeys(prop.getProperty("username"));
		lobj1.getenterPwd().sendKeys(prop.getProperty("pwd"));
		lobj1.getlogin().click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Sign Out')]")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Sign Out')]")).click();
		
		Thread.sleep(5000);
		String currentURL = driver.getCurrentUrl();
		System.out.println(">>" + currentURL);
		//assertEquals(currentURL, expectedURL);
		assertTrue(currentURL.equals("https://www.awspf.com/signin") || currentURL.equals("https://www.playfactile.com/signin"));
		
	}
	@AfterTest
	public void close()
	{
		driver.quit(); 
	}
	
}
