package academy3;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage3;
import resources.Base3;

public class NavbarValidation3 extends Base3 {

	public static Logger log = LogManager.getLogger(NavbarValidation3.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void initializeTest() throws IOException {
		driver = initializeDriver();
		log.debug("Opening website: "+prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
		LandingPage3 ln = new LandingPage3(driver);
		ln.closePopup().click();		
	}
	
	@Test
	public void validateNavbar() {
		LandingPage3 ln = new LandingPage3(driver);
		Assert.assertTrue(ln.navBar().isDisplayed());
		//System.out.println("NavigationBar on landing page verified successfully");
		log.info("NavigationBar on landing page verified successfully");
	}
	
	@AfterTest
	public void closeBrowser() {
		log.debug("Closing the browser..");
		driver.close();
		log.info("Browser closed successfully");
	}
	
}
