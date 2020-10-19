package pageObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateGameUsingExcel {
	
	WebDriver driver;
	
public CreateGameUsingExcel(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void createGame() throws InterruptedException, FileNotFoundException
{
	driver.findElement(By.cssSelector("span.createNewGame")).click();
	driver.findElement(By.cssSelector("input.btn.popupSubmit.autoGen")).click();
	//String uuid = UUID.randomUUID().toString();
	//Now this uuid enter to your text box
	//driver.findElement(By.id("gameTitle")).sendKeys("Test"+uuid);
	Random rand = new Random();
	int int1 = rand.nextInt(100);
	driver.findElement(By.id("gameTitle")).sendKeys("Test"+int1);
	
	Thread.sleep(1000);
	System.out.println(driver.findElement(By.id("gameTitle")).getText());
	driver.findElement(By.id("customURLSubmit")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[@data-type='excel']")).click();
	Thread.sleep(3000);
//	driver.findElement(By.id("uploadExcel")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("uploadExcel")).sendKeys(System.getProperty("user.dir") + "\\src\\main\\java\\excelReader\\example.xlsx");
	Thread.sleep(10000);
	driver.findElement(By.xpath("//button[contains(text(),'Upload')]")).click();
	driver.findElement(By.xpath("//button[contains(text(),'Yes, Upload it!')]")).click();
	driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
	driver.findElement(By.xpath("//p[contains(text(),'My Games')]")).click();	
	String str1 ="Test"+int1;
	System.out.println(str1);

}
@FindBy(xpath="//div[@id='collapsibleNavbar']")
WebElement NavigationBar;
public WebElement getNavigationBar()
{
	return NavigationBar;
}

	
	
}
