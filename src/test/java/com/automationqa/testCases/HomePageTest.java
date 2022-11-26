package com.automationqa.testCases;

import com.automationqa.BaseClass;
import org.testng.annotations.Test;

import java.util.HashMap;

public class HomePageTest extends BaseClass {

    @Test(dataProviderClass = DataProviders.class,dataProvider = "homePageTest1")
    public void homePageTest(HashMap<String, String> input) {

        //loginPage.enterUserName(input.get("userid"));
        // loginPage.enterPassword(input.get("password"));
        System.out.println("The age on home page  is" + input.get("age"));
        System.out.println("The name on home page  is" + input.get("Name"));
        System.out.println("The user on home page  is" + input.get("userid"));
        System.out.println("The password on home page  is" + input.get("password"));

    }
}