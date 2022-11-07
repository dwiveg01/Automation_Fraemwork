package com.automationqa.utilities;

import com.automationqa.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.automationqa.BaseClass.*;

public class DriverUtil {
    public void instantiateDriver() {
        if (browser.equals("CHROME")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
    }


}



