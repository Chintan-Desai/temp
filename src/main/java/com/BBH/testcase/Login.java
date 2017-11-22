package com.BBH.testcase;

import com.BBH.buisnessfunctions.Generic;
import com.BBH.utils.CommonFunctions;
import com.BBH.utils.Constants;
import com.BBH.utils.objrep;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Login extends CommonFunctions{

    static String methodName;
    public static HashMap<String, String> hm;
    public int nRowCount = 0;
    @BeforeMethod
    public void init() throws Exception
    {
        String bname =browserValue();
        initiateWebDriver(bname);
        methodName = "Login";
        System.out.println(methodName);

    }
    @Test
    public void LoginTest() throws Exception {
        nRowCount = 0;
        Generic oGeneric = new Generic();
        try {
            hm = GetDataFromExcel("BBH.xlsx", "Select * from TestData where TC = 'Login'");
            nRowCount++;
            Report("START --> Test Case Login & Logout functionality ", " Login & Logout functionality should work fine ", " Login & Logout Scenrios works functionality ", Constants.INFO);
            oGeneric.TPlogin();
            Click(objrep.Login.Continue, "Continue Tab");
            AssertTrue(hm.get("Value1" + nRowCount),GetText(objrep.Login.sWelcome, "Welcome Text"), "Welcome Text");
            Click(objrep.Login.Logout, "Logout button");
            Report("End --> Test Case Login & Logout functionality", "Verify Login & Logout functionality ", "Login & Logout Scenario works functionality", Constants.INFO);
        } catch (Exception e) {
            try {
                Report("Login & Logout functionality" +new Object(){}.getClass().getEnclosingMethod().getName()+ " encountered any exceptions","Login & Logout functionality should Verified without any errors"," Login & Logout functionality verification Failed an exception has occured " + getStackTrace(e),Constants.FAIL);
                e.printStackTrace();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    @BeforeSuite
    public static void setUpBeforeClass() throws Exception {
        ReadMainConfigData();
        beforeMethod(methodName);
    }
    @AfterMethod
    public void tearDown() throws Exception {
        String methodName = "Login & Logout";
        aftermethod(methodName);
        Thread.sleep(8000);
        closeBrowser();
    }
}
