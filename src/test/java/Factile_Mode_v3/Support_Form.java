package Factile_Mode_v3;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Page_Object_v3.Log_in_Elements;
import lombok.var;
import resources.Base;

public class Support_Form extends Base {
	WebDriver driver;
	int int2;
	Actions act;
	WebDriverWait wait;

	public static Logger Log = LogManager.getLogger(Support_Form.class.getName());

	@BeforeTest
	
	public void initilize() throws IOException, InterruptedException {

		driver = IntilizeDriver();
		Log.info("Driver is Initilize"); 
		driver.get(prop.getProperty("rooturl"));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 60);
		Log.info("Navigated to homePage");

	}

	@Test
	public void Support_Form_Verify() throws InterruptedException {

		Log_in_Elements lobj1 = new Log_in_Elements(driver);
		lobj1.Log_in_button().click();
		Thread.sleep(3000);

		lobj1.getenterEmail().sendKeys(prop.getProperty("username"));
		lobj1.getenterPwd().sendKeys(prop.getProperty("pwd"));
		lobj1.getlogin().click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='navbar-list-2']/ul/li[4]")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		Select sobj = new Select(driver.findElement(By.xpath("//select[@id='contact_topic']")));
		sobj.selectByValue("Other");
		driver.findElement(By.xpath("//input[@placeholder='Enter your problem topic']"))
				.sendKeys("This  message sent  by  tester for testing purpose only, so kinldy ignore this mail. Thankyou");
		driver.findElement(By.xpath("//textarea[@id='contact_desc']")).sendKeys("test data");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='contact_send']")));
		Thread.sleep(3000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement button = driver.findElement(By.xpath("//*[@name='contact_send']"));
		js1.executeScript("arguments[0].click();", button);
		Thread.sleep(2000);
//	
		String popupmsg = driver.findElement(By.xpath("//div[@class='swal2-popup swal2-modal swal2-icon-success swal2-show']"))
				.getText();
		System.out.println("After support form submission getting message is:-" + popupmsg);
	}

	@AfterTest
	public void close() {
	//	driver.quit();
	}
}
