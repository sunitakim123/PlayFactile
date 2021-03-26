package Factile_Mode;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
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

public class DGBP_HSB_TestCase_22 extends Base {
	WebDriver driver;
	WebDriver driver1;
	WebDriverWait wait, wait1;
	int int2;
	String s6, s7, GameName, twitterLink, PintrestLink, t1, p1, parent, expectedValue, actualValue,
			PlayerNameAtmodraterscreen, PlayerNameAtPlayerScreen;
	WebElement ElementNotGoingToVisible;
	Actions act, act1, act2, act3, act4;

	public static Logger Log = LogManager.getLogger(DGBP_HSB_TestCase_22.class.getName());
	private static String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\images\\eagle.jpg";

	@BeforeTest
	public void initilize() throws IOException {
		driver = IntilizeDriver();
		Dimension d = new Dimension(1382, 744);
		driver.manage().window().setSize(d);
		Log.info("Driver is Initilize");
		driver.get(prop.getProperty("rooturl"));
		wait = new WebDriverWait(driver, 60);
		Log.info("Navigated to homePage");

	}

	@Test
	public void TC_22_Verify_Skip_Final_Factile() throws InterruptedException, IOException {
		driver.findElement(By.cssSelector("span.loginButton")).click();
		driver.findElement(By.id("email")).sendKeys(prop.getProperty("username"));

		driver.findElement(By.id("password")).sendKeys(prop.getProperty("pwd"));
		driver.findElement(By.cssSelector("input.accountActionButton")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='settings']")));
		driver.findElement(By.xpath("//span[@id='settings']")).click();
		String url1 = driver.getCurrentUrl();

		if (driver.findElement(By.xpath("//div[@class='col-md-12 paidOfflineLabel']")).isDisplayed()) {

			modeaterscreen();
			PlayerScreen();
		}

		else {
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
		driver.findElement(By.id("customize")).click();
		Thread.sleep(2000);
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='resetAll resetCustomizations']")));
		driver.findElement(By.xpath("//button[@class='resetAll resetCustomizations']")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//button[@class='swal-button swal-button--confirm btn-danger swal-button--danger']")));
		driver.findElement(
				By.xpath("//button[@class='swal-button swal-button--confirm btn-danger swal-button--danger']")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[@class='swal-button swal-button--confirm']")));
		driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']")).click();
		Thread.sleep(2000);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='skip_ff']")));
		if (driver.findElement(By.xpath("//input[@id='skip_ff']")).isSelected()) {
			System.out.println("Skip is already selected");
		} else {
			act3 = new Actions(driver);
			act3.moveToElement(driver.findElement(By.xpath("//input[@id='skip_ff']"))).click().perform();

		}
		Log.info("At customization page>> >>Show skip answer is selected ");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='readingTimerValue']")));
		driver.findElement(By.xpath("//input[@id='readingTimerValue']")).clear();
		driver.findElement(By.xpath("//input[@id='readingTimerValue']")).sendKeys("6");
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//input[@class='btn getReceipt btnSaveBtn'])[5]")));

		driver.findElement(By.xpath("(//input[@class='btn getReceipt btnSaveBtn'])[5]")).click();
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//input[@id='answerTimerOnOff']")).isSelected()) {

		} else {
			act = new Actions(driver);
		}
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//input[@id='enterAnserBuzz']")).isSelected()) {

		} else {
			act1 = new Actions(driver);
			act1.moveToElement(driver.findElement(By.xpath("//input[@id='enterAnserBuzz']"))).click().perform();
		}

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
		Thread.sleep(2000);
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

		Thread.sleep(2000);
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
				Thread.sleep(2000);
				System.out.println(driver.getTitle());
				driver.findElement(By.xpath("//*[@id='displayBuzzerOptionBack']/div[1]/div[2]/div/div/ins")).click();

				driver.findElement(By.xpath("//*[@id='buzzerModeQuestion']/div/div[1]/span[2]")).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='inviteYourTeams']/div/span[4]")));
				Thread.sleep(2000);
				String i = driver.findElement(By.xpath("//*[@id='inviteYourTeams']/div/span[2]")).getText();
				System.out.println(i);// System.out.println(driver.getTitle());

				driver1 = IntilizeDriver();
				Dimension d1 = new Dimension(1382, 744);
				driver1.manage().window().setSize(d1);
				driver1.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				driver1.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
				driver1.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				wait1 = new WebDriverWait(driver1, 60);
				driver1.get(prop.getProperty("joinurl"));
				String url = driver1.getCurrentUrl();
				Thread.sleep(2000);
				driver1.findElement(By.xpath("//input[@class='form-control']")).sendKeys(i);

				Thread.sleep(2000);
				// String url = driver1.getCurrentUrl();
				if (url.equals("https://game.playfactile.com/join")) {
					// live join button
					driver1.findElement(By.xpath("//input[@class='joinBtn yellowBG mt-4 mb-4']")).click();
				} else {
					driver1.findElement(By.xpath("//input[@class='btn joinBtn yellowBG mt-4 mb-4']")).click();
				}
				Thread.sleep(2000);
				driver1.findElement(By.xpath("(//div[@class='characterBlock position-relative'])[last()]")).click();

				driver.switchTo().window(driver.getWindowHandle());
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[contains(text(),'Begin Game')]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[contains(text(),'Start Game')]")).click();
				Thread.sleep(2000);

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
					Thread.sleep(4000);
					//wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='mr-2']")));
					wait1.until(
							ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Buzz!')]")));

					WebElement ele = driver1.findElement(By.xpath("//div[contains(text(),'Buzz!')]"));
					JavascriptExecutor executor = (JavascriptExecutor) driver1;
					executor.executeScript("arguments[0].click();", ele);

					wait1.until(ExpectedConditions
							.presenceOfElementLocated(By.xpath("//textarea[@placeholder='Enter Answer']")));
					driver1.findElement(By.xpath("//textarea[@placeholder='Enter Answer']")).sendKeys("test");
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
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class='winnerTeamName']")));
				String winningTeamOnModeater = driver.findElement(By.xpath("//h1[@class='winnerTeamName']")).getText();
				System.out.println("winner team on moderater screen= " + winningTeamOnModeater);
				driver1.switchTo().window(driver1.getWindowHandle());
				Thread.sleep(2000);
				wait1.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//h1[@class='WinnerScreen-winner-team-name']")));
				String winningTeamOnPlayerScreen = driver1
						.findElement(By.xpath("//h1[@class='WinnerScreen-winner-team-name']")).getText();
				Assert.assertEquals(winningTeamOnModeater, winningTeamOnPlayerScreen);
				System.out.println(
						"final factile is skipped, winner screen is coming after all gameboard questions finished");

			}
		}
	}
}
