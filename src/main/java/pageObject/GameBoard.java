package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GameBoard {

	
WebDriver driver;
	
	public GameBoard(WebDriver driver)
	{	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
}
