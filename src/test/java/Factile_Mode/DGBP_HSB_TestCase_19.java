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

public class DGBP_HSB_TestCase_19 extends Base {
	WebDriver driver;
	WebDriver driver1;
	WebDriverWait wait, wait1;
	int int2;
	String s6, s7, GameName, twitterLink, PintrestLink, t1, p1, parent, expectedValue, actualValue,
			PlayerNameAtmodraterscreen, PlayerNameAtPlayerScreen;
	WebElement ElementNotGoingToVisible;
	Actions act;

	public static Logger Log = LogManager.getLogger(DGBP_HSB_TestCase_20.class.getName());
	private static String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\images\\eagle.jpg";

	@BeforeTest
	public void initilize() throws IOException {
		driver = IntilizeDriver();
		Log.info("Driver is Initilize");
		driver.get(prop.getProperty("rooturl"));
		wait = new WebDriverWait(driver, 60);
		Log.info("Navigated to homePage");

	}

	@Test
	public void TC_19_Verify_Double_Factile() throws InterruptedException, IOException {
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

		 driver1.quit();
		 driver.switchTo().window(driver.getWindowHandle());
		 driver.quit();
	}

	public void modeaterscreen() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("customize")));
		driver.findElement(By.id("customize")).click();
		Thread.sleep(3000);
		if (driver.findElement(By.xpath("//input[@id='playDoubleJeopardy']")).isSelected()) {
			System.out.println("Already selected");
		} else {
			act = new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//input[@id='playDoubleJeopardy']"))).click().perform();
			;

		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='readingTimerValue']")).clear();
		driver.findElement(By.xpath("//input[@id='readingTimerValue']")).sendKeys("5");
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
		Thread.sleep(3000);
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='jeopardy
		// tooltip-icon'])[2]")));
		if (driver.findElement(By.xpath("(//span[@class='jeopardy tooltip-icon'])[2]")).isSelected()) {
			System.out.println("already Selected");
		} else {
			act = new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("(//span[@class='jeopardy tooltip-icon'])[2]"))).click()
					.perform();

		}
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
		// System.out.println("Total window:=" + count);
		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				Thread.sleep(4000);
				driver.findElement(By.xpath("//span[@class='playNowButton']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[@data-numteams='2']")).click();
				Thread.sleep(1500);
				System.out.println(driver.getTitle());
				driver.findElement(By.xpath("//*[@id='displayBuzzerOptionBack']/div[1]/div[2]/div/div/ins")).click();

				driver.findElement(By.xpath("//*[@id='buzzerModeQuestion']/div/div[1]/span[2]")).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='inviteYourTeams']/div/span[4]")));
				Thread.sleep(2000);
				String i = driver.findElement(By.xpath("//*[@id='inviteYourTeams']/div/span[2]")).getText();
				System.out.println(i);// System.out.println(driver.getTitle());
		

				driver1 = IntilizeDriver();
				driver1.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				driver1.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
				driver1.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				wait1 = new WebDriverWait(driver1, 60);
				driver1.get(prop.getProperty("joinurl"));
				Thread.sleep(1000);
				driver1.findElement(By.xpath("//input[@class='form-control']")).sendKeys(i);
				Thread.sleep(1000);
				// driver1.findElement(By.xpath("//input[@class='joinBtn yellowBG mt-4
				// mb-4']")).click();
				driver1.findElement(By.xpath("//input[@class='btn joinBtn yellowBG mt-4 mb-4']")).click();
				Thread.sleep(1500);
				driver1.findElement(By.xpath("(//div[@class='characterBlock position-relative'])[last()]")).click();
		
				driver.switchTo().window(driver.getWindowHandle());
				Thread.sleep(1000);
				driver.findElement(By.xpath("//span[contains(text(),'Begin Game')]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//span[contains(text(),'Start Game')]")).click();
				Thread.sleep(1000);

				int activetiles = driver.findElements(By.xpath("//span[@class='gameQuestionBlock unAnsweredQuestion']"))
						.size();
				System.out.println("total active tiles in first game>>" + activetiles);

				for (int p = 1; p <= activetiles; p++) {

					System.out.println("value of p>>" + p);
					wait.until(ExpectedConditions.elementToBeClickable(
							By.xpath("(//span[@class='gameQuestionBlock unAnsweredQuestion'])[1]")));
					String value = driver
							.findElement(By.xpath("(//span[@class='gameQuestionBlock unAnsweredQuestion'])[1]"))
							.getText();
					// System.out.println("value"+ value);
					// System.out.println("value of p>>"+p);
					Thread.sleep(2000);
					driver.findElement(By.xpath("(//span[@class='gameQuestionBlock unAnsweredQuestion'])[1]")).click();
					driver1.switchTo().window(driver1.getWindowHandle());

					wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='mr-2']")));
					wait1.until(
							ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Buzz!')]")));
					driver1.findElement(By.xpath("//div[contains(text(),'Buzz!')]")).click();
					wait1.until(ExpectedConditions
							.presenceOfElementLocated(By.xpath("//input[@placeholder='Enter Answer']")));
					driver1.findElement(By.xpath("//input[@placeholder='Enter Answer']")).sendKeys("test");
					wait1.until(ExpectedConditions
							.elementToBeClickable(By.xpath("//input[@class='ansSubmitBtn btn--inside uppercase']")));
					driver1.findElement(By.xpath("//input[@class='ansSubmitBtn btn--inside uppercase']")).click();
					// driver.switchTo().window(driver.getWindowHandle());
					driver.switchTo().window(driver.getWindowHandle());
					Thread.sleep(2000);
					wait.until(
							ExpectedConditions.presenceOfElementLocated(By.xpath("//i[@class='fa fa-check right']")));
					driver.findElement(By.xpath("//i[@class='fa fa-check right']")).click();
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='backToBoard']")));
					driver.findElement(By.xpath("//button[@class='backToBoard']")).click();
					// System.out.println("value of p at end>>"+p);
				}
				Thread.sleep(2000);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='swal-modal']")));
				String popupmsg = driver.findElement(By.xpath("//div[@class='swal-modal']")).getText();
				Thread.sleep(2000);
				System.out.println("pop up msg>> " + popupmsg);

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
						"//div[@class='swal-modal']//button[@class='swal-button swal-button--confirm btn-success swal-button--danger']")));
				driver.findElement(By.xpath(
						"//div[@class='swal-modal']//button[@class='swal-button swal-button--confirm btn-success swal-button--danger']"))
						.click();
				Thread.sleep(2000);
				int activetilesInSecodGame = driver
						.findElements(By.xpath("//span[@class='gameQuestionBlock unAnsweredQuestion']")).size();
				System.out.println("total active tiles in second game>>" + activetilesInSecodGame);
				for (int p = 1; p <= 2; p++) {

					System.out.println("value of p>>" + p);
					wait.until(ExpectedConditions.elementToBeClickable(
							By.xpath("(//span[@class='gameQuestionBlock unAnsweredQuestion'])[1]")));
					String value = driver
							.findElement(By.xpath("(//span[@class='gameQuestionBlock unAnsweredQuestion'])[1]"))
							.getText();
					// System.out.println("value"+ value);
					// System.out.println("value of p>>"+p);
					Thread.sleep(2000);
					driver.findElement(By.xpath("(//span[@class='gameQuestionBlock unAnsweredQuestion'])[1]")).click();
					driver1.switchTo().window(driver1.getWindowHandle());

					wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='mr-2']")));
					wait1.until(
							ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Buzz!')]")));
					driver1.findElement(By.xpath("//div[contains(text(),'Buzz!')]")).click();
					wait1.until(ExpectedConditions
							.presenceOfElementLocated(By.xpath("//input[@placeholder='Enter Answer']")));
					driver1.findElement(By.xpath("//input[@placeholder='Enter Answer']")).sendKeys("test");
					wait1.until(ExpectedConditions
							.elementToBeClickable(By.xpath("//input[@class='ansSubmitBtn btn--inside uppercase']")));
					driver1.findElement(By.xpath("//input[@class='ansSubmitBtn btn--inside uppercase']")).click();
					// driver.switchTo().window(driver.getWindowHandle());
					driver.switchTo().window(driver.getWindowHandle());
					Thread.sleep(2000);
					wait.until(
							ExpectedConditions.presenceOfElementLocated(By.xpath("//i[@class='fa fa-check right']")));
					driver.findElement(By.xpath("//i[@class='fa fa-check right']")).click();
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='backToBoard']")));
					driver.findElement(By.xpath("//button[@class='backToBoard']")).click();
					// System.out.println("value of p at end>>"+p);
				
				}
				wait.until(
						ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='skipToFinalFactile']")));
				driver.findElement(By.xpath("//span[@class='skipToFinalFactile']")).click();
				// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
						"//div[@class='swal-modal']//button[@class='swal-button swal-button--confirm btn-success swal-button--danger']")));
				driver.findElement(By.xpath(
						"//div[@class='swal-modal']//button[@class='swal-button swal-button--confirm btn-success swal-button--danger']"))
						.click();
				driver1.switchTo().window(driver1.getWindowHandle());
				wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='moneyHolder']")));
				String moneyvalue = driver1.findElement(By.xpath("//span[@class='moneyHolder']")).getText();
				System.out.println("moneyholder:=" + moneyvalue);
				wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='wagerInput']")));
				driver1.findElement(By.xpath("//input[@class='wagerInput']")).sendKeys(moneyvalue);
				wait1.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//input[@class='wagerPlayBtn btn--inside uppercase']")));
				driver1.findElement(By.xpath("//input[@class='wagerPlayBtn btn--inside uppercase']")).click();
				driver.switchTo().window(driver.getWindowHandle());
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='playFinalJeopardy']")));
				driver.findElement(By.xpath("//span[@id='playFinalJeopardy']")).click();
				driver1.switchTo().window(driver1.getWindowHandle());
				wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='mr-2']")));
				wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Buzz!')]")));
				driver1.findElement(By.xpath("//div[contains(text(),'Buzz!')]")).click();
				wait1.until(
						ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Enter Answer']")));
				driver1.findElement(By.xpath("//input[@placeholder='Enter Answer']")).sendKeys("test");
				wait1.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//input[@class='ansSubmitBtn btn--inside uppercase']")));
				driver1.findElement(By.xpath("//input[@class='ansSubmitBtn btn--inside uppercase']")).click();
				Thread.sleep(2000);
				wait.until(
						ExpectedConditions.presenceOfElementLocated(By.xpath("//i[@class='fa fa-check right']")));
				driver.findElement(By.xpath("//i[@class='fa fa-check right']")).click();
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='backToBoard']")));
				driver.findElement(By.xpath("//button[@class='backToBoard']")).click();
				Thread.sleep(2000);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class='winnerTopHeader']")));
				String header = driver.findElement(By.xpath("//h2[@class='winnerTopHeader']")).getText();
				Thread.sleep(2000);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class='winnerTeamName']")));
				String winningTeamOnModeater = driver.findElement(By.xpath("//h1[@class='winnerTeamName']")).getText();
				System.out.println("winner team on moderater screen= " + winningTeamOnModeater);
				driver1.switchTo().window(driver1.getWindowHandle());
				wait1.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//h1[@class='WinnerScreen-winner-team-name']")));
				String winningTeamOnPlayerScreen = driver1
						.findElement(By.xpath("//h1[@class='WinnerScreen-winner-team-name']")).getText();
				Assert.assertEquals(winningTeamOnModeater, winningTeamOnPlayerScreen); 
				Log.info("Double factile is working fine");
				System.out.println("Double factile is working fine.");

			}
		}
	}
}
