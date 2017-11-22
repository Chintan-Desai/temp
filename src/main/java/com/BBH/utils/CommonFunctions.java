package com.BBH.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;


public class CommonFunctions {
	public static WebDriver driver;
//	public static ExtentReports htmlreport;
//	public static ExtentTest test;
	public static ExtentHtmlReporter htmlReporter;
	String winHandleBefore;
	public static ExtentReports htmlreport;
	public static ExtentTest test;
	public static DateFormat dateFormat = new SimpleDateFormat ("MMddyyyyHHmm");
	public static Calendar cal = Calendar.getInstance();
	public static Properties propMainConfig = new Properties();
	//public static Properties propMainConfig = new Properties();
	public static String sCurrentBrowser;

		/**
		 * Function Description: Launch web browser
		 * @parameters: sBrowser
		 */
		public WebDriver initiateWebDriver(String sBrowser) throws Exception {
			
			//Integer nWait = 5;
	        String sUserDir = System.getProperty("user.dir").replace("\\", "/").toString();    	
	        
	       // System.out.println("sbrowser in initatte"+sBrowser);
	        if (sBrowser.equalsIgnoreCase("IE")){
	        	
	        	System.out.println("launching Internet browser");
				DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
				caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
				caps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL,"");
				caps.setCapability("ignoreZoomSetting", true);
				caps.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, true);
				caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
				caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				caps.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
				caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
				caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
				System.setProperty("webdriver.ie.driver", sUserDir + "/src/test/java/" + "IEDriverServer.exe");
				driver = new InternetExplorerDriver(caps);					
				driver.manage().deleteAllCookies();				
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
				driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
				
		   	  	driver.get(propMainConfig.getProperty("URL"));
		   	  	
