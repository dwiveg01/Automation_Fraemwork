package com.automationqa;

import com.automationqa.utilities.test.Login;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.automationqa.utilities.ConfigUtil.*;


public class BaseClass {

    public static WebDriver driver;
    public static String baseUrl = getConfig("testurl");
    public static int waitTimeOut = Integer.parseInt(getConfig("waitTimeOut"));
    public static String browser = getConfig("browser");



    public static void commonProperty()
    {
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTimeOut));
    }


    @Test
    public static void setup() throws InterruptedException {

        if (browser.equalsIgnoreCase("CHROME")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            commonProperty();
            Login login=new Login(driver);
            login.TC001_User_LoggedInConfirmation_Test("gaurav.dwivedy94@gmail.com","Stockholm@1245");

        } else if (browser.equalsIgnoreCase("FIREFOX")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            commonProperty();
        } else if (browser.equalsIgnoreCase("IE")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new InternetExplorerDriver();
            commonProperty();
        }


    }

@AfterMethod
    public static void tearDown()
    {
        driver.quit();
    }


}
