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

public class ValidateNavigationBar extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	//Passed arguments as well in methods
	public void basePagenavigation() throws IOException {
		
		//one is inheritance
		//create object of class and invoke methods
		LandingPage lp = new LandingPage(driver);
		//mentorship bar is displayed or not
		Assert.assertTrue(lp.getMentorship().isDisplayed());  
		log.info("Navigation Bar is Displayed");
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
}
