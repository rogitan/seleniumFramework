package test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class seleniumGridTest {

	
	@Test
	public void SampleTest() throws MalformedURLException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("chrome");
		
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.10:4444"), caps);
		driver.get("https://rahulshettyacademy.com/");
//		driver.findElement(By.name("q")).sendKeys("Rogi");
		System.out.println(driver.getTitle());
		driver.close();
		
	}
	
}
