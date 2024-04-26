package com.pan.pages.QAClickAcademy;

import com.pan.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ThankYouShoppingPage extends BasePage {

	public ThankYouShoppingPage(WebDriver driver){

		super(driver);
	}

	@FindBy(xpath="//*[text()='Thank you, your order has been placed successfully ']")
	private WebElement thankYouMessage;
	
	public WebElement getThankYouMessage() { return thankYouMessage; }
}
