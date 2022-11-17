package com.automationqa.testCases;

import com.automationqa.BaseClass;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class LoginTest extends BaseClass {

    public static String dataPath="src/test/java/com/automationqa/testData/LoginData.json";
    @DataProvider(name = "testdatalogin")
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(dataPath);
        return new Object[][]  {{data.get(0)}, {data.get(1)}};


    }



    @Test(dataProvider = "testdatalogin")
    public void loginTest(HashMap<String, String> input) {

        loginPage.enterUserName(input.get("userid"));
        loginPage.enterPassword(input.get("password"));
        loginPage.clickOnLogin();
        String pageTitle = driver.getTitle();
        Assertions.assertThat(pageTitle).isEqualTo("Guru99 Bank Manager HomePage");
    }


}



