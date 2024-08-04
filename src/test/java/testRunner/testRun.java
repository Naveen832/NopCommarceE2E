package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		//features= ".//Features/", it is used for run all the feature files in the features
		  //it is used for the particular feature will be executed
		//features= {".//Features/Customers.feature",".//Features/Loginfunction.feature"},
		features= ".//Features/Loginfunction.feature",
		glue="stepDefinitions",
		dryRun = false,
		monochrome=true,
		plugin= {"pretty","html:target/cucumber-reports/reports1.html",
				          "junit:target/cucumber-reports/report.xml",
				          "json:target/cucumber-reports/reports.json",
				          "html:test-outputs"},
		tags = "@Regression"
		//{"@P1,@P2"}
		//target/cucumber-reports/reports1.html
		
		)
public class testRun {
	
	
	
	
 }
