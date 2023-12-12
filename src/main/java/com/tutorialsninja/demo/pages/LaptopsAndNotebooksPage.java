package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Listeners(CustomListeners.class)
public class LaptopsAndNotebooksPage extends Utility {

    @CacheLookup
    @FindBy(css = "div[id='content'] h2")
    WebElement laptopsAndNotebooks;

    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    List<WebElement> productsPath;
    @CacheLookup
    @FindBy(id ="input-sort")
    WebElement sortByMenu;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopAndNoteBookText;
    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement macBookLink;
    @CacheLookup
    @FindBy(css ="body > div:nth-child(4) > div:nth-child(2) > div:nth-child(2) > div:nth-child(7) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > h4:nth-child(1) > a:nth-child(1)")
    WebElement product;

    @CacheLookup
    @FindBy(css = "div[id='content'] h1")
    WebElement macbookText;

    @CacheLookup
    @FindBy(id="button-cart")
    WebElement addtoCartButtn;
    @CacheLookup
    @FindBy(className = "alert alert-success alert-dismissible")
    WebElement successMessage;
    @CacheLookup
    @FindBy(css ="div[class='alert alert-success alert-dismissible'] a:nth-child(2)")
    WebElement shoppingCartButton;


    public String getLaptopAndNoteBookText(){
        return getTextFromElement(laptopAndNoteBookText);
    }


    public String getActualText(){ return getTextFromElement(laptopsAndNotebooks);}
    public void sortbyPriceHighToLow(){
        selectByVisibleTextFromDropDown( sortByMenu, "Price (High > Low)");
        CustomListeners.test.log(Status.PASS,"select price high to low");
    }
    public String verifyTextMacBook(){ return getTextFromElement(macbookText); }
    public void selectProduct(String productMacbook){
        selectByVisibleTextFromDropDown(product, productMacbook);
    }
    public void addToCartButton(){ clickOnElement(addtoCartButtn);}
    public String verifyMacBookText(){return getTextFromElement(successMessage);}
    public void clickOnShoppingCart1(){ clickOnElement(shoppingCartButton);}


    public ArrayList<String> expectedList() {
        // Get all the products name and stored into array list
        List<WebElement> products = productsPath;
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        return originalProductsName;
    }
    public void selectPriceHighToLow(String inputSelectPriceOrder){
        Reporter.log("selecting " + inputSelectPriceOrder.toString());
        selectByVisibleTextFromDropDown(sortByMenu,inputSelectPriceOrder);
        CustomListeners.test.log(Status.PASS,"select"+inputSelectPriceOrder);
    }
    public List<Double> beforeSorting() {
        List<WebElement> product = productsPath ;
        ArrayList<Double> originalList = new ArrayList<>();
        for (WebElement list : product) {
            String[] arr = list.getText().split("Ex Tax:");
            originalList.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        return originalList;
    }
    public List<Double> afterSorting(){
        Collections.sort(beforeSorting(), Collections.reverseOrder());
        System.out.println(beforeSorting());
        List<WebElement>products = productsPath;
        ArrayList<Double>afterSortingList = new ArrayList<>();
        for (WebElement newSortList : products){
            String[] arr = newSortList.getText().split("Ex Tax:");
            afterSortingList.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        return afterSortingList;
    }
    public void clickOnMacbook(){
        Reporter.log("Clicking on macbook " + macBookLink.toString());
        clickOnElement(macBookLink);
        CustomListeners.test.log(Status.PASS,"Click on macbook");
}
}



