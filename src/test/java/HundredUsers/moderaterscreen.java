package HundredUsers;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotVisibleException;
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

public class moderaterscreen extends Base {
	WebDriver driver;
	WebDriver driver1;
	WebDriver driver2, driver3, driver4, driver5, driver6, driver7, driver8, driver9, driver10;
	WebDriverWait wait, wait1, wait2, wait3, wait4, wait5, wait6, wait7,wait8, wait9, wait10;
	int int2;
	
	int AnswerTimerValue = 5;
	String expectedAnswerTimerValue = String.valueOf(AnswerTimerValue);
	String s6, s7, GameName, twitterLink, PintrestLink, t1, p1, parent, expectedValue, actualValue,
			PlayerNameAtmodraterscreen, playerNameAtPlayerScreenString, text;
	WebElement ElementNotGoingToVisible;
	Actions act, act1, act2, act3, act4, act5, act6;
static String i, j;
	//public static Logger Log = LogManager.getLogger(FiftyUsersJoin.class.getName());

	@BeforeTest
	public void initilize() throws IOException {
		driver = IntilizeDriver();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.MINUTES);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.MINUTES);
		wait = new WebDriverWait(driver, 400);
		Dimension d = new Dimension(1382, 744);
		driver.manage().window().setSize(d);
	
		driver.get(prop.getProperty("rooturl"));


	}

	@Test
	public void Call() throws InterruptedException, IOException {
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
			driver.switchTo().window(driver.getWindowHandle());
			  j = driver.findElement(By.xpath("//*[@id='inviteYourTeams']/div/span[2]")).getText();
			  System.out.println("value of j"+j);
			
	}

	@AfterTest
	public void tearDown() throws InterruptedException {

		// driver1.quit(); driver.switchTo().window(driver.getWindowHandle());
		// driver.quit();

	}

	public void modeaterscreen() throws InterruptedException {
		driver.findElement(By.id("customize")).click();
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//input[@id='onlyCustomMascots']")).isSelected()) {
			System.out.println("use only custom mascot is already selected");
		} else {
			act = new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//input[@id='onlyCustomMascots']"))).click().perform();
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

				driver.findElement(By.xpath("//span[@data-numteams='10']")).click();
				Thread.sleep(2000);
				System.out.println(driver.getTitle());
				driver.findElement(By.xpath("//*[@id='displayBuzzerOptionBack']/div[1]/div[2]/div/div/ins")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='buzzerModeQuestion']/div/div[1]/span[2]")).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='inviteYourTeams']/div/span[4]")));
				Thread.sleep(2000);
				  i = driver.findElement(By.xpath("//*[@id='inviteYourTeams']/div/span[2]")).getText();
				System.out.println(i);// System.out.println(driver.getTitle());
				
				Thread.sleep(2000);
				
				
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
					driver1.findElement(By.xpath("//input[@class='joinBtn yellowBG mt-4 mb-4']")).click();
								Thread.sleep(2000);
				driver1.findElement(By.xpath("(//div[@class='characterBlock position-relative'])[last()]")).click();
				Thread.sleep(2000);
			
				driver2 = IntilizeDriver();
				Dimension d2 = new Dimension(1382,744);     
				driver2.manage().window().setSize(d2); 
				driver2.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				driver2.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
				driver2.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				wait2 = new WebDriverWait(driver2, 60);
				driver2.get(prop.getProperty("joinurl"));				
				Thread.sleep(2000);
				driver2.findElement(By.xpath("//input[@class='form-control']")).sendKeys(i);
				Thread.sleep(2000);
								driver2.findElement(By.xpath("//input[@class='joinBtn yellowBG mt-4 mb-4']")).click();			
				Thread.sleep(2000);
				driver2.findElement(By.xpath("(//div[@class='characterBlock position-relative'])[last()]")).click();
				Thread.sleep(2000);
				
				driver3 = IntilizeDriver();
				driver3.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				driver3.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
				driver3.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				wait3 = new WebDriverWait(driver3, 60);
				driver3.get(prop.getProperty("joinurl"));				
				Thread.sleep(2000);
				driver3.findElement(By.xpath("//input[@class='form-control']")).sendKeys(i);
				Thread.sleep(2000);
								driver3.findElement(By.xpath("//input[@class='joinBtn yellowBG mt-4 mb-4']")).click();			
				Thread.sleep(2000);
				driver3.findElement(By.xpath("(//div[@class='characterBlock position-relative'])[last()]")).click();
				Thread.sleep(2000);
				
				
				driver4 = IntilizeDriver();
				driver4.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				driver4.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
				driver4.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				wait4 = new WebDriverWait(driver4, 60);
				driver4.get(prop.getProperty("joinurl"));				
				Thread.sleep(2000);
				driver4.findElement(By.xpath("//input[@class='form-control']")).sendKeys(i);
				Thread.sleep(2000);
								driver4.findElement(By.xpath("//input[@class='joinBtn yellowBG mt-4 mb-4']")).click();			
				Thread.sleep(2000);
				driver4.findElement(By.xpath("(//div[@class='characterBlock position-relative'])[last()]")).click();
				Thread.sleep(2000);	
				
				}}}
	
	@Test
	public void Call1() throws InterruptedException, IOException {
	
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
		System.out.println(i);
		System.out.println(j);
		driver1.findElement(By.xpath("//input[@class='form-control']")).sendKeys(i);	
						Thread.sleep(2000);			
			driver1.findElement(By.xpath("//input[@class='joinBtn yellowBG mt-4 mb-4']")).click();
						Thread.sleep(2000);
		driver1.findElement(By.xpath("(//div[@class='characterBlock position-relative'])[last()]")).click();
		Thread.sleep(2000);
	
		driver2 = IntilizeDriver();
		Dimension d2 = new Dimension(1382,744);     
		driver2.manage().window().setSize(d2); 
		driver2.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver2.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		driver2.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wait2 = new WebDriverWait(driver2, 60);
		driver2.get(prop.getProperty("joinurl"));				
		Thread.sleep(2000);
		driver2.findElement(By.xpath("//input[@class='form-control']")).sendKeys(i);
		Thread.sleep(2000);
						driver2.findElement(By.xpath("//input[@class='joinBtn yellowBG mt-4 mb-4']")).click();			
		Thread.sleep(2000);
		driver2.findElement(By.xpath("(//div[@class='characterBlock position-relative'])[last()]")).click();
		Thread.sleep(2000);
		
		driver3 = IntilizeDriver();
		driver3.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver3.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		driver3.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wait3 = new WebDriverWait(driver3, 60);
		driver3.get(prop.getProperty("joinurl"));				
		Thread.sleep(2000);
		driver3.findElement(By.xpath("//input[@class='form-control']")).sendKeys(i);
		Thread.sleep(2000);
						driver3.findElement(By.xpath("//input[@class='joinBtn yellowBG mt-4 mb-4']")).click();			
		Thread.sleep(2000);
		driver3.findElement(By.xpath("(//div[@class='characterBlock position-relative'])[last()]")).click();
		Thread.sleep(2000);
		
		
		driver4 = IntilizeDriver();
		driver4.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver4.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		driver4.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wait4 = new WebDriverWait(driver4, 60);
		driver4.get(prop.getProperty("joinurl"));				
		Thread.sleep(2000);
		driver4.findElement(By.xpath("//input[@class='form-control']")).sendKeys(i);
		Thread.sleep(2000);
						driver4.findElement(By.xpath("//input[@class='joinBtn yellowBG mt-4 mb-4']")).click();			
		Thread.sleep(2000);
		driver4.findElement(By.xpath("(//div[@class='characterBlock position-relative'])[last()]")).click();
		Thread.sleep(2000);
	
	}
}