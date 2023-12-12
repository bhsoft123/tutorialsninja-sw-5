package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.demo.pages.ShoppingCartPage;
import com.tutorialsninja.demo.pages.TopMenuPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class LaptopsAndNotebooksTest extends BaseTest {

    TopMenuPage topMenuPage;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    ShoppingCartPage shoppingCartPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        topMenuPage = new TopMenuPage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        shoppingCartPage =  new ShoppingCartPage();
    }
    //1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
@Test(groups = {"sanity","smoke","regression"})
public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
    //1.1 Mouse hover on Laptops & Notebooks Tab.and click
    topMenuPage.hoverToLaptopsAndNotebooksAndClick();
    //1.2 Click on “Show All Laptops & Notebooks”
    topMenuPage.clickOnShowAllLaptopsAndNotebooks();
    //1.3 Select Sort By "Price (High > Low)"
    Thread.sleep(2000);
    laptopsAndNotebooksPage.sortbyPriceHighToLow();
    //1.4 Verify the Product price will arrange in High to Low order.
    Assert.assertEquals(laptopsAndNotebooksPage.afterSorting(), laptopsAndNotebooksPage.beforeSorting(), "products not sorted by Price High to Low");
}
    //2. Test name verifyThatUserPlaceOrderSuccessfully()
@Test(groups = {"sanity","regression"})
public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
    //2.1 Mouse hover on Laptops & Notebooks Tab and click
    topMenuPage.hoverToLaptopsAndNotebooksAndClick();
    //2.2 Click on “Show All Laptops & Notebooks”
    topMenuPage.clickOnShowAllLaptopsAndNotebooks();
    //2.3 Select Sort By "Price (High > Low)"
    laptopsAndNotebooksPage.sortbyPriceHighToLow();
    //2.4 Select Product “MacBook”
    laptopsAndNotebooksPage.selectProduct("MacBook");
    //2.5 Verify the text “MacBook”
    Assert.assertEquals(laptopsAndNotebooksPage.verifyTextMacBook(), "MacBook", "Error");
    //2.6 Click on ‘Add To Cart’ button
    laptopsAndNotebooksPage.addToCartButton();
    //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
    Assert.assertEquals(laptopsAndNotebooksPage.verifyMacBookText(), "MacBook", "Error");
    //2.8 Click on link “shopping cart” display into success message
    laptopsAndNotebooksPage.clickOnShoppingCart1();
    //2.9 Verify the text "Shopping Cart"
    Thread.sleep(5000);
    Assert.assertEquals(shoppingCartPage.verifyShoppingCartText(),"Shopping Cart  (0.00kg)" ,"Error");
    //2.10 Verify the Product name "MacBook"
    Assert.assertEquals(shoppingCartPage.verifyMacBookText(),"MacBook","Error");
    //2.11 Change Quantity "2"
    Thread.sleep(2000);
    shoppingCartPage.changeMacBookQuantity2("2");
    //2.12 Click on “Update” Tab
    Thread.sleep(2000);
    shoppingCartPage.clickOnUpdate();
    //2.13 Verify the message “Success: You have modified your shopping cart!”
    Assert.assertEquals(shoppingCartPage.successMessageForUpdate(),"Success: You have modified your shopping cart!\n×","Error");
    //2.14 Verify the Total £737.45
    Assert.assertEquals(shoppingCartPage.verifyTotalAmountMacBook(), "£737.45", "Error");
    //2.15 Click on “Checkout” button
    shoppingCartPage.clickOnCheckOutButton();
    Assert.assertEquals(shoppingCartPage.verifyCheckoutText(),"Checkout", "Error" );
    //2.17 Verify the Text “New Customer”
    Assert.assertEquals(shoppingCartPage.verifyNewCustomerText(), "New Customer","Error");
    //2.18 Click on “Guest Checkout” radio button
    Thread.sleep(2000);
    shoppingCartPage.clickOnGuestCheckOutRadioButton();
    //2.19 Click on “Continue” tab
    shoppingCartPage.clickOnContinueTab();
    //2.20 Fill the mandatory fields
    shoppingCartPage.fillMandatoryFields();
    //2.21 Click on “Continue” Button
    shoppingCartPage.clickOnContinueButton();
    //2.22 Add Comments About your order into text area
    shoppingCartPage.addCommentsAboutOrder();
    //2.23 Check the Terms & Conditions check box
    shoppingCartPage.termsAndConditionsCheckBox();
    //2.24 Click on “Continue” button
    shoppingCartPage.clickOnContinueButtonOnCheckOut();
    //2.25 Verify the message “Warning: Payment method required!”
    Assert.assertEquals(shoppingCartPage.verifyWarningPaymentMessage(), "Warning: Payment method required!\n×", "Error");
}

}
