package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class ShoppingCartPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Shopping Cart')]")
    WebElement verifyText3;
    @CacheLookup
    @FindBy(css = "body > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2) > a:nth-child(1)")
    WebElement verifyText4;
    @CacheLookup
    @FindBy(css = "body > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2) > small:nth-child(3)")
    WebElement verifyDelDateText;
    @CacheLookup
    @FindBy(xpath = "body > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2) > small:nth-child(3)")
    WebElement verifyModText;
    @CacheLookup
    @FindBy(css ="body > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(6)")
    WebElement verifyTotAmnt;
    @CacheLookup
    @FindBy  (css = "input[value='1']")
    WebElement quantityField;
    @CacheLookup
    @FindBy(css = "body > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2) > a:nth-child(1)")
    WebElement verifyMacbkText;
    @CacheLookup
    @FindBy(css =".fa.fa-refresh")
    WebElement updateButton;
    @CacheLookup
    @FindBy(css =".alert.alert-success.alert-dismissible")
    WebElement successMesgForUpdate;

    @CacheLookup
    @FindBy(css ="tbody tr td:nth-child(6)")
    WebElement totalMacBookAmnt;
    @CacheLookup
    @FindBy(css ="a[class='btn btn-primary']" )
    WebElement checkOutButton;
    @CacheLookup
    @FindBy(css = "div[id='content'] h1")
    WebElement checkOutText;
    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='New Customer']")
    WebElement newCustomerText;
    @CacheLookup
    @FindBy(css = "input[value='guest']")
    WebElement guestCheckoutButton;
    @CacheLookup
    @FindBy(css= "#button-account")
    WebElement continueTab;
    @CacheLookup
    @FindBy(css = "#button-guest")
            WebElement continueButton;
    @CacheLookup
    @FindBy(xpath  ="//textarea[@name='comment']")
    WebElement textArea;
    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
            WebElement checkBox;
    @CacheLookup
    @FindBy(css = "#button-payment-method")
    WebElement continueOnCheckOut;
    @CacheLookup
    @FindBy(css = ".alert.alert-danger.alert-dismissible")
            WebElement warningMessage;
    @CacheLookup
    @FindBy(id="input-payment-firstname")
    WebElement fillmandFirstname;
    @CacheLookup
    @FindBy(id="input-payment-lastname")
    WebElement fillmandlastname;
    @CacheLookup
    @FindBy(id="input-payment-email")
    WebElement fillmandEmail;
    @CacheLookup
    @FindBy(id="input-payment-telephone")
    WebElement fillmandPhone ;
    @CacheLookup
    @FindBy(id="input-payment-address-1")
    WebElement fillmandAddress ;
    @CacheLookup
    @FindBy(id="input-payment-city")
    WebElement fillmandCity ;
    @CacheLookup
    @FindBy(id="postcode")
    WebElement fillmandPostcode;
    @CacheLookup
    @FindBy(id="input-payment-country")
    WebElement fillmandCountry;
    @CacheLookup
    @FindBy(id ="input-payment-zone")
    WebElement fillmandZone;

    public String verifyShoppingCartText(){ return getTextFromElement(verifyText3);}
    public String verifyHPLaptopText(){ return getTextFromElement(verifyText4);}
    public String verifyDeliveryDate(){ return getTextFromElement(verifyDelDateText);}
    public String verifyModelText(){ return getTextFromElement(verifyModText);}
    public String verifyTotalAmount(){ return getTextFromElement(verifyTotAmnt);}

    public String verifyMacBookText() { return getTextFromElement(verifyMacbkText);}
    public void changeMacBookQuantity2(String quantity2) {
        clearTextFromField(quantityField);
        sendTextToElement(quantityField, quantity2);}
    public void clickOnUpdate(){ clickOnElement(updateButton);}
    public String successMessageForUpdate(){ return getTextFromElement(successMesgForUpdate);}
    public String verifyTotalAmountMacBook(){ return getTextFromElement(totalMacBookAmnt);}
    public void clickOnCheckOutButton(){ clickOnElement(checkOutButton);}
    public String verifyCheckoutText(){ return getTextFromElement(checkOutText);}
    public String verifyNewCustomerText(){ return getTextFromElement(newCustomerText);}
    public void clickOnGuestCheckOutRadioButton(){ clickOnElement(guestCheckoutButton);}
    public void clickOnContinueTab(){ clickOnElement(continueTab);}


    public void fillMandatoryFields(){
        sendTextToElement(fillmandFirstname,"Orange");
        sendTextToElement(fillmandlastname,"Purple");
        Random random = new Random();
        sendTextToElement(fillmandEmail,"orangepurple" + random.nextInt(1000)+"@gmail.com");
        sendTextToElement(fillmandPhone,"01234567899");
        sendTextToElement(fillmandAddress,"Orange Street");
        sendTextToElement(fillmandCity,"London");
        sendTextToElement(fillmandPostcode,"AB1 2CD");
        selectByVisibleTextFromDropDown(fillmandCountry, "United Kingdom");
        selectByVisibleTextFromDropDown(fillmandZone, "Bristol");
        }
    public void clickOnContinueButton(){ clickOnElement(continueButton);}
    public void addCommentsAboutOrder(){ sendTextToElement(textArea, "Please leave by the door");}
    public void termsAndConditionsCheckBox(){ clickOnElement(checkBox);}
    public void clickOnContinueButtonOnCheckOut(){ clickOnElement(continueOnCheckOut);}
    public String verifyWarningPaymentMessage(){return getTextFromElement(warningMessage); }
}
