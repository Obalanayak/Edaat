/**
*
* Test Script Name                   : N/A
* Objective                          : Not approved billers management functionality.
* Version                            : 1.0
* Author                             : Kathirvelu M
* Created Date                       : 23/05/2023
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
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.internal.TestMethodWithDataProviderMethodWorker;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.azmqalabs.edaattestautomation.testscripts.admin.AdminNotApprovedMgmCloseBiller;
import com.azmqalabs.edaattestautomation.testscripts.admin.AdminSystemMngBillerMgmtVerifyNewCheckboxViewedAfterAdminCheckSubbillerCheckbox;
import com.google.inject.Key;

public class AdminNotApprovedBillerManagement extends BasePage {

	public AdminNotApprovedBillerManagement(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Admin_SystemMgm_SearchItem)
	public WebElement Client;

	public boolean Exists() {
		return super.Exists(Client);
	}
	//Function Summary   : Method to enter biller name  
	//Parameter Summary : searchItem

	public void enterOnSearchItem(String searchItem) {

		WebEdit(EdaatOR.Admin_SystemMgm_SearchItem, searchItem);
	}

	//Function Summary   : Method to click on "Search" button.
	//Parameter Summary : N/A
	public void clickOnSearchBtn() {

		WebClick(EdaatOR.Admin_SystemMgm_Searchbtn);
	}

 		//Function Summary   : Method to search biller 
 		//Parameter Summary :  Search
	public void searchNotApprovedBillerMgm(String Search) throws Exception {
		enterOnSearchItem(Search);
		clickOnSearchBtn();
		waitForPageToLoad();
		Thread.sleep(1000);
	}

	//Function Summary   : Method to click on biller activation(edit) link
	//Parameter Summary : N/A
	public void clickOnActivateLink() {

		WebClick(EdaatOR.Admin_SystemMgm_BillerActivateBtn);
	}

	//Function Summary   : Method to enter corporate name in Arabic and English 
	//Parameter Summary : ArabicName and EnglishName.
	public void enterOnBillerActiName(Map<Object, Object> testdatamap) {
		WebEdit(EdaatOR.Admin_SystemMgm_BillerAliasName,testdatamap.get("ArabicName").toString() );
		WebEdit(EdaatOR.Admin_SystemMgm_BillerAliasEnName, testdatamap.get("EnglishName").toString());
	}

	//Function Summary   : Method to click on  "super biller" checkbox
	//Parameter Summary : N/A
	public void clickOnIsbiller() {
	WebClickUsingJS(EdaatOR.Admin_SystemMgm_IsBiller);
	}

	//Function Summary   : Method to click on "yes"
	//Parameter Summary : N/A
	public void clickOnIsbillerYesbtn() {
		WebClickUsingJS(EdaatOR.Admin_SystemMgm_IsBillerYesBtn);
	}

//Function Summary  : Method to click on save button
//Parameter Summary : NA
	public void clickOnSave() {
		WebClick(EdaatOR.Admin_SystemMgm_SavesBtn);
	}
	
//Function Summary  : Method click on yes button
//Parameter Summary : NA
	public void clickOnSaveYeBtn() {
		WebClick(EdaatOR.Admin_SystemMgm_SaveYesBtn);
	}

//Function Summary  : Method click on Close button
//Parameter Summary : NA
	public void clickOnClose() {
		WebClick(EdaatOR.Admin_SystemMgm_ApprovalCloseBtn);
	}

	//Function Summary   : Method to  clickOnIsTrackerBiiller
	//Parameter Summary  : N/A	
	public void clickOnIsTrackerBiiller() {
		WebClickUsingJS(EdaatOR.Admin_NotAppmMgm_IsTrackerBiller);
	}
	//Function Summary   : Method to  clickOnIsTrackBillerYesbtn
	//Parameter Summary  : N/A
	public void clickOnIsTrackBillerYesbtn() {
		WebClickUsingJS(EdaatOR.Admin_NotAppmMgm_IsTrackerBillerYesbtn);
	}
	//Function Summary   : Method to  selectTrackerCheckBox
	//Parameter Summary  : N/A	
	public void selectTrackerCheckBox() throws Exception {
		clickOnIsTrackerBiiller();
		Thread.sleep(800);
		clickOnIsTrackBillerYesbtn();
		Thread.sleep(800);
	}
	
	//Function Summary   : Method to enter Biller code
	//Parameter Summary : Benifi
	public void enterTempBillerCode(String Benifi) {
		WebEdit(EdaatOR.Admin_SystemMgm_BillerCode,Benifi);
	}
	//Function Summary   : Method to enter beneficiary name 
	//Parameter Summary : Benifi
	public void enterTempBenificaryName(String Benifi) {
		WebEdit(EdaatOR.Admin_SystemMgm_BillerTemBenificary,Benifi);
	}
	//Function Summary   : Method to enter Duration  
	//Parameter Summary : Benifi
	public void enterDuration(String Benifi) {
		WebEdit(EdaatOR.Admin_SystemMgm_BillerTransferDura,Benifi);
	}

	
	public void selectSuperTrackerBiller(String Benifi) {
		WebSelectByVisibleText(EdaatOR.Admin_TrackerBillerMangm_SelectNewSuper,Benifi);
	}

	//Function Summary   : Method to select biller category    
   //Parameter Summary   : Benifi 
	public void selectCategoryID(String Benifi) {
		WebSelectByVisibleText(EdaatOR.Admin_SystemMgm_BillerCategoryID,Benifi);
	}
	//Function Summary  : to click on reject button
	//Parameter Summary : NA	
	public void clickOnRejectedLink() throws Exception {
		scrollDowntillend(driver);
		WebClick(EdaatOR.Admin_RejectButton);
		Thread.sleep(1000);
		VerifyValue("Are you sure to reject the biller account information?", EdaatOR.Admin_RejectConfiMessage);
		WebClickUsingJS(EdaatOR.Admin_RejectYesButton);
	}
	
	//Function Summary   : Method to enter beneficiary details and save. 
	//Parameter Summary : BenificaryName,BillerCode,Duration,BenificaryCategory,PaymentMethod
	public void EnterBilleDetails(Map<Object, Object> testdatamap){
		try{
			enterTempBenificaryName(testdatamap.get("BenificaryName").toString());
			enterTempBillerCode(testdatamap.get("BillerCode").toString());
			enterDuration(testdatamap.get("Duretion").toString());
			enterOnBillerActiName(testdatamap);
			selectCategoryID(testdatamap.get("BenificaryCategory").toString());
			scrollDowntillend(driver);
			SelectThePaymentMethod(testdatamap.get("PaymentMethod").toString());
			this.takeScreenShot();
			scrollDowntillend(driver);
			Thread.sleep(1000);
			clickOnIsbiller();
			Thread.sleep(1000);
			clickOnIsbillerYesbtn();
			Thread.sleep(1000);
			test.log(Status.PASS,"#FUNC-EnterActivateBilleDetaisl" + driver.getTitle() +" * Corporatee Client Table Exists PASS * " );
			takeScreenShot();		

		}catch(Exception e){
			test.log(Status.FAIL,"#FUNC-EnterActivateBilleDetaisl" + driver.getTitle() +" * Table View Corporate client FAIL * " );
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
	//Function Summary   : Method to  EnterTrackerBillerDetails
	//Parameter Summary  : BenificaryName,BillerCode,Duretion,BenificaryCategory,SuperBillerName
	public void EnterTrackerBillerDetails(Map<Object, Object> testdatamap){
		try{
			enterTempBenificaryName(testdatamap.get("BenificaryName").toString());
			enterTempBillerCode(testdatamap.get("BillerCode").toString());
			enterDuration(testdatamap.get("Duretion").toString());
			enterOnBillerActiName(testdatamap);
			selectCategoryID(testdatamap.get("BenificaryCategory").toString());
			SelectThePaymentMethod(testdatamap.get("PaymentMethod").toString());
			this.takeScreenShot();
			scrollDowntillend(driver);
			selectTrackerCheckBox();
			Thread.sleep(1000);
			selectSuperTrackerBiller(testdatamap.get("SuperBillerName").toString());
			test.log(Status.PASS,"#FUNC-EnterActivateBilleDetaisl" + driver.getTitle() +" * Corporatee Client Table Exists PASS * " );
			takeScreenShot();		

		}catch(Exception e){
			test.log(Status.FAIL,"#FUNC-EnterActivateBilleDetaisl" + driver.getTitle() +" * Table View Corporate client FAIL * " );
			this.takeScreenShot();
		}
	}


	//Function Summary   : Method to click on Approval button
	//Parameter Summary : N/A
	public void clickOnApproval() throws InterruptedException {

		WebClick(EdaatOR.Admin_SystemMgm_ApprovalBtn);
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_SystemMgm_ApprovalYesBtn);
		Thread.sleep(1000);
		waitForPageToLoad();
	}


    //Function Summary   : Method to save and approve the biller activation
	//Parameter Summary  : CompanyName	
	public void VerifyBillerIsActivated(Map<Object, Object> testdatamap,Log Log) throws Exception {
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		clickOnActivateLink();
		EnterBilleDetails(testdatamap);
		SaveBillerDetails();
		takeScreenShot();
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		takeScreenShot();
		clickOnActivateLink();
		verifyElementIsPresent(EdaatOR.Admin_SystemMgm_ApprovalBtn);
		clickOnApproval();
		Thread.sleep(2000);
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		Thread.sleep(2000);
		verifyElementIsNotPresent(EdaatOR.Admin_SystemMgm_RecordUnclickable, "Slid Bar is activated");
		boolean Ele=CheckElementExists(EdaatOR.Admin_SystemMgm_RecordApproved);
		if(Ele==true) 
		{
		test.log(Status.PASS,"#FUNC-VerifyBillerIsActivated" + driver.getTitle() +" * Verify Biller is able to save and Approve * PASSED" );
    	Log.ReportEvent("PASS", "Search Biller and Activate the Biller ");
		}
		else
		{
		test.log(Status.FAIL,"#FUNC-VerifyBillerIsActivated" + driver.getTitle() +" * Verify Biller is able to save and Approve FAILED* " );	
		}
}


	//Function Summary   : Method to VerifyClosedBillerForDeactivate
	//Parameter Summary  : CompanyName
	public void VerifyClosedBillerForDeactivate(Map<Object, Object> testdatamap,Log Log) throws Exception {

		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		if(CheckElementExists(EdaatOR.Admin_SystemMgm_RecordNotFound)==true) {
			AdminNotApprovedMgmCloseBiller.record=false;
		}
		else {
			clickOnActivateLink();
			//EnterBilleDetails(testdatamap);
			Thread.sleep(1000);
			this.takeScreenShot();
			clickOnClose();
			Thread.sleep(1000);
			searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
			takeScreenShot();
			boolean Ele=CheckElementExists(EdaatOR.Admin_SystemMgm_RecordNotApproved);
			if(Ele==true) {
				test.log(Status.PASS,"#FUNC-VerifyClosedBillerForDeactivate" + driver.getTitle() +" * Biller is notactive ID PASS * " );
				takeScreenShot();
				Log.ReportEvent("PASS", "Verify to click on close button withoud doing any action by maker ");

			}else
				test.log(Status.FAIL,"#FUNC-VerifyClosedBillerForDeactivate" + driver.getTitle() +" * Biller is active FAIL * " );	
			AdminNotApprovedMgmCloseBiller.record=true;
		}
	}
	//Function Summary   : Method to VerifyBillerInavlidActivated
	//Parameter Summary  : CompanyName
	public void VerifyBillerInavlidActivated(Map<Object, Object> testdatamap,Log Log) throws Exception {
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		clickOnActivateLink();
		EnterBilleDetails(testdatamap);
		SaveBillerDetails();
		takeScreenShot();
		VerifyValue("Biller code is already in use", EdaatOR.Admin_SystemMgm_ErrorMeesage);
		test.log(Status.PASS,"#FUNC-VerifyBillerInavlidActivated" + driver.getTitle() +" * Verify Biller is not activate for invalid entry * " );
    	Log.ReportEvent("PASS", "Verify to enter Invalid activation info for deactivated biller by maker is successful ");

	}

	//Function Summary   : Method to click on save button
	//Parameter Summary : N/A
	public void SaveBillerDetails() throws Exception {
		scrollDowntillend(driver);
		clickOnSave();
		Thread.sleep(1000);
		clickOnSaveYeBtn();
		Thread.sleep(1000);
		takeScreenShot();
	}
//Function Summary  :verify biller approval rejected
//Parameter Summary : CompanyName.
	public void VerifyBillerApprovalIsRejected(Map<Object, Object> testdatamap,Log Log) throws Exception {
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		clickOnActivateLink();
		EnterBilleDetails(testdatamap);
		SaveBillerDetails();
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		takeScreenShot();
		clickOnActivateLink();
		clickOnRejectedLink();
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		boolean Ele=CheckElementExists(EdaatOR.Admin_SystemMgm_RecordNotApproved);
		if(Ele==true) {
			test.log(Status.PASS,"#FUNC-VerifyBillerApprovalIsRejected" + driver.getTitle() +" * Biller is approval is rejected PASS * " );
			takeScreenShot();
        	Log.ReportEvent("PASS", "Verify to Reject the biller activation account by checker");

		}else
			test.log(Status.FAIL,"#FUNC-VerifyBillerApprovalIsRejected" + driver.getTitle() +" * Biller is approval is rejected FAIL * " );	
		
	}	
//Function Summary  : to search biller in not approved billers management click on edit and close
//Parameter Summary : CompanyName	
	public void VerifyBillerApprovalIsClosed(Map<Object, Object> testdatamap,Log Log) throws Exception {
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		clickOnActivateLink();
		clickOnClose();
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		boolean Ele=CheckElementExists(EdaatOR.Admin_SystemMgm_RecordNotApproved);
		if(Ele==true) {
			test.log(Status.PASS,"#FUNC-VerifyBillerApprovalIsClosed" + driver.getTitle() +" * Biller is approval is rejected PASS * " );
			takeScreenShot();
        	Log.ReportEvent("PASS", "Verify to click on close button withoud doing any action by checker ");

		}else
			test.log(Status.FAIL,"#FUNC-VerifyBillerApprovalIsClosed" + driver.getTitle() +" * Biller is approval is rejected FAIL * " );	
		
	}
	
	public void VerifyGridViewNotManagement(Map<Object, Object> testdatamap,Log Log) throws Exception {

		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		if(CheckElementExists(EdaatOR.Admin_SystemMgm_RecordNotFound)==true) {
			AdminNotApprovedMgmCloseBiller.record=false;
			Log.ReportEvent("PASS", "Verify the Grid view details functionality is successful ");

		}
		else {
			this.takeScreenShot();
			VerifyValue(testdatamap.get("CompanyName").toString(), EdaatOR.Admin_SystemMgm_CorpName);
			VerifyValue("Corporate", EdaatOR.Admin_SystemMgm_CorpType);
			this.takeScreenShot();
			VerifyValue("No", EdaatOR.Admin_SystemMgm_EmailConf);
			verifyElementIsPresent(EdaatOR.Admin_SystemMgm_RecordUnclickable);
			this.takeScreenShot();
			verifyElementIsPresent(EdaatOR.Admin_SystemMgm_EyeIcon_view);	
			AdminNotApprovedMgmCloseBiller.record=true;
			Log.ReportEvent("PASS", "Verify the Grid view details functionality is successful ");

		}
	}

	//Function Summary   : Method to ApproveBiller
	//Parameter Summary  : CompanyName
	
	public void ApproveBiller(Map<Object, Object> testdatamap,Log Log) throws Exception {
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		clickOnActivateLink();
		EnterBilleDetails(testdatamap);
		SaveBillerDetails();
		takeScreenShot();
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		takeScreenShot();
		clickOnActivateLink();
		clickOnApproval();
    	Log.ReportEvent("PASS", "Search Biller and Activate the Biller ");

	}
	
	
	public void verifyApproveBillerChecker(Map<Object, Object> testdatamap) throws Exception {
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
		
	}
	
	
	public void VerifyApprovedGridViewAndUpdate(Map<Object, Object> testdatamap) throws Exception {
		VerifyValue(testdatamap.get("CompanyName").toString(), EdaatOR.Admin_ApprovedMgm_BillerName);
		VerifyValue(testdatamap.get("BillerCode").toString(), EdaatOR.Admin_ApprovedMgm_BillerID);
		VerifyValue("Corporate", EdaatOR.Admin_ApprovedMgm_BillerType);
		VerifyValue("No", EdaatOR.Admin_ApprovedMgm_EmailConf);
		verifyElementIsPresent(EdaatOR.Admin_SystemMgm_BillerActivateBtn);
		verifyElementIsPresent(EdaatOR.Admin_ApprovedMgm_EyeIcon);	
		WebClick(EdaatOR.Admin_SystemMgm_BillerActivateBtn);
		Thread.sleep(1000);
		enterTempBenificaryName(testdatamap.get("UpdatedBillerName").toString());
		WebEdit(EdaatOR.Admin_SystemMgm_BillerAliasName,testdatamap.get("UpdatedArabicName").toString() );
		WebEdit(EdaatOR.Admin_SystemMgm_BillerAliasEnName, testdatamap.get("UpdatedEnglishName").toString());
		SaveBillerDetails();
		WebClick(EdaatOR.Admin_SystemMgm_BillerActivateBtn);
		Thread.sleep(1000);
		VerifyValue1(testdatamap.get("UpdatedBillerName").toString(), WebGetTextAttribute(EdaatOR.Admin_SystemMgm_BillerTemBenificary));
		VerifyValue1(testdatamap.get("UpdatedArabicName").toString(), WebGetTextAttribute(EdaatOR.Admin_SystemMgm_BillerAliasName));
		VerifyValue1(testdatamap.get("UpdatedEnglishName").toString(), WebGetTextAttribute(EdaatOR.Admin_SystemMgm_BillerAliasEnName));
		
	}
	
	
	//Function Summary   : Method to CreateTrackerBill
	//Parameter Summary  : N/A
	public void CreateTrackerBill(Map<Object, Object> testdatamap,Log Log) throws Exception {
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		clickOnActivateLink();
		EnterTrackerBillerDetails(testdatamap);
		SaveBillerDetails();
		takeScreenShot();
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		takeScreenShot();
		clickOnActivateLink();
		clickOnApproval();
		takeScreenShot();
		Log.ReportEvent("PASS", "Save Biller Details as Tracker");

	}
	//Function Summary   : Method to EnterFees
	//Parameter Summary  : N/A
	public void EnterFees(Map<Object, Object> testdatamap) throws InterruptedException {				
		   // WebClear(EdaatOR.Admin_SystemMgm_Biller_sadadfees);
			WebEdit(EdaatOR.Admin_SystemMgm_Biller_sadadfees,testdatamap.get("SadadFees").toString());
			Thread.sleep(1000);
		//	WebClear(EdaatOR.Admin_SystemMgm_Biller_Azimfees);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_SystemMgm_Biller_Azimfees, testdatamap.get("AZMFees").toString());
		
	}
		//Function Summary   : Method to ApproveBillerErrorMsg
		//Parameter Summary  : CompanyName		
		public void ApproveBillerErrorMsg(Map<Object, Object> testdatamap) throws Exception {
			try {
			searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
			clickOnActivateLink();
			enterTempBenificaryName(testdatamap.get("BenificaryName").toString());
			enterTempBillerCode(testdatamap.get("BillerCode").toString());
			enterDuration(testdatamap.get("Duretion").toString());
			enterOnBillerActiName(testdatamap);
			EnterFees(testdatamap);
			selectCategoryID(testdatamap.get("BenificaryCategory").toString());
			scrollDowntillend(driver);
			Thread.sleep(1000);
			selectTrackerCheckBox();
			Thread.sleep(1000);
			selectSuperTrackerBiller(testdatamap.get("SuperBillerName").toString());
			Thread.sleep(1000);
			SaveBillerDetails();
			takeScreenShot();
			if(ExistsCheck(EdaatOR.Admin_SystemMgm_Biller_BenificaryError)&&ExistsCheck(EdaatOR.Admin_SystemMgm_Biller_idError)
			&&ExistsCheck(EdaatOR.Admin_SystemMgm_Biller_Durationerror))
			{
				driver.findElement(By.xpath(EdaatOR.Admin_SystemMgm_BillerAliasEnName)).sendKeys(Keys.PAGE_UP);
				Thread.sleep(3000);
				VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Admin_SystemMgm_Biller_BenificaryError);
				Thread.sleep(1000);
				VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Admin_SystemMgm_Biller_idError);
				Thread.sleep(1000);
				VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Admin_SystemMgm_Biller_Durationerror);
				this.takeScreenShot();
				Thread.sleep(1000);
				test.log(Status.PASS, "#FUNC-BeneficiaryName,Billerid and Transfer duration ErrorMessage Exists" + driver.getTitle() + " * BeneficiaryName,Billerid and Transfer duration ErrorMessage Exists * ");				
			}
			else if (ExistsCheck(EdaatOR.Admin_SystemMgm_Biller_CrpArbError)&&ExistsCheck(EdaatOR.Admin_SystemMgm_Biller_CrpEngError)
					&&ExistsCheck(EdaatOR.Admin_SystemMgm_Biller_BillerCatgError)) {
				driver.findElement(By.xpath(EdaatOR.Admin_SystemMgm_BillerCode)).sendKeys(Keys.PAGE_DOWN);
				Thread.sleep(3000);
				VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Admin_SystemMgm_Biller_CrpArbError);
				Thread.sleep(1000);
				VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Admin_SystemMgm_Biller_CrpEngError);
				Thread.sleep(1000);
				VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Admin_SystemMgm_Biller_BillerCatgError);
				this.takeScreenShot();
				Thread.sleep(1000);
				test.log(Status.PASS, "#FUNC-CorpNameAr,CorpNameEng and BillCat ErrorMessage Exists" + driver.getTitle() + " * CorpNameAr,CorpNameEng and BillCat ErrorMessage Exists * ");				
			}	
			else if(ExistsCheck(EdaatOR.Admin_SystemMgm_Biller_SuperBillerErrormsg))
			{
				VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Admin_SystemMgm_Biller_SuperBillerErrormsg);
				this.takeScreenShot();
				Thread.sleep(1000);
				test.log(Status.PASS, "#Tracked SuperBiller ErrorMessage Exists" + driver.getTitle() + " * Tracked SuperBiller ErrorMessage Exists * ");				
			}
			else if (ExistsCheck(EdaatOR.Admin_SystemMgm_Biller_TransferErrormsg)) {
				driver.findElement(By.xpath(EdaatOR.Admin_SystemMgm_BillerAliasEnName)).sendKeys(Keys.PAGE_UP);
				VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Admin_SystemMgm_Biller_TransferErrormsg);
				this.takeScreenShot();
				Thread.sleep(1000);
				test.log(Status.PASS, "#Invalid Transfer Duration ErrorMessage Exists" + driver.getTitle() + " * Invalid Transfer Duration ErrorMessage Exists * ");				
			}
			else if (ExistsCheck(EdaatOR.Admin_SystemMgm_Biller_sadadfeesError)&&ExistsCheck(EdaatOR.Admin_SystemMgm_Biller_sadadfeestaxerror)) {
				testdatamap.put("Sadadfeestaxerror", getText(EdaatOR.Admin_SystemMgm_Biller_sadadfeestaxerror));
				driver.findElement(By.xpath(EdaatOR.Admin_SystemMgm_BillerAliasEnName)).sendKeys(Keys.PAGE_UP);
				VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Admin_SystemMgm_Biller_sadadfeesError);
				Thread.sleep(1000);
				VerifyValue(testdatamap.get("Sadadfeestaxerror").toString(),EdaatOR.Admin_SystemMgm_Biller_sadadfeestaxerror);
				this.takeScreenShot();
				Thread.sleep(1000);
				test.log(Status.PASS, "#Invalid Sadad Fees ErrorMessage Exists" + driver.getTitle() + " * Invalid Sadad Fees ErrorMessage Exists * ");							
			}
			else if (ExistsCheck(EdaatOR.Admin_SystemMgm_Biller_AzimfeesError)&&ExistsCheck(EdaatOR.Admin_SystemMgm_Biller_Azmfeestaxerror)) {
				testdatamap.put("Azimfeestaxerror", getText(EdaatOR.Admin_SystemMgm_Biller_Azmfeestaxerror));
				driver.findElement(By.xpath(EdaatOR.Admin_SystemMgm_BillerAliasEnName)).sendKeys(Keys.PAGE_UP);
				VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Admin_SystemMgm_Biller_AzimfeesError);
				Thread.sleep(1000);
				VerifyValue(testdatamap.get("Azimfeestaxerror").toString(),EdaatOR.Admin_SystemMgm_Biller_Azmfeestaxerror);
				this.takeScreenShot();
				Thread.sleep(1000);
				test.log(Status.PASS, "#Invalid Azm Fees ErrorMessage Exists" + driver.getTitle() + " * Invalid Azm Fees ErrorMessage Exists * ");							
			}
			else
			{
				test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
			}
		}
			catch (Exception e) {
				
			test.log(Status.FAIL,"#FUNC-Not Approved Biller Management" + driver.getTitle()+ " * Not Approved Biller Management is UnSuccessfull FAIL * " );

			}

		}
		
		//Function Summary   : Method to AssignAllThePaymentMethod
		//Parameter Summary  : CompanyName
		public void verifyAssignAllThePaymentMethods(Map<Object, Object> testdatamap, Log Log) throws Exception {
			searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
			clickOnActivateLink();
			EnterBilleDetails(testdatamap);
			SaveBillerDetails();
			searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
			Thread.sleep(2000);
			takeScreenShot();
			clickOnActivateLink();
			verifyElementIsPresent(EdaatOR.Admin_SystemMgm_ApprovalBtn);
			clickOnApproval();
			Thread.sleep(2000);
			searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
			Thread.sleep(2000);
			verifyElementIsNotPresent(EdaatOR.Admin_SystemMgm_RecordUnclickable, "Slid Bar is activated");
			if(CheckElementExists(EdaatOR.Admin_SystemMgm_RecordApproved)) 
			{
			test.log(Status.PASS,"#FUNC-Verify that the Admin is able to assign all the payment methods is successfull" + driver.getTitle() +" * Verify that the Admin is able to assign all the payment methods is successfull * PASSED" );
        	Log.ReportEvent("PASS", "Verify that the Admin is able to assign all the payment methods is successfull ");
			}
			else
			{
			test.log(Status.FAIL,"#FUNC-Verify that the Admin is able to assign all the payment methods is Unsuccessfull" + driver.getTitle() +" * Verify that the Admin is able to assign all the payment methods is Unsuccessfull FAILED* " );	
			}
		}
		
        //Function Summary   : Method to verifyToAssignSamePaymentMethodForMoreThanOneBiller
		//Parameter Summary  : CompanyName
		public void verifyToAssignSamePaymentMethodForMoreThanOneBiller(Map<Object, Object> testdatamap, Log Log) throws Exception {
			searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
			clickOnActivateLink();
			EnterBilleDetails(testdatamap);
			SaveBillerDetails();
			searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
			Thread.sleep(2000);
			takeScreenShot();
			clickOnActivateLink();
			verifyElementIsPresent(EdaatOR.Admin_SystemMgm_ApprovalBtn);
			clickOnApproval();
			Thread.sleep(2000);
			searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
			Thread.sleep(2000);
			verifyElementIsNotPresent(EdaatOR.Admin_SystemMgm_RecordUnclickable, "Slid Bar is activated");
			if(CheckElementExists(EdaatOR.Admin_SystemMgm_RecordApproved)) 
			{
			test.log(Status.PASS,"#FUNC-Verify to add the same payment method for more than one biller is successfull" + driver.getTitle() +" * Verify to add the same payment method for more than one biller is successfull * PASSED" );
        	Log.ReportEvent("PASS", "Verify to add the same payment method for more than one biller is successfull");
			}
			else
			{
			test.log(Status.FAIL,"#FUNC-Verify to add the same payment method for more than one biller is Unsuccessfull" + driver.getTitle() +" * Verify to add the same payment method for more than one biller is Unsuccessfull FAILED* " );	
			}
		}
		
		//Function Summary   : Method to verify Add Minimum Invoice Amount Check box. 	
		public void verifyAddMinimumInvoiceAmountCheckbox(Log Log){
			try{
				clickOnActivateLink();
				Thread.sleep(1000);	
				WebElement element=driver.findElement(By.xpath(EdaatOR.Admin_BillerUnderActivationCorporateName));
				scrollToElement(driver, element);	
				this.takeScreenShot();
				verifyElementIsPresent(EdaatOR.Admin_SystemMgm_AddMinimumInvoiceAmountCheckbox);
				Thread.sleep(1000);
				takeScreenShot();
				Log.ReportEvent("PASS", "Add Minimum Invoice Amount Check box is present ");
				test.log(Status.PASS,"#FUNC-Verify Add minimum invoice amount checkbox" + driver.getTitle() +" * Verify Add minimum invoice amount checkbox PASS * " );
				takeScreenShot();		

			}catch(Exception e){
				test.log(Status.FAIL,"#FUNC-Verify Add minimum invoice amount checkbox" + driver.getTitle() +" * Verify Add minimum invoice amount checkbox FAIL * " );
				this.takeScreenShot();
			}
		}
		//Function Summary   : Method to verifyTheNewCheckboxViewedAfterCheckTheSubBillerCheckBox
		//Parameter Summary  : CompanyName,BenificaryName,BillerCode,Duretion,BenificaryCategory
		public void verifyTheNewCheckboxViewedAfterCheckTheSubBillerCheckBox(Map<Object, Object> testdatamap,Log Log) throws Exception {
			
			try {	
				searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
				if(CheckElementExists(EdaatOR.Admin_SystemMgm_RecordNotFound)==true) {
					AdminSystemMngBillerMgmtVerifyNewCheckboxViewedAfterAdminCheckSubbillerCheckbox.record=false;
				}
				else {
				clickOnActivateLink();
				enterTempBenificaryName(testdatamap.get("BenificaryName").toString());
				enterTempBillerCode(testdatamap.get("BillerCode").toString());
				this.takeScreenShot();
				enterDuration(testdatamap.get("Duretion").toString());
				enterOnBillerActiName(testdatamap);
				this.takeScreenShot();
				selectCategoryID(testdatamap.get("BenificaryCategory").toString());
				WebClickUsingJS(EdaatOR.Admin_SystemMng_notApprovedBiller_SubBillerCheckBox);
				Thread.sleep(2000);
				if (CheckElementExists(EdaatOR.Admin_SystemMng_notApprovedBiller_SubBillerCheckBox_Label)) {
					Thread.sleep(2000);
					verifyElementIsPresent(EdaatOR.Admin_SystemMgm_TransferRemarkCheckbox_Label);	
					Thread.sleep(2000);
					this.takeScreenShot();
					test.log(Status.PASS,"#FUNC-Verify that a new check box viewed after admin check the sub biller check box Functionality is successfull" + driver.getTitle() +" * Verify that a new check box viewed after admin check the sub biller check box Functionality is successfull PASS * " );
			    	Log.ReportEvent("PASS", "Verify that a new check box viewed after admin check the sub biller check box Functionality is successfull ");
				} else {
					test.log(Status.FAIL,"#FUNC-Verify that a new check box viewed after admin check the sub biller check box Functionality is Unsuccessfull" + driver.getTitle() +" * Verify that a new check box viewed after admin check the sub biller check box Functionality is Unsuccessfull FAIL * " );
				}
				AdminSystemMngBillerMgmtVerifyNewCheckboxViewedAfterAdminCheckSubbillerCheckbox.record=true;
				}

			} catch (Exception e) {
				e.printStackTrace();
				this.takeScreenShot();
				test.log(Status.FAIL,"#FUNC-Verify that a new check box viewed after admin check the sub biller check box Functionality is Unsuccessfull" + driver.getTitle() +" * Verify that a new check box viewed after admin check the sub biller check box Functionality is Unsuccessfull FAIL * " );
			}	
		}
			//Function Summary   : Method to verify Available Payment Methods Is Displayed 	
		public void verifyAvailablePaymentMethodsIsDisplayed(Log Log){
			try{
				clickOnActivateLink();
				Thread.sleep(500);
				WebElement element=driver.findElement(By.xpath(EdaatOR.Admin_BillerMang_AvailablePaymentMethods));
				scrollToElement(driver, element);	
				verifyElementIsPresent(EdaatOR.Admin_BillerMang_AvailablePaymentMethods);
				Thread.sleep(500);
				verifyElementIsPresent(EdaatOR.Admin_BillerMang_AvailPayMeth_PaidOutsideEDAAT);
				Thread.sleep(500);
				verifyElementIsPresent(EdaatOR.Admin_BillerMang_AvailPayMeth_Sadad);
				Thread.sleep(500);
				verifyElementIsPresent(EdaatOR.Admin_BillerMang_AvailPayMeth_Mada);
				Thread.sleep(500);
				verifyElementIsPresent(EdaatOR.Admin_BillerMang_AvailPayMeth_Visa);
				Thread.sleep(500);
				verifyElementIsPresent(EdaatOR.Admin_BillerMang_AvailPayMeth_MasterCard);
				Thread.sleep(500);
				verifyElementIsPresent(EdaatOR.Admin_BillerMang_AvailPayMeth_ApplePay);
				Thread.sleep(500);
				this.takeScreenShot();
				Log.ReportEvent("PASS", "verified Available Payment Methods ");
				test.log(Status.PASS,"#FUNC-Verify Available Payment Methods" + driver.getTitle() +" * Verify Available Payment Methods PASS * " );
				takeScreenShot();		

			}catch(Exception e){
				test.log(Status.FAIL,"#FUNC-Verify Available Payment Methods" + driver.getTitle() +" * Verify Available Payment Methods FAIL * " );
				this.takeScreenShot();
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
					}
						catch (Exception e) {
							e.printStackTrace();
							test.log(Status.FAIL,"#FUNC-Verify View Payment Method Details Incorrect" + driver.getTitle()+ " * Verify View Payment Method Details Incorrect FAIL * " );
							this.takeScreenShot();
						}
					
				}
		
		//Function Summary   : Method to verifyTheNewCheckboxAddMinimumInvoiceAmountIsNotMandatory
		//Parameter Summary  : CompanyName
		public void verifyTheNewCheckboxAddMinimumInvoiceAmountIsNotMandatory(Map<Object, Object> testdatamap,Log Log) throws Exception {
			try {	
				searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
				clickOnActivateLink();
				EnterBilleDetails(testdatamap);
				WebElement checkbox = driver.findElement(By.xpath(EdaatOR.Admin_SystemMgm_NotApproval_AddMinimum_Invoice_Checkbox));
				if(!checkbox.isSelected())
				{
					SaveBillerDetails();
					searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
					Thread.sleep(2000);
					takeScreenShot();
					clickOnActivateLink();
					verifyElementIsPresent(EdaatOR.Admin_SystemMgm_ApprovalBtn);
					clickOnApproval();
					Thread.sleep(2000);
					searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
					Thread.sleep(2000);
					verifyElementIsNotPresent(EdaatOR.Admin_SystemMgm_RecordUnclickable, "Slid Bar is activated");
					test.log(Status.PASS,"#FUNC-Verify that a new check box add minimum invoice amount is not mandatory  is successfull" + driver.getTitle() +" * Verify that a new check box add minimum invoice amount is not mandatory  is successfull* PASSED" );
		        	Log.ReportEvent("PASS", "Verify that a new check box add minimum invoice amount is not mandatory  is successfull");			
				}
				else {
					test.log(Status.FAIL,"#FUNC-Verify that a new check box add minimum invoice amount is not mandatory is Unsuccessfull" + driver.getTitle() +" * Verify that a new check box add minimum invoice amount is not mandatory  is Unsuccessfull FAILED* " );	
				}

			} catch (Exception e) {
				e.printStackTrace();
				this.takeScreenShot();
				test.log(Status.FAIL,"#FUNC-Verify that a new check box add minimum invoice amount is not mandatory is Unsuccessfull" + driver.getTitle() +" * Verify that a new check box add minimum invoice amount is not mandatory  is Unsuccessfull FAILED* " );	
			}	
	}
	
		//Function Summary   : Method to VerifyAdminAbleToAssignNewPaymentType
		//Parameter Summary  : CompanyName,BenificaryName,BillerCode,Duretion,ArabicName,EnglishName,BenificaryCategory,PaymentMethod,CompanyName,PaymentMethod
		public void VerifyAdminAbleToAssignNewPaymentType(Map<Object, Object> testdatamap,Log Log)
				{
					try {
						searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
						clickOnActivateLink();
						enterTempBenificaryName(testdatamap.get("BenificaryName").toString());
						enterTempBillerCode(testdatamap.get("BillerCode").toString());
						enterDuration(testdatamap.get("Duretion").toString());
						enterOnBillerActiName(testdatamap);
						WebEdit(EdaatOR.Admin_SystemMgm_BillerAliasName,testdatamap.get("ArabicName").toString() );
						WebEdit(EdaatOR.Admin_SystemMgm_BillerAliasEnName, testdatamap.get("EnglishName").toString());
						selectCategoryID(testdatamap.get("BenificaryCategory").toString());
						Thread.sleep(1000);
						SelectThePaymentMethod(testdatamap.get("PaymentMethod").toString());
						clickOnSave();
						clickOnIsbillerYesbtn();
						AdminSystemMangement AdminSystemMangement=new AdminSystemMangement(driver, test);
						AdminSystemMangement.navigateNotApprovedBillerManagement(Log);
						searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
						clickOnActivateLink();
						scrollDowntillend(driver);
						VerifySelectedPaymentType(testdatamap.get("PaymentMethod").toString(),Log);
						Log.ReportEvent("PASS", "Verify Selected Payment Type");
						test.log(Status.PASS,"#FUNC-Verify Selected Payment Type" + driver.getTitle()+ " * Verify Selected Payment Type PASS * " );
					}
					catch (Exception e) {
						e.printStackTrace();
						test.log(Status.FAIL,"#FUNC-Verify View Payment Method Details Incorrect" + driver.getTitle()+ " * Verify View Payment Method Details Incorrect FAIL * " );
						this.takeScreenShot();
					}
				
				}
				
				//Function Summary   : Method to verify Available Payment Methods Is Displayed 	
		public void verifyDefaultPaymentIsSelectedAndDisabled(Log Log){
			try{
				clickOnActivateLink();				
				Thread.sleep(500);
				WebElement element=driver.findElement(By.xpath(EdaatOR.Admin_BillerMang_AvailablePaymentMethods));
				scrollToElement(driver, element);
				boolean value=driver.findElement(By.xpath(EdaatOR.Admin_BillerMang_AvailPayMeth_PaidOutsideEDAAT)).isSelected();
				if(value=true)
				{
					test.log(Status.PASS,"#FUNC-Verifed default payment is selected");
	
				}
				Thread.sleep(1000);
				VerifyObjectDisabled(EdaatOR.Admin_BillerMang_AvailPayMeth_Disabled_PaidOutsideEDAAT);
				Thread.sleep(500);
				this.takeScreenShot();
				Log.ReportEvent("PASS", "Verifed default payment is selected and disabled");
				test.log(Status.PASS,"#FUNC-Verify default payment is selected and disabled" + driver.getTitle() +" * default payment is selected and disabled PASS * " );
				takeScreenShot();		

			}catch(Exception e){
				test.log(Status.FAIL,"#FUNC-Verify default payment is selected and disabled" + driver.getTitle() +" *default payment is selected and disabled FAIL * " );
				this.takeScreenShot();
			}
		}
		//Function Summary   : Method to verify subBiller Checkbox is Unchecked 
				//Parameter Summary : BenificaryName,BillerCode,Duration,BenificaryCategory,checkboxStatus
				public void verifySubBillerCheckBox(Map<Object, Object> testdatamap,Log Log){
					try{
						searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
						clickOnActivateLink();
						enterTempBenificaryName(testdatamap.get("BenificaryName").toString());
						enterTempBillerCode(testdatamap.get("BillerCode").toString());
						enterDuration(testdatamap.get("Duretion").toString());
						enterOnBillerActiName(testdatamap);
						selectCategoryID(testdatamap.get("BenificaryCategory").toString());
						scrollDowntillend(driver);
						Thread.sleep(1000);

						WebElement subBillerCheckbox = driver.findElement(By.xpath(EdaatOR.Admin_SystemMgm_IsBiller));
						boolean actualvalue = subBillerCheckbox.isSelected();
						String value = testdatamap.get("checkboxStatus").toString();
						boolean  checkBoxStatus= Boolean.parseBoolean(value);
						
						if(actualvalue==checkBoxStatus )
						{
							 System.out.println("Checkbox is " + (actualvalue ? "checked" : "unchecked") + ".");
						
						}
						else{
							
							throw new IllegalStateException("Checkbox is not in the expected state.");
				        }
						
						test.log(Status.PASS,"#FUNC-verifySubBillerCheckBox" + driver.getTitle() +" * SubBiller CheckBox is unchecked  PASS * " );
						takeScreenShot();		

					}catch(Exception e){
						test.log(Status.FAIL,"#FUNC-verifySubBillerCheckBox" + driver.getTitle() +" * SubBiller CheckBox is Unchecked FAIL * " );
						this.takeScreenShot();
					}
				}
		//Function Summary   : Method to verify Add Minimum Invoice Amount CheckBox is Checked/Unchecked
				//Parameter Summary  : N/A
				public void verifyAddMinimumInvoiceAmountCheckBox (Map<Object, Object> testdatamap,Log Log){
				try{
				    searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
					clickOnActivateLink();
					scrollDowntillend(driver);
					WebClickUsingJS(EdaatOR.Admin_Systemmgmt_MinimumInvoiceAmount);

					WebElement minInvoiceCheckbox = driver.findElement(By.xpath(EdaatOR.Admin_Systemmgmt_MinimumInvoiceAmount));
							
					 Assert.assertTrue(minInvoiceCheckbox.isSelected(), "Checkbox is Unchecked.");

					 WebClickUsingJS(EdaatOR.Admin_Systemmgmt_MinimumInvoiceAmount);
					 
					 Assert.assertFalse(minInvoiceCheckbox.isSelected(), "Checkbox is checked.");
					 
					test.log(Status.PASS,"#FUNC-verifyAddMinimumInvoiceAmountCheckBox" + driver.getTitle() +" * verify Add Minimum Invoice Amount CheckBox checked/Unchecked PASS * " );
					takeScreenShot();		

					}catch(Exception e){
						test.log(Status.FAIL,"#FUNC-verifyAddMinimumInvoiceAmountCheckBox" + driver.getTitle() +" * verify Add Minimum Invoice Amount CheckBox checked/Unchecked FAIL * " );
						this.takeScreenShot();
					}
				}
}
