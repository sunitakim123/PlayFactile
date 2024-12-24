
	package Factile_Mode_v3;

	import static org.testng.Assert.assertEquals;

	import java.io.IOException;
	import java.time.LocalDate;
	import java.util.Random;
	import java.util.Set;

	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Page_Object_v3.Log_in_Elements;
	import Page_Object_v3.SignUP_elements;
	import resources.Base;

	public class AssertionHardAndSoft extends Base{

		WebDriver driver;	
		int int2;
		Actions act;
		WebDriverWait wait;
		SoftAssert softAssert = new SoftAssert();
		public static Logger Log = LogManager.getLogger(Test1.class.getName());

		@BeforeTest
		public void initilize() throws IOException, InterruptedException {		
			
			driver = IntilizeDriver();
			Log.info("Driver is Initilize");
			driver.get(prop.getProperty("rooturl"));
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver, 40);
			Log.info("Navigated to homePage");
			Thread.sleep(2000);
			driver.findElement(
					By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div/main/section[1]/div/div/div[1]/div/div[1]/a[2]"))
					.click();
			//driver.navigate().refresh();

		}
		
		
		@Test
		public void Log_in() throws InterruptedException
		{	
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"sign-in-form-email\"]")).sendKeys("sunita.deligence@gmail.com");
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(("12345678"));
			driver.findElement(By.xpath("//button[@class='btn signin']")).click();

			//Title Assertion
			Thread.sleep(2000);
			String ExpectedTitle= "My Games - Factile1";
			String title = driver.getTitle();
	        System.out.println("Page Title: " + title);
	        String actualTitle= driver.getTitle();
	        softAssert.assertEquals(actualTitle, ExpectedTitle, "Title is mismatch, that's why this test case is getting failed");

	        //URL Assertion
	        String ExpectedURL= "https://awspf.com/mygames";
	        String actualURL= driver.getCurrentUrl();
	        softAssert.assertEquals(actualURL, ExpectedURL, "URL is not matching with the Expected URl");
	        softAssert.assertAll();        
		}
			
		
			
			
		@AfterTest
		public void close()
		{ 
			//driver.quit();
		}
		
		
		
	}

	
	

