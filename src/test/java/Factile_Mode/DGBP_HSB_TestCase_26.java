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

public class DGBP_HSB_TestCase_26 extends Base {
	WebDriver driver;
	WebDriver driver1;
	WebDriver driver2, driver3;
	WebDriverWait wait, wait1, wait2, wait3;
	int int2;
	String s6, s7, GameName, twitterLink, PintrestLink, t1, p1, parent, expectedValue, actualValue,
			PlayerNameAtmodraterscreen, PlayerNameAtPlayerScreen;
	WebElement ElementNotGoingToVisible;
	Actions act, act1, act2, act3, act4;

	public static Logger Log = LogManager.getLogger(DGBP_HSB_TestCase_26.class.getName());
	private static String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\images\\eagle.jpg";

	@BeforeTest
	public void initilize() throws IOException, InterruptedException {
		Thread.sleep(3000);
		driver = IntilizeDriver();
		Dimension d = new Dimension(1382, 744);
		driver.manage().window().setSize(d);
		Log.info("Driver is Initilize");
		
		driver.get(prop.getProperty("rooturl"));
		wait = new WebDriverWait(driver, 60);
		Log.info("Navigated to homePage");

	}

	@Test
	public void TC_26_Users_Can_Join_Buzzer_Mode_after_Game_Begins_directly_using_Pin()
			throws InterruptedException, IOException {
		driver.findElement(By.cssSelector("span.loginButton")).click();
		driver.findElement(By.id("email")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("pwd"));
		driver.findElement(By.cssSelector("input.accountActionButton")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='settings']")));
		driver.findElement(By.xpath("//span[@id='settings']")).click();
		String url1 = driver.getCurrentUrl();

		
		if (driver.findElement(By.xpath("//div[@class='col-md-12 currentActivePlanLabel']")).isDisplayed()) {

			modeaterscreen();
			PlayerScreen();
		}
	
	
	else {
		System.out.println("You have not taken any subscription");
	}
}
	@AfterTest
	public void tearDown() throws InterruptedException, IOException {

		driver1.quit();
		driver.switchTo().window(driver.getWindowHandle());
		driver.quit();
		driver2.switchTo().window(driver2.getWindowHandle());
		driver2.quit();
		driver3.switchTo().window(driver3.getWindowHandle());
		driver3.quit();
		String osName = System.getProperty("os.name");
		if (osName.equals("Windows 10")) {
				Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
				}
				else
				{
					String[] cmd = new String[]{"/bin/sh", "killchrome.sh"};
					Process pr = Runtime.getRuntime().exec(cmd);
				}
		Thread.sleep(3000);
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
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//span[@class='resetToDefault resetCustomizations'])[6]")));
		driver.findElement(By.xpath("(//span[@class='resetToDefault resetCustomizations'])[6]")).click();
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
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='multipleCorrect']")));
		if (driver.findElement(By.xpath("//input[@id='multipleCorrect']")).isSelected()) {
			System.out.println("already selected");
		} else {
			act3 = new Actions(driver);
			act3.moveToElement(driver.findElement(By.xpath("//input[@id='multipleCorrect']"))).click().perform();

		}

		if (driver.findElement(By.xpath("//input[@id='allowUserToJoinAfterBeginGameInBuzz']")).isSelected()) {
			System.out.println("already selected");
		} else {
			act3 = new Actions(driver);
			act3.moveToElement(driver.findElement(By.xpath("//input[@id='allowUserToJoinAfterBeginGameInBuzz']")))
					.click().perform();

		}

