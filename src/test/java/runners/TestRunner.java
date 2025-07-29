package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = {"stepdefinitions", "hooks"},
	    tags = "@e2e",
	    plugin = {
	        "pretty",
	        "html:target/cucumber-reports/Cucumber.html",  
            "json:target/cucumber-reports/Cucumber.json",  
            "junit:target/cucumber-reports/Cucumber.xml"   
	    },
	    monochrome = true
	)
	public class TestRunner extends AbstractTestNGCucumberTests {
	}