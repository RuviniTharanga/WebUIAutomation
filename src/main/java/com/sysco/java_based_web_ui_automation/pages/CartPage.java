package com.sysco.java_based_web_ui_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Rifad on 5/21/18.
 */
public class CartPage extends LoginPage {

    private By icnCart = By.id("cartHeader");
    private static By icnCartQuantity =By.xpath("//li[2]/ul/li[3]/div/div[1]/span[2]");
    private static By icnCartZeroValue =By.xpath("//*[@id=\"quick-access-list\"]/li[2]/ul/li[3]/div/div[1]/span[2]");
    private static By lnkRemove =By.xpath("//a[@title='Remove']");
    private static By lnkProductCategory =By.xpath("//div[@id='nav-wrapper']/div/ul[1]/li[@class='link-product']");
    private static By lnkProdCat =By.xpath("//*[@id=\"main-image\"]/img");
    private static By lnkRoyalLiqueur =By.xpath("//div[4]/div[@class='megamenu-left']/div[1]/ul//ul[@class='level0']//a[@href='https://www.bundabergrum.com.au/all-bottles/royal-liqueur-flavoured']");
    private static By icnItem =By.xpath("//a[@id='main-image']/img[@alt='Royal Liqueur - Mixed Pack 4']");
    private static By btnAddToCart =By.xpath("//*[@id=\"bundleSummary\"]/div/div[3]/button");
    private static By txtPriceInPopUp =By.xpath("//ol[@id='mini-cart']/li[@class='item odd']//table//span[@class='price']");
    private static By txtNameInPopUp =By.xpath("//ol[@id='mini-cart']//p[@class='product-name']/a[@href='https://www.bundabergrum.com.au/royal-liqueur-mixed-pack-4']");
    private static By btnCheckOut =By.xpath("//*[@id=\"topCartContent\"]/div/div/div/button");
    private static By txtPrice =By.xpath("//h1/span/span[@class='price']");
    private static By txtName =By.xpath("//h2/a[@href='https://www.bundabergrum.com.au/royal-liqueur-mixed-pack-4']");
    private static By btnProceedToCheckOut =By.xpath("//div[2]/div[3]/div[2]/div/div[1]/div[1]/div/ul/li[2]/button");
    private static By txtFirstName =By.id("billing:firstname");
    String value ="value";
    private static By txtLastName =By.id("billing:lastname");
    private static By txtAddress =By.id("billing:street1");
    private static By txtAddress2 =By.id("billing:street2");
    private static By txtContactNumber =By.id("billing:telephone");
    private static By btnContinue =By.id("delivery-address-button");
    private static By txtErrorForEmptyFirstName =By.id("advice-required-entry-billing:firstname");
    private static By txtErrorForEmptyLastName =By.id("advice-required-entry-billing:lastname");
    private static By txtErrorForEmptyAddress =By.id("advice-required-entry-billing:street1");
    private static By txtErrorForEmptyContactNumber =By.id("advice-required-entry-billing:telephone");
    private static By txtErrorForEmptyPostalCode =By.id("advice-required-entry-billing:postcodesuburb");
    private static By txtPostCode =By.id("billing:postcodesuburb");
    private static By icnRemovePostCode =By.id("billing:postcodesuburbremove");
    private static By txtDeliveryOptions =By.xpath("//h2[.='Delivery Options']");
    //private static By btnDeliveryOptionsContinue =By.xpath("//button[@id='shipping-method-button']");
    private static By btnDeliveryOptionsContinue =By.id("shipping-method-button");
    private static By rdBtnPayPal =By.xpath("//dl[@id='checkout-payment-method-load']/div[2]/dt/label");
    private static By chkAgreement =By.id("agreement-1");
    private static By btnPurchaseMyOrder =By.id("payment-method-button");
    private static By txtPayPal =By.id("pageTitle");
    private static By txtCreditCardNumber = By.id("cc");
    private static By txtCvv = By.id("cvv");
    private static By txtExpiry_value = By.id("expiry_value");
    private static By txtFirstNameInPaypal = By.id("firstName");
    private static By txtLastNameInPaypal = By.id("lastName");
    private static By txtBillingLine1 =By.id("billingLine1");
    private static By txtBillingLine2 =By.id("billingLine2");
    private static By txtBillingPostalCode =By.id("billingPostalCode");
    private static By txtEmail =By.id("email");
    private static By icnVisa =By.xpath("//*[@id=\"cardFields\"]/xo-credit-card/div/div[1]/div[4]/div");
    private static By txtPhone =By.id("telephone");
    private static By rdBttnCreditCard =By.xpath("//*[@id=\"checkout-payment-method-load\"]/div[1]/dt/label");
    private static By icnCreditCardVisa =By.xpath("//*[@id=\"payment-type-VI\"]/img");
    private static By txtCreditCard =By.id("braintree_cc_number");
    private static By txtCvvNumber =By.id("braintree_cc_cid");
    private static By expirationMonth =By.xpath("//*[@id=\"payment_form_braintree\"]/li[4]/div/div[1]/div/div[1]/div[1]");
    private static By expirationYear =By.xpath("//*[@id=\"payment_form_braintree\"]/li[4]/div/div[2]/div/div[1]/div[2]");
    //private static By drpExpireMonth = By.id("braintree_expiration");
    //private static By drpExpireYear = By.id("braintree_expiration_yr");
    //private static Select drpMonth = new Select(syscoLabUIOgm.findElement(By.id("braintree_expiration")));
    //private static Select drpYear = new Select(syscoLabUIOgm.findElement(By.id("braintree_expiration_yr")));
    private static By lstJan = By.xpath("//*[@id=\"payment_form_braintree\"]/li[4]/div/div[1]/div/div[3]/ul/li[2]");
    private static By lstNovember = By.xpath("//*[@id=\"payment_form_braintree\"]/li[4]/div/div[1]/div/div[2]/ul/li[12]");
    private static By errorEmptyCreditCardNumber = By.id("advice-required-entry-braintree_cc_number");
    private static By errorEmptyCvvNumber = By.id("advice-required-entry-braintree_cc_cid");
    private static By errorExpiryMonth= By.id("advice-validate-cc-exp-braintree_expiration");


