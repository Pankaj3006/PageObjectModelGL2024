package com.pan.utilities;

import com.pan.driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonUtilities {
	
	public static void click(WebElement element) {

        WaitUtilities.waitForClickabilityOf(element).click();
    }

    public static void clearThenInputText(WebElement element, String text) {
        element = WaitUtilities.waitForClickabilityOf(element);
        element.clear();
        element.sendKeys(text);
    }

    public static boolean isDisplayed(WebElement element)
    {
       return WaitUtilities.waitForVisibilityOfElement(element).isDisplayed();
    }

    public static String getText(WebElement element) {

        return WaitUtilities.waitForVisibilityOfElement(element).getText();
    }

    public static void clickWithJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public static void selectElement(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    private static WebDriver getDriver()
    {
        return DriverManager.getDriver();
    }
}
