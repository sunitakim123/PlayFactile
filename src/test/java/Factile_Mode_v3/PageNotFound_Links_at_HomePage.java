package Factile_Mode_v3;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Page_Object_v3.Log_in_Elements;
import resources.Base;

public class PageNotFound_Links_at_HomePage extends Base {
	WebDriver driver;	
	int int2;
	Actions act;
	WebDriverWait wait;
	 ArrayList<String> al ;
	public static Logger Log = LogManager.getLogger(PageNotFound_Links_at_HomePage.class.getName());

	@BeforeTest
	public void initilize() throws IOException, InterruptedException {		
	
		driver = IntilizeDriver();
		Log.info("Driver is Initilize");
		driver.get(prop.getProperty("rooturl"));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 40);
		Log.info("Navigated to homePage");
		
	}
	
	
	@Test
	public void PageNotFoundLinksAtHomePage() throws MalformedURLException, IOException, InterruptedException
	{
		 al = new ArrayList<String>();
		  
		    //identifying total number of URls in a page
		    List<WebElement> links = driver.findElements(By.tagName("a")); 
		    System.out.println(links.size());
		   
		           //for Getting all links from page
		          for (int i = 0;i<links.size(); i++) {
		      
		        //get one by one URL href value
		        String URL=links.get(i).getAttribute("href"); 
		       
		        //Removing unwanted URLS based on http or https
		        if(links.get(i).getAttribute("href").contains("https")||links.get(i).getAttribute("href").contains("http"))
		        {
		        System.out.println(URL);
		       
		         //storing all in URL's in array list
		         al.add(URL);
		       
		        }
		          }
		     
		          //Identifying  broken and 404 links
		         
		          for(int i=0;i<al.size();i++){
		           
		           //Navigating each URL
		           driver.get(al.get(i));
		           Thread.sleep(1000);
		           //getting response Code for the link
		           int statusCode= ResponseCode(al.get(i));

		           //verifying 404 links using page URL
		           //  if(driver.getTitle().contains("404")){
		           if(driver.getCurrentUrl().contains("404")){
		            
		            System.out.println("404 link is:-  "+al.get(i));
		            
		           }
		           
		           //verifying 404 links using page source
		           else if(driver.getPageSource().contains("PAGE NOT FOUND")){
		            
		            System.out.println("404 link is:-  "+al.get(i));
		            
		           }
		           //verifying 404 links using status code
		           else if(statusCode==404){
		            
		            System.out.println("404 link is:-  "+al.get(i));
		           } 
		           
		           
		          } 
		  }
		    //method for generating response code for URL
		     public static int ResponseCode(String URL) throws MalformedURLException, IOException {     
		        URL url = new URL(URL); 
		        HttpURLConnection huc = (HttpURLConnection) url.openConnection(); 
		        huc.setRequestMethod("GET"); 
		        huc.connect(); 
		        return huc.getResponseCode(); 
		     } 
   
	
		
		
		
	
	@AfterTest
	public void close()
	{ 
		driver.quit();
		
	}
}
