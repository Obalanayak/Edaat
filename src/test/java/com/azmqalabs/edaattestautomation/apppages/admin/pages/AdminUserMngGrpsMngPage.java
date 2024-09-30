/**
*
* Test Script Name                   : N/A
* Objective                          : Verify Group Management Functionality.
* Version                            : 1.0
* Author                             : Kathirvelu M
* Created Date                       : 01/06/2023
* Last Updated on                    : N/A
* Updated By                         : Dhruva Kumar S
* Pre-Conditions                     : N/A
* Epic Details                       : N/A
* User Story Details                 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;



public class AdminUserMngGrpsMngPage extends BasePage
{

	public AdminUserMngGrpsMngPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Admin_GroupMgm_Header)
	public WebElement Header;


	public boolean Exists(){
		return super.Exists(Header); 
	}


	//Function Summary   : Method to Navigate GroupManagement
	//Parameter Summary : N/A
	public void naviagteGroupManagement(Log Log) {
		WebClick(EdaatOR.Admin_UserManagement);
		WebClick(EdaatOR.Admin_GropManagment);
		waitForPageToLoad();
    	Log.ReportEvent("PASS", " Navigate to Groups Management Page");

	}

	//Function Summary   : Method to Enter Group Name in "Group Name" Text field
	//Parameter Summary : pname

	public void EnterSearchGroupName(String pname) {
		WebEdit(EdaatOR.Admin_GroupMgm_SearchGrpName, pname);
	}

	//Function Summary   : Method to Enter Group Code in "Group Code" Text field
	//Parameter Summary  : pname
	public void EnterSearchGroupCode(String lstname) {
		WebEdit(EdaatOR.Admin_GroupMgm_SearchCode, lstname);
	}

	//Function Summary   : Method to ClickOnGrouSearchBtn
	//Parameter Summary  : N/A
	public void ClickOnGrouSearchBtn() {
		WebClick(EdaatOR.Admin_GroupMgm_SearchButton);
	}
	//Function Summary   : Method to Click on Add Button
	//Parameter Summary  :N/A
	public void ClickOnAddBtn() {
		WebClick(EdaatOR.Admin_GroupMgm_AddGrpBtn);
	}

	//Function Summary   : Method to Enter Group Name In Arabic
	//Parameter Summary  : pname
	public void EnterAddGroupArabic(String pname) {
		WebEdit(EdaatOR.Admin_AddGroupMgm_ArabicName, pname);
	}
	//Function Summary   : Method to Enter Group Name In English
	//Parameter Summary  : lstname
	public void EnterAddGroupEng(String lstname) {
		WebEdit(EdaatOR.Admin_AddGroupMgm_Name, lstname);
	}

	//Function Summary   : Method to Enter Group Description
	//Parameter Summary : lstname
	public void EnterAddGroupDescription(String lstname) {
		WebEdit(EdaatOR.Admin_AddGroupMgm_Description, lstname);
	}
	//Function Summary   : Method to ClickOnTwoFactorAuthentication
	//Parameter Summary  : N/A
	public void ClickOnTwoFactorAuthentication() {
    	WebClickUsingJS(EdaatOR.Admin_SearchGroupMgm_SubjectTwoAuthenticateCheck);	
    }
	
	//Function Summary   : Method to ClickOnSendSmsCheckBox
	//Parameter Summary  : N/A
	public void ClickOnSendSmsCheckBox() {
    	WebClickUsingJS(EdaatOR.Admin_SearchGroupMgm_SendSMSValue);	
    }
	
	//Function Summary   : Method to ClickOnSendEmailCheckBox
	//Parameter Summary  : N/A
	public void ClickOnSendEmailCheckBox() {
    	WebClickUsingJS(EdaatOR.Admin_SearchGroupMgm_SendEmailValue);	
    }
	
    //Function Summary  : Method to EnterHour
	//Parameter Summary : hour
	public void EnterHour(String hour) {
		WebEdit(EdaatOR.Admin_AddGroupMgm_Hour, hour);
	}
	//Function Summary   : Method to Enter Group Code
	//Parameter Summary  : lstname
	public void EnterAddGroupCode(String lstname) {
		WebEdit(EdaatOR.Admin_AddGroupMgm_GroupCode, lstname);
	}

	//Function Summary   : Method to Click on "Add" Button
	//Parameter Summary  : N/A
	public void ClickOnGroupAddBtn() {
		WebClick(EdaatOR.Admin_AddGroupMgm_AddBtn);
	}

	//Function Summary   : Method to Add New Group
	//Parameter Summary : ArabicName,GroupCode,EngName
	public void addGroup(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			ClickOnAddBtn();
			waitForPageToLoad();
			Thread.sleep(1000);
			EnterAddGroupArabic(testdatamap.get("ArabicName").toString());
			EnterAddGroupEng(testdatamap.get("EngName").toString());
			EnterAddGroupDescription(testdatamap.get("Description").toString());
			EnterAddGroupCode(testdatamap.get("GroupCode").toString());
			Thread.sleep(2000);
	        this.takeScreenShot();
			ClickOnGroupAddBtn();
            Thread.sleep(2000);
            this.takeScreenShot();
            Thread.sleep(1000);
			test.log(Status.PASS,"#FUNC-addGrop is successful" + driver.getTitle() +" * User Group Management PASS * " );	
        	Log.ReportEvent("PASS", " Verify to Add new Group ");

		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Add Group is Failed" + driver.getTitle() +" * User Group Management  FAIL * " );
			e.printStackTrace();
			}	   
	}
	
	//Function Summary   : Method to verifyOtpRuleIsOnlyValidForAdmin
	//Parameter Summary  : N/A
	public void verifyOtpRuleIsOnlyValidForAdmin(Log Log) {
		try {
			ClickOnAddBtn();
			Thread.sleep(2000);
			verifyElementIsPresent(EdaatOR.Admin_AddGroupMgm_TwoFactorAuthentication);
			ClickOnTwoFactorAuthentication();
			EnterHour(WARNINGFontColorSuffix);
			verifyElementIsPresent(EdaatOR.Admin_AddGroupMgm_Hour);
			verifyElementIsPresent(EdaatOR.Admin_SearchGroupMgm_SendSMSValue);
			verifyElementIsPresent(EdaatOR.Admin_SearchGroupMgm_SendEmailValue);
			this.takeScreenShot();
			Log.ReportEvent("PASS", "Verify Otp Rule Is Only Valid For Admin Functionality is successfull");
			test.log(Status.PASS,"#FUNC-Verify Otp Rule Is Only Valid For Admin Functionality is successfull" + driver.getTitle() +" * Verify Otp Rule Is Only Valid For Admin Functionality is successfull PASS * " );	
		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL,"#FUNC-Verify Otp Rule Is Only Valid For Admin Functionality is Failed" + driver.getTitle() +" * Verify Otp Rule Is Only Valid For Admin Functionality FAIL * ");
		}
	}
	
	//Function Summary   : Method to View Users Under The Group
	//Parameter Summary  : UserPopupName
	public void ViewUsers(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			WebClick(EdaatOR.Admin_GroupMgm_ViewUser);
			Thread.sleep(2000);
			this.takeScreenShot();
			Thread.sleep(2000);
			VerifyValue1(getText(EdaatOR.Admin_GroupMgm_Userspopup), testdatamap.get("UserPopupName").toString());
			Thread.sleep(2000);
			WebClick(EdaatOR.Userlist_close);
			test.log(Status.PASS,"#FUNC-addGrop is successful" + driver.getTitle() +" * User Group Management PASS * " );	
        	Log.ReportEvent("PASS", " Verify View users under group");

		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Add Group is Failed" + driver.getTitle() +" * User Group Management  FAIL * " );
			this.takeScreenShot();
		}
          
	}
	
	
	//Function Summary   : Method to Search Group by Group Name
	//Parameter Summary : searchName

	public void searchGroupByName(String searchName) throws Exception {
		if(!searchName.equalsIgnoreCase("")) {
			EnterSearchGroupName(searchName);
		}
	}
	
	//Function Summary   :Method to Search Group by Group Code
	//Parameter Summary : GroupCode
	public void searchGroupByCode(String GroupCode) throws Exception {
		if(!GroupCode.equalsIgnoreCase("")) {
			EnterSearchGroupCode(GroupCode);
		}
	}
	//Function Summary   :Method to Search Group 
	//Parameter Summary : ArabicName,GroupCode,Description,EngName
	public void searchGroup(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
	        searchGroupByName(testdatamap.get("ArabicName").toString());
			searchGroupByCode(testdatamap.get("GroupCode").toString());
			ClickOnGrouSearchBtn();
	if(CheckElementExists(EdaatOR.Admin_SearchGroupMgm_Nodata)==true)
			{
				ClickOnAddBtn();
				waitForPageToLoad();
				Thread.sleep(1000);
				EnterAddGroupArabic(testdatamap.get("ArabicName").toString());
				EnterAddGroupEng(testdatamap.get("EngName").toString());
				EnterAddGroupDescription(testdatamap.get("Description").toString());
				EnterAddGroupCode(testdatamap.get("GroupCode").toString());
				Thread.sleep(1000);
				this.takeScreenShot();
				Thread.sleep(1000);
				ClickOnGroupAddBtn();
				Thread.sleep(1000);
				this.takeScreenShot();
				searchGroupByName(testdatamap.get("ArabicName").toString());
				searchGroupByCode(testdatamap.get("GroupCode").toString());
				ClickOnGrouSearchBtn();
	}
			Thread.sleep(1000);
			this.takeScreenShot();
	//		VerifyValue1(getText(EdaatOR.Biller_SearchGroupMgm_GrpName), testdatamap.get("ArabicName").toString());
			VerifyValue1(getText(EdaatOR.Admin_SearchGroupMgm_Code), testdatamap.get("GroupCode").toString());
			test.log(Status.PASS,"#FUNC-Search Group is successful" + driver.getTitle() +" * User Group Management PASS * " );	
        	Log.ReportEvent("PASS", " Verify to Search Group is successfull ");

		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Search Group is Failed" + driver.getTitle() +" * User Group Management  FAIL * " );
			this.takeScreenShot();
		}

	}
	//Function Summary  : Method to Delete Group
	//Parameter Summary : GroupCode
	public void deleteGroup(Map<Object, Object> testdatamap) throws Exception {
		try {
			searchGroupByCode(testdatamap.get("GroupCode").toString());
			Thread.sleep(1500);
			ClickOnGrouSearchBtn();
			WebClick(EdaatOR.Admin_SearchGroupMgm_DeleteBtn);
			Thread.sleep(500);
			WebClick(EdaatOR.Admin_SearchGroupMgm_YesDeleteBtn);
			Thread.sleep(1000);
			searchGroupByCode(testdatamap.get("GroupCode").toString());
			ClickOnGrouSearchBtn();
			verifyElementIsPresent(EdaatOR.Admin_SearchGroupMgm_Nodata, "Record got deleted");
			test.log(Status.PASS,"#FUNC-Delete Group is successful" + driver.getTitle() +" * User Group Management PASS * " );	
		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Delete Group is Failed" + driver.getTitle() +" * User Group Management  FAIL * " );
			this.takeScreenShot();
		}

	}
	
	//Function Summary   : Method to Update and View Group Permission
	//Parameter Summary  : GroupPermission,GroupCode
	public void updateAndViewGroupPermission(Map<Object, Object> testdatamap) throws Exception {
		try {
			searchGroupByCode(testdatamap.get("GroupCode").toString());
			ClickOnGrouSearchBtn();
			WebClick(EdaatOR.Admin_SearchGroupMgm_EditIcon);
			Thread.sleep(1000);
			VerifyValue1(getText(EdaatOR.Admin_SearchGroupMgm_PermissuionPOp), testdatamap.get("GroupPermission").toString());
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_EditGroup_Receivable);
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_EditGroup_UpdateBtn);
			Thread.sleep(1000);
			searchGroupByCode(testdatamap.get("GroupCode").toString());
			ClickOnGrouSearchBtn();
			WebClick(EdaatOR.Admin_SearchGroupMgm_EditIcon);
			Thread.sleep(2000);
			if(IsSelected(EdaatOR.Admin_EditGroup_Receivable)==true) {
				test.log(Status.PASS,"Receivable Check box is permission selected " );
			}
			else {
				test.log(Status.FAIL,"Receivable Check box is permission not selected " );
			}
			test.log(Status.PASS,"#FUNC-update Group is successful" + driver.getTitle() +" * User Group Management PASS * " );	
		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-update Group is Failed" + driver.getTitle() +" * User Group Management  FAIL * " );
			this.takeScreenShot();
		}

	}


	public void verifyViewGroupUnderUserList(Map<Object, Object> testdatamap) throws Exception {
		boolean listGr=false;
		try {
			List<WebElement> glist=driver.findElements(By.xpath(EdaatOR.Biller_Userlist_groups));
			for(int i=0;i<glist.size();i++) {
				int g=i+1;
				String grList=glist.get(i).getText();
				if(grList.contains(testdatamap.get("ArabicName").toString())) {
					test.log(Status.PASS,"Group Name is available in the userlist " );
					listGr=true;
					break;
				}
			}
			if(listGr==false) {
				test.log(Status.FAIL,"Group Name is not available in the userlist " );
			}
		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-View Group is Failed" + driver.getTitle() +" * User Group Management  FAIL * " );
			this.takeScreenShot();
		}

	}
	//Function Summary   : Method to ClickOnCloseBtn
	//Parameter Summary  : EngName
	public void ClickOnGroupName(String EngName) {
		
		WebClick("//a[text()='"+EngName+"']");	
	}
	//Function Summary   : Method to ClickOnCloseBtn
	//Parameter Summary  : N/A
	public void ClickOnCloseBtn() {
		
		WebClick(EdaatOR.Admin_Usermng_viewClose);
	}
	//Function Summary   : Method to VerifyGroupNameClick
	//Parameter Summary  : N/A
	public void VerifyGroupNameClick(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try
		{

		searchGroupByName(testdatamap.get("ArabicName").toString());
		searchGroupByCode(testdatamap.get("GroupCode").toString());
		ClickOnGrouSearchBtn();
		Thread.sleep(2000);
		this.takeScreenShot();
		Thread.sleep(1000);
		if(CheckElementExists(EdaatOR.Admin_Usermng_nodata)==true)
		{
			addGroup(testdatamap,Log);
			waitForPageToLoad();
			searchGroupByName(testdatamap.get("ArabicName").toString());
			searchGroupByCode(testdatamap.get("GroupCode").toString());
			ClickOnGrouSearchBtn();
			Thread.sleep(2000);
			this.takeScreenShot();
		}
		ClickOnGroupName(testdatamap.get("EngName").toString());
		Thread.sleep(5000);
		this.takeScreenShot();
		verifyElementIsPresent(EdaatOR.Admin_Usermng_viewgrp);
		Thread.sleep(2000);
		ClickOnCloseBtn();
		this.takeScreenShot();
		test.log(Status.PASS,"#FUNC-Verify that the Group name clickable is successful" + driver.getTitle() +" * User Group Managementn PASS * ");
    	Log.ReportEvent("PASS", " Verify that the Group name is clickable ");

		}
		catch (Exception e) {
		test.log(Status.FAIL,"#FUNC-Verify that the Group name is clickable Failed" + driver.getTitle() +" * User Group Management  FAIL * " );
			
		}
	}	
//Function Summary   : Method to Verify Delete Group Functionality.
//Parameter Summary  : ArabicName and GroupCode.
	public void VerifyDeleteGroupFunctionality(Map<Object, Object> testdatamap,Log Log)
	{
		try {
		naviagteGroupManagement(Log);
		addGroup(testdatamap,Log);
		waitForPageToLoad();
		Thread.sleep(1000);
		this.takeScreenShot();
		searchGroupByName(testdatamap.get("ArabicName").toString());
		searchGroupByCode(testdatamap.get("GroupCode").toString());
		ClickOnGrouSearchBtn();
		Thread.sleep(1000);
		this.takeScreenShot();
		WebClick(EdaatOR.Admin_SearchGroupMgm_DeleteBtn);
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_SearchGroupMgm_YesDeleteBtn);
		Thread.sleep(1000);
		this.takeScreenShot();
		WebClick(EdaatOR.Admin_GropManagment);
		Thread.sleep(1000);
		this.takeScreenShot();
		searchGroupByName(testdatamap.get("ArabicName").toString());
		Thread.sleep(1000);
		searchGroupByCode(testdatamap.get("GroupCode").toString());
		Thread.sleep(1000);
		ClickOnGrouSearchBtn();
		Thread.sleep(1000);
		this.takeScreenShot();
		if(CheckElementExists(EdaatOR.Admin_Usermng_Verifygroup))
		{
		test.log(Status.PASS,"#FUNC-Verify Delete Group Functionality" + driver.getTitle() +" * Verify Delete Group Functionality is Pass * " );
		Log.ReportEvent("PASS", " Verify delete group functionality is Suceessful");
		Thread.sleep(1000);
		this.takeScreenShot();
		}	
		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Verify Delete Group Functionality" + driver.getTitle() +" * Verify Delete Group Functionality is FAIL * " );
			this.takeScreenShot();
		}
		
	}
	//Function Summary   : Method to Edit Group Permission
	//Parameter Summary  : ArabicName,GroupCode,ViewDistributionPermission,ViewReceivablesPermission
	public void VerifyGroupPermission(Map<Object, Object> testdatamap,Log Log) {
		try {
		searchGroupByName(testdatamap.get("ArabicName").toString());
		searchGroupByCode(testdatamap.get("GroupCode").toString());
		ClickOnGrouSearchBtn();
		Thread.sleep(2000);
		this.takeScreenShot();
		Thread.sleep(1000);
		if(CheckElementExists(EdaatOR.Admin_Usermng_nodata)==true)
		{
			addGroup(testdatamap,Log);
			waitForPageToLoad();
			searchGroupByName(testdatamap.get("ArabicName").toString());
			searchGroupByCode(testdatamap.get("GroupCode").toString());
			ClickOnGrouSearchBtn();
			Thread.sleep(2000);
			this.takeScreenShot();
		}
		WebClick(EdaatOR.Admin_GrpMgm_GrpPermissionbtn);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_GrpMgm_DistributionPermission);
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Admin_GrpMgm_ReceivablesPermission);
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_GrpMgm_SavePermission);
		this.takeScreenShot();
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_GrpMgm_ViewPermission);
		Thread.sleep(1000);
		VerifyValue1(WebGetText(EdaatOR.Admin_GrpMgm_ViewDistributionPermission), testdatamap.get("ViewDistributionPermission").toString());
		VerifyValue1(WebGetText(EdaatOR.Admin_GrpMgm_ViewReceivablesPermission), testdatamap.get("ViewReceivablesPermission").toString());
		Thread.sleep(2000);
		this.takeScreenShot();
		test.log(Status.PASS,"#FUNC-Verify to Edit group permission" + driver.getTitle() +" * Edit group permission is Pass * ");
    	Log.ReportEvent("PASS", " Verify to edit group permission Functionality is successfull");

		}

		catch (Exception e) {
		test.log(Status.FAIL,"#FUNC-Verify to Edit group permission" + driver.getTitle() +" * Edit group permission is Fail * " );
			
		}
	}
	//Function Summary   : Method to view eye Icon button is Clickable.
	//Parameter Summary  : ArabicName,GroupCode.
	public void Viewpermision(Map<Object, Object> testdatamap,Log Log) {
		// TODO Auto-generated method stub
		try {
			addGroup(testdatamap,Log);
			Thread.sleep(2000);
	        searchGroupByName(testdatamap.get("ArabicName").toString());
			searchGroupByCode(testdatamap.get("GroupCode").toString());
			ClickOnGrouSearchBtn();
			Thread.sleep(2000);
			this.takeScreenShot();
			WebClick(EdaatOR.Admin_Usermng_eyebtn);
			Thread.sleep(3000);
			this.takeScreenShot();
			VerifyValue1(getText(EdaatOR.Admin_Usermng_viewpermision), testdatamap.get("ViewPermision").toString());
			Thread.sleep(3000);
			this.takeScreenShot();
			test.log(Status.PASS,"#FUNC-View Group permision is successful" + driver.getTitle() +" * User Group Management PASS * " );	
        	Log.ReportEvent("PASS", " Verify to view group permission functionality is successfull ");

		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-View Group permision is Failed" + driver.getTitle() +" * User Group Management  FAIL * " );
			this.takeScreenShot();
		}
		
	}
	//Function Summary   : Method to Verify AddGroupErrorMsg
	//Parameter Summary  : Expected
	public void AddGroupErrorMsg(Map<Object, Object> testdatamap,Log Log) {
		
		try
		{
			addGroup(testdatamap,Log);
			if(ExistsCheck(EdaatOR.Admin_GrpMgm_GrpCodeError))
			{
				VerifyValue1(getText(EdaatOR.Admin_GrpMgm_GrpCodeError), testdatamap.get("Expected").toString());
				test.log(Status.PASS, "#FUNC-GroupMng EnterGroupCode ErrorMessage Exists" + driver.getTitle() + " * EnterGroupCode ErrorMessage Exists * ");
			}
			else if (ExistsCheck(EdaatOR.Admin_GrpMgm_GrpNameEngError)) {
				
				VerifyValue1(getText(EdaatOR.Admin_GrpMgm_GrpNameEngError), testdatamap.get("Expected").toString());
				test.log(Status.PASS, "#FUNC-GroupMng EnterEngGroupName ErrorMessage Exists" + driver.getTitle() + " * EnterEngGroupName ErrorMessage Exists * ");
			}
			else if (ExistsCheck(EdaatOR.Admin_GrpMgm_GrpNameArbError)) {
				
				VerifyValue1(getText(EdaatOR.Admin_GrpMgm_GrpNameArbError), testdatamap.get("Expected").toString());
				test.log(Status.PASS, "#FUNC-GroupMng EnterArbGroupName ErrorMessage Exists" + driver.getTitle() + " * EnterArbGroupName ErrorMessage Exists * ");
			}
			else if (ExistsCheck(EdaatOR.Admin_GrpMgm_GrpNameEngErrorMsg)) {
				
				VerifyValue1(getText(EdaatOR.Admin_GrpMgm_GrpNameEngErrorMsg), testdatamap.get("Expected").toString());
				test.log(Status.PASS, "#FUNC-GroupMng EngGroupName ErrorMessage Exists" + driver.getTitle() + " * EngGroupName ErrorMessage Exists * ");
			}
            else if (ExistsCheck(EdaatOR.Admin_GrpMgm_GrpNameArbErrorMsg)) {
				
				VerifyValue1(getText(EdaatOR.Admin_GrpMgm_GrpNameArbErrorMsg), testdatamap.get("Expected").toString());
				test.log(Status.PASS, "#FUNC-GroupMng ArbGroupName ErrorMessage Exists" + driver.getTitle() + " * ArbGroupName ErrorMessage Exists * ");
			}
            else if (ExistsCheck(EdaatOR.Admin_GrpMgm_GrpCodeErrorMsg)) {
				
				VerifyValue1(getText(EdaatOR.Admin_GrpMgm_GrpCodeErrorMsg), testdatamap.get("Expected").toString());
				test.log(Status.PASS, "#FUNC-GroupMng GroupCode ErrorMessage Exists" + driver.getTitle() + " * GroupCode ErrorMessage Exists * ");
			}
            else {
            	test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
            }
		}
		catch (Exception e) {
			test.log(Status.FAIL,"#FUNC-Group Management Add Group" + driver.getTitle() +" * Group Management Add Group FAIL * " );
			this.takeScreenShot();
		}
		
	}
	
		//Function Summary   : Method to addGroupTwoFactorAuthenticationEnabled
		//Parameter Summary  : ArabicName,GroupCode,hour,EngName,Description
		public void addGroupTwoFactorAuthenticationEnabled(Map<Object, Object> testdatamap,Log Log) throws Exception {
			try {
				ClickOnAddBtn();
				waitForPageToLoad();
				Thread.sleep(1000);
				EnterAddGroupArabic(testdatamap.get("ArabicName").toString());
				EnterAddGroupEng(testdatamap.get("EngName").toString());
				EnterAddGroupDescription(testdatamap.get("Description").toString());
				EnterAddGroupCode(testdatamap.get("GroupCode").toString());
				ClickOnTwoFactorAuthentication();
				EnterHour(testdatamap.get("hour").toString());
				ClickOnSendSmsCheckBox();
				ClickOnSendEmailCheckBox();
				Thread.sleep(2000);
		        this.takeScreenShot();
				ClickOnGroupAddBtn();
	            Thread.sleep(2000);
	            this.takeScreenShot();
	            Thread.sleep(1000);
				test.log(Status.PASS,"#FUNC-Add Group Two Factor Authentication Enabled is successful" + driver.getTitle() +" * Add Group Two Factor Authentication Enabled is successful PASS * " );	
	        	Log.ReportEvent("PASS", " Add Gropp Two Factor Authentication Enabled is successful ");

			}
			catch(Exception e){
				test.log(Status.FAIL,"#FUNC-Add Group Two Factor Authentication is Failed" + driver.getTitle() +" *Add Group Two Factor Authentication is Failed  FAIL * " );
				e.printStackTrace();
				}	   
		}
		
		//Function Summary   : Method to View Two Factor Authentication
	    //Parameter Summary  : N/A
			public void ViewTwoFactorAuthentication(Map<Object, Object> testdatamap,Log Log) throws Exception {
				try
				{
	 
				searchGroupByName(testdatamap.get("ArabicName").toString());
				searchGroupByCode(testdatamap.get("GroupCode").toString());
				ClickOnGrouSearchBtn();
				Thread.sleep(2000);
				this.takeScreenShot();
				Thread.sleep(1000);
				if(CheckElementExists(EdaatOR.Admin_Usermng_nodata)==true)
				{
					addGroup(testdatamap,Log);
					waitForPageToLoad();
					searchGroupByName(testdatamap.get("ArabicName").toString());
					searchGroupByCode(testdatamap.get("GroupCode").toString());
					ClickOnGrouSearchBtn();
					Thread.sleep(2000);
					this.takeScreenShot();
				}
				ClickOnGroupName(testdatamap.get("EngName").toString());
				Thread.sleep(3000);
				this.takeScreenShot();
				verifyElementIsPresent(EdaatOR.Admin_Usermng_Viewtwofactauth);			
				Thread.sleep(2000);
				ClickOnCloseBtn();
				this.takeScreenShot();
				ClickOnAddBtn();
				Thread.sleep(2000);
				verifyElementIsPresent(EdaatOR.Admin_Usermng_AddGroupViewtwofactauth);
				this.takeScreenShot();
				test.log(Status.PASS,"#FUNC-Verify that view two factor authentication is successful" + driver.getTitle() +" * User Group Management PASS * ");
		    	Log.ReportEvent("PASS", " Verify that View Two Factor Authentication ");
	 
				}
				catch (Exception e) {
				test.log(Status.FAIL,"#FUNC-Verify view two factor authentication Failed" + driver.getTitle() +" * User Group Management  FAIL * " );
					
				}
			}
			
		//Function Summary   : Method to Verify the type checkbox have two values SMS,Email or both of them
		//Parameter Summary  : N/A.
		public void VerifySubjectToTwoFactorAuthenticationCheckbox(Log Log)
		{
		    try {
		    	naviagteGroupManagement(Log);
		    	ClickOnAddBtn();
				Thread.sleep(1000);
		    	WebClickUsingJS(EdaatOR.Admin_SearchGroupMgm_SubjectTwoAuthenticateCheck);
				Thread.sleep(2000);
		    	verifyElementIsPresent(EdaatOR.Admin_SearchGroupMgm_SendSMSValue);
				Thread.sleep(1000);
		    	verifyElementIsPresent(EdaatOR.Admin_SearchGroupMgm_SendEmailValue);
		    	this.takeScreenShot();
				test.log(Status.PASS,"#FUNC-Verify the type checkbox have two values SMS,Email or both of them is successful" + driver.getTitle() +" *Verify the type checkbox have two values SMS,Email or both of them PASS * " );	
	        	Log.ReportEvent("PASS", "Verify the type checkbox have two values SMS,Email or both of them");
		       }
		    
		    catch (Exception e) {
				test.log(Status.FAIL,"#FUNC-Verify the type checkbox have two values SMS,Email or both of them" + driver.getTitle() +" * Verify the type checkbox have two values SMS,Email or both of them FAIL * " );
				this.takeScreenShot();
			}
		}
		
	//Function Summary   : Method to verifyEditGroupTwoFactorAuthentication
	//Parameter Summary  : ArabicName,GroupCode,EditHour
	public void verifyEditGroupTwoFactorAuthentication(Map<Object, Object> testdatamap, Log Log) {
		try {
		searchGroupByName(testdatamap.get("ArabicName").toString());
		searchGroupByCode(testdatamap.get("GroupCode").toString());
		ClickOnGrouSearchBtn();
		Thread.sleep(2000);
		this.takeScreenShot();
		Thread.sleep(1000);
		if(CheckElementExists(EdaatOR.Admin_Usermng_nodata)==true)
		{
			addGroupTwoFactorAuthenticationEnabled(testdatamap,Log);
			waitForPageToLoad();
			searchGroupByName(testdatamap.get("ArabicName").toString());
			searchGroupByCode(testdatamap.get("GroupCode").toString());
			ClickOnGrouSearchBtn();
			Thread.sleep(2000);
			this.takeScreenShot();
		}
		WebClickUsingJS(EdaatOR.Admin_GrpMgm_GrpEditbtn);
		Thread.sleep(2000);
		ClickOnSendSmsCheckBox();
		EnterHour(testdatamap.get("EditHour").toString());
		WebClick(EdaatOR.Admin_GrpMgm_SaveChangesbtn);
		this.takeScreenShot();
		Thread.sleep(1000);
		searchGroupByName(testdatamap.get("ArabicName").toString());
		searchGroupByCode(testdatamap.get("GroupCode").toString());
		ClickOnGrouSearchBtn();
		Thread.sleep(2000);
		this.takeScreenShot();
		WebClickUsingJS(EdaatOR.Admin_GrpMgm_GrpEditbtn);
		Thread.sleep(3000);
		this.takeScreenShot();
		VerifyValue1(WebGetTextAttribute(EdaatOR.Admin_AddGroupMgm_Hour),testdatamap.get("EditHour").toString());
		this.takeScreenShot();
		test.log(Status.PASS,"#FUNC-Verify to Edit group two factor authentication Functionality is successfull " + driver.getTitle() +" * Verify to Edit group two factor authentication Functionality is successfull Pass * ");
    	Log.ReportEvent("PASS", " Verify to Edit group two factor authentication Functionality is successfull");
		}
		catch (Exception e) {
		test.log(Status.FAIL,"#FUNC-Verify to Edit group two factor authentication Functionality Failed" + driver.getTitle() +" * Verify to Edit group two factor authentication Functionality Fail * " );
			
		}
		
	}
		//Function Summary   : Method to verify Two Factor Authentication Valid For Hour Textfield
		//Parameter Summary  : Hour
			public void verifyTwoFactorAuthenticationValidForHourTextfield(Map<Object, Object> testdatamap,Log Log) throws Exception {
				try
				{
					ClickOnAddBtn();
					waitForPageToLoad();				
					Thread.sleep(500);
					this.takeScreenShot();
					WebClick(EdaatOR.Admin_Usermng_Viewtwofactauth);
					Thread.sleep(1000);
					this.takeScreenShot();
					VerifyValue1(getAttributeValue(EdaatOR.Admin_Usermng_AddGroup_EnterHours, "value"), "10");
					Thread.sleep(500);
					WebEdit(EdaatOR.Admin_Usermng_AddGroup_EnterHours,testdatamap.get("Hours").toString());
					Thread.sleep(500);
					this.takeScreenShot();		          

					test.log(Status.PASS,"#FUNC-Verify that the Time filed is a textbox with min 1 and max 120 and the default value is 10 is successful" + driver.getTitle() +" *PASS * ");
					Log.ReportEvent("PASS", " Verify that the Time filed is a textbox with min 1 and max 120 and the default value is 10");

				}
				catch (Exception e) {
					test.log(Status.FAIL,"#FUNC-Verify that the Time filed is a textbox with min 1 and max 120 and the default value is 10 Failed" + driver.getTitle() +" *FAIL * " );

				}
			}
		//Function Summary   : Method to View Two Factor Authentication Clicking on Group Name
		//Parameter Summary  : ArabicName,GroupCode,EngName
			public void ViewTwoFactorAuthenticationClickingOnGroupName(Map<Object, Object> testdatamap,Log Log) throws Exception {
				try
				{

				searchGroupByName(testdatamap.get("ArabicName").toString());
				searchGroupByCode(testdatamap.get("GroupCode").toString());
				ClickOnGrouSearchBtn();
				Thread.sleep(2000);
				this.takeScreenShot();
				Thread.sleep(1000);
				if(CheckElementExists(EdaatOR.Admin_Usermng_nodata)==true)
				{
					addGroup(testdatamap,Log);
					waitForPageToLoad();
					searchGroupByName(testdatamap.get("ArabicName").toString());
					searchGroupByCode(testdatamap.get("GroupCode").toString());
					ClickOnGrouSearchBtn();
					Thread.sleep(2000);
					this.takeScreenShot();
				}
				ClickOnGroupName(testdatamap.get("EngName").toString());
				Thread.sleep(3000);
				this.takeScreenShot();
				verifyElementIsPresent(EdaatOR.Admin_Usermng_Viewtwofactauth);
				VerifyObjectDisabled(EdaatOR.Admin_Usermng_AddGroupViewtwofactauthcheckbox);
				Thread.sleep(2000);
				this.takeScreenShot();
				ClickOnCloseBtn();							
				this.takeScreenShot();
				test.log(Status.PASS,"#FUNC-Verify that view two factor authentication is successful" + driver.getTitle() +" * User Group Management PASS * ");
		    	Log.ReportEvent("PASS", " Verify that View Two Factor Authentication ");

				}
				catch (Exception e) {
				test.log(Status.FAIL,"#FUNC-Verify view two factor authentication Failed" + driver.getTitle() +" * User Group Management  FAIL * " );
					
				}
			}	
			
			//Function Summary   : Method to Select two factor authentication view result
			//Parameter Summary  : N/A
				public void selectTwoFactorAuthenticationViewResult(Map<Object, Object> testdatamap,Log Log) throws Exception {
					try
					{
						ClickOnAddBtn();
						waitForPageToLoad();				
						Thread.sleep(500);
				        this.takeScreenShot();
				        verifyElementIsPresent(EdaatOR.Admin_Usermng_Viewtwofactauth);
				        Thread.sleep(500);
			            WebClick(EdaatOR.Admin_Usermng_Viewtwofactauth);
			            Thread.sleep(500);
			            verifyElementIsPresent(EdaatOR.Admin_Usermng_AddGroup_SendSMS);
			            verifyElementIsPresent(EdaatOR.Admin_Usermng_AddGroup_SendEmail);
			            this.takeScreenShot();
			            WebEdit(EdaatOR.Admin_Usermng_AddGroup_EnterHours,testdatamap.get("Hours").toString());
			            Thread.sleep(500);
			            WebClick(EdaatOR.Admin_Usermng_AddGroup_SendSMS);
			            Thread.sleep(500);
			            WebClick(EdaatOR.Admin_Usermng_AddGroup_SendEmail);						
			            Thread.sleep(500);
			            this.takeScreenShot();		          
													
					test.log(Status.PASS,"#FUNC-Select two factor authentication view result is successful" + driver.getTitle() +" * User Group Management PASS * ");
			    	Log.ReportEvent("PASS", " Verify Select two factor authentication view results in Add Group Popup");

					}
					catch (Exception e) {
					test.log(Status.FAIL,"#FUNC-Select two factor authentication view result Failed" + driver.getTitle() +" * User Group Management  FAIL * " );
						
					}
				}	
	
		
}
