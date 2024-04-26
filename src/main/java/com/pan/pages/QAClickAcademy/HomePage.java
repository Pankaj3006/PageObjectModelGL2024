package com.pan.pages.QAClickAcademy;

import com.pan.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver){
		super(driver);
	}

@FindBy(xpath="//ul/li[7]/a[text()='Practice']")
private WebElement practiceLink;

	public WebElement getPracticeLink() { return practiceLink; }
}