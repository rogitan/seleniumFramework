package chromeDevProtocols;

import java.util.HashMap;
import java.util.Map;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class SetGeoLocation {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\114\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devTool = driver.getDevTools();
		
		devTool.createSession();
		
		Map<String, Object> coordinates = new HashMap<String, Object>();
		coordinates.put("latitude", 40);
		coordinates.put("longitude", 3);
		coordinates.put("accuracy", 1);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Netflix",Keys.ENTER);
		Thread.sleep(3000);
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		Thread.sleep(3000);
		String title = driver.findElement(By.cssSelector(".text-title")).getText();
		System.out.println("Title is "+ title);
		
		
	}

}
