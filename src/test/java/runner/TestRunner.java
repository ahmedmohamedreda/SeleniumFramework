package runner;


import io.cucumber.testng.CucumberOptions;
import tests.TestBase;


@CucumberOptions(features = "src/test/java/features"
,glue= {"steps"}
,plugin = {"pretty",
		"html:target/reports/cucumber-report.html",
		"json:target\\reports\\CucumberTestReport.json"},dryRun =true)
public class TestRunner extends TestBase
{

}
