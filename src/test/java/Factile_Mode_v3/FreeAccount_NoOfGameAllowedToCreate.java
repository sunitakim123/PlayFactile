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

public class FreeAccount_NoOfGameAllowedToCreate extends Base {
	WebDriver driver;
	int int2;
	Actions act;
	WebDriverWait wait;
	String Newgmailidsent;
	public static Logger Log = LogManager.getLogger(FreeAccount_NoOfGameAllowedToCreate.class.getName());

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
	public void NoOfGamesCreationInFreeAccount_Verify() throws InterruptedException {
		// driver.navigate().to("http://www.yopmail.com/en/");
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		Newgmailidsent = "username1" + randomInt + "@gmail.com";

	
		System.out.println(Newgmailidsent);
		SignUP_elements sobj = new SignUP_elements(driver);
		sobj.Sign_in_button().click();
		sobj.getEmail().sendKeys(Newgmailidsent);
		sobj.getPassword().sendKeys("12345678");
		sobj.getConfirmPassword().sendKeys("12345678");
		sobj.getSignIN().click();
		sobj.getfreeaccount().click();
		
		for(int i=1;i<=4;i++)
		{
		
			
		int randomInt2 = randomGenerator.nextInt(10);
		String gamename = "Test"+randomInt2;
		String gameURL= "game" +randomInt2;
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='form-control']")));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement textbox = driver.findElement(By.xpath("//input[@class='form-control']"));
		js1.executeScript("arguments[0].click();", textbox);
		textbox.sendKeys(gamename);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='advanceOptionWrap']")));
		WebElement ClickOnAdvancedOption = driver.findElement(By.xpath("//div[@class='advanceOptionWrap']"));
		js1.executeScript("arguments[0].click();", ClickOnAdvancedOption);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='form-control']")));
		WebElement enterGameName = driver.findElement(By.xpath("//input[@class='form-control']"));
		js1.executeScript("arguments[0].click();", enterGameName);
		enterGameName.sendKeys(gameURL);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Submit')]")));
		WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
		js1.executeScript("arguments[0].click();", button);
		Thread.sleep(5000);
		
		//checking element is empty or not
		if(driver.findElements(By.xpath("(//a[@class='option clickable'])[1]")).isEmpty()){
		    //THEN FETCH THE ERROR MESSAGE FROM POP UP.
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='swal2-content']")));
			String s1= driver.findElement(By.xpath("//div[@id='swal2-content']")).getText();
			System.out.println("User who has free account are able to create total 3 games, and when user trying to create "+i+  "th game, the Error message he's getting:-"+s1);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='swal2-confirm swal2-styled']")));
			WebElement button2 = driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled']"));
			js1.executeScript("arguments[0].click();", button2);
			
			
		}else{
		    //DO CLICK ON MYGAME THAT IS ALIGNED AT THE LEFT NAVIGATION BAR.
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@class='option clickable'])[1]")));
			WebElement mygamelink = driver.findElement(By.xpath("(//a[@class='option clickable'])[1]"));
			js1.executeScript("arguments[0].click();", mygamelink);
		}
		
		
		
		}
		delete_Account();
	}

	public void delete_Account() throws InterruptedException {
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
	public void close() {
		 driver.quit();
	}

}
