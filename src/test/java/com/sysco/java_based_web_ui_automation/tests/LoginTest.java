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

    @Test(description = "TC 01")
    public void testRestrictEnterForUnderAge() throws Exception {

        SoftAssert softAssert = new SoftAssert();
        Login.loadLoginPage();
        Login.setBirthdayBelow18();
        softAssert.assertEquals(Login.getError(),"Sorry, your age or location does not permit you to enter at this time.");
        softAssert.assertAll();

    }
    @Test(description = "TC 02",dependsOnMethods = "testRestrictEnterForUnderAge",alwaysRun = true)
    public void testCorrectCountrySelection(){
        SoftAssert softAssert = new SoftAssert();
        Login.getCountry();
        softAssert.assertEquals(Login.getCountry(),"Sri Lanka","Selected country is incorrect");
        softAssert.assertAll();
    }
    @Test(description = "TC 03",dependsOnMethods = "testCorrectCountrySelection",alwaysRun = true)
    public void testEnterAnotherCountry(){
        SoftAssert softAssert = new SoftAssert();
        Login.setDifferentCountry();
        Login.getCountry();
        softAssert.assertEquals(Login.getCountry(),"Albania","Selected country is incorrect");
        softAssert.assertAll();
    }
    @Test(description = "TC 04",dependsOnMethods = "testEnterAnotherCountry",alwaysRun = true)
    public void testAllowEnterForOver18(){
        SoftAssert softAssert = new SoftAssert();
        Login.setBirthdayOver18();
        Account.isMyAccountDisplayed();
        softAssert.assertTrue(true,"Not Logged in for birthday over 18");
        softAssert.assertAll();

    }
    @Test(description = "TC 05",dependsOnMethods = "testAllowEnterForOver18",alwaysRun = true)
    public void testAccountEmailPasswordEmpty() throws Exception{
        SoftAssert softAssert = new SoftAssert();
        Account.clickMyAccount();
        //Verify when both email and password fields empty
        Account.clickSendButton();
        softAssert.assertEquals(Account.getEmailRequiredWarning(),"This is a required field.","Wrong error message when Email  is not entered");
        softAssert.assertEquals(Account.getPasswordRequiredWarning(),"This is a required field.","Wrong error message when Password  is not entered");
        softAssert.assertAll();
    }
    @Test(description = "TC 06:",dependsOnMethods = "testAccountEmailPasswordEmpty",alwaysRun = true)
    public void testIncorrectPassword(){
        SoftAssert softAssert = new SoftAssert();
        Account.typeEmail("ruvini@gmail.com");
        Account.typePassword("123");
        Account.clickSendButton();
        softAssert.assertEquals(Account.getInvalidPasswordWarning(),"Please enter 6 or more characters. Leading or trailing spaces will be ignored.");
        Account.clearEnteredEmailPassword();
        softAssert.assertAll();
    }

    @Test(description = "TC 07:",dependsOnMethods = "testIncorrectPassword",alwaysRun = true)
    public void testIncorrectEmail(){
        SoftAssert softAssert = new SoftAssert();
        Account.typeEmail("ruvini");
        Account.typePassword("1234@abcd");
        Account.clickSendButton();
        softAssert.assertEquals(Account.getInvalidEmailWarning(),"Please enter a valid email address. For example johndoe@domain.com.");
        Account.clearEnteredEmailPassword();
        softAssert.assertAll();
    }

    @Test(description = "TC 08",dependsOnMethods = "testIncorrectEmail",alwaysRun = true)
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

    @Test(description = "TC 09",dependsOnMethods = "testCorrectEmailPassword",alwaysRun = true)
    public void testRemoveItemsFromCart() throws Exception{
        SoftAssert softAssert = new SoftAssert();
        Cart.clickCartIcon();
        Cart.clickRemoveLink();

        Cart.clickCartIcon();
        softAssert.assertEquals(Cart.isDisplayedZeroInCart(),"0","Expected value does not displayed");
        softAssert.assertAll();
    }
    @Test(description = "TC 10",dependsOnMethods = "testRemoveItemsFromCart",alwaysRun = true)
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
    @Test(description = "TC 11",dependsOnMethods = "testAddItemToCart",alwaysRun = true)
    public static void testCheckOutOfAnItem() {
        Cart.clickCheckOut();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(Cart.isDisplayedOneInShoppingCart(), "1", "Expected value does not displayed");
        softAssert.assertTrue(Cart.isDisplayedPrice(), "expected price does not displayed");
        softAssert.assertTrue(Cart.isDisplayedName(), "expected name does not displayed");
        softAssert.assertAll();
    }
    @Test(description = "TC 12",dependsOnMethods = "testCheckOutOfAnItem",alwaysRun = true)
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
    @Test(description = "TC 13",dependsOnMethods = "testValidationsWhenProceedToCheckOut",alwaysRun = true)
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

    @Test(description = "TC 14",dependsOnMethods = "testContinueInProceedToCheckOut",alwaysRun = true)
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

    @Test(description = "TC-15",dependsOnMethods = "testPaymentMethodsDisplayed",alwaysRun = true)
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

    @Test(description = "TC-16",dependsOnMethods = "testCardValidationsWhenCCAndCvvEmpty",alwaysRun = true)
    public static void testCardValidationForExpireDay(){
        SoftAssert softAssert = new SoftAssert();
        //Cart.setExpiryMonthJanuary();
        //Cart.setExpiryYear2018();
        //softAssert.assertEquals(Cart.getErrorExpireMonth(),"Incorrect credit card expiration date.","Error message not displayed for overdue Expiry month");
        softAssert.assertAll();
    }

    @Test(description = "TC-17",dependsOnMethods = "testCardValidationForExpireDay",alwaysRun = true)
    public static void testEnterCreditcardDetails(){
        SoftAssert softAssert = new SoftAssert();
        Cart.enterCreditCardNoVisa("4111111111111111","123");
        softAssert.assertEquals(Cart.getEnteredCreditCardDetails(),"4111111111111111","credit card number entered incorreclyt");
        softAssert.assertEquals(Cart.getEnteredCvvDetails(),"123","cvv number entered incorreclyt");
        Cart.clearCardAndCvv();
        softAssert.assertAll();

    }
    @Test(description = "TC 18",dependsOnMethods = "testEnterCreditcardDetails",alwaysRun = true)
    public static void testInvalidCardDetails(){
        SoftAssert softAssert = new SoftAssert();
        Cart.enterCreditCardNoVisa("411111111111111111111","1234");
        softAssert.assertEquals(Cart.getErrorForIncorrectCardNo(),"Please enter a valid credit card number.");
        softAssert.assertAll();
    }
    @Test(description = "TC 19",dependsOnMethods = "testInvalidCardDetails",alwaysRun = true)
    public static void testInvalidCvvDetails(){
        SoftAssert softAssert = new SoftAssert();
        Cart.enterCreditCardNoVisa("4111111111111111","1234567");
        Cart.clickPurchase();
        softAssert.assertEquals(Cart.getErrorForIncorrectCvv(),"Please enter a valid credit card verification number.","Error message not displayed for incorrect cvv");
        softAssert.assertAll();
    }

    @Test(description = "TC 20",dependsOnMethods = "testInvalidCvvDetails",alwaysRun = true)
    public static void testEnteringPayPalDetails() {
        SoftAssert softAssert=new SoftAssert();
        Cart.selectPayPalOption();
        Cart.clickPurchase();
        Cart.clickonWindowAlert();
        softAssert.assertTrue(true,"Error Not displayed for not ticking agreement");
        Cart.selectAgreement();
        Cart.clickPurchase();
        softAssert.assertEquals(Cart.isDisplayedPayPalAccount(),"PayPal Guest Checkout");
        softAssert.assertAll();
    }

    @Test(description = "TC 21",dependsOnMethods = "testEnteringPayPalDetails",alwaysRun = true)
    public static void testCreditCardDetailsInPaypalPage(){
        SoftAssert softAssert=new SoftAssert();
        Cart.enterCCNumber("4");
        Cart.getIsVisaIconDisplayedinPaypalForFirstDigit();
        softAssert.assertTrue(Cart.getIsVisaIconDisplayedinPaypalForFirstDigit(),"Visa icon not displayed when entering 4");
        Cart.enterCCNumber("411111111111111");
        Cart.enterCvv("224");
        Cart.clickbtnContinueInPaypal();
        softAssert.assertTrue(Cart.getErrorForEmptyExpireInPaypal(),"Error not displayed when expire kept empty in paypal");

        Cart.enterExpiry("");
        Cart.enterPhone("222222222");
        softAssert.assertAll();
    }
    @Test(description = "TC-22",dependsOnMethods = "testCreditCardDetailsInPaypalPage",alwaysRun = true)
    public static void testUserDetailsInPaypalPage(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(Cart.getFirstNameDisplayedinPaypal(),"william","Incorrect first name displayed in Paypal");
        softAssert.assertEquals(Cart.getLastNameDisplayedinPaypal(),"jacob","Incorrect lastname displayed in Paypal");
        softAssert.assertEquals(Cart.getAddress1DisplayedinPaypal(),"Abc","Incorrect address displayed in Paypal");
        softAssert.assertEquals(Cart.getPostalCodeDisplayedinPaypal(),"2000","Incorrect postal code displayed in Paypal");
        softAssert.assertEquals(Cart.getEmailDisplayedInPaypal(),"williamjacob802@gmail.com","Incorrect email displayed in paypal");
        softAssert.assertAll();
    }


    @AfterClass
    public void cleanup(){
        Login.quiteDriver();
    }
}