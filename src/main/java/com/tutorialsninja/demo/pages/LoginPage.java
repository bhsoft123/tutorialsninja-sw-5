package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(id ="input-email")
    WebElement enterEmail;
    @CacheLookup
    @FindBy(id ="input-password")
    WebElement enterPassword;
    @CacheLookup
    @FindBy(css ="input[value='Login']")
    WebElement login;
    public void sendEmail(String email){ sendTextToElement(enterEmail, email);}
    public void sendPassword(String password){ sendTextToElement(enterPassword, password);}
    public void clickOnLogin(){clickOnElement(login);}

}
