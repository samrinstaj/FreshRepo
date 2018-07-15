package generic_component;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public WebDriver driver;
	
	@BeforeMethod
	public void launchApplication() throws IOException{
		 //System.setProperty("webdriver.chrome.driver", "E:\\selenium\\jars\\chromedriver.exe");
		UtilityClass uc = new UtilityClass();
		
		 driver = new FirefoxDriver();
		 driver.get(uc.reading_properties("url"));
		 driver.manage().window().maximize();
	}
}
