/**
*
* Test Script Name                   :NA
* Objective                          :Verify System Management Distribution Functionality.
* Version                            :1.0
* Author                             :Kathirvelu Mohan
* Created Date                       :8/09/2023
* Last Updated on                    :N/A
* Updated By                         :Arun Kumar MS
* Pre-Conditions                     :N/A
* Epic Details                       :N/A
* User Story Details                 :N/A
**/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.util.Map;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.internal.TestMethodWithDataProviderMethodWorker;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;

public class AdminSystemMngDistributionPage extends BasePage {

	public AdminSystemMngDistributionPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Admin_DistRecordofpostingsym)
	public WebElement RecordofPosting ;

	public boolean Exists() {
		return super.Exists(RecordofPosting);
	}
	

	//Function Summary  : Method to navigate to distribution page
	//Parameter Summary : N/A	
	public void NavigateToDistribution(Log Log) throws InterruptedException {
		WebClick(EdaatOR.Admin_SysMng);
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Admin_DistBtn);
		Thread.sleep(1000);
    	Log.ReportEvent("PASS", " Navigate to Distribution page is Successful");

	}
	//Function Summary  : Method to Verify Distribution Record of Posting View
	//Parameter Summary : N/A	
public void VerifyRecordofpostingview(Map<Object, Object> testdatamap,Log Log) {
		try {

            WebClick(EdaatOR.Admin_SysMng);
            Thread.sleep(1000);
            WebClick(EdaatOR.Admin_DistBtn);
            Thread.sleep(1000);
            WebClick(EdaatOR.Admin_DistRecordofposting);
            Thread.sleep(1000);
            WebEdit(EdaatOR.Admin_BatchNo,testdatamap.get("BatchNo").toString());
            WebClick(EdaatOR.Admin_ClickFromdate);
            selectDropdownValue_PartialText(EdaatOR.Admin_ClickFromyear,testdatamap.get("Fromyear").toString());
            Thread.sleep(500);
            selectDropdownValue_PartialText(EdaatOR.Admin_ClickFrommonth,testdatamap.get("FromMonth").toString());
            WebClick("//a[text()='"+testdatamap.get("Fromdate").toString()+"']");
            WebClick(EdaatOR.Admin_ClickTodate);
            selectDropdownValue_PartialText(EdaatOR.Admin_ClickToyear,testdatamap.get("Toyear").toString());
            Thread.sleep(500);
            selectDropdownValue_PartialText(EdaatOR.Admin_ClickTomonth,testdatamap.get("ToMonth").toString());
            WebClick("//a[text()='"+testdatamap.get("Todate").toString()+"']");
            WebClick(EdaatOR.Admin_Button);
            Thread.sleep(2000);
            verifyElementIsPresent("//span[text()='"+testdatamap.get("BatchNo").toString()+"']");            
            this.takeScreenShot();
            test.log(Status.PASS,"#FUNC-Verify Distribution Record of Posting Grid View" + driver.getTitle() +" * Distribution Record of Grid View is successfull PASS * " );
        	Log.ReportEvent("PASS", " Verify Distribution Record of Posting view is Successful");

		}

        catch (Exception e) {
            test.log(Status.FAIL,"#FUNC-Verify Distribution Record of Posting Grid View" + driver.getTitle() +" * Distribution Record of Posting Grid View is unsuccessfull FAIL * " );
        }
    }
    
    
	//Function Summary  : Method to Navigate Daily transfer Record
	//Parameter Summary : N/A	
	public void NavigateDailytransferRecord() throws InterruptedException
	{
		WebClick(EdaatOR.Admin_SysMng);
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_DistBtn);
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_DistRecordoftransferlink);
		Thread.sleep(1000);
	}

	//Function Summary  : Method to Verify Daiy transfered Record
	//Parameter Summary : RequestNumber,RequestStatus,TransferStatus
	public void DaiytransferedRecord(Map<Object, Object> testdatamap,Log Log) throws InterruptedException
	{
		try {
		     NavigateDailytransferRecord();
		     WebEdit(EdaatOR.AdminSys_Distri_record_Recnum,testdatamap.get("RequestNumber").toString());
		     SelectDate1( testdatamap);
	       	 WebClick(EdaatOR.AdminSys_Distri_Requeststatus);
		     Thread.sleep(1000);
	       	 WebClick("//select[@id='BulkTransferRequestStatuses']//option[text()='"+testdatamap.get("RequestStatus").toString()+"']");
		     Thread.sleep(1000);
	       	 WebClick(EdaatOR.AdminSys_Distri_Transferstatus);
	         Thread.sleep(1000);
	       	 WebClick("//select[@id='BulkTransferRequestBillerStatuses']//option[text()='"+testdatamap.get("TransferStatus").toString()+"']");
		     Thread.sleep(2000);
	       	 WebClickUsingJS(EdaatOR.AdminSys_Distri_recordsearchbtn);
		     Thread.sleep(1000);
		     VerifyValue1(getText(EdaatOR.AdminSys_Distri_recordsearch_verify),testdatamap.get("RequestNumber").toString());
		     test.log(Status.PASS,"#FUNC-Daiy transfered Record" + driver.getTitle() +" * Daiy transfered Record is pass* " );
			this.takeScreenShot();
			Log.ReportEvent("PASS", " Verify Daily Transfer Record Functionality is Successful");

		}
		catch(Exception e){
		     test.log(Status.FAIL,"#FUNC-Daiy transfered Record" + driver.getTitle() +" * Daiy transfered Record is Fail* " );
			 e.printStackTrace();
		}
		
	}
	public void verifyDailyFileExportingSADADPage(Map<Object, Object> testdatamap,Log Log)
	{
		try
		{
			Thread.sleep(2000);
			VerifyValue1(getText("//h6[text()='"+testdatamap.get("LabelName").toString()+"']"),testdatamap.get("LabelName").toString());
			Thread.sleep(1000);
			this.takeScreenShot();
			test.log(Status.PASS,"#FUNC-verifyDailyFileExportingSADADPage " + driver.getTitle() +" * Verify Daily File Exporting Lalel(SADAD) PASS * " );
        	Log.ReportEvent("PASS", " Verify the Daily File Exporting functionality is Successful");

		}
		catch (Exception e) {
			
			test.log(Status.FAIL,"#FUNC-verifyDailyFileExportingSADADPage " + driver.getTitle() +" * Verify Daily File Exporting Lalel(SADAD) FAIL * " );

		}
	}	
	
		//Function Summary  : Method to NavigateDailyFileExport
	//Parameter Summary : N/A
		public void NavigateDailyFileExport(Log Log) throws Exception
		{
			Thread.sleep(2000);
			WebClick(EdaatOR.Admin_SysMng);
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_DistBtn);
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_Dist_DailyfileExporting);
			Thread.sleep(1000);
        	Log.ReportEvent("PASS", " Navigate to Distribution Daily File Exporting Page");

		}
		
			//Function Summary  : Method to SelectDate
		//Parameter Summary : FromYear,FromMonth,FromDate,ToYear,ToMonth,ToDate
		public void SelectDate(Map<Object,Object>testdatamap)
	  	{
	  		try {
	  		WebClick(EdaatOR.Admin_Dist_ExportFromd);
	  		selectDropdownValue_PartialText(EdaatOR.Admin_Dist_ExportFromyear,testdatamap.get("FromYear").toString());
	      	selectDropdownValue_PartialText(EdaatOR.Admin_Dist_ExportFromon,testdatamap.get("FromMonth").toString());
	      	WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
	      	WebClick(EdaatOR.Admin_Dist_ExportTod);
	      	selectDropdownValue_PartialText(EdaatOR.Admin_Dist_ExportToyear,testdatamap.get("ToYear").toString());
	      	selectDropdownValue_PartialText(EdaatOR.Admin_Dist_Exportomon,testdatamap.get("ToMonth").toString());
	      	Thread.sleep(1000);
	      	WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
	  		}
	  		catch (Exception e) {
	  			e.printStackTrace();
	  			this.takeScreenShot();
	  		}
	  		
	  	}
		
		//Function Summary  : Method to Select Date
		//Parameter Summary : Reqyear,Reqmonth,Reqdate,Reconcileyear,Reconcilemonth and ReconcileDate.
			public void SelectDate1(Map<Object, Object> testdatamap)
			{
		     try {
		    	WebClick(EdaatOR.AdminSys_Distri_Reqd);
				selectDropdownValue_PartialText(EdaatOR.AdminSys_Distri_Reqyear,testdatamap.get("Reqyear").toString());
		        selectDropdownValue_PartialText(EdaatOR.AdminSys_Distri_ReqMon,testdatamap.get("Reqmonth").toString());
		        WebClick("//a[text()='"+testdatamap.get("Reqdate").toString()+"']");
		        Thread.sleep(1000);
		        WebClick(EdaatOR.AdminSys_Distri_Recond);
		        Thread.sleep(1000);
		        selectDropdownValue_PartialText(EdaatOR.AdminSys_Distri_Recon_Toyear,testdatamap.get("Reconcileyear").toString());
		        Thread.sleep(1000);
		        selectDropdownValue_PartialText(EdaatOR.AdminSys_Distri_Recon_Tomon,testdatamap.get("Reconcilelmonth").toString());
		        Thread.sleep(1000);
		        WebClick("//div[@class='calendars']//a[text()='"+testdatamap.get("ReconcileDate").toString()+"']");
		       //WebClick("//a[text()='"+testdatamap.get("ReconcileDate").toString()+"'])[2]");
				test.log(Status.PASS,"#FUNC-Select Date" + driver.getTitle() +" * Select Date is pass* " );
				this.takeScreenShot();

				}
				catch(Exception e){
					test.log(Status.FAIL,"#FUNC-Select Date" + driver.getTitle() +" * Select Date is FAIL* " );
					e.printStackTrace();
				}
			}
	//Function Summary  : Method to AddTransferRequest
	//Parameter Summary : N/A			
	public void AddTransferRequest(Map<Object, Object> testdatamap) throws InterruptedException {
		WebClick(EdaatOR.Admin_AddTransferRequest);
		switchToWindow();
		ReconcilledDateSearch(testdatamap);
		WebClick(EdaatOR.Admin_B2BCheckbox);
		WebClick(EdaatOR.Admin_SendTransferRequestBTn);
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_TransferRequestYesBTn);
		Thread.sleep(1000);

	
	}
	//Function Summary  : Method to ReconcilledDateSearch
	//Parameter Summary : Month,Year,Date
	public void ReconcilledDateSearch(Map<Object, Object> testdatamap) throws InterruptedException {
		WebClick(EdaatOR.Admin_DailyTransReconciledCalender);
		selectDropdownValue_PartialText(EdaatOR.Admin_ReconciledMonth, testdatamap.get("Month").toString());
		selectDropdownValue_PartialText(EdaatOR.Admin_ReconciledYear, testdatamap.get("Year").toString());
		WebClick("//a[text()='"+testdatamap.get("Date").toString()+"']");
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_ReconciledSearchBtn);
		Thread.sleep(2000);

	}

	//Function Summary  : Method to Verify Distribution Record of Posting View
	//Parameter Summary : N/A	
	public void VerifyDailyTransfer(Map<Object, Object> testdatamap,Log Log) {
		try {
			WebClickUsingJS(EdaatOR.Admin_DistDailyTransferPage);
			//AddTransferRequest(testdatamap);
			ReconcilledDateSearch(testdatamap);
			Thread.sleep(3000);
			this.takeScreenShot();
			WebClick(EdaatOR.Admin_viewRequest);
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_CloseRequest);
            Thread.sleep(1000);
			test.log(Status.PASS,"#FUNC-Verify Distribution Daily transfer " + driver.getTitle() +" *  Distribution Daily transfer view is successfull PASS * " );
        	Log.ReportEvent("PASS", " Verify Daily transfer requests is Successful");

		}
		catch (Exception e) {
			test.log(Status.FAIL,"#FUNC-Verify Distribution Daily transfer" + driver.getTitle() +" * Verify Distribution Daily transfer View is unsuccessfull FAIL * " );
		}
		
		
	}
	//Function Summary  : Method to EnterSearchitem
	//Parameter Summary : MainBiller,TransferStatus
	public void EnterSearchitem(Map<Object, Object> testdatamap) throws InterruptedException {
		
			WebClick(EdaatOR.Admin_Dist_BillerName);
			Thread.sleep(1000);
			WebClickUsingActions("//li[text()='"+testdatamap.get("MainBiller").toString()+"']");
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Admin_Dist_TransferStatus,testdatamap.get("TransferStatus").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_Dist_Export_srcbtn);
			Thread.sleep(2000);
			this.takeScreenShot();
		}
	
