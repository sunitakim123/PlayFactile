package Factile_Mode_v3;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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
import resources.Base;

public class ChangePassword extends Base {
	WebDriver driver;
	int int2;
	Actions act;
	WebDriverWait wait;
	String expected = "Password changed successfully";
	public static Logger Log = LogManager.getLogger(ChangePassword.class.getName());

	@BeforeTest
	public void initilize() throws IOException, InterruptedException {

		driver = IntilizeDriver();
	
		Log.info("Driver is Initilize");
		driver.get(prop.getProperty("rooturl"));
		wait = new WebDriverWait(driver, 60);
		Log.info("Navigated to homePage");

	}

	@Test
	public void ChangePassword() throws InterruptedException {

		Log_in_Elements lobj1 = new Log_in_Elements(driver);
		lobj1.Log_in_button().click();
		lobj1.getenterEmail().sendKeys("playfactile14@gmail.com");
		lobj1.getenterPwd().sendKeys("12345678");
		lobj1.getlogin().click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='navbar-list-2']/ul/li[3]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='col-sm-12 col-md-3 col-lg-3']//input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='oldPass']")).sendKeys("12345678");
		driver.findElement(By.xpath("//input[@name='newPass']")).sendKeys("12345678");

		driver.findElement(By.xpath("//input[@name='cnfNewPass']")).sendKeys("12345678");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Save']")));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement button = driver.findElement(By.xpath("//input[@value='Save']"));
		js1.executeScript("arguments[0].click();", button);

		// driver.switchTo().frame(0);
		Thread.sleep(4000); 
		String acutalmsg = driver.findElement(By.xpath("//div[@id='swal2-content']")).getText();
		System.out.println("Pop up message:- " + acutalmsg);
		assertEquals(acutalmsg, expected);
/*
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled']")).click();

		Thread.sleep(6000);
		driver.findElement(By.xpath("//span[contains(text(),'Sign Out')]")).click();
		Thread.sleep(6000);

		// resetting password back to the same
		lobj1.getenterEmail().sendKeys("playfactile14@gmail.com");
		lobj1.getenterPwd().sendKeys("12345678");
		lobj1.getlogin().click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='navbar-list-2']/ul/li[3]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='col-sm-12 col-md-3 col-lg-3']//input")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='oldPass']")));
		Thread.sleep(8000);
		
		driver.findElement(By.xpath("//input[@name='oldPass']")).sendKeys("12345678");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='newPass']")));
		driver.findElement(By.xpath("//input[@name='newPass']")).sendKeys("12345678");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='cnfNewPass']")));
		driver.findElement(By.xpath("//input[@name='cnfNewPass']")).sendKeys("12345678");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Save']")));
		Thread.sleep(4000);

		WebElement button2 = driver.findElement(By.xpath("//input[@value='Save']"));
		js1.executeScript("arguments[0].click();", button2);
*/
	}

	@AfterTest
	public void close() {
		driver.quit();
	}

}
