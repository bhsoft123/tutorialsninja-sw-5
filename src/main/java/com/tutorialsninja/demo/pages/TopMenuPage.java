package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class TopMenuPage extends Utility {

    @CacheLookup
    @FindBy(css = "\"body > div:nth-child(3) > nav:nth-child(1) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(1) > div:nth-child(2) > a:nth-child(2)")
    WebElement topMenuLink;

    @CacheLookup
    @FindBy(xpath = "//li[@class='dropdown']//a[normalize-space()='Desktops']")
    WebElement desktops;

    @CacheLookup
    @FindBy(xpath = "//li[@class='dropdown']//a[normalize-space()='Laptops & Notebooks']")
    WebElement laptopsAndNotebooks;

    @CacheLookup
    @FindBy(css = "body > div:nth-child(3) > nav:nth-child(1) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(2) > div:nth-child(2) > a:nth-child(2)")
    WebElement showAllLaptops;

    @CacheLookup
    @FindBy(className = "dropdown-toggle")
    WebElement components;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Show AllComponents')]")
    WebElement showAllComponents;

    @CacheLookup
    @FindBy(css = "div.container:nth-child(3) nav.navbar div.collapse.navbar-collapse.navbar-ex1-collapse ul.nav.navbar-nav li.dropdown:nth-child(1) div.dropdown-menu > a.see-all")
    WebElement showAllDesktops;

    @CacheLookup
    @FindBy(xpath = "//body/nav[@id='top']/div[1]/div[1]/form[1]/div[1]/button[1]")
    WebElement currencyDropDown;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'£Pound Sterling')]")
    WebElement poundSterling;
    @CacheLookup
    @FindBy(css = "a[title='My Account'] span[class='hidden-xs hidden-sm hidden-md']")
    WebElement myAccountLink;
    @CacheLookup
    @FindBy(css = "a[href='https://tutorialsninja.com/demo/index.php?route=account/register']")
    WebElement menuOptionsRegister;
    @CacheLookup
    @FindBy(css = "a[href='https://tutorialsninja.com/demo/index.php?route=account/login']")
    WebElement menuOptionsLogin;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccounts;
    @CacheLookup
    @FindBy(css = "a[title='My Account'] span[class='hidden-xs hidden-sm hidden-md']")
    WebElement myAccountslink;


    public void selectMenu(String menu) {
        if (menu == "Show All Desktops") {
            mouseHoverToElementAndClick(desktops);
        } else if (menu == "Show All Laptops & Notebooks") {
            mouseHoverToElementAndClick(laptopsAndNotebooks);
        } else if (menu == "Show All Components") {
            mouseHoverToElementAndClick(components);
        } else {
            System.out.println("please enter valid topmenu");
        }
    }

    public void selectMyAccountOption(String menu1) {
        if (menu1 == "Register") {
            selectByVisibleTextFromDropDown(menuOptionsRegister, menu1);
        } else if (menu1 == "Login") {
            selectByVisibleTextFromDropDown(menuOptionsLogin, menu1);
        }
    }


    public void hoverOnDesktopsAndClick() {
        mouseHoverToElementAndClick(desktops);
    }

    public void hoverToLaptopsAndNotebooksAndClick() {
        mouseHoverToElementAndClick(laptopsAndNotebooks);
    }

    public void clickOnShowAllLaptopsAndNotebooks() {
        mouseHoverToElementAndClick(showAllLaptops);
    }

    public void hoverToComponents() {
        mouseHoverToElementAndClick(components);
    }

    public void clickOnShowAllComponents() {
        mouseHoverToElementAndClick(showAllComponents);
    }

    public void clickOnShowAllDesktops() {
        mouseHoverToElementAndClick(showAllDesktops);
    }

    public void mouseHoverOnCurrencyDropdown() {
        mouseHoverToElementAndClick(currencyDropDown);
    }

    public void mouseHoverOnPoundSterlingAndClick() {
        mouseHoverToElementAndClick(poundSterling);
    }

    public void clickOnMyAccountLink() {
        clickOnElement(myAccountLink);
    }

    public void clickOnMyAccount() {
        clickOnElement(myAccounts);

    }
    public void selectMyAccountOptions(){ clickOnElement(myAccountslink);}
    public void clickOnLogin(){ clickOnElement(menuOptionsLogin);}
}