    public void clickCartIcon() {
        syscoLabUIOgm.sleep(1);
        syscoLabUIOgm.click(icnCart);
        syscoLabUIOgm.sleep(3);
    }
    public void clickRemoveLink() {
        int x = 0;
        while (Integer.parseInt(syscoLabUIOgm.getText(icnCartQuantity)) != 0) {
            syscoLabUIOgm.click(icnCart);
            syscoLabUIOgm.sleep(2);
            syscoLabUIOgm.click(lnkRemove);
            syscoLabUIOgm.sleep(1);
            syscoLabUIOgm.isAlertDisplayed();
            syscoLabUIOgm.sleep(2);
            syscoLabUIOgm.clickOkInWindowsAlert();
            syscoLabUIOgm.sleep(2);
        }
    }
    public String isDisplayedZeroInCart() {
        return (syscoLabUIOgm.getText(icnCartZeroValue));
    }
    public void MoveToProductCategory() {
        syscoLabUIOgm.sleep(2);
        syscoLabUIOgm.mouseHover(lnkProductCategory);
        syscoLabUIOgm.sleep(2);
    }
    public void clickRoyalLiqueur() {
        syscoLabUIOgm.mouseHover(lnkRoyalLiqueur);
        syscoLabUIOgm.click(lnkRoyalLiqueur);
        syscoLabUIOgm.sleep(4);
    }
    public void clickAnItem() {
        syscoLabUIOgm.mouseHover(icnItem);
        syscoLabUIOgm.sleep(1);
        syscoLabUIOgm.click(icnItem);
        syscoLabUIOgm.sleep(2);
    }
    public void clickAddToCartButton() {
        syscoLabUIOgm.sleep(2);
        syscoLabUIOgm.mouseHover(btnAddToCart);
        syscoLabUIOgm.click(btnAddToCart);
        syscoLabUIOgm.sleep(2);
    }
    public boolean isDisplayedPriceInPopUp() {
        syscoLabUIOgm.sleep(1);
        return (syscoLabUIOgm.isDisplayed(txtPriceInPopUp));
    }
    public boolean isDisplayedNameInPopUP() {
        return (syscoLabUIOgm.isDisplayed(txtNameInPopUp));
    }
    public void clickCheckOut() {
        syscoLabUIOgm.mouseHover(btnCheckOut);
        syscoLabUIOgm.sleep(1);
        syscoLabUIOgm.click(btnCheckOut);
        syscoLabUIOgm.sleep(2);
    }
    public String isDisplayedOneInShoppingCart() {
        return (syscoLabUIOgm.getText(icnCartQuantity));
    }
    public boolean isDisplayedPrice() {
        return syscoLabUIOgm.isDisplayed(txtPrice);
    }
    public boolean isDisplayedName() {
        return   syscoLabUIOgm.isDisplayed(txtName);
    }
    public void clickProceedToCheckOut() {
        syscoLabUIOgm.scrollUp();
        syscoLabUIOgm.sleep(1);
        syscoLabUIOgm.click(btnProceedToCheckOut);
        syscoLabUIOgm.sleep(2);
    }
    public String isDisplayedFirstName() {
        return (syscoLabUIOgm.getAttribute(txtFirstName,value));
    }
    public String isDisplayedLastName() {
        return (syscoLabUIOgm.getAttribute(txtLastName,value));
    }
    public String isDisplayedAddress() {
        return (syscoLabUIOgm.getAttribute(txtAddress,value));
    }
    public String isDisplayedContactNumber() {
        return (syscoLabUIOgm.getAttribute(txtContactNumber,value));
    }


