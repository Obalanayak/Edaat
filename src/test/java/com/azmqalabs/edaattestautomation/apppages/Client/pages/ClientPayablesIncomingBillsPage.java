/**
*
* Test Script Name                      : NA
* Objective                             : Verify to Client PayablesIncoming Bills Page Functionality.
* Version                               : 1.0
* Author                                : Basavaraj Mudnur
* Created Date                          : 
* Last Updated on                       : N/A
* Updated By   			 			    : Basavaraj Mudnur
* Pre-Conditions					    : N/A
* Epic Details						 	: N/A
* User Story Details				 	: N/A
**/
package com.azmqalabs.edaattestautomation.apppages.Client.pages;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.google.sitebricks.routing.Action;



public class ClientPayablesIncomingBillsPage extends BasePage
{

	public ClientPayablesIncomingBillsPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Biller_Client)
	public WebElement Client;


	public boolean Exists(){
		return super.Exists(Client); 
	}
	//Function Summary   : Method to verify Navigate to "Incoming Bills" Page.
	//Parameter Summary : N/A
	public void NavigatetoIncomingBills(Log Log) throws InterruptedException
	{
		WebClickUsingJS(EdaatOR.ClientsPayablesIncomingBillsBTN);
		Thread.sleep(1000);
	    Log.ReportEvent("PASS", " Navigate to Incoming Bills Page");
	    this.takeScreenShot();

	}
	
	public void SelectBillerNameDropDown(Map<Object,Object>testdatamap) throws InterruptedException
	{
		WebClick(EdaatOR.ClientsPayablesBillerNameDropdown);
		Thread.sleep(1000);
		WebSelect(EdaatOR.ClientsPayablesBillerNameDropdown, testdatamap.get("BillerName").toString());
	}
	
	public void SelectPaymentStatusDropDown(Map<Object,Object>testdatamap) throws InterruptedException
	{
		WebClick(EdaatOR.ClientsPayablesPaymentStatusDropdown);
		Thread.sleep(1000);
		WebSelect(EdaatOR.ClientsPayablesPaymentStatusDropdown, testdatamap.get("PaymentStatus").toString());
	}
	public void SearchIncomingBills(Map<Object,Object>testdatamap,Log Log) throws Exception
	{
		//WebClick(EdaatOR.ClientsPayablesInvoiceNumberTextField);
		WebEdit(EdaatOR.ClientsPayablesInvoiceNumberTextField, testdatamap.get("BillNumber").toString());
		//driver.findElement(By.xpath(EdaatOR.ClientsPayablesInvoiceNumberTextField)).sendKeys(testdatamap.get("InvoiceNumber").toString());
		SelectBillerNameDropDown(testdatamap);
		SelectPaymentStatusDropDown(testdatamap);
		WebClick(EdaatOR.ClientsPayablesIncomingBillSerach);
		
		Thread.sleep(1000);
		verifyElementIsPresent("//td/a[text()='"+testdatamap.get("BillNumber").toString()+"']");
		
    	Log.ReportEvent("PASS", "Verify Client Login is successfull");
    	this.takeScreenShot();
	}
	
    //Function Summary : Method to verifyPayButtonAppearsWithMultiPaymentMethods
	//Parameter Summary : BillNumber
	public void verifyPayButtonAppearsWithMultiPaymentMethods(Map<Object,Object>testdatamap,Log Log) throws Exception
	{
		try {
			WebEdit(EdaatOR.ClientsPayablesInvoiceNumberTextField, testdatamap.get("BillNumber").toString());
			SelectBillerNameDropDown(testdatamap);
			SelectPaymentStatusDropDown(testdatamap);
			WebClick(EdaatOR.ClientsPayablesIncomingBillSerach);
			
			Thread.sleep(1000);
			verifyElementIsPresent("//td/a[text()='"+testdatamap.get("BillNumber").toString()+"']");
			
			if(CheckElementExists("//a[text()='"+testdatamap.get("BillNumber").toString()+"']"))
			{
				WebClick(EdaatOR.ClientsPayablesIncomingBillsPay);
				
				Thread.sleep(1000);
				verifyElementIsPresent(EdaatOR.ClientsPayablesIncomingBills_Sadad_Link);
				verifyElementIsPresent(EdaatOR.ClientsPayablesIncomingBills_Mada_Link);
				verifyElementIsPresent(EdaatOR.ClientsPayablesIncomingBills_Visa_Link);
				verifyElementIsPresent(EdaatOR.ClientsPayablesIncomingBills_MasterCard_Link);
				verifyElementIsPresent(EdaatOR.ClientsPayablesIncomingBills_ApplePay_Link);
				Thread.sleep(1000);
				
				test.log(Status.PASS,"Verify that the pay button appears for exported bill installment invoices with multi-payment methods Functionality is successfull" + driver.getTitle()+ " * Verify that the pay button appears for exported bill installment invoices with multi-payment methods Functionality is successfull PASS * " );	
				Log.ReportEvent("PASS", "Verify that the pay button appears for exported bill installment invoices with multi-payment methods Functionality is successfull");
				this.takeScreenShot();
			}
			else
			{
				
				test.log(Status.FAIL,"Verify that the pay button appears for exported bill installment invoices with multi-payment methods Functionality is Unsuccessfull" + driver.getTitle()+ " * Verify that the pay button appears for exported bill installment invoices with multi-payment methods Functionality is Unsuccessfull FAIL * " );	
			}			
		} catch (Exception e) {
			e.printStackTrace();
			
			test.log(Status.FAIL,"Verify that the pay button appears for exported bill installment invoices with multi-payment methods Functionality is Unsuccessfull" + driver.getTitle()+ " * Verify that the pay button appears for exported bill installment invoices with multi-payment methods Functionality is Unsuccessfull FAIL * " );	
			this.takeScreenShot();
		}
		
	}
	public void ClickonBillNumber(String BillNumber)
	{
		WebClickUsingJS("//a[text()='"+BillNumber+"']");
	}
	
	public void VerifyBillNumberClickable(Map<Object,Object>testdatamap,Log Log) throws Exception
	{	    
		NavigatetoIncomingBills(Log);
		SearchIncomingBills(testdatamap,Log);
		Thread.sleep(2000);
		ClickonBillNumber(testdatamap.get("BillNumber").toString());
		verifyElementIsPresent(EdaatOR.ClientsPayablesIncomInvoiceDetailsText);
    	Log.ReportEvent("PASS", "Client Login Is Sucessful");
    	this.takeScreenShot();
		
	}
	//Function Summary   : Method to verify Bills Printout functionality.
	//Parameter Summary : N/A
	public void verifyBillsPrint(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
		try {
		WebClickUsingJS(EdaatOR.ClientsIncomingBillsBillnumber1);
		Thread.sleep(2000);
		switchToWindow();
		driver.findElement(By.xpath(EdaatOR.ClientsIncomingBillPrintBtn)).sendKeys(Keys.PAGE_DOWN);
		WebClickUsingJS(EdaatOR.ClientsIncomingBillPrintBtn);
		Thread.sleep(4000);
		
		test.log(Status.PASS,"Bills  Printout" + driver.getTitle() +" * Bills  Printout is Pass * " );
    	Log.ReportEvent("PASS", "Verify printout Functionality  is successfull");
    	this.takeScreenShot();
		}
	catch(Exception e){
		
		test.log(Status.FAIL,"Bills  Printout" + driver.getTitle() +" *Bills  Printout is FAIL * " );		
		this.takeScreenShot();
	}
		
		

	}
	

	//Function Summary: Verify Incoming Bills GridView
	//Function Parameter:NA
	public void IncomingBillsGridView(Log Log) throws InterruptedException
	{
		try {
		NavigatetoIncomingBills(Log);
		if(CheckElementExists(EdaatOR.ClientPayablesIncomingBillsGrid)==true)
		{
			test.log(Status.PASS,"FUNC-Incoming BillsGrid View"+driver.getTitle()+"Incoming BillsGrid View is Pass");
        	Log.ReportEvent("PASS", "Verify Grid view details");
        	this.takeScreenShot();

		}
		else
		{
		      test.log(Status.FAIL,"Incoming BillsGrid View" + driver.getTitle() +" * Incoming BillsGrid View is FAIL * ");
		}
	}
		catch(Exception e)
		{
		      test.log(Status.FAIL,"Incoming BillsGrid View" + driver.getTitle() +" * Incoming BillsGrid View is FAIL * ");
		      this.takeScreenShot();
		}
	}
	//Function Summary  :Method to VerifyPayIncomingBills
	//Function Parameter:N/A
	public void VerifyPayIncomingBills(Map<Object, Object> testdatamap,Log Log) {
		try
		{
			WebEdit(EdaatOR.ClientsPayablesInvoiceNumberTextField,testdatamap.get("BilNumber").toString());
			Thread.sleep(5000);
			SelectBillerNameDropDown(testdatamap);
			Thread.sleep(2000);
			SelectPaymentStatusDropDown(testdatamap);
			Thread.sleep(1000);
			WebClick(EdaatOR.ClientsPayablesIncomingBillSerach);
			
			Thread.sleep(1000);
			if(CheckElementExists("//a[text()='"+testdatamap.get("BilNumber").toString()+"']")==true)
			{
				WebClick(EdaatOR.ClientsPayablesIncomingBillsPay);
				
				Thread.sleep(1000);
				WebClick(EdaatOR.ClientsPayablesIncomingBillsPaysadad);
				
				Thread.sleep(1000);
				WebClick(EdaatOR.ClientsPayablesIncomingBillsfollowpay);
				Thread.sleep(2000);
				waitForPageToLoad();
				
				VerifyValue1(getText("//label[text()='"+testdatamap.get("PaymentSuccess").toString()+"']"),testdatamap.get("PaymentSuccess").toString());
				Thread.sleep(1000);
			   test.log(Status.PASS,"Verify PAY Functionality" + driver.getTitle() +" * PAY Functionality PASS * ");
	        	Log.ReportEvent("PASS", " Verify Incoming Bills PAY Functionality is successfull");
	        	this.takeScreenShot();

			}
			else
			{
				 test.log(Status.FAIL,"Verify PAY Functionality" + driver.getTitle() +" * PAY Functionality FAIL * ");
			}
		}
		catch (Exception e) {
			
		 test.log(Status.FAIL,"Verify PAY Functionality" + driver.getTitle() +" * PAY Functionality FAIL * ");
		 this.takeScreenShot();

		}
		
	}
	//Function Summary  :Method to VerifyPayIncomingBills Error Message
    //Function Parameter:N/A
	public void VerifyIncomingbillsPayEroorMessage(Map<Object,Object>testdatamap,Log Log) throws Exception
	{	    
		NavigatetoIncomingBills(Log);
		SearchIncomingBills(testdatamap,Log);
		WebClick(EdaatOR.ClientsPayablesIncomingBillsPay);
		Thread.sleep(2000);
		try
		{
		if(ExistsCheck(EdaatOR.Client_IncomingBills_Pay_Error))
		{
			VerifyValue1(testdatamap.get("Expected").toString(),getText(EdaatOR.Client_IncomingBills_Pay_Error));
			test.log(Status.PASS, "Incomingbills Pay ErrorMessage Exists" + driver.getTitle() + " * Incomingbills Pay ErrorMessage Exists * ");
		}
		else
		{
			test.log(Status.FAIL, "Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
		}
		}

		catch (Exception e) {
			test.log(Status.FAIL,"Incomingbills Pay " + driver.getTitle() +" * Incomingbills Pay * " );
			

		}
	}	
//Function Summary  :Method to Verify newly added payment method
	public void VerifyNewAddedPaymentMethodColumn(Log Log) throws Exception
	{	    
		NavigatetoIncomingBills(Log);		
		Thread.sleep(1000);	
		
		verifyElementIsPresent(EdaatOR.Client_IncomingBillsPaymentMethodColumn);
		Thread.sleep(1000);	
    	Log.ReportEvent("PASS", "Verify newly added payment menthod is sucessfull");
    	this.takeScreenShot();
		
	}
	//Function Summary  :Method to Verify newly added payment method search dropdown
		public void VerifyNewAddedPaymentMethodSearchDropdown(Log Log) throws Exception
		{	    
			NavigatetoIncomingBills(Log);		
			Thread.sleep(1000);	
			
			verifyElementIsPresent(EdaatOR.Client_IncomingBillsPaymentMethodSearchDropdown);
			Thread.sleep(1000);	
	    	Log.ReportEvent("PASS", "Verify newly added payment menthod search dropdown is sucessfull");
	    	this.takeScreenShot();
			
		}
		//Function Summary  :Method to Verify Pay Option In Incoming Bills
		public void VerifyPayOptionInIncomingBills(Log Log) throws Exception
		{	    
			NavigatetoIncomingBills(Log);		
			Thread.sleep(1000);	
			
			verifyElementIsPresent(EdaatOR.Client_IncomingBillsPayOption);
			Thread.sleep(1000);	
	    	Log.ReportEvent("PASS", "Verify pay option in Incoming bills is successfull");
	    	this.takeScreenShot();
		}
	
}






