package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import SeleniumFrameworkDesign.abstractComponent.AbstractComponent;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import page.CartPage;
import page.CheckOutPage;
import page.LoginPage;
import page.ProductCatalogPage;

public class BaseTest {

	// Initial driver = null
	public WebDriver driver;

	LoginPage loginPage;
	ProductCatalogPage prodCatalogPg;
	CartPage cartPg;
	CheckOutPage checkoutPg;
	AbstractComponent abstractComponent;

	public WebDriver initializeWebDriver() throws IOException {

		// Create global property
		Properties properties = new Properties();
		FileInputStream finputStream = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//resources//GlobalData.properties");
		properties.load(finputStream);
		
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") :properties.getProperty("browser");

		// after block of code driver will get life from the else if condition
		if (browserName.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440, 900));

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.getProperty("webdriver.gecko.driver", "E:\\driver");
			driver = new FirefoxDriver();
			
		} else if (browserName.equalsIgnoreCase("internetexplorer")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;

	}

	public List<HashMap<String, String>> getJsonDatatoMap(String fileName) throws IOException {

		// read json to string
		String JsonContent = FileUtils.readFileToString(
				new File(System.getProperty("user.dir") + "//src//test//java//data//" + fileName),
				StandardCharsets.UTF_8);

		// convert string to hashMap
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(JsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return data;

	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = (System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;

	}

	@BeforeMethod(alwaysRun = true)
	public WebDriver launchApplication() throws IOException {
		driver = initializeWebDriver();
		abstractComponent = new AbstractComponent(driver);
		loginPage = new LoginPage(driver);
		prodCatalogPg = new ProductCatalogPage(driver);
		cartPg = new CartPage(driver);
		checkoutPg = new CheckOutPage(driver);
		driver.get("https://rahulshettyacademy.com/client");
		return driver;
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}

}
