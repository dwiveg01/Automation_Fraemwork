package com.automationqa.testCases;

import com.automationqa.BaseClass;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class LoginTest extends BaseClass {






    @Test(dataProviderClass = DataProviders.class,dataProvider = "loginTest1")
    public void loginTest(HashMap<String, String> input) {

        //loginPage.enterUserName(input.get("userid"));
       // loginPage.enterPassword(input.get("password"));

        System.out.println("The name is" + input.get("Name"));
        System.out.println("The user is" + input.get("userid"));
        System.out.println("The password is" + input.get("password"));

//        loginPage.clickOnLogin();
//        String pageTitle = driver.getTitle();
//        Assertions.assertThat(pageTitle).isEqualTo("Guru99 Bank Manager HomePage");
    }


    @Test(dataProviderClass = DataProviders.class,dataProvider = "homePageTest")
    public void homePageTest1(HashMap<String, String> input) {

        //loginPage.enterUserName(input.get("userid"));
        // loginPage.enterPassword(input.get("password"));
        System.out.println("The age on home page  is" + input.get("age"));
        System.out.println("The name on home page  is" + input.get("Name"));
        System.out.println("The user on home page  is" + input.get("userid"));
        System.out.println("The password on home page  is" + input.get("password"));

//        loginPage.clickOnLogin();
//        String pageTitle = driver.getTitle();
//        Assertions.assertThat(pageTitle).isEqualTo("Guru99 Bank Manager HomePage");
    }

}



