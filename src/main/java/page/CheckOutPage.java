package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SeleniumFrameworkDesign.abstractComponent.AbstractComponent;

public class CheckOutPage extends AbstractComponent{

	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".ta-results")
	WebElement searchResult;
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement countryInputField;
	
	@FindBy(css =".action__submit")
	WebElement submitButton;
	
	
	public WebElement selectCountry(String countryName) {
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'"+countryName+"')]"));
		return ele;
	}
	
	public void fillUpAndSubmit(String country) {
		Actions a = new Actions(driver);
		a.sendKeys(countryInputField, country).build().perform();;
		waitForElementToAppear(searchResult);
		selectCountry(country).click();
		submitButton.click();
	}
	
}
