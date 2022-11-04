package com.automationqa.test;

import com.automationqa.utilities.DriverUtil.*;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static com.automationqa.BaseClass.*;


public class Login {

    WebDriver localDriver;

    public Login(WebDriver remoteDriver) {
        this.localDriver=remoteDriver;
        PageFactory.initElements(localDriver, this);
    }

    @FindBy(xpath = "//span[text()='Hello, sign in']")
    WebElement signInButton;

    @FindBy(id = "ap_email")
    WebElement userIdTextBox;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(id = "ap_password")
    WebElement passwordTextBox;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    WebElement userLoginConfirmation;


    public void TC001_User_LoggedInConfirmation_Test(String emailId, String password) throws InterruptedException {
        Thread.sleep(3000);
        signInButton.click();
        Thread.sleep(3000);
        userIdTextBox.sendKeys(emailId);
        continueButton.click();
        Thread.sleep(3000);
        passwordTextBox.sendKeys(password);
        Thread.sleep(3000);
        continueButton.click();
        Thread.sleep(10000);
        String userGreeting = userLoginConfirmation.getText();
        Assertions.assertThat(userGreeting).isEqualTo("Hello, Gaurav").describedAs("User successfully Logged in");

    }


}
