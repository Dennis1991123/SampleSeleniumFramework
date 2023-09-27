package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	 public WebDriver driver;
	public Properties prop;

	public WebDriver initializaDriver() throws IOException {

		String propath = System.getProperty("user.dir");

		FileInputStream fir = new FileInputStream(propath + "\\src\\main\\java\\resources\\data.properties");

		prop = new Properties();
		prop.load(fir);

		String browsrName = prop.getProperty("browser");

		if (browsrName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browsrName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browsrName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		return driver;

	}
	
	public void takeScreenShot(String testmethodname, WebDriver driver) throws IOException
	{
		File sourecfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFilepath = System.getProperty("user.dir")+"\\screenshot\\"+"testmethodname"+"png";
		FileUtils.copyFile(sourecfile, new File(destinationFilepath));
	
	}
	

	@AfterMethod
	public void closure() {
		driver.close();
	}

}
