package com.sysco.java_based_web_ui_automation.functions;

import com.sysco.java_based_web_ui_automation.common.Constants;
import com.sysco.java_based_web_ui_automation.pages.AccountPage;
import com.sysco.java_based_web_ui_automation.pages.LoginPage;
import com.sysco.java_based_web_ui_automation.utils.DriverSetUpUtil;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Account {
    static String email;

    public static AccountPage AccountPage = new AccountPage();

    public static void clickMyAccount(){
        AccountPage.clickMyAccount();
    }

    public static void typeEmail(String email){
        AccountPage.typeEmail(email);
    }
    public static void typePassword(String password){
        AccountPage.typePassword(password);
    }
    public static void clickSendButton(){
        AccountPage.clickSend();
    }
    public static String getEmailRequiredWarning(){
        return AccountPage.getEmailRequiredWarning();
    }
    public static String getPasswordRequiredWarning(){
        return AccountPage.getPasswordRequiredWarning();
    }
    public static String getInvalidEmailWarning(){
        return AccountPage.getInvalidEmailWarning();
    }
    public static String getInvalidPasswordWarning(){
        return AccountPage.getInvalidPasswordWarning();
    }
    public static void clearEnteredEmailPassword(){
        AccountPage.clearEmailPassword();
    }
    public static String getUsername(){

        return AccountPage.getUsername().replaceAll("HELLO, ","").replaceAll("!","");
    }
    public static Boolean isMyAccountDisplayed(){
        AccountPage.isMyAccountDisplayed();
        return null;
    }

}
