package tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pageobject.LandingPage;
import pageobject.Register;
import resources.Base;

public class RegistrationTest extends Base {

	@Test
	public void registration() throws IOException, InterruptedException {
		LandingPage lpage;
		WebDriver driver = initializaDriver();
		driver.get(prop.getProperty("url"));
		Faker faker = new Faker();
		String firstname = faker.name().firstName();
		String lastname = faker.name().lastName();
		String email = faker.internet().emailAddress();
		String phone = "9644152356";
		String password = "sasi@12334";
		String confirmpassword = "sasi@12334";
		Register register = new Register(driver);
		lpage = new LandingPage(driver);
		lpage.myAccountDropDown().click();
		register.registerbutton().click();
		Thread.sleep(3000);
		register.firstname().sendKeys(firstname);
		register.lastname().sendKeys(lastname);
		register.email().sendKeys(email);
		register.telephone().sendKeys(phone);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("window.scrollBy(0, -350)");
		register.password().sendKeys(password);
		register.confirm().sendKeys(confirmpassword);
		register.PrivacyPolicy().click();
		
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		 * wait.until(ExpectedConditions.visibilityOfElementLocated((By)
		 * register.closemodal()));
		 */
		 
		//Thread.sleep(3000);
		register.closemodal().click();
		register.checkbox().click();
		
		register.Continue().click();
	}

}
