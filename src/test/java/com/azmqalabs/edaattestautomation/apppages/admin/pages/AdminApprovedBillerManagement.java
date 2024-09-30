/**
* Test Script Name                   : N/A
* Objective                          : Admin Approved Billers Management related functions
* Version                            : 1.0
* Author                             : Kathirvelu M
* Created Date                       : 05/06/2023
* Last Updated on                    : N/A
* Updated By                         : Dhruva Kumar S
* Pre-Conditions                     : N/A
* Epic Details                       : N/A
* User Story Details                 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.ScrollAction;
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;
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
import com.azmqalabs.edaattestautomation.testscripts.admin.AdminNotApprovedMgmCloseBiller;

public class AdminApprovedBillerManagement extends BasePage {

	public AdminApprovedBillerManagement(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Admin_SystemMgm_SearchItem)
	public WebElement Client;

	public boolean Exists() {
		return super.Exists(Client);
	}
	//Function Summary   : Method to enterOnSearchItem
	//Parameter Summary  : searchItem

	public void enterOnSearchItem(String searchItem) {

		WebEdit(EdaatOR.Admin_SystemMgm_SearchItem, searchItem);
	}

	//Function Summary   : Method to  clickOnSearchBtn
	//Parameter Summary  : N/A

	public void clickOnSearchBtn() {

		WebClick(EdaatOR.Admin_SystemMgm_Searchbtn);
	}
	//Function Summary   : Method to searchNotApprovedBillerMgm
	//Parameter Summary  : Search

	public void searchNotApprovedBillerMgm(String Search) throws Exception {
		enterOnSearchItem(Search);
		clickOnSearchBtn();
		waitForPageToLoad();
		Thread.sleep(1000);
	}
	//Function Summary   : Method to clickOnActivateLink
	//Parameter Summary  : N/A
	public void clickOnActivateLink() {

		WebClick(EdaatOR.Admin_SystemMgm_BillerActivateBtn);
	}
//Function Summary   : Method to enterOnBillerActiName
	//Parameter Summary  : N/A
	public void enterOnBillerActiName(Map<Object, Object> testdatamap) {

		WebEdit(EdaatOR.Admin_SystemMgm_BillerAliasName,testdatamap.get("ArabicName").toString() );
		WebEdit(EdaatOR.Admin_SystemMgm_BillerAliasEnName, testdatamap.get("EnglishName").toString());
	}
	//Function Summary   : Method to clickOnIsbiller
	//Parameter Summary  : N/A

	public void clickOnIsbiller() {

		WebClickUsingJS(EdaatOR.Admin_SystemMgm_IsBiller);
	}
	//Function Summary   : Method to clickOnIsbillerYesbtn
	//Parameter Summary  : N/A

	public void clickOnIsbillerYesbtn() {

		WebClickUsingJS(EdaatOR.Admin_SystemMgm_IsBillerYesBtn);
	}
	//Function Summary   : Method to clickOnSave
	//Parameter Summary  : N/A

	public void clickOnSave() {

		WebClick(EdaatOR.Admin_SystemMgm_SavesBtn);
	}
	//Function Summary   : Method to clickOnSaveYeBtn
	//Parameter Summary  : N/A

	public void clickOnSaveYeBtn() {

		WebClick(EdaatOR.Admin_SystemMgm_SaveYesBtn);
	}

	//Function Summary   : Method to clickOnClose
	//Parameter Summary  : N/A
	public void clickOnClose() {

		WebClick(EdaatOR.Admin_SystemMgm_ApprovalCloseBtn);
	}
	//Function Summary   : Method to enterTempBillerCode
	//Parameter Summary  : Benifi
	public void enterTempBillerCode(String Benifi) {
		WebEdit(EdaatOR.Admin_SystemMgm_BillerCode,Benifi);
	}
	//Function Summary   : Method to enterTempBenificaryName
	//Parameter Summary  : Benifi
	public void enterTempBenificaryName(String Benifi) {
		WebEdit(EdaatOR.Admin_SystemMgm_BillerTemBenificary,Benifi);
	}
//Function Summary   : Method to enterDuration
	//Parameter Summary  : Benifi
	public void enterDuration(String Benifi) {
		WebEdit(EdaatOR.Admin_SystemMgm_BillerTransferDura,Benifi);
	}
	//Function Summary   : Method to selectCategoryID
	//Parameter Summary  : Benifi
	public void selectCategoryID(String Benifi) {
		WebSelectByVisibleText(EdaatOR.Admin_SystemMgm_BillerCategoryID,Benifi);
	}

	//Function Summary   : Method to verifyApproveBillerChecker
	//Parameter Summary  : CompanyName,InActive,Active
	public void verifyApproveBillerChecker(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		verifyElementIsNotPresent(EdaatOR.Admin_SystemMgm_RecordUnclickable, "Slid Bar is activated");
		verifyElementIsPresent(EdaatOR.Admin_ApproveMgn_ToggleBtn);
		WebClickUsingJS(EdaatOR.Admin_ApproveMgn_ToggleBtn);
		Thread.sleep(500);
		takeScreenShot();
		VerifyValue1(getText(EdaatOR.Admin_Compan_ActivePop), testdatamap.get("InActive").toString());
		WebClickUsingJS(EdaatOR.Admin_Compan_ActiveConfbtn);
		Thread.sleep(2000);
		takeScreenShot();
		WebClickUsingJS(EdaatOR.Admin_ApproveMgn_ToggleBtn);
		Thread.sleep(500);
		takeScreenShot();
		VerifyValue1(getText(EdaatOR.Admin_Compan_ActivePop), testdatamap.get("Active").toString());
		WebClickUsingJS(EdaatOR.Admin_Compan_ActiveConfbtn);
		test.log(Status.PASS,"#FUNC- Verify to Activate/Deactivate status toggel button" + driver.getTitle()+ " * Activate/Deactivate status toggel button PASS * " );
    	Log.ReportEvent("PASS", "Verfiy that biller account activated after checker approve  ");
    	this.takeScreenShot();
		}
		catch (Exception e) {
		test.log(Status.FAIL,"#FUNC- Verify to Activate/Deactivate status toggel button" + driver.getTitle()+ " * Activate/Deactivate status toggel button FAIL * " );
		this.takeScreenShot();
		}
	}
		//Function Summary  : Method to clickOnAddInvoicebtn
		//Parameter Summary : N/A
		public void clickOnAddInvoicebtn() throws InterruptedException {
			WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_AddInvoicebtn);
			Thread.sleep(2000);
			
		}
		//Function Summary  : Method to clickOnAddTransactionbtn
		//Parameter Summary : N/A
		public void clickOnAddTransactionbtn() throws InterruptedException {
			WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_AddTransactionbtn);
			Thread.sleep(2000);
			
		}
		//Function Summary  : Method to EnterFromAmount
		//Parameter Summary : fromAmount
		public void EnterFromAmount(String fromAmount) throws InterruptedException {
			Thread.sleep(2000);
			WebEdit(EdaatOR.Admin_SystemMng_PaymentMethodMng_Invoice_FromAmnt,fromAmount);
		}
		
		//Function Summary  : Method to EnterFromTransaction
		//Parameter Summary : fromTransaction
		public void EnterFromTransaction(String fromTransaction) throws InterruptedException {
			Thread.sleep(2000);
			WebEdit(EdaatOR.Admin_SystemMng_PaymentMethodMng_Transc_Fromtrans,fromTransaction);
		}

		//Function Summary  : Method to EnterToAmount
		//Parameter Summary : toAmount
		public void EnterToAmount(String toAmount) throws InterruptedException {
			Thread.sleep(2000);
			WebEdit(EdaatOR.Admin_SystemMng_PaymentMethodMng_Invoice_ToAmnt,toAmount);
		}
		
		//Function Summary  : Method to EnterToTransaction
		//Parameter Summary : toTransaction
		public void EnterToTransaction(String toTransaction) throws InterruptedException {
			Thread.sleep(2000);
			WebEdit(EdaatOR.Admin_SystemMng_PaymentMethodMng_Transc_Totrans,toTransaction);
		}
		//Function Summary  : Method to clickOnInvoiceFeesFixedValueCheckboxAndEnterValue
		//Parameter Summary : fixedValue
		public void clickOnInvoiceFeesFixedValueCheckboxAndEnterValue(String fixedValue) throws InterruptedException {
			WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_Invoice_FixedFeesCheckbox);
			Thread.sleep(2000);
			WebEdit(EdaatOR.Admin_SystemMng_PaymentMethodMng_Invoice_FixedFees_efield,fixedValue);
		}
		
		//Function Summary  : Method to clickOnTransFeesFixedValueCheckboxAndEnterValue
		//Parameter Summary : transFixedValue
		public void clickOnTransFeesFixedValueCheckboxAndEnterValue(String transFixedValue) throws InterruptedException {
			WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_Transc_FixedFeesCheckbox);
			Thread.sleep(2000);
			WebEdit(EdaatOR.Admin_SystemMng_PaymentMethodMng_Transc_FixedFees_efield,transFixedValue);
		}
			
		//Function Summary  : Method to clickOnInvoiceFeesPercentageCheckboxAndEnterValue
		//Parameter Summary : percentage
		public void clickOnInvoiceFeesPercentageCheckboxAndEnterValue(String percentage) throws InterruptedException {
			WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_Invoice_PercentageFeesCheckbox);
			Thread.sleep(2000);
			WebEdit(EdaatOR.Admin_SystemMng_PaymentMethodMng_Invoice_PercentageFees_efield,percentage);
		}
		//Function Summary  : Method to clickOnTransFeesPercentageCheckboxAndEnterValue
		//Parameter Summary : transPercentage
		public void clickOnTransFeesPercentageCheckboxAndEnterValue(String transPercentage) throws InterruptedException {
			WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_Transc_PercentageFeesCheckbox);
			Thread.sleep(2000);
			WebEdit(EdaatOR.Admin_SystemMng_PaymentMethodMng_Transc_PercentageFees_efield,transPercentage);
		}
		//Function Summary  : Method to clickOnAddInvoiceButton
		//Parameter Summary : N/A
		public void clickOnAddInvoiceButton() throws InterruptedException {
			WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_Invoice_Addbtn);
			Thread.sleep(2000);
		}
		
		//Function Summary  : Method to clickOnAddTransactionButton
		//Parameter Summary : N/A
		public void clickOnAddTransactionButton() throws InterruptedException {
			WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_Transc_Addbtn);
			Thread.sleep(2000);
		}
		//Function Summary  : Method to EnterTheInviceAmountDetails
		//Parameter Summary : N/A
		public void EnterTheInvoiceAmountDetails(Map<Object, Object> testdatamap) throws InterruptedException {
			try {
		    EnterFromAmount(testdatamap.get("FromAmount").toString());
		    
			EnterToAmount(testdatamap.get("ToAmount").toString());
			clickOnInvoiceFeesFixedValueCheckboxAndEnterValue(testdatamap.get("FixedValue").toString());
			
			clickOnInvoiceFeesPercentageCheckboxAndEnterValue(testdatamap.get("Percentage").toString());
			clickOnAddInvoiceButton();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//Function Summary  : Method to EnterTheTransactionAmountDetails
		//Parameter Summary : N/A
		public void EnterTheTransactionAmountDetails(Map<Object, Object> testdatamap) throws InterruptedException {
			try {
			EnterFromTransaction(testdatamap.get("FromTransaction").toString());
			
			EnterToTransaction(testdatamap.get("ToTransaction").toString());
			clickOnTransFeesFixedValueCheckboxAndEnterValue(testdatamap.get("TransFixedValue").toString());
			
			clickOnTransFeesPercentageCheckboxAndEnterValue(testdatamap.get("TransPercentage").toString());
			clickOnAddTransactionButton();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		//Function Summary  : Method to clickOnEditPaymentMethod
		//Parameter Summary : FeesType
		public void clickOnRadioButtonAndEnterTheDetails(Map<Object, Object> testdatamap) throws InterruptedException {
			String FeesType = testdatamap.get("FeesType").toString();
			try {
				if (FeesType.equalsIgnoreCase("FeesByInvoiceAmount")) {
					WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_FeesByInvoicebtn);
					if (CheckElementExists(EdaatOR.Admin_SystemMng_PaymentMethodMng_SwitchBtwTransToInvoice)) {
						
						WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_SwitchBtwTransToInvoice_Yesbtn);	
						clickOnAddInvoicebtn();
						
						EnterTheInvoiceAmountDetails(testdatamap);
					}
					else
					{
						clickOnAddInvoicebtn();
						
						EnterTheInvoiceAmountDetails(testdatamap);
					}
				} 
				else {
					WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_FeesByTransactionbtn);
					if (CheckElementExists(EdaatOR.Admin_SystemMng_PaymentMethodMng_SwitchBtwInvoiceToTrans)) {
						
						WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_SwitchBtwInvoiceToTrans_Yesbtn);		
						clickOnAddTransactionbtn();
						
						EnterTheTransactionAmountDetails(testdatamap);
					}
					else
					{
						clickOnAddTransactionbtn();
						
						EnterTheTransactionAmountDetails(testdatamap);	
					}
			}
			}
				catch (Exception e) {
				e.printStackTrace();
			}
		}
		//Function Summary  : Method to verifyThePriorityIsForCategoryFees
		//Parameter Summary : CompanyName,BillerCode,PaymentMethod,FromAmount,ToAmount,FromTransaction
		public void verifyToAddCategoryFees(Map<Object, Object> testdatamap, Log Log) throws InterruptedException {
			try {
				VerifyValue(testdatamap.get("CompanyName").toString(), EdaatOR.Admin_ApprovedMgm_BillerName);
				VerifyValue(testdatamap.get("BillerCode").toString(), EdaatOR.Admin_ApprovedMgm_BillerID);
				VerifyValue("Corporate", EdaatOR.Admin_ApprovedMgm_BillerType);
				VerifyValue("No", EdaatOR.Admin_ApprovedMgm_EmailConf);
				verifyElementIsPresent(EdaatOR.Admin_SystemMgm_BillerActivateBtn);
				verifyElementIsPresent(EdaatOR.Admin_ApprovedMgm_EyeIcon);	
				WebClickUsingJS(EdaatOR.Admin_SystemMgm_BillerActivateBtn);
				Thread.sleep(2000);
				WebClickUsingJS("//label[contains(text(),'"+testdatamap.get("PaymentMethod").toString()+"') and contains(@for,'pm')]/parent::div/parent::div//a[contains(@href,'AZMFees?')]");
				switchToWindow();
				clickOnRadioButtonAndEnterTheDetails(testdatamap);
				String FeesType = testdatamap.get("FeesType").toString();
				if (FeesType.equalsIgnoreCase("FeesByInvoiceAmount")) {
					VerifyValue1(getText("//table//td[text()='"+testdatamap.get("FromAmount").toString()+"']"),testdatamap.get("FromAmount").toString());
					VerifyValue1(getText("//table//td[text()='"+testdatamap.get("ToAmount").toString()+"']"),testdatamap.get("ToAmount").toString());
				}
				else
				{
					VerifyValue1(getText("//table//td[text()='"+testdatamap.get("FromTransaction").toString()+"']"),testdatamap.get("FromTransaction").toString());
					VerifyValue1(getText("//table//td[text()='"+testdatamap.get("ToTransaction").toString()+"']"),testdatamap.get("ToTransaction").toString());
				}
				
				Log.ReportEvent("PASS", "Verify that AZM fees can be define as category by (invoice amount/transaction count) functionality is successful");
				test.log(Status.PASS,"#FUNC-Verify that AZM fees can be define as category by (invoice amount/transaction count) functionality is successfull" + driver.getTitle()+ " * Verify that AZM fees can be define as category by (invoice amount/transaction count) functionality is successfull PASS * " );	
				this.takeScreenShot();
			} catch (Exception e) {
				e.printStackTrace();
				test.log(Status.FAIL,"#FUNC-Verify that AZM fees can be define as category by (invoice amount/transaction count) functionality is Unsuccessfull" + driver.getTitle()+ " * Verify that AZM fees can be define as category by (invoice amount/transaction count) functionality is Unsuccessfull FAIL * " );	
				this.takeScreenShot();
			}	
		}
		
	//Function Summary   : Method to navigateApprovedBillerManagement
	//Parameter Summary  : CompanyName,BillerCode,UpdatedBillerName,UpdatedArabicName,UpdatedEnglishName
	public void VerifyApprovedGridViewAndUpdate(Map<Object, Object> testdatamap,Log Log) throws Exception {
		VerifyValue(testdatamap.get("CompanyName").toString(), EdaatOR.Admin_ApprovedMgm_BillerName);
		VerifyValue(testdatamap.get("BillerCode").toString(), EdaatOR.Admin_ApprovedMgm_BillerID);
		VerifyValue("Corporate", EdaatOR.Admin_ApprovedMgm_BillerType);
		VerifyValue("No", EdaatOR.Admin_ApprovedMgm_EmailConf);
		verifyElementIsPresent(EdaatOR.Admin_SystemMgm_BillerActivateBtn);
		verifyElementIsPresent(EdaatOR.Admin_ApprovedMgm_EyeIcon);	
		WebClickUsingJS(EdaatOR.Admin_SystemMgm_BillerActivateBtn);
		Thread.sleep(1000);
		enterTempBenificaryName(testdatamap.get("UpdatedBillerName").toString());
		WebEdit(EdaatOR.Admin_SystemMgm_BillerAliasName,testdatamap.get("UpdatedArabicName").toString() );
		WebEdit(EdaatOR.Admin_SystemMgm_BillerAliasEnName, testdatamap.get("UpdatedEnglishName").toString());
		clickOnSave();
		Thread.sleep(1000);
		clickOnSaveYeBtn();
		Thread.sleep(1000);
		WebEdit(EdaatOR.Admin_SystemMgm_SearchItem,testdatamap.get("CompanyName").toString() );
		WebClick(EdaatOR.Admin_SystemMgm_Searchbtn);
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_SystemMgm_BillerActivateBtn);
		Thread.sleep(1000);
		VerifyValue1(testdatamap.get("UpdatedBillerName").toString(), WebGetTextAttribute(EdaatOR.Admin_SystemMgm_BillerTemBenificary));
		VerifyValue1(testdatamap.get("UpdatedArabicName").toString(), WebGetTextAttribute(EdaatOR.Admin_SystemMgm_BillerAliasName));
		VerifyValue1(testdatamap.get("UpdatedEnglishName").toString(), WebGetTextAttribute(EdaatOR.Admin_SystemMgm_BillerAliasEnName));
    	Log.ReportEvent("PASS", "Verify to update biller account Info  & Verify Grid details view  ");
    	this.takeScreenShot();
	}
	//Function Summary   : Method to Click On Define AzmFees Button
	//Parameter Summary  : PaymentsMethods
	public void ClickOnDefineAzmFeesButton(Map<Object, Object> testdatamap,Log Log) throws Exception {
		clickOnActivateLink();
		Thread.sleep(1000);
		WebClick("//label[text()='"+testdatamap.get("PaymentMethods").toString()+"']/parent::div/following-sibling::div//a[@class='btn btn-outline-secondary btn-sm btn-block']");
		Log.ReportEvent("PASS", "Clicked On Define AzmFees Button based on payment method ");	
		this.takeScreenShot();
	}
	//Function Summary   : Method to Click On Define visa fees button
	//Parameter Summary  : PaymentsMethods,Error,BillerName
		public void ClickOnDefineVisaFeesActivationButton(Map<Object, Object> testdatamap,Log Log) throws Exception {
			try {
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Sytemmanagement_BillerMgm);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_ApprovedMgm_Menu);
			Thread.sleep(1000);
			enterOnSearchItem(testdatamap.get("BillerName").toString());
			clickOnSearchBtn();
			Thread.sleep(1000);
			clickOnActivateLink();
			Thread.sleep(1000);
			scrollDowntillend(driver);
			WebClickUsingJS("//a[contains(text(),'"+testdatamap.get("DefineFees").toString()+"')]");
			VerifyValue1(getText(EdaatOR.Admin_ApprovedBiller_AzmFeesActivationError), testdatamap.get("Error").toString());
			Log.ReportEvent("PASS", "Click On Define visa fees button ");	
			this.takeScreenShot();
		
		}
		catch (Exception e) {
		test.log(Status.FAIL,"#FUNC- Click On Define visa fees button" + driver.getTitle()+ " * Click On Define visa fees button FAIL * " );
	
		}
		}
		public void clickOnSaveButton()
		{
			WebClick(EdaatOR.Admin_BillerMang_BillerActivationSaveBtn);	
		}
		public void clickOnConformSaveButton()
		{
			WebClick(EdaatOR.Admin_BillerMang_BillerActivationConformSaveBtn);	
		}
	
	//Function Summary   : Method to verify Deactivated PaymentMethod is Not Available.	
		public void verifyDeactivatedPaymentMethodisNotAvailable(Log Log) throws Exception {
			clickOnActivateLink();			
			Thread.sleep(500);
			WebElement element=driver.findElement(By.xpath(EdaatOR.Admin_BillerMang_AvailPayMeth_Sadad));
			scrollToElement(driver, element);
			
			Thread.sleep(500);
			verifyElementIsNotPresent(EdaatOR.Admin_BillerMang_AvailPayMeth_ApplePay);
			clickOnSaveButton();
			Thread.sleep(500);
			clickOnConformSaveButton();		
			Thread.sleep(500);
			Log.ReportEvent("PASS", "verified Deactivated PaymentMethod is Not Available ");	
			this.takeScreenShot();
		}
		//Function Summary   : Method to check minimum invoice amount checkbox
		//Parameter Summary  : BillerName
			public void checkMinInvoiceAmountCheckbox(Map<Object, Object> testdatamap,Log Log) throws Exception {
				try {
				Thread.sleep(1000);
				clickOnActivateLink();
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Biller_ExportBills_minimumInvoice_Checkbox);
				Thread.sleep(500);
				WebEdit(EdaatOR.Biller_ExportBills_minimumInvoice_Textbox, testdatamap.get("MinAmount").toString());
				Thread.sleep(500);
				clickOnSave();
				Thread.sleep(500);
				clickOnSaveYeBtn();
				Log.ReportEvent("PASS", "Verify that when admin check the check box a textbox is viewed to enter minimum value");	
				this.takeScreenShot();
			}
			catch (Exception e) {
			test.log(Status.FAIL,"#FUNC- Verify that when admin check the check box a textbox is viewed to enter minimum value" + driver.getTitle()+ " * FAIL * " );
			this.takeScreenShot();
			}
			}
			//Function Summary   : Method to Verify Customized Transfer Notes Is updatable Any Time
		//Parameter Summary  : BillerName
		public void VerifyCustomizedTransferNotesIsupdatableAnyTime(Map<Object, Object> testdatamap,Log Log) {

			try
			{
				WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
				takeScreenShot();
				WebClickUsingJS(EdaatOR.Admin_Sytemmanagement_Billers_Management);
				takeScreenShot();
				WebClickUsingJS(EdaatOR.Admin_SysMgm_ApprovedBillers);
				Thread.sleep(2000);
				takeScreenShot();
				enterOnSearchItem(testdatamap.get("BillerName").toString());
				clickOnSearchBtn();
				Thread.sleep(2000);
				takeScreenShot();
			    WebClickUsingJS(EdaatOR.Admin_SystemMgm_BillerActivateBtn);
				takeScreenShot();
	            WebClickUsingJS(EdaatOR.Admin_SysMgm_AprBiller_customNotes_checkBox);
				Thread.sleep(1000);
	            WebClickUsingJS(EdaatOR.Admin_SysMgm_AprBiller_customNotes_checkBox);
			    test.log(Status.PASS,"#FUNC- Verify that  a new  checkbox “Customized Transfer Notes” is updatable any time" + driver.getTitle()+ " * Verify that  a new  checkbox “Customized Transfer Notes” is updatable any time PASS * " );
	    	    Log.ReportEvent("PASS", "Verify that  a new  checkbox “Customized Transfer Notes” is updatable any time ");
	    	    this.takeScreenShot();
			}
			
			catch (Exception e) {
				test.log(Status.FAIL,"#FUNC- Verify that  a new  checkbox “Customized Transfer Notes” is updatable any time" + driver.getTitle()+ " * Verify that  a new  checkbox “Customized Transfer Notes” is updatable any time FAIL * " );
				this.takeScreenShot();
				}
		}
		//Function Summary   : Method to Select The Payment Method
	    //Parameter Summary  : paymentMethod
				public void SelectThePaymentMethod(String paymentMethod) {
					try {
						
					if (paymentMethod.equalsIgnoreCase("sadad")) {
						
						WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_SadadBtn);
					}
					else if (paymentMethod.equalsIgnoreCase("mada")) {
						
						WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_MadaBtn);
					}
					else if (paymentMethod.equalsIgnoreCase("visa")) {
						
						WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_VisaBtn);
					}
					else if (paymentMethod.equalsIgnoreCase("All")) {
						WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_MasterCardBtn);
						WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_SadadBtn);
						WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_MadaBtn);
						WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_VisaBtn);
						WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_ApplePayBtn);
					}
					else {
						
						WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_MasterCardBtn);
					}
				}
					catch (Exception e) {
						e.printStackTrace();
					}
					
				}
				
					//Function Summary   : Method to Select The Payment Method
				//Parameter Summary  : paymentMethod
				
				public void VerifySelectedPaymentType(String paymentMethod,Log Log)
				{
					try {
						WebElement paymentFieldSadad = driver.findElement(By.xpath(EdaatOR.Systemmgmt_NonApproved_SadadBtn));
						WebElement paymentFieldMada = driver.findElement(By.xpath(EdaatOR.Systemmgmt_NonApproved_MadaBtn));
						WebElement paymentFieldVisa = driver.findElement(By.xpath(EdaatOR.Systemmgmt_NonApproved_VisaBtn));
						WebElement paymentFieldMasterard = driver.findElement(By.xpath(EdaatOR.Systemmgmt_NonApproved_MasterCardBtn));
						WebElement paymentFieldApplePay = driver.findElement(By.xpath(EdaatOR.Systemmgmt_NonApproved_ApplePayBtn));
						
						if (paymentMethod.equalsIgnoreCase("sadad")) {
							
							paymentFieldSadad.isSelected();
							
						}
						else if (paymentMethod.equalsIgnoreCase("mada")) {
							
							paymentFieldMada.isSelected();
						}
						else if (paymentMethod.equalsIgnoreCase("visa")) {
							
							paymentFieldVisa.isSelected();
						}
						else if (paymentMethod.equalsIgnoreCase("All")) {
							paymentFieldSadad.isSelected();
							paymentFieldMada.isSelected();
							paymentFieldVisa.isSelected();
							paymentFieldMasterard.isSelected();
							paymentFieldApplePay.isSelected();
						}
						else {
							
							WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_MasterCardBtn);
						}
						Log.ReportEvent("PASS", "Verify Selected Payment Type");
						test.log(Status.PASS,"#FUNC-Verify Selected Payment Type" + driver.getTitle()+ " * Verify Selected Payment Type PASS * " );
						this.takeScreenShot();
					}
						catch (Exception e) {
							e.printStackTrace();
							test.log(Status.FAIL,"#FUNC-Verify View Payment Method Details Incorrect" + driver.getTitle()+ " * Verify View Payment Method Details Incorrect FAIL * " );
							this.takeScreenShot();
						}
					
				}
				
				//Function Summary   : Method to Verify Admin Able To Add Or Update Payment Type
				//Parameter Summary  : paymentMethod
				public void VerifyAdminAbleToAddOrUpdatePaymentType(Map<Object, Object> testdatamap,Log Log)
				{
					try {
						AdminSystemMangement AdminSystemMangement=new AdminSystemMangement(driver, test);
						AdminSystemMangement.navigateApprovedBillerManagement(testdatamap, Log);
						clickOnActivateLink();
						if (testdatamap.get("PaymentMethod").toString().equalsIgnoreCase("sadad")) {
							
							WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_MadaBtn);
						}
						else if (testdatamap.get("PaymentMethod").toString().equalsIgnoreCase("mada")) {
							
							WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_VisaBtn);
						}
						else if (testdatamap.get("PaymentMethod").toString().equalsIgnoreCase("visa")) {
							
							WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_ApplePayBtn);
						}
						else if (testdatamap.get("PaymentMethod").toString().equalsIgnoreCase("All")) {
							WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_MasterCardBtn);
							WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_SadadBtn);
							WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_MadaBtn);
							WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_VisaBtn);
							WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_ApplePayBtn);
						}
						else {
							
							WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_MasterCardBtn);
						}
						clickOnSave();
						clickOnSaveYeBtn();
						AdminSystemMangement.navigateApprovedBillerManagement(testdatamap, Log);
						clickOnActivateLink();
						VerifySelectedPaymentType(testdatamap.get("PaymentMethod").toString(),Log);
						Log.ReportEvent("PASS", "Verify Admin Able To Add Or Update Payment Type");
						test.log(Status.PASS,"#FUNC-Verify Admin Able To Add Or Update Payment Type is Successfull" + driver.getTitle()+ " * Verify Admin Able To Add Or Update Payment Type PASS * " );
						this.takeScreenShot();
					}
					catch (Exception e) {
						e.printStackTrace();
						test.log(Status.FAIL,"#FUNC-Verify Admin Able To Add Or Update Payment Type is not Successfull " + driver.getTitle()+ " * Verify Admin Able To Add Or Update Payment Type FAIL * " );
						this.takeScreenShot();
					}
				
				}
				
					
				//Function Summary   : Method to Verify To Add Fixed And Percentage Fees
				//Parameter Summary  : paymentMethod
				
				public void VerifyToAddFixedAndPercentageFees(Map<Object, Object> testdatamap,Log Log)
				{
					try {
						AdminSystemMangement AdminSystemMangement=new AdminSystemMangement(driver, test);
						AdminSystemMangement.navigateApprovedBillerManagement(testdatamap, Log);
						clickOnActivateLink();
						WebClickUsingJS(EdaatOR.Admin_CustomReconciliationReport_DefineAzmFeesButton);
						Thread.sleep(2000);
						WebClick(EdaatOR.Admin_PaymentMethodMngEditFeesFixedValueCheckbox);
						Thread.sleep(2000);
						WebEdit(EdaatOR.Admin_PaymentMethodMngEditFeesFixedValueAmount,testdatamap.get("Fixed").toString() );
						Thread.sleep(2000);
						WebClick(EdaatOR.Admin_PaymentMethodMngEditFeesPercentageCheckbox);
						Thread.sleep(2000);
						WebEdit(EdaatOR.Admin_PaymentMethodMngEditFeesPercentageAmount,testdatamap.get("Percentage").toString() );
						Thread.sleep(2000);

						WebClickUsingJS(EdaatOR.Admin_PaymentMethodMngEditFeesSaveButton);

						Log.ReportEvent("PASS", "Verify To Add Fixed And Percentage Fees");
						test.log(Status.PASS,"#FUNC-Verify To Add Fixed And Percentage Fees is Successfull" + driver.getTitle()+ " * Verify To Add Fixed And Percentage Fees PASS * " );
						this.takeScreenShot();
					}
					catch (Exception e) {
						e.printStackTrace();
						test.log(Status.FAIL,"#FUNC-Verify To Add Fixed And Percentage Fees is not Successfull " + driver.getTitle()+ " * Verify To Add Fixed And Percentage Fees FAIL * " );
						this.takeScreenShot();
					}
					
				}
	//Function Summary   : Method to VerifyTransferRemarkField
	//Parameter Summary  : N/A
	public void VerifyTransferRemarkFieldIsChecked(Map<Object, Object> testdatamap, Log Log) throws Exception {
	try {

		WebClick(EdaatOR.Admin_SystemMgm_BillerActivateBtn);
		driver.findElement(By.xpath(EdaatOR.Admin_SystemMgm_TransferRemarkCheckbox)).sendKeys(Keys.PAGE_DOWN);
		if(IsSelected(EdaatOR.Admin_SystemMgm_TransferRemarkCheckbox))
		{
			
			test.log(Status.PASS,"#FUNC- Transfer Remark field is Checked" + driver.getTitle()+ "Transfer Remark field is Checked PASS * " );
	    	Log.ReportEvent("PASS", "Transfer Remark field is Checked");
	    	this.takeScreenShot();
		}
		else {
			test.log(Status.FAIL,"#FUNC- Transfer Remark field is NotChecked" + driver.getTitle()+ " * Transfer Remark field is NotChecked FAIL " );
		}
	} catch (Exception e) {
		e.printStackTrace();
		test.log(Status.FAIL,"#FUNC- Transfer Remark field is NotChecked" + driver.getTitle()+ " * Transfer Remark field is NotChecked FAIL " );
		this.takeScreenShot();
	}
	}
}
