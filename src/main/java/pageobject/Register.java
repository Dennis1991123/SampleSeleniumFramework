package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register {

	WebDriver driver;

	public Register(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Register")
	WebElement registerbutton;

	@FindBy(id = "input-firstname")
	WebElement firstname;

	@FindBy(id = "input-lastname")
	WebElement lastname;

	@FindBy(id = "input-email")
	WebElement email;

	@FindBy(id = "input-telephone")
	WebElement telephone;

	@FindBy(id = "input-password")
	WebElement password;

	@FindBy(id = "input-confirm")
	WebElement confirm;

	@FindBy(linkText = "Privacy Policy")
	WebElement PrivacyPolicy;

	@FindBy(css = "input[value='Continue']")
	WebElement Continue;

	@FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
	WebElement registrationhome;
	
	@FindBy(css="input[name$='agree']")
	WebElement checkbox;
	
	@FindBy(xpath ="//button[@class='close'][@type='button']")
	WebElement closemodal;


	public WebElement registerbutton() {
		return registerbutton;
	}

	public WebElement firstname() {
		return firstname;
	}

	public WebElement lastname() {
		return lastname;
	}

	public WebElement email() {
		return email;
	}

	public WebElement telephone() {
		return telephone;
	}

	public WebElement password() {
		return password;
	}

	public WebElement confirm() {
		return confirm;
	}

	public WebElement PrivacyPolicy() {
		return PrivacyPolicy;
	}

	public WebElement Continue() {
		return Continue;
	}

	public WebElement registrationhome() {
		return registrationhome;
	}
	
	public WebElement closemodal()
	{
		return closemodal;
	}

	public WebElement checkbox()
	{
		return checkbox;
	}
}
