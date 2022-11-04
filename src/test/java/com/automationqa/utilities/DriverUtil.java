package com.automationqa.utilities;

import com.automationqa.BaseClass;
import com.automationqa.test.TestCases;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static com.automationqa.BaseClass.*;

import java.time.Duration;

public class DriverUtil {


    public static WebDriver getDriver() {
        if (browser.equalsIgnoreCase("CHROME")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            commonProperty();
        } else if (browser.equalsIgnoreCase("FIREFOX")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            commonProperty();
        } else if (browser.equalsIgnoreCase("IE")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new InternetExplorerDriver();
            commonProperty();
        }

        return driver;
    }

    public static void commonProperty() {
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTimeOut));
    }


}




