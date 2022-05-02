package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.base;

public class ValidateTitle extends base{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
	log.info("Driver is initiated");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
	}
	
	
	@Test
	//Passed arguments as well in methods
	public void validateAppTitle() throws IOException {
		//one is inheritance
		//create object of class and invoke methods
		LandingPage lp = new LandingPage(driver);
		//Compare the text from the browser with actual text - error..
		Assert.assertEquals(lp.getTitle().getText(),"Featured Courses");	
		log.info("Successfully validated Text message");
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	

}
