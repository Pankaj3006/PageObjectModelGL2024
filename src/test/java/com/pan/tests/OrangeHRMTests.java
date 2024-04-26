package com.pan.tests;

import static com.pan.utilities.CommonUtilities.clearThenInputText;
import static com.pan.utilities.CommonUtilities.click;
import static com.pan.utilities.CommonUtilities.isDisplayed;

import com.pan.driver.DriverManager;
import com.pan.pages.orangeHRM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.pan.utils.Constant;

public class OrangeHRMTests extends BaseTest {
	LoginPage loginPage;
	
	@Test
	void test2()
	{
		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.load("https://opensource-demo.orangehrmlive.com/");
		Assert.assertTrue(isDisplayed(loginPage.getImg_logo()));
	}
	
	@Test
	void test1()
	{
		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.load("https://opensource-demo.orangehrmlive.com/");
		clearThenInputText(loginPage.getUsername(), Constant.HRM_USERNAME);
		clearThenInputText(loginPage.getPassword(), Constant.HRM_PASSWORD);
		click(loginPage.getBtn_submit());
		Assert.assertEquals(DriverManager.getDriver().getTitle(), "OrangeHRM");
	}

}
