package Factile_Mode_v3;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Page_Object_v3.SignUP_elements;
import resources.Base;

public class Sign_UP_with_Multiple_Test_Cases_Using_Data_Provider_Annotation extends Base {
	WebDriver driver;
	int int2;
	Actions act;
	WebDriverWait wait;
	String Newgmailidsent;
	Random randomGenerator;
	int randomInt;
	public static Logger Log = LogManager.getLogger(Sign_UP_with_Multiple_Test_Cases_Using_Data_Provider_Annotation.class.getName());

	@Test(dataProvider = "loginData")
	public void SignUP_Verify(String email, String password, String confirmPassword, String expectedResult)
			throws InterruptedException, IOException {
		driver = IntilizeDriver();
		Log.info("Driver is Initilize");
		driver.get(prop.getProperty("rooturl"));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 60);
		Log.info("Navigated to homePage");
		Thread.sleep(2000);
		SignUP_elements sobj = new SignUP_elements(driver);
		Thread.sleep(3000);
		sobj.Sign_in_button().click();
		Thread.sleep(2000);

		// Enter email
		WebElement emailField = driver.findElement(By.id("sign-up-from-email"));
		emailField.clear();
		emailField.sendKeys(email);

		// Enter password
		WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
		passwordField.clear();
		passwordField.sendKeys(password);

		// Enter confirm password
		WebElement confirmpassword = driver.findElement(By.xpath("//*[@id=\"signUpForm\"]/div[3]/input"));
		confirmpassword.clear();
		confirmpassword.sendKeys(confirmPassword);
		// Click login
		WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn signin']"));
		loginButton.click();		// Validate outcome based on expectedResult
		Thread.sleep(2000);
		String actualTitle=driver.getTitle();
		
		if (expectedResult.equals(actualTitle)) {
			String geturl=driver.getCurrentUrl();//, "https://www.awspf.com/signup");
			assertTrue(geturl.equals("https://awspf.com/signup") || geturl.equals("https://www.awspf.com/signup")   );	
			//test.log(Status.PASS, "Sign-up successful. Current title matches expected: " + actualTitle);
			   
			System.out.println("Sign up is working fine");
		} else {
			WebElement errorMessage = driver.findElement(By.xpath("//span[@class='error-msg']")); // Replace with actual error element
																					// ID
			Assert.assertTrue(errorMessage.isDisplayed(), "Error message should be displayed");
			//System.out.println(driver.findElement(By.xpath("//span[@class='error-msg']")).getText());
			Thread.sleep(2000);
			//driver.quit();
		}
	}

	@DataProvider(name = "loginData")
	public Object[][] getLoginData() {
		return new Object[][] {		
			{generateRandomEmail(), "ValidPass123", "ValidPass123", "Signup – Create your free PlayFactile Account"},// Valid credentials
			{ "valid@example.com", "ValidPass123", "ValidPass123", "Email already exist!" }, // Email already exit
			{ "valid@", "ValidPass123", "ValidPass123", "Invalid email" }, // Missing email
			{ "valid@example.com", "ValidPass123", "ValidPass12", "Password mismatch" }, // Invalid email format
			{ "valid@example.com", "12345", "12345", "Password must contain at least 6 characters" }, // Missing password
			{ "  ", "ValidPass123", "ValidPass123", "Email required"},
			{ generateRandomEmail(), "      ", "      ", "Password must contain at least 6 characters"}//Entered space in password so it should show the error message

		// Valid credentials};}
		};}

	

	// Generate a random valid email
	private String generateRandomEmail() {
	    String randomString = UUID.randomUUID().toString().substring(0, 8); // Generates a random 8-character string
	    return randomString + "@example.com";
	}

	

	
	

	@AfterTest
	public void close() {
		// driver.quit();
	}

}
