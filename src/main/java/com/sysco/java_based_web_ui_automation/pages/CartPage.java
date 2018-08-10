package com.sysco.java_based_web_ui_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

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
    private static By lnkProdCat =By.xpath("//*[@id=\"nav-wrapper\"]/div/div[4]/div[1]/div[1]/ul/li/ul/li[1]/a");
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
    private static By txtContactNumber =By.id("billing:telephone");
    private static By btnContinue =By.id("delivery-address-button");
    private static By txtValidationForEmptyFirstName =By.id("advice-required-entry-billing:firstname");
    private static By txtValidationForEmptyLastName =By.id("advice-required-entry-billing:lastname");
    private static By txtValidationForEmptyAddress =By.id("advice-required-entry-billing:street1");
    private static By txtValidationForEmptyContactNumber =By.id("advice-required-entry-billing:telephone");
    private static By txtPostCode =By.id("billing:postcodesuburb");
    private static By icnRemovePostCode =By.id("billing:postcodesuburbremove");
    private static By txtDeliveryOptions =By.xpath("//h2[.='Delivery Options']");
    private static By btnDeliveryOptionsContinue =By.xpath("//button[@id='shipping-method-button']");
    private static By rdBtnPayPal =By.xpath("//dl[@id='checkout-payment-method-load']/div[2]/dt/label");
    private static By chkAgreement =By.id("agreement-1");
    private static By btnPurchase =By.id("payment-method-button");
    private static By txtPayPal =By.id("pageTitle");


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
//        for (int i = 1; i <= 8; i++) {
//            syscoLabUIOgm.sendKeys(txtFirstName, Keys.ARROW_RIGHT);
//            syscoLabUIOgm.sendKeys(txtFirstName, Keys.BACK_SPACE);
//        }
        syscoLabUIOgm.clear(txtFirstName);
        syscoLabUIOgm.sleep(2);
    }
    public void clearLastNameName() {
//        syscoLabUIOgm.click(txtLastName);
//        for (int i = 1; i <= 8; i++) {
//            syscoLabUIOgm.sendKeys(txtLastName, Keys.BACK_SPACE);
//        }
        syscoLabUIOgm.clear(txtLastName);
        syscoLabUIOgm.sleep(2);
    }
    public void clearAddress1() {
        syscoLabUIOgm.scrollDown(6);
//        syscoLabUIOgm.click(txtAddress);
//        for (int i = 1; i <= 8; i++) {
//            syscoLabUIOgm.sendKeys(txtAddress, Keys.BACK_SPACE);
//        }
        syscoLabUIOgm.clear(txtAddress);
        syscoLabUIOgm.sleep(2);
    }
    public void clearContactNumberName() {
//        syscoLabUIOgm.click(txtContactNumber);
//        for (int i = 1; i <= 15; i++) {
//            syscoLabUIOgm.sendKeys(txtContactNumber, Keys.BACK_SPACE);
//        }
        syscoLabUIOgm.clear(txtContactNumber);
        syscoLabUIOgm.sleep(2);
    }
    public void clickContinue() {
        syscoLabUIOgm.click(btnContinue);
        syscoLabUIOgm.sleep(1);
    }
    public String isDisplayedEmptyErrorFirstName() {
        return (syscoLabUIOgm.getText(txtValidationForEmptyFirstName));
    }

    public String isDisplayedEmptyErrorLastName() {
        return (syscoLabUIOgm.getText(txtValidationForEmptyLastName));
    }

    public String isDisplayedEmptyErrorAddress() {
        return (syscoLabUIOgm.getText(txtValidationForEmptyAddress));
    }

    public String isDisplayedEmptyErrorContactNumber() {
        return (syscoLabUIOgm.getText(txtValidationForEmptyContactNumber));
    }
    public void enterFirstName(String first_name) {
        syscoLabUIOgm.sendKeys(txtFirstName, first_name);
        syscoLabUIOgm.sleep(1);
    }
    public void enterLastName(String last_name) {
        syscoLabUIOgm.sendKeys(txtLastName, last_name);
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
    public void clickPurchase() {
        syscoLabUIOgm.sleep(1);
        syscoLabUIOgm.click(btnPurchase);
        syscoLabUIOgm.sleep(3);
    }
    public String isDisplayedPayPalAccount() {
        syscoLabUIOgm.sleep(2);
        syscoLabUIOgm.scrollUp();
        syscoLabUIOgm.sleep(2);
        return (syscoLabUIOgm.getText(txtPayPal));
    }

}

