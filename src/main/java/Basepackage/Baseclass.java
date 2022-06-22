package Basepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Baseclass {
	
	public static Properties pop;
	public static WebDriver driver;
			public Baseclass() {	
				try {
					pop=new Properties();
					String path=System.getProperty("user.dir");
					
					FileInputStream fi=new FileInputStream("/Users/narendra/eclipse-workspace/Java.com.project/src/main/java/Readpop.properties");
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
			
			String path=System.getProperty("user.dir");
			
			String browser=pop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			
			
			System.setProperty("webdriver.chrome.driver","//Users//narendra//Downloads//chromedriver 25");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox")){
			
			System.setProperty("webdriver.gecko.driver",path+"\\resources\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		//driver.get(pop.getProperty("url2"));
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		}
}
