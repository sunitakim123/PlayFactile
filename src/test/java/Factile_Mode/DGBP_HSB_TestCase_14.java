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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import resources.Base;

public class DGBP_HSB_TestCase_14 extends Base {
	WebDriver driver;
	WebDriver driver1;
	WebDriverWait wait, wait1;
	int int2;
	String s6, s7, GameName, twitterLink, PintrestLink, t1, p1, parent, expectedValue, actualValue,
			PlayerNameAtmodraterscreen, PlayerNameAtPlayerScreen;
	WebElement ElementNotGoingToVisible;
	Actions act, act1, act2;
	
	public static Logger Log = LogManager.getLogger(DGBP_HSB_TestCase_14.class.getName());
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
	public void TC_14_Verify_Play_as_Numbered_Tile_instead_of_Jeopardy_Style() throws InterruptedException, IOException {
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
		Thread.sleep(3000);
		
		// checking the exact case at player screen on gameboard
		if (driver.findElement(By.xpath("//div[@id='gameSettingSection']//input[@id='playAsNumberedTiles']")).isSelected()) {
			System.out.println("nothing to do");
		} else {
			act = new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//div[@id='gameSettingSection']//input[@id='playAsNumberedTiles']")))
					.click().perform();

			
		}
		
		Log.info("At customization page>> Play as Numbered Tiles instead of Jeopardy-style is checked >> ");

	}
	
	public void PlayerScreen() throws InterruptedException, IOException { 
		Thread.sleep(2000);
		parent = driver.getWindowHandle();
		System.out.println("ParentWindow id is :-" + parent);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='mygames']")));
		driver.findElement(By.xpath("//*[@id='mygames']")).click();
		GameName = prop.getProperty("gamename");
		// 'Test"+int1+"'
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//div[@data-text='" + GameName + "']/following-sibling::div/span[contains(text(), 'Play')]"))
				.click();
		Thread.sleep(2000);
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
				String i = driver.findElement(By.xpath("//*[@id='inviteYourTeams']/div/span[2]")).getText();
				System.out.println(i);// System.out.println(driver.getTitle());
				Thread.sleep(3000);
 
				driver1 = IntilizeDriver();
				driver1.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				driver1.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
				driver1.get(prop.getProperty("joinurl"));
				String url = driver1.getCurrentUrl();
				Thread.sleep(3000);
				driver1.findElement(By.xpath("//input[@class='form-control']")).sendKeys(i);
				Thread.sleep(2000);
				//String url = driver1.getCurrentUrl();
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
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='gameCategoryColumn playGameCategoryColumn']")));
			
				int total = driver.findElements(By.xpath("//span[@class='gamePointsBlock']")).size();
				
							
				for( int c=1;c<=total;c++)
				{ 
					
					String actual= driver.findElement(By.xpath("(//span[@class='gamePointsBlock'])[" + c + "]")).getText();
				
					 assertTrue(actual.equals("1") || actual.equals("2") || actual.equals("3") || actual.equals("4") || actual.equals("5")|| actual.equals("6")|| actual.equals("7")||actual.equals("8") ||actual.equals("9") ||actual.equals("10")
							 ||actual.equals("11")|| actual.equals("12") || actual.equals("13") || actual.equals("14") || actual.equals("15")|| actual.equals("16")|| actual.equals("17")||actual.equals("18") ||actual.equals("19") ||actual.equals("20")
					 || actual.equals("21")||actual.equals("22") || actual.equals("23") || actual.equals("24") || actual.equals("25")|| actual.equals("26")|| actual.equals("27")||actual.equals("28") ||actual.equals("29") ||actual.equals("30"));
				}
				
				Log.info("Play as Numbered Tiles instead of Jeopardy-style is working fine ");
				System.out.println("Play as Numbered Tiles instead of Jeopardy-style is working fine");
		}
	}
	}}
