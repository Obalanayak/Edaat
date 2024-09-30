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

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class AdminSystemMgmBillersCategoriesMngpage extends BasePage {

	public AdminSystemMgmBillersCategoriesMngpage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Admin_BillerCategory)
	public WebElement BillerCategory;

	public boolean Exists() {
		return super.Exists(BillerCategory);
		
	}
	//Function Summary  : Method to NavigateBillerCategoriesManagement
	//Parameter Summary : N/A
	public void NavigateBillerCategoriesManagement(Log Log)
	{
		WebClickUsingJS(EdaatOR.Admin_SystmMng_BillerCategory);
		this.takeScreenShot();
    	Log.ReportEvent("PASS", "Navigate to Biller categories Management page");

	}
	
	 //Function Summary  : Method to EnterSearchItem
	 //Parameter Summary : BillerCategoryName
		public void EnterSearchItem(String BillerCategoryName) throws InterruptedException
		{
			WebEdit(EdaatOR.Admin_SystmMng_BillerCategorysrcfield,BillerCategoryName);
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_SystmMng_BillerCategorysrcbtn);
			this.takeScreenShot();
			Thread.sleep(1000);
		}
	//Function Summary  : Method to AddBillerCategory
	//Parameter Summary : BillerCategoryNameAR,BillerCategoryNameEN
	public void AddBillerCategory(Map<Object, Object> testdatamap) throws InterruptedException {
			try
			{
			WebClick(EdaatOR.Admin_SystmMng_BillerCategoryaddbtn);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_SystmMng_BillerCategoryARfield,testdatamap.get("BillerCategoryNameAR").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_SystmMng_BillerCategoryENfield,testdatamap.get("BillerCategoryNameEN").toString());
			Thread.sleep(1000);
			this.takeScreenShot();
			WebClick(EdaatOR.Admin_SystmMng_BillerCategorySavebtn);
			Thread.sleep(1000);
			}
			catch (Exception e) {
				
				e.printStackTrace();
				this.takeScreenShot();
			}

		}
	//Function Summary  : Method to VerifytheBillerCategorySearch
	//Parameter Summary : BillerCategoryName
	public void VerifytheBillerCategorySearch(Map<Object, Object> testdatamap,Log Log)
	{
		try
		{
			EnterSearchItem(testdatamap.get("BillerCategoryName").toString());
			if(CheckElementExists(EdaatOR.Admin_SystmMng_BillerCategoryNodata)==true)
			{
				AddBillerCategory(testdatamap);
				EnterSearchItem(testdatamap.get("BillerCategoryName").toString());
			}
			VerifyValue1(getText("//td[text()='"+testdatamap.get("BillerCategoryName").toString()+"']"),testdatamap.get("BillerCategoryName").toString());
			this.takeScreenShot();
			Thread.sleep(1000);
		 test.log(Status.PASS,"#FUNC-Verify search Functionality" + driver.getTitle() +" * Biller Categories Management PASS * " );
     	Log.ReportEvent("PASS", "Verify the Search Biller category functionality is Suceessful");

		}
		catch (Exception e) {
		test.log(Status.FAIL,"#FUNC-Verify search Functionality" + driver.getTitle() +" *  Biller Categories Management FAIL * " );
		}
	}
	//Function Summary  : Method to View Biller Category
	//Parameter Summary : BillerCategoryNameEN
	public void VerifytheBillerCategoryView(Map<Object, Object> testdatamap,Log Log)
	{
		try
		{
			NavigateBillerCategoriesManagement(Log);
			Thread.sleep(1000);
			VerifytheBillerCategorySearch(testdatamap,Log);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR. Admin_BillerCategoryViewBTN);
			Thread.sleep(2000);
			this.takeScreenShot();
			verifyElementIsPresent("//input[@value='"+testdatamap.get("BillerCategoryNameEN").toString()+"']");
		    Thread.sleep(1000);
		 test.log(Status.PASS,"#FUNC-Verify to View Biller Category button" + driver.getTitle() +" * View Biller Category button PASS * " );
		}
		catch (Exception e) {
		test.log(Status.FAIL,"#FUNC-Verify to View Biller Category button" + driver.getTitle() +" *  View Biller Category buttont FAIL * " );
		this.takeScreenShot();
		}
		
	
	}

	//Function Summary  : Method to VerifytheBillerCategorySearch
		//Parameter Summary : BillerCategoryName
		public void VerifyBillerCategoryAddSearch(Map<Object, Object> testdatamap,Log Log)
		{
			try
			{
				AddBillerCategory(testdatamap);
				Thread.sleep(1000);
				EnterSearchItem(testdatamap.get("BillerCategoryName").toString());
				VerifyValue1(getText("//td[text()='"+testdatamap.get("BillerCategoryName").toString()+"']"),testdatamap.get("BillerCategoryName").toString());
				this.takeScreenShot();
				Thread.sleep(1000);
			    test.log(Status.PASS,"#FUNC-Verify add and search Functionality" + driver.getTitle() +" * Biller Categories Management PASS * " );
	        	Log.ReportEvent("PASS", " Verify Super biller report is succesfull");

			}
			catch (Exception e) {
			test.log(Status.FAIL,"#FUNC-Verify add and search Functionality" + driver.getTitle() +" *  Biller Categories Management FAIL * " );
			}
		}
		//Function Summary :Method to Verify grid view of Biller Categories Management module. 
		//Parameter Summary: N/A.				  
		public void VerifyGridView(Log Log) {

			try {
				NavigateBillerCategoriesManagement(Log);
				Thread.sleep(1000);
				verifyElementIsPresent(EdaatOR.Admin_SystmMng_BillerCategoryNameAr);		       
				verifyElementIsPresent(EdaatOR.Admin_SystmMng_BillerCategoryNameEng);		       
				Thread.sleep(2000);
				this.takeScreenShot();
				test.log(Status.PASS,"#FUNC-Verify gridview is successful" + driver.getTitle() +" * Biller Categories Management PASS * " );	
	        	Log.ReportEvent("PASS", " Verify Individual Client GridView is Suceessfull");
	
			}
				catch(Exception e){
				test.log(Status.FAIL,"#FUNC-Verify gridview is Failed" + driver.getTitle() +" * Biller Categories Management FAIL * " );
				this.takeScreenShot();
				}				
	}



					//Function Summary  : Method to Verify the Biller Category Edit 
					//Parameter Summary : BillerCategoryName,BillerCategoryName,BillerCategoryNameAREdit,BillerCategoryNameENEdit
					public void verifyEditBillerCategory(Map<Object, Object> testdatamap,Log Log) {
						try
						{
							EnterSearchItem(testdatamap.get("BillerCategoryName").toString());
							if(CheckElementExists(EdaatOR.Admin_SystmMng_BillerCategoryNodata)==true)
							{
								AddBillerCategory(testdatamap);
								EnterSearchItem(testdatamap.get("BillerCategoryName").toString());
							}
							WebClick(EdaatOR.Admin_SystmMng_BillerCategoryEditBtn);
							Thread.sleep(1000);
							WebEdit(EdaatOR.Admin_SystmMng_BillerEditCategoryARfield,testdatamap.get("BillerCategoryNameAREdit").toString());
							Thread.sleep(1000);
							WebEdit(EdaatOR.Admin_SystmMng_BillerEditCategoryENfield,testdatamap.get("BillerCategoryNameENEdit").toString());
							Thread.sleep(1000);
							WebClick(EdaatOR.Admin_SystmMng_BillerEditCategorySaveBtn);
							Thread.sleep(1000);
							EnterSearchItem(testdatamap.get("BillerCategoryNameENEdit").toString());
							Thread.sleep(1000);
							VerifyValue1(getText("//td[text()='"+testdatamap.get("BillerCategoryNameENEdit").toString()+"']"),testdatamap.get("BillerCategoryNameENEdit").toString());
							Thread.sleep(1000);
							this.takeScreenShot();
							test.log(Status.PASS,"#FUNC-Edit Category button" + driver.getTitle() +" * Verify Edit Category button is PASS * " );
				        	Log.ReportEvent("PASS", " Verify Edit Category button is Successful"); 

						}
						catch (Exception e) {
							test.log(Status.FAIL,"#FUNC-Edit Category button" + driver.getTitle() +" * Verify Edit Category button is FAIL * " );
						}
						
					}
		//Function Summary  : Method to VerifyBillerCategoryAddErrorMsg
		//Parameter Summary : Expected		
		public void VerifyBillerCategoryAddErrorMsg(Map<Object, Object> testdatamap) {
			
			try
			{
				AddBillerCategory(testdatamap);
				if(ExistsCheck(EdaatOR.Admin_SystmMng_BillerCategoryARErrorMsg)&&ExistsCheck(EdaatOR.Admin_SystmMng_BillerCategoryEngErrorMsg))
				{
					VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Admin_SystmMng_BillerCategoryARErrorMsg);
					Thread.sleep(1000);
					VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Admin_SystmMng_BillerCategoryEngErrorMsg);
					this.takeScreenShot();
					Thread.sleep(1000);
					test.log(Status.PASS, "#FUNC-BillerCatEng,BillerCatAr ErrorMessage Exists" + driver.getTitle() + " * BillerCatEng,BillerCatAr ErrorMessage Exists * ");
				}
				else if (ExistsCheck(EdaatOR.Admin_SystmMng_BillerCategoryARErrorMsg)) {
					VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Admin_SystmMng_BillerCategoryARErrorMsg);
					this.takeScreenShot();
					Thread.sleep(1000);	
					test.log(Status.PASS, "#FUNC-BillerCatAr Invalid ErrorMessage Exists" + driver.getTitle() + " * BillerCatArInvalid ErrorMessage Exists * ");
			    }
				else {
					test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
				}
			}
			catch (Exception e) {
			
				test.log(Status.FAIL, "#FUNC- Add Biller Category " + driver.getTitle() + " * Add Biller Category FAIL * ");
				this.takeScreenShot();
			}	
		
		}
					
					
}