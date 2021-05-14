package Factile_Mode_v3;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Page_Object_v3.Log_in_Elements;
import Page_Object_v3.SignUP_elements;
import resources.Base;

public class twoFactorAuthentication extends Base {
	WebDriver driver, driver1;
	int int2;
	Actions act;
	WebDriverWait wait;
	String parent;
	String expectedUrl = "https://v3.awspf.com/mygames";
	public static Logger Log = LogManager.getLogger(twoFactorAuthentication.class.getName());

	@BeforeTest
	public void initilize() throws IOException, InterruptedException {

		driver = IntilizeDriver();
		Log.info("Driver is Initilize");
		driver.get(prop.getProperty("rooturl"));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 40);
		Log.info("Navigated to homePage");

	}

	@Test
	public void Two_Factor_Authentication() throws InterruptedException, IOException {

		Log_in_Elements lobj1 = new Log_in_Elements(driver);
		lobj1.Log_in_button().click();
		lobj1.getenterEmail().sendKeys("sunita11@yopmail.com");
		lobj1.getenterPwd().sendKeys("12345678");
		lobj1.getlogin().click();
		driver1 = IntilizeDriver();
		driver1.get("http://www.yopmail.com/en/");
		driver1.findElement(By.cssSelector("input#login")).sendKeys("sunita11");
		driver1.findElement(By.cssSelector("input.sbut")).click();
		Thread.sleep(25000);
		driver1.findElement(By.cssSelector("span.slientext")).click();
		Thread.sleep(2000);
		driver1.switchTo().frame("ifmail");
		
		String verificationcode = driver1.findElement(By.xpath("(//td[@class='content-block'])[3]")).getText();
		
		System.out.println("--" + verificationcode);
		String code = verificationcode.substring(19);
		driver.switchTo().window(driver.getWindowHandle());
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(code);
		driver.findElement(By.xpath("//button[@class='btn signin']")).click();
		Thread.sleep(10000);
		String currentURL = null;
		currentURL = driver.getCurrentUrl();
		assertEquals(currentURL, expectedUrl);
	}

	@AfterTest 
	public void close() {
		
	}

}
