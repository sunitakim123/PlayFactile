
package Factile_Mode;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import resources.Base;

public class DGBM_B_TestCase_1 extends Base {
	WebDriver driver;
	WebDriver driver1;
	WebDriverWait wait;
	int int2, x, y, z, obj1, obj2, obj3;
	String GameName,  parent;
	public static Logger Log = LogManager.getLogger(DGBM_B_TestCase_1.class.getName());
	//private static String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\images\\Logo.jpg";
	private static String filePath =  "./src/main/java/images/Logo.jpg";
	//"./src/main/java/LinuxDrivers/chromedriver";
	@BeforeTest
	public void initilize() throws IOException {
		driver = IntilizeDriver();
		Log.info("Driver is Initilize");
		driver.get(prop.getProperty("rooturl"));		
		wait = new WebDriverWait(driver, 60);
		Log.info("Navigated to homePage");

	}

	@Test
	public void TC_1_Verify_Uploaded_Logo_at_Moderater_Gameboard_screen() throws InterruptedException, IOException {
		driver.findElement(By.cssSelector("span.loginButton")).click();
		driver.findElement(By.id("email")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("pwd"));
		driver.findElement(By.cssSelector("input.accountActionButton")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='settings']")));
		driver.findElement(By.xpath("//span[@id='settings']")).click();
		// String s1 =
		// driver.findElement(By.xpath("//*[@id='yearlyBox']/div")).getAttribute("class");
		// String s2 =
		// driver.findElement(By.xpath("//*[@id='monthlyBox']/div")).getAttribute("class");
		String s3 = driver.findElement(By.xpath("//*[@id='yearlybusinessBox']/div")).getAttribute("class");
		String s4 = driver.findElement(By.xpath("//*[@id='monthlybusinessBox']/div")).getAttribute("class");

		Thread.sleep(3000);
		String s5 = "iradio_flat-yellow checked";

		if (s3.equalsIgnoreCase(s5)) { 
			try {
			uploadLogoAtModeraterScreen();	
			VerifyLogoAtmoderatergameboardScreen();
		}
		catch(InterruptedException e) {
			System.out.println(e.toString());
		}
		} else if (s4.equalsIgnoreCase(s5)) {
			try {
				uploadLogoAtModeraterScreen();	
				VerifyLogoAtmoderatergameboardScreen();
			}
			catch(InterruptedException e) {
				System.out.println(e.toString());
			}
		} else {
			Log.info("You have not taken any subscription");
		}
	}

	@AfterTest
	public void tearDown() {
		driver1.quit();
		driver.switchTo().window(driver.getWindowHandle());
		driver.quit(); 
	}

