package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;

public class Screenshot {
	
	public static void takeScreenshot(WebDriver driver, Scenario scenario, String stepName) {

		try {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			String screenshotName = "Step Passed -" + stepName;
			scenario.attach(screenshot, "image/png", screenshotName);
			//Allure.addAttachment(screenshotName, stepName, new ByteArrayInputStream(screenshot), screenshotName);
			System.out.println("Screenshot attached to Cucumber report: " + screenshotName);
		} catch (Exception e) {
			System.out.println("Screenshot failed: " + e.getMessage());
		}
	}

}
