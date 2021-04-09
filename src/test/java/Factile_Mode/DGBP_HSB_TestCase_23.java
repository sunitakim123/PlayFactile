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

public class DGBP_HSB_TestCase_23 extends Base {
	WebDriver driver;
	WebDriver driver1;
	WebDriver driver2;
	WebDriverWait wait, wait1, wait2;
	int int2;
	String s6, s7, GameName, twitterLink, PintrestLink, t1, p1, parent, expectedValue, actualValue,
			PlayerNameAtmodraterscreen, PlayerNameAtPlayerScreen, url, url1;
	WebElement ElementNotGoingToVisible;
	Actions act, act1, act2, act3, act4;

	public static Logger Log = LogManager.getLogger(DGBP_HSB_TestCase_23.class.getName());
	private static String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\images\\eagle.jpg";

	@BeforeTest
	public void initilize() throws IOException {
		driver = IntilizeDriver();
		 Dimension d = new Dimension(1382,744);
		 driver.manage().window().setSize(d);
		Log.info("Driver is Initilize");
		driver.get(prop.getProperty("rooturl"));
		wait = new WebDriverWait(driver, 60);
		Log.info("Navigated to homePage");

	}

	@Test
	public void TC_23_Verify_Show_Final_Factile_Category_Hint_at_Wager_Time() throws InterruptedException, IOException {
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
		 Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
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
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ffCategoryHint']")));
		if (driver.findElement(By.xpath("//input[@id='ffCategoryHint']")).isSelected()) {
			System.out.println("already selected");
		} else {
			act3 = new Actions(driver);
			act3.moveToElement(driver.findElement(By.xpath("//input[@id='ffCategoryHint']"))).click().perform();

		}
		Log.info("At customization page>> >>Show Final Factile Category Hint at Wager Time is checked");
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
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='enterAnserBuzz']")));
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
		driver.findElement(
				By.xpath("//div[@data-text='" + GameName + "']/following-sibling::div/span[contains(text(), 'Edit')]"))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[@class='btn finalJeopardyButton completeEditBlockFinal position-relative']")));
		driver.findElement(
				By.xpath("//button[@class='btn finalJeopardyButton completeEditBlockFinal position-relative']"))
				.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='ffCategory']")));
		// Thread.sleep(2000);
		Select dropCategory = new Select(driver.findElement(By.xpath("//select[@id='ffCategory']")));
		dropCategory.selectByIndex(1);
		// Thread.sleep(2000);
		String storedCategory = driver.findElement(By.xpath("//select[@id='ffCategory']//option[2]")).getText();
		System.out.println("category>>" + storedCategory);
		String s1 = "CATEGORY :- ";
		String ExpectedCATEGORY = s1.concat(storedCategory);
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='btn btn-success font-weight-bold btn-sm']")));
		driver.findElement(By.xpath("//button[@class='btn btn-success font-weight-bold btn-sm']")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='editHomeIcon']")));
		driver.findElement(By.xpath("//div[@class='editHomeIcon']")).click();
		// String storedCategory =dropCategory.selectByIndex(1).

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
				 Dimension d1 = new Dimension(1382,744);
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
				
					driver1.findElement(By.xpath("//input[@class='joinBtn yellowBG mt-4 mb-4']")).click();
				
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
				Thread.sleep(2000);
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
					wait1.until(
							ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Buzz!')]")));

					WebElement ele = driver1.findElement(By.xpath("//div[contains(text(),'Buzz!')]"));
					JavascriptExecutor executor = (JavascriptExecutor) driver1;
					executor.executeScript("arguments[0].click();", ele);

					
						wait1.until(ExpectedConditions
								.presenceOfElementLocated(By.xpath("//textarea[@placeholder='Enter Answer']")));
						driver1.findElement(By.xpath("//textarea[@placeholder='Enter Answer']")).sendKeys("test");
						wait1.until(ExpectedConditions.elementToBeClickable(
								By.xpath("//input[@class='ansSubmitBtn btn--inside uppercase']")));
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
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='ffCategoryHint']")));
				String acutalCATEGORY = driver.findElement(By.xpath("//span[@id='ffCategoryHint']")).getText();

				Assert.assertEquals(ExpectedCATEGORY, acutalCATEGORY);
				System.out.println("Category is visible on moderater screen for final factile page");
				driver1.switchTo().window(driver1.getWindowHandle());
				wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='moneyHolder']")));
				String moneyvalue = driver1.findElement(By.xpath("//span[@class='moneyHolder']")).getText();
				System.out.println("moneyholder:=" + moneyvalue);

				wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='wagerInput']")));
				driver1.findElement(By.xpath("//input[@class='wagerInput']")).sendKeys(moneyvalue);
			
					wait1.until(ExpectedConditions.presenceOfElementLocated(
							By.xpath("//input[@class='wagerPlayBtn btn--inside uppercase']")));
					driver1.findElement(By.xpath("//input[@class='wagerPlayBtn btn--inside uppercase']")).click();
				

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
				
				Thread.sleep(2000);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//i[@class='fa fa-check right']")));
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
			}
		}

	}
}
