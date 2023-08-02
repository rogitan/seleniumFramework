package browserStack;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleTest {

	@Test
	public void simpleTest() throws MalformedURLException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.get
		WebDriver driver = new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"), cap);		
		driver.get("https://www.google.com/");
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("google"));
	}
	
}
