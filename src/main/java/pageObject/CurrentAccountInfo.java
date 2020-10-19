package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CurrentAccountInfo {
	
	WebDriver driver;
	
	public CurrentAccountInfo (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void checkAccountInfo() throws InterruptedException {
		driver.findElement(By.xpath("//span[@id='settings']")).click();

		//WebDriverWait wait = new WebDriverWait(driver,30);
		Thread.sleep(2000);
		WebElement HomeSchoolRadiobutton= driver.findElement(By.xpath("//body/div[@id='__flow-root']/div[1]/div[2]/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ins[1]"));
		if(HomeSchoolRadiobutton.isSelected())
		{
		System.out.println("radio button is Selected");			
		}
		else 
		{ HomeSchoolRadiobutton.click();
		driver.findElement(By.xpath("//*[@id='changeSubscriptionSubmit']")).click();
				
		}
		
		
		//System.out.print("Active subscription is:=");
	//	System.out.println(driver.findElement(By.id("yearlyBox")).getText());
		}
	
			@FindBy(id="yearlyBox")
			WebElement subscrition;
			
			public WebElement getActiveSubscription()
			{
				return subscrition;
			}
	
}
