package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
  
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(id="password")
	WebElement pwd;
	
	@FindBy(css="input.accountActionButton")
	WebElement signin;
	
	@FindBy(xpath="//div[@id='collapsibleNavbar']")
	WebElement NavigationBar;
	
	public WebElement getEmailid()
	{
		return username;
	}
	public WebElement getPassword()
	{
		return pwd;
	}
	public WebElement getSignin()
	{
		return signin;
	}
	
	
	public WebElement getNavigationBar()
	{
		return NavigationBar;
	}
	
	
	
	
}
