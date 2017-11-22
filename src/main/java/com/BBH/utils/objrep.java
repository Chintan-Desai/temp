package com.BBH.utils;

public class objrep {

		public static class Login {
			public static final String sUsername = Constants.XPATH + "~" + ".//input[@name='userid']";
			public static final String sPassword = Constants.XPATH + "~" + "//*[@id='loginForm']/input[3]";
			public static final String sLoginbutton = Constants.XPATH + "~" + "//*[@id='loginForm']/a[1]";
			public static final String sWelcome = Constants.XPATH + "~" + "//*[@id='name']";
			public static final String streetname = Constants.XPATH + "~" + "//*[@id='answerQuestionsForm']/input[6]";
			public static final String FirstCarname = Constants.XPATH + "~" + "//*[@id='answerQuestionsForm']/input[7]";
			public static final String YearfirstCars = Constants.XPATH + "~" + "//*[@id='answerQuestionsForm']/input[8]";
			public static final String Submitbutton = Constants.XPATH + "~" + "//*[@id='answerQuestionsForm']/a";
			public static final String Continue = Constants.XPATH + "~" + "//*[@id='enterPortalForm']/a";
			public static final String Logout = Constants.XPATH + "~" + "//*[@id='logoutlink']";
		}

		public static class Verify_Maintabs {
			public static final String WorldViewtab = Constants.XPATH + "~" + "//*[@id='g-header']/div[2]/a[2]";
			public static final String MyInfomediarytab = Constants.XPATH + "~" + "//*[@id='g-header']/div[2]/a[3]";
			public static final String ETFConnecttab = Constants.XPATH + "~" + "//*[@id='g-header']/div[2]/a[4]";	
			public static final String Marketstab = Constants.XPATH + "~" + "//*[@id='g-header']/div[2]/a[5]";
			public static final String BBH_App_Placetab = Constants.XPATH + "~" + "//*[@id='utb-view-mode-quicklink' or @id='utb-edit-mode-quicklink' ]/em";
		}
		
		public static class Reporting {
			public static final String Reporting = Constants.XPATH + "~" +"//*[@id='g-header']/div[3]/ul/li[1]/a";
			public static final String ReportingView = Constants.XPATH + "~" +"//a[@name='ReportView']";
			public static final String Report = Constants.XPATH + "~" +"//option[@value='17067']";
			public static final String Reporttype = Constants.XPATH + "~" +".//option[@value='698']";
			public static final String Frequency = Constants.XPATH + "~" +".//option[@value='Annually']";
			public static final String Submit = Constants.XPATH + "~" +"/html/body/form/div/div/div/table[2]/tbody/tr[4]/td/table/tbody/tr[1]/td/input";
			public static final String ManageReport = Constants.XPATH + "~" +"/html/body/div[1]/span[2]/a/strong";
			public static final String Admin = Constants.XPATH + "~" +"/html/body/div[1]/span[3]/a/strong";
			public static final String MyProfile = Constants.XPATH + "~" +"/html/body/div[1]/span[4]/a/strong";
			public static final String Alltype = Constants.XPATH + "~" +"/html/body/div[3]/div/form/table/tbody/tr[1]/td/div/table/tbody/tr/td[2]/select";
			public static final String Clickonalltype = Constants.XPATH + "~" +".//option[@value='115']";
			public static final String TemplateName = Constants.XPATH + "~" +".//option[@value='21474']";
			public static final String EnterReportname = Constants.XPATH + "~" +"/html/body/div[2]/div/form/table/tbody/tr[3]/td/div/div/table/tbody/tr/td[2]/p/input";
			public static final String ClickonAdd = Constants.XPATH + "~" +"/html/body/div[2]/div/form/table/tbody/tr[3]/td/div/div/table/tbody/tr/td[2]/input[2]";
			public static final String SelectReport = Constants.XPATH + "~" +".//*[text()=' Rpt - NEW']";
			public static final String Delete = Constants.XPATH + "~" +"/html/body/div[2]/div/form/table/tbody/tr[3]/td/div/div/table/tbody/tr/td[4]/input[3]";
			public static final String ViewReport = Constants.XPATH + "~" +"/html/body/div[1]/span[1]/a/strong";
		}
		
