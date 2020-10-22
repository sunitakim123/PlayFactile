package TestCases_Execution;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObject.CreateGameUsingExcel;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class TestCase_4 extends Base {
	WebDriver driver;
	public static Logger Log=LogManager.getLogger(TestCase_4.class.getName());

	@BeforeTest
	public void initilize() throws IOException {
		driver = IntilizeDriver();
		driver.get(prop.getProperty("url"));
		LandingPage l1 = new LandingPage(driver);
		l1.getLogin().click();
		LoginPage l2 = new LoginPage(driver);
		l2.getEmailid().sendKeys(prop.getProperty("username"));
		l2.getPassword().sendKeys(prop.getProperty("pwd"));
		l2.getSignin().click();
		}
	
	@Test(priority = 1)
	public void create_Game_Using_Excel_Upload() throws FileNotFoundException, InterruptedException
	{CreateGameUsingExcel c1 = new CreateGameUsingExcel(driver);
		c1.createGame();
		Log.info("Game is created using excel upload");
		Assert.assertTrue(c1.getNavigationBar().isDisplayed());
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
