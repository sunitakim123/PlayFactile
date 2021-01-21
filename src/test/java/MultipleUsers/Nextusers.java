package MultipleUsers;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
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

public class Nextusers extends Base {
	WebDriver driver;
	WebDriver driver1;
	WebDriver driver2, driver3, driver4, driver5;
	WebDriverWait wait, wait1, wait2, wait3;
	int int2;
	int AnswerTimerValue = 5;
	String expectedAnswerTimerValue = String.valueOf(AnswerTimerValue);
	String s6, s7, GameName, twitterLink, PintrestLink, t1, p1, parent, expectedValue, actualValue,
			PlayerNameAtmodraterscreen, playerNameAtPlayerScreenString, text;
	WebElement ElementNotGoingToVisible;
	Actions act, act1, act2, act3, act4, act5, act6;

	public static Logger Log = LogManager.getLogger(Nextusers.class.getName());

	
	

	@Test
	public void Call() throws InterruptedException, IOException {
		
			//	modeaterscreen();
				PlayerScreen();
			
	



	}

	public void PlayerScreen() throws InterruptedException, IOException {
		//java -jar $JARFILE -Dwebdriver.chrome.driver=$CHROMEDRIVER -role webdriver -hub http://$HUB_IP:4444/grid/register -maxSession 10 -browser browserName=chrome,maxInstances=10";
		
		driver1.get("https://game.playfactile.com/join -maxSession 10 -browser browserName=chrome,maxInstances=10");
		
			/*	for (int j = 1; j <= 10; j++) {
					driver1 = IntilizeDriver();
					
					driver1.manage().timeouts().pageLoadTimeout(60, TimeUnit.MINUTES);
					driver1.manage().timeouts().setScriptTimeout(60, TimeUnit.MINUTES);
					driver1.manage().timeouts().implicitlyWait(60, TimeUnit.MINUTES);
					wait1 = new WebDriverWait(driver1, 100);
					driver1.get(prop.getProperty("joinurl"));
					Thread.sleep(2000);
					driver1.findElement(By.xpath("//input[@class='form-control']")).sendKeys("9156");
					Thread.sleep(2000);
					try {
						

						driver1.findElement(By.xpath("//input[@class='joinBtn yellowBG mt-4 mb-4']")).click();
						// wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='characterBlock
						// position-relative'])[last()]")));
						if (driver1.findElement(By.xpath("(//div[@class='characterBlock position-relative'])[last()]"))
								.isDisplayed()) {
							driver1.findElement(By.xpath("(//div[@class='characterBlock position-relative'])[last()]"))
									.click();
						} else {
							wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='page-item']//span[@class='page-link']")));
							driver1.findElement(By.xpath("//li[@class='page-item']//span[@class='page-link']")).click();
							wait1.until(ExpectedConditions.presenceOfElementLocated(
									By.xpath("(//div[@class='characterBlock position-relative'])[last()]")));

							driver1.findElement(By.xpath("(//div[@class='characterBlock position-relative'])[last()]"))
									.click();
						}
					} catch (ElementNotVisibleException e) {
						System.out.println("user unable to join getting message couldn't connect");
					}
				}*/
	} 
}
