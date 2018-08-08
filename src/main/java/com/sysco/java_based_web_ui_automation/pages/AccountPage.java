package com.sysco.java_based_web_ui_automation.pages;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

/**
 * Created by Rifad on 5/21/18.
 */
public class AccountPage {
    protected static SyscoLabUI syscoLabUIOgm;

    private By btnMyAccount = By.xpath("//*[@id=\"quick-access-list\"]/li[1]/ul/li[2]/ul");
    private By btnCart = By.id("search-button");

    public void clickMyAccount(){
        syscoLabUIOgm.sleep(3);
        syscoLabUIOgm.click(btnMyAccount);
    }
    public void test(){
        System.out.println("***");
    }



}

