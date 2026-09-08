package hooks;

import org.openqa.selenium.WebDriver;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;
import utils.Screenshot;

import org.testng.*;

public class Hooks {

	String url;
	String browser;
	private WebDriver driver;

	@Before
	public void setUp() {
		url = ConfigReader.getProperty("url");
		browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
				.getParameter("browser");
		
		System.out.println("Browser: " + browser);
		System.out.println("Url: " + url);

		DriverFactory.initBrowser(browser, "--disable-notifications", "--disable-popup-blocking",
				"--disable-save-password-bubble");
		driver = DriverFactory.getDriver();
		driver.get(url);
		System.out.println("Browser opened");
	}

	@AfterStep
	public void afterSteps(Scenario scenario) {
		if (!scenario.isFailed()) {
			Screenshot.takeScreenshot(driver, scenario, "Step Passed");
		}
	}

	@After(order = 0)
	public void tearDown(Scenario scenario) {

		if (scenario.isFailed()) {
			System.out.println("Scenario FAILED: " + scenario.getName());
			Screenshot.takeScreenshot(driver, scenario, "FAILED_" + scenario.getName());
		}

		DriverFactory.closeBrowser();
		System.out.println("Browser closed");
	}

}
