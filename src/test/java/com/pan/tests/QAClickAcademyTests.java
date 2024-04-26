package com.pan.tests;

import static com.pan.utilities.CommonUtilities.click;
import static com.pan.utilities.CommonUtilities.clickWithJS;
import static com.pan.utilities.CommonUtilities.clearThenInputText;
import static com.pan.utilities.CommonUtilities.getText;
import static com.pan.utilities.CommonUtilities.selectElement;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static com.pan.utilities.WaitUtilities.unConditionalWait;

import com.pan.driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.pan.pages.QAClickAcademy.HomePage;
import com.pan.pages.QAClickAcademy.RegisterPage;
import com.pan.pages.QAClickAcademy.AutomationPage;
import com.pan.pages.QAClickAcademy.GreenCartProductPage;
import com.pan.pages.QAClickAcademy.CartPage;
import com.pan.pages.QAClickAcademy.PlaceOrderPage;
import com.pan.pages.QAClickAcademy.ProceedPage;
import com.pan.pages.QAClickAcademy.ThankYouShoppingPage;
import com.pan.utils.Constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QAClickAcademyTests extends BaseTest {
    HomePage homePage;
    RegisterPage registerPage;
    AutomationPage automationPage;
    GreenCartProductPage greenCartProductPage;
    CartPage cartPage;
    PlaceOrderPage placeOrderPage;
    ProceedPage proceedPage;
    ThankYouShoppingPage thankYouShoppingPage;

    @Test
    void test1()
    {
        homePage = new HomePage(DriverManager.getDriver());
        homePage.load("https://rahulshettyacademy.com/");
        click(homePage.getPracticeLink());
        registerPage = new RegisterPage(DriverManager.getDriver());
        getText(registerPage.getRegisterPageText());
        Assert.assertEquals(getText(registerPage.getRegisterPageText()), Constant.REGISTER_PAGE_TEXT);
        clearThenInputText(registerPage.getUsername(), Constant.QA_CLICK_USERNAME);
        clearThenInputText(registerPage.getUserEmail(), Constant.QA_CLICK_PASSWORD);
        click(registerPage.getCheckbox());
        click(registerPage.getSubmitButton());
        automationPage = new AutomationPage(DriverManager.getDriver());
        Assert.assertEquals(getText(automationPage.getOurProjectText()), Constant.AUTOMATION_PAGE_TITLE);
        clickWithJS(automationPage.getAutomationPracticeLink());
        Assert.assertEquals(DriverManager.getDriver().getTitle(), Constant.GREEN_CART_PAGE_TITLE);
    }

    @Test
    void test2()
    {
        greenCartProductPage = new GreenCartProductPage(DriverManager.getDriver());
        greenCartProductPage.load("https://rahulshettyacademy.com/seleniumPractise/#/");
        List<String> listOFItemsNeedToAdd = new ArrayList(Arrays.asList("Tomato", "Potato", "Onion", "Pomegranate", "Almonds"));
        for (int i=0; i<listOFItemsNeedToAdd.size(); i++) {
            greenCartProductPage.selectProductByName(listOFItemsNeedToAdd.get(i));
        }
        click(greenCartProductPage.getCart());
        cartPage = new CartPage(DriverManager.getDriver());
        click(cartPage.getProceedToCheckOut());
        placeOrderPage = new PlaceOrderPage(DriverManager.getDriver());
        unConditionalWait(2000);
        List<String> listOfOrderItems = placeOrderPage.getListOfOrderProducts();
        Assert.assertTrue(listOfOrderItems.containsAll(listOFItemsNeedToAdd));
        clearThenInputText(placeOrderPage.getPromoCodeTextBox(), Constant.PROMO_CODE);
        click(placeOrderPage.getPromoCodeApplyButton());
        click(placeOrderPage.getPlaceOrder());
        proceedPage = new ProceedPage(DriverManager.getDriver());
        Assert.assertEquals(getText(proceedPage.getChooseCountry()), Constant.COUNTRY_CHOOSE);
        selectElement(proceedPage.getCountryDropdown(), "India");
        click(proceedPage.getTermAndConditionCheckBox());
        click(proceedPage.getProceedButton());
        thankYouShoppingPage = new ThankYouShoppingPage(DriverManager.getDriver());
        String successMessage = getText(thankYouShoppingPage.getThankYouMessage());
        assertThat(successMessage, containsString(Constant.SUCCESSFUL_MESSAGE));
    }
}