		public static class security_Broker_check {
			public static final String ClickOnList= Constants.XPATH + "~" +"//*[@id=\"select1\"]";
			public static final String SelectSecurityDescription = Constants.XPATH + "~" +".//option[@value='SECDESC']";
			public static final String EnterText = Constants.XPATH + "~" +"//*[@id=\"layoutContainers\"]/div/div[2]/div[1]/div[3]/section/div[2]/div[2]/form[1]/input";
			public static final String ClickSearch = Constants.XPATH + "~" +"//*[@id=\"layoutContainers\"]/div/div[2]/div[1]/div[3]/section/div[2]/div[2]/form[1]/a";
			public static final String Clickonitem = Constants.XPATH + "~" +"//*[@id=\"printArea4\"]/table/tbody/tr[1]/td[1]";
			public static final String SECURITYSTATUS = Constants.XPATH + "~" +"//*[@id=\"detTabView\"]/div/table/tbody/tr[10]/td[2]/span/span";
		}
		
		
		public static class TP_OrderManagement {
			public static final String sOrderManagementTab= Constants.XPATH + "~" +"//*[@id='mCSB_1_container']/li[7]/ul/li/a";
			public static final String sCreateOrderTab = Constants.XPATH + "~" +"//*[@id='mCSB_1_container']/li[7]/ul/li/div[1]/ul/li/a";
			public static final String sViewOrderStatusTab = Constants.XPATH + "~" +"//*[@id='mCSB_1_container']/li[7]/ul/li/div[2]/ul/li/a";
			public static final String sConfirmIODTab= Constants.XPATH + "~" +"//*[@id='mCSB_1_container']/li[7]/ul/li/div[3]/ul/li/a";
			public static final String sInvoiceReportTab = Constants.XPATH + "~" +"//*[@id='mCSB_1_container']/li[7]/ul/li/div[4]/ul/li/a";
			public static final String sCreateOrderHeading = Constants.XPATH + "~" +"//*[@id='pageHeading']";
			public static final String sAddNewRecordButton = Constants.XPATH + "~" +"//*[@id='orderDetailsGrid']/div[1]/a";
			public static final String sSaveButton = Constants.XPATH + "~" +"//*[@id='btnSave']";
			public static final String sSubmitButton = Constants.XPATH + "~" +"//*[@id='btnSubmit']";
			public static final String sCancelButton = Constants.XPATH + "~" +"//*[@id='btnCancel']";
			public static final String sPONumber = Constants.XPATH + "~" +"//*[@id='txtPONumber']";
			public static final String sItemCode = Constants.XPATH + "~" +"//*[@id='ItemCode1']";
			public static final String sQuantity = Constants.XPATH + "~" +"//*[@id='OrderQuantity1']";
			public static final String sInventry = Constants.XPATH + "~" +"//*[@id='1']/div";
			public static final String sActionDelete = Constants.XPATH + "~" +"//*[@id='btnDel1']";
			public static final String sSuccessStatus = Constants.XPATH + "~" +"//*[@id='SuccessStatusMsg']";
		}
		
