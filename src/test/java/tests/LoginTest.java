package tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;
import com.github.javafaker.Faker;

import pageobject.HomePage;
import pageobject.LandingPage;
import pageobject.LoginPage;
import pageobject.Register;
import resources.Base;

public class LoginTest extends Base {

	@Test
	public void Login() throws IOException, InterruptedException {

	WebDriver driver = initializaDriver();
		LandingPage lpage;
		driver.get(prop.getProperty("url"));

		lpage = new LandingPage(driver);
		lpage.myAccountDropDown().click();
		Thread.sleep(3000);
		lpage.loginButton().click();

		Thread.sleep(3000);
		// WebDriverWait waitdr = new WebDriverWait(driver, Duration.ofSeconds(3));
		LoginPage login = new LoginPage(driver);

		login.email().sendKeys(prop.getProperty("username"));
		login.password().sendKeys(prop.getProperty("password"));
		login.loginbutton().click();
		Thread.sleep(3000);

		HomePage hpage = new HomePage(driver);

		org.testng.Assert.assertTrue(hpage.homelink().isDisplayed());
		//org.testng.Assert.assertTrue(false);

	}

}
