package HundredUsers;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class joinsuser4to8 extends moderaterscreen {


	@Test
	public void Call() throws InterruptedException, IOException {
	
		driver1 = IntilizeDriver();
		Dimension d1 = new Dimension(1382,744);     
		driver1.manage().window().setSize(d1); 
		driver1.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver1.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		driver1.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wait1 = new WebDriverWait(driver1, 60);
		driver1.get(prop.getProperty("joinurl"));
		String url = driver1.getCurrentUrl();
		Thread.sleep(2000);
		System.out.println(i);
		System.out.println(j);
		driver1.findElement(By.xpath("//input[@class='form-control']")).sendKeys(j);	
						Thread.sleep(2000);			
			driver1.findElement(By.xpath("//input[@class='joinBtn yellowBG mt-4 mb-4']")).click();
						Thread.sleep(2000);
		driver1.findElement(By.xpath("(//div[@class='characterBlock position-relative'])[last()]")).click();
		Thread.sleep(2000);
	
		driver2 = IntilizeDriver();
		Dimension d2 = new Dimension(1382,744);     
		driver2.manage().window().setSize(d2); 
		driver2.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver2.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		driver2.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wait2 = new WebDriverWait(driver2, 60);
		driver2.get(prop.getProperty("joinurl"));				
		Thread.sleep(2000);
		driver2.findElement(By.xpath("//input[@class='form-control']")).sendKeys(j);
		Thread.sleep(2000);
						driver2.findElement(By.xpath("//input[@class='joinBtn yellowBG mt-4 mb-4']")).click();			
		Thread.sleep(2000);
		driver2.findElement(By.xpath("(//div[@class='characterBlock position-relative'])[last()]")).click();
		Thread.sleep(2000);
		
		driver3 = IntilizeDriver();
		driver3.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver3.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		driver3.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wait3 = new WebDriverWait(driver3, 60);
		driver3.get(prop.getProperty("joinurl"));				
		Thread.sleep(2000);
		driver3.findElement(By.xpath("//input[@class='form-control']")).sendKeys(i);
		Thread.sleep(2000);
						driver3.findElement(By.xpath("//input[@class='joinBtn yellowBG mt-4 mb-4']")).click();			
		Thread.sleep(2000);
		driver3.findElement(By.xpath("(//div[@class='characterBlock position-relative'])[last()]")).click();
		Thread.sleep(2000);
		
		
		driver4 = IntilizeDriver();
		driver4.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver4.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		driver4.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wait4 = new WebDriverWait(driver4, 60);
		driver4.get(prop.getProperty("joinurl"));				
		Thread.sleep(2000);
		driver4.findElement(By.xpath("//input[@class='form-control']")).sendKeys(i);
		Thread.sleep(2000);
						driver4.findElement(By.xpath("//input[@class='joinBtn yellowBG mt-4 mb-4']")).click();			
		Thread.sleep(2000);
		driver4.findElement(By.xpath("(//div[@class='characterBlock position-relative'])[last()]")).click();
		Thread.sleep(2000);
	
	}
	
	
}
