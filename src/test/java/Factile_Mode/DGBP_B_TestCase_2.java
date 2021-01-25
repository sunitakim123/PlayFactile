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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import junit.framework.Assert;
import resources.Base;

public class DGBP_B_TestCase_2 extends Base {
	WebDriver driver;
	WebDriver driver1;
	WebDriverWait wait;
	int int2;
	String s1;
	String altText, NewMascotNameAtModerater, NewMascotNameAtPlayer,  parent ;
	Actions act;
	public static Logger Log = LogManager.getLogger(DGBP_B_TestCase_2.class.getName());
	private static String filePath1 = System.getProperty("user.dir") + "\\src\\main\\java\\images\\eagle.jpg";

	@BeforeTest
	public void initilize() throws IOException {
		driver = IntilizeDriver();
		Log.info("Driver is Initilize");
		driver.get(prop.getProperty("rooturl"));
		wait = new WebDriverWait(driver, 60);
		Log.info("Navigated to homePage");
	}

	@Test
	public void TC_2_Verify_Uploaded_Mascot_at_Player_screen() throws InterruptedException, IOException {
		driver.findElement(By.cssSelector("span.loginButton")).click();
		driver.findElement(By.id("email")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("pwd"));
		driver.findElement(By.cssSelector("input.accountActionButton")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='settings']")));
		driver.findElement(By.xpath("//span[@id='settings']")).click();
		String url1 = driver.getCurrentUrl();

		if (driver.findElement(By.xpath("//div[@class='col-md-12 currentActivePlanLabel']")).isDisplayed()) {

			uploadMascot();
			VerifyAtPlayerScreen();
		}

		else {
			System.out.println("You have not taken any subscription");
		}
	}
				
			
	@AfterTest
	public void tearDown() {
		driver1.quit();
		driver.switchTo().window(driver.getWindowHandle());
	driver.quit();  
	}

	public void uploadMascot() throws InterruptedException {
		driver.findElement(By.id("customize")).click();
Thread.sleep(2000);
driver.navigate().refresh();
Thread.sleep(2000);	
try {
			int total = driver.findElements(By.xpath("//div[@id='mascotSection']//span[@class='deleteCharacter']")).size();
			if (total > 0) {
				for (int i = 0; i <= total; i++) {
					driver.findElement(By.xpath("//div[@id='mascotSection']//span[@class='deleteCharacter']")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//button[contains(text(),'Yes, Delete it!')]")).click();
					Thread.sleep(2000);
				}
			}
		} catch (NoSuchElementException e) {
			// log.debug("Impossible to click the pop-up. Reason: " + e.toString());
		//	System.out.println("Impossible to click the pop-up. Reason: " + e.toString());
		}

		
		Thread.sleep(2000); 
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='addNewCharacter']")));
		driver.findElement(By.xpath("//*[@id='addNewCharacter']")).click();
		Thread.sleep(2000);
		uploadFileWithRobot(filePath1);
		Thread.sleep(5000);
		Log.info("Mascot image is uploaded");
		Random rand = new Random();
		int2 = rand.nextInt(100);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='mascotSection']//input[@placeholder='Enter Name']")).sendKeys("user"+int2);
		
			}

	public void VerifyAtPlayerScreen() throws InterruptedException, IOException {
		Thread.sleep(2000);
		 parent = driver.getWindowHandle();
		System.out.println("ParentWindow id is :-" + parent);
		driver.findElement(By.xpath("//*[@id='mygames']")).click();
		s1 = prop.getProperty("gamename");
		// 'Test"+int1+"'
		driver.findElement(
				By.xpath("//div[@data-text='" + s1 + "']/following-sibling::div/span[contains(text(), 'Play')]"))
				.click();
		Thread.sleep(2000);
		try {
			WebElement obj = driver.findElement(By.xpath("//button[contains(text(),'Start new game')]"));

			obj.click();
		} catch (NoSuchElementException e) {
			// log.debug("Impossible to click the pop-up. Reason: " + e.toString());
			//System.out.println("Impossible to click the pop-up. Reason: " + e.toString());
		}
		Thread.sleep(1000);
		Set<String> allWindows = driver.getWindowHandles();
		int count = allWindows.size();
		System.out.println("Total window:=" + count);
		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='playNowButton']")));
				//Thread.sleep(1000);
				driver.findElement(By.xpath("//span[@class='playNowButton']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[@data-numteams='2']")).click();
				
				Thread.sleep(2000);

				//System.out.println(driver.getTitle());
				//1. Display question on buzzer device
				//driver.findElement(By.xpath("(//ins[@class='iCheck-helper'])[1]")).click();
				
				//2. Display GM o buzzer device
				driver.findElement(By.xpath("//*[@id='displayBuzzerOptionBack']/div[1]/div[2]/div/div/ins")).click();

				//3. Buzzer Only
				//driver.findElement(By.xpath("(//ins[@class='iCheck-helper'])[3]")).click();
				
				Thread.sleep(2000);
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
				Thread.sleep(1000);
				//driver1.findElement(By.xpath("//input[@class='joinBtn yellowBG mt-4 mb-4']")).click();
				//driver1.findElement(By.xpath("//button[@class='btn joinBtn yellowBG mt-4 mb-4']")).click();
				driver1.findElement(By.xpath("//input[@class='btn joinBtn yellowBG mt-4 mb-4']")).click();
				Thread.sleep(2000);
				WebElement image = driver1.findElement(By.xpath("//div[@data-name='user"+int2+"']//img"));
				 altText = image.getAttribute("alt");
				System.out.println("alttext is =" +altText);
				driver1.findElement(By.xpath("//div[@data-name='user"+int2+"']//img")).click();
				Log.info("uploaded masoct is active & selected at player screen .");
				Thread.sleep(2000);
				driver.switchTo().window(driver.getWindowHandle());
				 driver.switchTo().window(driver.getWindowHandle());
				 Thread.sleep(2000);
				 driver.findElement(By.xpath("//span[contains(text(),'Begin Game')]")).click();
				 Thread.sleep(2000);
				 driver.findElement(By.xpath("//span[contains(text(),'Start Game')]")).click();
				 Thread.sleep(2000);
				 NewMascotNameAtModerater=	driver.findElement(By.xpath("//div[@class='col-lg m-0 p-0']/span")).getText();
				 Thread.sleep(2000);
				 driver1.switchTo().window(driver1.getWindowHandle());
				 Thread.sleep(2000);
				 NewMascotNameAtPlayer =driver1.findElement(By.xpath("//div[@class='m-0 p-0 col-12']/span")).getText();
				 Thread.sleep(2000);
				 Assert.assertEquals(NewMascotNameAtModerater, NewMascotNameAtPlayer);
				 Log.info("uploaded masoct is visible on player screen");
				
			}
		}
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
		robot.keyRelease(KeyEvent.VK_ENTER);
	} 

}



