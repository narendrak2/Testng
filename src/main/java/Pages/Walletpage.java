package Pages;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import Basepackage.Baseclass;

public class Walletpage extends Baseclass{

	
	
	
	public static String url="https://wallethub.com/profile/13732055i";
	
	public static WebDriverWait wait;
	
	//defining locators using page factory
	
		
 @FindBy(xpath="//nav[@role='none']//span[@role='link']")
	
	WebElement loginbtn;
 
 @FindBy(xpath="//h1[normalize-space()='Login']")
	
	WebElement Assertpage;
	
 @FindBy(xpath="//input[@placeholder='Email Address']")
	
	WebElement Email;
 	
 @FindBy(xpath="//input[@placeholder='Password']")
	
	WebElement Password;
	
 @FindBy(xpath="//span[@ng-if='!pending']")
	
	WebElement loginbtn2;
 
 @FindBy(xpath="//a[@class='brgm-button'][normalize-space()='My Wallet']")
 
 WebElement loggedinverify;
 
 
@FindBy(xpath="//span[@class='//*[@id=']")
 
 WebElement Reviewpage;


@FindBy(xpath="//review-star[@class='rvs-svg']//div[@class='rating-box-wrapper']//*[name()='svg'][1]")

WebElement Star1;


@FindBy(xpath="//span[@class='nav-txt'][normalize-space()='Reviews']")
WebElement review;


@FindBy(xpath="//review-star[@class='rvs-svg']//div[@class='rating-box-wrapper']//*[name()='svg'][4]")
	
WebElement star4;


@FindBy(xpath="//div[normalize-space()='Submit']")

WebElement submitbtn;



@FindBy(xpath="//span[normalize-space()='Select...'])[1]")
List<WebElement> selectoption1;


@FindBy(xpath="//textarea[@placeholder='Write your review...']")

WebElement AddReview;



@FindBy(xpath="//*[@id='web-app']/header/div/nav[1]/div[5]/span")

WebElement Profilehover;



@FindBy(xpath="//a[@class='brgm-list-it'][normalize-space()='Profile']")

WebElement Profileclick;



@FindBy(xpath="//a[normalize-space()='Test Insurance Company']")

WebElement Testinsuranceappear;


@FindBy(xpath="//*[@id='reviews-section']/modal-dialog/div/div/write-review/div[2]/div/ng-dropdown/div/span[1]")

WebElement Clickondropdown;


@FindBy(xpath="//ul[@aria-labelledby='']/li[2]")

WebElement ClickonHealth;


@FindBy(xpath="//textarea[@placeholder='Write your review...']")

WebElement Reviewadd;



@FindBy(xpath="//div[normalize-space()='Submit']")

WebElement submit;



String reviewadding="WalletHub helps all consumers reach top financial fitness by providing Free credit scores and credit reports that are updated on a daily basis Free 24/7 credit monitoring and personalized advice that will help you improve your credit and save money.";
		








 public Walletpage() {
	 driver.get(url);
	 PageFactory.initElements(driver, this);
	 
 }
 public String GetLoggedin_AndWait(String username,String passsword){
	 
	 wait=new WebDriverWait(driver,20);
	 loginbtn.click();
	 wait.until(ExpectedConditions.elementToBeClickable(Email)).sendKeys(username);
	 Password.sendKeys(passsword);
	 loginbtn2.click();
	 WebElement str= wait.until(ExpectedConditions.elementToBeClickable(loggedinverify));
	 String texts=str.getText();
	 return texts;
	}
 
 public String Assert(String text) {
	  
	 text=Assertpage.getText();
	 return text;
	 
 }
 public void Hoveron_Star() throws InterruptedException {
	 
	 review.click();
	 Thread.sleep(4000);
	 Actions action=new Actions(driver);
	 Thread.sleep(2000);
	 WebElement star=Star1;
	 action.moveToElement(star).perform();
	 wait=new WebDriverWait(driver,10);
	 WebElement str= wait.until(ExpectedConditions.elementToBeClickable(star4));
	 str.click();
	 Thread.sleep(2000);
 }
	 public void selectValueFromDropDown(WebDriver driver) throws InterruptedException{
	       
		 Clickondropdown.click();
		 Thread.sleep(2000);
		 ClickonHealth.click();
		 Reviewadd.sendKeys(reviewadding);
		 Thread.sleep(3000);
		 submit.click();
		 Thread.sleep(3000);
	        
	        }       
 public String Click_profile() throws InterruptedException {
	 Actions action=new Actions(driver);
	 Thread.sleep(2000);
	 WebElement profile=Profilehover;
	 action.moveToElement(profile).perform();
	 wait=new WebDriverWait(driver,10);
	 WebElement web= wait.until(ExpectedConditions.elementToBeClickable(Profileclick));
	 web.click();
	 Thread.sleep(3000);
	 WebElement web1= wait.until(ExpectedConditions.elementToBeClickable(Testinsuranceappear));
	 String str=web1.getText();
	 web1.click();
	 Thread.sleep(2000);
	 boolean str2=driver.getPageSource().contains(reviewadding);
	 return str;
 }

}