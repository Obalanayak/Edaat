/**
*
* Test Script Name                   :NA
* Objective                          :AdminSystemManagement functionality
* Version                            :1.0
* Author                             :Kathirvelu M
* Created Date                       :8/09/2023
* Last Updated on                    :N/A
* Updated By                         :Kalpana I R
* Pre-Conditions                     :N/A
* Epic Details                       :N/A
* User Story Details                 :N/A
**/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.io.EOFException;
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

public class AdminSystemMngCorporateclientMngpage extends BasePage {

	public AdminSystemMngCorporateclientMngpage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Systemmgmt_Menu)
	public WebElement Client;
	private Map<Object, Object> testdatamap;

	public boolean Exists() {
		return super.Exists(Client);
	}
	
	//Function Summary  : Method to NavigatetoCorporateClientsMng
	//Parameter Summary : N/A

	public void NavigatetoCorporateClientsMng(Log Log) throws InterruptedException {
		WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
		Thread.sleep(2000);
        WebClickUsingJS(EdaatOR.Admin_SysMgmClient_CorpoclientMgmMenu);
		Thread.sleep(2000);	
    	Log.ReportEvent("PASS", " Navigate to Corporate Clients Management page");

	}
	//Function Summary  : Method to Entersearchitem
	//Parameter Summary : Corporatename,crnumber
	public void Entersearchitem(Map<Object, Object> testdatamap) throws InterruptedException {
		
		WebEdit(EdaatOR.Admin_Corporatename_efield,testdatamap.get("Corporatename").toString());
		WebEdit(EdaatOR.Admin_CorporateClient_crefield,testdatamap.get("crnumber").toString());
		Thread.sleep(1000);
		SelectClientDropdown(testdatamap);
		WebClick(EdaatOR.Admin_Corporateclient_srchbtn);
		Thread.sleep(1000);
		takeScreenShot();
	}
	//Function Summary  : Method to VerifyCorporatenameClick
	//Parameter Summary : Corporatename
	public void VerifyCorporatenameClick(Map<Object, Object> testdatamap,Log Log) {
	
	try {
		Entersearchitem(testdatamap);
		WebClick("//a[text()='"+testdatamap.get("Corporatename").toString()+"']");
		switchToWindow();
		VerifyValue1(getText("//h6[text()='"+testdatamap.get("Corporatename").toString()+"']"),testdatamap.get("Corporatename").toString());
		this.takeScreenShot();
		test.log(Status.PASS,"#FUNC-Verify Corporate Client name is clickable" + driver.getTitle() +" * Corporatee Client name click is successfull PASS * " );
    	Log.ReportEvent("PASS", " Verify Corprate name click functionality is Suceessful");

	}
	catch (Exception e) {
		test.log(Status.FAIL,"#FUNC-Verify Corporate Client name is clickable" + driver.getTitle() +" * Corporatee Client name click is unsuccessfull FAIL * " );
	}
		}
//Function Summary  : Method to select client status dropdown
	//Parameter Summary : Client Status
	public void SelectClientDropdown(Map<Object, Object> testdatamap)
    {
        WebClick(EdaatOR.Admin_SymCorpoClientstatus);
        WebClick("//option[text()='"+testdatamap.get("Client Status").toString()+"']");
    
    }
//Function Summary  : Method to Verify Request Record Button
//Parameter Summary : HistoryPopup
	public void VerifyRequestRecordButton(Map<Object, Object> testdatamap,Log Log) {
		
		try {
			NavigatetoCorporateClientsMng(Log);
			Entersearchitem(testdatamap);
			Thread.sleep(2000);			
			WebClick(EdaatOR.Admin_Corporateclient_RecordBtn);
			Thread.sleep(2000);
			VerifyValue1(getText(EdaatOR.Admin_Corporateclient_HistoryPopup),testdatamap.get("HistoryPopup").toString());
			this.takeScreenShot();
			test.log(Status.PASS,"#FUNC-Verify Request Record button " + driver.getTitle() +" * Corporatee Client Request Record button click is successfull PASS * " );
        	Log.ReportEvent("PASS", " Verify Request Record button clickable is Suceessful");

		}
		catch (Exception e) {
			test.log(Status.FAIL,"#FUNC-Verify Request Record button" + driver.getTitle() +" * Corporatee Client Request Record button click is Unsuccessfull FAIL * " );
		}
		
			
		}
