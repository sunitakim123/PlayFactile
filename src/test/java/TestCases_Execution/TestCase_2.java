package TestCases_Execution;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObject.CurrentAccountInfo;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class TestCase_2 extends Base {
	WebDriver driver;
	public static Logger Log=LogManager.getLogger(TestCase_2.class.getName());
	@BeforeTest
	public void initilize() throws IOException {
		driver = IntilizeDriver();
		driver.get(prop.getProperty("url"));
		LandingPage l1 = new LandingPage(driver);
		l1.getLogin().click();
		
	}

	

	@Test()
	public void logIn() {
		
		LoginPage l2 = new LoginPage(driver);
		l2.getEmailid().sendKeys(prop.getProperty("username"));
		Log.info("username is entered");
		l2.getPassword().sendKeys(prop.getProperty("pwd"));
		Log.info("password is entered");
		l2.getSignin().click();
		Log.info("Sign_IN is successfully Done");
		Assert.assertTrue(l2.getNavigationBar().isDisplayed());
	}

	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
