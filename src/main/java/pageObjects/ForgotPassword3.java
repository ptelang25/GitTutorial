package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword3 {
	
	public WebDriver driver;
	
	public ForgotPassword3(WebDriver driver) {
		this.driver = driver;		
	}

	private By useremail = By.cssSelector("input[id='user_email']");
	private By submit = By.cssSelector("input[type='submit']");
	
	public WebElement getUserEmail() {
		return driver.findElement(useremail);	
	}
	
	public WebElement getSubmit() {
		return driver.findElement(submit);
	}
	
		
}
