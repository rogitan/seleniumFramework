package SeleniumFrameworkDesign.abstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	
	WebDriver driver;
	WebDriverWait wait;
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}


	public void waitForElementToAppear(By findBy) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	
	public void waitForElementToAppear(WebElement ele) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	
	public void waitForElementToDisappear(By findBy) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
		
	}
	
	public void waitForElementToDisappear(WebElement ele) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}
	
	public void waitForElementToBeClickable(WebElement ele) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void waitForElementToBeClickable(By findBy) {
		wait.until(ExpectedConditions.elementToBeClickable(findBy));
	}
}