		public static class TP_ViewOrder {
			public static final String sOrderManagementTab= Constants.XPATH + "~" +"//*[@id='mCSB_1_container']/li[7]/ul/li/a";
			public static final String sViewOrderHeading = Constants.XPATH + "~" +"//*[@id='pageHeading']";
			public static final String sViewOrderStatusTab = Constants.XPATH + "~" +"//*[@id='SOIS']";
			public static final String sDatePicker = Constants.XPATH + "~" +"//*[@id='dvSalesInvoiceStatus']/div[1]/div[1]/div[2]/span/span/span";
			public static final String sDatelink = Constants.XPATH + "~" +"//*[@class='k-widget k-calendar']/div[2]/a";
			public static final String sSearchButton = Constants.XPATH + "~" +"//*[@id='btnSearchOrderInvoiceStatus']";
			public static final String sSync = Constants.XPATH + "~" +"//*[@id='content']/div[3]/div/p";
			public static final String sOrderStatus = Constants.XPATH + "~" +"//*[@id='content']/div[3]/div/p";
			public static final String sExportExcel = Constants.XPATH + "~" +"//*[@id='btnExportToExcel']";
			public static final String sExportPDF = Constants.XPATH + "~" +"//*[@id='btnExportToPdf']";
		
		}
		
		public static class TP_GetBackOrder {
			public static final String sOrderManagementTab= Constants.XPATH + "~" +"//*[@id='mCSB_1_container']/li[7]/ul/li/a";
			public static final String sViewOrderHeading = Constants.XPATH + "~" +"//*[@id='pageHeading']";
			public static final String sViewOrderStatusTab = Constants.XPATH + "~" +"//*[@id='mCSB_1_container']/li[7]/ul/li/div[2]/ul/li/a";
			public static final String sDatePicker = Constants.XPATH + "~" +"//*[@id='dvSalesInvoiceStatus']/div[1]/div[1]/div[2]/span/span/span";
			public static final String sDatelink = Constants.XPATH + "~" +"//*[@class='k-widget k-calendar']/div[2]/a";
			public static final String sSearchButton = Constants.XPATH + "~" +"//*[@id='btnSearchOrderInvoiceStatus']";
			public static final String sSync = Constants.XPATH + "~" +"//*[@id='content']/div[3]/div/p";
			public static final String sOrderStatus = Constants.XPATH + "~" +"//*[@id='content']/div[3]/div/p";
			public static final String sGetBackOrder = Constants.XPATH + "~" +"//*[@id='getSchemes']/div/div[1]/ul/li/div[2]/div[1]/div[2]/div[1]/a";
			public static final String sOrderQuantity = Constants.XPATH + "~" +"//*[@id='OrderQuantity1']";
			public static final String sSubmit = Constants.XPATH + "~" +"//*[@id='btnSubmit']";
			public static final String sSuccessMsg = Constants.XPATH + "~" +"//*[@id='SuccessStatusMsg']";
		
		}
		
		public static class TP_ConfirmIOD{
			public static final String sOrderManagementTab= Constants.XPATH + "~" +"//*[@id='mCSB_1_container']/li[7]/ul/li/a";
			public static final String sConfirmIODTab = Constants.XPATH + "~" +"//*[@id='mCSB_1_container']/li[7]/ul/li/div[3]/ul/li/a";
			public static final String sConfirmIODHeading = Constants.XPATH + "~" +"//*[@id='pageHeading']";
			public static final String sCheckbox = Constants.XPATH + "~" +"//*[@id='chk_4']";
			public static final String sCalendarIcon = Constants.XPATH + "~" +"//*[@id='tbodyReceive']/tr[1]/td[4]/span/span/span";
			public static final String sCurrentDate = Constants.XPATH + "~" +"//*[@id='txtReceivingDate_0_dateview']/div/div[2]/a";
			public static final String sRemarks = Constants.XPATH + "~" +"//*[@id='txtInvoiceRemarks_0']";
			public static final String sSavBtn = Constants.XPATH + "~" +"//*[@id='btnConfirm']";
			public static final String sBtnCncl = Constants.XPATH + "~" +"//*[@id='btnCncl']";
			public static final String sfile = Constants.XPATH + "~" +"//*[@class='k-button k-upload-button']/input[@id='files_0']";
		}
		
		public static class TP_InvoiceReport{
			
