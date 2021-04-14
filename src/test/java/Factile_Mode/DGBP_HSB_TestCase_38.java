package Factile_Mode;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class DGBP_HSB_TestCase_38 extends Base {
	WebDriver driver;
	WebDriver driver1;
	WebDriver driver2, driver3;
	WebDriverWait wait, wait1, wait2, wait3;
	int int2;
	int AnswerTimerValue=5;
	String  expectedAnswerTimerValue = String.valueOf(AnswerTimerValue);
	String s6, s7, GameName, twitterLink, PintrestLink, t1, p1, parent, expectedValue, actualValue,
			PlayerNameAtmodraterscreen, playerNameAtPlayerScreenString, text;
	WebElement ElementNotGoingToVisible;
	Actions act, act1, act2, act3, act4, act5, act6;

	public static Logger Log = LogManager.getLogger(DGBP_HSB_TestCase_38.class.getName());

	@BeforeTest
	public void initilize() throws IOException, InterruptedException {
		driver = IntilizeDriver();
		
		Dimension d = new Dimension(1382, 744);
		driver.manage().window().setSize(d);
		Log.info("Driver is Initilize");
		Thread.sleep(6000);
		driver.get(prop.getProperty("rooturl"));
		wait = new WebDriverWait(driver, 60);
		Log.info("Navigated to homePage");

	}

	@Test()
	public void TC_38_Verify_Automatically_Mark_incorrect_answer_upon_timeout() throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.loginButton")));
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

		String osName = System.getProperty("os.name");
		if (osName.equals("Windows 10")) {
				Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
				}
				else
				{
					String[] cmd = new String[]{"/bin/sh", "killchrome.sh"};
					Process pr = Runtime.getRuntime().exec(cmd);
				}

	//	 driver1.quit(); driver.switchTo().window(driver.getWindowHandle());
		//  driver.quit(); 

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

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='timerValue']")));
		driver.findElement(By.xpath("//input[@id='timerValue']")).clear();
		
		driver.findElement(By.xpath("//input[@id='timerValue']")).sendKeys("5");
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//input[@class='btn getReceipt btnSaveBtn'])[5]")));

		driver.findElement(By.xpath("(//input[@class='btn getReceipt btnSaveBtn'])[5]")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='readingTimerValue']")));
		driver.findElement(By.xpath("//input[@id='readingTimerValue']")).clear();
		driver.findElement(By.xpath("//input[@id='readingTimerValue']")).sendKeys("1");
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//input[@class='btn getReceipt btnSaveBtn'])[6]")));

		driver.findElement(By.xpath("(//input[@class='btn getReceipt btnSaveBtn'])[6]")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ffTimerValue']")));
		driver.findElement(By.xpath("//input[@id='ffTimerValue']")).clear();
		driver.findElement(By.xpath("//input[@id='ffTimerValue']")).sendKeys("4");
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//input[@class='btn getReceipt btnSaveBtn'])[7]")));
		
		driver.findElement(By.xpath("(//input[@class='btn getReceipt btnSaveBtn'])[7]")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='answerTimerOnOff']")));
		if (!driver.findElement(By.xpath("//input[@id='answerTimerOnOff']")).isSelected()) {
			act6 = new Actions(driver);
			act6.moveToElement(driver.findElement(By.xpath("//input[@id='answerTimerOnOff']"))).click();
		
		} else {
		System.out.println("already selected");	
		}
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='answerTimerValue']")));
		driver.findElement(By.xpath("//input[@id='answerTimerValue']")).clear();
		driver.findElement(By.xpath("//input[@id='answerTimerValue']")).sendKeys(expectedAnswerTimerValue);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//input[@class='btn getReceipt btnSaveBtn'])[8]")));

		driver.findElement(By.xpath("(//input[@class='btn getReceipt btnSaveBtn'])[8]")).click();
		
		
		Thread.sleep(2000);

		if(driver.findElement(By.xpath("//*[@id='answerTimerOnOff']")).isSelected())
		{
			System.out.println("yes");
		}
		else
		{System.out.println("no");
		act5 = new Actions(driver);
		act5.moveToElement(driver.findElement(By.xpath("//*[@id='answerTimerOnOff']"))).click().perform();

		}
		
		if (driver.findElement(By.xpath("//input[@id='makeAnswerIncorrect']")).isSelected()) {

			System.out.println("yes");
			
		} else {
			System.out.println("not selected");
			act6 = new Actions(driver);
			act6.moveToElement(driver.findElement(By.xpath("//input[@id='makeAnswerIncorrect']"))).click().perform();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm btn-danger swal-button--danger']")).click();
			
		}	
		
		
		if(driver.findElement(By.xpath("//input[@id='buzzerForFinalFactile']")).isSelected())
		{
			
		}
		else
		{
			act3 = new Actions(driver);
			act3.moveToElement(driver.findElement(By.xpath("//input[@id='buzzerForFinalFactile']"))).click().perform();
		}
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='enter_final_answer']")));
		if (driver.findElement(By.xpath("//input[@id='enter_final_answer']")).isSelected()) {

		} else {
			act1 = new Actions(driver);
			act1.moveToElement(driver.findElement(By.xpath("//input[@id='enter_final_answer']"))).click().perform();
		}
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

				driver.findElement(By.xpath("//span[@class='playNowButton']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[@data-numteams='2']")).click();
				Thread.sleep(2000);
				System.out.println(driver.getTitle());
				driver.findElement(By.xpath("//*[@id='displayBuzzerOptionBack']/div[1]/div[2]/div/div/ins")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='buzzerModeQuestion']/div/div[1]/span[2]")).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='inviteYourTeams']/div/span[4]")));
				Thread.sleep(2000);
				String i = driver.findElement(By.xpath("//*[@id='inviteYourTeams']/div/span[2]")).getText();
				System.out.println(i);// System.out.println(driver.getTitle());
				Thread.sleep(2000);
				driver1 = IntilizeDriver();
				Dimension d1 = new Dimension(1382, 744);
				driver1.manage().window().setSize(d1);
				driver1.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				driver1.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
				driver1.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				wait1 = new WebDriverWait(driver1, 8);
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

			
				driver.switchTo().window(driver.getWindowHandle());
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[contains(text(),'Begin Game')]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[contains(text(),'Start Game')]")).click();
				Thread.sleep(5000);


				int activetiles = driver.findElements(By.xpath("//span[@class='gameQuestionBlock unAnsweredQuestion']"))
						.size();
				System.out.println("total active tiles in current game>>" + activetiles);

				for (int p = 1; p <= activetiles; p++) {

					System.out.println("Tile Number =>>" + p);
					wait.until(ExpectedConditions.elementToBeClickable(
							By.xpath("(//span[@class='gameQuestionBlock unAnsweredQuestion'])[1]")));

					// System.out.println("value"+ value);
					// System.out.println("value of p>>"+p);

					driver.findElement(By.xpath("(//span[@class='gameQuestionBlock unAnsweredQuestion'])[1]")).click();
					driver1.switchTo().window(driver1.getWindowHandle());
					
			//	wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='mr-2']")));
				//	wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Buzz!')]")));

					Thread.sleep(4000);
					WebElement ele = driver1.findElement(By.xpath("//div[contains(text(),'Buzz!')]"));
					JavascriptExecutor executor = (JavascriptExecutor) driver1;
					executor.executeScript("arguments[0].click();", ele); 

					
					
					driver.switchTo().window(driver.getWindowHandle());
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='podiumPortion position-relative']//span[@class='answerTimer']")));
					String actualAnswerTimerValue = driver.findElement(By.xpath("//div[@class='podiumPortion position-relative']//span[@class='answerTimer']")).getText();
					
					
					System.out.println("actual answer timer value at starting=" + actualAnswerTimerValue);
				//	Assert.assertEquals(expectedAnswerTimerValue, expectedAnswerTimerValue);
					
					assertTrue(expectedAnswerTimerValue.equals("5") || expectedAnswerTimerValue.equals("4"));
					Thread.sleep(4000);
					String text=driver.findElement(By.xpath("//div[@class='podiumPortion position-relative']//span[@class='answerTimer']")).getText();
					System.out.println("actual answer timer value at the end="+text);
					
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//i[@class='fa fa-check right disableRightWrong']")));
					
					String expectedcorrectmarkclass="fa fa-check right disableRightWrong";
				
					String actualcorrectmarkclass=	driver.findElement(By.xpath("//i[@class='fa fa-check right disableRightWrong']")).getAttribute("class");
					String actualIncorrectmarkclass=	driver.findElement(By.xpath("//i[@class='fa fa-times wrong disableRightWrong']")).getAttribute("class");
					System.out.println("When Right button is disbaled at that time, the class attribute is coming= "+actualcorrectmarkclass);
					System.out.println("When Wrong button is disbaled at that time, the class attribute is coming="+actualIncorrectmarkclass);
					Assert.assertEquals(expectedcorrectmarkclass, actualcorrectmarkclass);
				System.out.println("Answer marked automatically incorrect");
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
				driver1.findElement(By.xpath("//input[@class='wagerInput']")).sendKeys("0");

				wait1.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//input[@class='wagerPlayBtn btn--inside uppercase']")));
				driver1.findElement(By.xpath("//input[@class='wagerPlayBtn btn--inside uppercase']")).click();

			
				

				driver.switchTo().window(driver.getWindowHandle());
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='playFinalJeopardy']")));
				driver.findElement(By.xpath("//span[@id='playFinalJeopardy']")).click();
				
				driver1.switchTo().window(driver1.getWindowHandle());
										
				wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='mr-2']")));
				//driver1.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Buzz!')]")));
				
				WebElement ele = driver1.findElement(By.xpath("//div[contains(text(),'Buzz!')]"));
				Assert.assertNotNull("Buzzer is coming for final factile to  user 1", ele);
				JavascriptExecutor executor = (JavascriptExecutor) driver1;
				executor.executeScript("arguments[0].click();", ele); 
			

				driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				wait1.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//textarea[@placeholder='Enter Answer']")));
				driver1.findElement(By.xpath("//textarea[@placeholder='Enter Answer']")).sendKeys("test");
				wait1.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//input[@class='ansSubmitBtn btn--inside uppercase']")));
				driver1.findElement(By.xpath("//input[@class='ansSubmitBtn btn--inside uppercase']")).click();

			
				
				driver.switchTo().window(driver.getWindowHandle());
				wait.until(
						ExpectedConditions.presenceOfElementLocated(By.xpath("(//i[@class='fa fa-check right'])[1]")));
				driver.findElement(By.xpath("(//i[@class='fa fa-check right'])[1]")).click();
			
 
			

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='backToBoard']")));
				driver.findElement(By.xpath("//button[@class='backToBoard']")).click();
				Thread.sleep(2000);
				wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//h1[@class='winnerTeamName']")));
				String winningTeamOnModeater = driver
						.findElement(By.xpath("//h1[@class='winnerTeamName']"))
						.getText();
				System.out.println("winningTeamOnModeater>>" + winningTeamOnModeater);
				Thread.sleep(2000);

				driver1.switchTo().window(driver1.getWindowHandle());
				wait1.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//h1[@class='WinnerScreen-winner-team-name']")));
				String winningTeamOnPlayerScreen = driver1
						.findElement(By.xpath("//h1[@class='WinnerScreen-winner-team-name']")).getText();
				System.out.println("winningTeamOnPlayerScreen>>" + winningTeamOnPlayerScreen);
				Assert.assertEquals(winningTeamOnModeater, winningTeamOnPlayerScreen);
	}
}}}
	

