package Factile_Mode_v3;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Page_Object_v3.Log_in_Elements;
import Page_Object_v3.SignUP_elements;
import resources.Base;

public class GoProToSubscriptionHomeSchoolYearlyData_Verify extends Base {
	WebDriver driver;
	int int2;
	Actions act;
	WebDriverWait wait;
	String Newgmailidsent;
	public static Logger Log = LogManager.getLogger(GoProToSubscriptionHomeSchoolYearlyData_Verify.class.getName());
	ZoneId defaultZoneId = ZoneId.systemDefault();

	@BeforeTest
	public void initilize() throws IOException, InterruptedException {
			
		driver = IntilizeDriver();
		Log.info("Driver is Initilize");
		driver.get(prop.getProperty("rooturl"));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 120);
		Log.info("Navigated to homePage");

	}

	@Test
	public void GoProToHomeSchoolYearlySubscriptionAndNextComingDate() throws InterruptedException, ParseException {
		System.out.println("System Default TimeZone : " + defaultZoneId);

		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		Newgmailidsent = "Newuser1" + randomInt + "@gmail.com";
		System.out.println(Newgmailidsent);
		SignUP_elements sobj = new SignUP_elements(driver);
		sobj.Sign_in_button().click();
		Thread.sleep(3000);
		sobj.getEmail().sendKeys(Newgmailidsent);
		sobj.getPassword().sendKeys("12345678");
		sobj.getConfirmPassword().sendKeys("12345678");
		sobj.getSignIN().click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		//sobj.getfreeaccount().click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='goPro nav-link']/a")));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement GoProLink = driver.findElement(By.xpath("//li[@class='goPro nav-link']/a"));
		js1.executeScript("arguments[0].click();", GoProLink);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='yearly']")));
		WebElement enternumber = driver.findElement(By.xpath("//span[@id='yearly']"));
		js1.executeScript("arguments[0].click();", enternumber);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='cardNumber']")));
		driver.findElement(By.xpath("//input[@id='cardNumber']")).sendKeys("5454545454545454");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='cardExpiry']")));
		driver.findElement(By.xpath("//input[@id='cardExpiry']")).sendKeys("1226");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='cardCvc']")));
		driver.findElement(By.xpath("//input[@id='cardCvc']")).sendKeys("111");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='billingName']")));
		driver.findElement(By.xpath("//input[@id='billingName']")).sendKeys("sunita");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//button[@class='SubmitButton SubmitButton--complete']")));
		driver.findElement(
				By.xpath("//button[@class='SubmitButton SubmitButton--complete']"))
				.click();
		sobj.getEmail().sendKeys(Newgmailidsent);
		sobj.getPassword().sendKeys("12345678");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	
		//Thread.sleep(6000);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='navbar-list-2']/ul/li[3]/a")));
		/*
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		WebElement button2 = driver.findElement(By.xpath("//*[@class='goBack'][2]"));
		js2.executeScript("arguments[0].click();", button2);
		
		Thread.sleep(3000);
		*/
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='navbar-list-2']/ul/li[3]/a")));
		
		// driver.findElement(By.xpath("//*[@id='navbar-list-2']/ul/li[3]/a")).click();
		WebElement ClickOnAccountLink = driver.findElement(By.xpath("//*[@id='navbar-list-2']/ul/li[3]/a"));
		js1.executeScript("arguments[0].click();", ClickOnAccountLink);
		// Create object of SimpleDateFormat class and decide the format
		LocalDate futureDate = LocalDate.now().plusYears(1);

		System.out.println("Date after one month=" + futureDate);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='currentActivePlanLabel']/div")));

		String datecaptureFromAccountPage = driver.findElement(By.xpath("//div[@class='currentActivePlanLabel']/div"))
				.getText();
		//capture date from account page after successfully subscription.
		System.out.println("datecaptureFromAccountPage" + datecaptureFromAccountPage);
		//extracting only data here that why using substring method
		String dateExtracted = datecaptureFromAccountPage.substring(71, 82);
		System.out.println(":- " + dateExtracted);
		DateFormat df3 = new SimpleDateFormat("dd-MMM-yyyy");
		Date d1 = df3.parse(dateExtracted);
		// 1. Convert Date -> Instant
		
		Instant instant = d1.toInstant();
		System.out.println("instant : " + instant);

		// 2. Instant + system default time zone + toLocalDate() = LocalDate
		LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
		System.out.println("localDate : " + localDate);

		if (futureDate.isEqual(localDate)) {
			System.out.println("They are the same date");
		} else {
			System.out.println("They are different dates");
		}delete_Account();
	}

	public void delete_Account() throws InterruptedException {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='deleteAccountWrapper']/button")));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement button = driver.findElement(By.xpath("//*[@class='deleteAccountWrapper']/button"));
		js1.executeScript("arguments[0].click();", button);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='deleteAccountWrapper']/button")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='swal2-input']")).sendKeys("12345678");
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='swal2-confirm swal2-styled']")));
		driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Delete!')]")));
		driver.findElement(By.xpath("//*[contains(text(),'Delete!')]")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Yes!')]")));
		driver.findElement(By.xpath("//*[contains(text(),'Yes!')]")).click();
		Thread.sleep(4000);
	}

	@AfterTest
	public void close() {
		 driver.quit();
	}
}
