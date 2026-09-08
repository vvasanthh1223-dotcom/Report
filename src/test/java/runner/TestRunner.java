package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
				features = "src/test/resources/features",
				glue     = { "stepdefinitions", "hooks" }, 
				plugin   = { "pretty", 
						     "summary", 
						     "html:target/CucumberReport.html",
						     "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" }
				)

public class TestRunner extends AbstractTestNGCucumberTests{
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
