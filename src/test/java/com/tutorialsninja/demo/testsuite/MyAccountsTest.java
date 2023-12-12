package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.*;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class MyAccountsTest extends BaseTest {

    TopMenuPage topMenuPage;
    DesktopPage desktopPage;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    ComponentsPage componentsPage;
    ShoppingCartPage shoppingCartPage;
    MyAccountPage myAccountPage;
    RegisterPage registerPage;
    AccountCreatedPage accountCreatedPage;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        topMenuPage = new TopMenuPage();
        desktopPage = new DesktopPage();
        laptopsAndNotebooksPage =  new LaptopsAndNotebooksPage();
        componentsPage = new ComponentsPage();
        shoppingCartPage = new ShoppingCartPage();
        myAccountPage = new MyAccountPage();
        registerPage = new RegisterPage();
        accountCreatedPage = new AccountCreatedPage();
        loginPage = new LoginPage();
    }

@Test(groups={"Sanity" , "Smoke" ,"Regression"})
public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
    //1. Create the class MyAccountsTest
    //1.1 create method with name "selectMyAccountOptions" it has one parameter name
    //"option" of type string
    //1.2 This method should click on the options whatever name is passed as parameter.
    // (Hint: Handle List of Element and Select options)1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully()
    //1.1 Clickr on My Account Link.
    topMenuPage.clickOnMyAccountLink();
    //1.2 Call the method “selectMyAccountOptions” method and pass the parameter
    topMenuPage.selectMyAccountOption("Register");
    // “Register”
    //1.3 Verify the text “Register Account”.
    Assert.assertEquals(registerPage.getTextFromRegister(), "Register Account", "Error");
}
    //2. Test name verifyUserShouldNavigateToLoginPageSuccessfully()
    @Test(groups={"Sanity" ,"Regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Click on My Account Link.
        topMenuPage.clickOnMyAccountLink();
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “login”
        topMenuPage.selectMyAccountOption("Login");
        //2.3 Verify the text “Returning customer”.
        Assert.assertEquals(registerPage.getTextFromReturningCustomer(), "Register Account", "Error");
    }
@Test(groups={"Regression"})
public void verifyThatUserRegisterAccountSuccessfully()  {
        //3. Test name verifyThatUserRegisterAccountSuccessfully()
    //3.1 Clickr on My Account Link.
    topMenuPage.clickOnMyAccountLink();
    //3.2 Call the method “selectMyAccountOptions” method and pass the parameter
    // “Register”
    topMenuPage.selectMyAccountOption("Register");
    //3.3 Enter First Name
    //3.4 Enter Last Name
    //3.5 Enter Email
    //3.6 Enter Telephone
    //3.7 Enter Password
    //3.8 Enter Password Confirm
    //3.9 Select Subscribe Yes radio button
    //3.10 Click on Privacy Policy check box
    // 3.11 Click on Continue button
    registerPage.fillMandDetailsForRegistration();
    //3.12 Verify the message “Your Account Has Been Created!”
    Assert.assertEquals(accountCreatedPage.getTextFromAccount(), "Your Account Has Been Created!", "Error");
    //3.13 Click on Continue button
    accountCreatedPage.clickonContinueOnNewAccountPage();
    // 3.14 Clickr on My Account Link.
    accountCreatedPage.clickOnMuAccountLink();
    //3.15 Call the method “selectMyAccountOptions” method and pass the parameter
    accountCreatedPage.selectMyAccountOptions("Logout");
    // “Logout”
    //3.16 Verify the text “Account Logout”
    Assert.assertEquals(accountCreatedPage.getMyAccountText(), "Account Logout", "Not logged out");
    //4.11 Click on Continue button
    accountCreatedPage.clickOnContinueAfterLogout();
    //3.17 Click on Continue button
}
@Test(groups={"Regression"})
public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
    //4.1 Click on My Account Link.
    topMenuPage.clickOnMyAccount();
    //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
    topMenuPage.clickOnLogin();
    //4.3 Enter Email address
    loginPage.sendEmail("orangespurples@gmail.com");
    //4.5 Enter Password
    loginPage.sendPassword("Orange@purple");
    //4.6 Click on Login button
    loginPage.clickOnLogin();
    //4.7 Verify text “My Account”
    //Assert.assertEquals(myAccountPage.getMyAccountText(), "My Account", "Not on my account");
    //4.8 Click on My Account Link.
    //myAccountPage.clickOnMyAccountLink();
    //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
    //topMenuPage.selectMyAccountOptions("Logout");
    //4.10 Verify the text “Account Logout”
    //Assert.assertEquals(topMenuPage.getTextFromLogout(), "Account Logout", "Not logged out");
    //4.11 Click on Continue button
    //topMenuPage.clickOnContinueButton();

}

}
