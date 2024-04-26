package com.pan.pages.QAClickAcademy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.pan.pages.BasePage;

public class AutomationPage extends BasePage {

	public AutomationPage(WebDriver driver){
		super(driver);
	}

	@FindBy(xpath="//h5[text()='OUR PROJECTS']")
	private WebElement ourProjectText;

	@FindBy(xpath="//*[@id='project-container']/div/div[1]/a[1]")
	private WebElement automationPracticeLink;

	public WebElement getOurProjectText() { return ourProjectText; }

	public WebElement getAutomationPracticeLink() { return automationPracticeLink; }
	}

	



