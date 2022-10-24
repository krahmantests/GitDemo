package rahulshettyacademy.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.OrderPage;

public class AbstractComponent {
	WebDriver driver;

public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}

@FindBy(xpath = "(//button[@class='btn btn-custom']) [3]")
WebElement cartHeader;

@FindBy(xpath = "(//button[@class='btn btn-custom']) [2]")
WebElement orderHeader;

public void waitForElementToAppear(By findBy) {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
}

public void waitForWebElementToAppear(WebElement findBy) {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(findBy));
}

public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	// wait.until(ExpectedConditions.invisibilityOf(ele));
	Thread.sleep(1000);
}

public CartPage cart() {
	
	cartHeader.click();
	CartPage cartPage = new CartPage(driver);
	return cartPage;
	
}
public OrderPage gotoOrdersPage() {
	
	orderHeader.click();
	OrderPage orderPage = new OrderPage(driver);
	return orderPage;
	
}


}
