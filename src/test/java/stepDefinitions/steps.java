package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import PageObjects.AddCustomersPage;
import PageObjects.LoginPage;
import PageObjects.SearchCustomer;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable;

public class steps extends BaseClass {

//	public WebDriver driver;
//	public LoginPage LP;
	
	
	//@Before(order=0)
	@Before("@P1")//it will executed only P1 if we mention the P1 tag in testrunner
	public void setUp() throws IOException {
		
		configPro = new Properties();
		//reading the data from config properties
		FileInputStream fs = new FileInputStream("config.properties");
		configPro.load(fs);

		String browser = configPro.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("Edge")) {
			
			driver = new EdgeDriver();
			
		}else if(browser.equalsIgnoreCase("IE")) {
			
			driver = new InternetExplorerDriver();
			
		}else if(browser.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
			
		}
		else 
		{
			 System.out.println("Unsupported browser: " + browser);
		}
		//Initiliaze the logger
		log = LogManager.getLogger(steps.class);
		//PropertyConfigurator.
		//driver = new ChromeDriver();
		log.info("*************** launching browser ****************");
		LP = new LoginPage(driver);
		log.info("SetUp1 executed");	
	}
	//@Before(order=1)
	
	
	@Before("@Sanity")
	public void setUp2() throws IOException {
		
		configPro = new Properties();
		//reading the data from config properties
		FileInputStream fs = new FileInputStream("config.properties");
		configPro.load(fs);

		String browser = configPro.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("Edge")) {
			
			driver = new EdgeDriver();
			
		}else if(browser.equalsIgnoreCase("IE")) {
			
			driver = new InternetExplorerDriver();
			
		}else if(browser.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
			
		}
		else 
		{
			 System.out.println("Unsupported browser: " + browser);
		}
		//Initiliaze the logger
		log = LogManager.getLogger(steps.class);
		//PropertyConfigurator.
		//driver = new ChromeDriver();
		log.info("*************** launching browser ****************");
		LP = new LoginPage(driver);
		log.info("SetUp1 executed");	
	}
	@Before("@Regression")
	public void setUp3() throws IOException {
		
		configPro = new Properties();
		//reading the data from config properties
		FileInputStream fs = new FileInputStream("config.properties");
		configPro.load(fs);

		String browser = configPro.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("Edge")) {
			
			driver = new EdgeDriver();
			
		}else if(browser.equalsIgnoreCase("IE")) {
			
			driver = new InternetExplorerDriver();
			
		}else if(browser.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
			
		}
		else 
		{
			 System.out.println("Unsupported browser: " + browser);
		}
		//Initiliaze the logger
		log = LogManager.getLogger(steps.class);
		//PropertyConfigurator.
		//driver = new ChromeDriver();
		log.info("*************** launching browser ****************");
		LP = new LoginPage(driver);
		log.info("SetUp1 executed");	
	}
	
	@Given("user launch the browser")
	public void user_launch_the_browser() {
		
		//Initiliaze the logger
		LP = new LoginPage(driver);
	
	}

	@When("user open url {string}")
	public void user_open_url(String string) {
		
		log.info("*************** launching url ****************");
		driver.get(string); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String actualtitle1 = driver.getTitle();
		System.out.println(actualtitle1);
	}

	@And("user enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String uname, String password) {
		
		log.info("*************** Providing login details ****************");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		LP.setUserName(uname);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		LP.setPassword(password);
	}

	@And("click on login button")
	public void click_on_login_button() {
		log.info("*************** Stareted login ****************");
		LP.clicklogin();
		System.out.println(driver.getTitle());
		
	    
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String title) {
		
		String actualtitle = driver.getTitle();
		System.out.println(actualtitle+"<------------------------->");
		
		
		if(actualtitle.equals(title)) {

			log.warn("Test Failed:Login feature - page title matched");
			Assert.assertTrue(true);//pass
			
			System.out.println("Website is worlking");
		}
		else 
		{
			Assert.assertTrue(false);//fail
			log.warn("Test Failed:Login feature - page title not matched");
			System.out.println("Website is not worlking");
		}
//		if(driver.getPageSource().contains("Login was unsuccessful")) {
//			driver.close();
//			Assert.assertTrue(false);
//		}else {
//			Assert.assertEquals(title, driver.getTitle());
//		}
	   
	}
	//Customer featur files
	

	@When("user click on logout button")
	public void user_click_on_logout_button() throws InterruptedException {
		log.info("*************** click on login button ****************");
		LP.clicklogout();
		Thread.sleep(5000);
	   
	}

	@Then("page title should be1 {string};")
	public void page_title_should_be1(String exptitle) {
//		boolean b =driver.findElement(By.xpath("//h1[normalize-space()='Admin area demo']")).isDisplayed();
//		Assert.assertEquals(b, true);
//        String actualtitle = driver.getTitle();
//        System.out.println(actualtitle+"<--------------------------->");
		String b =driver.findElement(By.xpath("//h1[normalize-space()='Admin area demo']")).getText();
	System.out.println("The Actual title is: "+b);
       // String actualtitle = driver.getTitle();
        Assert.assertEquals(b, exptitle);
        System.out.println("Execution failed because the string value is different");
        
        System.out.println("The Expected String is: "+exptitle);
       // System.out.println(actualtitle+"<--------------------------->");
		
		
        //steps a other
//        if(driver.getPageSource().contains("Login was unsuccessful.")) {
//        	driver.close();
//        	Assert.assertTrue(false);
//        }else {
//        	Assert.assertEquals(title, driver.getTitle());
//        }
//        Thread.sleep(2000);
//		if(actualtitle.equals(exptitle)) {
//
//			Assert.assertTrue(true);//pass
//			System.out.println("Website is worlking");
//		}
//		else 
//		{
//			Assert.assertTrue(false);//fail
//			System.out.println("Website is not worlking");
//		}
//		
	}
	
	
	//Customer feature files
	@Then("user can view Dashboard")
	public void user_can_view_dashboard() {
		Addcust = new AddCustomersPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", Addcust.gettitlepage());
		System.out.println("Page title is same");
	   
	}

	@When("user click on the customers menu")
	public void user_click_on_the_customers_menu() {
		Addcust.clickonCustomerMenu();
	   
	}

	@When("click on customers menu item")
	public void click_on_customers_menu_item() {
		Addcust.clickonCustomermainmenu();
	   
	}

	@When("click on add new button")
	public void click_on_add_new_button() {
		Addcust.clickonNew();
	   
	}

	@Then("user can view add new customer page")
	public void user_can_view_add_new_customer_page() {
	    Assert.assertEquals("Add a new customer / nopCommerce administration", Addcust.gettitlepage());
	    System.out.println("page title should be: "+Addcust.gettitlepage());
	}

	@When("user enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		String email = randomString()+"@gmail.com";
		Addcust.enterMail(email);
		Addcust.enterPassword("test123");
		Addcust.enterFirstname("naveen kuamr");
		Addcust.enterLastname("Viswanadham");
		Addcust.setgender("Male");
		//Addcust.setCustomoerRoles("Guest");
		Addcust.serManagerOvendor1("Vendor 1");
		Addcust.setDob("07/08/1998");
		Addcust.setCompanyname("Naveen Softwares");
		Addcust.setAdmnin("this is only for testing purpose");
	
		
		
	   
	}

	@When("click on save button")
	public void click_on_save_button() {
		Addcust.savtbtn();
	}

	@Then("user can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
	 //  Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']//button")).getText().contains("The new customer had been added successfully. "));
		
		String bodytag = driver.findElement(By.tagName("Body")).getText();
		if(bodytag.contains(msg)) {
			Assert.assertTrue(true);
			System.out.println("test is passed succesfully");
		}else
		{
			Assert.assertTrue(false);
			System.out.println("test is faield");
		}
	}
	
	///////////////////////steps for searching a customer using emailId/////////////////////////////////////
	
	
	
	@And("Enter customer Email")
	public void enter_customer_email() {
		 SearchCust = new SearchCustomer(driver);
		 SearchCust.setfname("Brenda");
		 SearchCust.setMail("brenda_lindgren@nopCommerce.com");
	}

	@When("click on search button")
	public void click_on_search_button() throws Exception {
		SearchCust.ClickSerch();
//		Thread.sleep(3000);
		
	    
	}

	@Then("user should found emaill in the search table")
	public void user_should_found_email_in_the_search_table() {
		//Another way to find the data
//	   boolean status = SearchCust.searchCustomerByEmail("brenda_lindgren@nopCommerce.com");
//	   Assert.assertEquals(true, status);
//		System.out.println("we found the email in the availble customser");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		if(SearchCust.searchCustomerByEmail("brenda_lindgren@nopCommerce.com") == true) {
			
			Assert.assertTrue(true);
			System.out.println("we found the email in the availble customser");
			
		}else {
			System.out.println("we not found the email in the availble customser");
		}
		
		
	}
	
	
	/////////////////////steps for serching a customer using first name and kast name ///////////////////
	
	@And("Enter customer firstname")
	public void enter_customer_firstname() {
		 SearchCust = new SearchCustomer(driver);
		SearchCust.setfname("Victoria");
	  
	}
	@And("Enter customer lastname")
	public void enter_customer_lastname() {
		SearchCust.setLname("Terces");
		
	}
	
	@Then("user should found Firstname in the search table")
	public void user_should_found_firstname_in_the_search_table() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		if(SearchCust.searchCustomerByName("Victoria Terces") == true) {
			Assert.assertTrue(true);
			System.out.println("we found the firstlastname in the availble customser");
		}
		else {
			System.out.println("we found not firstlastname email in the availble customser");
		}
	}
	@And("close the browser")
	public void close_the_browser() {
		log.info("*************** close the browser ****************");
		//driver.close();
	    
	}
	 @After()
	 public void tearDown(Scenario sc){
		 System.out.println("Tear down method executed");
		 if(sc.isFailed()==true) {
			 String filepath = "C:\\Users\\NVISWANA\\eclipse-workspace1\\NopCommerace\\Screenshorts\\test3.png";
			 TakesScreenshot ts = ((TakesScreenshot)driver);
			 
			 File srcfile = ts.getScreenshotAs(OutputType.FILE);
			 
			 File destfile = new File(filepath);
			 
			 try {
				FileUtils.copyFile(srcfile, destfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			 
		 }
		 
		 driver.quit();
	 }
	/* @After(order=1)
	 public void tearDown2() {
		 System.out.println("Tear down method executed2");
		 
		 driver.quit();
	 }*/
	/* @BeforeStep 
	 public void beforeStepMethodDemo() {
		 System.out.println("this is before step");
	 }
	 @AfterStep 
	 public void afterStepMethodDemo() {
		 System.out.println("this is after step");
	 }*/
}
