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

public class HideCategoryWithPointsChecked extends Base {
	WebDriver driver;
	WebDriver driver1;
	WebDriverWait wait, wait1;
	int int2;
	String s6, s7, GameName, GameURL, twitterLink, PintrestLink, t1, p1, parent, expectedValue, actualValue;
	WebElement ElementNotGoingToVisible;
	Actions act;

	public static Logger Log = LogManager.getLogger(HideCategoryWithPointsChecked.class.getName());
	private static String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\images\\eagle.jpg";

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
	public void Hide_category_with_Points_When_checked_At_Global_Settings()
			throws InterruptedException, IOException {
		Log_in_Elements lobj1 = new Log_in_Elements(driver);
		lobj1.Log_in_button().click();
		lobj1.getenterEmail().sendKeys(prop.getProperty("username"));
		lobj1.getenterPwd().sendKeys(prop.getProperty("pwd"));
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
			}
			else
			{
				String[] cmd = new String[]{"/bin/sh", "killchrome.sh"};
				Process pr = Runtime.getRuntime().exec(cmd);
			}
	Thread.sleep(3000);
	}

	public void modeaterscreen() throws InterruptedException {
		driver.findElement(By.xpath("//a[@href='/customize']")).click();
		Thread.sleep(2000);
		System.out.println(
				driver.findElement(By.xpath("//label[text()='Hide Category And Points On Question Tile']")).getText());

		WebElement s1 = driver.findElement(By.xpath(
				"//label[contains(text(), 'Hide Category And Points On Question Tile')]/preceding-sibling::input[@type='checkbox']"));
		Boolean check = s1.isSelected();
		System.out.println(check);
		if (s1.isSelected()) {
			System.out.println("nothing to do");
		} else {

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", s1);
			Thread.sleep(1000);
		}

		Log.info("At customization page>> Check Hide Category with Points>> ");
	}

	public void PlayerScreen() throws InterruptedException, IOException {
		Thread.sleep(2000);
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
				
				if(JoinSubmit.isDisplayed())
				{
					JavascriptExecutor executor3 = (JavascriptExecutor) driver1;
					executor3.executeScript("arguments[0].click();", JoinSubmit);
					Thread.sleep(2000);
				}
				else
				{
					System.out.println("nothing to do");
				}
				
				driver1.findElement(By.xpath("(//span[@class='setupCharacterName'])[1]")).click();
				Thread.sleep(2000);
				driver.switchTo().window(driver.getWindowHandle());
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[contains(text(),'Begin Game')]")).click();
				Thread.sleep(2000);
				WebElement ClickOnYES=	driver.findElement(By.xpath("//button[contains(text(),'Yes')]"));
				
				JavascriptExecutor executor3 = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", ClickOnYES);
		
				
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[contains(text(),'Begin Game')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@data-points='100'])[1]")).click();
				Thread.sleep(2000);
				driver1.switchTo().window(driver1.getWindowHandle());
				Thread.sleep(2000);
				ElementNotGoingToVisible = driver1.findElement(By.xpath("(//div[@class='gameTitle game-title-flex']//h1)[1]"));
				System.out.println("HEader text:-"+ElementNotGoingToVisible.getText());
				String myString=ElementNotGoingToVisible.getText();
			
				assertTrue(myString.equals("---"));
				Log.info("Hide category with points is working fine>> When Checked");
				System.out.println("Hide category with points is working fine>> When Checked");

			}
		}
	}
}
