package Factile_Mode_v3;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
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

public class DeleteAccount extends Base {
	WebDriver driver;
	int int2;
	Actions act;
	WebDriverWait wait;
	String expectedURL = "https://awspf.com/signin";
	public static Logger Log = LogManager.getLogger(DeleteAccount.class.getName());

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
	public void DeleteAccount() throws InterruptedException {
		// driver.navigate().to("http://www.yopmail.com/en/");
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		String Newgmailidsent = "test" + randomInt + "@gmail.com";
		System.out.println(Newgmailidsent);
		SignUP_elements sobj = new SignUP_elements(driver);
		sobj.Sign_in_button().click();
		sobj.getEmail().sendKeys(Newgmailidsent);
		sobj.getPassword().sendKeys("12345678");		
		
		sobj.getConfirmPassword().sendKeys("12345678");
		sobj.getSignIN().click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='fa fa-times closeNotification']"));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='navbar-list-2']/ul/li[4]")));
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		WebElement ClickOnAccountMenu = driver.findElement(By.xpath("//*[@id='navbar-list-2']/ul/li[4]"));
		js5.executeScript("arguments[0].click();", ClickOnAccountMenu);
		
		//driver.findElement(By.xpath("//*[@id='navbar-list-2']/ul/li[4]")).click();
		Thread.sleep(3000);
	//	driver.findElement(By.xpath("//ul[@class='navbar-nav menu']//li[4]")).click();
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
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='email']")));
		Thread.sleep(7000);
		String currentURL = driver.getCurrentUrl();
		System.out.println(">>" + currentURL);
		//assertEquals(currentURL, expectedURL);
		 assertTrue(currentURL.equals("https://www.awspf.com/signin") || currentURL.equals("https://www.playfactile.com/signin"));
	}

	@AfterTest
	public void close() {
		// driver.quit();
	}

}
