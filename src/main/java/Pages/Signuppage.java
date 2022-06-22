package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Basepackage.Baseclass;

public class Signuppage extends Baseclass{

	
public static String url="https://www.facebook.com/";	
	
	//defining locators using page factory
	
	@FindBy(xpath="//*[@class='inputtext _55r1 _6luy']")
	
	WebElement email;
	
@FindBy(xpath="//input[@type='password']")
	
	WebElement password;


@FindBy(xpath="//button[@type='submit']")

WebElement Loginbutton;


@FindBy(xpath="//*[name()='path' and contains(@d,'M14 2.042c')]")

WebElement searchbtn;

	


public Signuppage() {

	driver.get(url);
	PageFactory.initElements(driver, this);	
}

public void Setusername(String username) {
	
	email.sendKeys(username);
	
}
public void Setpassword(String passwrd) {
	
	password.sendKeys(passwrd);
}
public void Login_with_fb() {
	
	email.sendKeys(pop.getProperty("username"));
	password.sendKeys(pop.getProperty("password"));
	Loginbutton.click();
}

public void login(String usrname,String password) {
	
	this.Setusername(usrname);
	this.Setpassword(password);
}

public void clickbuttonAndwait() throws InterruptedException {
	//Here used Webdriverwait
	Loginbutton.click();
	WebDriverWait wait=new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.elementToBeClickable(searchbtn));
}

}
