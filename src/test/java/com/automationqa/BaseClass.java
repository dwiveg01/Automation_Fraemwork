package com.automationqa;

import com.automationqa.managers.PageObjectManager;
import com.automationqa.pageObjects.HomePage;
import com.automationqa.pageObjects.LoginPage;
import com.automationqa.utilities.DriverUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import java.sql.Driver;
import java.time.Duration;

import static com.automationqa.utilities.ConfigUtil.*;
import static com.automationqa.utilities.DriverUtil.*;


public class BaseClass {

    public static WebDriver driver;


    public HomePage homePage;
    public LoginPage loginPage;


    public static String baseURL = getConfig("baseURL");
    public static int waitTimeOut = Integer.parseInt(getConfig("waitTimeOut"));
    public static String browser = getConfig("browser");
    public static String userID = getConfig("userId");
    public static String password = getConfig("password");


    @BeforeTest
    public void setUp() {
        DriverUtil driverUtil = new DriverUtil();
        driverUtil.instantiateDriver();
        objectInitializer();
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTimeOut));
    }

    public void objectInitializer() {
        PageObjectManager objectManager = new PageObjectManager(driver);
        loginPage = objectManager.loginPage();
        homePage = objectManager.homePage();

    }

    @AfterTest
    public static void tearDown() throws InterruptedException {
        driver.quit();


    }
}
