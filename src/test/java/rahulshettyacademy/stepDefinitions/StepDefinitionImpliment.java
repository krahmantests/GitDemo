package rahulshettyacademy.stepDefinitions;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalog;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefinitionImpliment extends BaseTest{
	public  LandingPage landingPage;
	public ProductCatalog productCatalog;
	public ConfirmationPage confirmationPage;
	

    @Given("^I landed on Ecommerce Page$")
    public void i_landed_on_ecommerce_page() throws Throwable {
        landingPage = launchApplication();
    }

    @Given("^Logged in with username (.+) and password (.+)$")
    public void logged_in_with_username_and_password(String name, String password) throws Throwable {
       productCatalog = landingPage.loginApplication(name,password);
       
    }

    @When("^I add product (.+) to Cart$")
    public void i_add_product_to_cart(String productName) throws Throwable {
    	List<WebElement> products= productCatalog.getProductList();
		productCatalog.addProductToCart(productName);
    }

    

    @When("^Checkout (.+) and submit the order$")
    public void checkout_and_submit_the_order(String productName) throws Throwable {
CartPage cartPage = productCatalog.cart();
		
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckOut();
		checkoutPage.selectCountry("united");
		confirmationPage = checkoutPage.submitOrder();
    }
    
    
    @Then("{string} message is displayed on ConfirmationPage$")
    public void message_displayed_confirmationPage(String string) {
    	
    	String confrimMessage = confirmationPage.getConfirmationMessage();
    	Assert.assertTrue(confrimMessage.equalsIgnoreCase(string));
    }

}