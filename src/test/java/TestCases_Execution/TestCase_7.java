package TestCases_Execution;
	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.Toolkit;
	import java.awt.datatransfer.Clipboard;
	import java.awt.datatransfer.StringSelection;
	import java.awt.event.KeyEvent;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Random;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
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

	public class TestCase_7 extends Base {
		WebDriver driver;
		public static Logger Log=LogManager.getLogger(TestCase_7.class.getName());
		public WebDriverWait wait;
		public  static String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\images\\eagle.jpg";


			
		@Test()
		public void VerifyGameBoardAtPlayerScreen() throws InterruptedException, IOException 
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
			String parent = driver.getWindowHandle();
			System.out.println("ParentWindow id is :-" + parent);
			String PlayerURL= "https://game.awspf.com/join";
			driver.findElement(By.xpath("//div[@class='gameTileRows position-relative']//div[1]//div[2]//span[1]")).click();
			driver.findElement(By.xpath("//button[contains(text(), 'Start new game')]")).click();
			Set<String> allWindows = driver.getWindowHandles();
			int count = allWindows.size();
			System.out.println("Total window:=" + count);
			for (String child : allWindows) {
				if (!parent.equalsIgnoreCase(child)) {
					driver.switchTo().window(child);
					Thread.sleep(3000);
					driver.findElement(By.xpath("//span[@class='playNowButton']")).click();

					driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/span[4]")).click();
					System.out.println(driver.getTitle());
					driver.findElement(
							By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/ins[1]"))
							.click();

					driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/span[2]")).click();
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/span[2]")));
					
					String i = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/span[2]")).getText();
					System.out.println(i);// System.out.println(driver.getTitle());

					 JavascriptExecutor js = (JavascriptExecutor) driver;
					 js.executeScript("window.open('https://game.awspf.com/join','_blank');");
					 Set<String> allwindow =driver.getWindowHandles(); 
					 ArrayList<String> tabs = new ArrayList<>(allwindow);
						 
					driver.switchTo().window(tabs.get(2));
					System.out.println(driver.getTitle());
					//System.out.println("finish");
				 Thread.sleep(3000);
				 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='form-control']")));
					
				driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(i);
					driver.findElement(By.xpath("//button[contains(text(),'Join')]")).click();
					
					 
				}
				}}

		

		
		
		 
		 @AfterMethod
		 public void teardown()
		 {
			 driver.close();
		 }
	

}