//Function Summary  : Method to VerifyDailyFileExporting
	//Parameter Summary : N/A	
	public void VerifyDailyFileExporting(Map<Object, Object> testdatamap,Log Log)
	{
		try
		{
			SelectDate(testdatamap);
			Thread.sleep(2000);
			EnterSearchitem(testdatamap);
			VerifyValue1(getText("//td[text()='"+testdatamap.get("MainBiller").toString()+"']"),testdatamap.get("MainBiller").toString());
			Thread.sleep(1000);
			this.takeScreenShot();
			test.log(Status.PASS,"#FUNC-Distribution Daily File Exporting " + driver.getTitle() +" * Verify Daily File Exporting PASS * " );
        	Log.ReportEvent("PASS", " Verify the Daily File Exporting functionality is Successful");

		}
		catch (Exception e) {
			
			test.log(Status.FAIL,"#FUNC-Distribution Daily File Exporting " + driver.getTitle() +" * Verify Daily File Exporting FAIL * " );

		}
	}	
	//Function Summary  : Method to VerifyDailyTransferErrorMsg
	//Parameter Summary : Expected	
		public void VerifyDailyTransferErrorMsg(Map<Object, Object> testdatamap) {
			try {
				WebClickUsingJS(EdaatOR.Admin_DistDailyTransferPage);
				WebClick(EdaatOR.Admin_AddTransferRequest);
				switchToWindow();
				ReconcilledDateSearch(testdatamap);
				WebClick(EdaatOR.Admin_ManualCheckbox);
				WebClick(EdaatOR.Admin_SaveButton);				
				if(ExistsCheck(EdaatOR.Admin_DistReason)&&ExistsCheck(EdaatOR.Admin_DistAttachment)&&ExistsCheck(EdaatOR.Admin_DistDate))
				{
					VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Admin_DistReason);
					Thread.sleep(1000);
					VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Admin_DistAttachment);
					Thread.sleep(1000);
					VerifyValue(testdatamap.get("DateError").toString(),EdaatOR.Admin_DistDate);
					this.takeScreenShot();
					Thread.sleep(1000);
					test.log(Status.PASS, "#FUNC-Transfer Date,Type/Reason and Attachment ErrorMessage Exists" + driver.getTitle() + " * Transfer Date,Type/Reason and Attachment ErrorMessage Exists * ");
				}
				else
				{
					test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");

				}
			}
			catch (Exception e) {
				test.log(Status.FAIL,"#FUNC-Verify Distribution Daily transfer" + driver.getTitle() +" * Verify Distribution Daily transfer View is unsuccessfull FAIL * " );
			}
}
		//Function Summary  : Method to VerifyEODSettlementReportErrorMsg
		//Parameter Summary : Expected	
		public void VerifyEODSettlementReportErrorMsg(Map<Object, Object> testdatamap) {
			
			try {
				WebClickUsingJS(EdaatOR.Admin_Dist_EODSettlement);
				Thread.sleep(1000);
				WebClick(EdaatOR.Admin_Dist_EODSettlementSearchbtn);
				Thread.sleep(1000);
				if(ExistsCheck(EdaatOR.Admin_Dist_EODSettlementErrorMsg))
				{
					VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Admin_Dist_EODSettlementErrorMsg);
					Thread.sleep(1000);
					this.takeScreenShot();
					test.log(Status.PASS, "#FUNC-Date ErrorMessage Exists" + driver.getTitle() + " * Date ErrorMessage Exists * ");
				}
				else
				{
					test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");

				}
				
			} catch (Exception e) {
							
				test.log(Status.FAIL,"#FUNC-Verify Distribution EOD Settlement" + driver.getTitle() +" * Verify Distribution EOD Settlement is unsuccessfull FAIL * " );
				this.takeScreenShot();
			}
			
		}
		//Function Summary  : Method to Verify Daily file exporting [Hyper pay]
		//Parameter Summary : N/A	
		public void VerifyDailyFileExportingHyperPay(Log Log) {
			try {

				Thread.sleep(2000);
				verifyElementIsPresent(EdaatOR.Admin_Dist_DailyfileExporting, "Daily file exporting");
				this.takeScreenShot();
				test.log(Status.PASS,"#FUNC-Verify Daily file exporting [Hyper pay] " + driver.getTitle() +" *  Verify Daily file exporting [Hyper pay] view is successfull PASS * " );
	        	Log.ReportEvent("PASS", " Verify Daily file exporting [Hyper pay] is Successful");

			}
			catch (Exception e) {
				test.log(Status.FAIL,"Verify Daily file exporting [Hyper pay]" + driver.getTitle() +" * Verify Distribution Daily transfer View is unsuccessfull FAIL * " );
			}
			
			
		}		
}
