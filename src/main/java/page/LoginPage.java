package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import SeleniumFrameworkDesign.abstractComponent.AbstractComponent;

public class LoginPage extends AbstractComponent {

	WebDriver driver;
//	LoginPage loginPage = new LoginPage();

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "userEmail")
	WebElement usernameField;

	@FindBy(id = "userPassword")
	WebElement passwordField;

	@FindBy(id = "login")
	WebElement loginButton;
	
	@FindBy(xpath = "//div[@id='toast-container']//div//div")
	WebElement incorrectToast;

	By loginSuccessToast = By.cssSelector(".toast-success");

	public void goTo(String URL) {
		driver.get(URL);
	}

	public void loginToApplication(String email, String password) {
		usernameField.sendKeys(email);
		passwordField.sendKeys(password);
		loginButton.click();
//		waitForElementToAppear(loginSuccessToast);
	}
	
	public void validateErrorMessage(String message) {
		String actualMessage = incorrectToast.getText();
		message.contains(actualMessage);
	}
	
	

}
