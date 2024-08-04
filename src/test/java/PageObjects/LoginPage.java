package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver ldriver;
	
	public LoginPage(WebDriver driver) {
		 ldriver=driver;
		 PageFactory.initElements(driver, this);
		 
	}
	
	@FindBy(id="Email") WebElement txtemail;
	@FindBy(id="Password") WebElement txtpassword;
	@FindBy(xpath="//button[normalize-space()='Log in']") WebElement lnklogin;
	@FindBy(xpath ="//a[normalize-space()='Logout']") WebElement lnklogout;
	@FindBy(xpath="//h1[normalize-space()='Admin area demo']") WebElement title;
	
	
	
	public void setUserName(String uname) {
		txtemail.clear();
		txtemail.sendKeys(uname);
	}
	public void setPassword(String pname) {
		txtpassword.clear();
		txtpassword.sendKeys(pname);
	}
	public void clicklogin() {
		lnklogin.click();
	}
	public void clicklogout() {
		lnklogout.click();
	}
	public void titledemo() {
		title.isDisplayed();
	}
	
	

}
