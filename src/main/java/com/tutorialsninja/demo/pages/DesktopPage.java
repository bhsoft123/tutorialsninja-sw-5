package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class DesktopPage extends Utility {

    @CacheLookup
    @FindBy (xpath = "//a[normalize-space()='Desktops']")
    WebElement desktopText;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-sort']")
    WebElement sortByFilter;


    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement verifyText2;
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='HP LP3065']")
    WebElement verifyText1 ;
    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//a[normalize-space()='shopping cart']")
    WebElement shoppingCart;
    @CacheLookup
    @FindBy(css ="#button-cart")
    WebElement  buttonAddToCart;
    @CacheLookup
    @FindBy(css = "#input-quantity")
    WebElement  quantityField;
    @CacheLookup
    @FindBy(css = "img[title='HTC Touch HD']")
    WebElement selectProduct1;


    public String getActualText(){ return getTextFromElement(desktopText);}
    public void clickOnSortByNameZtoA(String sortByText){ selectByVisibleTextFromDropDown(sortByFilter, sortByText);}
    public void clickOnSortByNameAtoZ(String sortByText1){ selectByVisibleTextFromDropDown(sortByFilter,sortByText1);}
    public String verifyHPLP30651Text(){ return getTextFromElement(verifyText1);}
    public void selectProduct(String product){
        clickOnElement(selectProduct1);}
        public void enterquantity(String quantity1){
        sendTextToElement(quantityField, quantity1);    }
    public void addToCart(){ clickOnElement(buttonAddToCart);}
    public String verifySuccessMessageText(){ return getTextFromElement(verifyText2);}
    public void clickOnShoppingCart(){ clickOnElement(shoppingCart);}
    By beforeSortList = By.xpath("//div[@class='caption']//h4//a");
    By afterSortList = By.xpath("//div[@class='caption']//h4//a");

    public List productsBeforeSortby() {
        List<WebElement> originalProducts = driver.findElements(beforeSortList);
        ArrayList<String> originalList = new ArrayList<>();

        for (WebElement e : originalProducts) {
            originalList.add(e.getText());
            System.out.println("originalList" + originalList);
        }
        return originalList;
    }
    public List productsAfterSortBy() {
        List<WebElement> afterSortByNameZtoA = driver.findElements(afterSortList);
        ArrayList<String> sortedListZtoA = new ArrayList<>();

        for (WebElement e : afterSortByNameZtoA){
            sortedListZtoA.add(e.getText());
            System.out.println("Sorted List: " +sortedListZtoA);
        }
        return sortedListZtoA;
    }
}


