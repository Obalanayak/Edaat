/**
* Test Script Name                   : N/A
* Objective                          : My Bills related functions
* Version                            : 1.0
* Author                             : Kathirvelu Mohan
* Created Date                       : 05/06/2023
* Last Updated on                    : N/A
* Updated By                         : Dhruva Kumar S
* Pre-Conditions                     : N/A
* Epic Details                       : N/A
* User Story Details                 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class MyBillsPage extends BasePage {

	public MyBillsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.LoginPage_Username)
	public WebElement Username;

	public boolean Exists() {
		return super.Exists(Username);
	}
	
	//Function Summary   : Method to  clickOnMyBillMenu
	//Parameter Summary  : N/A
	public void clickOnMyBillMenu(Log Log) throws InterruptedException {
		WebClick(EdaatOR.Admin_MyBill_Button);
		Thread.sleep(2000);
		this.takeScreenShot();
    	Log.ReportEvent("PASS", "Navigate to My Bills");

	}
	//Function Summary   : Method to  enterMyBillsDetails
	//Parameter Summary  : N/A
	
	public void enterMyBillsDetails(String ID) {
		WebEdit(EdaatOR.Admin_MyBill_BillNumberField, ID);
	}
	//Function Summary   : Method to  clickOnMyBillViewButton
	//Parameter Summary  : N/A	
	
	public void clickOnMyBillViewButton() {
		WebClick(EdaatOR.Admin_MyBill_ViewButton);
	}
	
	//Function Summary   : Method to verifyInvalidBillNumberMessage
	//Parameter Summary  : InvalidBillNumber
	public void verifyInvalidBillNumberMessage(Map<Object,Object> testdatamap,Log Log) throws IOException, InterruptedException {
		enterMyBillsDetails(testdatamap.get("InvalidBillNumber").toString());
		clickOnMyBillViewButton();
		this.takeScreenShot();
		Thread.sleep(2000);
		this.takeScreenShot();
		VerifyValue1(getText(EdaatOR.Admin_MyBill_InvalidNumber), "Invalid invoice number");
    	Log.ReportEvent("PASS", "Verify to enter Invalid Invoice Number");

	}
	
	//Function Summary   : Method to  clickOnMyBillMenu
	//Parameter Summary  : InvoiceID,Invoice Status,Invoice Details
	public void verifyValidBillNumberMessage(Map<Object,Object> testdatamap,Log Log) throws IOException, Exception {
		enterMyBillsDetails(testdatamap.get("InvoiceID").toString());
		clickOnMyBillViewButton();
		this.takeScreenShot();
		Thread.sleep(1000);
		this.takeScreenShot();
		VerifyValue1(getText(EdaatOR.Admin_MyBill_BillNumber), testdatamap.get("InvoiceID").toString());
		verifyElementIsPresent(EdaatOR.Admin_MyBill_BillStatus, "Invoice Status");
		verifyElementIsPresent(EdaatOR.Admin_MyBill_DetailsHeader, "Invoice Details");
       	Log.ReportEvent("PASS", "Verify to enter valid Invoice Number");

	}
	
	//Function Summary   : Method to  clickOnPayNowButton
	//Parameter Summary  : N/A
	public void clickOnPayNowButton() {
		WebClickUsingJS(EdaatOR.MyBills_Paybtn);
	}
	
	//Function Summary   : Method to  clickLoginButton
	//Parameter Summary  : N/A
	public void clickLoginButton() {
		WebClickUsingJS(EdaatOR.MyBills_Clientpopup_LoginBtn);
	}
	//Function Summary   : Method to  VerifyAvailablePaymentMethodAssignedToBillerAccount
	//Parameter Summary  : ContractNumber
	public void VerifyAvailablePaymentMethodAssignedToBillerAccount(Map<Object, Object> testdatamap, Log Log) {
		try {
			enterMyBillsDetails(testdatamap.get("ContractNumber").toString());
			clickOnMyBillViewButton();
			this.takeScreenShot();
			Thread.sleep(1000);
			if(CheckElementExists(EdaatOR.MyBills_Paybtn)) {
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(EdaatOR.MyBills_Paybtn))).build().perform();
			verifyElementIsPresent(EdaatOR.MyBills_Sadad_PaymentMethod);
			verifyElementIsPresent(EdaatOR.MyBills_Mada_PaymentMethod);
			verifyElementIsPresent(EdaatOR.MyBills_Visa_PaymentMethod);
			verifyElementIsPresent(EdaatOR.MyBills_MasterCard_PaymentMethod);
			this.takeScreenShot();
			test.log(Status.PASS,"#FUNC-Verify that the available payment method on my bills page is the same one assigned in the biller's account Functionality is successfull" + driver.getTitle() +" * Verify that the available payment method on my bills page is the same one assigned in the biller's account Functionality is successfull PASS * " );	
	    	Log.ReportEvent("PASS", "Verify that the available payment method on my bills page is the same one assigned in the biller's account Functionality is successfull");	
			}
			else
			{
				this.takeScreenShot();
				test.log(Status.FAIL,"#FUNC-Verify that the available payment method on my bills page is the same one assigned in the biller's account Functionality is Unsuccessfull" + driver.getTitle() +" * Verify that the available payment method on my bills page is the same one assigned in the biller's account Functionality is Unsuccessfull FAIL * " );	
			}
		  }
	     catch (Exception e) {
			e.printStackTrace();
			this.takeScreenShot();
			test.log(Status.FAIL,"#FUNC-Verify that the available payment method on my bills page is the same one assigned in the biller's account Functionality is Unsuccessfull" + driver.getTitle() +" * Verify that the available payment method on my bills page is the same one assigned in the biller's account Functionality is Unsuccessfull FAIL * " );	
		}
	}
	
	//Function Summary   : Method to  enterTheContractNumberAndClickOnPayNowButton
	//Parameter Summary  : ContractNumber,ClientPopupHeader
	public void enterTheContractNumberAndClickOnPayNowButton(Map<Object, Object> testdatamap, Log Log) throws IOException, InterruptedException {
		try {
		enterMyBillsDetails(testdatamap.get("ContractNumber").toString());
		clickOnMyBillViewButton();
		clickOnPayNowButton();
		Thread.sleep(2000);
		this.takeScreenShot();
		if (CheckElementExists(EdaatOR.MyBills_Clientpopup_Header)) {
			this.takeScreenShot();
			VerifyValue1(getText(EdaatOR.MyBills_Clientpopup_Header),testdatamap.get("ClientPopupHeader").toString());
			clickLoginButton();
			this.takeScreenShot();
	    	Log.ReportEvent("PASS", "Enter the contract number and click on PayNow Functionality is successfull");	
			test.log(Status.PASS,"#FUNC-Enter the contract number and click on PayNow Functionality is successfull" + driver.getTitle() +" *Enter the contract number and click on PayNow Functionality is successfull PASS * " );	

		}
		else {
			this.takeScreenShot();
			test.log(Status.FAIL,"#FUNC-Enter the contract number and click on PayNow Functionality is Unsuccessfull" + driver.getTitle() +" *Enter the contract number and click on PayNow Functionality is Unsuccessfull FAIL * " );	
		}
		}
		catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL,"#FUNC-Enter the contract number and click on PayNow Functionality is Unsuccessfull" + driver.getTitle() +" *Enter the contract number and click on PayNow Functionality is Unsuccessfull FAIL * " );	

		}
	}
	
	//Function Summary   : Method to  validateTheClientPopupAppears
	//Parameter Summary  : ContractNumber,ClientPopupHeader
	public void validateTheClientPopupAppears(Map<Object, Object> testdatamap, Log Log) throws IOException, InterruptedException {
		try {
		enterMyBillsDetails(testdatamap.get("ContractNumber").toString());
		clickOnMyBillViewButton();
		clickOnPayNowButton();
		Thread.sleep(2000);
		this.takeScreenShot();
		if (CheckElementExists(EdaatOR.MyBills_Clientpopup_Header)) {
			this.takeScreenShot();
			VerifyValue1(getText(EdaatOR.MyBills_Clientpopup_Header),testdatamap.get("ClientPopupHeader").toString());
			verifyElementIsPresent(EdaatOR.MyBills_Clientpopup_LoginBtn);
			this.takeScreenShot();
	    	Log.ReportEvent("PASS", "verify that when clicking on inquire about invoice button after entering the contract number redirects to login to the client account Functionality is successfull");	
			test.log(Status.PASS,"#FUNC-verify that when clicking on inquire about invoice button after entering the contract number redirects to login to the client account Functionality is successfull" + driver.getTitle() +" *verify that when clicking on inquire about invoice button after entering the contract number redirects to login to the client account Functionality is successfull PASS * " );	
		}
		else {
			this.takeScreenShot();
			test.log(Status.FAIL,"#FUNC-verify that when clicking on inquire about invoice button after entering the contract number redirects to login to the client account Functionality is Unsuccessfull" + driver.getTitle() +" *verify that when clicking on inquire about invoice button after entering the contract number redirects to login to the client account Functionality is Unsuccessfull FAIL * " );	
		}
		}
		catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL,"#FUNC-verify that when clicking on inquire about invoice button after entering the contract number redirects to login to the client account Functionality is Unsuccessfull" + driver.getTitle() +" *verify that when clicking on inquire about invoice button after entering the contract number redirects to login to the client account Functionality is Unsuccessfull FAIL * " );	

		}
	}
	public void ExistsCheckElement(String Main) throws InterruptedException {
		Thread.sleep(1000);
		this.takeScreenShot();
		boolean Header;
		try {
			Header = ExistsCheck(Main);
			
			if (Header) {
				test.log(Status.PASS, "#FUNC-Element Exists" + driver.getTitle() + " * Element Exists * ");

			} else {
				test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
			}
		} catch (Exception e) {
			test.log(Status.FAIL,
					WARNINGFontColorSuffix + "launchApplication Page - loginToApplication failed - unable to Enter" + e
							+ WARNINGFontColorSuffix);
			test.log(Status.FAIL,
					WARNINGFontColorSuffix + "Error found at class: " + this.getClass().getName() + " Code line Number: "
							+ new Exception().getStackTrace()[0].getLineNumber() + "!" + WARNINGFontColorSuffix);
			throw new NoSuchElementException("Biller Home Page - Not Loaded");
		}
	}

	//LOGIN TO APPLICATION WITH GLOBAL LOGIN USER ID FROM LOGIN PAGE
	public void LoginToApplication(){
		try {
			
			this.Exists();
			if (IsDispalyed(EdaatOR.LoginPage_Username)) {
				WebEdit(EdaatOR.LoginPage_Username,  GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginUserName"));
				Thread.sleep(2000);
				WebEdit(EdaatOR.LoginPage_Password,  GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginPassword"));
				Thread.sleep(2000);
				this.takeScreenShot();
				WebClick(EdaatOR.LoginPage_LogIn);
				Thread.sleep(2000);
			} else {
				WebEdit(EdaatOR.LoginPage_Username, GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginUserName"));
				WebClick(EdaatOR.LoginPage_LogIn);

			}
			test.log(Status.PASS, "#FUNC-LoginToApplication" + driver.getTitle() + " * Login To Application PASS * ");

		} catch (Exception e) {
			test.log(Status.FAIL, "#FUNC-LoginToApplication" + driver.getTitle() + " * Login To Application FAILED * ");
			this.takeScreenShot();
		}
	}

	//LOGIN TO APPLICATION WITH INDIVIDUAL TESTDATA SHEET(SAME SHEET - CALL THIS METHOD IF USER WANTS PASS USER ID FROM THE SAME SHEET)
	public void LoginToApplication(String username, String password) {
		try {
			this.Exists();
			if (IsDispalyed(EdaatOR.LoginPage_Username)) {
				WebEdit(EdaatOR.LoginPage_Username, username);
				Thread.sleep(2000);
				WebEdit(EdaatOR.LoginPage_Password, password);
				Thread.sleep(2000);
				this.takeScreenShot();
				WebClick(EdaatOR.LoginPage_LogIn);
			} else {
				WebEdit(EdaatOR.LoginPage_Username, GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginUserName"));
				WebClick(EdaatOR.LoginPage_LogIn);

			}
			test.log(Status.PASS, "#FUNC-LoginToApplication" + driver.getTitle() + " * Login To Application PASS * ");

		} catch (Exception e) {
			test.log(Status.FAIL, "#FUNC-LoginToApplication" + driver.getTitle() + " * Login To Application FAILED * ");
			this.takeScreenShot();
		}
	}
	public void loginToApplication(String Username) {
		try {
			if (Username.equalsIgnoreCase("")) {
				Username = GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginUserName").toString();
			}

			WebEdit(EdaatOR.LoginPage_Username, Username);
			WebEdit(EdaatOR.LoginPage_Password, GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginPassword").toString());
			WebClick(EdaatOR.LoginPage_LogIn);

		} catch (Exception e) {
			test.log(Status.FAIL,
					WARNINGFontColorSuffix + "launchApplication Page - loginToApplication failed - unable to Enter" + e
							+ WARNINGFontColorSuffix);
			test.log(Status.FAIL,
					WARNINGFontColorSuffix + "Error found at class: " + this.getClass().getName() + " Code line Number: "
							+ new Exception().getStackTrace()[0].getLineNumber() + "!" + WARNINGFontColorSuffix);
			throw new NoSuchElementException("loginToApplication - Login Failed");
		}

	}

	public void Wait() throws Exception {
		int i = 0;
		while (i < 10) {
			SetExecutionDelay();
			i = i + 1;
		}
	}

	public void Logout(String logout) {
		try {
			WebClickUsingJS(logout);
			test.log(Status.PASS, "#FUNC-Logout Successful" + driver.getTitle() + " * Logout * ");
			this.takeScreenShot();
		} catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL, "#FUNC-Logout Not Successful" + driver.getTitle() + " * Not Logout * ");
			throw new NoSuchElementException("Logout - Logout Failed");

		}
	}
	
	public void ForgetPassword(String forGet,String Username) {
		try {
			WebClickUsingJS(forGet);
			WebEdit(EdaatOR.LoginPage_Username, Username);
			WebClickUsingJS(EdaatOR.LoginPage_send);
			test.log(Status.PASS, "#FUNC-ForgetPassword functionality Successful" + driver.getTitle() + " * Forget Password * ");
			this.takeScreenShot();
		} catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL, "#FUNC-ForgetPassword functionality Not Successful" + driver.getTitle() + " * Forget Password * ");
			throw new NoSuchElementException("ForgetPassword - ForgetPassword Failed");

		}
	}
	
	public void clickOnBillerLogin() throws InterruptedException {
		WebClickUsingJS(EdaatOR.Biller_Link);
		waitForPageToLoad();
		Thread.sleep(1000);
	}
	
	public void LoginToApplication(Map<Object,Object> testdatamap){
		try {
			Recordset login=ReadData.readTestDataBySpecifiedValue("Login", "LoginCategory", testdatamap.get("LoginCategory").toString());
			login.next();
			this.Exists();
			if (IsDispalyed(EdaatOR.LoginPage_Username)) {
				WebEdit(EdaatOR.LoginPage_Username,  login.getField("LoginUserName"));
				Thread.sleep(2000);
				WebEdit(EdaatOR.LoginPage_Password,  login.getField("LoginPassword"));
				Thread.sleep(2000);
				this.takeScreenShot();
				WebClick(EdaatOR.LoginPage_LogIn);
				Thread.sleep(2000);
			} else {
				WebEdit(EdaatOR.LoginPage_Username, login.getField("LoginUserName"));
				WebClick(EdaatOR.LoginPage_LogIn);

			}
			test.log(Status.PASS, "#FUNC-LoginToApplication" + driver.getTitle() + " * Login To Application PASS * ");

		} catch (Exception e) {
			test.log(Status.FAIL, "#FUNC-LoginToApplication" + driver.getTitle() + " * Login To Application FAILED * ");
			this.takeScreenShot();
		}
	}
	//Function Summary   : Method to verify Redirects To The Client Login Page,When user click on pay button
	//Parameter Summary  : ContractNumber
	public void verifyRedirectsToTheLoginClientPage (Map<Object,Object> testdatamap,Log Log) throws IOException, InterruptedException {
		try {
		enterMyBillsDetails(testdatamap.get("ContractNumber").toString());
		clickOnMyBillViewButton();
		this.takeScreenShot();
		Thread.sleep(1000);
		WebClick(EdaatOR.MyBills_Paybtn);
		Thread.sleep(500);
		this.takeScreenShot();
		Thread.sleep(500);
		WebClick(EdaatOR.MyBills_LoginAsClientToProcessBtn);
		Thread.sleep(500);
		VerifyValue1(getText(EdaatOR.MyBills_ClientRegistrationPage), "New Client Registration");
		this.takeScreenShot();
		test.log(Status.PASS, "#FUNC-Redirects to client login page" + driver.getTitle() + " * Redirect to client login page PASS * ");
    	Log.ReportEvent("PASS", "verified Redirects to the Login Client Page");
		}
		catch(Exception e) {
			test.log(Status.FAIL, "#FUNC-Redirects to client login page" + driver.getTitle() + " *  Redirect to client login page * ");
			this.takeScreenShot();	
		}

	}	
}
