
package Factile_Mode_v3;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import Page_Object_v3.SignUP_elements;
import resources.Base;

public class SignUP_With_Multiple_Test_Cases extends Base {
	WebDriver driver;
	int int2;
	Actions act;
	WebDriverWait wait;
	String Newgmailidsent;
	public static Logger Log = LogManager.getLogger(SignUP_With_Multiple_Test_Cases.class.getName());

	@BeforeMethod
	public void initilize() throws IOException, InterruptedException {

		driver = IntilizeDriver();
		Log.info("Driver is Initilize");
		driver.get(prop.getProperty("rooturl"));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 60);
		Log.info("Navigated to homePage");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div/main/section[1]/div/div/div[1]/div/div[1]/a[1]"))
				.click();
		driver.navigate().refresh();

	}

	// Generate a random valid email
	private String generateRandomEmail() {
		String randomString = UUID.randomUUID().toString().substring(0, 8); // Generates a random 8-character string
		return randomString + "@example.com";
	}

	@Test(priority = 1)
	public void Sign_Up_with_Valid_Credentials() throws InterruptedException {
		// driver.navigate().to("http://www.yopmail.com/en/");
		Thread.sleep(2000);
		// Enter email
		String genratedemail = generateRandomEmail();
		System.out.println("Genearted email is:=" + genratedemail);
		driver.findElement(By.id("sign-up-from-email")).sendKeys(genratedemail);
		// Enter password
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("ValidPass123");
		// Enter confirm password
		driver.findElement(By.xpath("//*[@id=\"signUpForm\"]/div[3]/input")).sendKeys("ValidPass123");
		// Click login
		driver.findElement(By.xpath("//button[@class='btn signin']")).click();
		Thread.sleep(2000);
		String expectedTitle ="Signup – Create your free PlayFactile Account";
		String actualTitle = driver.getTitle();
		System.out.println("title of page:-"+actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle, "After sign up Page title is mismatching that's why it's getting fail");
		
		
		
		//System.out.println("Sign up is working fine");
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='introjs-skipbutton']")).click();
		String GmailAfterLogin = driver.findElement(By.xpath("//span[@class='showEmail font-bold navbar-text']"))
				.getText();
		assertEquals(GmailAfterLogin, genratedemail);
		Thread.sleep(4000);
		delete_Account();

	}

	@Test(priority =2)
	public void Sign_Up_with_an_already_Registered_Email() throws InterruptedException {
		Thread.sleep(2000);
		// String genratedemail= generateRandomEmail();
		// System.out.println("Genearted email is:="+genratedemail);
		driver.findElement(By.id("sign-up-from-email")).sendKeys("sunita.deligence@gmail.com");
		// Enter password
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("ValidPass123");
		// Enter confirm password
		driver.findElement(By.xpath("//*[@id=\"signUpForm\"]/div[3]/input")).sendKeys("ValidPass123");
		// Click login
		driver.findElement(By.xpath("//button[@class='btn signin']")).click();
		Thread.sleep(2000);
		String errorMessage = driver.findElement(By.xpath("//span[@class='error-msg']")).getText(); // Replace with
																									// actual error
																									// element
		System.out.println("Fetched error message is:-" + errorMessage);
		String expectederrorMessage = "Email already exist!";
		Assert.assertEquals(errorMessage, expectederrorMessage);
		Thread.sleep(2000);
	}

	@Test(priority =3)
	public void SignUp_with_an_Invalid_EmailID() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("sign-up-from-email")).sendKeys("valid@");
		// Enter password
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("ValidPass123");
		// Enter confirm password
		driver.findElement(By.xpath("//*[@id=\"signUpForm\"]/div[3]/input")).sendKeys("ValidPass123");
		// Click login
		driver.findElement(By.xpath("//button[@class='btn signin']")).click();
		Thread.sleep(2000);
		String errorMessage = driver.findElement(By.xpath("//span[@class='error-msg']")).getText(); // Replace with
																									// actual error
																									// element
		System.out.println("Fetched error message is:-" + errorMessage);
		String expectederrorMessage = "Invalid email";
		Assert.assertEquals(errorMessage, expectederrorMessage);
		Thread.sleep(2000);
	}

	@Test(priority =4)
	public void SignUp_with_Password_ConfirmPassword_Missmatch() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("sign-up-from-email")).sendKeys(generateRandomEmail());
		// Enter password
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("ValidPass123");
		// Enter confirm password
		driver.findElement(By.xpath("//*[@id=\"signUpForm\"]/div[3]/input")).sendKeys("ValidPass12");
		// Click login
		driver.findElement(By.xpath("//button[@class='btn signin']")).click();
		Thread.sleep(2000);
		String errorMessage = driver.findElement(By.xpath("//span[@class='error-msg']")).getText(); // Replace with
																									// actual error
																									// element
		System.out.println("Fetched error message is:-" + errorMessage);
		String expectederrorMessage = "Password mismatch";
		Assert.assertEquals(errorMessage, expectederrorMessage);
		Thread.sleep(2000);
	}

	@Test(priority =5)
	public void SignUp_with_a_Password_Less_Than_6_Characters() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("sign-up-from-email")).sendKeys(generateRandomEmail());
		// Enter password
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345");
		// Enter confirm password
		driver.findElement(By.xpath("//*[@id=\"signUpForm\"]/div[3]/input")).sendKeys("12345");
		// Click login
		driver.findElement(By.xpath("//button[@class='btn signin']")).click();
		Thread.sleep(2000);
		String errorMessage = driver.findElement(By.xpath("//span[@class='error-msg']")).getText(); // Replace with
																									// actual error
																									// element
		System.out.println("Fetched error message is:-" + errorMessage);
		String expectederrorMessage = "Password must contain at least 6 characters";
		Assert.assertEquals(errorMessage, expectederrorMessage);
		Thread.sleep(2000);
	}

	@Test(priority =6)
	public void SignUp_with_an_Email_Containing_Invalid_Characters_Space() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("sign-up-from-email")).sendKeys("   ");
		// Enter password
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345");
		// Enter confirm password
		driver.findElement(By.xpath("//*[@id=\"signUpForm\"]/div[3]/input")).sendKeys("12345");
		// Click login
		driver.findElement(By.xpath("//button[@class='btn signin']")).click();
		Thread.sleep(2000);
		String errorMessage = driver.findElement(By.xpath("//span[@class='error-msg']")).getText(); // Replace with
																									// actual error
																									// element
		System.out.println("Fetched error message is:-" + errorMessage);
		String expectederrorMessage = "Email required";
		Assert.assertEquals(errorMessage, expectederrorMessage);
		Thread.sleep(2000);
	}

	@Test(priority =7)
	public void SignUp_with_an_Password_Containing_Invalid_Characters_Space() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("sign-up-from-email")).sendKeys(generateRandomEmail());
		// Enter password
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("      ");
		// Enter confirm passwor
		driver.findElement(By.xpath("//*[@id=\"signUpForm\"]/div[3]/input")).sendKeys("      ");
		// Click login
		
		driver.findElement(By.xpath("//button[@class='btn signin']")).click();
		Thread.sleep(2000);

		String locator = "//span[@class='error-msg']";
		boolean testResult = isDisplayed(locator);
		Assert.assertTrue(testResult,
				"This test case is fail because in password & confirmPassword spaces are allowed, expected We should not allow spaces for password");
		String errorMessage = driver.findElement(By.xpath("//span[@class='error-msg']")).getText(); // Replace with
																									// actual error
																									// element
		// System.out.println("Fetched error message is:-"+errorMessage);
		String expectederrorMessage = "Password must contain at least 6 characters";
		Assert.assertEquals(errorMessage, expectederrorMessage);

	}

	public boolean isDisplayed(String locator) {
		boolean result1 = false;
		try {
			result1 = driver.findElement(By.xpath(locator)).isDisplayed();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result1;
	}

	public void delete_Account() throws InterruptedException {
		driver.findElement(By.xpath("//ul[@class='navbar-nav menu']//li[4]")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='deleteAccountWrapper']/button")));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement button = driver.findElement(By.xpath("//*[@class='deleteAccountWrapper']/button"));
		js1.executeScript("arguments[0].click();", button);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='deleteAccountWrapper']/button")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='swal2-input']")).sendKeys("ValidPass123");
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='swal2-confirm swal2-styled']")));
		driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Delete!')]")));
		driver.findElement(By.xpath("//*[contains(text(),'Delete!')]")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Yes!')]")));
		driver.findElement(By.xpath("//*[contains(text(),'Yes!')]")).click();
		Thread.sleep(4000);
	}

	@AfterMethod
	public void close() {
		 driver.quit();
	}

}
