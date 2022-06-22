package Scripts;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Basepackage.Baseclass;
import Pages.Signuppage;
import Pages.Walletpage;

public class WalletTest extends Baseclass{

	public static Walletpage page;
	
	@BeforeMethod
	public void setup() {
    	initialization(); 
    	 	
    }
	@Test(priority=1,description="Login with username and password in wallet")
	
	public void Loginwithwallet() throws InterruptedException {
		page=new Walletpage();
		//Please pass here username and password
		String str=page.GetLoggedin_AndWait("narendra0035@gmail.com", "Naru@100");
		Assert.assertEquals(str, "My Wallet");
		System.out.println(str);
	}	
	
	@Test(priority=2,description="Hover on stars and policy page change to health insurance review and review submit ")
	public void Hover_stars() throws InterruptedException {
		Loginwithwallet();
		page.Hoveron_Star();
	    page.selectValueFromDropDown(driver);
		//System.out.println(str);
		
	}
@Test(priority=3,description="Go to profile and check review")
	public void Submitting() throws InterruptedException {

		Loginwithwallet();
		String editbutton=page.Click_profile();
		Assert.assertEquals(editbutton,"Test Insurance Company");
			
	}
	@AfterMethod
	public  void quit(ITestResult result) {
		
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