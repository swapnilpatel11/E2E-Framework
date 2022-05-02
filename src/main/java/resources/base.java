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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		//creating script for browser object to execute instead of writing driver object in every class 
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Swapn\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			//Execute in chrome driver
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Swapn\\Downloads\\chromedriver_win32\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Swapn\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		else if(browserName.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\Swapn\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			 driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
		
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException {
		//we have to provide life to this driver as well 

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}
}
