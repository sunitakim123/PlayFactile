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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Page_Object_v3.Log_in_Elements;
import Page_Object_v3.SignUP_elements;
import resources.Base;

public class Test1 extends Base{

	WebDriver driver;	
	int int2;
	Actions act;
	WebDriverWait wait;

	public static Logger Log = LogManager.getLogger(Log_In.class.getName());

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
	public void Log_in() throws InterruptedException
	{	
		
		Log_in_Elements lobj1= new Log_in_Elements(driver);
		lobj1.Log_in_button().click();
		Thread.sleep(3000);
		lobj1.getenterEmail().sendKeys("username1833@gmail.com");
		lobj1.getenterPwd().sendKeys(("12345678"));
		lobj1.getlogin().click();
		
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='form-control']")));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement textbox = driver.findElement(By.xpath("//input[@class='form-control']"));
		js1.executeScript("arguments[0].click();", textbox);
		textbox.sendKeys("heena78");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='advanceOptionWrap']")));
		WebElement ClickOnAdvancedOption = driver.findElement(By.xpath("//div[@class='advanceOptionWrap']"));
		js1.executeScript("arguments[0].click();", ClickOnAdvancedOption);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='form-control']")));
		WebElement enterGameName = driver.findElement(By.xpath("//input[@class='form-control']"));
		js1.executeScript("arguments[0].click();", enterGameName);
		enterGameName.sendKeys("gift1234");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Submit')]")));
		WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
		js1.executeScript("arguments[0].click();", button);
		Thread.sleep(5000);
		
		if(driver.findElements(By.xpath("(//a[@class='option clickable'])[1]")).isEmpty()){
		    //THEN CLICK ON THE SUBMIT BUTTON
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='swal2-content']")));
			String s1= driver.findElement(By.xpath("//div[@id='swal2-content']")).getText();
			System.out.println(">>"+s1);
		}else{
		    //DO SOMETHING ELSE AS SUBMIT BUTTON IS NOT THERE
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@class='option clickable'])[1]")));
			WebElement mygamelink = driver.findElement(By.xpath("(//a[@class='option clickable'])[1]"));
			js1.executeScript("arguments[0].click();", mygamelink);
		}
		
		
		
	}
	@AfterTest
	public void close()
	{ 
		//driver.quit();
	}
	
	
	
}
