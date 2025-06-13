package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/CRUD_vscool.feature", 
		glue = "stepdefinitions", 
		plugin = { "pretty", "html:Reports/HTMLReports.html", 
							 "json:Reports/JSONReports/json_report.json",
							 "junit:Reports/JUnitReports/junit_report.xml" }
		)
public class TestRunner {

}
