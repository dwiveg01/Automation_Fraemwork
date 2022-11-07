package com.automationqa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


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

    @FindBy(xpath = "//a[text()='Register']")
    WebElement register;

    @FindBy(id = "gender-male")
    WebElement radioButtonForMale;
    @FindBy(id = "FirstName")
    WebElement firstNameTextBox;

    @FindBy(id = "LastName")
    WebElement lastNameNameTextBox;

    @FindBy(name = "DateOfBirthDay")
    WebElement dateOfBirth;

    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    WebElement birthMonth;

    @FindBy(xpath = "//select[@name='DateOfBirthMonth']//option")
    List<WebElement> monthOptions;

    @FindBy(name = "DateOfBirthYear")
    WebElement birthYear;

    @FindBy(id = "Email")
    WebElement emaild;

    @FindBy(id = "Company")
    WebElement companyTextBox;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(id = "Password")
    WebElement ConfirmPassword;

    @FindBy(id = "register-button")
    WebElement registerButton;

    @FindBy(xpath = "//div[text()='Your registration completed']")
    WebElement succRegistration;


    public void enterUserName(String username) {
        userId.sendKeys(username);
    }

    public void enterPassword(String password) {
        pass.sendKeys(password);
    }

    public void clickOnLogin() {
        login.click();
    }

    public void clickOnRegisterLink() {
        register.click();
    }

    public void selectMaleGender() {
        radioButtonForMale.click();
    }

    public void firstNameTextBox(String firstName) {
        firstNameTextBox.sendKeys(firstName);
    }

    public void lastNameTextBox(String lastName) {
        lastNameNameTextBox.sendKeys(lastName);
    }

    public void selectDateOfBirth(String date) {
        Select select = new Select(dateOfBirth);
        select.selectByValue(date);
    }

    public void selectBirthMonth(String month) {

        birthMonth.click();
        List<WebElement> allMonthOptions = monthOptions;
        System.out.println(allMonthOptions.size());
        for (int i = 0; i <= allMonthOptions.size() - 1; i++) {
            if (allMonthOptions.get(i).getText().contains(month)) {
                allMonthOptions.get(i).click();
                break;
            }
        }
    }

    public void selectBirthYear(String year) {
        Select select = new Select(birthYear);
        select.selectByValue(year);
    }

    public void enterEmailId(String emailId) {
        emaild.sendKeys(emailId);
    }

    public void enterCompanyName(String companyName) {
        companyTextBox.sendKeys(companyName);
    }

    public void enterPasswordReg(String regPassword) {
        password.sendKeys(regPassword);
    }

    public void enterConfirmPasswordReg(String conPassword) {

        ConfirmPassword.sendKeys(conPassword);
    }

    public void clickOnRegisterButton() {
        registerButton.click();
    }

    public String getSuccRegistartionResponse() {
        String response = succRegistration.getText();
        return response;
    }


}
