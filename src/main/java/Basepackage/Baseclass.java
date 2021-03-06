package Basepackage;

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


public class Baseclass {
	
	public static Properties pop;
	public static WebDriver driver;
			public Baseclass() {	
				try {
					pop=new Properties();
					
					FileInputStream fi=new FileInputStream("/Users/narendra/git/Testng/Java.com.project/src/main/java/Readpop.properties");
					try {	
						
						pop.load(fi);
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
		}
			
		public static void initialization() {
			
			String browser=pop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			
			
			System.setProperty("webdriver.chrome.driver","/Users/narendra/git/Testng/Java.com.project/drivers/chromedriver 25");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox")){
			
			System.setProperty("webdriver.gecko.driver","\\resources\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		//driver.get(pop.getProperty("url2"));
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		}
}