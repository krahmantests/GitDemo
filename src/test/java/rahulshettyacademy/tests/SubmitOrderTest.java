package rahulshettyacademy.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.ProductCatalog;

public class SubmitOrderTest extends BaseTest {
	String productName = "ZARA COAT 3";
	
	
@Test(dataProvider="getData", groups = {"Purchase"})
public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException{
		// TODO Auto-generated method stub

		
		
		
		ProductCatalog productCatalog = landingPage.loginApplication(input.get("email"), input.get("password"));
		
		 
			List<WebElement> products= productCatalog.getProductList();
			productCatalog.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalog.cart();
		
		Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckOut();
		checkoutPage.selectCountry("united");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		
		
		
		
		String confirmMessage = confirmationPage.getConfirmationMessage();
		
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
@Test(dependsOnMethods= {"submitOrder"})
public void OrderHistoryTest() {
	ProductCatalog productCatalog = landingPage.loginApplication("johndoe4213@gmail.com", "Ps34life");
	OrderPage ordersPage =  productCatalog.gotoOrdersPage();
Assert.assertTrue( ordersPage.VerifyOrderDisplay(productName))	;

}



@DataProvider
public Object[][] getData() throws IOException {
	
	//One way to do it with hashmap below
	HashMap<String, String> map = new HashMap<String, String>();
	map.put("email","johndoe4213@gmail.com" );
	map.put("password", "Ps34life");
	map.put("product", "ZARA COAT 3");

	HashMap<String, String> map1 = new HashMap<String, String>();
	map1.put("email","dipu4213@gmail.com" );
	map1.put("password", "Ps34life");
	map1.put("product", "ADIDAS ORIGINAL");
	return new Object[][] {{map}, {map1}} ;
	

	
	//List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//rahulshettyacademy//data//PurchaseOrder.json");
	//return new Object[][] {{data.get(0)}, {data.get(1)}} ;
}
//One way to do it with hashmap below



}
