package com.pan.pages.orangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.pan.pages.BasePage;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(how=How.XPATH ,using="//input[@name='username']")
	private WebElement username;
	
	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btn_submit;

	@FindBy(xpath = "//img[@alt='company-branding']")
	private WebElement img_logo;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getBtn_submit() {
		return btn_submit;
	}

	public WebElement getImg_logo() {
		return img_logo;
	}
}
