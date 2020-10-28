package Play_Now;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestCases_Execution.TestCase_1;
import resources.Base;

public class DGBP_HSB_TestCase3  extends Base{
	WebDriver driver;
	WebDriver driver1;
	WebDriverWait wait;
	int int2;
	String s1;
	public static Logger Log = LogManager.getLogger(TestCase_1.class.getName());
	private static String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\images\\eagle.jpg";

	@BeforeTest
	public void initilize() throws IOException {
		driver = IntilizeDriver();
		Log.info("Driver is Initilize");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);
		Log.info("Navigated to homePage");

	}

	@Test
	public void Verify_Uploaded_Mascot_at_Player_screen() throws InterruptedException {
		driver.findElement(By.cssSelector("span.loginButton")).click();
		driver.findElement(By.id("email")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("pwd"));
		driver.findElement(By.cssSelector("input.accountActionButton")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='settings']")));
		driver.findElement(By.xpath("//span[@id='settings']")).click();
		String s1 = driver.findElement(By.xpath("//*[@id='yearlyBox']/div")).getAttribute("class");
		String s2 = driver.findElement(By.xpath("//*[@id='monthlyBox']/div")).getAttribute("class");
		String s3 = driver.findElement(By.xpath("//*[@id='yearlybusinessBox']/div")).getAttribute("class");
		String s4 = driver.findElement(By.xpath("//*[@id='monthlybusinessBox']/div")).getAttribute("class");

		Thread.sleep(3000);
		String s5 = "iradio_flat-yellow checked";

		if (s1.equalsIgnoreCase(s5)) {
			
		} else if (s2.equalsIgnoreCase(s5)) {
			
		} else if (s3.equalsIgnoreCase(s5)) {
			
		} else if (s4.equalsIgnoreCase(s5)) {
			

		} else {
			System.out.println("You have not taken any subscription");
		}
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
