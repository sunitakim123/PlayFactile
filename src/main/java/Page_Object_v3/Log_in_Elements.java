package Page_Object_v3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Log_in_Elements {
 public WebDriver driver;
 
 
 public Log_in_Elements(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	

	@FindBy(xpath="//a[@class='blueOutlineSec01']")
	
	WebElement clickOnLog_in_home;
	public WebElement Log_in_button()
	{
		return clickOnLog_in_home;
	}
	
	
	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	
	public WebElement getenterEmail() {
		return email;
	}
	
	@FindBy(xpath="//input[@name='password']")
	WebElement pwd;
	public WebElement getenterPwd()
	{
		return pwd;
	}
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Log_In;
	
	public WebElement getlogin()
	{
		return Log_In;
	}
 
}
