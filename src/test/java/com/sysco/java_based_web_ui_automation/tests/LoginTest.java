package com.sysco.java_based_web_ui_automation.tests;


import com.sysco.java_based_web_ui_automation.data.LoginData;
import com.sysco.java_based_web_ui_automation.functions.Account;
import com.sysco.java_based_web_ui_automation.functions.Login;
import com.sysco.java_based_web_ui_automation.pages.LoginPage;
import com.sysco.java_based_web_ui_automation.utils.ExcelUtil;
import com.sysco.java_based_web_ui_automation.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class LoginTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {

        iTestContext.setAttribute("feature", "Bundabergrum - Checkout");
    }

    @Test
    public void testLogin() throws Exception {

        // Sample way to retrive data from excel
        //LoginData loginData = ExcelUtil.getLoginData("$as238l");

        //UI Automation  sample
        SoftAssert softAssert = new SoftAssert();
        Login.loadLoginPage();
        Login.setBirthdayBelow18();
        softAssert.assertEquals(Login.getError(),"Sorry, your age or location does not permit you to enter at this time.");
        Login.setBirthdayOver18();
        Login.clickMyAccount();
        //Account.ttest();
        //Login.quiteDriver();
        softAssert.assertAll();

    }
}