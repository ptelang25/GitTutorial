package pageObjects;

import org.apache.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage3 {

	public WebDriver driver;
	//private static Logger log = (Logger) LogManager.getLogger(LandingPage3.class.getName());
	
	public LandingPage3(WebDriver driver) {
		this.driver = driver;		
	}
	
	private By popupnothanks = By.xpath("//button[contains(text(),'NO THANKS')]");
	private By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	private By login = By.xpath("//span[contains(text(),'Login')]");
	private By navbar = By.cssSelector("ul.nav.navbar-nav.navbar-right");
	
	public WebElement closePopup() {
		//log.debug("Trying to identify popupnothanks..");
		return driver.findElement(popupnothanks);
	}
	
	public WebElement getTitle() {
		//log.debug("Trying to identify title..");
		return driver.findElement(title);
	}
	
	public LoginPage3 logIn() {
		//log.debug("Trying to identify login..");
		driver.findElement(login).click();
		LoginPage3 lg = new LoginPage3(driver);
		return lg;
	}
			
	public WebElement navBar() {
		//log.debug("Trying to identify navbar..");
		return driver.findElement(navbar);
	}
}
