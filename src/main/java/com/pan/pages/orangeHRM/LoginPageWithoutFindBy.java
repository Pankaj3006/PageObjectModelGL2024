package com.pan.pages.orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageWithoutFindBy {
	
	WebDriver driver;
	
	public LoginPageWithoutFindBy(WebDriver driver)
	{
		this.driver= driver;
	}
	
	By txt_userName = By.xpath("//input[@name='username']");
	By txt_password = By.xpath("//input[@name='password']");
	By btn_submit = By.xpath("//button[@type='submit']");
	By img_logo = By.xpath("//img[@alt='company-branding']");
	
	public void enterUserName(String userName)
	{
		driver.findElement(txt_userName).sendKeys(userName);
	}
	
	public void enterPassword(String password)
	{
		driver.findElement(txt_password).sendKeys(password);
	}
	
	public void clickLoginButton()
	{
		driver.findElement(btn_submit).click();
	}
	
	public boolean isLogoDisplayed()
	{
		return driver.findElement(btn_submit).isDisplayed();
	}

}
