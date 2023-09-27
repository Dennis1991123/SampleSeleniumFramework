package pageobject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='My Account']")
	WebElement myAccountDropDown;

	@FindBy(linkText = "Login")
	WebElement loginbutton;

	public WebElement myAccountDropDown() {
		return myAccountDropDown;
	}

	public WebElement loginButton() {
		return loginbutton;
	}

}
