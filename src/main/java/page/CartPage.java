package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

import SeleniumFrameworkDesign.abstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent{

	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> prodAddedToCart;
	
	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkOutButton;
	
	
	public boolean verifyProductCheckoutPage(String productName) {
		
		boolean flag = prodAddedToCart.stream().anyMatch(prod->prod.getText().equalsIgnoreCase(productName));
		return flag;
	}
	
	public void goToCheckoutPage() {
		waitForElementToBeClickable(checkOutButton);
//		checkOutButton.click();
	}
	
	
}
