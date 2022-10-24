package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent.AbstractComponent;

public class OrderPage extends AbstractComponent {
	WebDriver driver;
	
	@FindBy(xpath ="(//button[contains(@type,'button')]) [2]")
	WebElement checkoutEle;
	
	
	@FindBy(xpath = "//td[2]")
	private List <WebElement> productNames;

	
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

public Boolean VerifyOrderDisplay(String productName) {
	Boolean match = productNames.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
	return match;
	
	
}




	
	
	
}
