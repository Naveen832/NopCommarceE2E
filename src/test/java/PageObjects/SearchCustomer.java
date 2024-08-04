 package PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomer {
public WebDriver driver;
	
	
      WaitHelper waithelper1= new WaitHelper(driver);
      
	public SearchCustomer(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//waithelper1 = new WaitHelper(driver);
	}
	@FindBy(how = How.ID,using = "SearchEmail")
	@CacheLookup WebElement searchmail;
	
	@FindBy(how = How.ID,using = "SearchFirstName")
	@CacheLookup WebElement searchfname;

	@FindBy(how = How.NAME,using = "SearchLastName")
	@CacheLookup WebElement searchlname;
	
	@FindBy(how = How.ID,using = "SearchMonthOfBirth")
	@CacheLookup WebElement searchMonthogbirth;
	
	@FindBy(how = How.ID,using = "SearchDayOfBirth")
	@CacheLookup WebElement searchDayofbirth;
	
	@FindBy(how = How.ID,using = "SearchCompany")
	@CacheLookup WebElement searchCompany;
	
	@FindBy(how = How.ID,using = "SearchIpAddress")
	@CacheLookup WebElement searchIpAddress;
	
	@FindBy(how = How.XPATH,using = "//input[@role='searchbox']")
	@CacheLookup WebElement txtcustomerroles;
	
	@FindBy(how = How.XPATH,using = "//li[contains(text(),'Administrators')]")
	@CacheLookup WebElement listAdminstrators;
	
	@FindBy(how = How.XPATH,using = "//li[contains(text(),'Registered')]")
	@CacheLookup WebElement listregistedt;
	
	@FindBy(how = How.XPATH,using = "//li[contains(text(),'Vendors')]")
	@CacheLookup WebElement listvendors;
	
	@FindBy(how = How.XPATH,using = "//li[contains(text(),'Forum Moderators')]")
	@CacheLookup WebElement listForumModerators;
	
	@FindBy(how = How.XPATH,using = "//li[contains(text(),'Guests')]")
	@CacheLookup WebElement listGuest;//button[@id='search-customers']
	
	@FindBy(how = How.ID,using = "search-customers")
	@CacheLookup WebElement SearchCustomers;
	
	//table[@id='customers-grid']
	
	@FindBy(how = How.XPATH,using = "//table[@id='customers-grid']")
	@CacheLookup WebElement table;
	
	@FindBy(how = How.XPATH,using = "//table[@id='customers-grid']//tbody//tr")
	@CacheLookup List<WebElement> tablerows;
	
	@FindBy(how = How.XPATH,using = "//table[@id='customers-grid']//tbody//tr//td")
	@CacheLookup List<WebElement> tablecoulms;
	
	public void setMail(String email) {
		waithelper1.WaifForElement(searchmail,Duration.ofSeconds(10));
		searchmail.sendKeys(email);
	}
	public void setfname(String fname) {
		waithelper1.WaifForElement(searchfname, Duration.ofSeconds(20));
		searchfname.sendKeys(fname);
	}
	public void setLname(String Lname) {
		waithelper1.WaifForElement(searchlname, Duration.ofSeconds(20));
		searchlname.sendKeys(Lname);
	}
	public void ClickSerch() {
		waithelper1.WaifForElement(searchlname, Duration.ofSeconds(20));
		SearchCustomers.click();
		
	}
	
	public int getrows() {
		return (tablerows.size());
	}
	public int getcolums() {
		return (tablecoulms.size());
	}
	
	public boolean searchCustomerByEmail(String email1) {
		
		waithelper1.WaifForElement(searchmail,Duration.ofSeconds(20));
		boolean flag = false;
		
			
		for(int i=1;i<=getrows();i++) {
			
			String emailId = driver.findElement(By.xpath("//table[@id='customers-grid']//tbody//tr["+i +"]//td[2]")).getText();
			System.out.println(emailId);
			
			if(emailId.equals(email1)) {
				System.out.println("we found a correct element");
				flag = true;
				break;
			}
			
		}
		
		return false;
	}
		public boolean searchCustomerByName(String name1){
			
			waithelper1.WaifForElement(searchmail,Duration.ofSeconds(20));
			boolean flag = false;
			
			for(int i=1;i<=getrows();i++) {
				String name = driver.findElement(By.xpath("//table[@id='customers-grid']//tbody//tr["+  i +"]//td[3]")).getText();
				String names[] = name.split(" ");
				
				if(names[0].equals("Victoria") && names[1].equals("Terces")) {
					System.out.println("value is found");
					flag = true;
					break;
				}
				}
				
			
			
			return false;
		
		
	}
	
	
	
	

	
	
}
