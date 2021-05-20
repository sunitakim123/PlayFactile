package Factile_Mode_v3;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Page_Object_v3.Log_in_Elements;
import Page_Object_v3.SignUP_elements;
import resources.Base;

public class Log_In extends Base{

	WebDriver driver;	
	int int2;
	Actions act;
	WebDriverWait wait;

	public static Logger Log = LogManager.getLogger(Log_In.class.getName());

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
	public void Log_in()
	{
		
		Log_in_Elements lobj1= new Log_in_Elements(driver);
		lobj1.Log_in_button().click();
		lobj1.getenterEmail().sendKeys(prop.getProperty("username"));
		lobj1.getenterPwd().sendKeys(prop.getProperty("pwd"));
		lobj1.getlogin().click();
	}
	@AfterTest
	public void close()
	{ 
		driver.quit();
	}
	
	
	
}
