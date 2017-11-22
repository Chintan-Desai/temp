package com.BBH.testcase;

import com.BBH.buisnessfunctions.Generic;
import com.BBH.utils.CommonFunctions;
import com.BBH.utils.Constants;
import com.BBH.utils.objrep;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
public class Reporting extends CommonFunctions{

	static String methodName;
    public static HashMap<String, String> hm;
    public int nRowCount = 0;
    @BeforeMethod
    public void init() throws Exception
    {
    		methodName = "Reporting";
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
            hm = GetDataFromExcel("BBH.xlsx", "Select * from TestData where TC = 'Reporting'");
            nRowCount++;
            Report("START --> Test Case Reporting functionality ", " Verify Reporting functionality should work fine ", " Verify Reporting Scenrios works functionality ", Constants.INFO);
            oGeneric.TPlogin();
            Click(objrep.Login.Continue, "Continue Tab");
            Click(objrep.Reporting.Reporting, "Click on Reporting Tab");
            Click(objrep.Reporting.ReportingView, "Click on Reporting View tab");
            switchToCurentframe();
            Click(objrep.Reporting.Report, "Click on Report in list");
            Click(objrep.Reporting.Reporttype, "Click on Report type");
            Click(objrep.Reporting.Frequency, "Click on Frequency");
            Click(objrep.Reporting.Submit, "Click on Submit tab");
            Click(objrep.Reporting.ManageReport, "Click on Manage report type");
            Click(objrep.Reporting.Alltype, "Click on All type");
            Click(objrep.Reporting.Clickonalltype, "Click on All Report ");
            Click(objrep.Reporting.TemplateName, "Click on Template Name");
            Click(objrep.Reporting.Admin, "Click on Admin");
            SetText(objrep.Reporting.EnterReportname, hm.get("Value1" + nRowCount), "Report Name");
            Click(objrep.Reporting.ClickonAdd, "Click on Add");
            Click(objrep.Reporting.SelectReport, "Select Report");
            Thread.sleep(1000);
            Clickandhandlealert(objrep.Reporting.Delete, "Click on Delete");            
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
//   @BeforeSuite
//    public static void setUpBeforeClass() throws Exception {
//        ReadMainConfigData();
//        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir").toString().replace("\\", "/") + "/reports/Reporting_report"  + dateFormat.format(cal.getTime()) + ".html");
//    }
    @AfterMethod
    public void tearDown() throws Exception {
        String methodName = "Reporting";
        aftermethod(methodName);
        Thread.sleep(8000);
        closeBrowser();
    }
}
