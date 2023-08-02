package test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class seleniumGridTest2 {

	
	@Test
	public void SampleTest() throws MalformedURLException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(CapabilityType.BROWSER_NAME, "firefox");
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.10:4444"), caps);
//		WebDriver driver = new FirefoxDriver();
		
		
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Rogi");
		System.out.println(driver.getTitle());
		driver.close();
		
	}
	
}
