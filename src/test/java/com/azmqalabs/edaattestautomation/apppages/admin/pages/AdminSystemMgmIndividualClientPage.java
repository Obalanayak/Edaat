/**
*
* Test Script Name                   : N/A
* Objective                          : Admin Individual clients functionality
* Version                            : 1.0
* Author                             : Kathirvelu M
* Created Date                       : 23/05/2023
* Last Updated on                    : N/A
* Updated By                         : Kalpana I R
* Pre-Conditions                     : Admin login credentials* Epic Details                       : N/A
* User Story Details                 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.util.Map;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.ReadData;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.codoid.products.fillo.Recordset;

public class AdminSystemMgmIndividualClientPage extends BasePage {

	public AdminSystemMgmIndividualClientPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.AdminSystem_Individual)
	public WebElement Individual;

	public boolean Exists() {
		return super.Exists(Individual);
	}
	
//Function summary:Navigate to IndividualClient Management
//Function Parameters:NA
	public void NavigateIndividualClientManagement(Log Log)
	{
		WebClickUsingJS(EdaatOR.AdminSystem_Individual_link);
 	    this.takeScreenShot();
		Log.ReportEvent("PASS", "Verify to navigate Individual Client management is Suceessful");

	}
//Function summary:Verify Individual Client name is clickable.
//Function Parameters: ClientName and National ID
	public void ClientNameClickable(Map<Object, Object> testdatamap,Log Log)
	{
		try {
		      WebClear(EdaatOR.AdminSystem_IndividualClient_Name);
		      WebEdit(EdaatOR.AdminSystem_IndividualClient_Name,testdatamap.get("ClientName").toString());
		      Thread.sleep(1000);
		      WebClear(EdaatOR.AdminSystem_Individual_national);
		      WebEdit(EdaatOR.AdminSystem_Individual_national,testdatamap.get("National ID").toString());
		      Thread.sleep(1000);
		      WebClick(EdaatOR.Admin_System_Individual_clientstatus);
	          WebClick("//option[text()='"+testdatamap.get("Client Status").toString()+"']");
		      WebClickUsingJS(EdaatOR.AdminSystem_Individual_Search);
		      Thread.sleep(1000);
		      WebClick("//a[text()='"+testdatamap.get("ClientName").toString()+"']");
		      switchToWindow();
		      Thread.sleep(1000);
		     VerifyValue1(getText("//h6[text()='"+testdatamap.get("ClientName").toString()+"']"),testdatamap.get("ClientName").toString());
		      Thread.sleep(1000);
		      this.takeScreenShot();
		      test.log(Status.PASS,"#FUNC-ClientNameClickable" + driver.getTitle() +" * ClientName is Clickable  PASS * " );
			  Log.ReportEvent("PASS", " Verify Individual Client Name Cllick Functionality is Suceessful");

		}
		catch(Exception e){
	    	test.log(Status.FAIL,"#FUNC-ClientNameClickable" + driver.getTitle() +" *  Client Name Click is FAIL * " );
	        this.takeScreenShot();
	   }
	}

//Function summary:Verify Individual Client Grid View.
//Function Parameters: ClientName and National ID
	public void IndivudualClientGridView(Map<Object,Object> testdatamap,Log Log)
	{
		try {
			  NavigateIndividualClientManagement(Log);
		      Thread.sleep(2000);
		      if(CheckElementExists(EdaatOR.AdminSystem_Individual_grid)==true)
		      {
		    	  this.takeScreenShot();
		    	  Thread.sleep(2000);
		    	  test.log(Status.PASS,"#FUNC-Verify Individual Client GridView" + driver.getTitle() +" * Individual Client Grid View is Sucessful  PASS * " ); 
		          Log.ReportEvent("PASS", " Verify Individual Client GridView is Suceessfull");

		      }
		      else
		      {
		    	  test.log(Status.FAIL,"#FUNC-Verify Individual Client GridView" + driver.getTitle() +" * Individual Client Grid View is UnSucessful  FAIL * " ); 

		      }
		    }
		catch(Exception e){
	    	test.log(Status.FAIL,"#FUNC-Verify Individual Client GridView" + driver.getTitle() +" *  Individual Client Grid View is UnSucessful  FAIL * " );
	        this.takeScreenShot();
	   }
	}
	
	public void SelectradioButtton(String accountstatus) throws InterruptedException
	{
		if(accountstatus.equalsIgnoreCase("Suspended Permanently")) {
			WebClickUsingJS(EdaatOR.AdminSystem_Individuaul_SuspendPermradioBTN);
			Thread.sleep(3000);
		}
		else{
			WebClickUsingJS(EdaatOR.AdminSystem_Individuaul_SuspendradioBTN);
			Thread.sleep(3000);
		}
	}
	//Function summary:Verify Individual Client Status Activation and De-activation.
	//Function Parameters: Textarea
	public void Individualclientactivation(Map<Object, Object> testdatamap,Log Log) {
		try {
			  Systemindividualclientsearch(testdatamap);
		      Thread.sleep(1000);
		      WebClick(EdaatOR.Admin_SymIndividua_statustoggle);
		      Thread.sleep(3000);
		      WebEdit(EdaatOR.Admin_SymIndividual_statustoggletextarea,testdatamap.get("Textarea").toString());
		      Thread.sleep(3000);
		      this.takeScreenShot();
		      WebClick(EdaatOR.Admin_Symstatustoggleyesbtn);
		      Thread.sleep(3000);
		      WebClick(EdaatOR.Admin_SymIndividua_statustoggle);
		      Thread.sleep(2000);
		      WebEdit(EdaatOR.Admin_SymIndividual_statustoggletextarea,testdatamap.get("Textarea").toString());
			  Thread.sleep(3000);
			  this.takeScreenShot();
			  WebClick(EdaatOR.Admin_SymIndividual_statustoggleconformactivation);
			  Thread.sleep(3000);
			  this.takeScreenShot();
			  test.log(Status.PASS,"#FUNC-Verify Individual Client Status toggle button" + driver.getTitle() +" * Individual Client Status toggle button is successfull PASS * " );
			  Log.ReportEvent("PASS", " Verify to  Individual Client Status Toggle Activation&De-activation is Suceessful");
    
		}
		    catch (Exception e) {
				this.takeScreenShot();
		    	test.log(Status.FAIL,"#FUNC-Verify Individual Client Status toggle button" + driver.getTitle() +" * Individual Client Status toggle button is  FAIL * " );
		    
	   }		
	}

	//Function summary:Verify Individual Client Status Activation and De-activation.
	//Function Parameters: Client Name,National ID,Client Status
	private void Systemindividualclientsearch(Map<Object, Object> testdatamap) throws InterruptedException {
	    try {
		  WebEdit(EdaatOR.AdminSystem_IndividualClient_Name,testdatamap.get("Client Name").toString());
	      Thread.sleep(1000);
	      WebClear(EdaatOR.AdminSystem_Individual_national);
	      WebEdit(EdaatOR.AdminSystem_Individual_national,testdatamap.get("National ID").toString());
	      Thread.sleep(1000);
	      WebClick(EdaatOR.Admin_System_Individual_clientstatus);
	      WebClick("//option[text()='"+testdatamap.get("Client Status").toString()+"']");
	      Thread.sleep(2000);
	      WebClickUsingJS(EdaatOR.AdminSystem_Individual_Search);
	      Thread.sleep(1000);
		  this.takeScreenShot();
	    }
	    catch (Exception e) {
			this.takeScreenShot();
	    	test.log(Status.FAIL,"#FUNC-Verify Individual Client Search" + driver.getTitle() +" * Individual Client Search is FAIL * " );
	    
	    }
		}

	//Function summary   : Verify Individual Client Request Record button.
	//Function Parameters: History
	public void IndividualclientRequestRecord(Map<Object, Object> testdatamap,Log Log) {
		try {
			  Systemindividualclientsearch(testdatamap);
		      Thread.sleep(1000);
		      WebClick(EdaatOR.Admin_SymIndividua_RequestRecordBtn);
		      Thread.sleep(3000);
		      VerifyValue1(WebGetText(EdaatOR.Admin_SymIndividual_Historypage),testdatamap.get("History").toString());
		      Thread.sleep(3000);
		      this.takeScreenShot();
			  test.log(Status.PASS,"#FUNC-Verify Individual Client Request Record button" + driver.getTitle() +" * Individual Client Request Record  button is successfull PASS * " );
			  Log.ReportEvent("PASS", " Verify to  IndividualClient Request Record button is Suceessful");

		}
		    catch (Exception e) {
				this.takeScreenShot();
		    	test.log(Status.FAIL,"#FUNC-Verify Individual Client Request Record  button" + driver.getTitle() +" * Individual Client Request Record  button is  FAIL * " );
		    
	   }		

	}
		public void SelectClientDropdown(Map<Object, Object> testdatamap)
    {
        WebClick(EdaatOR.Admin_SymIndivClientstatus);
        WebClick("//option[text()='"+testdatamap.get("Client Status").toString()+"']");
    
    }
   	//Function summary:Method to Download the NationalID under Individual client module.
	//Function Parameters: ClientName and National ID
	public void NationalIdDownload(Map<Object, Object> testdatamap,Log Log) {
		// TODO Auto-generated method stub
		try {
			  NavigateIndividualClientManagement(Log);
		      Thread.sleep(2000);
		      WebEdit(EdaatOR.Admin_SymIndivClientname,testdatamap.get("ClientName").toString());
		      Thread.sleep(2000);
		      WebEdit(EdaatOR.Admin_SymIndivNIDname,testdatamap.get("National ID").toString());
		      Thread.sleep(2000);
		      SelectClientDropdown(testdatamap);
		      WebClick(EdaatOR.Admin_Individualclient_srchbtn);
		      Thread.sleep(2000);
		      WebClick(EdaatOR.Admin_Individualdownload);
		      this.takeScreenShot(); 
		      test.log(Status.PASS,"#FUNC-Verify Individual Client NationalId download" + driver.getTitle() +" * Individual Client NationalID download is Sucessful  PASS * " );
	          Log.ReportEvent("PASS", " Verify Individual Client NationalId download is Successful");

		}
		catch(Exception e){
	    	test.log(Status.FAIL,"#FUNC-Verify Individual Client NationalId download" + driver.getTitle() +" *  Individual Client NationalId download is UnSucessful  FAIL * " );
	        this.takeScreenShot();
	   }
	}
	
//Function summary:Method to search individual client
//Function Parameters: ClientName, ClientStatus, National ID
	public void SearchIndividualClient(Map<Object, Object> testdatamap,Log Log)
	{
		try {
			 WebClear(EdaatOR.AdminSystem_IndividualClient_Name);
		      WebEdit(EdaatOR.AdminSystem_IndividualClient_Name,testdatamap.get("ClientName").toString());
		      Thread.sleep(1000);
		      WebClear(EdaatOR.AdminSystem_Individual_national);
		      WebEdit(EdaatOR.AdminSystem_Individual_national,testdatamap.get("NationalID").toString());
		      Thread.sleep(1000);
		      selectDropdownValue_PartialText(EdaatOR.AdminSystem_IndividualClientStatus, testdatamap.get("ClientStatus").toString());
      	      WebClickUsingJS(EdaatOR.AdminSystem_Individual_Search);
		      Thread.sleep(1000);
		       VerifyValue1(getText(EdaatOR.AdminNationalIDVerify),testdatamap.get("NationalID").toString());
		      test.log(Status.PASS,"#FUNC-Search Individual Client" + driver.getTitle() +" *   Search Individual Client  PASS * " );
	          Log.ReportEvent("PASS", " Verify  Search individual client functionality Is Suceessful");

		}
		catch(Exception e){
	    	test.log(Status.FAIL,"#FUNC-Search Individual Client" + driver.getTitle() +" * Search Individual Client is FAIL * " );
	        this.takeScreenShot();
	   }
	}
	//Function summary:Method to VerifyAccountSettingButton
	//Function Parameters: Account Status Type, ClientName,National ID,AccountSuspendedReasons
 public void VerifyAccountSettingButton(Map<Object,Object> testdatamap,Log Log)
	{
		try {
			  String accountstatus=testdatamap.get("Account Status Type").toString();
			  WebClear(EdaatOR.AdminSystem_IndividualClient_Name);
		      WebEdit(EdaatOR.AdminSystem_IndividualClient_Name,testdatamap.get("ClientName").toString());
		      Thread.sleep(1000);
		      WebClear(EdaatOR.AdminSystem_Individual_national);
		      WebEdit(EdaatOR.AdminSystem_Individual_national,testdatamap.get("National ID").toString());
		      Thread.sleep(1000);
		      WebClickUsingJS(EdaatOR.AdminSystem_Individual_Search);
		      Thread.sleep(1000);
		      VerifyValue1(getText("//a[text()='"+testdatamap.get("ClientName").toString()+"']"),testdatamap.get("ClientName").toString());
		      WebClickUsingJS(EdaatOR.AdminSystem_Individuaul_SettingsBTN);
		      Thread.sleep(1000);
		      SelectradioButtton(accountstatus);
		      WebClick(EdaatOR.AdminSystem_Individuaul_SuspendReason);
		      Thread.sleep(1000);
		      WebClickUsingActions("//li[text()='"+testdatamap.get("AccountSuspendedReasons").toString()+"']");
		      Thread.sleep(1000);
		      WebClickUsingJS(EdaatOR.AdminSystem_Individuaul_SettingConirmBTN);
		      Thread.sleep(1000);
		      WebClear(EdaatOR.AdminSystem_IndividualClient_Name);
		      Thread.sleep(1000);
		      WebEdit(EdaatOR.AdminSystem_IndividualClient_Name,testdatamap.get("ClientName").toString());
		      Thread.sleep(1000);
		      WebClear(EdaatOR.AdminSystem_Individual_national);
		      WebEdit(EdaatOR.AdminSystem_Individual_national,testdatamap.get("National ID").toString());
		      Thread.sleep(1000);
		      WebClickUsingJS(EdaatOR.AdminSystem_Individual_Search);
		      Thread.sleep(1000);
		      if(accountstatus.equalsIgnoreCase("suspended permanently"))
		      {
		    	VerifyValue1(getText("//td[text()='"+accountstatus+"']"),accountstatus);  
		    	 Thread.sleep(2000);
		      }
		      else
		      {
		        VerifyValue1(getText("//td[contains(text(),'"+accountstatus+"')]"),accountstatus); 
		        Thread.sleep(2000);
		      }
		      this.takeScreenShot();
		      Thread.sleep(1000);
		      test.log(Status.PASS,"#FUNC-Verify Individual Client GridView" + driver.getTitle() +" * Individual Client Grid View is Sucessful  PASS * " );
			  Log.ReportEvent("PASS", "Verify Account Setting button Functionality is Suceessful");

		}
		catch(Exception e){
	    	test.log(Status.FAIL,"#FUNC-Verify Individual Client GridView" + driver.getTitle() +" *  Individual Client Grid View is UnSucessful  FAIL * " );
	        this.takeScreenShot();
	   }
	}
	//Function summary   :VerifyClientStatusSearch
	//Function Parameters:ClientName and National ID
	public void VerifyClientStatusSearch(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
	try {
	String clientstatus = testdatamap.get("ClientStatus").toString();
	if(clientstatus.equalsIgnoreCase("registered")||clientstatus.equalsIgnoreCase("approved"))
	{
	selectDropdownValue_PartialText(EdaatOR.AdminSystem_Individual_Clientstatus,clientstatus);
	Thread.sleep(2000);
	WebClick(EdaatOR.AdminSystem_Individual_Search);
	Thread.sleep(2000);
	this.takeScreenShot();
	VerifyValue1(getText(EdaatOR.AdminSystem_Individual_Clientstatus_Verify),"Yes");
	
	}
	else {
	selectDropdownValue_PartialText(EdaatOR.AdminSystem_Individual_Clientstatus,clientstatus);
	Thread.sleep(2000);
	WebClick(EdaatOR.AdminSystem_Individual_Search);
	Thread.sleep(2000);
	this.takeScreenShot();
	VerifyValue1(getText(EdaatOR.AdminSystem_Individual_Clientstatus_Verify),"No");
	}	
    test.log(Status.PASS,"#FUNC-Verify to search based on the Client status" + driver.getTitle() +" * search based on the Client status  PASS * " );
	Log.ReportEvent("PASS", "Verify to search based on the Client status is succesful");

	}
	catch (Exception e) {
    test.log(Status.FAIL,"#FUNC-Verify to search based on the Client status" + driver.getTitle() +" *  search based on the Client status  FAIL * " );
	}		
	}

	public void VerifyAccountSettingButtonErrorMsg(Map<Object, Object> testdatamap){		
		try {
			  String accountstatus=testdatamap.get("Account Status Type").toString();
			  WebClear(EdaatOR.AdminSystem_IndividualClient_Name);
		      WebEdit(EdaatOR.AdminSystem_IndividualClient_Name,testdatamap.get("ClientName").toString());
		      Thread.sleep(1000);
		      WebClear(EdaatOR.AdminSystem_Individual_national);
		      WebEdit(EdaatOR.AdminSystem_Individual_national,testdatamap.get("National ID").toString());
		      Thread.sleep(1000);
		      WebClickUsingJS(EdaatOR.AdminSystem_Individual_Search);
		      Thread.sleep(1000);
		      VerifyValue1(getText("//a[text()='"+testdatamap.get("ClientName").toString()+"']"),testdatamap.get("ClientName").toString());
		      WebClickUsingJS(EdaatOR.AdminSystem_Individuaul_SettingsBTN);
		      Thread.sleep(1000);
		      if(accountstatus.equalsIgnoreCase("Suspended Permanently")) {
					WebClickUsingJS(EdaatOR.AdminSystem_Individuaul_SuspendPermradioBTN);
					Thread.sleep(3000);
				}
				else if(accountstatus.equalsIgnoreCase("Suspended")){
					WebClickUsingJS(EdaatOR.AdminSystem_Individuaul_SuspendradioBTN);
					Thread.sleep(3000);
				}
		      WebClickUsingJS(EdaatOR.AdminSystem_Individuaul_SettingConirmBTN);
		      if(ExistsCheck(EdaatOR.AdminSystem_Individuaul_Accountstatuserrormsg))
		      {
		    	  
		    	  VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.AdminSystem_Individuaul_Accountstatuserrormsg);
		    	  this.takeScreenShot();
		    	  test.log(Status.PASS, "#FUNC-Individual clients Account status ErrorMessage Exists" + driver.getTitle() + " * Account Status ErrorMessage Exists * ");
		      }
		      else if(ExistsCheck(EdaatOR.AdminSystem_Individuaul_SuspendReasonerrormsg)){
		    	  
		    	  VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.AdminSystem_Individuaul_SuspendReasonerrormsg);
		    	  this.takeScreenShot();
		    	  test.log(Status.PASS, "#FUNC-Individual clients Account Suspended Reason ErrorMessage Exists" + driver.getTitle() + " * Account Suspended Reason ErrorMessage Exists * ");				
		      }
		      else
		      {
		          test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");		      
		      }
		     WebClick(EdaatOR.AdminSystem_Individuaul_cancelbtn);
		    }
		catch(Exception e){
	    	test.log(Status.FAIL,"#FUNC-Verify Individual Client Account settings Button " + driver.getTitle() +" *  Individual Client Account settings Button is UnSucessful  FAIL * " );
	        this.takeScreenShot();
	   }
	}
}