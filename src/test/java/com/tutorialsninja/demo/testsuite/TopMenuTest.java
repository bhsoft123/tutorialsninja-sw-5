package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.ComponentsPage;
import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.TopMenuPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class TopMenuTest extends BaseTest {

    TopMenuPage topMenuPage;
    DesktopPage desktopPage;
    ComponentsPage componentsPage;

    @BeforeMethod
    public void inIt(){
        topMenuPage = new TopMenuPage();
        desktopPage = new DesktopPage();
    //    laptopsAndNotebooksPage =  new LaptopsAndNotebooksPage();
        componentsPage = new ComponentsPage();
    }

    //1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
@Test(groups={"Sanity" , "Smoke" ,"Regression"})
public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
    //1.1 Mouse hover on “Desktops” Tab and click
    topMenuPage.hoverOnDesktopsAndClick();
    //1.2 call selectMenu method and pass the menu = “Show All Desktops”
    topMenuPage.selectMenu("Show All Desktops");
    //1.3 Verify the text ‘Desktops’
    Assert.assertEquals(desktopPage.getActualText(), "Desktops", "Error");
}

//2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
@Test(groups={"Sanity" ,"Regression"})
public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
    //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
    topMenuPage.hoverToLaptopsAndNotebooksAndClick();
    //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
    topMenuPage.selectMenu("Show All Laptops & Notebooks");
    topMenuPage.clickOnShowAllLaptopsAndNotebooks();
    //2.3 Verify the text ‘Laptops & Notebooks’
    //Assert.assertEquals(laptopsAndNotebooksPage.getActualText(), "Laptops & Notebooks","Error");


}
@Test(groups={"Regression"})
//3. verifyUserShouldNavigateToComponentsPageSuccessfully()
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //3.1 Mouse hover on “Components” Tab and click
        topMenuPage.hoverToComponents();
        //3.2 call selectMenu method and pass the menu = “Show All Components”
        topMenuPage.selectMenu("Show All Components");
        //3.3 Verify the text ‘Components
        Assert.assertEquals(componentsPage.getActualText(),"Components","Error");
    }
}
