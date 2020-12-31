package Factile_Mode;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import junit.framework.Assert;
import resources.Base;

public class DGBP_HSB_TestCase_4 extends Base {
	WebDriver driver;
	WebDriver driver1;
	WebDriverWait wait, wait1;
	int int2;
	String s6, s7, GameName, twitterclass, Pintrestclass, t1, p1, parent;
	Actions act;

	public static Logger Log = LogManager.getLogger(DGBP_HSB_TestCase_4.class.getName());

	@BeforeTest
	public void initilize() throws IOException {
		driver = IntilizeDriver();
		Log.info("Driver is Initilize");
		driver.get(prop.getProperty("rooturl"));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 40);
		Log.info("Navigated to homePage");

	}

	@Test
	public void TC_4_Verify_Show_Social_Media_on_Gameboard() throws InterruptedException, IOException {
		driver.findElement(By.cssSelector("span.loginButton")).click();
		driver.findElement(By.id("email")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("pwd"));
		driver.findElement(By.cssSelector("input.accountActionButton")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='settings']")));
		driver.findElement(By.xpath("//span[@id='settings']")).click();
		String s1 = driver.findElement(By.xpath("//*[@id='yearlyBox']/div")).getAttribute("class");
		String s2 = driver.findElement(By.xpath("//*[@id='monthlyBox']/div")).getAttribute("class");
		String s3 = driver.findElement(By.xpath("//*[@id='yearlybusinessBox']/div")).getAttribute("class");
		String s4 = driver.findElement(By.xpath("//*[@id='monthlybusinessBox']/div")).getAttribute("class");

		Thread.sleep(3000);
		String s5 = "iradio_flat-yellow checked";

		if (s1.equalsIgnoreCase(s5)) {
			try {
				Uncheck_Hide_social_media_link();
				Show_SMO_Links_A_tModrater_Screen_Gameboard();
			} catch (InterruptedException e) {
				System.out.println(e.toString());
			}

		} else if (s2.equalsIgnoreCase(s5)) {
			try {
				Uncheck_Hide_social_media_link();
				Show_SMO_Links_A_tModrater_Screen_Gameboard();
			} catch (InterruptedException e) {
				System.out.println(e.toString());
			}
		} else if (s3.equalsIgnoreCase(s5)) {
			try {
				Uncheck_Hide_social_media_link();
				Show_SMO_Links_A_tModrater_Screen_Gameboard();
			} catch (InterruptedException e) {
				System.out.println(e.toString());
			}

		} else if (s4.equalsIgnoreCase(s5)) {
			try {
				Uncheck_Hide_social_media_link();
				Show_SMO_Links_A_tModrater_Screen_Gameboard();
			} catch (InterruptedException e) {
				System.out.println(e.toString());
			}
		} else if (driver.findElement(By.xpath("//div[@class='col-md-12 paidOfflineLabel']")).isDisplayed()) {

			Uncheck_Hide_social_media_link();
			Show_SMO_Links_A_tModrater_Screen_Gameboard();

		} else {
			System.out.println("You have not taken any subscription");
		}
	}

	@AfterTest
	public void tearDown() {

		driver1.quit();
		driver.switchTo().window(driver.getWindowHandle());
		driver.quit();
	}

	public void Uncheck_Hide_social_media_link() throws InterruptedException {
		driver.findElement(By.id("customize")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='mascotSection']/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Yes, reset !')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		Thread.sleep(4000);
		// unchecking the Hide social links on gameboard
		if (!driver.findElement(By.xpath("//div[@id='gameSettingSection']//input[@id='hideSocialLinks']"))
				.isSelected()) {
			System.out.println("nothing to do");
		} else {
			act = new Actions(driver);
			act.moveToElement(
					driver.findElement(By.xpath("//div[@id='gameSettingSection']//input[@id='hideSocialLinks']")))
					.click().perform();
			;

		}
	}

	public void Show_SMO_Links_A_tModrater_Screen_Gameboard() throws InterruptedException, IOException {
		Thread.sleep(2000);
		parent = driver.getWindowHandle();
		System.out.println("ParentWindow id is :-" + parent);
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
		System.out.println("Total window:=" + count);
		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);

				Thread.sleep(4000);
				driver.findElement(By.xpath("//span[@class='playNowButton']")).click();

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
				driver1.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
				driver1.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
				driver1.get(prop.getProperty("joinurl"));
				String url = driver1.getCurrentUrl();
				Thread.sleep(3000);
				driver1.findElement(By.xpath("//input[@class='form-control']")).sendKeys(i);
				Thread.sleep(1000);
//driver1.get(prop.getProperty("joinurl"));
				if (url.equals("https://game.playfactile.com/join")) {
					// live join button
					driver1.findElement(By.xpath("//input[@class='joinBtn yellowBG mt-4 mb-4']")).click();
				} else {
					driver1.findElement(By.xpath("//input[@class='btn joinBtn yellowBG mt-4 mb-4']")).click();
				}
				Thread.sleep(2000);
				driver1.findElement(By.xpath("(//div[@class='characterBlock position-relative'])[last()]")).click();
				Thread.sleep(2000);
				driver.switchTo().window(driver.getWindowHandle());
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[contains(text(),'Begin Game')]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[contains(text(),'Start Game')]")).click();
				Thread.sleep(2000);

				twitterclass = "fa fa-twitter";
				// "https://www.pinterest.com/pin/create/button?guid=jFE1MQuKNYAF-1&url=https%3A%2F%2Fawspf.com%2Fnewplay%2Fplay&media=undefined&description=PlayWin%20-%20Factile";
				Pintrestclass = "fa fa-pinterest";

				t1 = driver
						.findElement(
								By.xpath("//span[@class='btn btn-social-icon btn-twitter redirectLink_blank']//span"))
						.getAttribute("class");
				p1 = driver.findElement(By.xpath("//a[@class='btn btn-social-icon btn-pinterest']//span"))
						.getAttribute("class");

				Assert.assertEquals(twitterclass, t1);
				Log.info("When unchecked from customization setting>>Twitter link is displaying");
				Assert.assertEquals(Pintrestclass, p1);
				Log.info("When unchecked from customization setting>>Pintrest link is displaying");
				System.out.println("When unchecked from customization setting>>Pintrest link is displaying");
			} 

		}
	}
}
