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

public class TestCase_1 extends Base {
	WebDriver driver;
	public static Logger Log=LogManager.getLogger(TestCase_1.class.getName());
	
	@BeforeTest
	public void initilize() throws IOException {
		driver = IntilizeDriver();
		Log.info("Driver is Initilize");
		driver.get(prop.getProperty("url"));
	
		Log.info("Navigated to homePage");
	}

	@Test()
	public void basePageNavigation() throws IOException, InterruptedException {

		LandingPage l1 = new LandingPage(driver);
		// compare the text from the browser actual text..
		Assert.assertEquals(l1.getTitle().getText(), "Create an online Jeopardy-style quiz game board in minutes");
		Log.info("Successsfully validated text message");
		l1.getLogin().click();
		Log.info("Sign In page is Open");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
