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

    public static AccountPage ogmAccountPage = new AccountPage();

    public static void clickMyAccount(){
        ogmAccountPage.clickMyAccount();
    }
    public static void ttest(){
        ogmAccountPage.test();
    }
}
