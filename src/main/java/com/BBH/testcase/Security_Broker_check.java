package com.BBH.testcase;

import java.util.HashMap;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.BBH.buisnessfunctions.Generic;
import com.BBH.utils.CommonFunctions;
import com.BBH.utils.Constants;
import com.BBH.utils.objrep;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Security_Broker_check extends CommonFunctions{

	static String methodName;
    public static HashMap<String, String> hm;
    public int nRowCount = 0;
    @BeforeMethod
    public void init() throws Exception
    {
    		methodName = "Security Broker check";
    		System.out.println(methodName);
    		/* 
    		 * 
    		 *
				To run individual test, Please remove comment from htmlreportobj(); and Beforesuit geven below.
    		 * 
    		 * 
    		 * 
    		 */
    		
    		//htmlreportobj();
    		test=htmlreport.createTest(methodName);
    		Reportinfo();
    		String bname =browserValue();
    		initiateWebDriver(bname);
    }
    @Test
    public void LoginTest() throws Exception {
        nRowCount = 0;
        Generic oGeneric = new Generic();
        try {
            hm = GetDataFromExcel("BBH.xlsx", "Select * from TestData where TC = 'Security_Broker_check'");
            nRowCount++;
            Report("START --> Test Case Reporting functionality ", " Verify Reporting functionality should work fine ", " Verify Reporting Scenrios works functionality ", Constants.INFO);
            oGeneric.TPlogin();
            Click(objrep.Login.Continue, "Continue Tab");
            Click(objrep.security_Broker_check.ClickOnList, "Click on List");
            Click(objrep.security_Broker_check.SelectSecurityDescription, "Click on Security Description");
            SetText(objrep.security_Broker_check.EnterText, hm.get("Value1" + nRowCount), "Enter Text");
            Click(objrep.security_Broker_check.ClickSearch, "Click on Search");
            
            Switchtochildwin();
            Click(objrep.security_Broker_check.Clickonitem, "Click on Request"); 
            AssertTrue(hm.get("Value2" + nRowCount),GetText(objrep.security_Broker_check.SECURITYSTATUS, "SECURITY STATUS"), "SECURITY STATUS");
            Report("End --> Test Case Verify Maintabs functionality", "Verify Maintabs functionality ", "Verify Maintabs Scenario works functionality", Constants.INFO);
          } catch (Exception e) {
            try {
                Report("Verify Reporting functionality" +new Object(){}.getClass().getEnclosingMethod().getName()+ " encountered any exceptions","Verify Reporting functionality should Verified without any errors"," Verify Reporting functionality verification Failed an exception has occured " + getStackTrace(e),Constants.FAIL);
                e.printStackTrace();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
//    @BeforeSuite
//    public static void setUpBeforeClass() throws Exception {
//        ReadMainConfigData();
//        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir").toString().replace("\\", "/") + "/reports/Reportingreport"  + dateFormat.format(cal.getTime()) + ".html");
//    }
    @AfterMethod
    public void tearDown() throws Exception {
        String methodName = "Security Broker check";
        aftermethod(methodName);
        Thread.sleep(8000);
        closeBrowser();
    }
}
