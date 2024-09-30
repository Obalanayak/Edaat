/**
*
* Test Script Name                   : N/A
* Objective                          : Admin Login functionality
* Version                            : 1.0
* Author                             : Kathirvelu M
* Created Date                       : 23/05/2023
* Last Updated on                    : N/A
* Updated By                         : Kalpana I R
* Pre-Conditions                     : Admin login credentials
* Epic Details                       : N/A
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

public class AdminSystemMgmSubBillersPage extends BasePage {

	public AdminSystemMgmSubBillersPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Admin_system_subBlr_verif)
	public WebElement subBiller;

	public boolean Exists() {
		return super.Exists(subBiller);
	}
	//Function Summary  : Method to Navigate Sub biller Management Page
	//Parameter Summary :N/A
	public void NavigateSubBillersManagement(Log Log)
	{
		WebClickUsingJS(EdaatOR.Admin_system_sublink);
		this.takeScreenShot();
		Log.ReportEvent("PASS", " Verify to navigate SubBiller management is Suceessful");

	}
		//Function Summary : Method to EnterSearchitem
	//Parameter Summary: MainBiller
	public void EnterSearchitem(Map<Object, Object> testdatamap) throws InterruptedException {
		WebClick(EdaatOR.Admin_system_subBlr_click);
		Thread.sleep(2000);
		WebClickUsingActions("//li[text()='"+testdatamap.get("MainBiller").toString()+"']");
		Thread.sleep(1000);
		this.takeScreenShot();
	}
	//Function Summary : Method to selectRadiobtn
	//Parameter Summary: Radiobutton
	public void selectRadiobtn(Map<Object, Object> testdatamap) {
		String ele = testdatamap.get("Radiobutton").toString();
		if(ele.equalsIgnoreCase("individual"))
		{
			WebClick(EdaatOR.Admin_system_subBlr_indiv);
		}
		else
		{
			WebClick(EdaatOR.Admin_system_subBlr_Corp);
		}
	}
	//Function Summary : Method to ClickonSearchBtn
	//Parameter Summary: N/A
	public void ClickonSearchBtn() {
		WebClick(EdaatOR.Admin_system_subBlr_srcbtn);
	}
	//Function Summary : Method to EnterSearchitem
	//Parameter Summary: MainBiller
	public void verifySubBillerSearch(Map<Object, Object> testdatamap,Log Log)
	{
		try {
		EnterSearchitem(testdatamap);
		selectRadiobtn(testdatamap);
		ClickonSearchBtn();
		Thread.sleep(3000);
		this.takeScreenShot();
		Thread.sleep(1000);
		VerifyValue1(getText("//td[text()='"+testdatamap.get("MainBiller").toString()+"']"),testdatamap.get("MainBiller").toString());
		Thread.sleep(1000);
		test.log(Status.PASS,"#FUNC-SubBiller Search" + driver.getTitle() +" * SubBiller Search functionality PASS* ");
		Log.ReportEvent("PASS", " Verify the SubBiller Search functionality is Suceessful");

		}
		catch (Exception e) {
		test.log(Status.FAIL,"#FUNC-SubBiller Search" + driver.getTitle() +" * SubBiller Search functionality FAIL* " );
		}
	}
	//Function Summary : Method to SubBillerAccount
	//Parameter Summary: N/A
    public void SubBillerAccount(Log Log)
    {
       try {
    	WebClick(EdaatOR.Admin_system_subBlr_Edit);
    	switchToWindow();
    	verifyElementIsPresent(EdaatOR.Admin_system_subBlr_Edit_verif);
		test.log(Status.PASS,"#FUNC-SubBillerAccount" + driver.getTitle() +" * SubBillerAccount Edit button is Pass* " );
		this.takeScreenShot();
		Log.ReportEvent("PASS", " Verify Edit button for SubBiller Account is Suceessful");

       }
       catch(Exception e){
			test.log(Status.FAIL,"#FUNC-SubBillerAccount" + driver.getTitle() +" * SubBillerAccount Edit button is FAIL * " );
			this.takeScreenShot();
       }
    }
    //Function Summary  : Method to verify  sub biller management grid view
	//Parameter Summary : MainBiller 
    public void VerifyGridView(Map<Object,Object> testdatamap,Log Log)
    {
       try {
   		selectDropdownValue_PartialText(EdaatOR.Admin_system_subBlr_MainBiller, testdatamap.get("MainBiller").toString());
   		WebClick(EdaatOR.Admin_system_subBlr_SearchBtn);
		Thread.sleep(600);
        verifyElementIsNotPresent(EdaatOR.Admin_system_subBlr_Grid);
   		test.log(Status.PASS,"#FUNC-SubBiller  " + driver.getTitle() +" * SubBiller Grid View is Pass* " );
    	this.takeScreenShot();
		Log.ReportEvent("PASS", " Verify Sub biller Grid View is Sucessful");
	
       }
       catch(Exception e){
			test.log(Status.FAIL,"#FUNC-SubBiller " + driver.getTitle() +" * SubBiller  Grid View is FAIL * " );
			this.takeScreenShot();
       }
    }
}