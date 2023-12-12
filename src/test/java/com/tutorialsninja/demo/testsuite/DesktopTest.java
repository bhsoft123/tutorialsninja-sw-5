package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.*;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class DesktopTest extends BaseTest {

    TopMenuPage topMenuPage;
    DesktopPage desktopPage;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    ComponentsPage componentsPage;
    ShoppingCartPage shoppingCartPage;
    @BeforeMethod
    public void inIt(){
        topMenuPage = new TopMenuPage();
        desktopPage = new DesktopPage();
        laptopsAndNotebooksPage =  new LaptopsAndNotebooksPage();
        componentsPage = new ComponentsPage();
        shoppingCartPage = new ShoppingCartPage();
    }
    //1.Test name verifyProductArrangeInAlphaBaticalOrder()
@Test(groups={"sanity","smoke","regression"})
public void verifyProductArrangeInAlphaBaticalOrder() {

    //1.1 Mouse hover on Desktops Tab.and click
    topMenuPage.hoverOnDesktopsAndClick();
    //1.2 Click on “Show All Desktops”
    topMenuPage.clickOnShowAllDesktops();
    //Call a method to store original product display list
    desktopPage.productsBeforeSortby();
    //1.3 Select Sort By position "Name: Z to A"
    desktopPage.clickOnSortByNameZtoA("Name (Z - A)");
    desktopPage.productsAfterSortBy();
    //1.4 Verify the Product will arrange in Descending order. check again
    Assert.assertEquals(desktopPage.productsBeforeSortby(),desktopPage.productsAfterSortBy(),"Products in descending order");
}
@Test(groups={"sanity","regression"})
public void  verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
    //2.1 Mouse hover on Currency Dropdown and click
    topMenuPage.mouseHoverOnCurrencyDropdown();
    //2.2 Mouse hover on £Pound Sterling and click
    topMenuPage.mouseHoverOnPoundSterlingAndClick();
    //2.3 Mouse hover on Desktops Tab.
    topMenuPage.hoverOnDesktopsAndClick();
    //2.4 Click on “Show All Desktops”
    topMenuPage.clickOnShowAllDesktops();
    //2.5 Select Sort By position "Name: A to Z"
    desktopPage.clickOnSortByNameAtoZ("Name (A - Z)");
    //2.6 Select product “ HTC Touch HD”
    desktopPage.selectProduct("HTC Touch HD");
    //2.7.Enter Qty "1” using Select class.
    desktopPage.enterquantity("1");
    //2.8 Click on “Add to Cart” button
    desktopPage.addToCart();
    //2.9 Verify the Message “Success Message”
    Thread.sleep(2000);
    Assert.assertEquals(desktopPage.verifySuccessMessageText(), "Success: You have added HP LP3065 to your shopping cart!\n×","Error");
    //2.12 Click on link “shopping cart” display into success message
    desktopPage.clickOnShoppingCart();
    //2.13 Verify the text "Shopping Cart"
    Thread.sleep(5000);
    Assert.assertEquals(shoppingCartPage.verifyShoppingCartText(),"Shopping Cart  (1.00kg)" ,"Error");
    //2.14 Verify the Product name "HTC Touch HD"
    Assert.assertEquals(shoppingCartPage.verifyHPLaptopText(), "HTC Touch HD", "Error");
     //2.16 Verify the Model "Product1"
    Assert.assertEquals(shoppingCartPage.verifyModelText(),"Product 1");
    //2.17 Verify the Todal "£74.73"
    Assert.assertEquals(shoppingCartPage.verifyTotalAmount(),"£74.73","Error");
}
}

