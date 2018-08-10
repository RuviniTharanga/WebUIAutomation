package com.sysco.java_based_web_ui_automation.pages;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

/**
 * Created by Rifad on 5/21/18.
 */
public class LoginPage {
    protected static SyscoLabUI syscoLabUIOgm;
    private By txtGoogleSearch = By.id("lst-ib");
    private By drpDate = By.id("age_select_day");
    private By drpMonth = By.id("age_select_month");
    private By drpYear = By.id("age_select_year");
    private By setDate = By.xpath("//*[@id=\"age_select_day\"]/option[26]");
    private By setMonth = By.xpath("//*[@id=\"age_select_month\"]/option[4]");
    private By setYear1 = By.xpath("//*[@id=\"age_select_year\"]/option[2]");
    private By setYear2 = By.xpath("//*[@id=\"age_select_year\"]/option[17]");
    private By btnEnter = By.id("age_confirm_btn");
    //private By drpCountry1 = By.id("age_select_country");
    private By drpCountry = By.xpath("//*[@id=\"age_select_country\"]");
    private By errorEntering = By.xpath("//*[@id=\"age_missing_message\"]/span");



    public static void loadLoginPage(Capabilities capabilities, String url) {
        syscoLabUIOgm = new SyscoLabWUI(capabilities);
        syscoLabUIOgm.navigateTo(url);
        syscoLabUIOgm.driver.manage().window().maximize();
    }

    public void quitDriver() {
        if (syscoLabUIOgm != null) {
            syscoLabUIOgm.quit();
        }
    }


//    public void enterText(String searchString) {
//        syscoLabUIOgm.sendKeys(txtGoogleSearch, searchString);
//    }

     public void clickDate(){
        syscoLabUIOgm.click(drpDate);
    }
    public void typeDate(){
        syscoLabUIOgm.click(setDate);
    }
    public void clickMonth(){
        syscoLabUIOgm.click(drpMonth);
    }
    public void typeMonth(){
        syscoLabUIOgm.click(setMonth);
    }public void clickYear(){
        syscoLabUIOgm.click(drpYear);
    }
    public void typeYear(){
        syscoLabUIOgm.click(setYear1);
    }
    public void typeYear2(){
        syscoLabUIOgm.click(setYear2);
    }
    public void clickEnter(){
        syscoLabUIOgm.click(btnEnter);
    }

    public String getError(){
        return syscoLabUIOgm.getText(errorEntering);
    }
    public String getCountry(){
        return syscoLabUIOgm.getText(drpCountry);
    }



}

