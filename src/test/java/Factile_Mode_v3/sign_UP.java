package Factile_Mode_v3;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Page_Object_v3.SignUP_elements;
import resources.Base;

public class sign_UP extends Base{
	WebDriver driver;	
	int int2;
	Actions act;
	WebDriverWait wait;
	String  Newgmailidsent;
	public static Logger Log = LogManager.getLogger(sign_UP.class.getName());

	@BeforeTest
	public void initilize() throws IOException, InterruptedException {		
	
		driver = IntilizeDriver();
		Log.info("Driver is Initilize");
		driver.get(prop.getProperty("rooturl"));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 60);
		Log.info("Navigated to homePage");
		
	}
	
	
	@Test
	public void Sign_UP() throws InterruptedException
	{
		//driver.navigate().to("http://www.yopmail.com/en/");
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000); 	
		 Newgmailidsent="username1"+randomInt+"@gmail.com";
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
		Thread.sleep(4000);
	
		driver.findElement(By.xpath("//ul[@class='navbar-nav menu']//li[4]")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='deleteAccountWrapper']/button")));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement button = driver.findElement(By.xpath("//*[@class='deleteAccountWrapper']/button"));
		js1.executeScript("arguments[0].click();", button);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='deleteAccountWrapper']/button")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='swal2-input']")).sendKeys("12345678");
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='swal2-confirm swal2-styled']")));
		driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Delete!')]")));
		driver.findElement(By.xpath("//*[contains(text(),'Delete!')]")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Yes!')]")));
		driver.findElement(By.xpath("//*[contains(text(),'Yes!')]")).click();
		Thread.sleep(4000);
		
	}
	@AfterTest
	public void close()
	{
		driver.quit(); 
	}
	
	
	
}
