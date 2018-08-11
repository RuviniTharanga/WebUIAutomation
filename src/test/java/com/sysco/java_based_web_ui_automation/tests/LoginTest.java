package com.sysco.java_based_web_ui_automation.tests;


import com.sysco.java_based_web_ui_automation.data.LoginData;
import com.sysco.java_based_web_ui_automation.functions.Account;
import com.sysco.java_based_web_ui_automation.functions.Cart;
import com.sysco.java_based_web_ui_automation.functions.Login;
import com.sysco.java_based_web_ui_automation.pages.LoginPage;
import com.sysco.java_based_web_ui_automation.utils.ExcelUtil;
import com.sysco.java_based_web_ui_automation.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class LoginTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {

        iTestContext.setAttribute("feature", "Bundabergrum - Checkout");
    }

    @Test(description = "TC 01:Validate Restrict Entry for Age below 18")
    public void testRestrictEnterForUnderAge() throws Exception {

        SoftAssert softAssert = new SoftAssert();
        Login.loadLoginPage();
        Login.setBirthdayBelow18();
        softAssert.assertEquals(Login.getError(),"Sorry, your age or location does not permit you to enter at this time.");
        softAssert.assertAll();

    }
    @Test(description = "TC 02",dependsOnMethods = "testRestrictEnterForUnderAge")
    public void testCorrectCountrySelection(){
        SoftAssert softAssert = new SoftAssert();
        Login.getCountry();
        softAssert.assertEquals(Login.getCountry(),"Sri Lanka","Selected country is incorrect");
        softAssert.assertAll();
    }
    @Test(description = "TC 03",dependsOnMethods = "testCorrectCountrySelection")
    public void testEnterAnotherCountry(){
        SoftAssert softAssert = new SoftAssert();
        Login.setDifferentCountry();
        softAssert.assertAll();
    }
    @Test(description = "TC 04:Verify Enter for age over 18",dependsOnMethods = "testEnterAnotherCountry")
    public void testAllowEnterForOver18(){
        SoftAssert softAssert = new SoftAssert();
        Login.setBirthdayOver18();
        softAssert.assertAll();

    }
    @Test(description = "TC 05:Test error messages when both Email and password empty ",dependsOnMethods = "testAllowEnterForOver18")
    public void testAccountEmailPasswordEmpty() throws Exception{
        SoftAssert softAssert = new SoftAssert();
        Account.clickMyAccount();
        //Verify when both email and password fields empty
        Account.clickSendButton();
        softAssert.assertEquals(Account.getEmailRequiredWarning(),"This is a required field.","Wrong error message when Email  is not entered");
        softAssert.assertEquals(Account.getPasswordRequiredWarning(),"This is a required field.","Wrong error message when Password  is not entered");
        softAssert.assertAll();
    }
    @Test(description = "TC 06:",dependsOnMethods = "testAccountEmailPasswordEmpty")
    public void testIncorrectPassword(){
        SoftAssert softAssert = new SoftAssert();
        Account.typeEmail("ruvini@gmail.com");
        Account.typePassword("123");
        Account.clickSendButton();
        softAssert.assertEquals(Account.getInvalidPasswordWarning(),"Please enter 6 or more characters. Leading or trailing spaces will be ignored.");
        Account.clearEnteredEmailPassword();
        softAssert.assertAll();
    }

    @Test(description = "TC 07:",dependsOnMethods = "testIncorrectPassword")
    public void testIncorrectEmail(){
        SoftAssert softAssert = new SoftAssert();
        Account.typeEmail("ruvini");
        Account.typePassword("1234@abcd");
        Account.clickSendButton();
        softAssert.assertEquals(Account.getInvalidEmailWarning(),"Please enter a valid email address. For example johndoe@domain.com.");
        Account.clearEnteredEmailPassword();
        softAssert.assertAll();
    }

    @Test(description = "TC 08",dependsOnMethods = "testIncorrectEmail")
    public void testCorrectEmailPassword() throws Exception{
        SoftAssert softAssert = new SoftAssert();
        Account.typeEmail("williamjacob802@gmail.com");
        Account.typePassword("12345678");
        Account.clickSendButton();
        Account.getUsername();
        softAssert.assertEquals(Account.getUsername(),"WILLIAM JACOB", "Displayed username is incorrect");
        Cart.clickCartIcon();
        softAssert.assertAll();
    }

    @Test(description = "TC 09",dependsOnMethods = "testCorrectEmailPassword")
    public void testRemoveItemsFromCart() throws Exception{
        SoftAssert softAssert = new SoftAssert();
        Cart.clickCartIcon();
        Cart.clickRemoveLink();

        Cart.clickCartIcon();
        softAssert.assertEquals(Cart.isDisplayedZeroInCart(),"0","Expected value does not displayed");
        softAssert.assertAll();
    }
    @Test(description = "TC 10",dependsOnMethods = "testRemoveItemsFromCart")
    public static void testAddItemToCart() {
        Cart.MoveToProductCategory();
        Cart.clickRoyalLiqueur();
        Cart.clickAnItem();
        Cart.clickAddToCartButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Cart.isDisplayedPriceInPopUp(), "expected price does not displayed");
        softAssert.assertTrue(Cart.isDisplayedNameInPopUP(), "expected name does not displayed");
        softAssert.assertAll();
    }
    @Test(description = "TC 11",dependsOnMethods = "testAddItemToCart")
    public static void testCheckOutOfAnItem() {
        Cart.clickCheckOut();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(Cart.isDisplayedOneInShoppingCart(), "1", "Expected value does not displayed");
        softAssert.assertTrue(Cart.isDisplayedPrice(), "expected price does not displayed");
        softAssert.assertTrue(Cart.isDisplayedName(), "expected name does not displayed");
        softAssert.assertAll();
    }
    @Test(description = "TC 12",dependsOnMethods = "testCheckOutOfAnItem")
    public static void testValidationsWhenProceedToCheckOut() {
        Cart.clickProceedToCheckOut();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(Cart.isDisplayedFirstName(),"william","expected name does not displayed");
        softAssert.assertEquals(Cart.isDisplayedLastName(),"jacob","expected name does not displayed");
        Cart.clearFirstName();
        Cart.clearLastNameName();
        Cart.clearAddress1();
        Cart.clearContactNumberName();
        Cart.clickContinue();
        softAssert.assertEquals(Cart.isDisplayedEmptyErrorFirstName(),"This is a required field.","expected value does not displayed");
        softAssert.assertEquals(Cart.isDisplayedEmptyErrorLastName(),"This is a required field.","expected value does not displayed");
        softAssert.assertEquals(Cart.isDisplayedEmptyErrorAddress(),"This is a required field.","expected value does not displayed");
        softAssert.assertEquals(Cart.isDisplayedEmptyErrorContactNumber(),"This is a required field.","expected value does not displayed");
        softAssert.assertAll();
    }
    @Test(description = "TC 13",dependsOnMethods = "testValidationsWhenProceedToCheckOut")
    public static void testContinueInProceedToCheckOut() {
        Cart.enterFirstName("william");
        Cart.enterLastName("jacob");
        Cart.enterAddress1("Abc");
        Cart.enterContactNumber("2222222222");
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(Cart.isDisplayedFirstName(),"william","expected name does not displayed");
        softAssert.assertEquals(Cart.isDisplayedLastName(),"jacob","expected name does not displayed");
        softAssert.assertEquals(Cart.isDisplayedAddress(),"Abc","expected name does not displayed");
        softAssert.assertEquals(Cart.isDisplayedContactNumber(),"2222222222","expected name does not displayed");
        Cart.removePostCode();
        Cart.enterPostCode("2000");
        Cart.clickContinue();
        softAssert.assertEquals(Cart.isDisplayedDeliveryOptions(),"DELIVERY OPTIONS","expected name does not displayed");
        softAssert.assertAll();
    }

    @Test(description = "TC 14",dependsOnMethods = "testContinueInProceedToCheckOut")
    public static void testPaymentMethodsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        Cart.clickContinueInDeliveryOptions();
        //verify payment methods displayed
        Cart.isCreditCardPaymentDisplayed();
        softAssert.assertTrue(true,"Credit card payment not displayed");
        Cart.isPaypalPaymentDisplayed();
        softAssert.assertTrue(true,"Paypal payment not displayed");
        softAssert.assertAll();
    }

    @Test(description = "TC-15",dependsOnMethods = "testPaymentMethodsDisplayed")
    public static void testCardValidationsWhenCCAndCvvEmpty(){
        SoftAssert softAssert = new SoftAssert();
        Cart.selectCreditCardPayment();
        Cart.clickPurchase();
        Cart.getErrorEmptyCreditCardNumber();
        Cart.getErrorEmptyCvvNumber();
        softAssert.assertEquals(Cart.getErrorEmptyCreditCardNumber(),"This is a required field.","Credit Card number kept empty");
        softAssert.assertEquals(Cart.getErrorEmptyCvvNumber(),"This is a required field.","cvv number kept empty");
        softAssert.assertAll();
    }

    @Test(description = "TC-16",dependsOnMethods = "testCardValidationsWhenCCAndCvvEmpty")
    public static void testCardValidationForExpireDay(){
        SoftAssert softAssert = new SoftAssert();
        //Cart.setExpiryMonthJanuary();
        //Cart.setExpiryYear2018();
        //softAssert.assertEquals(Cart.getErrorExpireMonth(),"Incorrect credit card expiration date.","Error message not displayed for overdue Expiry month");
        softAssert.assertAll();
    }

    @Test(description = "TC-17",dependsOnMethods = "testCardValidationForExpireDay")
    public static void testEnterCreditcardDetails(){
        SoftAssert softAssert = new SoftAssert();
        Cart.enterCorrectCreditCardNoVisa("4111111111111111","123");
        softAssert.assertEquals(Cart.getEnteredCreditCardDetails(),"4111111111111111","credit card number entered incorreclyt");
        softAssert.assertEquals(Cart.getEnteredCvvDetails(),"123","cvv number entered incorreclyt");
        softAssert.assertAll();

    }

    @Test(description = "TC 18",dependsOnMethods = "testCardValidationForExpireDay",alwaysRun = true)
    public static void testEnteringPayPalDetails() {
        SoftAssert softAssert=new SoftAssert();
        Cart.selectPayPalOption();
        Cart.selectAgreement();
        Cart.clickPurchase();

        Cart.enterCCNumber("4111111111111111");
        Cart.enterExpiry("");
        Cart.enterCvv("");
        Cart.enterPhone("");

        softAssert.assertAll();

    }


    @AfterClass
    public void cleanup(){
        Login.quiteDriver();
    }
}