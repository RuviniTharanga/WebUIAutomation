package com.sysco.java_based_web_ui_automation.functions;

import com.sysco.java_based_web_ui_automation.common.Constants;
import com.sysco.java_based_web_ui_automation.pages.LoginPage;
import com.sysco.java_based_web_ui_automation.utils.DriverSetUpUtil;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class Login  {

    public static LoginPage LoginPage = new LoginPage();


    public static void loadLoginPage() {

        if (Constants.RUN_LOCALLY) {
            DriverSetUpUtil.setToRunLocally();
            DesiredCapabilities capabilities = null;
            LoginPage.loadLoginPage(capabilities, Constants.APP_URL);
        } else {
            LoginPage.loadLoginPage(DriverSetUpUtil.setToRunRemotely(Constants.APP_OS), Constants.APP_URL);
        }
    }


    public static void quiteDriver() {
        LoginPage.quitDriver();
    }

    public static void loginToFtr() {

    }
    public static void setBirthdayBelow18(){
        LoginPage.clickDate();
        LoginPage.typeDate();
        LoginPage.clickMonth();
        LoginPage.typeMonth();
        LoginPage.clickYear();
        LoginPage.typeYear();
        LoginPage.clickEnter();
    }
    public static String getError(){
       return LoginPage.getError();
    }

    public static void setBirthdayOver18(){
        LoginPage.clickDate();
        LoginPage.typeDate();
        LoginPage.clickMonth();
        LoginPage.typeMonth();
        LoginPage.clickYear();
        LoginPage.typeYear2();
        LoginPage.clickEnter();
    }
    public static String getCountry(){
        return LoginPage.getCountry();
    }
    public static void setDifferentCountry(){
        LoginPage.setDifferentCountry();
    }

}
