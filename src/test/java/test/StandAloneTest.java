package test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import page.LoginPage;

public class StandAloneTest {

	static String username = "rogi.g.tan@gmail.com";
	static String password = "P@ssword1";
	static String productName = "zara coat 3";

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		

		
//		loginpusernameField.sendKeys(username);
//		passwordField.sendKeys(password);
//		loginButton.click();
		
		WebElement loginSuccessToast = driver.findElement(By.cssSelector(".toast-success"));
		
		wait.until(ExpectedConditions.visibilityOf(loginSuccessToast));
		
		
		List<WebElement> productList = driver.findElements(By.cssSelector(".mb-3"));

		WebElement prodSelect = productList.stream()
				.filter(product -> product.findElement(By.tagName("b")).getText().equalsIgnoreCase(productName))
				.findFirst().orElse(null);

		prodSelect.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		WebElement loading = driver.findElement(By.cssSelector(".ngx-spinner-overlay"));

		

		wait.until(ExpectedConditions.visibilityOf(loading));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-tns-c4-5")));

		WebElement cartButton = driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']"));
//		cartButton.click();

		
		List<WebElement> prodAddedToCart = driver.findElements(By.cssSelector(".cartSection h3"));
		
		boolean flag = prodAddedToCart.stream().anyMatch(prod->prod.getText().equalsIgnoreCase(productName));
		
		Assert.assertTrue(flag);
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		Actions a = new Actions(driver);
		
		a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "Phili").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results ")));
		
		driver.findElement(By.xpath("//span[contains(text(),'Philippines')]")).click();
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String confirmationMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		Assert.assertTrue(confirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	}

}
