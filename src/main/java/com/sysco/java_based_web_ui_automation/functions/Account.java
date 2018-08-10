package com.sysco.java_based_web_ui_automation.functions;

import com.sysco.java_based_web_ui_automation.common.Constants;
import com.sysco.java_based_web_ui_automation.pages.AccountPage;
import com.sysco.java_based_web_ui_automation.pages.LoginPage;
import com.sysco.java_based_web_ui_automation.utils.DriverSetUpUtil;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Rifad on 5/21/18.
 */
public class Account {
    static String email;

    public static AccountPage ogmAccountPage = new AccountPage();

    public static void clickMyAccount(){
        ogmAccountPage.clickMyAccount();
    }

    public static void typeEmail(String email){
        ogmAccountPage.typeEmail(email);
    }
    public static void typePassword(String password){
        ogmAccountPage.typePassword(password);
    }
    public static void clickSendButton(){
        ogmAccountPage.clickSend();
    }
    public static String getEmailRequiredWarning(){
        return ogmAccountPage.getEmailRequiredWarning();
    }
    public static String getPasswordRequiredWarning(){
        return ogmAccountPage.getPasswordRequiredWarning();
    }
    public static String getInvalidEmailWarning(){
        return ogmAccountPage.getInvalidEmailWarning();
    }
    public static String getInvalidPasswordWarning(){
        return ogmAccountPage.getInvalidPasswordWarning();
    }
    public static void clearEnteredEmailPassword(){
        ogmAccountPage.clearEmailPassword();
    }
    public static String getUsername(){
        //System.out.println(ogmAccountPage.getUsername().replaceAll("HELLO, ","").replaceAll("!",""));
        return ogmAccountPage.getUsername().replaceAll("HELLO, ","").replaceAll("!","");
    }

}
