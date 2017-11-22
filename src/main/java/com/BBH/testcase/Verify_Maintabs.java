package com.BBH.testcase;

import java.util.HashMap;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.BBH.buisnessfunctions.Generic;
import com.BBH.utils.CommonFunctions;
import com.BBH.utils.Constants;
import com.BBH.utils.objrep;

public class Verify_Maintabs extends CommonFunctions{

	static String methodName;
    public static HashMap<String, String> hm;
    public int nRowCount = 0;
    @BeforeMethod
    public void init() throws Exception
    {
    		methodName = "Verify Maintabs";
    		System.out.println(methodName);
    		/* 
    		 * 
    		 *
				To run individual test, Please remove comment from htmlreportobj(); geven below.
    		 * 
    		 * 
    		 * 
    		 */
    		
    	//	htmlreportobj();
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
            hm = GetDataFromExcel("BBH.xlsx", "Select * from TestData where TC = 'Verify_Maintabs'");
            nRowCount++;
            Report("START --> Test Case Verify Maintabs functionality ", " Verify Maintabs functionality should work fine ", " Verify Maintabs Scenrios works functionality ", Constants.INFO);
            oGeneric.TPlogin();
            Click(objrep.Login.Continue, "Click on Continue Tab");
            Click(objrep.Verify_Maintabs.WorldViewtab, "Click on WorldViewtab");
            AssertTrue(hm.get("Value1" + nRowCount),GetText(objrep.Verify_Maintabs.WorldViewtab, "TAB Is visible and clickable"), "TAB Is visible and clickable");
            Click(objrep.Verify_Maintabs.BBH_App_Placetab, "Click on BBH_App_Placetab");  
            AssertTrue(hm.get("Value5" + nRowCount),GetText(objrep.Verify_Maintabs.BBH_App_Placetab, "TAB Is visible and clickable"), "TAB Is visible and clickable");
            Click(objrep.Verify_Maintabs.MyInfomediarytab, "Click on Infomediarytab");
            AssertTrue(hm.get("Value2" + nRowCount),GetText(objrep.Verify_Maintabs.MyInfomediarytab, "TAB Is visible and clickable"),"TAB Is visible and clickable");
            Click(objrep.Verify_Maintabs.ETFConnecttab, "Click on ETFConnecttab");
            AssertTrue(hm.get("Value3" + nRowCount),GetText(objrep.Verify_Maintabs.ETFConnecttab, "TAB Is visible and clickable"),"TAB Is visible and clickable");
            Click(objrep.Verify_Maintabs.Marketstab, "Click on Marketstab");
            AssertTrue(hm.get("Value4" + nRowCount),GetText(objrep.Verify_Maintabs.Marketstab, "TAB Is visible and clickable"),"TAB Is visible and clickable");
            Report("End --> Test Case Verify Maintabs functionality", "Verify Maintabs functionality ", "Verify Maintabs Scenario works functionality", Constants.INFO);
            
        } catch (Exception e) {
            try {
                Report("Verify Maintabs functionality" +new Object(){}.getClass().getEnclosingMethod().getName()+ " encountered any exceptions","Verify Maintabs functionality should Verified without any errors"," Verify Maintabs functionality verification Failed an exception has occured " + getStackTrace(e),Constants.FAIL);
                e.printStackTrace();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
//    @BeforeSuite
//    public static void setUpBeforeClass() throws Exception {
//        ReadMainConfigData();
//        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir").toString().replace("\\", "/") + "/reports/VerifyMaintabsReport"  + dateFormat.format(cal.getTime()) + ".html");
//    }
    @AfterMethod
    public void tearDown() throws Exception {
        String methodName = "Verify Maintabs";
        aftermethod(methodName);
        Thread.sleep(8000);
        closeBrowser();
    }
}
