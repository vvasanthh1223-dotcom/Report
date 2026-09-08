package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Action;

public class LoginPage {

	private WebDriver driver;
	private WebDriverWait wait;
	public Action ac;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.ac = new Action(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user-name")
	private WebElement username;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "login-button")
	private WebElement loginButton;

	@FindBy(xpath = "//div[@class='error-message-container error']")
	private WebElement errorMessage;

	public void enterUsername(String usernameValue) {
		ac.clear(username);
		ac.type(username, usernameValue);
	}

	public void enterPassword(String passwordValue) {
		ac.clear(password);
		ac.type(password, passwordValue);
	}

	public void clickLogin() {
		ac.click(loginButton);
	}

	public boolean isErrorMessageDisplayed() {
		return errorMessage.isDisplayed();
	}

}
