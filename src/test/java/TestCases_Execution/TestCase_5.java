package TestCases_Execution;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObject.CreateGameUsingExcel;
import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.UploadMascot;
import resources.Base;

public class TestCase_5 extends Base {
	WebDriver driver;
	public static Logger Log=LogManager.getLogger(TestCase_5.class.getName());
	public WebDriverWait wait;
	public  static String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\images\\eagle.jpg";


		
	@Test()
	public void UploadMascotImageAtModearater() throws IOException, InterruptedException
	{
				
			driver = IntilizeDriver();
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		     wait = new WebDriverWait(driver,30);
			driver.get(prop.getProperty("url"));
			LandingPage l1 = new LandingPage(driver);
			l1.getLogin().click();
			LoginPage l2 = new LoginPage(driver);
			l2.getEmailid().sendKeys(prop.getProperty("username"));
			l2.getPassword().sendKeys(prop.getProperty("pwd"));
			l2.getSignin().click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("customize")));
			driver.findElement(By.id("customize")).click();
			UploadMascot up = new UploadMascot(driver);
			
			
		int obj = driver.findElements(By.xpath("//div[@id='mascotSection']//span[@class='deleteCharacter']")).size();
	
		System.out.println("Size is="+obj);
		
		for(int i=1;i<=obj;i++)
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='mascotSection']//span[@class='deleteCharacter']"))); 
			driver.findElement(By.xpath("//div[@id='mascotSection']//span[@class='deleteCharacter']")).click();
			 driver.findElement(By.xpath("//button[contains(text(),'Yes, Delete it!')]")).click();
			 Thread.sleep(2000);
			
		}
	    
		wait.until(ExpectedConditions.elementToBeClickable(up.Mascot()));
		 up.Mascot().click();
		uploadFileWithRobot(filePath);
		Log.info("Mascot image is uploaded");
		
		 Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='form-control characterNameEdit']")));
		Random rand = new Random();
		int int2 = rand.nextInt(100);
		driver.findElement(By.xpath("//input[@class='form-control characterNameEdit']")).sendKeys("Player"+int2);
		Log.info("Name given to new mascot uploaded image");
		driver.findElement(By.xpath("//span[contains(text(),'Active')]")).click();
		Log.info("New mascot is Activated.");
		Thread.sleep(2000);
		
		
		/*wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='addNewCharacter']")));
	driver.findElement(By.xpath("//*[@id='addNewCharacter']")).click();
	uploadFileWithRobot(filePath); */
		
	}
	
	 public void uploadFileWithRobot (String imagePath) {
	        StringSelection stringSelection = new StringSelection(imagePath);
	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        clipboard.setContents(stringSelection, null);
	 
	        Robot robot = null;
	 
	        try {
	            robot = new Robot();
	        } catch (AWTException e) {
	            e.printStackTrace();
	        }
	 
	        robot.delay(250);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.delay(150);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	    

		}
	
	
	 
	 @AfterMethod
	 public void teardown()
	 {
		 driver.close();
	 }
}
