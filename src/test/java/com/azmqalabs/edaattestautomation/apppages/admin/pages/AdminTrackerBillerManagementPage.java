/**
* Test Script Name                   : N/A
* Objective                          : Admin Tracked Biller Management related functions
* Version                            : 1.0
* Author                             : Kathirvelu M
* Created Date                       : 5/07/2023
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
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SwitchToWindow;
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
import com.azmqalabs.edaattestautomation.testscripts.admin.AdminTrackerMgmGridView;
import com.azmqalabs.edaattestautomation.testscripts.admin.AdminTrackerMgmToggleStatus;

public class AdminTrackerBillerManagementPage extends BasePage {

	public AdminTrackerBillerManagementPage(WebDriver driver, ExtentTest test) {
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

	//Function Summary   : Method to clickOnSearchBtn
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

	
	//Function Summary   : Method to verifySearchTrackerBiller
	//Parameter Summary  : CompanyName
		public void verifySearchTrackerBiller(Map<Object, Object> testdatamap,Log Log) throws Exception {
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		boolean Ele=CheckElementExists(EdaatOR.Admin_TrackerBillerMangm_Record);
		if(Ele==true) {
			test.log(Status.PASS,"#FUNC-VerifyBillerApprovalIsClosed" + driver.getTitle() +" * Biller is approval is rejected PASS * " );
			takeScreenShot();
        	Log.ReportEvent("PASS", "Verify the search functionality  ");

		}else
			test.log(Status.FAIL,"#FUNC-VerifyBillerApprovalIsClosed" + driver.getTitle() +" * Biller is approval is rejected FAIL ");
	}
	
	
	
	public void VerifyGridViewTrackerManagement(Map<Object, Object> testdatamap,Log Log) throws Exception {

		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		if(CheckElementExists(EdaatOR.Admin_SystemMgm_RecordNotFound)==true) {
			AdminTrackerMgmGridView.record=false;
			Log.ReportEvent("PASS", "Verify Grid view details ");

		}
		else {
			this.takeScreenShot();
			VerifyValue(testdatamap.get("CompanyName").toString(), EdaatOR.Admin_TrackerBillerMangm_CorpName);
			this.takeScreenShot();
			VerifyValue("Corporate", EdaatOR.Admin_TrackerBillerMangm_CorpType);
			VerifyValue("No", EdaatOR.Admin_TrackerBillerMangm_EmailConf);
			verifyElementIsPresent(EdaatOR.Admin_TrackerBillerMangm_ToggleBtn);
			this.takeScreenShot();
			//verifyElementIsPresent(EdaatOR.Admin_SystemMgm_EyeIcon);
		    verifyElementIsPresent(EdaatOR.Admin_TrackerBillerMangm_EyeIcon);	
			AdminTrackerMgmGridView.record=true;
			Log.ReportEvent("PASS", "Verify Grid view details ");

		}
	}

	//Function Summary   : Method to verifyTrackerBillerMgmToggle
	//Parameter Summary  : CompanyName,InActive,Active
	public void verifyTrackerBillerMgmToggle(Map<Object, Object> testdatamap,Log Log) throws Exception {
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		Thread.sleep(1000);
		if(CheckElementExists(EdaatOR.Admin_SystemMgm_RecordNotFound)==true) {
			AdminTrackerMgmToggleStatus.record=false;
			Log.ReportEvent("PASS", "Verify the status toggel  & Verify Activate Biller / Corporate button is successful");

		}
		else {
		verifyElementIsNotPresent(EdaatOR.Admin_SystemMgm_RecordUnclickable, "Slid Bar is activated");
		verifyElementIsPresent(EdaatOR.Admin_ApproveMgn_ToggleBtn);
		WebClickUsingJS(EdaatOR.Admin_ApproveMgn_ToggleBtn);
		Thread.sleep(600);
		takeScreenShot();
		VerifyValue1(getText(EdaatOR.Admin_Compan_ActivePop), testdatamap.get("InActive").toString());
		WebClickUsingJS(EdaatOR.Admin_Compan_ActiveConfbtn);
		Thread.sleep(3000);
		takeScreenShot();
		WebClickUsingJS(EdaatOR.Admin_ApproveMgn_ToggleBtn);
		Thread.sleep(600);
		takeScreenShot();
		VerifyValue1(getText(EdaatOR.Admin_Compan_ActivePop), testdatamap.get("Active").toString());
		WebClickUsingJS(EdaatOR.Admin_Compan_ActiveConfbtn);
		AdminTrackerMgmToggleStatus.record=true;
		Log.ReportEvent("PASS", "Verify the status toggel  & Verify Activate Biller / Corporate button is successful");

		}
		
	}
	
	
	public void clickOnApproval() throws InterruptedException {

		WebClick(EdaatOR.Admin_SystemMgm_ApprovalBtn);
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_SystemMgm_ApprovalYesBtn);
		Thread.sleep(1000);
		waitForPageToLoad();
	}
	
	public void clickOnActivateLink() {

		WebClick(EdaatOR.Admin_SystemMgm_BillerActivateBtn);
	}
	
	//Function Summary   : Method to verifyIndividualClientIDClickable
	//Parameter Summary  : N/A	
	public void verifyIndividualClientIDClickable(Log Log) throws Exception {
		String clientID=getText(EdaatOR.Admin_TrackerBillerMangm_IndiviClenteID);
		WebClick(EdaatOR.Admin_TrackerBillerMangm_IndiviClenteID);
		waitForPageToLoad();
		switchToWindow();
		String row=getrowcount();
		//String clientIDAfter=getText(EdaatOR.Admin_IndividualClient_RowCount);
		VerifyValue1(clientID, row);
    	Log.ReportEvent("PASS", "Verify that Total Individual Clients is clickable ");

	}
	
	public String getrowcount() {
		List<WebElement> allrows = driver.findElements(By.xpath(EdaatOR.Admin_IndividualClient_RowCount));
		waitForPageToLoad();
		int row_count = allrows.size();
		String rowcount = Integer.toString(row_count);
		return rowcount;
	}
	//Function Summary   : Method to click on and verify "Total corporate clients"
	//Parameter Summary :N/A
	public void verifyCorporateClientIDClickable(Log Log) throws Exception {
		String clientID=getText(EdaatOR.Admin_TrackerBillerMangm_CopoClientID);
		WebClick(EdaatOR.Admin_TrackerBillerMangm_CopoClientID);
		waitForPageToLoad();
		switchToWindow();
		Thread.sleep(2000);
		this.takeScreenShot();
		String rowCount=getRowCounts() ;
		//String clientIDAfter=getText(EdaatOR.Admin_IndividualClient_RowCount);
		VerifyValue1(clientID, rowCount);
		Log.ReportEvent("PASS", "Verify that Total Corporate Clients is clickable ");

    }
	//Function Summary   : Method to count "Total corporate clients"
	//Parameter Summary :N/A
	public String getRowCounts() {
    	List<WebElement> invoice = driver.findElements(By.xpath(EdaatOR.Admin_IndividualClient_RowCount));
        waitForPageToLoad();
        int Rcount =invoice.size();
        String rowCount=Integer.toString(Rcount);
        return rowCount;
    }
}
