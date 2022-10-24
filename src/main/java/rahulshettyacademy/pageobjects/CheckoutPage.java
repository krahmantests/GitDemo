package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.AbstractComponent.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath ="//div[@class='actions'] //a")
	WebElement submit;
	
	
	@FindBy(xpath ="//input[@placeholder='Select Country']")
	WebElement country;
	
	
	@FindBy(xpath="//button[contains(@class,'ta-item')] [4]")
	WebElement selectCountry;
	
	By results = By.cssSelector(".ta-results");
			
	
	public void selectCountry(String countryName) {
		
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(By.cssSelector(".ta-results"));
	selectCountry.click();
		
		//country 
		
		
	}
	public ConfirmationPage submitOrder() {
		
		
		driver.findElement(By.xpath("//div[@class='actions'] //a")).click();
		return new ConfirmationPage(driver);
	
	}
	
	
	

}
