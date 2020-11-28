package Factile_Mode;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import junit.framework.Assert;
import resources.Base;

public class DGBP_HSB_TestCase_16 extends Base {
	WebDriver driver;
	WebDriver driver1;
	WebDriverWait wait, wait1;
	int int2;
	String s6, s7, GameName, twitterLink, PintrestLink, t1, p1, parent, expectedValue, actualValue,
			PlayerNameAtmodraterscreen, PlayerNameAtPlayerScreen;
	WebElement ElementNotGoingToVisible;
	Actions act;

	public static Logger Log = LogManager.getLogger(DGBP_HSB_TestCase_16.class.getName());
	

	@BeforeTest
	public void initilize() throws IOException {
		driver = IntilizeDriver();
		Log.info("Driver is Initilize");
		driver.get(prop.getProperty("rooturl"));
		wait = new WebDriverWait(driver, 60);
		Log.info("Navigated to homePage");

	}

	@Test
	public void TC_16_Verify_Game_Point_Symbol_$_After() throws InterruptedException, IOException {
		driver.findElement(By.cssSelector("span.loginButton")).click();
		driver.findElement(By.id("email")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("pwd"));
		driver.findElement(By.cssSelector("input.accountActionButton")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='settings']")));
		driver.findElement(By.xpath("//span[@id='settings']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='yearlyBox']/div")));
		String s1 = driver.findElement(By.xpath("//*[@id='yearlyBox']/div")).getAttribute("class");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='monthlyBox']/div")));
		String s2 = driver.findElement(By.xpath("//*[@id='monthlyBox']/div")).getAttribute("class");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='yearlybusinessBox']/div")));
		String s3 = driver.findElement(By.xpath("//*[@id='yearlybusinessBox']/div")).getAttribute("class");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='monthlybusinessBox']/div")));
		String s4 = driver.findElement(By.xpath("//*[@id='monthlybusinessBox']/div")).getAttribute("class");
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));

		Thread.sleep(3000);
		String s5 = "iradio_flat-yellow checked";

		if (s1.equalsIgnoreCase(s5)) {
			try {
				modeaterscreen();
				PlayerScreen();
			} catch (InterruptedException e) {
				System.out.println(e.toString());
			}
		} else if (s2.equalsIgnoreCase(s5)) {

			try {
				modeaterscreen();
				PlayerScreen();
			} catch (InterruptedException e) {
				System.out.println(e.toString());
			}
		} else if (s3.equalsIgnoreCase(s5)) {
			try {
				modeaterscreen();
				PlayerScreen();
			} catch (InterruptedException e) {
				System.out.println(e.toString());
			}
		} else if (s4.equalsIgnoreCase(s5)) {
			try {
				modeaterscreen();
				PlayerScreen();
			} catch (InterruptedException e) {
				System.out.println(e.toString());
			}
		} else {
			System.out.println("You have not taken any subscription");
		}
	}

	@AfterTest
	public void tearDown() throws InterruptedException {

	//driver1.quit();
	//	driver.switchTo().window(driver.getWindowHandle());
	//	driver.quit();
	}

	public void modeaterscreen() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("customize")));
		driver.findElement(By.id("customize")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//span[@class='resetToDefault resetCustomizations'])[4]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm btn-danger swal-button--danger']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']")).click();	
		Thread.sleep(5000);
		// checking the exact case at player screen on gameboard
		if (!driver.findElement(By.xpath("//div[@id='gameSettingSection']//input[@id='playAsNumberedTiles']"))
				.isSelected()) {
			System.out.println("nothing to do");
		} else {
			act = new Actions(driver);
			act.moveToElement(
					driver.findElement(By.xpath("//div[@id='gameSettingSection']//input[@id='playAsNumberedTiles']")))
					.click().perform(); 
		}
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='symbolValue']")));
		
		driver.findElement(By.xpath("//input[@id='symbolValue']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='symbolValue']")).sendKeys("$");
		Thread.sleep(3000);
		Select values = new Select(driver.findElement(By.xpath("//select[@class='form-control symbolPosition']")));
		values.selectByIndex(1);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='readingTimerValue']")).clear();
		driver.findElement(By.xpath("//input[@id='readingTimerValue']")).sendKeys("10");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='btn getReceipt btnSaveBtn'])[5]")).click();
		Thread.sleep(2000);
	}

	public void PlayerScreen() throws InterruptedException, IOException {
		Thread.sleep(2000);
		parent = driver.getWindowHandle();
		System.out.println("ParentWindow id is :-" + parent);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='mygames']")));
		driver.findElement(By.xpath("//*[@id='mygames']")).click();
		GameName = prop.getProperty("gamename");
		// 'Test"+int1+"'
		driver.findElement(
				By.xpath("//div[@data-text='" + GameName + "']/following-sibling::div/span[contains(text(), 'Play')]"))
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
		// System.out.println("Total window:=" + count);
		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				Thread.sleep(4000);
				driver.findElement(By.xpath("//span[@class='playNowButton']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[@data-numteams='2']")).click(); 
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
				wait1 = new WebDriverWait(driver1, 50);
				driver1.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				driver1.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
				driver1.get(prop.getProperty("joinurl"));
				Thread.sleep(3000);
				driver1.findElement(By.xpath("//input[@class='form-control']")).sendKeys(i);
				Thread.sleep(1000);
			//	driver1.findElement(By.xpath("//input[@class='joinBtn yellowBG mt-4 mb-4']")).click();
				//input[@class='btn joinBtn yellowBG mt-4 mb-4']
				driver1.findElement(By.xpath("//input[@class='btn joinBtn yellowBG mt-4 mb-4']")).click();
				//driver1.findElement(By.xpath("//button[@class='btn joinBtn yellowBG mt-4 mb-4']")).click();
				Thread.sleep(2000);
				driver1.findElement(By.xpath("(//div[@class='characterBlock position-relative'])[last()]")).click();
				Thread.sleep(2000);
				driver.switchTo().window(driver.getWindowHandle());
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[contains(text(),'Begin Game')]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[contains(text(),'Start Game')]")).click();
				driver1.switchTo().window(driver1.getWindowHandle());

				Thread.sleep(3000);
				int total = driver1
						.findElements(
								By.xpath("//span[@class='gameQuestionBlock unAnsweredQuestion disbledClick']/span"))
						.size();


				for (int c = 1; c <= total; c++) {

					String actual = driver1.findElement(By.xpath(
							"(//span[@class='gameQuestionBlock unAnsweredQuestion disbledClick']/span)[" + c + "]"))
							.getText();
					System.out.println("value is >>"+actual);
					assertTrue(actual.equals("100$") || actual.equals("200$") || actual.equals("300$")
							|| actual.equals("400$") || actual.equals("500$"));
				}

				driver.switchTo().window(driver.getWindowHandle());
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//span[@class='gamePointsBlock'])[1]")).click();
				Thread.sleep(2000);
				driver1.switchTo().window(driver1.getWindowHandle());
			
				wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='mr-2']")));
				wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Buzz!')]")));
				driver1.findElement(By.xpath("//div[contains(text(),'Buzz!')]")).click();
				//Thread.sleep(1000);
				// wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@name='input']")));
				//driver1.findElement(By.xpath("//textarea[@name='input']")).sendKeys("test");
				wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Enter Answer']")));
				driver1.findElement(By.xpath("//input[@placeholder='Enter Answer']")).sendKeys("test");				
				
				wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='ansSubmitBtn btn--inside uppercase']")));
				driver1.findElement(By.xpath("//input[@class='ansSubmitBtn btn--inside uppercase']")).click();
				// driver.switchTo().window(driver.getWindowHandle());
				driver.switchTo().window(driver.getWindowHandle());
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//i[@class='fa fa-check right']")));
				driver.findElement(By.xpath("//i[@class='fa fa-check right']")).click();
				driver1.switchTo().window(driver1.getWindowHandle());
				String expectedValue = "100$";
				Thread.sleep(2000);
				wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='moneyHolder']")));
				for (int d = 1; d <= 2; d++) {
					String actualvalue = driver1.findElement(By.xpath("(//span[@class='moneyHolder'])[" + d + "]"))
							.getText();

					Assert.assertEquals(expectedValue, actualvalue);
				}
				Log.info("JGame_Point_Symbol_$_After is working fine");
			}

		}
	}
}
