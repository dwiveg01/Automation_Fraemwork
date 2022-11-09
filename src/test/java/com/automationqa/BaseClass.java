package com.automationqa;

import com.automationqa.managers.PageObjectManager;
import com.automationqa.pageObjects.HomePage;
import com.automationqa.pageObjects.LoginPage;
import com.automationqa.utilities.DriverUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.time.Duration;
import static com.automationqa.utilities.PropertyUtil.*;



public class BaseClass {

    public static WebDriver driver;



    public HomePage homePage;
    public LoginPage loginPage;


    public static String baseURL = getProperty("baseURL");
    public static int waitTimeOut = Integer.parseInt(getProperty("waitTimeOut"));
    public static String browser = getProperty("browser");
    public static String userID = getProperty("userId");
    public static String password = getProperty("password");


    PageObjectManager objectManager;
    @BeforeMethod
    public void setUp() {
        DriverUtil driverUtil = new DriverUtil();
        driverUtil.instantiateDriver();
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTimeOut));
        objectInitializer();
    }

    public void objectInitializer() {
        objectManager = new PageObjectManager();
        loginPage = objectManager.loginPage();
        homePage = objectManager.homePage();

    }

    @AfterMethod
    public static void tearDown() throws InterruptedException {
        driver.quit();


    }
}