			public static final String sOrderManagementTab= Constants.XPATH + "~" +"//*[@id='mCSB_1_container']/li[7]/ul/li/a";
			public static final String sInvoiceReportTab = Constants.XPATH + "~" +"//*[@id='IR']";
			public static final String sInvoiceReportHeading = Constants.XPATH + "~" +"//*[@id='pageHeading']";
			public static final String sCalendarIcon = Constants.XPATH + "~" +"//*[@id='invoiceReportPage']/div[1]/div[3]/div[2]/span/span/span";
			public static final String sCalBack = Constants.XPATH + "~" +"//*[@id='txtFromDate_dateview']/div//div[1]/a[1]";
			public static final String sCalMid = Constants.XPATH + "~" +"//*[@id='txtFromDate_dateview']/div//div[1]/a[2]";
			public static final String sCalFrwd = Constants.XPATH + "~" +"//*[@id='txtFromDate_dateview']/div//div[1]/a[3]";
			public static final String sMonthslist = Constants.XPATH + "~" +"//*[@id='txtFromDate_dateview']/div/table/tbody/tr/td/a";
			public static final String sDayslist = Constants.XPATH + "~" +"//*[@id='txtFromDate_dateview']/div/table/tbody/tr/td[not(contains(@class,'k-other-month'))]";
			public static final String sSearchButton = Constants.XPATH + "~" +"//*[@id='SearchButton']";
			public static final String sSaleOrderNumber = Constants.XPATH + "~" +"//*[@id='gridInvoiceReport']/div[2]/table/tbody/tr[1]/td[1]";
			public static final String sExPDF = Constants.XPATH + "~" +"//*[@id='pdf']";
			public static final String sExExcel= Constants.XPATH + "~" +"//*[@id='xl']";
		}
		
		public static class TP_SearchServiceCall
		{
			public static final String sServiceCallLog = Constants.XPATH + "~" +"//*[@id='mCSB_1_container']/li[3]/ul/li/a";
			public static final String sSearchServiceCall = Constants.XPATH + "~" +"//*[@id='mCSB_1_container']/li[3]/ul/li/div[2]/ul/li/a";
			public static final String sMobileRadioButton = Constants.XPATH + "~" +"//*[@id='mobile_']";
			public static final String sMobileNumber= Constants.XPATH + "~" +"//*[@id='mobileNumber']";
			public static final String sSearchButton= Constants.XPATH + "~" +"//*[@id='SearchButton']";
			public static final String sVerifyMobileNumber= Constants.XPATH + "~" +"//*[@id='SearchServiceRequestGrid']/div[2]/table/tbody/tr[1]/td[8]";
			public static final String sJobIDradioButton= Constants.XPATH + "~" +"//*[@id='job_']";
			public static final String sJobIDTestBox= Constants.XPATH + "~" +"//*[@id='jobId']";
			public static final String sSearchServiceCallHeading= Constants.XPATH + "~" +"//*[@id='pageHeading']";
			public static final String sVerifyJobID= Constants.XPATH + "~" +"//*[@id='SearchServiceRequestGrid']/div[2]/table/tbody/tr/td[1]";
			public static final String sExporttoExcelButton= Constants.XPATH + "~" +"//*[@id='btnExportToExcel']";
		}
		
		public static class TP_SubmitCOB
		{
			public static final String sConfirmBalTab= Constants.XPATH + "~" +"//*[@id='mCSB_1_container']/li[6]/ul/li/a";
			public static final String sCOBTab= Constants.XPATH + "~" +"//*[@id='mCSB_1_container']/li[6]/ul/li/div/ul/li/a";
			public static final String sDDArrow= Constants.XPATH + "~" +"//*[@id='content']/div[1]/div[1]/div[5]/div[2]/span/span/span[2]";
			public static final String sCOBHeading= Constants.XPATH + "~" +"//*[@id='pageHeading']";
			public static final String sDDValues= Constants.XPATH + "~" +"//*[@id='ddlMonth_listbox']/li";
			public static final String sSrchBtn= Constants.XPATH + "~" +"//*[@id='btnGetCOB']";
			public static final String sVerifyCOB= Constants.XPATH + "~" +"//*[@id='COBTemplateText']/div[2]/h5";
		}
		
