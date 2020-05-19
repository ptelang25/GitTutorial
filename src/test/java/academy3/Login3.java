package academy3;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage3;
import pageObjects.LoginPage3;
import resources.Base3;

public class Login3 extends Base3 {
	
	public static Logger log = LogManager.getLogger(Login3.class.getName());
	public WebDriver driver;
	//LandingPage2 ln = new LandingPage2(driver);
	
	@BeforeTest
	public void initializeTest() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		//System.out.println("Opening website: "+prop.getProperty("url"));
		log.info("Opening website: "+prop.getProperty("url"));
		driver.manage().window().maximize();
		LandingPage3 ln = new LandingPage3(driver);
		ln.closePopup().click();		
	}
	
	@Test(dataProvider="getData")
	public void validateLogin(String username, String password) {
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		LandingPage3 ln = new LandingPage3(driver);
		LoginPage3 lg = ln.logIn();
		//System.out.println("Navigating to Login page..");
		log.debug("Navigating to Login page..");
		//LoginPage3 lg = new LoginPage3(driver);	//no more needed
		lg.EnterUserName().sendKeys(username);
		lg.EnterPwd().sendKeys(password);
		lg.SignIn().click();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "someuser@abc.com";
		data[0][1] = "123456";
		data[1][0] = "anotheruser@xyz.com";
		data[1][1] = "456789";
		
		return data;		
	}
	
	@AfterTest
	public void closeBrowser() {
		log.debug("Closing the browser..");
		driver.close();
		log.info("Browser closed successfully");
	}
}
