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

public class TitleValidation3 extends Base3 {
	
	public static Logger log = LogManager.getLogger(TitleValidation3.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void initializeTest() throws IOException {
		driver = initializeDriver();
		log.debug("Opening website: "+prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();		
	}
	
	@Test
	public void validateTitle() {
		LandingPage3 ln = new LandingPage3(driver);
		ln.closePopup().click();
		Assert.assertEquals(ln.getTitle().getText(), "2FEATURED COURSES");
		//System.out.println("Landing page header verified successfully");
		log.info("Landing page header verified successfully");
	}
	
	@AfterTest
	public void closeBrowser() {
		//System.out.println("Closing the browser..");
		log.debug("Closing the browser..");
		driver.close();
		log.info("Browser closed successfully");
	}
}
