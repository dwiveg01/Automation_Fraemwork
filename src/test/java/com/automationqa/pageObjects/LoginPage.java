package com.automationqa.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    WebDriver localDriver;

    public LoginPage(WebDriver remoteDriver) {
        this.localDriver = remoteDriver;
        PageFactory.initElements(localDriver, this);
    }
    @FindBy(name = "uid")
    WebElement userId;

    @FindBy(name = "password")
    WebElement pass;

    @FindBy(name = "btnLogin")
    WebElement login;

    public void enterUserName(String username){
        userId.sendKeys(username);
    }
    public void enterPassword(String password){
        pass.sendKeys(password);
    }
    public void clickOnLogin(){
        login.click();
    }

}
