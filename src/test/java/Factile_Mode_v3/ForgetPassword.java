package Factile_Mode_v3;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Page_Object_v3.Log_in_Elements;
import Page_Object_v3.SignUP_elements;
import resources.Base;

public class ForgetPassword extends Base {
	WebDriver driver;
	int int2;
	Actions act;
	WebDriverWait wait;
	String parent;
	String expectedUrl = "https://v3.awspf.com/mygames";
	public static Logger Log = LogManager.getLogger(ForgetPassword.class.getName());

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
	public void Forget_Password() throws InterruptedException {

		Log_in_Elements lobj1 = new Log_in_Elements(driver);
		lobj1.Log_in_button().click();
		driver.findElement(By.xpath("//a[text()='Click here']")).click();
		lobj1.getenterEmail().sendKeys("sunita26@yopmail.com");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.navigate().to("http://www.yopmail.com/en/");
		parent = driver.getWindowHandle();
		System.out.println("ParentWindow id is :-" + parent);
		driver.findElement(By.cssSelector("input#login")).sendKeys("sunita26");
		driver.findElement(By.cssSelector("input.sbut")).click();
		Thread.sleep(10000);
		driver.navigate().refresh();
		driver.findElement(By.cssSelector("span.slientext")).click();
		driver.switchTo().frame("ifmail");
		driver.findElement(By.linkText("RESET YOUR PASSWORD")).click();

		Set<String> allWindows = driver.getWindowHandles();
		int count = allWindows.size();
		// System.out.println("Total window:=" + count); 
		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);

				SignUP_elements sobj = new SignUP_elements(driver);
				sobj.getPassword().sendKeys("12345678");
				sobj.getConfirmPassword().sendKeys("12345678");
				sobj.getSignIN().click();
				lobj1.getenterEmail().sendKeys("sunita26@yopmail.com");
				lobj1.getenterPwd().sendKeys("12345678");
				lobj1.getlogin().click();
				Thread.sleep(5000);
				String currentURL = null;
				currentURL = driver.getCurrentUrl();
				assertEquals(currentURL, expectedUrl);
			}
		}

	}

	@AfterTest
	public void close() {
		driver.quit();
	}

}
