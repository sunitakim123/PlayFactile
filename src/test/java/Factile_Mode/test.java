package Factile_Mode;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestCases_Execution.TestCase_1;
import resources.Base;

public class test  extends Base{
	WebDriver driver;
	WebDriver driver1;
	WebDriverWait wait, wait1;
	int int2;
	String s6, s7, GameName;
	Actions act;
	
	public static Logger Log = LogManager.getLogger(test.class.getName());
	@BeforeTest
	public void initilize() throws IOException {
		driver = IntilizeDriver();
		Log.info("Driver is Initilize");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);
		//driver1.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//wait1 = new WebDriverWait(driver1, 20);
		Log.info("Navigated to homePage");

	}

	@Test
	public void Verify_Show_Social_Media_on_Gameboard_If_Unchecked() throws InterruptedException, IOException {
		driver.findElement(By.cssSelector("span.loginButton")).click();
		driver.findElement(By.id("email")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("pwd"));
		driver.findElement(By.cssSelector("input.accountActionButton")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='customize']")));
		driver.findElement(By.xpath("//*[@id='customize']")).click();
		Thread.sleep(3000);
		
		//if u want to uncheck
		if(!driver.findElement(By.xpath("//div[@id='gameSettingSection']//input[@id='hideSocialLinks']")).isSelected())
		{System.out.println("nothing to do");
		}
		else
		{
			act = new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//div[@id='gameSettingSection']//input[@id='hideSocialLinks']"))).click().perform();;
		
		}
		/*
		//if u want to check
		if(driver.findElement(By.xpath("//div[@id='gameSettingSection']//input[@id='hideSocialLinks']")).isSelected())
		{System.out.println("nothing to do");
		}
		else
		{
			act = new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//div[@id='gameSettingSection']//input[@id='hideSocialLinks']"))).click().perform();;
		
		}*/
		
		
	}
}
