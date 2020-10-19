package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
  
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(css="span.loginButton")
	WebElement login;
	
	@FindBy(css="h2.jeopardyRocks")
	WebElement Title;
	
	public WebElement getLogin()
	{
		return login;
	}
	public WebElement getTitle()
	{
		return Title;
	}
}