    public void clearFirstName() {
        syscoLabUIOgm.sleep(2);
       syscoLabUIOgm.clear(txtFirstName);
        syscoLabUIOgm.sleep(2);
    }
    public void clearLastNameName() {
        syscoLabUIOgm.clear(txtLastName);
        syscoLabUIOgm.sleep(2);
    }
    public void clearAddress1() {
        syscoLabUIOgm.scrollDown(6);
        syscoLabUIOgm.clear(txtAddress);
        syscoLabUIOgm.sleep(2);
    }
    public void clearContactNumberName() {
        syscoLabUIOgm.clear(txtContactNumber);
        syscoLabUIOgm.sleep(2);
    }
    public void clickContinue() {
        syscoLabUIOgm.click(btnContinue);
        syscoLabUIOgm.sleep(1);
    }
    public String isDisplayedEmptyErrorFirstName() {
        return (syscoLabUIOgm.getText(txtErrorForEmptyFirstName));
    }

    public String isDisplayedEmptyErrorLastName() {
        return (syscoLabUIOgm.getText(txtErrorForEmptyLastName));
    }

    public String isDisplayedEmptyErrorAddress() {
        return (syscoLabUIOgm.getText(txtErrorForEmptyAddress));
    }

    public String isDisplayedEmptyErrorContactNumber() {
        return (syscoLabUIOgm.getText(txtErrorForEmptyContactNumber));
    }
    public void enterFirstName(String firstName) {
        syscoLabUIOgm.sendKeys(txtFirstName, firstName);
        syscoLabUIOgm.sleep(1);
    }
    public void enterLastName(String lastName) {
        syscoLabUIOgm.sendKeys(txtLastName, lastName);
        syscoLabUIOgm.sleep(1);
    }

    public void enterAddress1(String address_1) {
        syscoLabUIOgm.sendKeys(txtAddress, address_1);
        syscoLabUIOgm.sleep(1);
    }

