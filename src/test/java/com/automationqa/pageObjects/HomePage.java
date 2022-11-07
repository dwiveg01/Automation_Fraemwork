package com.automationqa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver localDriver;

    public HomePage(WebDriver remoteDriver) {
        this.localDriver = remoteDriver;
        PageFactory.initElements(localDriver, this);
    }
}
