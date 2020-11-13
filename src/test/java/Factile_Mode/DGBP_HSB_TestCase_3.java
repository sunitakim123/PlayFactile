package Factile_Mode;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Base;


public class DGBP_HSB_TestCase_3  extends Base{
	WebDriver driver;
	WebDriver driver1;
	WebDriverWait wait;
	int int2;
	Actions act;
	String GameName, parent;
	WebElement e1, e2, e3, e4, e5, e6, e7, e8;
	String image1, GameBoardColour, QuestionTileColourAndDollarColour, TextColour, PGameboardColor, PGameTileColour, pTextColour;
	public static Logger Log = LogManager.getLogger(DGBP_HSB_TestCase_3.class.getName());
	private static String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\images\\bimage.jpg";

	@BeforeTest
	public void initilize() throws IOException {
		driver = IntilizeDriver();
		Log.info("Driver is Initilize");
		driver.get(prop.getProperty("rooturl"));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 60);	
		Log.info("Navigated to homePage"); 

	}

	@Test
	public void TC_3_Verify_Uploaded_BackgroundImage_at_Player_screen() throws InterruptedException, IOException {
	
		driver.findElement(By.cssSelector("span.loginButton")).click();
		driver.findElement(By.id("email")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("pwd"));
		driver.findElement(By.cssSelector("input.accountActionButton")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='settings']")));
		driver.findElement(By.xpath("//span[@id='settings']")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='yearlyBox']/div")));
		String s1 = driver.findElement(By.xpath("//*[@id='yearlyBox']/div")).getAttribute("class");
		String s2 = driver.findElement(By.xpath("//*[@id='monthlyBox']/div")).getAttribute("class");
		String s3 = driver.findElement(By.xpath("//*[@id='yearlybusinessBox']/div")).getAttribute("class");
		String s4 = driver.findElement(By.xpath("//*[@id='monthlybusinessBox']/div")).getAttribute("class");

		Thread.sleep(3000);
		String s5 = "iradio_flat-yellow checked";

		if (s1.equalsIgnoreCase(s5)) {
			try {
			uploadBAckgroundimageAtModeraterScreen();
			VerifyuploadedBackgroundimageatBothScreen();
			}
			catch(InterruptedException e) {
				System.out.println(e.toString());
			}
		} else if (s2.equalsIgnoreCase(s5)) {
			try {
				uploadBAckgroundimageAtModeraterScreen();
				VerifyuploadedBackgroundimageatBothScreen();
				}
				catch(InterruptedException e) {
					System.out.println(e.toString());
				}
		} else if (s3.equalsIgnoreCase(s5)) {
			try {
				uploadBAckgroundimageAtModeraterScreen();
			VerifyuploadedBackgroundimageatBothScreen();
				}
				catch(InterruptedException e) {
					System.out.println(e.toString());
				}
		} else if (s4.equalsIgnoreCase(s5)) {
			try {
				uploadBAckgroundimageAtModeraterScreen();
				VerifyuploadedBackgroundimageatBothScreen();
				}
				catch(InterruptedException e) {
					System.out.println(e.toString());
				}

		} else {
			System.out.println("You have not taken any subscription");
		}
		
		
	}

	@AfterTest
	public void tearDown() {
	driver1.quit();
		driver.switchTo().window(driver.getWindowHandle());
		driver.quit();
	}
	public void uploadBAckgroundimageAtModeraterScreen() throws InterruptedException {
		driver.findElement(By.id("customize")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='mascotSection']/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Yes, reset !')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		Thread.sleep(3000); 
		
		/*driver.findElement(By.xpath("//*[@id='gameDesignSection']//span[@class='resetToDefault resetCustomizations']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Yes, reset !')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		Thread.sleep(3000); 
		*/
		try {
		int total = driver.findElements(By.xpath("//*[@id='gameDesignSection']//span[@class='deleteBackground']")).size();
		if(total>0)
		{
			for(int i=0;i<=total;i++)
			{
				driver.findElement(By.xpath("//*[@id='gameDesignSection']//span[@class='deleteBackground']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[contains(text(),'Yes, Delete it!')]")).click();
				Thread.sleep(3000);
			}
		}
		} 
		 catch (NoSuchElementException e) {
				// log.debug("Impossible to click the pop-up. Reason: " + e.toString());
				System.out.println("Impossible to click the pop-up. Reason: " + e.toString());
			} 
		 
		driver.findElement(By.xpath("//*[@id='addNewBackground']/div/span")).click();	
	 
		uploadFileWithRobot(filePath);
		Thread.sleep(10000);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='gameDesignSection']//input[@cLass='backgroundImageBtn'])[last()]")));
		driver.findElement(By.xpath("(//*[@id='gameDesignSection']//input[@cLass='backgroundImageBtn'])[last()]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='backgroundColorPreview']")).click();
		driver.findElement(By.xpath("//*[@id='backgroundColorChooser']//*[@data-color='#1f1f1f']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='gameBoardColorPreview']")).click();
		driver.findElement(By.xpath("//*[@id='gameBoardColorChooser']/div/div[2]/div[11]")).click();
		Thread.sleep(1000);
		 driver.findElement(By.xpath("//*[@id='questionTileColorPreview']")).click();
		driver.findElement(By.xpath("//*[@id='questionTileColorChooser']/div/div[2]/div[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='dollarAmountColorPreview']")).click();
		driver.findElement(By.xpath("//*[@id='dollarAmountColorChooser']/div/div[2]/div[6]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='textColorPreview']")).click();
		driver.findElement(By.xpath("//*[@id='textColorChooser']/div/div[2]/div[10]")).click(); 
		Thread.sleep(3000);
		
		
			}
	
	public void VerifyuploadedBackgroundimageatBothScreen() throws InterruptedException, IOException {
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
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@data-numteams='2']")));
				driver.findElement(By.xpath("//span[@data-numteams='2']")).click();
				
				Thread.sleep(3000);

				//1. Display question on buzzer device
				//driver.findElement(By.xpath("(//ins[@class='iCheck-helper'])[1]")).click();
				
				//2. Display GM o buzzer device
				driver.findElement(By.xpath("//*[@id='displayBuzzerOptionBack']/div[1]/div[2]/div/div/ins")).click();

				//3. Buzzer Only
				//driver.findElement(By.xpath("(//ins[@class='iCheck-helper'])[3]")).click();
				
				driver.findElement(By.xpath("//*[@id='buzzerModeQuestion']/div/div[1]/span[2]")).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='inviteYourTeams']/div/span[4]")));
				Thread.sleep(3000);
				String i = driver.findElement(By.xpath("//*[@id='inviteYourTeams']/div/span[2]")).getText();
				System.out.println(i);// System.out.println(driver.getTitle());
				Thread.sleep(3000);

				driver1 = IntilizeDriver();
				driver1.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				driver1.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
				driver1.get(prop.getProperty("joinurl"));
				//driver1.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
				Thread.sleep(3000);
				driver1.findElement(By.xpath("//input[@class='form-control']")).sendKeys(i);
				driver1.findElement(By.xpath("//button[contains(text(),'Join')]")).click();
				Thread.sleep(2000);
				 driver1.findElement(By.xpath("(//div[@class='characterBlock position-relative'])[1]")).click();
				 Thread.sleep(2000);
				 driver.switchTo().window(driver.getWindowHandle());
				 Thread.sleep(2000);
				 driver.findElement(By.xpath("//span[contains(text(),'Begin Game')]")).click();
				 Thread.sleep(2000);
				 driver.findElement(By.xpath("//span[contains(text(),'Start Game')]")).click();
				 Thread.sleep(2000);
				WebElement e1 =driver.findElement(By.xpath("//div[@id='gamePlayPage']"));
				String image1= e1.getAttribute("style");
				System.out.println("Background image is successfully loaded at gameboard, image url is= "+image1);
				Log.info("Background image is successfully loaded at gameboard, image url is= "+image1);
			WebElement e2	=driver.findElement(By.xpath("//div[@class='jeopardyBoard customGame']"));
			String GameBoardColour = e2.getAttribute("style");
			System.out.println("Game Board Color is="+GameBoardColour);
			Log.info("At Modearter >> Game Board Color is="+GameBoardColour);
								
			WebElement e3 = driver.findElement(By.xpath("//*[@class='gameQuestionBlock unAnsweredQuestion']"));
			String QuestionTileColourAndDollarColour= e3.getAttribute("Style");
		System.out.println("Question Tile Color & Dollar colour is="+QuestionTileColourAndDollarColour);
		Log.info("At Modearter >> Question Tile Color & Dollar colour is="+QuestionTileColourAndDollarColour);
		
		WebElement e4 = driver.findElement(By.xpath("//*[@class='gameCategoryTitle playGameCategoryTitle']"));
		String TextColour= e4.getAttribute("Style");
	System.out.println("At moderater >> game category title color="+TextColour);
	Log.info("At Modearter >> game category title color="+TextColour);
			
		driver1.switchTo().window(driver1.getWindowHandle());
		Thread.sleep(4000);
		WebElement e5= driver1.findElement(By.xpath("//div[@id='mainGameBoard']"));
		String GameboardImageAtPlayer = e5.getAttribute("style");
		System.out.println("At player >> gameboard background image is>>"+GameboardImageAtPlayer);
		Log.info("At player >> gameboard background image is>>"+GameboardImageAtPlayer);
		
		if(image1.equalsIgnoreCase(GameboardImageAtPlayer))
		{
			System.out.println("Same image is displying at modertaer & player screen on gameboard");
		}
		WebElement e6 = driver1.findElement(By.xpath("//div[@class='jeopardyGameBoard h-100']"));
		String  PGameboardColor = e6.getAttribute("style");
		System.out.println("At player >> gameboard gameboard colour is =>>"+PGameboardColor);
		Log.info("At player >> gameboard gameboard colour is =>>"+PGameboardColor);
		
		WebElement e7 = driver1.findElement(By.xpath("//div[@class='gameTitle']"));
		String  PGameTileColour = e7.getAttribute("style");
		System.out.println("At player >> game tile color is =>>"+PGameTileColour);
		Log.info("At player >>game tile color is =>>"+PGameTileColour);
		
		WebElement e8 = driver1.findElement(By.xpath("//span[@class='gamePointsBlock']"));
		String  PGamepointColour = e8.getAttribute("style");
		System.out.println("At player >> Dollar colour is =>>"+PGamepointColour);
		Log.info("At player >>Dollar colour is=>>"+PGamepointColour);
		
		WebElement e9 = driver1.findElement(By.xpath("//span[@class='gameCategoryTitle']/span/p"));
		String pTextColour= e9.getAttribute("Style");
	System.out.println("At moderater >> game category Title color="+pTextColour);
	Log.info("At Modearter >> game category Title color="+pTextColour);
		
		
	}}}

	
	public void uploadFileWithRobot(String imagePath) {
		StringSelection stringSelection = new StringSelection(imagePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);

		Robot robot = null;

		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(150);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}
}
