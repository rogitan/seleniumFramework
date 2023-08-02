package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFrameworkDesign.abstractComponent.AbstractComponent;

public class ProductCatalogPage extends AbstractComponent{

	WebDriver driver;
	
	public ProductCatalogPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = ".mb-3")
	List<WebElement> productList;
	
	By products = By.cssSelector(".mb-3");
	By addToCartButon = By.cssSelector(".card-body button:last-of-type");
	By loadingSpinner = By.cssSelector(".ngx-spinner-overlay");
	By addedToCartToastMessage = By.cssSelector(".ngx-spinner-overlay");
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement checkOutButton;
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(products);
		return productList;
	}
	
	public WebElement getProductByName(String productName) {
		
		WebElement prodSelect = productList.stream()
				.filter(product -> product.findElement(By.tagName("b")).getText().equalsIgnoreCase(productName))
				.findFirst().orElse(null);
		return prodSelect;
		
	}
	
	public void addProductToCart(String productName) {
		
		WebElement selectedProduct = getProductByName(productName);
		selectedProduct.findElement(addToCartButon).click();
		waitForElementToAppear(loadingSpinner);
		waitForElementToDisappear(addedToCartToastMessage);
		checkOutButton.click();
		
	}
	
}
