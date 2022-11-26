package com.automationqa;

import com.automationqa.managers.PageObjectManager;
import com.automationqa.pageObjects.HomePage;
import com.automationqa.pageObjects.LoginPage;
import com.automationqa.utilities.DriverUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import static com.automationqa.utilities.PropertyUtil.*;


public class BaseClass {

    public static WebDriver driver;


    public HomePage homePage;
    public LoginPage loginPage;


    public static String baseURL = getProperty("baseURL");
    public static int waitTimeOut = Integer.parseInt(getProperty("waitTimeOut"));
    public static String browser = getProperty("browser");
   // public static String userID = getProperty("userId");
   // public static String password = getProperty("password");
   // public static String testDataPath="src/test/java/com/automationqa/testData/.*";


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
        if (driver != null) {
            driver.quit();
        }

    }


    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {

        String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {

        });
        return data;


    }
}
