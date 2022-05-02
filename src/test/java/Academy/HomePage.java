package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgotPassword;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

public class HomePage extends base{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	//DataProvider provides data to scripts
	
	@Test(dataProvider = "getData")
	
	//Passed arguments as well in methods
	public void basePagenavigation(String Username,String Password) throws IOException {
		//one is inheritance
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		//create object of class and invoke methods
		LandingPage lp = new LandingPage(driver);
		LoginPage lo = lp.getLogin(); 
		lo.getEmail().sendKeys(Username);
		lo.getPassword().sendKeys(Password);
		log.info("Login Checked");
		lo.getLogin().click();
		//forgot password 
		 lo.getEmail().click();
		ForgotPassword fp =lo.forgotPassword();
		fp.getEmail().sendKeys("xxx");
		fp.nextButton().click();
	}
	
	@DataProvider
	public Object[][] getData() {
		//row stands for howmany different datatypes test should run
		//column stands for howmany values per each test
		//In tutorial, Rahul have used Object[1][2] for two 2 rows and 3 columns. 
		//Object takes total counts ; Object[total row][total column], not index. 
		//Hence if you are taking 2 rows and 3 columns, it should be:
		//Object[][] data= new Object[2][3];
		//Change data username password to run test 
		Object[][] data = new Object[2][2];
		//0th row non restricted user
		data[0][0] = "sap@email.com";
		data[0][1] = "12554823";
		
		//restricted user
		data[1][0] = "abl@email.com";
		data[1][1] = "124589";
		
		return data;
	}
	
	
	
}
