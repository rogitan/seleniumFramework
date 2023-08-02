package test;

import static org.testng.Assert.assertTrue;

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
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import page.CartPage;
import page.CheckOutPage;
import page.LoginPage;
import page.ProductCatalogPage;

public class ErrorValidations extends BaseTest{

	static String username = "rogi.g.tan@gmail.com";
	static String password = "P@ssword1123";
	static String productName = "zara coat 3";
	static String country = "Philippines";
	
	
	@Test
	public void orderAndSubmit() {
		loginPage.goTo("https://rahulshettyacademy.com/client");
		loginPage.loginToApplication(username, password);
		
	}

}
