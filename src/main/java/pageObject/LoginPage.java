package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
public WebDriver driver;
	
	By email = By.cssSelector("#email");
	By password = By.cssSelector("#password");
	By login = By.cssSelector("input[value='Login']");
	By forgotPassword = By.cssSelector("a[class='bodySmall form-footer']");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void ForgotPassowrd(WebDriver driver) {
		this.driver = driver;
	}


	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	
	public ForgotPassword forgotPassword() {
		driver.findElement(forgotPassword).click();
		return new ForgotPassword(driver);
	}
}
