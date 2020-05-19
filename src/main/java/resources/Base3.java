package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base3 {
	
	public static Logger log = LogManager.getLogger(Base3.class.getName());
	public WebDriver driver;
	public Properties prop = new Properties();
	
	public WebDriver initializeDriver() throws IOException {
	
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\java\\resources\\parameters.properties");
	//FileInputStream fis = new FileInputStream("C:\\Users\\Akshay\\eclipse-workspace\\E2E3\\src\\main\\java\\resources\\parameters.properties");
	prop.load(fis);
	//For mvn test -Dbrowser=Chrome
	String browser = System.getProperty("browser");
	//String browser = prop.getProperty("browser");
	log.info("Browser is: "+ browser);
		
	if (browser.contains("Chrome")){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();		
		if (browser.contains("headless")) {
			options.addArguments("headless");
		}
		driver = new ChromeDriver(options);		
	}	
	/*if (browser.equalsIgnoreCase("Chrome")){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C:\\Workspace\\chromedriver.exe");
		driver = new ChromeDriver();
	}	*/
	if (browser.equalsIgnoreCase("Firefox")){
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();		
	}
	if(browser.equalsIgnoreCase("IE")) {
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\resources\\iedriverserver.exe");
		driver = new InternetExplorerDriver();		
	}
		
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	
	}
	
	public String getScreenshot (String failedMethodName, WebDriver driver) throws IOException {
		// TODO Auto-generated method stub
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+failedMethodName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
	
}
