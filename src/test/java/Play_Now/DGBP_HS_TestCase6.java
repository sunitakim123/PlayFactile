package Play_Now;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestCases_Execution.TestCase_1;
import junit.framework.Assert;
import resources.Base;

public class DGBP_HS_TestCase6  extends Base{
	WebDriver driver;
	WebDriver driver1;
	WebDriverWait wait, wait1;
	int int2;
	String s6, s7, GameName, twitterLink, PintrestLink, t1, p1;
	Actions act;
	
	public static Logger Log = LogManager.getLogger(TestCase_1.class.getName());
	private static String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\images\\eagle.jpg";

	@BeforeTest
	public void initilize() throws IOException {
		driver = IntilizeDriver();
		Log.info("Driver is Initilize");
		driver.get(prop.getProperty("rooturl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);
		//driver1.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//wait1 = new WebDriverWait(driver1, 20);
		Log.info("Navigated to homePage");

	}

	@Test
	public void Verify_Show_Social_Media_on_Gameboard_If_Unchecked() throws InterruptedException, IOException {
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
			modeaterscreen();
			VerifyupSMOLinksAtModraterScreenGameboard();
		} else if (s2.equalsIgnoreCase(s5)) {
			modeaterscreen();
			VerifyupSMOLinksAtModraterScreenGameboard();
		} else if (s3.equalsIgnoreCase(s5)) {
			modeaterscreen();
			VerifyupSMOLinksAtModraterScreenGameboard();
		} else if (s4.equalsIgnoreCase(s5)) {
			modeaterscreen();
			VerifyupSMOLinksAtModraterScreenGameboard();
		} else {
			System.out.println("You have not taken any subscription");
		}
	}

	@AfterTest
	public void tearDown() {
		//driver.close();
		//driver1.close();
	}

	public void modeaterscreen() throws InterruptedException
	{
		driver.findElement(By.id("customize")).click();
		Thread.sleep(3000);
		
		//unchecking the Hide social links on gameboard
		if(!driver.findElement(By.xpath("//div[@id='gameSettingSection']//input[@id='hideSocialLinks']")).isSelected())
		{System.out.println("nothing to do");
		}
		else
		{
			act = new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//div[@id='gameSettingSection']//input[@id='hideSocialLinks']"))).click().perform();;
		
		}
	} 
	
	public void VerifyupSMOLinksAtModraterScreenGameboard() throws InterruptedException, IOException {
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		System.out.println("ParentWindow id is :-" + parent);
		driver.findElement(By.xpath("//*[@id='mygames']")).click();
		GameName = prop.getProperty("gamename");
		// 'Test"+int1+"'
		driver.findElement(
				By.xpath("//div[@data-text='" + GameName + "']/following-sibling::div/span[contains(text(), 'Play')]"))
				.click();
		Thread.sleep(3000);
		
			boolean obj = driver.findElement(By.xpath("//button[contains(text(),'Start new game')]")).isDisplayed();
			
			if(obj==true)
{
				 driver.findElement(By.xpath("//button[contains(text(),'Start new game')]")).click();
}
		
		Thread.sleep(1000);
		Set<String> allWindows = driver.getWindowHandles();
		int count = allWindows.size();
		System.out.println("Total window:=" + count);
		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
			
				Thread.sleep(4000);
				driver.findElement(By.xpath("//span[@class='playNowButton']")).click();

				driver.findElement(By.xpath("//*[@id='howManyTeams']/div/div[1]/span[1]")).click();
				
				Thread.sleep(3000);

				System.out.println(driver.getTitle());
				driver.findElement(By.xpath("//*[@id='displayBuzzerOptionBack']/div[1]/div[2]/div/div/ins")).click();

				driver.findElement(By.xpath("//*[@id='buzzerModeQuestion']/div/div[1]/span[2]")).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='inviteYourTeams']/div/span[4]")));
				Thread.sleep(3000);
				String i = driver.findElement(By.xpath("//*[@id='inviteYourTeams']/div/span[2]")).getText();
				System.out.println(i);// System.out.println(driver.getTitle());
				Thread.sleep(3000);

				driver1 = IntilizeDriver();

				driver1.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
				driver1.get(prop.getProperty("joinurl"));
				Thread.sleep(3000);
				driver1.findElement(By.xpath("//input[@class='form-control']")).sendKeys(i);
				driver1.findElement(By.xpath("//button[contains(text(),'Join')]")).click();
				Thread.sleep(2000);
				 driver1.findElement(By.xpath("//div[@data-name='Pineapple']")).click();
				 Thread.sleep(2000);
				 driver.switchTo().window(driver.getWindowHandle());
				 Thread.sleep(2000);
				 driver.findElement(By.xpath("//span[contains(text(),'Begin Game')]")).click();
				 Thread.sleep(2000);
				 driver.findElement(By.xpath("//span[contains(text(),'Start Game')]")).click();
				 Thread.sleep(2000);

				 twitterLink = "https://twitter.com/intent/tweet?text=Playing%20PlayWin%20Jeopardy%20style&url=https://awspf.com/newplay/play&via=playfactile";
				 			   // "https://www.pinterest.com/pin/create/button?guid=jFE1MQuKNYAF-1&url=https%3A%2F%2Fawspf.com%2Fnewplay%2Fplay&media=undefined&description=PlayWin%20-%20Factile";
				 PintrestLink=	"https://www.pinterest.com/pin/create/button?guid=PjuTvwrrevai-1&url=https%3A%2F%2Fawspf.com%2Fnewplay%2Fplay&media=undefined&description=PlayWin%20-%20Factile";
				 
				String tl =driver.findElement(By.xpath("//span[@class='btn btn-social-icon btn-twitter redirectLink_blank']")).getAttribute("data-href");
				p1= driver.findElement(By.xpath("//a[@class='btn btn-social-icon btn-pinterest']")).getAttribute("data-pin-href");
				if(tl.equalsIgnoreCase(twitterLink))
				{
					System.out.println(t1);
					Log.info("Twitter link is>>"+t1);
					
				}
				
				if(p1.equalsIgnoreCase(PintrestLink))
				{
					System.out.println(p1);
					Log.info("Pintrest  link is>>"+p1);
					
				}
				// Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='btn btn-social-icon btn-twitter redirectLink_blank']"))).getAttribute("data-href").equals("https://twitter.com/intent/tweet?text=Playing%20PlayWin%20Jeopardy%20style&url=https://awspf.com/newplay/play&via=playfactile"));
				 //Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-social-icon btn-pinterest']"))).getAttribute("data-pin-href").equals("https://www.pinterest.com/pin/create/button?guid=jFE1MQuKNYAF-1&url=https%3A%2F%2Fawspf.com%2Fnewplay%2Fplay&media=undefined&description=PlayWin%20-%20Factile"));
				 
}	
		}}}
