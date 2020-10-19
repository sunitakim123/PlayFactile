package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	//Adding logs
	//generating html reports
	//screenshot on falure
	//jenkins Integration
	public WebDriver driver;
	public static  Properties prop = new Properties();
	public WebDriver IntilizeDriver() throws IOException {
	
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);		
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\main\\java\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//https://stackoverflow.com/questions/49647636/delete-chromedriver-from-eclipse
		}
		else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\src\\main\\java\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} 
		else if (browserName.equals("IE")) {

		}
		return driver;
	}
	
	public String getscreenShotPath(String testcaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
	File source=	ts.getScreenshotAs(OutputType.FILE);
	String destinationFile= System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}

}
