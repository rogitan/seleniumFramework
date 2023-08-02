package chromeDevProtocols;

import static org.testng.Assert.assertFalse;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v114.emulation.Emulation;

public class MobileEmulatorTest {
	
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "\\workspace\\SeleniumFrameworkDesign\\driver\\114\\chromedriver.exe");

		
		// Use chromedriver since webdriver does not expose chrome dev tools
		ChromeDriver driver = new ChromeDriver();
//		WebDriver driver = new ChromeDriver();

		// Create object to access method from class "DevTools"
		DevTools devTools = driver.getDevTools();

		// always create session
		devTools.createSession();
		

		// after creating session, we can now communicate with CDP
		devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(),
				Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
				Optional.empty(), Optional.empty()));
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo");
		
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
//		driver.findElement(By.name("q")).sendKeys("rogi");
		Thread.sleep(3000);
		
		
		driver.findElement(By.linkText("Cart")).click();

	}
}
