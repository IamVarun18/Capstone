package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {
				"src/test/resources/features/01_UserAuth.feature",
				"src/test/resources/features/02_SearchAndFilter.feature",
				"src/test/resources/features/03_AddToCartAndCheckout.feature",
				"src/test/resources/features/04_OrderManagement.feature"
		},
		glue = "stepDefinition",
		plugin = {"pretty","html:Reports/HTMLReports.html",
				  "json:Reports/json_report.json",
				  "junit:Reports/junit_report.xml"
				  } 
		)
public class TestRunner {

}