    public void enterContactNumber(String contact_number) {
        syscoLabUIOgm.sendKeys(txtContactNumber, contact_number);
        syscoLabUIOgm.sleep(1);
    }
    public void removePostCode() {
        syscoLabUIOgm.click(icnRemovePostCode);
        syscoLabUIOgm.sleep(1);
    }
    public void enterPostCode(String postCode){
        syscoLabUIOgm.sendKeys(txtPostCode, postCode);
        syscoLabUIOgm.sleep(1);
        try {
            Robot robot = new Robot();
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_ENTER);
            syscoLabUIOgm.sleep(1);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(1000);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
    public String isDisplayedDeliveryOptions() {
        return (syscoLabUIOgm.getText(txtDeliveryOptions));
    }
    public void clickContinueInDeliveryOptions() {
        syscoLabUIOgm.scrollUp();
        syscoLabUIOgm.sleep(2);
        syscoLabUIOgm.mouseHover(btnDeliveryOptionsContinue);
        syscoLabUIOgm.click(btnDeliveryOptionsContinue);
        syscoLabUIOgm.sleep(3);
    }
    public void selectPayPalOption() {
        syscoLabUIOgm.sleep(2);
        syscoLabUIOgm.mouseHover(rdBtnPayPal);
        syscoLabUIOgm.sleep(1);
        syscoLabUIOgm.click(rdBtnPayPal);
        syscoLabUIOgm.sleep(1);
    }
    public void selectAgreement() {
        syscoLabUIOgm.click(chkAgreement);
        syscoLabUIOgm.sleep(1);
    }
    public void clickPurchaseMyOrder() {
        syscoLabUIOgm.sleep(1);
        syscoLabUIOgm.click(btnPurchaseMyOrder);
        syscoLabUIOgm.sleep(3);
    }
    public String isDisplayedPayPalAccount() {
        syscoLabUIOgm.sleep(2);
        syscoLabUIOgm.scrollUp();
        syscoLabUIOgm.sleep(2);
        return (syscoLabUIOgm.getText(txtPayPal));
    }
    public void enterCCNumber(String ccNumber){
        syscoLabUIOgm.sendKeys(txtCreditCardNumber,ccNumber);
    }
    public void enterPhone(String phoneNumber){
        syscoLabUIOgm.sendKeys(txtPhone,phoneNumber);
    }
    public void selectCreditCardPayment(){
        syscoLabUIOgm.click(rdBttnCreditCard);
    }
    public void clickMonth(){
        syscoLabUIOgm.sleep(1);
        syscoLabUIOgm.click(expirationMonth);
    }
    public void clickYear(){
        syscoLabUIOgm.click(expirationYear);
    }
    public void setJanuary(){
        //syscoLabUIOgm.scrollDown(2);
        syscoLabUIOgm.sleep(1);
        syscoLabUIOgm.click(lstJan);
    }
    public void setNovember(){
        syscoLabUIOgm.click(lstNovember);
    }
    public String getEmptyCreditCardNumber(){
        return syscoLabUIOgm.getText(errorEmptyCreditCardNumber);
    }
    public String getEmptyCvvNumber(){
        return syscoLabUIOgm.getText(errorEmptyCvvNumber);
    }
    public String getErrorExpireMonth(){
        return syscoLabUIOgm.getText(errorExpiryMonth);
    }
    public Boolean isCreditCardPaymentDisplayed(){
         syscoLabUIOgm.getText(rdBttnCreditCard);
         return null;
    }
    public Boolean isPaypalPaymentDisplayed(){
        syscoLabUIOgm.getText(rdBtnPayPal);
        return null;
    }
    public void clickVisaIcon(){
        syscoLabUIOgm.click(icnCreditCardVisa);
    }
    public void enterCorrectCreditCardNoVisa(String ccNo){
        syscoLabUIOgm.sendKeys(txtCreditCard,ccNo);
    }
    public void enterCorrectCvvNoVisa(String ccNo){
        syscoLabUIOgm.sendKeys(txtCvvNumber,ccNo);
    }
    public String getEnteredCardDetails(){
        return syscoLabUIOgm.getText(txtCreditCard);
    }
    public String getEnteredCvvDetails(){
        return syscoLabUIOgm.getText(txtCvvNumber);
    }


}