		Log.info("At customization page>> >>Users Can Join Buzzer Mode after Game Begins is checked");
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
			act.moveToElement(driver.findElement(By.xpath("//input[@id='answerTimerOnOff']"))).click();
		}
		
		
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//input[@id='buzzerForFinalFactile']")).isSelected())
		{
			
		}
		else
		{
			act3 = new Actions(driver);
			act3.moveToElement(driver.findElement(By.xpath("//input[@id='buzzerForFinalFactile']"))).click().perform();
		}
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='enter_final_answer']")));
		if (driver.findElement(By.xpath("//input[@id='enter_final_answer']")).isSelected()) {

		} else {
			act1 = new Actions(driver);
			act1.moveToElement(driver.findElement(By.xpath("//input[@id='enter_final_answer']"))).click().perform();
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
		GameName = prop.getProperty("gamename");
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='jeopardy
		// tooltip-icon'])[2]")));

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
				Thread.sleep(2000);

				driver2 = IntilizeDriver();
				Dimension d2 = new Dimension(1382, 744);
				driver2.manage().window().setSize(d2);
				driver2.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				driver2.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
				driver2.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				wait2 = new WebDriverWait(driver2, 60);
				driver2.get(prop.getProperty("joinurl"));

				Thread.sleep(2000);
				driver2.findElement(By.xpath("//input[@class='form-control']")).sendKeys(i);
				Thread.sleep(2000);
				// String url = driver1.getCurrentUrl();
				if (url.equals("https://game.playfactile.com/join")) {
					// live join button
					driver2.findElement(By.xpath("//input[@class='joinBtn yellowBG mt-4 mb-4']")).click();
				} else {
					driver2.findElement(By.xpath("//input[@class='btn joinBtn yellowBG mt-4 mb-4']")).click();
				}
				Thread.sleep(2000);
				driver2.findElement(By.xpath("(//div[@class='characterBlock position-relative'])[last()]")).click();
				Thread.sleep(2000);

				driver.switchTo().window(driver.getWindowHandle());
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[contains(text(),'Begin Game')]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[contains(text(),'Start Game')]")).click();
				Thread.sleep(2000);
				wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//span[@class='selectGamePodiumCandidate']")));
				String pinvisibleOnModraterScreen = driver
						.findElement(By.xpath("//span[@class='selectGamePodiumCandidate']")).getText();
				Assert.assertEquals(i, pinvisibleOnModraterScreen);
				System.out.println("Pin is visible on moderater screen");
				int activetiles = driver.findElements(By.xpath("//span[@class='gameQuestionBlock unAnsweredQuestion']"))
						.size();
				System.out.println("total active tiles in first game>>" + activetiles);

				for (int p = 1; p <= activetiles; p++) {

					System.out.println("value of p>>" + p);
					wait.until(ExpectedConditions.elementToBeClickable(
							By.xpath("(//span[@class='gameQuestionBlock unAnsweredQuestion'])[1]")));

					// System.out.println("value"+ value);
					// System.out.println("value of p>>"+p);

					if (p == 2) {// opening new driver to join the game in the mid
						driver3 = IntilizeDriver();
						Dimension d3 = new Dimension(1382, 744);
						driver3.manage().window().setSize(d3);
						driver3.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
						driver3.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
						driver3.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
						wait3 = new WebDriverWait(driver3, 60);
						driver3.get(prop.getProperty("joinurl"));

						Thread.sleep(2000);
						driver3.findElement(By.xpath("//input[@class='form-control']")).sendKeys(i);
						Thread.sleep(2000);
						// String url = driver1.getCurrentUrl();
						if (url.equals("https://game.playfactile.com/join")) {
							// live join button
							driver3.findElement(By.xpath("//input[@class='joinBtn yellowBG mt-4 mb-4']")).click();
						} else {
							driver3.findElement(By.xpath("//input[@class='btn joinBtn yellowBG mt-4 mb-4']")).click();
						}
						Thread.sleep(2000);
						driver3.findElement(By.xpath("(//div[@class='characterBlock position-relative'])[last()]"))
								.click();

						driver.switchTo().window(driver.getWindowHandle());
						driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
						wait.until(ExpectedConditions
								.presenceOfElementLocated(By.xpath("//span[@class='playerWaitingText']")));
						driver.findElement(By.xpath("//span[@class='playerWaitingText']")).click();
						Thread.sleep(2000);
						wait.until(ExpectedConditions.presenceOfElementLocated(
								By.xpath("//span[@class='cursor-pointer candidateApprove']")));
						driver.findElement(By.xpath("//span[@class='cursor-pointer candidateApprove']")).click();
						wait.until(ExpectedConditions.presenceOfElementLocated(
								By.xpath("//button[@class='btn btn-success completeModal']")));
						driver.findElement(By.xpath("//button[@class='btn btn-success completeModal']")).click();
						Thread.sleep(2000);
						WebElement ThirdUser = driver.findElement(By.xpath("(//div[@class='characterPodium'])[3]"));
						Assert.assertNotNull(allWindows);
						System.out.println("New user has joined the game successfully");

					}

					Thread.sleep(2000);
					driver.findElement(By.xpath("(//span[@class='gameQuestionBlock unAnsweredQuestion'])[1]")).click();
					driver1.switchTo().window(driver1.getWindowHandle());

					wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='mr-2']")));
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

					driver2.switchTo().window(driver2.getWindowHandle());
					// wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='mr-2']")));
					wait2.until(
							ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Buzz!')]")));

					WebElement ele1 = driver2.findElement(By.xpath("//div[contains(text(),'Buzz!')]"));
					JavascriptExecutor executor1 = (JavascriptExecutor) driver2;
					executor1.executeScript("arguments[0].click();", ele1);

					wait2.until(ExpectedConditions
							.presenceOfElementLocated(By.xpath("//textarea[@placeholder='Enter Answer']")));
					driver2.findElement(By.xpath("//textarea[@placeholder='Enter Answer']")).sendKeys("test");
					wait2.until(ExpectedConditions
							.elementToBeClickable(By.xpath("//input[@class='ansSubmitBtn btn--inside uppercase']")));
					driver2.findElement(By.xpath("//input[@class='ansSubmitBtn btn--inside uppercase']")).click();

					if (p >= 2) {
						driver3.switchTo().window(driver3.getWindowHandle());
						// wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='mr-2']")));
						wait3.until(ExpectedConditions
								.presenceOfElementLocated(By.xpath("//div[contains(text(),'Buzz!')]")));

						WebElement ele3 = driver3.findElement(By.xpath("//div[contains(text(),'Buzz!')]"));
						JavascriptExecutor executor3 = (JavascriptExecutor) driver3;
						executor3.executeScript("arguments[0].click();", ele3);

						wait3.until(ExpectedConditions
								.presenceOfElementLocated(By.xpath("//textarea[@placeholder='Enter Answer']")));
						driver3.findElement(By.xpath("//textarea[@placeholder='Enter Answer']")).sendKeys("test");
						wait3.until(ExpectedConditions.elementToBeClickable(
								By.xpath("//input[@class='ansSubmitBtn btn--inside uppercase']")));
						driver3.findElement(By.xpath("//input[@class='ansSubmitBtn btn--inside uppercase']")).click();

					}

					driver.switchTo().window(driver.getWindowHandle());
					Thread.sleep(2000);
					wait.until(ExpectedConditions
							.presenceOfElementLocated(By.xpath("(//i[@class='fa fa-check right'])[1]")));
					driver.findElement(By.xpath("(//i[@class='fa fa-check right'])[1]")).click();
					Thread.sleep(2000);

					wait.until(ExpectedConditions
							.presenceOfElementLocated(By.xpath("(//i[@class='fa fa-check right'])[2]")));
					driver.findElement(By.xpath("(//i[@class='fa fa-check right'])[2]")).click();

					if (p >= 2) {
						wait.until(ExpectedConditions
								.presenceOfElementLocated(By.xpath("(//i[@class='fa fa-check right'])[3]")));
						driver.findElement(By.xpath("(//i[@class='fa fa-check right'])[3]")).click();
					}

					Thread.sleep(2000);
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='backToBoard']")));
					driver.findElement(By.xpath("//button[@class='backToBoard']")).click();
					// System.out.println("value of p at end>>"+p);

					Thread.sleep(2000);
				}

				driver1.switchTo().window(driver1.getWindowHandle());
				wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='moneyHolder']")));
				String moneyvalue = driver1.findElement(By.xpath("//span[@class='moneyHolder']")).getText();
				System.out.println("moneyholder:=" + moneyvalue);

				wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='wagerInput']")));
				driver1.findElement(By.xpath("//input[@class='wagerInput']")).sendKeys(moneyvalue);

				wait1.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//input[@class='wagerPlayBtn btn--inside uppercase']")));
				driver1.findElement(By.xpath("//input[@class='wagerPlayBtn btn--inside uppercase']")).click();

				driver2.switchTo().window(driver2.getWindowHandle());
				wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='moneyHolder'])[2]")));
				String moneyvalue2 = driver2.findElement(By.xpath("(//span[@class='moneyHolder'])[2]")).getText();
				System.out.println("moneyholder2:=" + moneyvalue2);

				wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='wagerInput']")));
				driver2.findElement(By.xpath("//input[@class='wagerInput']")).sendKeys(moneyvalue2);

				wait2.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//input[@class='wagerPlayBtn btn--inside uppercase']")));
				driver2.findElement(By.xpath("//input[@class='wagerPlayBtn btn--inside uppercase']")).click();

				driver3.switchTo().window(driver3.getWindowHandle());
				wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='moneyHolder'])[3]")));
				String moneyvalue3 = driver3.findElement(By.xpath("(//span[@class='moneyHolder'])[3]")).getText();
				System.out.println("moneyholder3:=" + moneyvalue3);

				wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='wagerInput']")));
				driver3.findElement(By.xpath("//input[@class='wagerInput']")).sendKeys(moneyvalue3);

				wait3.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//input[@class='wagerPlayBtn btn--inside uppercase']")));
				driver3.findElement(By.xpath("//input[@class='wagerPlayBtn btn--inside uppercase']")).click();

				driver.switchTo().window(driver.getWindowHandle());
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='playFinalJeopardy']")));
				driver.findElement(By.xpath("//span[@id='playFinalJeopardy']")).click();
				driver1.switchTo().window(driver1.getWindowHandle());

				wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='mr-2']")));
				wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Buzz!')]")));
				WebElement ele = driver1.findElement(By.xpath("//div[contains(text(),'Buzz!')]"));
				JavascriptExecutor executor = (JavascriptExecutor) driver1;
				executor.executeScript("arguments[0].click();", ele);

				driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				wait1.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//textarea[@placeholder='Enter Answer']")));
				driver1.findElement(By.xpath("//textarea[@placeholder='Enter Answer']")).sendKeys("test");
				wait1.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//input[@class='ansSubmitBtn btn--inside uppercase']")));
				driver1.findElement(By.xpath("//input[@class='ansSubmitBtn btn--inside uppercase']")).click();

				driver2.switchTo().window(driver2.getWindowHandle());

				// wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='mr-2']")));
				wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Buzz!')]")));
				WebElement ele2 = driver2.findElement(By.xpath("//div[contains(text(),'Buzz!')]"));
				JavascriptExecutor executor2 = (JavascriptExecutor) driver2;
				executor2.executeScript("arguments[0].click();", ele2);

				driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				wait2.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//textarea[@placeholder='Enter Answer']")));
				driver2.findElement(By.xpath("//textarea[@placeholder='Enter Answer']")).sendKeys("test");
				wait2.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//input[@class='ansSubmitBtn btn--inside uppercase']")));
				driver2.findElement(By.xpath("//input[@class='ansSubmitBtn btn--inside uppercase']")).click();

				driver3.switchTo().window(driver3.getWindowHandle());

				// wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='mr-2']")));
				wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Buzz!')]")));
				WebElement ele3 = driver3.findElement(By.xpath("//div[contains(text(),'Buzz!')]"));
				JavascriptExecutor executor3 = (JavascriptExecutor) driver3;
				executor3.executeScript("arguments[0].click();", ele3);

				driver3.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				wait3.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//textarea[@placeholder='Enter Answer']")));
				driver3.findElement(By.xpath("//textarea[@placeholder='Enter Answer']")).sendKeys("test");
				wait3.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//input[@class='ansSubmitBtn btn--inside uppercase']")));
				driver3.findElement(By.xpath("//input[@class='ansSubmitBtn btn--inside uppercase']")).click();

				driver.switchTo().window(driver.getWindowHandle());
				wait.until(
						ExpectedConditions.presenceOfElementLocated(By.xpath("(//i[@class='fa fa-check right'])[1]")));
				driver.findElement(By.xpath("(//i[@class='fa fa-check right'])[1]")).click();
				wait.until(
						ExpectedConditions.presenceOfElementLocated(By.xpath("(//i[@class='fa fa-check right'])[2]")));
				driver.findElement(By.xpath("(//i[@class='fa fa-check right'])[2]")).click();

				wait.until(
						ExpectedConditions.presenceOfElementLocated(By.xpath("(//i[@class='fa fa-check right'])[3]")));
				driver.findElement(By.xpath("(//i[@class='fa fa-check right'])[3]")).click();

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='backToBoard']")));
				driver.findElement(By.xpath("//button[@class='backToBoard']")).click();
				Thread.sleep(2000);
				wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//div[@id='andTheWinnerIs']/div[2]/h2[@class='winnerTopHeader']")));
				String winningTeamOnModeater = driver
						.findElement(By.xpath("//div[@id='andTheWinnerIs']/div[2]/h2[@class='winnerTopHeader']"))
						.getText();
				System.out.println("winningTeamOnModeater>>" + winningTeamOnModeater);
				Thread.sleep(2000);

				driver1.switchTo().window(driver1.getWindowHandle());
				wait1.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//div[@class='WinnerScreen-winner-top-header']")));
				String winningTeamOnPlayerScreen = driver1
						.findElement(By.xpath("//div[@class='WinnerScreen-winner-top-header']")).getText();
				System.out.println("winningTeamOnPlayerScreen>>" + winningTeamOnPlayerScreen);
				Assert.assertEquals(winningTeamOnModeater, winningTeamOnPlayerScreen);
			}
		}

	}
}
