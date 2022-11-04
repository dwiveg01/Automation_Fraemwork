package com.automationqa.test;

import com.automationqa.BaseClass;
import org.testng.annotations.Test;
import static com.automationqa.utilities.DriverUtil.*;

public class TestCases extends BaseClass {
    Login login=new Login(getDriver());

    @Test
    public void test1_login_Confirmation() throws InterruptedException {

        login.TC001_User_LoggedInConfirmation_Test("gaurav.dwivedy94@gmail.com","Test1234");

    }


}