	public void uploadLogoAtModeraterScreen() throws InterruptedException {
		driver.findElement(By.id("customize")).click();
		Thread.sleep(2000);
		
		
		try {
		int total = driver.findElements(By.xpath("//div[@id='logoSection']//span[@class='deleteLogoUrl']")).size();
		if(total>0)
		{
			for(int i=0;i<=total;i++)
			{
				driver.findElement(By.xpath("//div[@id='logoSection']//span[@class='deleteLogoUrl']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[contains(text(),'Yes, Delete it!')]")).click();
				Thread.sleep(2000);
			}
		}
		}
		 catch (NoSuchElementException e) {
				// log.debug("Impossible to click the pop-up. Reason: " + e.toString());
				System.out.println("Impossible to click the pop-up. Reason: " + e.toString());
			}
		driver.findElement(By.xpath("//*[@id='addNewLogo']/div/span")).click();	
		Thread.sleep(3000);
		uploadFileWithRobot(filePath);
		Thread.sleep(5000);
		Random rand = new Random();
		int int2 = rand.nextInt(100);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='logoSection']//input[@placeholder='Enter Name']")));
		driver.findElement(By.xpath("//div[@id='logoSection']//input[@placeholder='Enter Name']")).sendKeys("NewLogo" + int2);		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='logoSection']//input[@class='w-50 logoActivateBtn']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='logoSection']//input[@class='w-50 logoActivateBtn right']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='mascotSection']/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'Yes, reset !')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		Thread.sleep(2000);
		
		Thread.sleep(2000);

			}
	public void VerifyLogoAtmoderatergameboardScreen() throws InterruptedException, IOException {
		Thread.sleep(2000);
		// driver.switchTo().window(baseUrl);
		 parent = driver.getWindowHandle();
		System.out.println("ParentWindow id is :-" + parent);
		driver.findElement(By.xpath("//*[@id='mygames']")).click();
		GameName = prop.getProperty("gamename");
		// 'Test"+int1+"'
		driver.findElement(
				By.xpath("//div[@data-text='" + GameName + "']/following-sibling::div/span[contains(text(), 'Play')]"))
				.click();
		Thread.sleep(3000);
		
		try {
			WebElement obj = driver.findElement(By.xpath("//button[contains(text(),'Start new game')]"));

			obj.click();
		} catch (NoSuchElementException e) {
			// log.debug("Impossible to click the pop-up. Reason: " + e.toString());
			System.out.println("Impossible to click the pop-up. Reason: " + e.toString());
		}
		Thread.sleep(1000);
		Set<String> allWindows = driver.getWindowHandles();
		int count = allWindows.size();
		System.out.println("Total window:=" + count);
		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
			
				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[@class='playNowButton']")).click();

				driver.findElement(By.xpath("//span[@data-numteams='2']")).click();
				
				Thread.sleep(3000);

				//System.out.println(driver.getTitle());
				//1. Display question on buzzer device
				//driver.findElement(By.xpath("(//ins[@class='iCheck-helper'])[1]")).click();
				
				//2. Display GM o buzzer device
				driver.findElement(By.xpath("//*[@id='displayBuzzerOptionBack']/div[1]/div[2]/div/div/ins")).click();

				//3. Buzzer Only
				//driver.findElement(By.xpath("(//ins[@class='iCheck-helper'])[3]")).click();
				
				driver.findElement(By.xpath("//*[@id='buzzerModeQuestion']/div/div[1]/span[2]")).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='inviteYourTeams']/div/span[4]")));
				Thread.sleep(3000);
				String i = driver.findElement(By.xpath("//*[@id='inviteYourTeams']/div/span[2]")).getText();
				System.out.println(i);// System.out.println(driver.getTitle());
				Thread.sleep(3000);

				driver1 = IntilizeDriver();
				driver1.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				driver1.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
				driver1.get(prop.getProperty("joinurl"));
				Thread.sleep(3000);
				driver1.findElement(By.xpath("//input[@class='form-control']")).sendKeys(i);
				driver1.findElement(By.xpath("//input[@class='joinBtn yellowBG mt-4 mb-4']")).click();
				Thread.sleep(2000);
				 driver1.findElement(By.xpath("//div[@data-name='Pineapple']")).click();
				 Thread.sleep(2000);
				 driver.switchTo().window(driver.getWindowHandle());
				 Thread.sleep(2000);
				 driver.findElement(By.xpath("//span[contains(text(),'Begin Game')]")).click();
				 Thread.sleep(2000);
				 driver.findElement(By.xpath("//span[contains(text(),'Start Game')]")).click();
				 Thread.sleep(2000);
				WebElement w1 =  driver.findElement(By.xpath("(//img[@class='gameBoardLogo'])[1]"));
				String  leftlogo= w1.getAttribute("alt");
				String expected1 ="factile";
				if(leftlogo.equalsIgnoreCase(expected1))
				{
				Log.info("Left logo is present>>="+leftlogo);
				}
				Thread.sleep(1000);
			
				WebElement w2 =  driver.findElement(By.xpath("(//img[@class='gameBoardLogo'])[2]"));
				String  TopLogo= w1.getAttribute("alt");
				String expected2 ="Custom Logo";
				System.out.println("Top logo is present>>="+TopLogo);
				if(TopLogo.equalsIgnoreCase(expected2))
				{
				Log.info("Top logo is present>>="+TopLogo);
				}
				Thread.sleep(2000);
				//WebElement image = driver.findElement(By.xpath("//div[@data-name='Player67']//img"));
				//String altText = image.getAttribute("alt"); 
				
				//System.out.println("alttext is =" +altText);
				
				
			}}
	}
		
	

	public void uploadFileWithRobot(String imagePath) {
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
		robot.keyPress(KeyEvent.VK_ENTER);

	}

}