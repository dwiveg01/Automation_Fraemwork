package com.automationqa.managers;

import com.automationqa.pageObjects.HomePage;
import com.automationqa.pageObjects.LoginPage;
import org.openqa.selenium.WebDriver;


public class PageObjectManager {

    private WebDriver localDriver;
    private LoginPage loginPage;
    private HomePage homePage;


    public PageObjectManager(WebDriver remoteDriver) {

        this.localDriver = remoteDriver;

    }

    public LoginPage loginPage() {

        return (loginPage == null) ? loginPage = new LoginPage(localDriver) : loginPage;

    }

    public HomePage homePage() {

        return (homePage == null) ? homePage = new HomePage(localDriver) : homePage;

    }
}
