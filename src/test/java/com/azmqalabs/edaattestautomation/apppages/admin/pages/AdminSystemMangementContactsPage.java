/**
*
* Test Script Name                   :NA
* Objective                          :AdminSystemManagement functionality
* Version                            :1.0
* Author                             :Kathirvelu M
* Created Date                       :8/09/2023
* Last Updated on                    :N/A
* Updated By                         :Basavaraj Mudnur
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

public class AdminSystemMangementContactsPage extends BasePage {

	public AdminSystemMangementContactsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Systemmgmt_Menu)
	public WebElement Client;

	public boolean Exists() {
		return super.Exists(Client);
	}

	//Function Summary  : Method to Navigate Contacts Management Menu
	//Parameter Summary :N/A
	public void navigateContactsManagement(Log Log)
	{
		WebClick(EdaatOR.Systemmgmt_Menu);
		WebClickUsingJS(EdaatOR.Admin_ContactsManagement);
    	Log.ReportEvent("PASS", "Navigate to Contacts Management page is Successfull");

	}
	//Function Summary  : Method to Select Subject DropDown
	//Parameter Summary :N/A

	public void SelectSubject(String Subject)
	{
		WebClick(EdaatOR.Admin_ContactsMGM_SubjectDrop);
		WebSelect(EdaatOR.Admin_ContactsMGM_SubjectDrop, Subject);
	}
	
	//Function Summary  : Method to Select Status DropDown
   //Parameter Summary :N/A
	public void SelectStatus(String Status)
	{
		WebClick(EdaatOR.Admin_ContactsMGM_StatusDrop);
		WebSelect(EdaatOR.Admin_ContactsMGM_StatusDrop, Status);
	}
	//Function Summary  : Method to Select SenderType DropDown
   //Parameter Summary :N/A
	public void SelectSenderType(String Sender)
	{
		WebClick(EdaatOR.Admin_ContactsMGM_SenderTypeDrop);
		WebSelect(EdaatOR.Admin_ContactsMGM_SenderTypeDrop, Sender);
	}
	//Function Summary  : Method to Search Contacts
   //Parameter Summary :Name,Subject,Staus,SenderType
	public void verifySearchFunctionality(Map<Object, Object> testdatamap,Log Log)
	{
		try{
			navigateContactsManagement(Log);
			this.takeScreenShot();
			WebEdit(EdaatOR.Admin_ContactsMGM_SenderName,testdatamap.get("Name").toString());
			SelectSubject( testdatamap.get("Subject").toString());
			Thread.sleep(1000);
			SelectStatus(testdatamap.get("Staus").toString());
       	    Thread.sleep(1000);
       	    SelectSenderType(testdatamap.get("SenderType").toString());
       	    Thread.sleep(1000);
        	WebClick(EdaatOR.Admin_ContactsMGM_SearchButton);
       	    Thread.sleep(2000);
       	    VerifyValue1(getText("//td[text()='"+testdatamap.get("Name").toString()+"']"), testdatamap.get("Name").toString());
       		Thread.sleep(2000);
       		this.takeScreenShot();
       		test.log(Status.PASS,"#FUNC-Verify Corporate Client name is clickable" + driver.getTitle() +" * Corporatee Client name click is successfull PASS * " );
        	Log.ReportEvent("PASS", "Verify Contact Mangement Search is Sucessful");

		}catch(Exception e){
      test.log(Status.FAIL,"#FUNC-Add Individual client" + driver.getTitle() +" * Add Individual client PASS * " );
        this.takeScreenShot();
    }
}    
//Function Summary  : Method to verifyMessageDetailsandClose
	//Parameter Summary :Name,Subject,Staus,SenderType
	public void verifyMessageDetailsandClose(Map<Object, Object> testdatamap,Log Log)
	{
		try
		{
			WebEdit(EdaatOR.Admin_ContactsMGM_SenderName,testdatamap.get("Name").toString());
			SelectSubject( testdatamap.get("Subject").toString());
			Thread.sleep(1000);
			SelectStatus(testdatamap.get("Staus").toString());
       	    Thread.sleep(1000);
       	    SelectSenderType(testdatamap.get("SenderType").toString());
       	    Thread.sleep(1000);
       	    WebClick(EdaatOR.Admin_ContactsMGM_SearchButton);
       	    Thread.sleep(3000);
       	    WebClickUsingJS("//td[text()='"+testdatamap.get("Name").toString()+"']/ancestor::tr//a");
       	    Thread.sleep(2000);
       	    verifyElementIsPresent(EdaatOR.Admin_ContactsMGM_MsgDetails_verify);
       	    this.takeScreenShot();
       	    Thread.sleep(1000);
       	    WebClick(EdaatOR.Admin_ContactsMGM_MsgDetails_Closebtn);
       	    Thread.sleep(1000);
       	    this.takeScreenShot();
       		test.log(Status.PASS,"#FUNC-Verify Message Details & Close" + driver.getTitle() +" *Contacts Management PASS" );
        	Log.ReportEvent("PASS", "Verify Message Details & Close is Suceessful");

		}
		catch (Exception e) {
			test.log(Status.FAIL,"#FUNC-Verify Message Details & Close" + driver.getTitle() +" *Contacts Management FAIL" );		
		}
	}
//Function Summary  : Message Reply Details
//Parameter Summary :Name,Subject,Staus,SenderType
	public void MessageReplyDetails(Map<Object, Object> testdatamap,Log Log)
	{
		try {
		      verifySearchFunctionality(testdatamap,Log);
	       	  Thread.sleep(1000);
		      WebClickUsingJS("//td[text()='"+testdatamap.get("Name").toString()+"']//ancestor::tr//a");
	       	  Thread.sleep(1000);
		      WebClick(EdaatOR.Admin_ContactsMGM_Replybtn);
	       	  Thread.sleep(1000);
		      WebClear(EdaatOR.Admin_ContactsMGM_TextMsg);
	       	  Thread.sleep(1000);
		      WebEdit(EdaatOR.Admin_ContactsMGM_TextMsg,testdatamap.get("Description").toString());
	       	  Thread.sleep(1000);
		      WebClickUsingJS(EdaatOR.Admin_ContactsMGM_SendReply);
	       	  Thread.sleep(1000);
		      test.log(Status.PASS,"#FUNC-MessageReplyDetails" + driver.getTitle() +" * Message Reply Details is PASS * " );
		      this.takeScreenShot();
			  Log.ReportEvent("PASS", "Verify to Message details and Reply is Suceessful");

		}
		catch(Exception e){
		      test.log(Status.FAIL,"#FUNC-MessageReplyDetails" + driver.getTitle() +" * Message Reply Details is fail* " );
		        this.takeScreenShot();
		    }
	} 
	//Function Summary  : Method to verify contacts Status
	//Parameter Summary : Status
	public void contactsStatus(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			navigateContactsManagement(Log);
			WebClick(EdaatOR.Admin_ContactsMGM_StatusDrop);
			WebSelect(EdaatOR.Admin_ContactsMGM_StatusDrop, testdatamap.get("Status").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_ContactsMGM_SearchButton);
       	    Thread.sleep(2000);
			VerifyValue1(WebGetText("(//tr/td[.='"+testdatamap.get("Status").toString()+"'])[1]"),testdatamap.get("Status").toString());	
			Thread.sleep(1000);
			this.takeScreenShot();
       		test.log(Status.PASS,"#FUNC-Verify the Contacts Management status" + driver.getTitle() +" * Contacts Management status is PASS" );
        	Log.ReportEvent("PASS", "Verify Contact Mangement Status is Sucessful");

		} catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL,"#FUNC-Verify the Contacts Management status" + driver.getTitle() +" *Contacts Management status is FAIL" );		
		}
		
	}
	//Function Summary  : Method to view Contacts in System Management.
	//Parameter Summary : N/A.
	public void VerifyContactsGridView(Map<Object, Object> testdatamap,Log Log)
	{
		try
		{
			navigateContactsManagement(Log);
			Thread.sleep(1000);
			this.takeScreenShot();
			verifyElementIsPresent(EdaatOR.Admin_SymCorptable);
			Thread.sleep(1000);
			this.takeScreenShot();
			verifyElementIsPresent(EdaatOR.Admin_Symcontactsym);
       	    this.takeScreenShot();
       		test.log(Status.PASS,"#FUNC-Verify Grid view" + driver.getTitle() +" *Contacts Management PASS" );
        	Log.ReportEvent("PASS", "Verify Contact Mangement Grid view Functionality is Sucessful");
 
		}
		catch (Exception e) {
			test.log(Status.FAIL,"#FUNC-Verify Grid view" + driver.getTitle() +" *Contacts Management FAIL" );		
		}
	
	
	}
	//Function Summary  : Method to VerifyStatusToggle
    //Parameter Summary :N/A
		public void VerifyStatusToggle(Map<Object, Object> testdatamap,Log Log)
		{
			try
			{
				Thread.sleep(1000);
				WebClick(EdaatOR.Admin_ContactsMGMToggle);
			    Thread.sleep(1000);
				WebClick(EdaatOR.Admin_ContactsMGMToggle);
	       	    this.takeScreenShot();
	       		test.log(Status.PASS,"#FUNC-Verify Status Toggle " + driver.getTitle() +" *Contacts Management PASS" );
	        	Log.ReportEvent("PASS", "Verify  Status Toggle functionality Is Suceessful");

			}
			catch (Exception e) {
				test.log(Status.FAIL,"#FUNC-Verify Status Toggle "
						+ "" + driver.getTitle() +" *Contacts Management FAIL" );		
			}
		
		
		}
	
}


	

