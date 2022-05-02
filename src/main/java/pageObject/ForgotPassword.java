package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPassword {
	public WebDriver driver;
	
	By email = By.cssSelector("#email");
	By nextButton = By.xpath("//input[@name='commit']");
	
	public WebElement getEmail()
	{
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));

		w.until(ExpectedConditions.visibilityOfElementLocated(email));
		return driver.findElement(email);
	}
	
	public ForgotPassword(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement nextButton() {
		return driver.findElement(nextButton);
	}

}
