package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/SearchAndFilter.feature",
		glue = "stepDefinition",
		plugin = {"pretty","html:Reports/HTMLReports.html",
				  "json:Reports/json_report.json",
				  "junit:Reports/junit_report.xml"
				  } 
		)
public class TestRunnerSearch {

}
