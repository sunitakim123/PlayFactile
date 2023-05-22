package Factile_Mode_v3;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Page_Object_v3.Log_in_Elements;
import junit.framework.Assert;
import resources.Base;

public class ShowSkipQuestionButton extends Base {
	WebDriver driver;
	WebDriver driver1;
	WebDriverWait wait, wait1;
	int int2, expectedtotalscore, calculate, exp=0, calc;
	String s6, s7, GameName, GameURL, twitterLink, PintrestLink, t1, p1, parent, expectedValue, actualValue;
	WebElement ElementNotGoingToVisible;
	Actions act;

	public static Logger Log = LogManager.getLogger(ShowSkipQuestionButton.class.getName());

	@BeforeTest
	public void initilize() throws IOException, InterruptedException {
		Thread.sleep(3000);
		driver = IntilizeDriver();
		Log.info("Driver is Initilize");
		driver.get(prop.getProperty("rooturl"));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 60);
		// driver1.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		// wait1 = new WebDriverWait(driver1, 20);
		Log.info("Navigated to homePage");

	}

	@Test
	public void Show_Skip_Question_Button_Checked_At_Global_Settings() throws InterruptedException, IOException {
		Log_in_Elements lobj1 = new Log_in_Elements(driver);
		Thread.sleep(2000);
		WebElement ClickOnSignIN= driver.findElement(By.xpath("(//a[@href='/signin'])[2]"));
		JavascriptExecutor executor6 = (JavascriptExecutor) driver;
		executor6.executeScript("arguments[0].click();", ClickOnSignIN);
		Thread.sleep(2000);
		lobj1.getenterEmail().sendKeys(prop.getProperty("username"));
		Thread.sleep(2000);
		lobj1.getenterPwd().sendKeys(prop.getProperty("pwd"));
		Thread.sleep(2000);
		lobj1.getlogin().click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/settings']")));
		driver.findElement(By.xpath("//a[@href='/settings']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/settings']")));
		Thread.sleep(3000);
		String url1 = driver.getCurrentUrl();

		if (driver.findElement(By.xpath("//div[@class='currentActivePlanLabel']/div")).isDisplayed()) {

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
		String osName = System.getProperty("os.name");
		if (osName.equals("Windows 11")) {
			try {
				Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			String[] cmd = new String[] { "/bin/sh", "killchrome.sh" };
			Process pr = Runtime.getRuntime().exec(cmd);
		}
		Thread.sleep(3000); 
	}

	public void modeaterscreen() throws InterruptedException {
		driver.findElement(By.xpath("//a[@href='/customize']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='resetAllCustomization']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled']")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//label[text()='Show Skip Question Button']")).getText());
		
		
		
		WebElement s1 = driver.findElement(
				By.xpath("//label[contains(text(), 'Show Skip Question Button')]/preceding-sibling::input[@type='checkbox']"));

		// WebElement s1 = driver.findElement(By.xpath("//label[text()='Display Question
		// On Game Board Tile']"));

		if (s1.isSelected()) {
			System.out.println("nothing to do");
		} else {

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", s1);
			Thread.sleep(1000);
		}

		Log.info("At customization page>> Show Skip Question Button is Checked >> ");
	}

	public void PlayerScreen() throws InterruptedException, IOException {

		parent = driver.getWindowHandle();
		System.out.println("ParentWindow id is :-" + parent);
		driver.findElement(By.xpath("//a[text()='My Games']")).click();

		GameName = prop.getProperty("gamename");
		// 'Test"+int1+"'
		// By.xpath("//div[@data-text='" + GameName +
		// "']/following-sibling::div/span[contains(text(), 'Play')]")).click();
		// driver.findElement(By.xpath("//a[@href='/skyblye']"));
		Thread.sleep(3000);
		GameURL = prop.getProperty("gameurl");
		WebElement clickonPlay = driver.findElement(By.xpath("//a[@href='" + GameURL + "']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", clickonPlay);
		Thread.sleep(2000);

		Set<String> allWindows = driver.getWindowHandles();
		int count = allWindows.size();
		System.out.println("Total window:=" + count);
		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);

				Thread.sleep(4000);

				driver.findElement(By.xpath("//div[@class='playNowButton']")).click();

				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[@data-numteams='2']")).click();

				Thread.sleep(3000);

				System.out.println(driver.getTitle());
				WebElement GQB = driver.findElement(By.xpath("//div[@id='pdisplayOption1']//input"));
				if (GQB.isSelected()) {
					System.out.println("nothing to do");
				} else {

					JavascriptExecutor executor1 = (JavascriptExecutor) driver;
					executor1.executeScript("arguments[0].click();", GQB);
					Thread.sleep(2000);
				}

				driver.findElement(By.xpath("//span[@class='buzzer-mode-choice-box-yes']")).click();
				Thread.sleep(2000);
				String i = driver.findElement(By.xpath("//div[@class='counter-value']")).getText();
				System.out.println(i);// System.out.println(driver.getTitle());
				Thread.sleep(4000);

				driver1 = IntilizeDriver();
				driver1.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
				wait1 = new WebDriverWait(driver1, 50);
				driver1.get(prop.getProperty("joinurl"));
				String url = driver1.getCurrentUrl();
				Thread.sleep(3000);
				driver1.findElement(By.xpath("//input[@id='pin']")).sendKeys(i);
				Thread.sleep(5000);
				WebElement JoinSubmit = driver1.findElement(By.xpath("//input[@class='joinBtn yellowBG mt-4 mb-4']"));
				JavascriptExecutor executor2 = (JavascriptExecutor) driver1;
				executor2.executeScript("arguments[0].click();", JoinSubmit);
				Thread.sleep(2000);
				
				WebElement mascotselection = driver1.findElement(By.xpath("(//span[@class='setupCharacterName'])[1]"));
				JavascriptExecutor executor4 = (JavascriptExecutor) driver1;
				executor4.executeScript("arguments[0].click();", mascotselection);
				Thread.sleep(2000);
				driver.switchTo().window(driver.getWindowHandle());
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[contains(text(),'Begin Game')]")).click();
				Thread.sleep(2000);
				WebElement ClickOnYES = driver.findElement(By.xpath("//button[contains(text(),'Yes')]"));

				JavascriptExecutor executor3 = (JavascriptExecutor) driver;
				executor3.executeScript("arguments[0].click();", ClickOnYES);

				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[contains(text(),'Begin Game')]")).click();
				
				
				Thread.sleep(4000);
			String valueOfTile1=	driver.findElement(By.xpath("(//span[@data-points='100'])[1]")).getAttribute("class");
			System.out.println("Get the value of class:="+valueOfTile1);
			Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@data-points='100'])[1]")).click();
				
				Thread.sleep(2000);driver.findElement(By.xpath("//span[text()='Skip Question']")).click();
				Thread.sleep(3000);
				String valueOfTile1afterSkipQuestion=	driver.findElement(By.xpath("(//span[@data-points='100'])[1]")).getAttribute("class");
				System.out.println(valueOfTile1afterSkipQuestion);
				Thread.sleep(2000);
				
				Assert.assertEquals(valueOfTile1, valueOfTile1afterSkipQuestion);
				System.out.println("Show Skip Question button is working fine");
				Log.info("Show Skip Question button is working fine");

			}
		}
	}
}
