package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;
	
	@FindBy(xpath ="(//button[contains(@type,'button')]) [2]")
	WebElement checkoutEle;
	
	
	@FindBy(xpath = "//div[@class='cartSection'] //h3")
	private List <WebElement> productTitles;
public CartPage(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

public Boolean VerifyProductDisplay(String productName) {
	Boolean match = productTitles.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
	return match;
	
	
}
public CheckoutPage goToCheckOut() {
	driver.findElement(By.xpath("(//button[contains(@type,'button')]) [2]")).click();
	return new CheckoutPage(driver);
	
			
	
	
}



	
	
	
}
