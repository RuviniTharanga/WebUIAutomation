package com.sysco.java_based_web_ui_automation.pages;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

/**
 * Created by Rifad on 5/21/18.
 */
public class AccountPage extends LoginPage{

    private By btnMyAccount = By.xpath("//*[@id=\"quick-access-list\"]/li[1]/ul/li[2]/ul");
    private By txtEmail = By.id("email");
    private By txtPassword = By.id("pass");
    private By btnSend = By.id("send2");
    private By lblEmailRequired = By.id("advice-required-entry-email");
    private By lblPasswordRequired = By.id("advice-required-entry-pass");
    private By messageInvalidEmail = By.id("advice-validate-email-email");
    private By messageInvalidPassword = By.id("advice-validate-password-pass");
    private By lblusername = By.xpath("/html/body/div[2]/div[3]/div[2]/div[1]/div/div[3]/div[1]/h2");

    public void clickMyAccount(){
        syscoLabUIOgm.sleep(3);
        syscoLabUIOgm.click(btnMyAccount);
    }
    public void clickSend(){
        syscoLabUIOgm.click(btnSend);
    }
    public String getEmailRequiredWarning(){
        return syscoLabUIOgm.getText(lblEmailRequired);
    }
    public String getPasswordRequiredWarning(){
        return syscoLabUIOgm.getText(lblPasswordRequired);
    }
    public String getInvalidEmailWarning(){
        return syscoLabUIOgm.getText(messageInvalidEmail);
    }
    public String getInvalidPasswordWarning(){
        return syscoLabUIOgm.getText(messageInvalidPassword);
    }
    public void typeEmail(String email){
        syscoLabUIOgm.sendKeys(txtEmail,email);
    }
    public void typePassword(String password){
        syscoLabUIOgm.sendKeys(txtPassword,password);
    }
    public void clearEmailPassword(){
        syscoLabUIOgm.clear(txtEmail);
        syscoLabUIOgm.clear(txtPassword);
    }
    public String getUsername(){
        //System.out.println(syscoLabUIOgm.getText(lblusername));
        return syscoLabUIOgm.getText(lblusername);
    }




}

