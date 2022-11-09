package com.automationqa.testCases;
import com.automationqa.BaseClass;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;



public class LoginTest extends BaseClass {


    @Test()
    public void loginTest() {

        loginPage.enterUserName(userID);
        loginPage.enterPassword(password);
        loginPage.clickOnLogin();
        String pageTitle = driver.getTitle();
        Assertions.assertThat(pageTitle).isEqualTo("Guru99 Bank Manager HomePage");
    }


}
