package com.sysco.java_based_web_ui_automation.functions;

import com.sysco.java_based_web_ui_automation.pages.AccountPage;
import com.sysco.java_based_web_ui_automation.pages.CartPage;

/**
 * Created by Rifad on 5/21/18.
 */
public class Cart {

    public static CartPage cartPage = new CartPage();

    public static void clickCartIcon(){
        cartPage.clickCartIcon();
    }
    public static void clickRemoveLink() {
        cartPage.clickRemoveLink();
    }
    public static String isDisplayedZeroInCart() {
        return  cartPage.isDisplayedZeroInCart();
    }
    public static void MoveToProductCategory() {
        cartPage.MoveToProductCategory();
    }
    public static void clickRoyalLiqueur() {
        cartPage.clickRoyalLiqueur();
    }
    public static void clickAnItem() {
        cartPage.clickAnItem();
    }
    public static void clickAddToCartButton() {
        cartPage.clickAddToCartButton();
    }
    public static boolean isDisplayedPriceInPopUp() {
        return  cartPage.isDisplayedPriceInPopUp();
    }
    public static boolean isDisplayedNameInPopUP() {
        return  cartPage.isDisplayedNameInPopUP();
    }
    public static void clickCheckOut() {
        cartPage.clickCheckOut();
    }
    public static String isDisplayedOneInShoppingCart() {
        return  cartPage.isDisplayedOneInShoppingCart();
    }
    public static boolean isDisplayedPrice() {
        return cartPage.isDisplayedPrice();
    }
    public static boolean isDisplayedName() {
        return   cartPage.isDisplayedName();
    }
    public static void clickProceedToCheckOut() {
        cartPage.clickProceedToCheckOut();
    }
    public static String isDisplayedFirstName() {
        return  cartPage.isDisplayedFirstName();
    }
    public static String isDisplayedLastName() {
        return  cartPage.isDisplayedLastName();
    }
    public static String isDisplayedAddress() {
        return  cartPage.isDisplayedAddress();
    }

    public static String isDisplayedContactNumber() {

        return  cartPage.isDisplayedContactNumber();
    }

    public static void clearFirstName() {
        cartPage.clearFirstName();
    }
    public static void clearLastNameName() {
        cartPage.clearLastNameName();
    }
    public static void clearAddress1() {
        cartPage.clearAddress1();
    }
    public static void clearContactNumberName() {
        cartPage.clearContactNumberName();
    }
    public static void clickContinue() {
        cartPage.clickContinue();
    }
    public static String isDisplayedEmptyErrorFirstName() {
        return  cartPage.isDisplayedEmptyErrorFirstName();
    }
    public static String isDisplayedEmptyErrorLastName() {
        return  cartPage.isDisplayedEmptyErrorLastName();
    }
    public static String isDisplayedEmptyErrorAddress() {
        return  cartPage.isDisplayedEmptyErrorAddress();
    }

    public static String isDisplayedEmptyErrorContactNumber() {
        return  cartPage.isDisplayedEmptyErrorContactNumber();
    }
    public static void enterFirstName(String firstName)  {
        cartPage.enterFirstName(firstName);
    }

    public static void enterLastName(String lastName)  {
        cartPage.enterLastName(lastName);
    }

    public static void enterAddress1(String address1)  {

        cartPage.enterAddress1(address1);
    }

    public static void enterContactNumber(String contactNumber)  {
        cartPage.enterContactNumber(contactNumber);

    }
    public static void removePostCode() {
        cartPage.removePostCode();
    }
    public static void enterPostCode(String postCode){
        cartPage.enterPostCode(postCode);
    }
    public static String isDisplayedDeliveryOptions() {
        return  cartPage.isDisplayedDeliveryOptions();
    }
    public static void clickContinueInDeliveryOptions() {
        cartPage.clickContinueInDeliveryOptions();
    }
    public static void selectPayPalOption() {
        cartPage.selectPayPalOption();
    }
    public static void selectAgreement() {
        cartPage.selectAgreement();
    }
    public static void clickPurchase() {
        cartPage.clickPurchase();
    }
    public static String isDisplayedPayPalAccount() {
        return  cartPage.isDisplayedPayPalAccount();
    }

}