		public static class TP_AccountStatement{
			
			public static final String sAccountStatmentTab= Constants.XPATH + "~" +"//*[@id='mCSB_1_container']/li[4]/a";
			public static final String sAccountStatmentHeading= Constants.XPATH + "~" +"//*[@id='pageHeading']";
			public static final String sSearchBtn = Constants.XPATH + "~" +"//*[@id='pageHeading']";
			public static final String ExportPDF = Constants.XPATH + "~" +"//*[@id='accountStatementPdf']";
			public static final String ExportExcel = Constants.XPATH + "~" +"//*[@id='xl']";
		}
		
		
		public static class TP_Dashboard{
			
			public static final String sLatestNewslink= Constants.XPATH + "~" +"//*[@id='content']/div[2]/div[1]/div[2]/div[1]/div/h4/a";
			public static final String sAnnocementlink= Constants.XPATH + "~" +"//*[@id='content']/div[2]/div[1]/div[2]/div[2]/div/h4/a";
			public static final String sActiveScheme = Constants.XPATH + "~" +"//*[@id='projects-collection']/li/span/a";
			public static final String NotificationLink= Constants.XPATH + "~" +"//*[@id='notifications-collection']/li[1]/span/a";
			public static final String PageHeading = Constants.XPATH + "~" +"//*[@id='pageHeading']";
			public static final String BackDashboard = Constants.XPATH + "~" +"//*[@id='breadcrumbs-wrapper']/div/div/div[1]/div/ol/li[1]/a";
														
		}
		
		public static class TP_MyRequestStatus{
			
			public static final String sEntityApprovalProcessTab= Constants.XPATH + "~" +"//*[@id='mCSB_1_container']/li[8]/ul/li/a";
			public static final String sMyRequestTab= Constants.XPATH + "~" +"//*[@id='mCSB_1_container']/li[8]/ul/li/div/ul/li/a";
			public static final String sPageHeading = Constants.XPATH + "~" +"//*[@id='pageHeading']";
			public static final String sSearchButton = Constants.XPATH + "~" +"//*[@id='btnSearch']";
			public static final String sActionIcon = Constants.XPATH + "~" +"//*[@id='gridStatus']/div[2]/table/tbody/tr[1]/td[7]/a[2]";
			public static final String sCloseIcon = Constants.XPATH + "~" +"//*[@id='modalEntityApprovalDetail']/a";
			public static final String sExprtExcel = Constants.XPATH + "~" +"//*[@id='btnExportToExcel']";
			
		}
		
			public static class TP_LockedUnlockUser{
			
			public static final String sUsername= Constants.XPATH + "~" +"//*[@id='txtUserName']";
			public static final String sSchemeInformation= Constants.XPATH + "~" +"//*[@id='SCI']";
			public static final String sPassword= Constants.XPATH + "~" +"//*[@id='txtPassword']";
			public static final String sLoginButton = Constants.XPATH + "~" +".//*[@id='btnLogin']";
			public static final String sUserlockedmsg = Constants.XPATH + "~" +"//*[@id='txtErrorMssgLogin']";
			public static final String sUserMgtTab = Constants.XPATH + "~" +"//*[@id='mCSB_1_container']/li[12]/ul/li/a";
			public static final String sUnlockUserTab = Constants.XPATH + "~" +"//*[@id='UU']";
			public static final String sUnlockcheckbox = Constants.XPATH + "~" +"//*[@id='selectAllCU']";
			public static final String sUnlockuserbutton = Constants.XPATH + "~" +"//*[@id='btnUnlockUser']";
			public static final String sUnlockuserMsg = Constants.XPATH + "~" +"//*[@id='SuccessStatusMsg']";
			public static final String sScrollbar = Constants.XPATH + "~" +"//*[@id='mCSB_1_dragger_vertical']/div";
		}
			
			
	
}
