package Scripts;

import java.awt.AWTException;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Basepackage.Baseclass;
import Pages.Signuppage;



public class Signuptest extends Baseclass{

	static Logger log = Logger.getLogger(Signuptest.class);
	
	@BeforeMethod
	public void setup() {
    	initialization(); 
    	
    }
	@Test(priority=1,description="Facbook Login with username and password")
	public void Loginwith_FB() throws InterruptedException {
		
		Signuppage page=new Signuppage();
		//use here username and password have to pass here
		page.login("narendra0035@gmail.com", "Naru@100");
		page.clickbuttonAndwait();//Here waits until button available after logged in
		System.out.println("Hello world");
		
	}	
	@AfterMethod
	public void quit(ITestResult result) {
		
if(ITestResult.FAILURE==result.getStatus()){
			
			try{
				//Taking screenshot and captured under screenshot folder
				TakesScreenshot screenshot=(TakesScreenshot)driver;
				File src=screenshot.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("screenshots\\"+result.getName()+".png"));
				System.out.println("Successfully taken screenshot");
				
			}catch (Exception e){
				
				System.out.println("Exception while taking screenshot "+e.getMessage());
			} 
	}
	driver.quit();
	}
}