package com.automationqa.testCases;

import com.automationqa.BaseClass;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;



public class DataProviders extends BaseClass {
    @DataProvider(name = "loginTest1")
    public Object[][] getLoginTest1Data() throws IOException {
        String testDataPath="src/test/java/com/automationqa/testData/loginTest.json";
        List<HashMap<String, String>> data = getJsonDataToMap(testDataPath);
        return new Object[][]{{data.get(0)}, {data.get(1)}};


    }

    @DataProvider(name = "homePageTest1")
    public Object[][] getHomePageTest1Data() throws IOException {
        String testDataPath="src/test/java/com/automationqa/testData/homePageTest.json";
        List<HashMap<String, String>> data = getJsonDataToMap(testDataPath);
        return new Object[][]{{data.get(0)}, {data.get(1)}};


    }
}
