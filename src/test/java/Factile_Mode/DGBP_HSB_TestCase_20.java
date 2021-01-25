package Factile_Mode;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.spi.FileSystemProvider;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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

public class DGBP_HSB_TestCase_20 extends Base {
	WebDriver driver;
	WebDriver driver1;
	WebDriverWait wait, wait1;
	int int2;
	String s6, s7, GameName, twitterLink, PintrestLink, t1, p1, parent, expectedValue, actualValue,
			PlayerNameAtmodraterscreen, PlayerNameAtPlayerScreen;
	WebElement ElementNotGoingToVisible;
	Actions act, act1;

	public static Logger Log = LogManager.getLogger(DGBP_HSB_TestCase_20.class.getName());
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
	public void TC_20_Verify_Double_Double() throws InterruptedException, IOException {
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
	public void tearDown() throws InterruptedException {

		 driver1.quit();
		driver.switchTo().window(driver.getWindowHandle());
		driver.quit();
	}

	public void modeaterscreen() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("customize")));
		driver.findElement(By.id("customize")).click();
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//span[@class='resetToDefault resetCustomizations'])[4]")));
		driver.findElement(By.xpath("(//span[@class='resetToDefault resetCustomizations'])[4]")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//button[@class='swal-button swal-button--confirm btn-danger swal-button--danger']")));
		driver.findElement(
				By.xpath("//button[@class='swal-button swal-button--confirm btn-danger swal-button--danger']")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[@class='swal-button swal-button--confirm']")));
		driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//span[@class='resetToDefault resetCustomizations'])[6]")));
		driver.findElement(By.xpath("(//span[@class='resetToDefault resetCustomizations'])[6]")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//button[@class='swal-button swal-button--confirm btn-danger swal-button--danger']")));
		driver.findElement(
				By.xpath("//button[@class='swal-button swal-button--confirm btn-danger swal-button--danger']")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[@class='swal-button swal-button--confirm']")));
		driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']")).click();
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//input[@id='enterAnserBuzz']")).isSelected())
		{
			
		}
		else
		{
			act1 = new Actions(driver);
			act1.moveToElement(driver.findElement(By.xpath("//input[@id='enterAnserBuzz']"))).click().perform();
		}
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='dailyDouble']")));
		if (driver.findElement(By.xpath("//input[@id='dailyDouble']")).isSelected()) {
			System.out.println("nothing to do");
		} else {
			act = new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//input[@id='dailyDouble']"))).click().perform();

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
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//div[@class='gameQuestionsBox'])[1]//span[3]")));
		driver.findElement(By.xpath("(//div[@class='gameQuestionsBox'])[1]//span[3]")).click();
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
		// driver.findElement(By.xpath("")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='toggleDailyDouble']")));
		driver.findElement(By.xpath("//span[@id='toggleDailyDouble']")).click();
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@data-num='1']//span[@data-points='200']//div[2]//span")));
		String value = driver.findElement(By.xpath("//div[@data-num='1']//span[@data-points='200']"))
				.getAttribute("data-points");
		System.out.println("Value of tile is =" + value);
		int i = Integer.parseInt(value);
		i = i * 2;
		String Doublevalue = String.valueOf(i);
		String expectedvalue = "$" + Doublevalue;
		System.out.println("expected value=" + expectedvalue);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//div[@data-cat-num='1'])[2]")));
		String v1 = driver.findElement(By.xpath("(//div[@data-cat-num='1'])[2]")).getAttribute("class");
		String v2 = "dailyDoubleOff selectDailyDouble";
		if (v1.equalsIgnoreCase(v2)) {
			driver.findElement(By.xpath("(//span[@class='dailyDouble tooltip-icon'])[2]")).click();
		} else {
			System.out.println("dd is selected");
		}

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='gameSettings']")));
		driver.findElement(By.xpath("//span[@id='gameSettings']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-toggle='button']")));
		String buttonON = driver.findElement(By.xpath("//button[@data-toggle='button']")).getAttribute("class");
		String expect = "btn btn-lg btn-toggle d-inline-block switchBtn active";
		if (buttonON.equalsIgnoreCase(expect)) {
			driver.findElement(By.xpath("//button[@data-toggle='button']")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='saveSettings']")));
			driver.findElement(By.xpath("//button[@id='saveSettings']")).click();
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//button[@class='swal-button swal-button--confirm']")));
			driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']")).click();

		} else {
			System.out.println("Is already off");
		}

		driver.navigate().back();

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
				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[@data-numteams='2']")).click();
				Thread.sleep(3000);
				System.out.println(driver.getTitle());
				driver.findElement(By.xpath("//*[@id='displayBuzzerOptionBack']/div[1]/div[2]/div/div/ins")).click();

				driver.findElement(By.xpath("//*[@id='buzzerModeQuestion']/div/div[1]/span[2]")).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='inviteYourTeams']/div/span[4]")));
				Thread.sleep(3000);
				String y = driver.findElement(By.xpath("//*[@id='inviteYourTeams']/div/span[2]")).getText();
				System.out.println(y);// System.out.println(driver.getTitle());
				Thread.sleep(3000);

				driver1 = IntilizeDriver();
				Dimension d1 = new Dimension(1382, 744);
				driver1.manage().window().setSize(d1);
				driver1.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				driver1.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
				driver1.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				wait1 = new WebDriverWait(driver1, 50);
				driver1.get(prop.getProperty("joinurl"));
				String url = driver1.getCurrentUrl();
				Thread.sleep(2000);
				driver1.findElement(By.xpath("//input[@class='form-control']")).sendKeys(y);
				Thread.sleep(1000);
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
				Thread.sleep(2000);

				int activetiles = driver.findElements(By.xpath("//span[@class='gameQuestionBlock unAnsweredQuestion']"))
						.size();
				System.out.println("total active tiles in second game>>" + activetiles);

				for (int p = 2; p <= 2; p++) {

					System.out.println("value of p>>" + p);
					wait.until(ExpectedConditions.elementToBeClickable(
							By.xpath("(//span[@class='gameQuestionBlock unAnsweredQuestion'])[2]")));
					String value1 = driver
							.findElement(By.xpath("(//span[@class='gameQuestionBlock unAnsweredQuestion'])[2]"))
							.getText();
					System.out.println("value" + value1);
					System.out.println("value of p>>" + p);
					driver.findElement(By.xpath("(//span[@class='gameQuestionBlock unAnsweredQuestion'])[2]")).click();
					driver1.switchTo().window(driver1.getWindowHandle());

					wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='mr-2']")));
					wait1.until(
							ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Buzz!')]")));
					driver1.findElement(By.xpath("//div[contains(text(),'Buzz!')]")).click();
					
						wait1.until(ExpectedConditions
								.presenceOfElementLocated(By.xpath("//textarea[@placeholder='Enter Answer']")));
						driver1.findElement(By.xpath("//textarea[@placeholder='Enter Answer']")).sendKeys("test");
						wait1.until(ExpectedConditions.elementToBeClickable(
								By.xpath("//input[@class='ansSubmitBtn btn--inside uppercase']")));
						driver1.findElement(By.xpath("//input[@class='ansSubmitBtn btn--inside uppercase']")).click();
					
					driver.switchTo().window(driver.getWindowHandle());
					Thread.sleep(2000);
					wait.until(
							ExpectedConditions.presenceOfElementLocated(By.xpath("//i[@class='fa fa-check right']")));
					driver.findElement(By.xpath("//i[@class='fa fa-check right']")).click();
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='backToBoard']")));
					driver.findElement(By.xpath("//button[@class='backToBoard']")).click();
					Thread.sleep(1500);
					// System.out.println("value of p at end>>"+p);
				}

				driver1.switchTo().window(driver1.getWindowHandle());
				wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='moneyHolder']")));
				String ActualValue1 = driver1.findElement(By.xpath("(//span[@class='moneyHolder'])[1]")).getText();
				String ActualValue2 = driver1.findElement(By.xpath("(//span[@class='moneyHolder'])[2]")).getText();
				System.out.println("Money" + ActualValue1);
				System.out.println("Money" + ActualValue2);

				Assert.assertEquals(expectedvalue, ActualValue1);
				Assert.assertEquals(expectedvalue, ActualValue2);
				System.out.println("Daily double is working fine.");
				// Log.info("Double factile is working fine");
				// System.out.println("Double factile is working fine.");

			}
		}
	}
}
