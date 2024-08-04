package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AddCustomersPage {
	
	public WebDriver driver;
	
	
	public AddCustomersPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	By lnkCustomers_menu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By lnkCustomers_menuItem = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	By btnaddnew = By.xpath("//a[normalize-space()='Add new']");
	By txtEmail = By.xpath("//input[@id='Email']");
	By txtpwd = By.xpath("//input[@id='Password']");
	By txtfirstname = By.xpath("//input[@id='FirstName']");
	By txtlastname = By.xpath("//input[@id='LastName']");
	
	
	By txtcustomerRoles = By.xpath("(//span[@class='select2-selection select2-selection--multiple']//input[@role='searchbox'])[2]");
	By Listadiministrator1 = By.xpath("//li[contains(text(),'Administrators')]");
	By ListForumModerators2 = By.xpath("//li[@id='select2-SelectedCustomerRoleIds-result-j6ti-2']");
	By ListRegistered3 = By.xpath("//li[@id='select2-SelectedCustomerRoleIds-result-9on2-3']");
	By ListGuests4 = By.xpath("li[contains(text(),'Guests']");
	By ListVendrs5 = By.xpath("//li[@id='select2-SelectedCustomerRoleIds-result-5opt-5']");
	
	By drpdwnmgrofVendor = By.xpath("//select[@id='VendorId']");
	
	By genderMale = By.id("Gender_Male");
	By genderFemale = By.id("Gender_Female");
	
	By txtDob = By.xpath("//input[@id='DateOfBirth']");
	
	By txtComapany = By.xpath("//input[@id='Company']");
	
	By txtadminComment = By.xpath("//textarea[@id='AdminComment']");
	
	By btnsave = By.xpath("//button[@name='save']");
	
	
	//Actions
	
	public String gettitlepage() {
		return driver.getTitle();
	}
	public void clickonCustomerMenu() {
		driver.findElement(lnkCustomers_menu).click();
	
	}
	
	public void clickonCustomermainmenu() {
		driver.findElement(lnkCustomers_menuItem).click();	
		
	}
    public void clickonNew() {
    	driver.findElement(btnaddnew).click();
    }
    public void enterMail(String email) {
    	driver.findElement(txtEmail).sendKeys(email);
    }
    public void enterPassword(String password) {
    	driver.findElement(txtpwd).sendKeys(password);
    }
    public void enterFirstname(String fname) {
    	driver.findElement(txtfirstname).sendKeys(fname);
    }
    public void enterLastname(String lname) {
    	driver.findElement(txtlastname).sendKeys(lname);
    }
    public void setCustomoerRoles(String role) throws InterruptedException {
    	if(!role.equals("Vendors")) {
    		driver.findElement(By.xpath("//*[@id='select2-SelectedCustomerRoleIds-results']/li"));
    		//*[@id='select2-SelectedCustomerRoleIds-results']/li
    	}
    	driver.findElement(txtcustomerRoles).click();
    	WebElement ListItem;
    	Thread.sleep(3000);
    	
    	if(role.equals("Administrators")) {
    		ListItem = driver.findElement(Listadiministrator1);
    		
    	}
    	else if(role.equals("Guest")) {
    		ListItem = driver.findElement(ListGuests4);
    	}
    	else if(role.equals("ListRegistered3")) {
    		ListItem = driver.findElement(ListRegistered3);
    	}
    	else {
    		ListItem = driver.findElement(ListVendrs5);
    	}
    	ListItem.clear();
    	//if click method is not working we will use javascript exector
    	
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();",ListItem);
    	
    }
    public void serManagerOvendor1(String value) {
    	Select drop = new Select(driver.findElement(drpdwnmgrofVendor));
    		drop.selectByVisibleText(value);
    	}
    
    
    public void setgender(String gender) {
    	if(gender.equals("Male")) {
    		driver.findElement(genderMale).click();
    	}
    	else if(gender.equals("Female")) {
    		driver.findElement(genderFemale).click();
    	}
    	else {
    		driver.findElement(genderMale).click();//default
    	}
}
    public void setDob(String dob) {
    	driver.findElement(txtDob).sendKeys(dob);
    }
    public void setCompanyname(String cname) {
    	driver.findElement(txtComapany).sendKeys(cname);
    }
    public void setAdmnin(String admin) {
    	driver.findElement(txtadminComment).sendKeys(admin);
    }
    public void savtbtn() {
    	driver.findElement(btnsave).click();
    }
    
	
	

}
