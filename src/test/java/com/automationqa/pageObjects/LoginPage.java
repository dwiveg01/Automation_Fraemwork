package com.automationqa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.automationqa.utilities.ElementUtil.getElement;


public class LoginPage {


    WebElement userId = getElement("user");
    WebElement password = getElement("password1");
    WebElement loginbtnXpath = getElement("loginButton");


    public void enterUserName(String username) {
        userId.sendKeys(username);
    }

    public void enterPassword(String password1) {
        password.sendKeys(password1);
    }
    public void clickOnLogin() {
        loginbtnXpath.click();
    }
}