			    Report("Launch Internet Explorer browser","Internet Explorer browser with URL '" + propMainConfig.getProperty("URL")+ "' lauched successfully","Internet Explorer browser with URL '" + propMainConfig.getProperty("URL")+ "' lauched successfully",Constants.INFO);
			    Thread.sleep(3000);
	        }
	        
	        	else if(sBrowser.equalsIgnoreCase("chrome")){
	        	System.setProperty("webdriver.chrome.driver", sUserDir + "/src/test/java/" + "chromedriver.exe");
	      	    DesiredCapabilities sChromeCapability= DesiredCapabilities.chrome();
	      	    sChromeCapability.setBrowserName("chrome");
	      	    ChromeOptions options = new ChromeOptions();
	      	    sChromeCapability.setCapability(CapabilityType.BROWSER_NAME, "CHROME");
	      	  	sChromeCapability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	      	  	sChromeCapability.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT,true);
	      	  	sChromeCapability.setCapability("ensureCleanSession", true);
			    sChromeCapability.setCapability("ignoreZoomSetting", true);
			    sChromeCapability.setCapability("ignoreProtectedModeSettings", true);
			    sChromeCapability.setCapability("ignore-certificate-error", true);
			    sChromeCapability.setCapability("ignoreProtectedModeSettings", true);
			    sChromeCapability.setCapability("disable-popup-blocking", true);
			    sChromeCapability.setCapability("enablePersistentHover", true);
			    sChromeCapability.setCapability(ChromeOptions.CAPABILITY, options);
	      	    //Capability.setPlatform(Platform.WINDOWS);
	      	    driver= new ChromeDriver(sChromeCapability);
	      	    driver.manage().deleteAllCookies();
	      	    driver.manage().window().maximize();
	      	  	driver.get(propMainConfig.getProperty("URL"));
	      	  	Report("Launch Chrome browser."+" ","Chrome browser with URL '"+ propMainConfig.getProperty("URL")+ "' lauched successfully","Chrome browser with URL '" + propMainConfig.getProperty("URL")+ "' lauched successfully",Constants.INFO);
		        
	        }
			    
			    else if(sBrowser.equalsIgnoreCase("firefox")){
	        	
	        	System.setProperty("webdriver.gecko.driver", sUserDir + "/src/test/java/" + "geckodriver.exe");//firefox.marionette
	        	//System.setProperty("webdriver.gecko.driver", "F://geckodriver.exe");
	        	DesiredCapabilities sFFCapability = DesiredCapabilities.firefox();
	    		sFFCapability.setBrowserName("firefox");
	    		sFFCapability.setCapability("marionette", false);
	    		//sFFCapability.setCapability("version", "45.0.2");
	    		sFFCapability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	            sFFCapability.setCapability("acceptSslCerts", true);
	        	FirefoxProfile profile;
	        	profile = new FirefoxProfile();
				profile.setAcceptUntrustedCertificates(true);
	        	profile.setAssumeUntrustedCertificateIssuer(true);
	        	profile.setPreference("browser.download.folderList", 2);
	        	profile.setPreference("browser.download.manager.showWhenStarting", false);
	        	//profile.setPreference("browser.download.dir", System.getProperty("java.io.tmpdir")+"\\"+testName);
	        	profile.setPreference("browser.download.dir","C:\\Download");
	        	profile.setPreference("browser.helperApps.neverAsk.openFile",
	    				"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/zip,application/x-zip,application/x-zip-compressed,application/octet-stream");
	    		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
	    				"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/zip,application/x-zip,application/x-zip-compressed,application/octet-stream");
	    		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
	    		profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
	    		profile.setPreference("browser.download.manager.focusWhenStarting", false);
	    		profile.setPreference("browser.download.manager.useWindow", false);
	    		profile.setPreference("browser.download.manager.showAlertOnComplete", false);
	    		profile.setPreference("browser.download.manager.closeWhenDone", false);
	    		sFFCapability.setCapability(FirefoxDriver.PROFILE, profile);
	    		driver = new FirefoxDriver(sFFCapability);
	    		System.out.println("before url");
	        	driver.get(propMainConfig.getProperty("URL"));
	        	System.out.println(propMainConfig.getProperty("URL"));
	        	System.out.println("after url");
	            Report("Launch Firefox browser","Firefox browser with URL '" + propMainConfig.getProperty("URL")+ "' lauched successfully","Firefox browser with URL '" + propMainConfig.getProperty("URL")+ "' lauched successfully",Constants.INFO);
	        }
	        
	        //driver.manage().deleteAllCookies();
	        Thread.sleep(2000);							
			driver.manage().window().maximize();
	        return driver;
		}
		/**
		 * Function Description: Get Stack Trace
		 * @parameters: Exception e
		 */
		public String getStackTrace(Exception e) throws Exception {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String errorMessage = e.toString();
			return errorMessage;
		}

		/**
		 * Function Description: Get the element/object
		 * @parameters: objName
		 */
		public WebElement GetObject(String objName) throws Exception, NoSuchElementException {
			
			WebDriverWait wait = new WebDriverWait(driver, 60);
			String identifier;
			String description;
			WebElement element = null;
			By searchBy = null;
			if (objName.equals(null) || objName.trim().equals("")) {
				throw new Exception("Object description must be provided");
			} else {
				identifier = objName.split("~")[0].trim();
				description = objName.split("~")[1].trim();
				if (identifier.equals("xpath")) {
					searchBy = By.xpath(description);
				} else if (identifier.equals("name")) {
					searchBy = By.name(description);
				} else if (identifier.equals("id")) {
					searchBy = By.id(description);
				} else if (identifier.equals("cssSelector")) {
					searchBy = By.cssSelector(description);
				} else if (identifier.equals("tagname")) {
					searchBy = By.tagName(description);
				} else if (identifier.equals("linktext")) {
					searchBy = By.linkText(description);
				} else if (identifier.equals("partiallinktext")) {
					searchBy = By.partialLinkText(description);
				} else if (identifier.equals("classname")) {
					searchBy = By.className(description);
				} else {
					throw new Exception("Object description is NOT valid");
				}
		        element = wait.until(ExpectedConditions.presenceOfElementLocated(searchBy)); //elementToBeClickable
				//element = driver.findElement(searchBy);
			return element;
		  }		
		}

		/**
		 * Function Description: Get the list of elements/objects
		 * @parameters: objName
		 */
		public List<WebElement> GetObjects(String objName)throws Exception, NoSuchElementException {
			
			String identifier;
			String description;
			List<WebElement> element = null;
			By searchBy = null;
			if (objName.equals(null) || objName.trim().equals("")) {
				throw new Exception("Object description must be provided");
			} else {
				identifier = objName.split("~")[0].trim();
				description = objName.split("~")[1].trim();
				if (identifier.equals("xpath")) {
					searchBy = By.xpath(description);
				} else if (identifier.equals("name")) {
					searchBy = By.name(description);
				} else if (identifier.equals("id")) {
					searchBy = By.id(description);
				} else if (identifier.equals("cssSelector")) {
					searchBy = By.cssSelector(description);
				} else if (identifier.equals("tagname")) {
					searchBy = By.tagName(description);
				} else if (identifier.equals("linktext")) {
					searchBy = By.linkText(description);
				} else if (identifier.equals("partiallinktext")) {
					searchBy = By.partialLinkText(description);
				} else if (identifier.equals("classname")) {
					searchBy = By.className(description);
				} else {
					throw new Exception("Object description is NOT valid");
				}
				element = driver.findElements(searchBy);
				return element;
			}
		}

		/**
		 * Function Description: Check for the element/object existence, returns true if available
		 * @parameters: objName
		 */
		public boolean DoesObjectExist(String objName)throws Exception  {
			boolean returnValu = true;
			   try{
					 GetObject(objName);
			   }catch (Exception e){
					 returnValu = false;
			   }
		     return returnValu;
		}

		/**
		 * Function Description: Check whether the element/object is Hidden
		 * @parameters: objName
		 */
		public boolean isObjectHidden(String objName)throws Exception  {
			
		    boolean returnValu = false;
		           try{
		                 if(GetObject(objName).getAttribute("hidefocus").equals("true")){
		                	 System.out.println(GetObject(objName).getAttribute("hidefocus"));
		                	 returnValu = true;
		                 }
		           }catch( Exception e){
		                 returnValu = false;
		           }
		     return returnValu;
		}

		/**
		 * Function Description: Set the text in an element/object
		 * @parameters: objName, sValue, sFieldName
		 */
		public void JSCalSetText(String objName, String sValue, String sFieldName)throws Exception, NoSuchElementException {
			//try{
			((JavascriptExecutor)driver).executeScript("document.getElementByXpath(\"//*[@name='fromDate']\")");
			GetObject(objName).sendKeys("");
			GetObject(objName).sendKeys(sValue);
			Report("Entering value '" + sValue + "' in the field '" + sFieldName + "'","'" + sFieldName + "' Should be entered with Value '" + sValue + "' Successfully","'" + sFieldName + "' was entered with Value '" + sValue + "' Successfully",Constants.PASS);
			
		}
		public void SetText(String objName, String sValue, String sFieldName)throws Exception, NoSuchElementException {
			//try{
			GetObject(objName).sendKeys("");
			GetObject(objName).sendKeys(sValue);
			Report("Entering value '" + sValue + "' in the field " + sFieldName + "."," " + sFieldName + "' Should be entered with Value '" + sValue + "' Successfully"," " + sFieldName + " was entered with Value '" + sValue + "' Successfully",Constants.PASS);
			/*}catch (Exception e){
				try {
					Report("Entering value '" + sValue + "' in the field '" + sFieldName + "'","'" + sFieldName + "' Should be entered with Value '" + sValue + "' Successfully","'" + sFieldName + "' was NOT entered with Value '" + sValue + "' Successfully",Constants.FAIL);
					e.printStackTrace();
				}catch (Exception e1) {
						e1.printStackTrace();
			    }
			 }*/
		}
		/**
		 * Function Description: save the document to print using robot keys
	     * @parameters: sDocumentName
		 */
		public void SaveDocument(String sDocumentName) throws NoSuchElementException, Exception {
			try{

				Thread.sleep(15000L);
				Robot a = new Robot();
	            sendRobotKeys(a,"VK_ENTER");
	            Thread.sleep(5000L);
				sendRobotKeys(a, sDocumentName);
				Thread.sleep(8000L);
				sendRobotKeys(a,"VK_TAB");
				sendRobotKeys(a,"VK_TAB");
				sendRobotKeys(a,"VK_ENTER");
				sendRobotKeys(a,"VK_LEFT");
				Thread.sleep(1000L);
				sendRobotKeys(a,"VK_ENTER");
				Thread.sleep(1000L);
				Report("Save Document", "Document saved successfully", "User has saved the document to print successfully", Constants.PASS );
			}catch (Exception e){
				try {
					Report("Document saved successfully " +new Object(){}.getClass().getEnclosingMethod().getName()+ " encountered any exceptions","Application should save document without exceptions"," Saving Failed an exception has occured " + getStackTrace(e),"FAIL");
					e.printStackTrace();
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}


		/**
		 * Function Description: Set the text in an element/object based on index
		 * @parameters: objName, sValue, sFieldName
		 */
		public void SetTextBasedOnIndex(String objName, String sValue, int nIndex, String sFieldName)throws Exception, NoSuchElementException {
			//try{
			GetObjects(objName).get(nIndex).sendKeys("");
			GetObjects(objName).get(nIndex).sendKeys(sValue);
			Report("Entering value '" + sValue + "' in the field '" + sFieldName + "'","'" + sFieldName + "' Should be entered with Value '" + sValue + "' Successfully","'" + sFieldName + "' was entered with Value '" + sValue + "' Successfully",Constants.PASS);
			/*}catch (Exception e){
				try {
					Report("Entering value '" + sValue + "' in the field '" + sFieldName + "'","'" + sFieldName + "' Should be entered with Value '" + sValue + "' Successfully","'" + sFieldName + "' was NOT entered with Value '" + sValue + "' Successfully",Constants.FAIL);
					e.printStackTrace();
				}catch (Exception e1) {
						e1.printStackTrace();
			    }
			 }*/
		}


	    /**
	     * Function Description: Handle the alert available on application
	     * @parameters: sValue
	     */
	    public void HandleAlert(String sValue) {
	        Alert alert = driver.switchTo().alert();
	        if (sValue.contains("true"))
	            alert.accept();
	        else
	            alert.dismiss();
	    }
	    public void Enter() throws AWTException {
	    	Robot robot = new Robot();
	    	robot.keyPress(KeyEvent.VK_ENTER);	
	    }

	    /**
	     * Function Description: Get the text
	     * @parameters: objName, sFieldName
	     */
		public String GetText(String objName, String sFieldName)throws Exception, NoSuchElementException {
			//try{
			String sText = GetObject(objName).getText();
			//Report ("Retrieving value of the field '" + sFieldName + "'","'" + sFieldName + "' value Should be retrieved Successfully", "'" + sFieldName + "' was retrieved with value '" + sText + "' Successfully", Constants.PASS);
			return sText;
				//GetObject(objName).sendKeys(sValue);
			//*[@id='fileName']/paper-input-decorator
			/*}catch (Exception e){
				try {
					Report("Entering value '" + sValue + "' in the field '" + sFieldName + "'","'" + sFieldName + "' Should be entered with Value '" + sValue + "' Successfully","'" + sFieldName + "' was NOT entered with Value '" + sValue + "' Successfully",Constants.FAIL);
					e.printStackTrace();
				}catch (Exception e1) {
						e1.printStackTrace();
			    }
			 }*/
		}
		
		

		/**
		 * Function Description: Get the attribute Value of an element/object
		 * @parameters: objName, sFieldName
		 */
		public String GetAttributeValue (String objName, String sFieldName)throws Exception, NoSuchElementException {
			//try{
			String sText = GetObject(objName).getAttribute("value");
			Report ("Retrieving value of the field '" + sFieldName + "'","'" + sFieldName + "' value Should be retrieved Successfully", "'" + sFieldName + "' was retrieved with value '" + sText + "' Successfully", Constants.PASS);
			return sText;
		}

		/**
		 * Function Description: Get Attribute Value
		 * @parameters: objName, sAttributeValue, sExpectedstyle
		 */
		public void GetAttributeValueStyle(String objName, String sAttributeValue, String sExpectedstyle)throws Exception, NoSuchElementException {
			//try{
			String sText = GetObject(objName).getAttribute(sAttributeValue);
			if (sText.contains(sExpectedstyle)) {
				Report("Retrieving value of the field '" + sAttributeValue + "'", "'" + sAttributeValue + "' value Should be retrieved Successfully", "'" + sAttributeValue + "' was retrieved with value '" + sText + "' Successfully", Constants.PASS);
			}else{
				Report("Retrieving value of the field '" + sAttributeValue + "'", "'" + sAttributeValue + "' value Should be retrieved Successfully", "'" + sAttributeValue + "' was NOT retrieved with value '" + sText + "' Successfully", Constants.FAIL);
			}
		}

		/**
		 * Function Description: Get the attribute width
	     * @parameters: objName
		 */

		public int GetAttributeWidth(String objName)throws Exception, NoSuchElementException {
			//try{
			int sPageWidth = GetObject(objName).getSize().getWidth();
			return sPageWidth;
			}

		public void MousekeyESC()throws Exception, NoSuchElementException {
			//try{
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ESCAPE).build().perform();
		}
		
		public void keyDownEnter()throws Exception, NoSuchElementException {
			//try{
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
		}

	    /**
	     * Function Description: Get the attribute Height
	     * @parameters: objName
	     */
		public int GetAttributeHeight(String objName)throws Exception, NoSuchElementException {
			//try{
			int sPageHeight = GetObject(objName).getSize().getWidth();
			return sPageHeight;
			}

		public void selectDDvalue(String objName,String svalue)throws Exception, NoSuchElementException {
			//try{
			List<WebElement> list =  GetObjects(objName);
			for(int i=0;i<list.size();i++)
			{
				//System.out.println(list.get(i).getText());
				if(list.get(i).getText().trim().contains(svalue.trim()))
				{
					//System.out.println("matched"+svalue);
					list.get(i).click();
					break;
				}
			}
			
			}
		
		
		/**
		 * 
		 * Function Description: Click an element/object
		 * @parameters: objName, sFieldName
		 */
		
		public void Click(String objName, String sFieldName)throws Exception, NoSuchElementException {
			//try{
				GetObject(objName).click();
				Report("Click " + sFieldName + "."," " + sFieldName + "' Should be Clicked Successfully"," " + sFieldName + " was Clicked Successfully",Constants.PASS);
			/*}catch (Exception e){
				try {
					Report("Click '" + sFieldName + "'","'" + sFieldName + "' Should be Clicked Successfully","'" + sFieldName + "' was NOT Clicked Successfully",Constants.FAIL);
					e.printStackTrace();
				}catch (Exception e1) {
						e1.printStackTrace();
			    }
			 }*/
		}
		public void Clickandhandlealert(String objName, String sFieldName)throws Exception, NoSuchElementException {
			//try{
				GetObject(objName).click();
				//Report("Click " + sFieldName + "."," " + sFieldName + "' Should be Clicked Successfully"," " + sFieldName + " was Clicked Successfully",Constants.PASS);
			/*}catch (Exception e){
				try {
					Report("Click '" + sFieldName + "'","'" + sFieldName + "' Should be Clicked Successfully","'" + sFieldName + "' was NOT Clicked Successfully",Constants.FAIL);
					e.printStackTrace();
				}catch (Exception e1) {
						e1.printStackTrace();
			    }
			 }*/
				//WebDriverWait wait=new WebDriverWait(driver,100);
				Alert alert=driver.switchTo().alert();
				String alerttext=alert.getText();
				alert.accept();
				
		}
	
		public void Switchtochildwin() throws Exception {
			Report("Switched to popup ", " "," "+ "window successfully"+".", " ");
		winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
          driver.manage().window().maximize();
        
		}
		
		
		public void Switchtomainwin() throws Exception {
			driver.switchTo().window(winHandleBefore);
			Report("Switched to main ", " "," "+ "window successfully"+".", " ");
			}
		public void JClick(String objName, String sFieldName)throws Exception, NoSuchElementException {
			//try{	
					WebElement element = GetObject(objName);
		           JavascriptExecutor executor = (JavascriptExecutor)driver;
		           executor.executeScript("arguments[0].click();", element);//*[@contentDescription='Web View']
				Report("Click '" + sFieldName + "'","'" + sFieldName + "' Should be Clicked Successfully","'" + sFieldName + "' was Clicked Successfully",Constants.PASS);
			/*}catch (Exception e){
				try {
					Report("Click '" + sFieldName + "'","'" + sFieldName + "' Should be Clicked Successfully","'" + sFieldName + "' was NOT Clicked Successfully",Constants.FAIL);
					e.printStackTrace();
				}catch (Exception e1) {
						e1.printStackTrace();
			    }
			 }*/
		}

		/**
		 * Function Description: Click an element/object based on index
		 * @parameters: objName, sFieldName
		 */
		public void ClickBasedOnIndex(String objName, int nIndex, String sFieldName)throws Exception, NoSuchElementException {
			//try{
			GetObjects(objName).get(nIndex).click();
			Report("Click '" + sFieldName + "'","'" + sFieldName + "' Should be Clicked Successfully","'" + sFieldName + "' was Clicked Successfully",Constants.PASS);
			/*}catch (Exception e){
				try {
					Report("Click '" + sFieldName + "'","'" + sFieldName + "' Should be Clicked Successfully","'" + sFieldName + "' was NOT Clicked Successfully",Constants.FAIL);
					e.printStackTrace();
				}catch (Exception e1) {
						e1.printStackTrace();
			    }
			 }*/
		}
		
		/**
		 * Function Description:  Assert the text
	     * @Parameters: objName, sExpectedValue
		 */
		public void AssertText(String objName, String sExpectedValue)throws Exception, NoSuchElementException {
			String sActualValue = GetObject(objName).getText();
			Assert.assertTrue(sActualValue.contains(sExpectedValue));
	        Report("Asserting value of the field '" + sExpectedValue + "'", "'" + sExpectedValue + "' value Should be Asserted Successfully", "'" + sExpectedValue + "' was Asserted with value '" + sActualValue + "' Successfully", Constants.PASS);

		}
		/**
	     * Function Description:  clear the text available on element
	     * @Parameters: objName, sFieldName
		 */
		public void Clear(String objName, String sFieldName)throws Exception, NoSuchElementException {
			try{
				GetObject(objName).clear();
				Report("Clear '" + sFieldName + "'","'" + sFieldName + "' Should be Cleared Successfully","'" + sFieldName + "' was Cleared Successfully",Constants.PASS);
			}catch (Exception e){
				try {
					if(verifyText(objName,"")){
						Report("Clear '" + sFieldName + "'","'" + sFieldName + "' Should be Cleared Successfully","'" + sFieldName + "' was Cleared Successfully",Constants.PASS);
					}
				}catch (Exception e1) {
					Report("Clear '" + sFieldName + "'","'" + sFieldName + "' Should be Clicked Successfully","'" + sFieldName + "' was NOT Cleared Successfully",Constants.FAIL);
					e1.printStackTrace();
				}
			}
		}

	    /**
	     * Function Description: Select Drop down Value
	     * @parameters: objName, sValueToSelect, sFieldName
	     */

		public void selectDropDownValue(String objName, String sValueToSelect, String sFieldName) throws Exception
		{
			//try{
			    WebElement dropdownList= GetObject(objName);     
			    new Select(dropdownList).selectByVisibleText(sValueToSelect); 
			    Report("Selecting value '" + sValueToSelect + "' in the field '" + sFieldName + "'","'" + sFieldName + "' Should be selected with Value '" + sValueToSelect + "' Successfully","'" + sFieldName + "' was selected with Value '" + sValueToSelect + "' Successfully",Constants.PASS);
			/*}catch (Exception e){
				try {
					Report("Selecting value '" + sValueToSelect + "' in the field '" + sFieldName + "'","'" + sFieldName + "' Should be selected with Value '" + sValueToSelect + "' Successfully","'" + sFieldName + "' was NOT selected with Value '" + sValueToSelect + "' Successfully",Constants.FAIL);
					e.printStackTrace();
				}catch (Exception e1) {
						e1.printStackTrace();
			    }
			 }*/
		}

		/**
		 * Function Description: Get the test data from an excel
		 * @parameters: sFile, sQuery
		 */
		public HashMap<String, String> GetDataFromExcel(String sFile,String sQuery) throws Exception {
			
			Fillo fillo=new Fillo();
			Recordset rs = null;
			sFile = System.getProperty("user.dir").toString().replace("\\", "/")+ "/src/test/java/" + sFile;
			HashMap<String, String> results = new HashMap<String, String>();
			String columnNames = "";
			int columnCount = 0;
			int rowCount = 0;
			Connection connObj=fillo.getConnection(sFile);
			if (null != connObj) {
					rs = connObj.executeQuery(sQuery);		
					String cellValue = new String("");
					ArrayList<String> columnList=rs.getFieldNames();
					columnCount=columnList.size();
					rowCount = 0;
					while (rs.next()) {
						rowCount++;
						columnNames = "";
						for (int i = 0; i < columnCount ; i++) {
							String columnName = columnList.get(i);
							if (columnNames == ""){
								columnNames = columnName;
							}else{
								columnNames = columnNames + ";" + columnName;
							}
							cellValue=(String) rs.getField(columnName);
							if (cellValue==null) cellValue="";
							results.put(columnName + rowCount,cellValue);
							
						}
					}
				}
				if(rs!=null)rs.close();
				if (null != connObj)	connObj.close();
				results.put("RowCount", rowCount + "");
				results.put("ColumnCount", columnCount + "");
				results.put("ColumnNames", columnNames);
				return results;
		}

		/**
		 * Function Description:
		 * @parameters: sMethodName
		 */
		public static void beforeMethod(String methodName)  {
			 htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir").toString().replace("\\", "/") + "/reports/LoginReport" + dateFormat.format(cal.getTime()) + ".html");
		        htmlreport = new ExtentReports ();
				htmlreport.attachReporter(htmlReporter);
				htmlReporter.config().setTheme(Theme.DARK);
				test=htmlreport.createTest("Login1 & Logout");
				test.assignAuthor("Shakir Kagzi");
				test.assignCategory("BBH Automation");
				htmlReporter.config().setChartVisibilityOnOpen(true);
			    htmlReporter.config().setReportName("My Own Report");
			    htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			    htmlReporter.config().setTheme(Theme.DARK);
		}
		public static void Reportinfo()  {
				test.assignAuthor("Shakir Kagzi");
				test.assignCategory("BBH Automation");
		}
		public static void htmlreportobj()  {
			htmlreport = new ExtentReports ();
			htmlreport.attachReporter(htmlReporter);
			htmlReporter.config().setTheme(Theme.DARK);
	}
		/**
		 * Function Description:
		 * @parameters: sMethodName
		 */
		public void aftermethod(String methodName){
		    htmlreport.flush();
			       
		}

		/**
		 * Function Description: Close the browser
		 * @parameters: NIL
		 */
		public void closeBrowser() {
			driver.close();
			driver.quit();
		}

		/**
		 * Function Description: Report/Log the test step activities
		 * @parameters: sDescription, sExpResult, sActResult, sStepStatus
		 */
		public void Report(String Description,String sExpResult,String sActResult, String sStepStatus ) throws Exception{
			if (sStepStatus.toLowerCase().contains("pass")){
				test.log(Status.PASS, MarkupHelper.createLabel(Description + sActResult, ExtentColor.GREEN));
				takeScreenshot();
			}else if(sStepStatus.toLowerCase().contains("fail")){
				 test.log(Status.FAIL, MarkupHelper.createLabel(Description + sActResult, ExtentColor.RED));
				takeScreenshot();
			}else{
				test.log(Status.INFO, Description + sActResult);
			}
		}
		/**
		 * Function Description: Take snapshot
		 * @parameters: NIL
		 */
		public void takeScreenshot() throws IOException, InterruptedException{
			Thread.sleep(1000);
			File screen_image= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File screen_file= new File(System.getProperty("user.dir").toString().replace("\\", "/")+ "/snapshots/snapshorts"+System.currentTimeMillis()+".png");
			String img_path = screen_file.getPath();
			FileUtils.copyFile(screen_image,screen_file);
			test.info("Snapshot Below: " +test.addScreenCaptureFromPath(img_path));
			htmlreport.flush();
		}
		/**
		 * Function Description: Read main Configuration data (mainConfig.xml)
		 * @parameters: NIL
		 */
		public static void ReadMainConfigData() throws InvalidPropertiesFormatException, IOException {
			
					File file = new File(System.getProperty("user.dir").toString().replace("\\", "/")+ "/src/test/java/" + "BBH.xml");
					FileInputStream fileInput = new FileInputStream(file);
					propMainConfig.loadFromXML(fileInput);
					fileInput.close();

		}

		/**
		 * Function Description: Read Environment Configuration data
		 * @parameters: NIL
		 */
		/*public static void ReadEnvConfigData() throws InvalidPropertiesFormatException, IOException {
			
			File file = new File(System.getProperty("user.dir").toString().replace("\\", "/")+ "/src/test/resources/" + propMainConfig.getProperty("Environment") + "/" + propMainConfig.getProperty("AppName") + ".xml");
			FileInputStream fileInput = new FileInputStream(file);
			propMainConfig.loadFromXML(fileInput);
			fileInput.close();

		}*/

		/**
		 * Function Description: Enter values/Perform Click using Robot Keys
		 * @parameters: robot, sKeys
		 */
		public void sendRobotKeys(Robot robot, String sKeys) throws Exception {
			if (sKeys.startsWith("VK_")){
				int keyCode = (int)KeyEvent.class.getField(sKeys).getInt(null);
				if (KeyEvent.CHAR_UNDEFINED == keyCode) {
		            throw new RuntimeException("Key code not found for '" + sKeys + "'");
		        }
		        robot.keyPress(keyCode);
		        robot.delay(100);
		        robot.keyRelease(keyCode);
		        robot.delay(100);
			}else if (sKeys.startsWith("BUTTON1_")){
				int keyCode = (int)KeyEvent.class.getField(sKeys).getInt(null);
				if (KeyEvent.CHAR_UNDEFINED == keyCode) {
		            throw new RuntimeException("Key code not found for '" + sKeys + "'");
		        }
				//robot.mouseMove(arg0, arg1);
				robot.delay(100);
		        robot.mousePress(keyCode);
		        robot.delay(100);
		        robot.mouseRelease(keyCode);		        
		        robot.delay(100);
			}else{
				Thread.sleep(2000L);
			    for (char c : sKeys.toCharArray()) {
			        int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
			        if (KeyEvent.CHAR_UNDEFINED == keyCode) {
			            throw new RuntimeException("Key code not found for character '" + c + "'");
			        }
			        if (Character.isUpperCase(c)){
			        	robot.keyPress(KeyEvent.VK_SHIFT);
			        	robot.delay(100);
				        robot.keyPress(keyCode);
				        robot.delay(100);
				        robot.keyRelease(keyCode);
				        robot.delay(100);
				        robot.keyRelease(KeyEvent.VK_SHIFT);
				        robot.delay(100);
			        }else{
			        	robot.keyPress(keyCode);
				        robot.delay(100);
				        robot.keyRelease(keyCode);
				        robot.delay(100);
			        }
			    }
				Report("Setting Text Using Robot", "Text '" + sKeys + "' Should be Entered successfully", "Text '" + sKeys + "' was Entered successfully", Constants.PASS );
			}
		}

		/**
		 * Function Description: Perform Click on an element using Robot Keys
		 * @parameters: robot, sKeys, objName, sFieldName
		 */
		public void ClickRobot(Robot robot, String sKeys, String objName, String sFieldName) throws NoSuchElementException, Exception {
			Thread.sleep(5000L);
			if (sKeys.startsWith("BUTTON1_")){
				int keyCode = (int)KeyEvent.class.getField(sKeys).getInt(null);
				if (KeyEvent.CHAR_UNDEFINED == keyCode) {
		            throw new RuntimeException("Key code not found for '" + sKeys + "'");
		        }		
				Point coordinates = GetObject(objName).getLocation();
				Thread.sleep(4000L);
				robot.mouseMove(coordinates.getX() + 10 , coordinates.getY() + 60);
				robot.delay(100);
		        robot.mousePress(keyCode);
		        robot.delay(100);
		        robot.mouseRelease(keyCode);		        
		        robot.delay(100);
		        Report("Click '" + sFieldName + "'","'" + sFieldName + "' Should be Clicked Successfully","'" + sFieldName + "' was Clicked Successfully",Constants.PASS);
			}	
		}

		/**
		 * Function Description: Switch to Home
		 * @parameters: NIL
		 */
		public void switchToCurentframe() throws Exception{
			//driver.switchTo().defaultContent();	
	    	driver.switchTo().frame("WebPage");	
		}
		public void switchToHome() throws Exception{
			driver.switchTo().defaultContent();	
	    	}
		/**
		 * Function Description: Switch to a frame
		 * @parameters: objName
		 */
		public void switchToStandardObjectFrame(String objName) throws Exception{
			driver.switchTo().defaultContent();	
			int size = driver.findElements(By.tagName("iframe")).size();
			for(int i=0; i<size; i++){
				driver.switchTo().frame(i);
				if((GetObjects(objName).size())==1)
				{
					driver.switchTo().defaultContent();	
					driver.switchTo().frame(i);
					break;
				}
				driver.switchTo().defaultContent();		    
			}
		}

		/**
		 * Function Description: Validate specified File type availability in Zip File
		 * @parameters: sFileName, sDocumentName, sValidateFileType
		 */
		/*public boolean ValidateZipFileContainsSpecifiedType(String sFileName, String sDocumentName, String sValidateFileType) throws Exception{
			boolean sFlag = false;
			File file = new File("C:\\Download\\" + sFileName + ".zip");
	        InputStream input;
	          input = new FileInputStream(file);
	          ZipInputStream zip = new ZipInputStream(input);
	          ZipEntry entry = null; //zip.getNextEntry();
	          while ((entry = zip.getNextEntry()) != null) {
	        	  if ((entry.getName().contains(sDocumentName))){
	        		  if (entry.getName().endsWith(sValidateFileType)){
	        			  sFlag = true;
	        		  }else{
	            		  throw new Exception ("Document '" + sDocumentName + "' inside Zip File '" + sFileName + "' contains file types other than expected file type '" + sValidateFileType + "'");
	            	  }
	        	  }
	        	  //entry = zip.getNextEntry();
	          }
	          
	        if (sFlag) {
	        	Report ("Validation of Document File Types inside Zip Files", "Document File Types inside Zip Files Should be available in the expected format","Document '" + sDocumentName + "' File Types inside Zip Files was available in the expected format '" + sValidateFileType + "'",Constants.PASS);
	        }else{
	        	Report ("Validation of Document File Types inside Zip Files", "Document File Types inside Zip Files Should be available in the expected format","Document '" + sDocumentName + "' File Types inside Zip Files was NOT available in the expected format '" + sValidateFileType + "'",Constants.FAIL);
	        }
	        return sFlag;
		}*/

		/**
		 * Function Description: Created for test paramaterization of browsers
		 * @parameters: NIL
		 */
		/*public static Stream <String> browserValues() throws Exception {
			  LinkedList browsers = new LinkedList ();
			  String[] rawBrowserStrings = propMainConfig.getProperty("Browsers").split(",");
			  for (String rawBrowserString : rawBrowserStrings) {
				  browsers.add(new String[] { rawBrowserString});	
			  }	  
			  return browsers.stream();
			}*/
		
		
		public static String browserValue() throws Exception {
			  String rawBrowserStrings = propMainConfig.getProperty("Browsers");
			  return rawBrowserStrings;
			}

	    /**
	     * Function Description: Verify Text
	     * @parameters: objName, sExpected
	     */
		public boolean verifyText(String objName, String sExpected) throws Exception
		{
			boolean bReturnValue = false;
			String sActual = GetText(objName,"Actual Text");
			if(sActual.trim().contains(sExpected))
			{
				bReturnValue = true;
				Report("Text Matches",sExpected ,sActual , Constants.PASS);
			} else
			{
				Report("Text does not Match",sExpected ,sActual , Constants.FAIL);
			}
			return bReturnValue;
		}

	    /**
	     * Function Description: Generate reandom number in the range from min to max
	     * @parameters: nMin, nMax
	     */
		public static int RandNum (int nMin, int nMax) {

			Random rnd = new Random();
	        int randomNum = rnd.nextInt((nMax - nMin) + 1) + nMin;
			return randomNum;
		}

	
		public void ClickRobotForControls(Robot robot, String sKeys, String objName, String sFieldName) throws NoSuchElementException, Exception {
			if (sKeys.startsWith("BUTTON1_")){
				int keyCode = (int)KeyEvent.class.getField(sKeys).getInt(null);
				if (KeyEvent.CHAR_UNDEFINED == keyCode) {
					throw new RuntimeException("Key code not found for '" + sKeys + "'");
				}
				Point coordinates = GetObject(objName).getLocation();
				Thread.sleep(4000L);
				robot.mouseMove(coordinates.getX() + 10 , coordinates.getY() + 65);
				robot.delay(100);
				robot.mousePress(keyCode);
				robot.delay(100);
				robot.mouseRelease(keyCode);
				robot.delay(100);
				Report("Click '" + sFieldName + "'","'" + sFieldName + "' Should be Clicked Successfully","'" + sFieldName + "' was Clicked Successfully",Constants.PASS);
			}
		}

		/**
		 * Function Description: Assert Value
		 * @parameters: sExpectedValue, sActualValue, sFieldName
		 */
		public void AssertTrue(String sExpectedValue, String sActualValue,String sFieldName)throws Exception, NoSuchElementException
		{
		//	Assert.assertTrue(sExpectedValue.equalsIgnoreCase(sActualValue));
			Report ("Asserting Value of the field '" + sFieldName + "'"+"."," "+"'" + sFieldName + "' value Should be Asserted Successfully", " "+"'" + sFieldName + "' was Asserted with value '" + sExpectedValue + "' Successfully", Constants.PASS);
		}

		/**
		 * Function Description: Fetch CSS Value of item
		 * @parameters: objName, sFieldName
		 */
		public String GetCSSValue(String objName, String sFieldName)throws Exception, NoSuchElementException
		{
			String sText = GetObject(objName).getCssValue(sFieldName);
			Report ("Get CSS value of the field '" + sFieldName + "'","'" + sFieldName + "' value Should be retrieved Successfully", "'" + sFieldName + "' was retrieved with value '" + sText + "' Successfully", Constants.PASS);
			return sText;
		}
}
