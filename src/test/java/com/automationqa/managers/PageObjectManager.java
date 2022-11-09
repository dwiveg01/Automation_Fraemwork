package com.automationqa.managers;

import com.automationqa.pageObjects.HomePage;
import com.automationqa.pageObjects.LoginPage;



public class PageObjectManager {


    private LoginPage loginPage;
    private HomePage homePage;


    public LoginPage loginPage() {

        return (loginPage == null) ? loginPage = new LoginPage() : loginPage;

    }

    public HomePage homePage() {

        return (homePage == null) ? homePage = new HomePage() : homePage;

    }
}
