package com.BBH.buisnessfunctions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.BBH.utils.CommonFunctions;
import com.BBH.utils.objrep;

public class Generic extends CommonFunctions{
	
	
	public void login(String username, String password) throws NoSuchElementException, Exception
	{
		SetText(objrep.Login.sUsername, username, "UserName");
        SetText(objrep.Login.sPassword, password, "Password");
        Click(objrep.Login.sLoginbutton, "Login1 Button");
	}
	
	public void Securitylogininfo(String street, String FirstCar, String YearfirstCar) throws NoSuchElementException, Exception
	{
		SetText(objrep.Login.streetname, street, "Street");
        SetText(objrep.Login.FirstCarname, FirstCar, "First Car");
        SetText(objrep.Login.YearfirstCars, YearfirstCar, "Year in which you buy fist car");
        Click(objrep.Login.Submitbutton, "Submit Button");
	}
	
	public void TPlogin() throws NoSuchElementException, Exception
	{

		String username = propMainConfig.getProperty("TPUserID");
		String password = propMainConfig.getProperty("TPPassword");	
		login(username,password);
		Thread.sleep(3000);
		
		String street = propMainConfig.getProperty("street");
		String FirstCar = propMainConfig.getProperty("FirstCar");	
		String YearfirstCar = propMainConfig.getProperty("YearfirstCar");	
		Securitylogininfo(street,FirstCar,YearfirstCar);	
		
	}
	
	public String defaultDate()
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -4);
		Date result = cal.getTime();
		return new SimpleDateFormat("dd/MM/yyyy").format(result);
	}	
	
	public void setDate(String str) throws NoSuchElementException, Exception
	{
		WebElement prelink = GetObject(objrep.TP_InvoiceReport.sCalBack);
		WebElement Nextlink = GetObject(objrep.TP_InvoiceReport.sCalFrwd);
		WebElement Midlink = GetObject(objrep.TP_InvoiceReport.sCalMid);
		String Dateparts[] = str.split("/"); 
			int yearDiff = Integer.parseInt(Dateparts[2])-Calendar.getInstance().get(Calendar.YEAR);
		  // System.out.println("Year difference is "+yearDiff);
		   Midlink.click();
		   if(yearDiff!=0)
		   {
			   if(yearDiff>0){
	                for(int i=0;i< yearDiff;i++){
	                    System.out.println("Year Diff->"+i);
	                    Nextlink.click();
	                }
		   }
			   else if(yearDiff<0){
	                for(int i=0;i< (yearDiff*(-1));i++){
	                    System.out.println("Year Diff->"+i);
	                    prelink.click();
	                }
	            }    
		   }
		   List<WebElement> allmonths = GetObjects(objrep.TP_InvoiceReport.sMonthslist);
		   Thread.sleep(5000L);
		   allmonths.get(Integer.parseInt(Dateparts[1])-1).click();
		   List<WebElement> allday = GetObjects(objrep.TP_InvoiceReport.sDayslist);
		   Thread.sleep(5000L);
		   allday.get(Integer.parseInt(Dateparts[0])-1).click();
		   Thread.sleep(10000L);
	}	
}
