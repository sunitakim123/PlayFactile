package pageObject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadMascot {

	WebDriver driver;
	
public UploadMascot(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	

	
@FindBy(xpath="//*[@id='addNewCharacter']")
WebElement AddMascot;


public WebElement Mascot()
{
	return AddMascot;
}
}