//Function Summary  : Method to Verify Corporate Client Management Search 
//Parameter Summary : ClientStatus
	public void CarporateclientSearch(Map<Object, Object> testdatamap,Log Log) throws InterruptedException
	{
		try {
		NavigatetoCorporateClientsMng(Log);
		WebEdit(EdaatOR.Admin_SymCorpoName,testdatamap.get("Corporatename").toString());
		Thread.sleep(2000);
		WebEdit(EdaatOR.Admin_SymCorpoCrNumber,testdatamap.get("crnumber").toString());
		Thread.sleep(2000);
		SelectClientDropdown(testdatamap);
		WebClick(EdaatOR.Admin_Corporateclient_srchbtn);
		this.takeScreenShot();
		VerifyValue1(getText("//a[text()='"+testdatamap.get("Corporatename").toString()+"']/ancestor::tr//td[4]"),testdatamap.get("crnumber").toString());
		Thread.sleep(2000);
		this.takeScreenShot();
		test.log(Status.PASS,"#FUNC-Verify Corporate Client Search" + driver.getTitle() +" * Corporate Client Search is successfull PASS * " );
    	Log.ReportEvent("PASS", " Verify The Corporate Client search functionality is Successful");

		}
		catch (Exception e) {
			test.log(Status.FAIL,"#FUNC-Verify Corporate Client Search" + driver.getTitle() +" * Corporate Client Search is unsuccessfull FAIL * " );

		}			
		}
	//Function Summary  : Method to VerifyCorporateClientStatustoggel
	//Parameter Summary : Corporatename,crnumber,Active,CorporateName,InActive
	public void VerifyCorporateClientStatustoggel(Map<Object, Object> testdatamap) {	
		try
		{
			if(CheckElementExists("//h5[text()='"+testdatamap.get("Active").toString()+"']")==true)
			{
			VerifyValue1(getText("//h5[text()='"+testdatamap.get("Active").toString()+"']"),testdatamap.get("Active").toString());
			Thread.sleep(2000);
			this.takeScreenShot();
			WebEdit(EdaatOR.Admin_Symstatustoggletextarea,testdatamap.get("Textarea").toString());
			Thread.sleep(2000);
			WebClick(EdaatOR.Admin_Symstatustoggleyesbtn);
			WebClick("//a[text()='"+testdatamap.get("CorporateName").toString()+"']//ancestor::tr//label[1]");
			Thread.sleep(2000);
			this.takeScreenShot();
			VerifyValue1(getText("//h5[text()='"+testdatamap.get("InActive").toString()+"']"),testdatamap.get("InActive").toString());
			WebEdit(EdaatOR.Admin_Symstatustoggletextarea,testdatamap.get("Textarea").toString());
			Thread.sleep(2000);
			this.takeScreenShot();
			WebClick(EdaatOR.Admin_Symstatustoggleconformactivation);
			Thread.sleep(2000);
			this.takeScreenShot();		
			}
			else
			{
				VerifyValue1(getText("//h5[text()='"+testdatamap.get("InActive").toString()+"']"),testdatamap.get("InActive").toString());
				Thread.sleep(2000);
				this.takeScreenShot();
				WebEdit(EdaatOR.Admin_Symstatustoggletextarea,testdatamap.get("Textarea").toString());
				Thread.sleep(2000);
				WebClick(EdaatOR.Admin_Symstatustoggleyesbtn);
				Thread.sleep(1000);
				WebClick("//a[text()='"+testdatamap.get("CorporateName").toString()+"']//ancestor::tr//label[1]");
				Thread.sleep(2000);
				this.takeScreenShot();
				VerifyValue1(getText("//h5[text()='"+testdatamap.get("Active").toString()+"']"),testdatamap.get("Active").toString());
				WebEdit(EdaatOR.Admin_Symstatustoggletextarea,testdatamap.get("Textarea").toString());
				Thread.sleep(2000);
				this.takeScreenShot();
				WebClick(EdaatOR.Admin_Symstatustoggleconformactivation);
				Thread.sleep(2000);
				this.takeScreenShot();
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			this.takeScreenShot();
		}
	}
//Function Summary  : Method to Verify Corporate Client Statustoggle
//Parameter Summary : Corporatename,crnumber
	public void CorporateClientStatustoggle(Map<Object, Object> testdatamap,Log Log)
	{
		try {
			NavigatetoCorporateClientsMng(Log);
			WebEdit(EdaatOR.Admin_SymCorpoName,testdatamap.get("CorporateName").toString());
			Thread.sleep(2000);
			WebEdit(EdaatOR.Admin_SymCorpoCrNumber,testdatamap.get("CRNumber").toString());
			Thread.sleep(2000);
			SelectClientDropdown(testdatamap);
			WebClick(EdaatOR.Admin_Corporateclient_srchbtn);
			WebClick("//a[text()='"+testdatamap.get("CorporateName").toString()+"']//ancestor::tr//label[1]");
			VerifyCorporateClientStatustoggel(testdatamap);
			Thread.sleep(2000);
			this.takeScreenShot();
			test.log(Status.PASS,"#FUNC-Verify Corporate Client Status toggle button" + driver.getTitle() +" * Corporate Client Status toggle button is successfull PASS * " );
        	Log.ReportEvent("PASS", " Verify Corporate Client status toggle is Successful");

		}
		catch (Exception e) {
			test.log(Status.FAIL,"#FUNC-Verify Corporate Client Status toggle button" + driver.getTitle() +" * Corporate Client Status toggle button is unsuccessfull FAIL * " );

		}
	}

//Function Summary  : Method to Verify Corporate Client Management Search based on Registered,added and Approved
//Parameter Summary : ClientStatus
	public void CorporateClientManagementSearch(Map<Object, Object> testdatamap,Log Log)
	{
			try {
				NavigatetoCorporateClientsMng(Log);
				Thread.sleep(2000);
			      String clientstatus = testdatamap.get("ClientStatus").toString();
			      if(clientstatus.equalsIgnoreCase("registered")||clientstatus.equalsIgnoreCase("approved"))
			      {
			       selectDropdownValue_PartialText(EdaatOR.AdminSystem_Corporate_Clientstatus,clientstatus);
			       Thread.sleep(2000);
			       WebClick(EdaatOR.AdminSystem_Corporate_Searchbtn);
			       Thread.sleep(2000);
			       this.takeScreenShot();
			       VerifyValue1(getText(EdaatOR.Admin_Sys_CorpVerify),"Yes");
			     }
			    else {
			       selectDropdownValue_PartialText(EdaatOR.AdminSystem_Corporate_Clientstatus,clientstatus);
			       Thread.sleep(2000);
			       WebClick(EdaatOR.AdminSystem_Corporate_Searchbtn);
			       Thread.sleep(2000);
			       this.takeScreenShot();
			       VerifyValue1(getText(EdaatOR.Admin_Sys_CorpVerify),"No");
			    }    
			    test.log(Status.PASS,"#FUNC-Verify to search based on the Client status" + driver.getTitle() +" * search based on the Client status  PASS * " );
				Log.ReportEvent("PASS", " Verify to search based on the Client status [Registered,Added,Approved] is Suceessful");

			}
			 catch (Exception e) {
			    test.log(Status.FAIL,"#FUNC-Verify to search based on the Client status" + driver.getTitle() +" *  search based on the Client status  FAIL * " );
			 }        
		
		}
//Function Summary  : Method to Verify CorporateClient Management GridView
	//Parameter Summary : N/A
	public void CorporateclientMgmGridView(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
		try {
			NavigatetoCorporateClientsMng(Log);
			verifyElementIsPresent(EdaatOR.Admin_SysMgm_CorpoclientDetails);
			Thread.sleep(2000);
			this.takeScreenShot();
			test.log(Status.PASS,"#FUNC-Verify CorporateClient Management GridView" + driver.getTitle() +" * CorporateClient Management GridView is successfull* " );
        	Log.ReportEvent("PASS", " Verify Corporate Client Management Gridview Details are Suceessful");

		} 
		catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL,"#FUNC-Verify CorporateClient Management GridView" + driver.getTitle() +" * CorporateClient Management GridView is FAIL * " );

		}
	}
	//Function Summary  : Method to VerifyCorporatenameClick
	//Parameter Summary : Corporatename
	public void SuspendAccount(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
		WebClick(EdaatOR.Admin_CorpMGMSettingBtn);
		Thread.sleep(1000);
	    String client=testdatamap.get("AccountStatus").toString();
        if(client.equalsIgnoreCase("Suspended")) {
            WebClickUsingJS(EdaatOR.Admin_CorpMGMSuspendBtn);
            Thread.sleep(1000);
        }
        else{
            WebClickUsingJS(EdaatOR.Admin_CorpMGMSuspendPermanentyBtn);
            Thread.sleep(1000);
        }
        WebClick(EdaatOR.Admin_CorpMGMSuspendReasonDrop);
        Thread.sleep(800);
        WebClick(EdaatOR.Admin_CorpMGMSuspendReason);
        WebClick(EdaatOR.Admin_CorpMGMSuspendYesBtn);
		Thread.sleep(800);
		
	}
	//Function Summary  : Method to Search corporate client
	//Parameter Summary : CompanyName
	public void SearchcorpClient(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
		NavigatetoCorporateClientsMng(Log);
		WebEdit(EdaatOR.Admin_SymCorpoName,testdatamap.get("CompanyName").toString());
		Thread.sleep(1000);
		SelectClientDropdown(testdatamap);
		WebClick(EdaatOR.Admin_Corporateclient_srchbtn);
		
	}
	
	
	//Function Summary  : Method to verify settings button
	//Parameter Summary : AccountStatus
	public void CorporateClientSettingsBtn(Map<Object, Object> testdatamap,Log Log)
	{
		try {
			SearchcorpClient(testdatamap,Log);
			Thread.sleep(800);
			SuspendAccount(testdatamap,Log);
			SearchcorpClient(testdatamap,Log);
			Thread.sleep(800);
			verifyElementIsPresent("//td[contains(text(),'"+testdatamap.get("AccountStatus").toString()+"')]");
			this.takeScreenShot();
			test.log(Status.PASS,"#FUNC-Verify Corporate settings button" + driver.getTitle() +" * Corporate Client settings button is successfull PASS * " );
        	Log.ReportEvent("PASS", "Verify corporate client settings button is Sucessful");

		}
		catch (Exception e) {
			test.log(Status.FAIL,"#FUNC-Verify Corporate settings button" + driver.getTitle() +" * Verify Corporate settings button is unsuccessfull FAIL * " );

		}
	}

	public void CorporateClientSettingsBtnErrorMsg(Map<Object, Object> testdatamap,Log Log) {
		
		try {
			String client=testdatamap.get("AccountStatus").toString();
			SearchcorpClient(testdatamap,Log);
			Thread.sleep(800);
			WebClick(EdaatOR.Admin_CorpMGMSettingBtn);
			Thread.sleep(1000);
	        if(client.equalsIgnoreCase("Suspended Permanently")) {
	            WebClickUsingJS(EdaatOR.Admin_CorpMGMSuspendBtn);
	            Thread.sleep(1000);
	        }
	        else if(client.equalsIgnoreCase("Suspended")){
	            WebClickUsingJS(EdaatOR.Admin_CorpMGMSuspendPermanentyBtn);
	            Thread.sleep(1000);
	        }
			WebClickUsingJS(EdaatOR.Admin_CorpMGMSuspendYesBtn);
		      if(ExistsCheck(EdaatOR.AdminSystem_Corporate_Accountstatuserrormsg))
		      {
		    	  
		    	  VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.AdminSystem_Corporate_Accountstatuserrormsg);
		    	  this.takeScreenShot();
		    	  test.log(Status.PASS, "#FUNC-Corporate clients Account status ErrorMessage Exists" + driver.getTitle() + " * Account Status ErrorMessage Exists * ");
		      }
		      else if(ExistsCheck(EdaatOR.AdminSystem_Corporate_SuspendReasonerrormsg)){
		    	  
		    	  VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.AdminSystem_Corporate_SuspendReasonerrormsg);
		    	  this.takeScreenShot();
		    	  test.log(Status.PASS, "#FUNC-Corporate clients Account Suspended Reason ErrorMessage Exists" + driver.getTitle() + " * Account Suspended Reason ErrorMessage Exists * ");				
		      }
		      else
		      {
		          test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");		      
		      }
		     WebClick(EdaatOR.AdminSystem_Corporate_cancelbtn);			
		}
		catch (Exception e) {
			test.log(Status.FAIL,"#FUNC-Verify Corporate settings button" + driver.getTitle() +" * Verify Corporate settings button is unsuccessfull FAIL * " );
		}
	}
		
}
