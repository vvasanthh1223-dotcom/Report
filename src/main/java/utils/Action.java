package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action {
	@SuppressWarnings("unused")
	public WebDriver driver;
	public WebDriverWait wait;

	public Action(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void click(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public void type(WebElement element, String text) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(text);
	}

	public void clear(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
	}

	public String getText(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}

	public boolean isDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isEnabled(WebElement element) {
		return element.isEnabled();
	}

	public boolean isSelected(WebElement element) {
		return element.isSelected();
	}
}
