package cucumber.stepDefinition;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import SeleniumFrameworkDesign.abstractComponent.AbstractComponent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.CartPage;
import page.CheckOutPage;
import page.LoginPage;
import page.ProductCatalogPage;
import test.BaseTest;

public class StepDefinitionImplementation {

	
	WebDriver driver = new ChromeDriver();
	LoginPage loginPage = new LoginPage(driver);
	ProductCatalogPage prodCatalogPg = new ProductCatalogPage(driver);
	CartPage cartPg = new CartPage(driver);
	CheckOutPage checkoutPg = new CheckOutPage(driver);

//	public void initializeDriver() {
//		
//	}
	
	@Given("I landed on Ecommerce Page")
	public void navigate_to_Ecommerce_Page() throws IOException{
		driver.manage().window().maximize();
		loginPage.goTo("https://rahulshettyacademy.com/client/");
	}

	@Given("^I am logged in with username (.+) and password (.+)$")
	public void loginToApplication(String username, String password) {
		loginPage.loginToApplication(username, password);
	}

	@When("^I add the product (.+) to cart$")
	public void addProductToCart(String productName) {
		prodCatalogPg.addProductToCart(productName);
	}

	@And("^Checkout (.+) and submit order$")
	public void checkoutAndSubmitOrder(String country) {
		cartPg.goToCheckoutPage();
		checkoutPg.fillUpAndSubmit(country);
	}

	@Then("{string} message is displayed in confirmation page")
	public void validateMessageIsDisplayed(String string) {
		String confirmationMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmationMessage.equalsIgnoreCase(string));

	}
	
	@Then("I will see {string} message is displayed")
	public void validateIncorrectLoginToastMessageDisplayed(String string) {
		loginPage.validateErrorMessage(string);
	}
}
