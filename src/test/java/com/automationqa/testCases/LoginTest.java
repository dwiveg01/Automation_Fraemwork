package com.automationqa.testCases;

import com.automationqa.BaseClass;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import static com.automationqa.utilities.ConfigUtil.randomWords;


public class LoginTest extends BaseClass {


    @Test(enabled = false)
    public void loginTest() {

        loginPage.enterUserName(userID);
        loginPage.enterPassword(password);
        loginPage.clickOnLogin();
        String pageTitle = driver.getTitle();
        Assertions.assertThat(pageTitle).isEqualTo("Guru99 Bank Manager HomePage");
    }

    @Test
    public void registrationTest() throws InterruptedException {
        loginPage.clickOnRegisterLink();
        loginPage.selectMaleGender();
        loginPage.firstNameTextBox("Gaurav");
        loginPage.lastNameTextBox("Dwivedy");
        loginPage.selectDateOfBirth("5");
        Thread.sleep(3000);
        loginPage.selectBirthMonth("November");
        loginPage.selectBirthYear("1994");
        String emaild=randomWords()+"@gmail.com";
        System.out.println("The email id is="+emaild);
        loginPage.enterEmailId(emaild);
        loginPage.enterCompanyName("TATA");
        loginPage.enterPasswordReg("Test1234");
        Thread.sleep(3000);
        loginPage.enterConfirmPasswordReg("Test1234");
        loginPage.clickOnRegisterButton();
        String response=loginPage.getSuccRegistartionResponse();
        Assertions.assertThat(response).isEqualTo("Your registration completed").describedAs("Registered successfully");


    }


}
