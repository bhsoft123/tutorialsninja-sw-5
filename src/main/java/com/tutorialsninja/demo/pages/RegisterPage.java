package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Utility {

    @CacheLookup
    @FindBy(css ="div[id='content'] h1")
    WebElement registerAccountText;
    @CacheLookup
    @FindBy(css = "getTextFromReturningCustomer()")
    WebElement returningCusomterText;
    @CacheLookup
    @FindBy(id="input-firstname")
    WebElement fillmandFirstname;
    @CacheLookup
    @FindBy(id="input-lastname")
    WebElement fillmandlastname;
    @CacheLookup
    @FindBy(id="input-email")
    WebElement fillmandEmail;
    @CacheLookup
    @FindBy(id="input-telephone")
    WebElement fillmandPhone ;
    @CacheLookup
    @FindBy(id="input-password")
    WebElement fillmandPassword ;
    @CacheLookup
    @FindBy(id="input-confirm")
    WebElement fillmandConfirmPassword ;
    @CacheLookup
    @FindBy(css ="input[value='1'][name='newsletter']")
    WebElement selectYesRadioButton;
    @CacheLookup
    @FindBy(css ="input[value='1'][name='agree']")
    WebElement selectPrivacyPolicy;
    @CacheLookup
    @FindBy(css ="input[value='1'][name='agree']")
    WebElement continueButton;

    public String getTextFromRegister() {return getTextFromElement(registerAccountText);}
    public String  getTextFromReturningCustomer(){ return getTextFromElement(returningCusomterText);}
    public void fillMandDetailsForRegistration(){
        sendTextToElement(fillmandFirstname,"Oranges");
        sendTextToElement(fillmandlastname,"Purples");
        sendTextToElement(fillmandEmail,"orangespurples@gmail.com");
        sendTextToElement(fillmandPhone,"01234567899");
        sendTextToElement(fillmandPassword, "Orange@purple");
        sendTextToElement(fillmandConfirmPassword, "Orange@purple");
        clickOnElement(selectYesRadioButton);
        clickOnElement(selectPrivacyPolicy);
        clickOnElement(continueButton);



    }


}
