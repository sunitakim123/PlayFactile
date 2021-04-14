package Factile_Mode;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

public class DGBP_HSB_TestCase_39 extends Base {
	WebDriver driver;
	WebDriver driver1;
	WebDriver driver2, driver3, driver4;
	WebDriverWait wait, wait1, wait2, wait3, wait4;
	ChromeOptions options;
	int int2;
	int FinalFactileTimer = 5;
	String expectedFinalFactileTimer = String.valueOf(FinalFactileTimer);
	String s6, s7, GameName, twitterLink, PintrestLink, t1, p1, parent, expectedValue, actualValue,
			PlayerNameAtmodraterscreen, playerNameAtPlayerScreenString, text;
	String gameURL;
	WebElement ElementNotGoingToVisible;
	Actions act, act1, act2, act3, act4;

	public static Logger Log = LogManager.getLogger(DGBP_HSB_TestCase_39.class.getName());

	@Test
	public void TC_39_Same_Game_playing_from_first_Moderater() throws InterruptedException, IOException {

		driver = IntilizeDriver();
		Dimension d = new Dimension(1382, 744);
		driver.manage().window().setSize(d);

		Log.info("Driver is Initilize");
		//Thread.sleep(6000);
		driver.get(prop.getProperty("rooturl"));
		wait = new WebDriverWait(driver, 60);
		Log.info("Navigated to homePage");
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

	@Test
	public void TC_39_Same_Game_playing_by_second__Moderater() throws InterruptedException, IOException {

		FileInputStream fis = new FileInputStream("./src/main/java/resources/data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			String osName = System.getProperty("os.name");
			if (osName.equals("Windows 10")) {

				System.setProperty("webdriver.chrome.driver3",
						System.getProperty("user.dir") + "\\src\\main\\java\\Drivers\\chromedriver.exe");
				driver3 = new ChromeDriver();
				driver3.manage().window().maximize();
				driver3.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver3.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				driver3.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
			} else {
				String chromeDriverPath = "./src/main/java/LinuxDrivers/chromedriver";
				System.setProperty("webdriver.chrome.driver3", chromeDriverPath);
				options = new ChromeOptions();
				options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200",
						"--ignore-certificate-errors");
				driver3 = new ChromeDriver(options);
				driver3.manage().window().maximize();
				driver3.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver3.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				driver3.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
				Dimension d3 = new Dimension(1382, 744);
				driver3.manage().window().setSize(d3);

			}
		} else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver3",
					System.getProperty("user.dir") + "\\src\\main\\java\\Drivers\\geckodriver.exe");
			driver3 = new FirefoxDriver();
			driver3.manage().window().maximize();
			driver3.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver3.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver3.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		} else if (browserName.equals("edge")) {

			System.setProperty("webdriver.edge.driver3",
					System.getProperty("user.dir") + "\\src\\main\\java\\Drivers\\msedgedriver.exe");
			driver3 = new EdgeDriver();
			driver3.manage().window().maximize();
			driver3.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver3.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver3.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		}

		driver3.get(prop.getProperty("rooturl"));
		wait3 = new WebDriverWait(driver3, 60);
		Log.info("Navigated to homePage");
		driver3.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wait3.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.loginButton")));
		driver3.findElement(By.cssSelector("span.loginButton")).click();
		driver3.findElement(By.xpath("//input[@id='email']")).sendKeys("shubham.deligence@gmail.com");
		driver3.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
		driver3.findElement(By.cssSelector("input.accountActionButton")).click();
		Thread.sleep(3000);
		wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='settings']")));
		driver3.findElement(By.xpath("//span[@id='settings']")).click();
		String url1 = driver.getCurrentUrl();

		if (driver3.findElement(By.xpath("//div[@class='col-md-12 currentActivePlanLabel']")).isDisplayed()) {

			PlayerScreen2();
		}

		else {
			System.out.println("You have not taken any subscription");
		}
	}

	@AfterTest
	public void tearDown() throws InterruptedException, IOException {
		/*
		 * driver1.quit(); driver.switchTo().window(driver.getWindowHandle());
		 * driver.quit();
		 */
	/*	String osName = System.getProperty("os.name");
		if (osName.equals("Windows 10")) {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
		} else {
			String[] cmd = new String[] { "/bin/sh", "killchrome.sh" };
			Process pr = Runtime.getRuntime().exec(cmd);
		} */

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
		driver.findElement(By.xpath("//input[@id='ffTimerValue']")).sendKeys(expectedFinalFactileTimer);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//input[@class='btn getReceipt btnSaveBtn'])[7]")));

		driver.findElement(By.xpath("(//input[@class='btn getReceipt btnSaveBtn'])[7]")).click();

		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//input[@id='answerTimerOnOff']")).isSelected()) {

		} else {
			act = new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//input[@id='answerTimerOnOff']"))).click();
		}

		if (driver.findElement(By.xpath("//input[@id='buzzerForFinalFactile']")).isSelected()) {

		} else {
			act3 = new Actions(driver);
			act3.moveToElement(driver.findElement(By.xpath("//input[@id='buzzerForFinalFactile']"))).click().perform();
		}
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='enter_final_answer']")));
		if (driver.findElement(By.xpath("//input[@id='enter_final_answer']")).isSelected()) {

		} else {
			act1 = new Actions(driver);
			act1.moveToElement(driver.findElement(By.xpath("//input[@id='enter_final_answer']"))).click().perform();
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

		Set<String> allWindows = driver.getWindowHandles();
		int count = allWindows.size();
		// System.out.println("Total window:=" + count);
		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				gameURL = driver.getCurrentUrl();
				System.out.println("Game url is:= " + gameURL);

				// use this code when u having bussiness account

				wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//div[@class='editShareIcon popup-nav-form']//p")));
				driver.findElement(By.xpath("//div[@class='editShareIcon popup-nav-form']//p")).click();
				Thread.sleep(3000);
				Select DDList = new Select(driver.findElement(By.xpath("//select[@id='shareOption']")));
				DDList.selectByValue("link");
				wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//button[@class='btn float-left closeShareModal']")));
				driver.findElement(By.xpath("//button[@class='btn float-left closeShareModal']")).click();

				Thread.sleep(3000);
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
				wait1 = new WebDriverWait(driver1, 10);
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

					System.out.println("Tile Number on moderater 1=>>" + p);
					wait.until(ExpectedConditions.elementToBeClickable(
							By.xpath("(//span[@class='gameQuestionBlock unAnsweredQuestion'])[1]")));

					// System.out.println("value"+ value);
					// System.out.println("value of p>>"+p);

					driver.findElement(By.xpath("(//span[@class='gameQuestionBlock unAnsweredQuestion'])[1]")).click();
					driver1.switchTo().window(driver1.getWindowHandle());

					Thread.sleep(4000);

					WebElement ele = driver1.findElement(By.xpath("//div[contains(text(),'Buzz!')]"));
					JavascriptExecutor executor = (JavascriptExecutor) driver1;
					executor.executeScript("arguments[0].click();", ele);

					driver.switchTo().window(driver.getWindowHandle());
					Thread.sleep(2000);
					wait.until(ExpectedConditions
							.presenceOfElementLocated(By.xpath("(//i[@class='fa fa-check right'])[1]")));
					driver.findElement(By.xpath("(//i[@class='fa fa-check right'])[1]")).click();
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

				driver.switchTo().window(driver.getWindowHandle());
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='playFinalJeopardy']")));
				driver.findElement(By.xpath("//span[@id='playFinalJeopardy']")).click();
				driver1.switchTo().window(driver1.getWindowHandle());

				Thread.sleep(3000);
				// driver1.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class='winnerTeamName']")));
				String winningTeamOnModeater = driver.findElement(By.xpath("//h1[@class='winnerTeamName']")).getText();
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
		}

	}

	public void PlayerScreen2() throws InterruptedException, IOException {
		Thread.sleep(2000);
		driver3.findElement(By.id("customize")).click();
		Thread.sleep(2000);
		wait3.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='resetAll resetCustomizations']")));
		driver3.findElement(By.xpath("//button[@class='resetAll resetCustomizations']")).click();
		Thread.sleep(2000);
		wait3.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//button[@class='swal-button swal-button--confirm btn-danger swal-button--danger']")));
		driver3.findElement(
				By.xpath("//button[@class='swal-button swal-button--confirm btn-danger swal-button--danger']")).click();
		Thread.sleep(2000);

		wait3.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[@class='swal-button swal-button--confirm']")));
		driver3.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']")).click();
		Thread.sleep(2000);

		parent = driver3.getWindowHandle();
		System.out.println("ParentWindow id is :-" + parent);
		wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='mygames']")));
		driver3.findElement(By.xpath("//*[@id='mygames']")).click();
		Thread.sleep(30000);
		driver3.get(gameURL);

		driver3.findElement(By.xpath("//span[@class='playNowButton']")).click();
		Thread.sleep(2000);
		driver3.findElement(By.xpath("//span[@data-numteams='2']")).click();
		Thread.sleep(2000);
		System.out.println(driver3.getTitle());
		driver3.findElement(By.xpath("//*[@id='displayBuzzerOptionBack']/div[1]/div[2]/div/div/ins")).click();
		Thread.sleep(2000);
		driver3.findElement(By.xpath("//*[@id='buzzerModeQuestion']/div/div[1]/span[2]")).click();
		wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='inviteYourTeams']/div/span[4]")));
		Thread.sleep(2000);
		String i = driver3.findElement(By.xpath("//*[@id='inviteYourTeams']/div/span[2]")).getText();
		System.out.println(i);// System.out.println(driver.getTitle());
		Thread.sleep(2000);

		FileInputStream fis = new FileInputStream("./src/main/java/resources/data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			String osName = System.getProperty("os.name");
			if (osName.equals("Windows 10")) {

				System.setProperty("webdriver.chrome.driver4",
						System.getProperty("user.dir") + "\\src\\main\\java\\Drivers\\chromedriver.exe");
				driver4 = new ChromeDriver();
				driver4.manage().window().maximize();
				driver4.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver4.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				driver4.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
			} else {
				String chromeDriverPath = "./src/main/java/LinuxDrivers/chromedriver";
				System.setProperty("webdriver.chrome.driver4", chromeDriverPath);
				options = new ChromeOptions();
				options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200",
						"--ignore-certificate-errors");
				driver4 = new ChromeDriver(options);
				driver4.manage().window().maximize();
				driver4.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver4.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				driver4.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
				Dimension d4 = new Dimension(1382, 744);
				driver4.manage().window().setSize(d4);

			}
		} else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver4",
					System.getProperty("user.dir") + "\\src\\main\\java\\Drivers\\geckodriver.exe");
			driver4 = new FirefoxDriver();
			driver4.manage().window().maximize();
			driver4.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver4.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver4.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		} else if (browserName.equals("edge")) {

			System.setProperty("webdriver.edge.driver4",
					System.getProperty("user.dir") + "\\src\\main\\java\\Drivers\\msedgedriver.exe");
			driver4 = new EdgeDriver();
			driver4.manage().window().maximize();
			driver4.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver4.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver4.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		}

		Dimension d4 = new Dimension(1382, 744);
		driver4.manage().window().setSize(d4);

		wait4 = new WebDriverWait(driver4, 10);
		driver4.get(prop.getProperty("joinurl"));
		String url = driver4.getCurrentUrl();
		Thread.sleep(2000);
		driver4.findElement(By.xpath("//input[@class='form-control']")).sendKeys(i);

		Thread.sleep(2000);
		// String url = driver1.getCurrentUrl();
		if (url.equals("https://game.playfactile.com/join")) {
			// live join button
			driver4.findElement(By.xpath("//input[@class='joinBtn yellowBG mt-4 mb-4']")).click();
		} else {
			driver4.findElement(By.xpath("//input[@class='btn joinBtn yellowBG mt-4 mb-4']")).click();
		}
		Thread.sleep(2000);
		driver4.findElement(By.xpath("(//div[@class='characterBlock position-relative'])[last()]")).click();
		Thread.sleep(2000);

		driver3.switchTo().window(driver3.getWindowHandle());
		Thread.sleep(2000);
		driver3.findElement(By.xpath("//span[contains(text(),'Begin Game')]")).click();
		Thread.sleep(2000);
		driver3.findElement(By.xpath("//span[contains(text(),'Start Game')]")).click();
		Thread.sleep(5000);

		int activetiles = driver3.findElements(By.xpath("//span[@class='gameQuestionBlock unAnsweredQuestion']"))
				.size();
		System.out.println("total active tiles in current game>>" + activetiles);

		for (int p = 1; p <= activetiles; p++) {

			System.out.println("Tile Number on modeater 2 =>>" + p);
			wait3.until(ExpectedConditions
					.elementToBeClickable(By.xpath("(//span[@class='gameQuestionBlock unAnsweredQuestion'])[1]")));

			// System.out.println("value"+ value);
			// System.out.println("value of p>>"+p);

			driver3.findElement(By.xpath("(//span[@class='gameQuestionBlock unAnsweredQuestion'])[1]")).click();
			driver4.switchTo().window(driver4.getWindowHandle());

			Thread.sleep(5000);

			WebElement ele = driver4.findElement(By.xpath("//div[contains(text(),'Buzz!')]"));
			JavascriptExecutor executor = (JavascriptExecutor) driver4;
			executor.executeScript("arguments[0].click();", ele);

			driver3.switchTo().window(driver3.getWindowHandle());
			Thread.sleep(2000);
			wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//i[@class='fa fa-check right'])[1]")));
			driver3.findElement(By.xpath("(//i[@class='fa fa-check right'])[1]")).click();
			Thread.sleep(2000);

			wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='backToBoard']")));
			driver3.findElement(By.xpath("//button[@class='backToBoard']")).click();
			// System.out.println("value of p at end>>"+p);

			Thread.sleep(2000);

		}
		driver4.switchTo().window(driver4.getWindowHandle());
		wait4.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='moneyHolder']")));
		String moneyvalue = driver4.findElement(By.xpath("//span[@class='moneyHolder']")).getText();
		System.out.println("moneyholder:=" + moneyvalue);
		Thread.sleep(2000);
		wait4.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='wagerInput']")));
		driver4.findElement(By.xpath("//input[@class='wagerInput']")).sendKeys(moneyvalue);

		wait4.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//input[@class='wagerPlayBtn btn--inside uppercase']")));
		driver4.findElement(By.xpath("//input[@class='wagerPlayBtn btn--inside uppercase']")).click();

		driver3.switchTo().window(driver3.getWindowHandle());
		wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='playFinalJeopardy']")));
		driver3.findElement(By.xpath("//span[@id='playFinalJeopardy']")).click();
		driver4.switchTo().window(driver4.getWindowHandle());

		driver3.switchTo().window(driver3.getWindowHandle());
		wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//i[@class='fa fa-check right'])[1]")));
		driver3.findElement(By.xpath("(//i[@class='fa fa-check right'])[1]")).click();

		wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='backToBoard']")));
		driver3.findElement(By.xpath("//button[@class='backToBoard']")).click();
		Thread.sleep(2000);
		wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class='winnerTeamName']")));
		String winningTeamOnModeater = driver3.findElement(By.xpath("//h1[@class='winnerTeamName']")).getText();
		System.out.println("winningTeamOnModeater>>" + winningTeamOnModeater);
		Thread.sleep(2000);

		driver4.switchTo().window(driver4.getWindowHandle());
		wait4.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class='WinnerScreen-winner-team-name']")));
		String winningTeamOnPlayerScreen = driver4.findElement(By.xpath("//h1[@class='WinnerScreen-winner-team-name']"))
				.getText();
		System.out.println("winningTeamOnPlayerScreen>>" + winningTeamOnPlayerScreen);
		Assert.assertEquals(winningTeamOnModeater, winningTeamOnPlayerScreen);

	}

}
