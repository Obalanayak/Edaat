/**
* Test Script Name                   : N/A
* Objective                          : Verify UserList functionality Under UserManagement 
* Version                            : 1.0
* Author                             : Kathirvelu M
* Created Date                       : 
* Last Updated on                    : N/A
* Updated By                         : Basavaraj Mudnur
* Pre-Conditions                     : 1)Admin Login Credentials 
* Epic Details                       : N/A
* User Story Details                 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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



public class AdminUserMngUserListPage extends BasePage
{

	public AdminUserMngUserListPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Admin_Usermanagement_Userlist)
	public WebElement UserList;
	

	public boolean Exists(){
		return super.Exists(UserList);
	}

	//Function Summary  : Method to navigateUserlistPage
	//Parameter Summary : N/A
	public void navigateUserlistPage(Log Log) throws Exception {
		WebClickUsingJS(EdaatOR. Admin_Menu_UserManagement);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_Menu_UserList);
		Thread.sleep(2000);
    	Log.ReportEvent("PASS", " Verify User List Page is Displayed");

	}
	//Function Summary  : Method to EnterUserNameBox
	//Parameter Summary : N/A
	public void ClickOnAddUserBtn() {
		WebClick(EdaatOR.Admin_UserList_AddUserBt);
	}
	//Function Summary  : Method to EnterUserNameBox
	//Parameter Summary : pname
	public void EnterUserNameBox(String pname) {
		WebEdit(EdaatOR.Admin_UserListAdd_NameInput,pname);
	}
	//Function Summary  : Method to EnterEmailIdBox
	//Parameter Summary : Email
	public void EnterEmailIdBox(String Email) {
		WebEdit(EdaatOR.Admin_UserListAdd_EmailInput, Email);
	}
	//Function Summary  : Method to EnterPhoneNmBox
	//Parameter Summary : phone
	public void EnterPhoneNmBox(String phone) {
		WebEdit(EdaatOR.Admin_UserListAdd_PhoneInput,phone);
	}
	//Function Summary  : Method to ClickOnGrouChekbox
	//Parameter Summary : N/A
	public void ClickOnGrouChekbox() {
		WebClickUsingJS(EdaatOR.Admin_UserListAdd_GroupCheckBox);
	}
	//Function Summary  : Method to ClickOnUserAddBtn
	//Parameter Summary : N/A
	public void ClickOnUserAddBtn() {
		WebClick(EdaatOR.Admin_UserListAdd_AddUserBtPop);
	}

	//Function Summary  : Method to EnterSearchUserName
	//Parameter Summary : lstname
	public void EnterSearchUserName(String lstname) {
		WebEdit(EdaatOR.Admin_UserListSearch_NameBt, lstname);
	}
	//Function Summary  : Method to EnterSearchEmalID
	//Parameter Summary : lstname
	public void EnterSearchEmalID(String lstname) {
		WebEdit(EdaatOR.Admin_UserListSearch_EmailBt, lstname);
	}
	//Function Summary  : Method to ClickOnUselistSearchBtn
	//Parameter Summary : N/A
	public void ClickOnUselistSearchBtn() throws InterruptedException {
		WebClick(EdaatOR.Admin_UserListSearch_SaerchBt);
		Thread.sleep(1000);
	}
	//Function Summary  : Method to ClickOnDiscountDeleteBtn
	//Parameter Summary : N/A
	public void ClickOnDiscountDeleteBtn() {
		WebClick(EdaatOR.Admin_UserList_DeleteBtn);
	}
	//Function Summary  : Method to ClickOnDiscountConfYesBtn
	//Parameter Summary : N/A
	public void ClickOnDiscountConfYesBtn() {
		WebClick(EdaatOR.Admin_UserList_YesConfBtn);
	}
		
	//Function Summary  : Method verify AddUser
	//Parameter Summary : UserName,EmailID,PhoneNum
	public void AddUser(Map<Object,Object>testdatamap) throws Exception {
		ClickOnAddUserBtn();
		Thread.sleep(1500);
		EnterUserNameBox(testdatamap.get("UserName").toString());
		Thread.sleep(500);
		EnterEmailIdBox(testdatamap.get("EmailID").toString());
		Thread.sleep(200);
		EnterPhoneNmBox(testdatamap.get("PhoneNum").toString());
		ClickOnGrouChekbox();
		Thread.sleep(1500);
		ClickOnUserAddBtn();
		Thread.sleep(1000);
		this.takeScreenShot();
	}
	//Function Summary  : Method SearchUser
	//Parameter Summary : UserName,EmailID
	public void SearchUser(Map<Object,Object>testdatamap) throws Exception {
		
		EnterSearchUserName(testdatamap.get("UserName").toString());
		EnterSearchEmalID(testdatamap.get("EmailID").toString());
		ClickOnUselistSearchBtn();
		Thread.sleep(1000);
		this.takeScreenShot();
	}
	public void DeleteUser(Map<Object,Object>testdatamap) throws Exception {
		ClickOnDiscountDeleteBtn();
		Thread.sleep(1500);
		VerifyValue1(getText(EdaatOR.Admin_UserList_ConfirmDeletePop), testdatamap.get("DeleteDiscount").toString());
		ClickOnDiscountConfYesBtn();
		Thread.sleep(1500);

	}

	public void verifyDeleteUser(Map<Object,Object> testdatamap) throws Exception {
		try {
			AddUser(testdatamap);
			SearchUser(testdatamap);
			DeleteUser(testdatamap);
			verifyElementIsPresent(EdaatOR.Admin_Product_NoData);
			test.log(Status.PASS,"#FUNC-Delete User from userlist" + driver.getTitle() +" * User Management PASS * " );	
		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Delete User from userlist" + driver.getTitle() +" * User Management  FAIL * " );
			this.takeScreenShot();
		}
	}
	//Function Summary  : Method verifySearchUser
	//Parameter Summary : N/A
	public void verifySearchUser(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			SearchUser(testdatamap);
           // WebClick("//span[text()='"+testdatamap.get("UserName").toString()+"']");
			//Thread.sleep(3000);
			//verifyElementIsPresent("//h6[text()='View User Info']"); 
			if(CheckElementExists(EdaatOR.Admin_Product_NoData)==true) {
			AddUser(testdatamap);
			waitForPageToLoad();
			SearchUser(testdatamap);
			}
			VerifyValue1(getText(EdaatOR.Admin_UserList_UserName), testdatamap.get("UserName").toString());
		//	verifyElementIsNotPresent(EdaatOR.Admin_Product_NoData, "Data is exists");
			Thread.sleep(1000);
			this.takeScreenShot();
			test.log(Status.PASS,"#FUNC-Search User from userlist " + driver.getTitle() +" * User list Management PASS * " );	
        	Log.ReportEvent("PASS", " Verify user list Search functionality is Successful");

		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Search User from userlist" + driver.getTitle() +" * User List Management  FAIL * " );
			this.takeScreenShot();
		}
	}
	public void SearchUserCheckbox(Map<Object,Object> testdatamap,Log Log) throws Exception
	{
		try {
	    navigateUserlistPage(Log);
		EnterSearchUserName(testdatamap.get("UserName").toString());
		EnterSearchEmalID(testdatamap.get("EmailID").toString());
		WebClick(EdaatOR.Admin_UserList_dltcheck);
		ClickOnUselistSearchBtn();		
		Thread.sleep(1000);
		this.takeScreenShot();
		Thread.sleep(1000);
		//driver.findElement(By.xpath(EdaatOR.Admin_UserList_dltcheck)).sendKeys(Keys.PAGE_DOWN);
		VerifyValue1(getText(EdaatOR.Admin_UserList_dltVerify),testdatamap.get("EmailID").toString() );
		Thread.sleep(1000);
		this.takeScreenShot();
		test.log(Status.PASS,"#FUNC-Search User from userlist" + driver.getTitle() +" * User List Management  PASS * " );
		Log.ReportEvent("PASS", " Verify Deleted Users checkbox is Suceessful");
		Thread.sleep(1000);
		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Search User from userlist" + driver.getTitle() +" * User List Management  FAIL * " );
			this.takeScreenShot();
	}
	
	}
	//Function Summary  : Method verify Edit Users Details
	//Parameter Summary : ChangeUserName,ChangePhoneNum,EmailID,UserName
	public void verifyUsersListEdit(Map<Object, Object> testdatamap,Log Log) {
		try {
			AddUser(testdatamap);
			Thread.sleep(1000);
			this.takeScreenShot();
			SearchUser(testdatamap);
			Thread.sleep(1000);
			this.takeScreenShot();
			WebClick(EdaatOR.Admin_UserMgm_UsersList_Editbtn);
			switchToWindow();
			Thread.sleep(1000);
			this.takeScreenShot();
			WebClear(EdaatOR.Admin_UserListAdd_NameInput);
			WebEdit(EdaatOR.Admin_UserListAdd_NameInput,testdatamap.get("ChangeUserName").toString());
			Thread.sleep(500);
			WebClear(EdaatOR.Admin_UserListAdd_PhoneInput);
			WebEdit(EdaatOR.Admin_UserListAdd_PhoneInput,testdatamap.get("ChangePhoneNum").toString());
			Thread.sleep(1000);
			this.takeScreenShot();
			WebClick(EdaatOR.Admin_UserMgm_UsersList_Savechange);
			EnterSearchUserName(testdatamap.get("ChangeUserName").toString());
			EnterSearchEmalID(testdatamap.get("EmailID").toString());
			ClickOnUselistSearchBtn();
			Thread.sleep(1000);
			this.takeScreenShot();
			VerifyValue1(getText(EdaatOR.Admin_UserList_UserName), testdatamap.get("ChangeUserName").toString());
			test.log(Status.PASS,"#FUNC-Verify UsersList Edit" + driver.getTitle() +" * UsersList Edit is Pass * " );	
			this.takeScreenShot();
        	Log.ReportEvent("PASS", " Verify UsersList Edit functionality is successfull");

		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Verify UsersList Edit" + driver.getTitle() +" * UsersList Edit is Fail * " );
			this.takeScreenShot();
		}
	}
	//Function Summary  : Method verify Delete User
	//Parameter Summary : UserName,EmailID
	public void verifyUsersDelete(Map<Object, Object> testdatamap,Log Log) {
	try {
		AddUser(testdatamap);
		Thread.sleep(500);
		SearchUser(testdatamap);
		this.takeScreenShot();
		WebClick(EdaatOR.Admin_UserMgm_UsersList_Deletebtn);
		Thread.sleep(1000);
		this.takeScreenShot();
		WebClick(EdaatOR.Admin_UserMgm_UsersList_YesDeletebtn);
		EnterSearchUserName(testdatamap.get("UserName").toString());
		EnterSearchEmalID(testdatamap.get("EmailID").toString());
		WebClick(EdaatOR.Admin_UserMgm_UsersList_DeletedCheckbox);
		ClickOnUselistSearchBtn();
		VerifyValue1(getText(EdaatOR.Admin_UserList_UserName), testdatamap.get("UserName").toString());
		test.log(Status.PASS,"#FUNC-Verify Delete User" + driver.getTitle() +" * Delete User is Pass * " );	
    	Log.ReportEvent("PASS", " Verify Delete user functionality");
		this.takeScreenShot();
	
	}
	catch(Exception e){
		test.log(Status.FAIL,"#FUNC-Verify Delete User" + driver.getTitle() +" * Delete User is Fail * " );
		this.takeScreenShot();
	}
	}
	//Function Summary  : Method to Verify Status toggle under user list management.
	//Parameter Summary : N/A
	public void Verifystatustoggle(Map<Object,Object> testdatamap,Log Log) throws Exception
	{
		try {
		navigateUserlistPage(Log);
		AddUser(testdatamap);
		Thread.sleep(1000);
		SearchUser(testdatamap);
		Thread.sleep(5000);
		verifyElementIsPresent(EdaatOR.Admin_UserList_statustg);	
    	Log.ReportEvent("PASS", " Verify status toggle functionality is Successful");
		}
		catch(Exception e)
		{
			test.log(Status.FAIL,"#FUNC-Verify status toggle button" + driver.getTitle() +" * User List Management  FAIL * " );
		}
	}
	
	public void AddUserAndVerify(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			AddUser(testdatamap);
			Thread.sleep(1000);
			SearchUser(testdatamap);
			Thread.sleep(1000);
			this.takeScreenShot();
			VerifyValue1(getText(EdaatOR.Admin_UserList_Email), testdatamap.get("EmailID").toString());
			Thread.sleep(1000);
			this.takeScreenShot();
			test.log(Status.PASS,"#FUNC-Add user and verify " + driver.getTitle() +" * User list Management PASS * " );	
        	Log.ReportEvent("PASS", " Verify User list Add User functionality is Successfull");

		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Add user and verify" + driver.getTitle() +" * User List Management  FAIL * " );
			this.takeScreenShot();
		}
	}
	//Function Summary  : Method to Verify UserName is Clickable
	//Parameter Summary : ActivationMsg
	public void verifyUsernameClikable(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			AddUser(testdatamap);
			SearchUser(testdatamap);
			Thread.sleep(2000);
			this.takeScreenShot();
			WebClick(EdaatOR.Admin_UserList_UserNameClick);
			Thread.sleep(3000);
			
			//VerifyValue1(getText("//h6[text()='"+testdatamap.get("UserInfo").toString()+"']"),testdatamap.get("UserInfo").toString());
			//verifyElementIsPresent(EdaatOR.Admin_UserList_ViewUserInfoNameTxt);
			Thread.sleep(2000);
			this.takeScreenShot();
			test.log(Status.PASS,"#FUNC-UserName is Clickable " + driver.getTitle() +" * UserName is Clickable PASS * " );	
        	Log.ReportEvent("PASS", " Verify Search functionality");

		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-UserName is Clickable" + driver.getTitle() +" * UserName is Clickable FAIL * " );
			this.takeScreenShot();
		}
	
	}
	    //Function Summary  : Method verify AddUserErrorvalidation
		//Parameter Summary : GroupClick,UserName,EmailID,PhoneNum
	public void AddUserErrorvalidation(Map<Object,Object>testdatamap) throws Exception {
			String Group = testdatamap.get("GroupClick").toString();
			ClickOnAddUserBtn();
			Thread.sleep(1500);
			EnterUserNameBox(testdatamap.get("UserName").toString());
			Thread.sleep(500);
			EnterEmailIdBox(testdatamap.get("EmailID").toString());
			Thread.sleep(200);
			EnterPhoneNmBox(testdatamap.get("PhoneNum").toString());
			if(Group.equalsIgnoreCase("Yes"))
			{
				WebClickUsingJS(EdaatOR.Admin_UserListAdd_GroupCheckBox);
			}
			Thread.sleep(1500);
			ClickOnUserAddBtn();
			Thread.sleep(1000);
			this.takeScreenShot();
		}
	//Function Summary  : Method to verifyAddUserErrorMsg
	//Parameter Summary : Expected
	public void verifyAddUserErrorMsg(Map<Object, Object> testdatamap) throws Exception {
		try
		{
		AddUserErrorvalidation(testdatamap);
		if(ExistsCheck(EdaatOR.Admin_UserList_NameErrorMsg))
		{
			VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Admin_UserList_NameErrorMsg);
			test.log(Status.PASS, "#FUNC-UserListUserName ErrorMessage Exists" + driver.getTitle() + " * UserListUserName ErrorMessage Exists * ");
		}
		else if (ExistsCheck(EdaatOR.Admin_UserList_PhonenoErrorMsg)&&ExistsCheck(EdaatOR.Admin_UserList_NameErrorMsg)&&ExistsCheck(EdaatOR.Admin_UserList_EmailErrorMsg))
		{
			VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Admin_UserList_PhonenoErrorMsg);
			test.log(Status.PASS, "#FUNC-UserListPhone ErrorMessage Exists" + driver.getTitle() + " * UserListEmail ErrorMessage Exists * ");
		}		
		else if (ExistsCheck(EdaatOR.Admin_UserList_EmailErrorMsg)) {
			VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Admin_UserList_EmailErrorMsg);
			test.log(Status.PASS, "#FUNC-UserListEmail ErrorMessage Exists" + driver.getTitle() + " * UserListEmail ErrorMessage Exists * ");			
		}
		else if (ExistsCheck(EdaatOR.Admin_UserList_EmailExistsErrorMsg))
		{	
			driver.findElement(By.xpath(EdaatOR.Admin_UserListAdd_EmailInput)).sendKeys(Keys.PAGE_UP);
			VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Admin_UserList_EmailExistsErrorMsg);
			this.takeScreenShot();
			Thread.sleep(1000);
			test.log(Status.PASS, "#FUNC-UserList Emailalreadyinuse ErrorMessage Exists" + driver.getTitle() + " * UserListEmailalreadyinuse ErrorMessage Exists * ");
		}
		else if (ExistsCheck(EdaatOR.Admin_UserList_GroupErrorMsg))
		{
			VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Admin_UserList_GroupErrorMsg);
			test.log(Status.PASS, "#FUNC-UserListGroup ErrorMessage Exists" + driver.getTitle() + " * UserListGroup ErrorMessage Exists * ");
		}
		else
		{
			test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
		}
		}
		catch (Exception e) {
			test.log(Status.FAIL,"#FUNC-UserList Add User" + driver.getTitle() +" * UserList Add User FAIL * " );
			this.takeScreenShot();
		}
	}
	
}
