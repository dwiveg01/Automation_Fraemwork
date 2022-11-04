package com.automationqa;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import java.time.Duration;

import static com.automationqa.utilities.ConfigUtil.*;
import static com.automationqa.utilities.DriverUtil.*;


public class BaseClass {

    public static WebDriver driver;
    public static String baseUrl = getConfig("testurl");
    public static int waitTimeOut = Integer.parseInt(getConfig("waitTimeOut"));
    public static String browser = getConfig("browser");


    @BeforeTest
    public void setUp() {
        getDriver();
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        driver.quit();


    }
}
