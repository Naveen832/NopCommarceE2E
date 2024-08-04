package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObjects.AddCustomersPage;
import PageObjects.LoginPage;
import PageObjects.SearchCustomer;

public class BaseClass {
	
	
	public WebDriver driver;
	public LoginPage LP;
	public AddCustomersPage Addcust;
	public SearchCustomer SearchCust;
	public SearchCustomer SearchCust1;
	public static Logger log;
	public Properties configPro;

	
	public static String randomString() {
		String genratestring = RandomStringUtils.randomAlphabetic(6);
		return genratestring;
	}
}
