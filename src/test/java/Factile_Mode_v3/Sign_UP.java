package Factile_Mode_v3;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Page_Object_v3.SignUP_elements;
import resources.Base;

public class Sign_UP extends Base{
	WebDriver driver;	
	int int2;
	Actions act;
	WebDriverWait wait;

	public static Logger Log = LogManager.getLogger(Sign_UP.class.getName());

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
	public void Sign_in()
	{
		//driver.navigate().to("http://www.yopmail.com/en/");
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000); 	
		String Newgmailidsent="username"+randomInt+"@gmail.com";
		System.out.println(Newgmailidsent);		
		SignUP_elements sobj = new SignUP_elements(driver);		
		sobj.Sign_in_button().click();		
		sobj.getEmail().sendKeys(Newgmailidsent);	
		sobj.getPassword().sendKeys("12345678");	
		sobj.getConfirmPassword().sendKeys("12345678");
		sobj.getSignIN().click();
		sobj.getfreeaccount().click();
		String GmailAfterLogin=sobj.getemailFromAccountPage().getText();
		assertEquals(GmailAfterLogin, Newgmailidsent);
		//driver.findElement(By.xpath("//a[@class='blueBtnSec01']")).click();
		//driver.findElement(By.xpath("Sign_in_button")).click();
		//driver.findElement(By.xpath("//input[@name='email']")).sendKeys(gmailidsent);
		//driver.findElement(By.xpath("//input[@name='passwordConfirm']")).sendKeys("12345678");
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345678");
		//driver.findElement(By.xpath("//button[@class='btn signin']")).click();
		
	//	driver.findElement(By.xpath("//span[@id='freeAccount']")).click();
			
		//String GmailAfterLogin=driver.findElement(By.xpath("//span[@class='userEmail']")).getText();
		
		
	}
	@AfterTest
	public void close()
	{
		driver.quit();
	}
	
	
	
}
