package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ComponentsPage extends Utility {

    @CacheLookup
    @FindBy (css = "body > div:nth-child(3) > nav:nth-child(1) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(2) > div:nth-child(2) > a:nth-child(2)")
    WebElement showAllLaptops;

    public String getActualText(){ return getTextFromElement(showAllLaptops);}
}
