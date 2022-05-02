package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	By signin = By.cssSelector("a[href*='sign_in']");
	By title = By.cssSelector("div[class='pull-left'] h2");
	By mentorship = By.cssSelector("div[class='header-upper'] li:nth-child(5) a:nth-child(1)");
	
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}


	public LoginPage getLogin()
	{
		driver.findElement(signin).click();
		return new LoginPage(driver);
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getMentorship() {
		return driver.findElement(mentorship);
	}
}
