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

public class TestCase_3 extends Base {
	WebDriver driver;
	public static Logger Log=LogManager.getLogger(TestCase_3.class.getName());

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

	@Test()
	public void CheckAccountInfo() throws InterruptedException {

		CurrentAccountInfo c1 = new CurrentAccountInfo(driver);
		c1.checkAccountInfo();
		
		//Assert.assertEquals(c1.getActiveSubscription().getText(), "Yearly $48 (Ends 08-Oct-2021)");
		
		Log.info("account is active  >>" +c1.getActiveSubscription().getText());
	}

	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
