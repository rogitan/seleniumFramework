package test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.Retry;

public class SubmitAndOrder extends BaseTest {

	
	@Test(dataProvider = "getData")
//	@Test(dataProvider = "getData", retryAnalyzer = Retry.class)
	public void orderAndSubmit(HashMap<String, String> input) throws IOException {
		loginPage.loginToApplication(input.get("email"), input.get("password"));
		prodCatalogPg.addProductToCart(input.get("productName"));
		assertTrue(cartPg.verifyProductCheckoutPage(input.get("productName")));
		cartPg.goToCheckoutPage();
		checkoutPg.fillUpAndSubmit("Philippines");
		String confirmationMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@DataProvider
	public Object[][] getData() throws IOException {
//
//		List<HashMap<String, String>> data = getJsonDatatoMap("PurchaseOrder.json");
//	
//		
//		//FIRst hashmap
//		HashMap<Object, Object> map = new HashMap<Object, Object>();
//		map.put("email", "rogitest@gmail.com");
//		map.put("password", "P@ssword1");
//		map.put("productName", "zaracoat3");
//		
//		//secondhashmap
//		HashMap<Object, Object> map2 = new HashMap<Object, Object>();
//		map.put("email", "rogitest2@gmail.com");
//		map.put("password", "P@ssword2");
//		map.put("productName", "zaracoat3");
//		return new Object[][] { { "rogitest@gmail.com", "P@ssword1", "zaracoat3" },
//				{ "rogitest2@gmail.com", "P@ssword1", "zaracoat4" } };

		List<HashMap<String, String>> data = getJsonDatatoMap("PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}

}
