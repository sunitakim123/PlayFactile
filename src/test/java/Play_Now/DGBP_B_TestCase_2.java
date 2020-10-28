package Play_Now;

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

import TestCases_Execution.TestCase_1;
import junit.framework.Assert;
import pageObject.LandingPage;
import resources.Base;

public class DGBP_B_TestCase_2 extends Base {
	WebDriver driver;
	WebDriver driver1;
	WebDriverWait wait;
	int int2;
	String s1;
	String altText;
	public static Logger Log = LogManager.getLogger(TestCase_1.class.getName());
	private static String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\images\\eagle.jpg";

	@BeforeTest
	public void initilize() throws IOException {
		driver = IntilizeDriver();
		
		Log.info("Driver is Initilize");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);
		Log.info("Navigated to homePage");
		
	}

	@Test
	public void Verify_Uploaded_Mascot_at_Player_screen() throws InterruptedException, IOException {
		driver.findElement(By.cssSelector("span.loginButton")).click();
		driver.findElement(By.id("email")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("pwd"));
		driver.findElement(By.cssSelector("input.accountActionButton")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='settings']")));
		driver.findElement(By.xpath("//span[@id='settings']")).click();
		//String s1 = driver.findElement(By.xpath("//*[@id='yearlyBox']/div")).getAttribute("class");
		//String s2 = driver.findElement(By.xpath("//*[@id='monthlyBox']/div")).getAttribute("class");
		String s3 = driver.findElement(By.xpath("//*[@id='yearlybusinessBox']/div")).getAttribute("class");
		String s4 = driver.findElement(By.xpath("//*[@id='monthlybusinessBox']/div")).getAttribute("class");

		Thread.sleep(3000);
		String s5 = "iradio_flat-yellow checked";

		if (s3.equalsIgnoreCase(s5)) {
			uploadMascot();
			VerifyAtPlayerScreen();
		} else if (s4.equalsIgnoreCase(s5)) {
			uploadMascot();
		 VerifyAtPlayerScreen();

		} else {
			Log.info("You have not taken any subscription");
		}
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver1.close();
	}

	public void uploadMascot() throws InterruptedException {
		driver.findElement(By.id("customize")).click();
		Thread.sleep(2000);

		int obj = driver.findElements(By.xpath("//div[@id='mascotSection']//span[@class='deleteCharacter']")).size();

		if (obj > 4) {
			for (int i = 4; i < obj; i++) {
				wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("(//div[@id='mascotSection']//span[@class='deleteCharacter'])[" + i + "]")));
				driver.findElement(By.xpath("(//div[@id='mascotSection']//span[@class='deleteCharacter'])[" + i + "]"))
						.click();
				driver.findElement(By.xpath("//button[contains(text(),'Yes, Delete it!')]")).click();
				Thread.sleep(2000);
			}
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='addNewCharacter']")));
		driver.findElement(By.xpath("//*[@id='addNewCharacter']")).click();
		Thread.sleep(3000);
		uploadFileWithRobot(filePath);
		Thread.sleep(3000);
		Log.info("Mascot image is uploaded");

		int obj1 = driver.findElements(By.xpath("//div[@id='mascotSection']//input[@placeholder='Enter Name']")).size();
		System.out.println("size is >>" + obj1);

		Random rand = new Random();
		int2 = rand.nextInt(100);
		Thread.sleep(4000);
		if (obj1 == 4) {
			for (int j = 5; j > obj1; j--) {
				driver.findElement(
						By.xpath("(//div[@id='mascotSection']//input[@placeholder='Enter Name'])[" + j + "]")).sendKeys("Player"+int2);
			}
		}
		driver.findElement(By.xpath("//*[@id='mascotSection']/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'Yes, reset !')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='mascotSection']/div/div[2]/div/div")).click();
				Log.info("New mascot is Activated.");
		Thread.sleep(3000);

	}

	public void VerifyAtPlayerScreen() throws InterruptedException, IOException {
		Thread.sleep(2000);
		// driver.switchTo().window(baseUrl);
		String parent = driver.getWindowHandle();
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
			System.out.println("Impossible to click the pop-up. Reason: " + e.toString());
		}
		Thread.sleep(1000);
		Set<String> allWindows = driver.getWindowHandles();
		int count = allWindows.size();
		System.out.println("Total window:=" + count);
		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//span[@class='playNowButton']")).click();

				driver.findElement(By.xpath("//*[@id='howManyTeams']/div/div[1]/span[1]")).click();
				
				Thread.sleep(3000);

				System.out.println(driver.getTitle());
				driver.findElement(By.xpath("//*[@id='displayBuzzerOptionBack']/div[1]/div[2]/div/div/ins")).click();

				driver.findElement(By.xpath("//*[@id='buzzerModeQuestion']/div/div[1]/span[2]")).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='inviteYourTeams']/div/span[4]")));
				Thread.sleep(3000);
				String i = driver.findElement(By.xpath("//*[@id='inviteYourTeams']/div/span[2]")).getText();
				System.out.println(i);// System.out.println(driver.getTitle());
				Thread.sleep(3000);

				driver1 = IntilizeDriver();
				
				driver1.get(prop.getProperty("joinurl"));
				Thread.sleep(3000);
				driver1.findElement(By.xpath("//input[@class='form-control']")).sendKeys(i);
				driver1.findElement(By.xpath("//button[contains(text(),'Join')]")).click();
				Thread.sleep(2000);
				WebElement image = driver1.findElement(By.xpath("//div[@data-name='Player"+int2+"']//img"));
				 altText = image.getAttribute("alt");
				System.out.println("alttext is =" +altText);
				driver1.findElement(By.xpath("//div[@data-name='Player"+int2+"']//img")).click();
				Log.info("uploaded masoct is active & selected at player screen .");
				Thread.sleep(2000);
				
				
				
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

	}

}
