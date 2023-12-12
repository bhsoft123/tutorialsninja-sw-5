package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends Utility {
    @CacheLookup
    @FindBy(css = "div[id='content'] h1")
    WebElement verifyTextNewAccount;
    @CacheLookup
    @FindBy(css = ".btn.btn-primary")
    WebElement contOnNewAccountPage;
    @CacheLookup
    @FindBy(xpath = "//a[@title='My Account']")
    WebElement myAccountLink;
    @CacheLookup
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement continueAfterLogout;
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/h2[text()='My Account']")
    WebElement myAccountText;
    @CacheLookup
    @FindBy(css = "li[class='dropdown open'] li:nth-child(1) a:nth-child(1)")
    WebElement logout;


    public String getTextFromAccount() {
        return getTextFromElement(verifyTextNewAccount);
    }

    public void clickonContinueOnNewAccountPage() {
        clickOnElement(contOnNewAccountPage);
    }

    public void clickOnMuAccountLink() {
        clickOnElement(myAccountLink);
    }
    public void selectMyAccountOptions(String text) { selectByVisibleTextFromDropDown(logout, text);}
    public void clickOnContinueAfterLogout() {
        clickOnElement(continueAfterLogout);
    }

    public String getMyAccountText() {
        return getTextFromElement(myAccountText);

    }
}