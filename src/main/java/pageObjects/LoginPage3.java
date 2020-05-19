package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage3 {
	
	public WebDriver driver;
	//private static Logger log = LogManager.getLogger(LoginPage3.class.getName());


	public LoginPage3(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	private @FindBy(css="input#user_email")
	WebElement username;
	private @FindBy(css="input#user_password")
	WebElement password;
	private @FindBy(xpath="//input[@name='commit']")
	WebElement signin;
	private @FindBy(css="a[href*='password/new']")
	WebElement forgotpwdlink;
	
		
	public WebElement EnterUserName() {
		//log.debug("Trying to identify username..");
	return username;
	}
	public WebElement EnterPwd() {
		//log.debug("Trying to identify password..");
	return password;
	}
	public WebElement SignIn() {
		//log.debug("Trying to identify signin button..");
	return signin;
	}	
	public ForgotPassword3 getForgotPwdLink() {
	 forgotpwdlink.click();
	 ForgotPassword3 fp = new ForgotPassword3(driver);
	 return fp;
	 
	}

}
