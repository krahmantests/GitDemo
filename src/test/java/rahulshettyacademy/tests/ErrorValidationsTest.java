package rahulshettyacademy.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.TestComponents.Retry;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.ProductCatalog;

public class ErrorValidationsTest extends BaseTest {

@Test(groups = {"ErrorHandling"}) //,retryAnalyzer = Retry.class)
public void LoginErrorValidation() throws IOException, InterruptedException{
		// TODO Auto-generated method stub

		
		
		
		 landingPage.loginApplication("johndoe42213@gmail.com", "Ps34life");
		landingPage.getErrorMessage();
		 Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		//div[@class='ng-tns-c4-3 toast-message ng-star-inserted']
	}

@Test
public void ProductErrorValidation() throws IOException, InterruptedException{
		// TODO Auto-generated method stub

		String productName = "ZARA COAT 3";
		
		
		ProductCatalog productCatalog = landingPage.loginApplication("dipu4213@gmail.com", "Ps34life");
		
		 
			List<WebElement> products= productCatalog.getProductList();
			productCatalog.addProductToCart(productName);
		CartPage cartPage = productCatalog.cart();
		
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		
	}


}
