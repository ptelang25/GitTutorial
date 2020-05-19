package academy3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword3;
import pageObjects.LandingPage3;
import pageObjects.LoginPage3;
import resources.Base3;

public class ResetPasswordValidation extends Base3 {
	
	public WebDriver driver;
	
	
	@BeforeTest
	public void initializeTest() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		log.info("Opening website: "+prop.getProperty("url"));
		LandingPage3 ln = new LandingPage3(driver);
		ln.closePopup().click();
	}
	
	@Test
	public void verifyResetPassword() throws InterruptedException {
		LandingPage3 ln = new LandingPage3(driver);
		LoginPage3 lg = ln.logIn();
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ForgotPassword3 fp = lg.getForgotPwdLink();
		Thread.sleep(3000);
		fp.getUserEmail().sendKeys("someone@abc.com");
		fp.getSubmit().click();	
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void closeBrowser() {
		log.debug("Closing the browser..");
		driver.close();
		log.info("Browser closed successfully");
	}
	
}
