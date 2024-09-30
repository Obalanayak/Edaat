/**
*
* Test Script Name                   :N/A
* Objective                          :Admin SystemManagement functionality
* Version                            :1.0
* Author                             :Kathirvelu Mohan
* Created Date                       :8/09/2023
* Last Updated on                    :N/A
* Updated By                         :Dhruva Kumar S
* Pre-Conditions                     :N/A
* Epic Details                       :N/A
* User Story Details                 :N/A
**/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.io.File;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

public class AdminSystemMangement extends BasePage {

	public AdminSystemMangement(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Systemmgmt_Menu)
	public WebElement Client;

	public boolean Exists() {
		return super.Exists(Client);
	}
//Function Summary  :To search tax and verify it on grid view.
//Parameter Summary : Category.	
	public void TableGridviewTax(String Category,Log Log){
	     try{
	     	if(CheckElementExists(EdaatOR.Admin_taxTable)==true) {
	 			Thread.sleep(2000);
	 			WebClear(EdaatOR.Admin_TaxSearch);
	 			WebEdit(EdaatOR.Admin_TaxSearch,Category);        			
	 			WebClick(EdaatOR.Admin_SearchCat);
	 			this.takeScreenShot();
	 			Thread.sleep(2000);
	 			test.log(Status.PASS,"#FUNC-Corporate Client Table Exists" + driver.getTitle() +" * Corporatee Client Table Exists PASS * " );
	        	Log.ReportEvent("PASS", "Verify Tax Grid view is Dispalyed Suceessfully");

	     	}       		
	     	else {
	     		test.log(Status.FAIL,"#FUNC-Corporate Client Table Not Exists" + driver.getTitle() +" * Corporate Client Table Not Exists FAIL * " );
	     		}
	     }catch(Exception e){
	     	test.log(Status.FAIL,"#FUNC-Table View Corporate client" + driver.getTitle() +" * Table View Corporate client FAIL * " );
	         this.takeScreenShot();
	     }
	 }
//Function Summary  : Navigate to product categories
//Parameter Summary : N/A.
	public void navigateSystemMangementCategory(Log Log) throws Exception {
		WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_Prod_Category);
		Thread.sleep(2000);
    	Log.ReportEvent("PASS", "Verify Admin Product Management is Page dispayed Suceessfull");

	}
	//Function Summary   : Method to navigate to product category 
	//Parameter Summary  : N/A
	public void navigateSystemMangement(Log Log) throws Exception {
		WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_Prod_Category);
		Thread.sleep(2000);
    	Log.ReportEvent("PASS", "Verify Product Management is Page dispayed Suceessfull");

	}
	//Function Summary   : Method to navigate to Tax management page 
	//Parameter Summary : N/A
	public void navigateSystemMangementTax(Log Log) throws Exception {
		WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_Tax_Mgmt);
		Thread.sleep(2000);
    	Log.ReportEvent("PASS", "Verify Taxes Management is Page dispayed Suceessfull");

	}
	//Function Summary  : //To Search a Tax, activate and deactivate toggle
	//Parameter Summary : Enter TaxEnglish and searchstr.
	public void ActivateDactivate(Map<Object, Object>testdatamap,Log Log){
		String searchstr=testdatamap.get("TaxEnglish").toString();
		try{	
		WebEdit(EdaatOR.Admin_TaxEng,searchstr);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Tax_Search);
			if(CheckElementExists(EdaatOR.Admin_Tax_Nodata)==true) {
				addTaxdeatails();
				Thread.sleep(1000);
				WebEdit(EdaatOR.Admin_Prod_CatEng,testdatamap.get("TaxEnglish").toString());  
				Thread.sleep(1000);
				WebEdit(EdaatOR.Admin_taxArabic,testdatamap.get("TaxArabic").toString());
				Thread.sleep(1000);
				WebEdit(EdaatOR.Admin_Prod_Ref,testdatamap.get("RefCode").toString());
				Thread.sleep(1000);
				WebEdit(EdaatOR.Admin_PercentageValue,testdatamap.get("Percentage").toString());
				Thread.sleep(1000);
				if(testdatamap.get("Activate").toString().equalsIgnoreCase("yes")) {
					WebClickUsingJS(EdaatOR.Admin_Status);
				}
				this.takeScreenShot();
				WebClickUsingJS(EdaatOR.Admin_Add_tax);
				WebEdit(EdaatOR.Admin_TaxEng,searchstr);
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Admin_Tax_Search);
				Thread.sleep(1000);
			}
				ExistsCheck("//td[text()='"+searchstr+"']");
				verifyElementIsPresent(EdaatOR.Admin_Tax_ToggleBtn);
				WebClickUsingJS(EdaatOR.Admin_Tax_ToggleBtn);
				Thread.sleep(1000);
				this.takeScreenShot();
				VerifyValue1(getText(EdaatOR.Admin_Compan_ActivePop), testdatamap.get("Active").toString());
				WebClickUsingJS(EdaatOR.Admin_Compan_ActiveConfbtn);
				Thread.sleep(2000);
				this.takeScreenShot();
				WebClickUsingJS(EdaatOR.Admin_Tax_ToggleBtn);
				Thread.sleep(1000);
				this.takeScreenShot();
				VerifyValue1(getText(EdaatOR.Admin_Compan_ActivePop), testdatamap.get("InActive").toString());
				WebClickUsingJS(EdaatOR.Admin_Compan_ActiveConfbtn);
				Thread.sleep(2000);		
				test.log(Status.PASS,"#FUNC-Tax Deactivate/Activate Done" + driver.getTitle() +" * Tax Deactivate/Activate Done PASS * " );   					
	        	Log.ReportEvent("PASS", "Verify Taxes Management Activate/De-Activate functionality Is Suceessful");

		}catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Tax Deactivate/Activate Not Done" + driver.getTitle() +" * Tax Corporate client Not Done * " );
			this.takeScreenShot();
		}
	}

	public void Toggle(String view,String tog) {
		try {

			boolean Ele = Toggleview(view,tog);
			if (Ele == true)
				test.log(Status.PASS,"#FUNC-Toggle Click" + driver.getTitle() + " * Toggle Click  PASS * ");
			else
				test.log(Status.FAIL,"#FUNC-Toggle Click" + driver.getTitle() + " * Toggle Click FAIL * ");
		} catch (Exception e) {
			test.log(Status.FAIL, "#FUNC-Toggle Click" + driver.getTitle() + " * Toggle Click FAIL * ");
			this.takeScreenShot();
		}
	}
	//Function Summary   : Method to TableGridview
	//Parameter Summary  : Category
	public void TableGridview(String Category,Log Log){
		try{
			if(CheckElementExists(EdaatOR.Admin_CatTable)==true) {
				Thread.sleep(2000);
				WebClear(EdaatOR.Admin_UpdateSearch);
				WebEdit(EdaatOR.Admin_UpdateSearch,Category);        			
				WebClick(EdaatOR.Admin_SearchCat);
				this.takeScreenShot();
				test.log(Status.PASS,"#FUNC-Corporate Client Table Exists" + driver.getTitle() +" * Corporatee Client Table Exists PASS * " );
	        	Log.ReportEvent("PASS", "Verify Admin product Category Grid view is Suceessful");

			}       		
			else {
				test.log(Status.FAIL,"#FUNC-Corporate Client Table Not Exists" + driver.getTitle() +" * Corporate Client Table Not Exists FAIL * " );
			}
		}catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Table View Corporate client" + driver.getTitle() +" * Table View Corporate client FAIL * " );
			this.takeScreenShot();
		}
	}




	public boolean Toggleview(String view,String tog) {
		boolean existsNID = false;
		try {
			WebClickUsingJS(EdaatOR.Systemmgmt_Menu);
			Thread.sleep(1000);
			WebClickUsingJS(view);
			Thread.sleep(1000);
			this.takeScreenShot();
			if (ExistsCheck(tog) == true) {
				WebClickUsingJS(tog);
				WebClickUsingJS(EdaatOR.Biller_Individualclient_button);
				Thread.sleep(1000);
				this.takeScreenShot();
				WebClickUsingJS(tog);
				WebClickUsingJS(EdaatOR.Biller_Individualclient_button);
				existsNID = true;
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			this.takeScreenShot();
		}
		return existsNID;
	}
	//Function Summary   : Method to update the product category 
	//Parameter Summary : N/A
	public void UpdateCategoryDetails(Map<Object,Object> testdatamap,Log Log){
		try{

			boolean Ele=UpdateCategory(testdatamap);
			if(Ele==true)
			{
				test.log(Status.PASS,"#FUNC-Updated  Category Passed " + driver.getTitle() +" * Updated Category PASS * " );
        	Log.ReportEvent("PASS", "Verify Product Management Edit category functionality Is Suceessful");
			}
			else
				test.log(Status.FAIL,"#FUNC-Updated Category Failed" + driver.getTitle() +" * Updated Category FAIL * " );
		}catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Updated Category Failed" + driver.getTitle() +" * Updated Category FAIL * " );
			this.takeScreenShot();
		}
	}
//Function Summary  : To add and update category.
//Parameter Summary : Enter ProdEnglish,UpdateProdEnglish,UpdateProdArabic and UpdateProdEnglish
	public boolean UpdateCategory(Map<Object,Object> testdatamap){
		boolean existsNID = false;
		try{
			Addcat(testdatamap);
			WebEdit(EdaatOR.Admin_UpdateSearch,testdatamap.get("ProdEnglish").toString());
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Search);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Updatebtn);	
			Thread.sleep(1000);
			WebClear(EdaatOR.Admin_Prod_CatEng);
			WebEdit(EdaatOR.Admin_Prod_CatEng,testdatamap.get("UpdateProdEnglish").toString());
			Thread.sleep(1000);
			WebClear(EdaatOR.Admin_Prod_CatArabic);
			WebEdit(EdaatOR.Admin_Prod_CatArabic,testdatamap.get("UpdateProdArabic").toString());
			this.takeScreenShot();
			WebClickUsingJS(EdaatOR.Admin_UpdateCat);
			WebEdit(EdaatOR.Admin_UpdateSearch,testdatamap.get("UpdateProdEnglish").toString());
		    Thread.sleep(1000);
			this.takeScreenShot();
			WebClickUsingJS(EdaatOR.Admin_Search);
			VerifyValue1(getText("//td[text()='"+testdatamap.get("UpdateProdEnglish").toString()+"']"),testdatamap.get("UpdateProdEnglish").toString());
			existsNID=true;
		}catch (Exception e) {
			e.printStackTrace();
			this.takeScreenShot();
		}
		return existsNID;
	}
	
	//Function Summary  : Method to click on Add category
	//Parameter Summary : N/A
	public void addCategoryDetails() throws Exception {
		ClickOnProductBtn();
		Thread.sleep(500);
	}
//Function Summary  : To click on add button.
//Parameter Summary : N/A.
	public void ClickOnProductBtn() {
		WebClickUsingJS(EdaatOR.Admin_Cat_Addbtn);
		waitForPageToLoad();
	}
	//Function Summary   :To click on Add tax button
    //Parameter Summary  :N/A
	public void addTaxdeatails() throws Exception {
		ClickOnTaxBtn();
		Thread.sleep(500);
	}
	public void ClickOnTaxBtn() {
		WebClickUsingJS(EdaatOR.Admin_Tax_Addbtn);
		waitForPageToLoad();
	}

	//Function Summary  : Method to Add product category
	//Parameter Summary : Product name
	public boolean Addcat(Map<Object,Object> testdatamap){
		boolean existsNID = false;
		try{
			addCategoryDetails();
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Prod_CatEng,testdatamap.get("ProdEnglish").toString());  
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Prod_CatArabic,testdatamap.get("ProdArabic").toString());
			Thread.sleep(1000);
			this.takeScreenShot();
			WebClickUsingJS(EdaatOR.Admin_Add_Cat);
			existsNID=true;
		}catch (Exception e) {
			e.printStackTrace();
			this.takeScreenShot();
		}
		return existsNID;
	}
	//Function Summary   : To Add a tax
    //Parameter Summary  :Enter TaxEnglish,TaxArabic,RefCode and Percentage
	public void AddTax(Map<Object,Object> testdatamap,Log Log){
		
		try{
			addTaxdeatails();
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Prod_CatEng,testdatamap.get("TaxEnglish").toString());  
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_taxArabic,testdatamap.get("TaxArabic").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Prod_Ref,testdatamap.get("RefCode").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_PercentageValue,testdatamap.get("Percentage").toString());
			Thread.sleep(1000);
			if(testdatamap.get("Activate").toString().equalsIgnoreCase("yes")) {
				WebClickUsingJS(EdaatOR.Admin_Status);
			}
			this.takeScreenShot();
			WebClickUsingJS(EdaatOR.Admin_Add_tax);
	        WebEdit(EdaatOR.Admin_TaxEng,testdatamap.get("TaxEnglish").toString());
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Tax_Search);
			this.takeScreenShot();
			Thread.sleep(1000);
			VerifyValue1(getText("//td[text()='"+testdatamap.get("TaxEnglish").toString()+"']"),testdatamap.get("TaxEnglish").toString());
			Thread.sleep(1000);
        	Log.ReportEvent("PASS", "Verify Taxes Management Add Tax functionality Is Suceessfull"); 

		}catch (Exception e) {
			e.printStackTrace();
			this.takeScreenShot();
		}
	}
//Function Summary  : To add category
//Parameter Summary : NA.
	public void AddCategory(Map<Object,Object> testdatamap,Log Log){
		boolean cat=false;
		try{
			if(Addcat(testdatamap)==true) {
	           WebEdit(EdaatOR.Admin_Prod_CatEnglish,testdatamap.get("ProdEnglish").toString());
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Biller_Subbiller_Search);
				this.takeScreenShot();
				VerifyValue1(getText("//td[text()='"+testdatamap.get("ProdEnglish").toString()+"']"),testdatamap.get("ProdEnglish").toString());
				test.log(Status.PASS,"#FUNC-Add Category is Successful" + driver.getTitle() +" * Add Category is Successful PASS * " );
				//test.log(Status.PASS,"#FUNC-Add Category is Successful" + driver.getTitle() +" * Add Category is Successful PASS * " );
		    	Log.ReportEvent("PASS", "Verify Product Management Add Category functionality Is Suceessful");

			}else {
				test.log(Status.FAIL,"#FUNC-Add Category is not Successful" + driver.getTitle() +" * Add Category is not Successful FAIL * " );
			}
		}catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Add Category is not Successful" + driver.getTitle() +" * Add Category is not Successful FAIL * " );
			this.takeScreenShot();
		}
	}

	//Function Summary  : Method to Search product category and verify it exists
	//Parameter Summary : Product category
	public boolean SearchCategory(Map<Object,Object> testdatamap,Log Log){
		boolean existsElement = false;
		String searchstr=testdatamap.get("ProdEnglish").toString();
		try{
			WebEdit(EdaatOR.Admin_Prod_CatEnglish,searchstr);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Prod_CatSrch);
			this.takeScreenShot();
		//	existsElement=ExistsCheck("//td[text()='"+searchstr+"']");
        if(CheckElementExists(EdaatOR.Admin_Prod_Nodata)==true)
			{
				addCategoryDetails();
				Addcat(testdatamap);
				WebEdit(EdaatOR.Admin_Prod_CatEnglish,searchstr);
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Admin_Prod_CatSrch);
				Thread.sleep(1000);
			}
			VerifyValue1(getText("//td[text()='"+testdatamap.get("ProdEnglish").toString()+"']"),testdatamap.get("ProdEnglish").toString());
			this.takeScreenShot();
			existsElement=ExistsCheck("//td[text()='"+searchstr+"']");
			this.takeScreenShot();
			Thread.sleep(1000);
			if(existsElement==true) {
				test.log(Status.PASS,"#FUNC-Searched Category is Found" + driver.getTitle() +" * Searched Category is Found PASS * " );
	        	Log.ReportEvent("PASS", "Verify Product Management Search Category functionality Is Suceessfull");

			}else {
				test.log(Status.FAIL,"#FUNC-Searched Category is Not Found" + driver.getTitle() +" * Searched Category is Not Found  FAIL* " );

			}
		}catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Searched Category is not Successful" + driver.getTitle() +" * Searched Category is not Successful FAIL * " );
			this.takeScreenShot();
		}
		return existsElement;
	}

	//Function Summary   : Method to navigate  to "Not approved billers management"
	//Parameter Summary : N/A
		public void navigateNotApprovedBillerManagement(Log Log) throws Exception {
		WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Admin_Sytemmanagement_Billers_Management);
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Admin_NoAppBillerMangm);
		Thread.sleep(2000);
		Log.ReportEvent("PASS", "Naviagate to Not approved Biller Management ");

	}
	//Function Summary   : Method to navigateBillersUnderActivation
	//Parameter Summary  : N/A

	public void navigateBillersUnderActivation(Map<Object, Object> testdatamap,Log Log) throws Exception {
		WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_Sytemmanagement_Billers_Management);
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Admin_ApproveBillerMangm);
		Thread.sleep(2000);
	    searchforapprbiller(testdatamap);
		Thread.sleep(2000);
	}
	
	//Function Summary   : Method to navigateApprovedBillerManagement
		//Parameter Summary  : N/A
		public void navigateApprovedBillerManagement(Map<Object, Object> testdatamap,Log Log) throws Exception {
			WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_ApproveBillerMangm);
			Thread.sleep(2000);
		    searchforapprbiller(testdatamap);
			Thread.sleep(2000);
		}
	//Function Summary   : Method to searchforapprbiller
	//Parameter Summary  : CompanyName
	public void searchforapprbiller(Map<Object, Object> testdatamap) throws InterruptedException 
	{
		enterOnSearchItem(testdatamap.get("CompanyName").toString());
		clickOnSearchBtn();
		waitForPageToLoad();
		Thread.sleep(1000);
	}
	//Function Summary   : Method to clickOnSearchBtn
	//Parameter Summary  : N/A
	public void clickOnSearchBtn() {
		WebClick(EdaatOR.Admin_SystemMgm_Searchbtn);
		}
	//Function Summary   : Method to enterOnSearchItem
	//Parameter Summary  : searchItem
	public void enterOnSearchItem(String searchItem) {
		WebEdit(EdaatOR.Admin_SystemMgm_SearchItem, searchItem);
	}

	//Function Summary   : Method to  navigateTrackerBillerManagement
	//Parameter Summary  : N/A
	public void navigateTrackerBillerManagement(Log Log) throws Exception {
		WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_TrackerBillerMangm);
		Thread.sleep(2000);
		Log.ReportEvent("PASS", "Naviagate to Tracked Billers Management ");

	}
	
	//Function Summary   : Method to search tax and verify tax is displayed
	//Parameter Summary : TaxEnglish.
	public boolean SearchTaxes(Map<Object,Object> testdatamap,Log Log){
		boolean existsElement = false;
		String searchstr=testdatamap.get("TaxEnglish").toString();
		try{
			WebEdit(EdaatOR.Admin_TaxEng,searchstr);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Tax_Search);
			this.takeScreenShot();
	if(CheckElementExists(EdaatOR.Admin_Tax_Nodata)==true)
			{
				addTaxdeatails();
				Thread.sleep(1000);
				WebEdit(EdaatOR.Admin_Prod_CatEng,testdatamap.get("TaxEnglish").toString());  
				Thread.sleep(1000);
				WebEdit(EdaatOR.Admin_taxArabic,testdatamap.get("TaxArabic").toString());
				Thread.sleep(1000);
				WebEdit(EdaatOR.Admin_Prod_Ref,testdatamap.get("RefCode").toString());
				Thread.sleep(1000);
				WebEdit(EdaatOR.Admin_PercentageValue,testdatamap.get("Percentage").toString());
				Thread.sleep(1000);
				if(testdatamap.get("Activate").toString().equalsIgnoreCase("yes")) {
					WebClickUsingJS(EdaatOR.Admin_Status);
				}
				this.takeScreenShot();
				WebClickUsingJS(EdaatOR.Admin_Add_tax);
				WebEdit(EdaatOR.Admin_TaxEng,searchstr);
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Admin_Tax_Search);
				Thread.sleep(1000);
			}
			existsElement=ExistsCheck("//td[text()='"+searchstr+"']");
			this.takeScreenShot();
			VerifyValue1(getText("//td[text()='"+testdatamap.get("TaxEnglish").toString()+"']"),testdatamap.get("TaxEnglish").toString());
			Thread.sleep(1000);
			if(existsElement==true) {
				test.log(Status.PASS,"#FUNC-Searched Tax is Found" + driver.getTitle()+ " * Searched Tax is Found PASS * " );
	        	Log.ReportEvent("PASS", "Verify Taxes Management Search functionality Is Suceessful");

			}else {
				test.log(Status.FAIL,"#FUNC-Searched Tax is Not Found" + driver.getTitle() +" * Searched Tax is Not Found  FAIL* " );

			}
		}catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Searched Tax is not Successful" + driver.getTitle() +" * Searched Tax is not Successful FAIL * " );
			this.takeScreenShot();
		}
		return existsElement;
	}
	//Function Summary   : Method to Verify AddTaxErrorValidation
	//Parameter Summary : TaxEnglish,TaxArabic,RefCode,Percentage,Activate
	public void AddTaxErrorValidation(Map<Object,Object> testdatamap)
	{
		try {
			addTaxdeatails();
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Prod_CatEng,testdatamap.get("TaxEnglish").toString());  
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_taxArabic,testdatamap.get("TaxArabic").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Prod_Ref,testdatamap.get("RefCode").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_PercentageValue,testdatamap.get("Percentage").toString());
			Thread.sleep(1000);
			if(testdatamap.get("Activate").toString().equalsIgnoreCase("yes")) {
				WebClickUsingJS(EdaatOR.Admin_Status);
			}
			this.takeScreenShot();
			WebClickUsingJS(EdaatOR.Admin_Add_tax);
			test.log(Status.PASS,"#FUNC-Add Tax functionality" + driver.getTitle()+ " * Add Tax is Successfull PASS * " );

		}
		catch (Exception e) {
			test.log(Status.FAIL,"#FUNC-Add Tax functionality" + driver.getTitle()+ " * Add Tax is UnSuccessfull FAIL * " );
		}
	}
	//Function Summary   : Method to search tax and verify tax is displayed
	//Parameter Summary : Expected
	public void AddTaxErrorMsg(Map<Object, Object> testdatamap) {
		
		try {
			AddTaxErrorValidation(testdatamap);
			if(ExistsCheck(EdaatOR.Admin_Tax_TaxEngError)&&ExistsCheck(EdaatOR.Admin_Tax_TaxArbError)
			&&ExistsCheck(EdaatOR.Admin_Tax_RefcodeError)&&ExistsCheck(EdaatOR.Admin_Tax_PercenError))
			{
				VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Admin_Tax_TaxEngError);
				Thread.sleep(1000);
				VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Admin_Tax_TaxArbError);
				Thread.sleep(1000);
				VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Admin_Tax_RefcodeError);
				Thread.sleep(1000);
				VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Admin_Tax_PercenError);
				this.takeScreenShot();
				Thread.sleep(1000);
				test.log(Status.PASS, "#FUNC-TaxEnglish,TaxArabic,Refrencecode and Percentage ErrorMessage Exists" + driver.getTitle() + " * TaxEnglish,TaxArabic,Refrencecode and Percentage ErrorMessage Exists * ");
			}
			else if (ExistsCheck(EdaatOR.Admin_Tax_RefcodeExistsError)) {
				VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Admin_Tax_RefcodeExistsError);
				this.takeScreenShot();
				Thread.sleep(1000);
				test.log(Status.PASS, "#FUNC-Refrencecode already in use ErrorMessage Exists" + driver.getTitle() + " * RefrencecodeErrorMessage Exists * ");
				
			}
			else if (ExistsCheck(EdaatOR.Admin_Tax_TaxArbError)) {
				VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Admin_Tax_TaxArbError);
				this.takeScreenShot();
				Thread.sleep(1000);
				test.log(Status.PASS, "#FUNC-TaxEnglish,TaxArabic Invalid ErrorMessage Exists" + driver.getTitle() + " * TaxEnglish,TaxArabic Invalid ErrorMessage Exists * ");

			}
			else
			{
			test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
			}
			
		}
		catch (Exception e) {
			
			test.log(Status.FAIL,"#FUNC-Add Tax functionality" + driver.getTitle()+ " * Add Tax is UnSuccessfull FAIL * " );
			this.takeScreenShot();
		}
	}
	//Function Summary  : Method to AddCategoryErrorMsg
	//Parameter Summary : Expected
	public void AddCategoryErrorMsg(Map<Object, Object> testdatamap) {
		try {
			addCategoryDetails();
			Addcat(testdatamap);
			if(ExistsCheck(EdaatOR.Admin_Prod_CatEngError)&&ExistsCheck(EdaatOR.Admin_Prod_CatArError))
			{
					VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Admin_Prod_CatEngError);
					Thread.sleep(1000);
					VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Admin_Prod_CatArError);
					Thread.sleep(1000);
					this.takeScreenShot();
					test.log(Status.PASS, "#FUNC-ProducCatEng and ProductCatAr ErrorMessage Exists" + driver.getTitle() + " * ProducCatEng and ProductCatAr ErrorMessage Exists * ");
			}			
		} catch (Exception e) {
			test.log(Status.FAIL,"#FUNC-Add Product Category functionality" + driver.getTitle()+ " * Add Product category is UnSuccessfull FAIL * " );
			this.takeScreenShot();
		}
	}
	
	//Function Summary  : Method to navigatePaymentProviderManagement
	//Parameter Summary : N/A
	public void navigatePaymentProviderManagement(Log Log) {
			try {	
			WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Sytemmanagement_PaymentProviders_Management);
			this.takeScreenShot();
			Log.ReportEvent("PASS", "Naviagate to Payment Provider Management ");
			test.log(Status.PASS,"#FUNC-Payment Provider Management Page is Found" + driver.getTitle()+ " * Payment Provider Management Page is Found PASS * " );
			} catch (Exception e) {
				e.printStackTrace();
				test.log(Status.FAIL,"#FUNC-Payment Provider Management Page is not Found" + driver.getTitle()+ " * Payment Provider Management Page is not Found FAIL * " );
				this.takeScreenShot();
			}
	}
	//Function Summary   : Method to ActivatePayment Methods Free activation status toggle
	//Parameter Summary  : PaymentsMethods
	public void VerifyActivatePaymentMethodFreeActivationStatusToggle(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			WebElement ele= driver.findElement(By.xpath("(//a[text()='"+testdatamap.get("PaymentMethods").toString()+"']/parent::td/following-sibling::td//input[contains(@class,'switch makeActive')]/parent::span)[2]"));
            if(ele.isEnabled()==false) {
			WebClick(ele);
			Thread.sleep(500);
			VerifyValue1(getText(EdaatOR.Admin_PaymentMng_FreeActivationPopupMessage), testdatamap.get("ArabicInactive").toString());
			Thread.sleep(500);
			WebClick(EdaatOR.Admin_SystemMng_PaymentMng_FreeActivationYesBtn);
        
			Thread.sleep(500);
			Log.ReportEvent("PASS", "Activated the Payment Methods Free activation status toggle");
			test.log(Status.PASS,"#FUNC-Payment Methods activated" + driver.getTitle()+ " * Payment Methods activated PASS * " );
            }
            }catch(Exception e)	{				
			e.printStackTrace();
			test.log(Status.FAIL,"#FUNC-Payment Methods activated" + driver.getTitle()+ " * Payment Methods activated FAIL * " );
			this.takeScreenShot();
		}
}

	//Function Summary  : Method to verifyPaymentProviderPageIsDisplayed
	//Parameter Summary : Expected
	public void verifyPaymentProviderManagementPageIsDisplayed(Map<Object, Object> testdatamap, Log Log) {
		try {
			VerifyValue1(getText(EdaatOR.Admin_SystemMng_PaymentProviderMng_Page),testdatamap.get("Expected").toString());
			this.takeScreenShot();
			Log.ReportEvent("PASS", "Payment Provider Management Page is Added and Displayed");
			test.log(Status.PASS,"#FUNC-Payment Provider Management Page is Displayed" + driver.getTitle()+ " * Payment Provider Management Page is Displayed PASS * " );	
		} catch (Exception e) {
			test.log(Status.FAIL,"#FUNC-Payment Provider Management Page is not Displayed" + driver.getTitle()+ " * Payment Provider Management Page is not Displayed FAIL * ");
			this.takeScreenShot();
		}	
	}
	
	//Function Summary  : Method to navigatePaymentMethodManagement
	//Parameter Summary : N/A
	public void navigatePaymentMethodManagement(Log Log) {
			try {	
			WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng);
			this.takeScreenShot();
			Log.ReportEvent("PASS", "Naviagate to Payment Method Management ");
			test.log(Status.PASS,"#FUNC-Payment Method Management Page is Found" + driver.getTitle()+ " * Payment Method Management Page is Found PASS * " );
			} catch (Exception e) {
				e.printStackTrace();
				test.log(Status.FAIL,"#FUNC-Payment Method Management Page is not Found" + driver.getTitle()+ " * Payment Method Management Page is not Found FAIL * " );
				this.takeScreenShot();
			}
	}
	//Function Summary  : Method to click on edit button
	//Parameter Summary : PaymentMethod
	public void clickOnEditIconInPaymentMethodMgm(Map<Object, Object> testdatamap) throws InterruptedException {
		Thread.sleep(1000);
		WebClickUsingJS("(//td/a[text()='"+testdatamap.get("PaymentMethod").toString()+"']/../following::td/a[contains(@href,'EditPaymentMethod')])[1]");
		
	}
    //Function Summary  : Method to verifyPaymentMethodManagementGridViewDetails
	//Parameter Summary : EnglishColumn,ArabicColumn,StartDateColumn,EndDateColumn,FeesColumn,StatusColumn,FeesActivationColumn,PaymentProviderColumn,EditPaymentMethodColumn
	public void verifyPaymentMethodManagementGridViewDetails(Map<Object, Object> testdatamap, Log Log) {
		try {
			VerifyValue1(getText(EdaatOR.Admin_SystemMng_PaymentMethodMng_EnglishName_Column),testdatamap.get("EnglishColumn").toString());
			VerifyValue1(getText(EdaatOR.Admin_SystemMng_PaymentMethodMng_ArabicName_Column),testdatamap.get("ArabicColumn").toString());
			VerifyValue1(getText(EdaatOR.Admin_SystemMng_PaymentMethodMng_StartDate_Column),testdatamap.get("StartDateColumn").toString());
			VerifyValue1(getText(EdaatOR.Admin_SystemMng_PaymentMethodMng_EndDate_Column),testdatamap.get("EndDateColumn").toString());
			VerifyValue1(getText(EdaatOR.Admin_SystemMng_PaymentMethodMng_Fees_Column),testdatamap.get("FeesColumn").toString());
			VerifyValue1(getText(EdaatOR.Admin_SystemMng_PaymentMethodMng_Status_Column),testdatamap.get("StatusColumn").toString());
			VerifyValue1(getText(EdaatOR.Admin_SystemMng_PaymentMethodMng_FeesActivation_Column),testdatamap.get("FeesActivationColumn").toString());
			VerifyValue1(getText(EdaatOR.Admin_SystemMng_PaymentMethodMng_PaymentProvider_Column),testdatamap.get("PaymentProviderColumn").toString());
			VerifyValue1(getText(EdaatOR.Admin_SystemMng_PaymentMethodMng_EditPaymentMethod_Column),testdatamap.get("EditPaymentMethodColumn").toString());
			this.takeScreenShot();
			Log.ReportEvent("PASS", "Payment Method Management Verify the Grid view details functionality is successful");
			test.log(Status.PASS,"#FUNC-Payment Method Management Verify the Grid view details functionality is successful" + driver.getTitle()+ " * Payment Method Management Verify the Grid view details functionality is successful PASS * " );	
		} catch (Exception e) {
			test.log(Status.FAIL,"#FUNC-Payment Method Management Verify the Grid view details functionality is unsuccessful" + driver.getTitle()+ " * Payment Method Management Verify the Grid view details functionality is unsuccessful FAIL * " );	
			this.takeScreenShot();
		}	
	}
	
	//Function Summary  : Method to click on save button
	//Parameter Summary : 
	public void clickOnSaveButtonInPaymentMethodMgm() throws InterruptedException {
		Thread.sleep(500);
		WebClick(EdaatOR.Admin_PaymentMethodMngEditFeesSaveButton);
	}
	
	//Function Summary  : Method to enterThePaymentProviderName
	//Parameter Summary : paymentProviderName
	public void enterThePaymentProviderName(String paymentProviderName) {
		WebEdit(EdaatOR.Admin_SystemMng_PaymentProvidersMng_PaymentProvider_efield, paymentProviderName);
	}
	//Function Summary  : Method to verify Edit Fees In Payment Method Page
	//Parameter Summary :PaymentMethod,FixedValue,Percentage
	public void verifyEditFeesInPaymentMethodPage(Map<Object, Object> testdatamap,Log Log) {
			try {	
				clickOnEditIconInPaymentMethodMgm(testdatamap);
				Thread.sleep(1000);
				WebElement ele1=driver.findElement(By.xpath("//label[@for='HasFixedFees']"));
				WebElement ele2=driver.findElement(By.xpath("//label[@for='HasFixedFeesPercentage']"));
				if(!ele1.isSelected()) {	
				WebClick(EdaatOR.Admin_PaymentMethodMngEditFeesFixedValueCheckbox);
				Thread.sleep(500);}
				WebEdit(EdaatOR.Admin_PaymentMethodMngEditFeesFixedValueAmount,testdatamap.get("FixedValue").toString());
				Thread.sleep(500);
                 if(!ele2.isSelected()) {
     				WebClick(EdaatOR.Admin_PaymentMethodMngEditFeesPercentageCheckbox);
                 }
				Thread.sleep(500);
				WebEdit(EdaatOR.Admin_PaymentMethodMngEditFeesPercentageAmount,testdatamap.get("Percentage").toString());	
				clickOnSaveButtonInPaymentMethodMgm();
			this.takeScreenShot();
			Log.ReportEvent("PASS", "verify Edit Fees In Payment Method Page");
			test.log(Status.PASS,"#FUNC-verify Edit Fees In Payment Method Page" + driver.getTitle()+ " * verify Edit Fees In Payment Method Page PASS * " );
			} catch (Exception e) {
				e.printStackTrace();
				test.log(Status.FAIL,"#FUNC-verify Edit Fees In Payment Method Page" + driver.getTitle()+ " * verify Edit Fees In Payment Method Page FAIL * " );
				this.takeScreenShot();
			}
	}
	
    //Function Summary  : Method to enterTheCrnumber
	//Parameter Summary : crNumber
	public void enterTheCrnumber(String crNumber) {
		WebEdit(EdaatOR.Admin_SystemMng_PaymentProvidersMng_Crnumber_efield, crNumber);
	}
		
	//Function Summary  : Method to enterCode
	//Parameter Summary : code
	public void enterCode(String code) {
		WebEdit(EdaatOR.Admin_SystemMng_PaymentProvidersMng_Code_efield, code);
	}
	
	//Function Summary  : Method to enterCode
	//Parameter Summary : code
	public void clickOnSearchButton() {
		WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentProvidersMng_Search_btn);
	}
	
	//Function Summary  : Method to verifyPaymentProvidersManagementGridViewDetails
	//Parameter Summary : EnglishColumn,ArabicColumn,ContactColumn,CRNumberColumn,CodeColumn
	public void verifyPaymentProvidersManagementGridViewDetails(Map<Object, Object> testdatamap, Log Log) {
		try {
			enterThePaymentProviderName(testdatamap.get("PaymentProviderName").toString());
			enterTheCrnumber(testdatamap.get("CRNumber").toString());
			this.takeScreenShot();
			enterCode(testdatamap.get("Code").toString());
			this.takeScreenShot();
			clickOnSearchButton();
			Thread.sleep(3000);
			VerifyValue1(getText("//table//td[text()='"+testdatamap.get("PaymentProviderName").toString()+"']"),testdatamap.get("PaymentProviderName").toString());
			this.takeScreenShot();
			VerifyValue1(getText(EdaatOR.Admin_SystemMng_PaymentProvidersMng_EnglishName_Column),testdatamap.get("EnglishColumn").toString());
			VerifyValue1(getText(EdaatOR.Admin_SystemMng_PaymentProvidersMng_ArabicName_Column),testdatamap.get("ArabicColumn").toString());
			VerifyValue1(getText(EdaatOR.Admin_SystemMng_PaymentProvidersMng_Contact_Column),testdatamap.get("ContactColumn").toString());
			VerifyValue1(getText(EdaatOR.Admin_SystemMng_PaymentProvidersMng_CrNumber_Column),testdatamap.get("CRNumberColumn").toString());
			VerifyValue1(getText(EdaatOR.Admin_SystemMng_PaymentProvidersMng_Code_Column),testdatamap.get("CodeColumn").toString());
			Log.ReportEvent("PASS", "Verify the grid view for the Payment providers Management page functionality is successful");
			test.log(Status.PASS,"#FUNC-Verify the grid view for the Payment providers Management page functionality is successful" + driver.getTitle()+ " * Verify the grid view for the Payment providers Management page functionality is successful PASS * " );	
		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL,"#Verify the grid view for the Payment providers Management page functionality is unsuccessful" + driver.getTitle()+ " * Verify the grid view for the Payment providers Management page functionality is unsuccessful FAIL * " );	
			this.takeScreenShot();
		}
		
	}
	//Function Summary  : Method to clickOnEditPaymentMethod
	//Parameter Summary : PaymentMethodName
	public void clickOnEditPaymentMethod(Map<Object, Object> testdatamap) {
		WebClickUsingJS("//a[text()='"+testdatamap.get("PaymentMethodName").toString()+"']/parent::td/parent::tr//a[contains(@href,'EditPaymentMethod')]");
		this.takeScreenShot();
	}
	
	//Function Summary  : Method to clickOnAddInvoicebtn
	//Parameter Summary : N/A
	public void clickOnAddInvoicebtn() throws InterruptedException {
		WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_AddInvoicebtn);
		Thread.sleep(2000);
		this.takeScreenShot();
	}
	//Function Summary  : Method to clickOnAddTransactionbtn
	//Parameter Summary : N/A
	public void clickOnAddTransactionbtn() throws InterruptedException {
		WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_AddTransactionbtn);
		Thread.sleep(2000);
		this.takeScreenShot();
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
	    this.takeScreenShot();
		EnterToAmount(testdatamap.get("ToAmount").toString());
		clickOnInvoiceFeesFixedValueCheckboxAndEnterValue(testdatamap.get("FixedValue").toString());
		this.takeScreenShot();
		clickOnInvoiceFeesPercentageCheckboxAndEnterValue(testdatamap.get("Percentage").toString());
		clickOnAddInvoiceButton();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Function Summary  : Method to Verify Payment Methods Management Page Is Added
   //Parameter Summary : N/A
	public void VerifyPaymentMethodsManagementPageIsAdded(Log Log)
	{
		try {
			 WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
			 Thread.sleep(1000);
	    	 verifyElementIsPresent(EdaatOR.Admin_SystemMng_PaymentMethodMng);
			 this.takeScreenShot();
		     test.log(Status.PASS,"#FUNC- Verify Payment Methods Management Page Is Added" + driver.getTitle()+ " * Verify Payment Methods Management Page Is Added PASS * " );
	         Log.ReportEvent("PASS", "Verify Payment Methods Management Page Is Added");
  	       }
	
  	    catch (Exception e) {
		test.log(Status.FAIL,"#FUNC- Verify that  a new  checkbox “Customized Transfer Notes” is updatable any time" + driver.getTitle()+ " * Verify that  a new  checkbox “Customized Transfer Notes” is updatable any time FAIL * " );
		this.takeScreenShot();

		}
	}
	
	//Function Summary  : Method to EnterTheTransactionAmountDetails
	//Parameter Summary : N/A
	public void EnterTheTransactionAmountDetails(Map<Object, Object> testdatamap) throws InterruptedException {
		try {
		EnterFromTransaction(testdatamap.get("FromTransaction").toString());
		this.takeScreenShot();
		EnterToTransaction(testdatamap.get("ToTransaction").toString());
		clickOnTransFeesFixedValueCheckboxAndEnterValue(testdatamap.get("TransFixedValue").toString());
		this.takeScreenShot();
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
					this.takeScreenShot();
					WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_SwitchBtwTransToInvoice_Yesbtn);	
					clickOnAddInvoicebtn();
					this.takeScreenShot();
					EnterTheInvoiceAmountDetails(testdatamap);
				}
				else
				{
					clickOnAddInvoicebtn();
					this.takeScreenShot();
					EnterTheInvoiceAmountDetails(testdatamap);
				}
			} 
			else {
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_FeesByTransactionbtn);
				if (CheckElementExists(EdaatOR.Admin_SystemMng_PaymentMethodMng_SwitchBtwInvoiceToTrans)) {
					this.takeScreenShot();
					WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_SwitchBtwInvoiceToTrans_Yesbtn);		
					clickOnAddTransactionbtn();
					this.takeScreenShot();
					EnterTheTransactionAmountDetails(testdatamap);
				}
				else
				{
					clickOnAddTransactionbtn();
					this.takeScreenShot();
					EnterTheTransactionAmountDetails(testdatamap);	
				}
		}
		}
			catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Function Summary  : Method to verify required fields to add fees by transaction count
		//Parameter Summary : PaymentMethod,
		public void verifyRequiredFieldsToAddFeesByTransactionCount(Map<Object, Object> testdatamap,Log Log) {
				try {	
					clickOnEditIconInPaymentMethodMgm(testdatamap);
					Thread.sleep(1000);
					WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_FeesByTransactionbtn);
					if (CheckElementExists(EdaatOR.Admin_SystemMng_PaymentMethodMng_SwitchBtwInvoiceToTrans)) {
						this.takeScreenShot();
						WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_SwitchBtwInvoiceToTrans_Yesbtn);		
						clickOnAddTransactionbtn();
						this.takeScreenShot();
					}
					else
					{
						clickOnAddTransactionbtn();
						this.takeScreenShot();
					}	
					verifyElementIsPresent(EdaatOR.Admin_SystemMng_PaymentMethodMng_Transc_Fromtrans);
					verifyElementIsPresent(EdaatOR.Admin_SystemMng_PaymentMethodMng_Transc_Totrans);
					verifyElementIsPresent(EdaatOR.Admin_SystemMng_PaymentMethodMng_Transc_FixedFees_efield);
					verifyElementIsPresent(EdaatOR.Admin_SystemMng_PaymentMethodMng_Transc_FixedFees_efield);
				this.takeScreenShot();
				Log.ReportEvent("PASS", " Verify to add Fees based on number of transaction in payment method page");
				test.log(Status.PASS,"#FUNC- Verify to add Fees based on number of transaction in payment method page" + driver.getTitle()+ "*PASS * " );
				} catch (Exception e) {
					e.printStackTrace();
					test.log(Status.FAIL,"#FUNC- Verify to add Fees based on number of transaction in payment method page" + driver.getTitle()+ " *FAIL * " );
					this.takeScreenShot();
				}
		}
	//Function Summary  : Method to verifyThePriorityIsForCategoryFees
	//Parameter Summary : N/A
	public void verifyThePriorityIsForCategoryFees(Map<Object, Object> testdatamap, Log Log) throws InterruptedException {
		try {
			clickOnEditPaymentMethod(testdatamap);
			Thread.sleep(2000);
			clickOnRadioButtonAndEnterTheDetails(testdatamap);
			this.takeScreenShot();
			Log.ReportEvent("PASS", "Verify that the  priority is for category fees when  deduction payment method fees functionality is successful");
			test.log(Status.PASS,"#FUNC-Verify that the  priority is for category fees when  deduction payment method fees functionality is successfull" + driver.getTitle()+ " * Verify that the  priority is for category fees when  deduction payment method fees functionality is successfull PASS * " );	
		} catch (Exception e) {
			test.log(Status.FAIL,"#FUNC-Verify that the  priority is for category fees when  deduction payment method fees functionality is Unsuccessfull" + driver.getTitle()+ " * Verify that the  priority is for category fees when  deduction payment method fees functionality is Unsuccessfull FAIL * " );	
		}	
	}
//Function Summary  : Method to change the category from Invoice based to Transaction count and vice versa
		//Parameter Summary : N/A
		public void verifyToChangeTheCategoryFromInvoiceBasedToTransactionCountAndViceVersa(Map<Object, Object> testdatamap,Log Log) {
			try {	
				clickOnEditIconInPaymentMethodMgm(testdatamap);
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_FeesByInvoiceAmount);
				Thread.sleep(1000);
				if (CheckElementExists(EdaatOR.Admin_SystemMng_PaymentMethodMng_SwitchBtwInvoiceToTrans)) {
					this.takeScreenShot();
					verifyElementIsPresent(EdaatOR.Admin_SystemMng_PaymentMethodMng_SwitchBtwInvoiceToTransMessage);
					WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_SwitchBtwInvoiceToTrans_Yesbtn);		

				}
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_FeesByTransactionbtn);
				if (CheckElementExists(EdaatOR.Admin_SystemMng_PaymentMethodMng_SwitchBtwInvoiceToTrans)) {
					this.takeScreenShot();
					verifyElementIsPresent(EdaatOR.Admin_SystemMng_PaymentMethodMng_SwitchBtwInvoiceToTransMessage);
					WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_SwitchBtwInvoiceToTrans_Yesbtn);		

				}
			Log.ReportEvent("PASS", " Verify the message when the user change the category from Invoice based to Transaction count and vice versa");
			test.log(Status.PASS,"#FUNC- Verify the message when the user change the category from Invoice based to Transaction count and vice versa" + driver.getTitle()+ "*PASS * " );
			} catch (Exception e) {
				e.printStackTrace();
				test.log(Status.FAIL,"#FUNC- Verify the message when the user change the category from Invoice based to Transaction count and via versa" + driver.getTitle()+ " *FAIL * " );
				this.takeScreenShot();
			}
		}
		
		//Function Summary   : Method to navigate  to "BillerUnderActivation"
		//Parameter Summary : N/A
			public void navigateBillerUnderActivation(Log Log) throws Exception {
			WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_BillerMang);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_BillerUnderActivation);
			Log.ReportEvent("PASS", "Naviagate to Not approved Biller Management ");

		}
		
		//Function Summary  : Method to Verify View Payment Method Details
		//Parameter Summary : N/A
		public void VerifyViewPaymentMethodDetails(Log Log,Map<Object, Object> testdatamap)
		{
			try {
				Thread.sleep(1000);
				if(testdatamap.get("EnglishName").toString().equalsIgnoreCase("Paid Outside EDAAT"))
				{
				WebClick(EdaatOR.Admin_SystemMng_PaymentMethod_Paidoutside_link);
				Thread.sleep(1000);
				this.takeScreenShot();
				VerifyValue1(getAttributeValue(EdaatOR.Admin_SystemMng_PaymentMethod_PaidOutsideEnglishName, "value"),testdatamap.get("EnglishName").toString());
				Thread.sleep(1000);
				VerifyValue1(getAttributeValue(EdaatOR.Admin_SystemMng_PaymentMethod_PaidOutsideArabicName, "value"),testdatamap.get("ArabicName").toString());
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethod_BackButton);
				}
				else if(testdatamap.get("EnglishName").toString().equalsIgnoreCase("Sadad"))
				{
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethod_Sadad_link);
				Thread.sleep(1000);
				this.takeScreenShot();
				VerifyValue1(getAttributeValue(EdaatOR.Admin_SystemMng_PaymentMethod_SadadEnglishName, "value"),testdatamap.get("EnglishName").toString());
				Thread.sleep(1000);
				VerifyValue1(getAttributeValue(EdaatOR.Admin_SystemMng_PaymentMethod_SadadArabicName, "value"),testdatamap.get("ArabicName").toString());
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethod_BackButton);
				}
				else if(testdatamap.get("EnglishName").toString().equalsIgnoreCase("MADA"))
				{
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethod_MADA_link);
				Thread.sleep(1000);
				this.takeScreenShot();
				VerifyValue1(getAttributeValue(EdaatOR.Admin_SystemMng_PaymentMethod_MadaEnglishName, "value"),testdatamap.get("EnglishName").toString());
				Thread.sleep(1000);
				VerifyValue1(getAttributeValue(EdaatOR.Admin_SystemMng_PaymentMethod_MADArabicName, "value"),testdatamap.get("ArabicName").toString());
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethod_BackButton);
				}
				
				else if(testdatamap.get("EnglishName").toString().equalsIgnoreCase("Visa"))
				{
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethod_Visa_link);
				Thread.sleep(1000);
				this.takeScreenShot();
				VerifyValue1(getAttributeValue(EdaatOR.Admin_SystemMng_PaymentMethod_VisaEnglishName, "value"),testdatamap.get("EnglishName").toString());
				Thread.sleep(1000);
				VerifyValue1(getAttributeValue(EdaatOR.Admin_SystemMng_PaymentMethod_VisaArabicName, "value"),testdatamap.get("ArabicName").toString());
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethod_BackButton);
				}
				
				else if(testdatamap.get("EnglishName").toString().equalsIgnoreCase("Master Card"))
				{
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethod_MasterCard_link);
				Thread.sleep(1000);
				this.takeScreenShot();
				VerifyValue1(getAttributeValue(EdaatOR.Admin_SystemMng_PaymentMethod_MastercardEnglishName, "value"),testdatamap.get("EnglishName").toString());
				Thread.sleep(1000);
				VerifyValue1(getAttributeValue(EdaatOR.Admin_SystemMng_PaymentMethod_MasterCardArabicName, "value"),testdatamap.get("ArabicName").toString());
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethod_BackButton);
				}
				
				else if(testdatamap.get("EnglishName").toString().equalsIgnoreCase("ApplePay"))
				{
				
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethod_ApplePay_link);
				Thread.sleep(1000);
				this.takeScreenShot();
				VerifyValue1(getAttributeValue(EdaatOR.Admin_SystemMng_PaymentMethod_ApplePayEnglishName, "value"),testdatamap.get("EnglishName").toString());
				Thread.sleep(1000);
				VerifyValue1(getAttributeValue(EdaatOR.Admin_SystemMng_PaymentMethod_ApplepayArabicName, "value"),testdatamap.get("ArabicName").toString());
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethod_BackButton);
				}
				
				Log.ReportEvent("PASS", "Verify View Payment Method Details");
				test.log(Status.PASS,"#FUNC-Verify View Payment Method Details" + driver.getTitle()+ " * Verify View Payment Method Details PASS * " );
			}
			 
			catch (Exception e) {
					e.printStackTrace();
					test.log(Status.FAIL,"#FUNC-Verify View Payment Method Details Incorrect" + driver.getTitle()+ " * Verify View Payment Method Details Incorrect FAIL * " );
					this.takeScreenShot();
				}
		}
			//Function Summary   : Method to Verify Define AZM fees For Payment Methods
		//Parameter Summary  : FixedValue,Percentage,FixedValueWithTax,PercentageWithTax
			public void VerifyDefineAZMfeesForPaymentMethods(Map<Object, Object> testdatamap,Log Log) throws Exception {
				switchToWindow();
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_PaymentMethodMngFixedValueCheckbox);
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_PaymentMethodMngFixedValueCheckbox);
				Thread.sleep(500);
				WebEdit(EdaatOR.Admin_PaymentMethodMngFixedValueAmount,testdatamap.get("FixedValue").toString());
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_PaymentMethodMngPercentageCheckbox);
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_PaymentMethodMngPercentageCheckbox);
				Thread.sleep(500);
				WebEdit(EdaatOR.Admin_PaymentMethodMngPercentageAmount,testdatamap.get("Percentage").toString());		
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_PaymentMethodMngSaveButton);
				Thread.sleep(500);
				VerifyValue1(testdatamap.get("FixedValueWithTax").toString(), WebGetTextAttribute(EdaatOR.Admin_PaymentMethodMngFixedValueAmountWithTax));
				Thread.sleep(500);
				VerifyValue1(testdatamap.get("PercentageWithTax").toString(), WebGetTextAttribute(EdaatOR.Admin_PaymentMethodMngPercentageAmountwithTax));
				
				Log.ReportEvent("PASS", "Verified Define AZM fees For Payment Methods");	
			}
			//Function Summary   : Method to Activate And Deactivate Payment Methods status toggle both in EN and AR
			//Parameter Summary  : PaymentsMethods
			public void VerifyActivateAndDeactivatePaymentMethodsStatusToggle(Map<Object, Object> testdatamap,Log Log) throws Exception {
				try {
				Thread.sleep(1000);
				WebClick("(//a[text()='"+testdatamap.get("PaymentMethods").toString()+"']/parent::td/following-sibling::td//input[contains(@class,'switch makeActive')]/parent::span)[1]");
				Thread.sleep(500);
				this.takeScreenShot();
				VerifyValue1(getText(EdaatOR.Admin_PaymentMng_CancelPopupMessage), testdatamap.get("Inactive").toString());
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_SystemMng_PaymentMng_YesBtn);
				this.takeScreenShot();
				Thread.sleep(500);
				WebClick("(//a[text()='"+testdatamap.get("PaymentMethods").toString()+"']/parent::td/following-sibling::td//input[contains(@class,'switch makeActive')]/parent::span)[1]");
				Thread.sleep(500);
				this.takeScreenShot();
				VerifyValue1(getText(EdaatOR.Admin_PaymentMng_ConfirmationPopupMessage), testdatamap.get("Active").toString());
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_SystemMng_PaymentMng_YesBtn);
				this.takeScreenShot();
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_PaymentMng_ChangetoArabic);
				Thread.sleep(500);
				this.takeScreenShot();
				WebClick("(//a[text()='"+testdatamap.get("PaymentMethods").toString()+"']/parent::td/following-sibling::td//input[contains(@class,'switch makeActive')]/parent::span)[1]");
				Thread.sleep(500);
				VerifyValue1(getText(EdaatOR.Admin_PaymentMng_ArabicPopupMessage), testdatamap.get("ArabicInactive").toString());
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_SystemMng_PaymentMng_YesBtn);
				this.takeScreenShot();
				Thread.sleep(500);
				WebClick("(//a[text()='"+testdatamap.get("PaymentMethods").toString()+"']/parent::td/following-sibling::td//input[contains(@class,'switch makeActive')]/parent::span)[1]");
				Thread.sleep(500);
				VerifyValue1(getText(EdaatOR.Admin_PaymentMng_ArabicPopupMessage), testdatamap.get("ArabicActive").toString());
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_SystemMng_PaymentMng_YesBtn);
				Thread.sleep(500);
				WebClick(EdaatOR.Changelanguagebtn);
				Log.ReportEvent("PASS", "Activated And Deactivated the Payment Methods status toggle");
				test.log(Status.PASS,"#FUNC-Payment Methods activated and deactivated" + driver.getTitle()+ " * Payment Methods activated and deactivated PASS * " );
				}catch(Exception e)	{				
				e.printStackTrace();
				test.log(Status.FAIL,"#FUNC-Payment Methods activated and deactivated" + driver.getTitle()+ " * Payment Methods activated and deactivated FAIL * " );
				this.takeScreenShot();
				}
			}
				//Function Summary   : Method to Activate And Deactivate Payment Methods Fees activation status toggle EN and AR
				//Parameter Summary  : PaymentsMethods
				public void VerifyActivateAndDeactivatePaymentMethodFeesActivationStatusToggle(Map<Object, Object> testdatamap,Log Log) throws Exception {
					try {
					Thread.sleep(1000);
					WebClick("(//a[text()='"+testdatamap.get("PaymentMethods").toString()+"']/parent::td/following-sibling::td//input[contains(@class,'switch makeActive')]/parent::span)[2]");
					Thread.sleep(500);
					VerifyValue1(getText(EdaatOR.Admin_PaymentMng_CancelPopupMessage), testdatamap.get("Inactive").toString());
					Thread.sleep(500);
					WebClick(EdaatOR.Admin_SystemMng_PaymentMng_FreeActivationYesBtn);
					Thread.sleep(500);
					WebClick("(//a[text()='"+testdatamap.get("PaymentMethods").toString()+"']/parent::td/following-sibling::td//input[contains(@class,'switch makeActive')]/parent::span)[2]");
					Thread.sleep(500);
					VerifyValue1(getText(EdaatOR.Admin_PaymentMng_ConfirmationPopupMessage), testdatamap.get("Active").toString());
					Thread.sleep(500);
					WebClick(EdaatOR.Admin_SystemMng_PaymentMng_FreeActivationYesBtn);
					Thread.sleep(500);
					WebClick(EdaatOR.Admin_PaymentMng_ChangetoArabic);
					Thread.sleep(500);
					this.takeScreenShot();
					WebClick("(//a[text()='"+testdatamap.get("PaymentMethods").toString()+"']/parent::td/following-sibling::td//input[contains(@class,'switch makeActive')]/parent::span)[2]");
					Thread.sleep(500);
					VerifyValue1(getText(EdaatOR.Admin_PaymentMng_FreeActivationPopupMessage), testdatamap.get("ArabicInactive").toString());
					Thread.sleep(500);
					WebClick(EdaatOR.Admin_SystemMng_PaymentMng_FreeActivationYesBtn);
					Thread.sleep(500);
					this.takeScreenShot();
					WebClick("(//a[text()='"+testdatamap.get("PaymentMethods").toString()+"']/parent::td/following-sibling::td//input[contains(@class,'switch makeActive')]/parent::span)[2]");
					Thread.sleep(500);
					VerifyValue1(getText(EdaatOR.Admin_PaymentMng_FreeActivationPopupMessage), testdatamap.get("ArabicActive").toString());
					Thread.sleep(500);
					WebClick(EdaatOR.Admin_SystemMng_PaymentMng_FreeActivationYesBtn);
					Thread.sleep(500);
					this.takeScreenShot();
					WebClick(EdaatOR.Changelanguagebtn);
					Log.ReportEvent("PASS", "Activated And Deactivated the Payment Methods Fees activation status toggle");
					test.log(Status.PASS,"#FUNC-Payment Methods activated and deactivated" + driver.getTitle()+ " * Payment Methods activated and deactivated PASS * " );
					}catch(Exception e)	{				
					e.printStackTrace();
					test.log(Status.FAIL,"#FUNC-Payment Methods activated and deactivated" + driver.getTitle()+ " * Payment Methods activated and deactivated FAIL * " );
					this.takeScreenShot();
					}
			}
				//Function Summary   : Method to Deactivate Payment Methods status toggle 
				//Parameter Summary  : PaymentsMethods
				public void VerifyDeactivatePaymentMethodsStatusToggle(Map<Object, Object> testdatamap,Log Log) throws Exception {
					try {
					Thread.sleep(500);
					WebClick("(//a[text()='"+testdatamap.get("PaymentMethods").toString()+"']/parent::td/following-sibling::td//input[contains(@class,'switch makeActive')]/parent::span)[1]");
					this.takeScreenShot();
					Thread.sleep(500);
					VerifyValue1(getText(EdaatOR.Admin_PaymentMng_CancelPopupMessage), testdatamap.get("Inactive").toString());
					Thread.sleep(500);
					WebClick(EdaatOR.Admin_SystemMng_PaymentMng_YesBtn);
					this.takeScreenShot();
					Thread.sleep(500);					
					Log.ReportEvent("PASS", "Activated And Deactivated the Payment Methods status toggle");
					test.log(Status.PASS,"#FUNC-Payment Methods deactivated" + driver.getTitle()+ " * Payment Methods deactivated PASS * " );
					}catch(Exception e)	{				
					e.printStackTrace();
					test.log(Status.FAIL,"#FUNC-Payment Methods deactivated" + driver.getTitle()+ " * Payment Methods deactivated FAIL * " );
					this.takeScreenShot();
					}
				}
				//Function Summary   : Method to Activate Payment Methods status toggle 
				//Parameter Summary  : PaymentsMethods
				public void VerifyActivatePaymentMethodsStatusToggle(Map<Object, Object> testdatamap,Log Log) throws Exception {
					try {					
					Thread.sleep(500);
					WebClick("(//a[text()='"+testdatamap.get("PaymentMethods").toString()+"']/parent::td/following-sibling::td//input[contains(@class,'switch makeActive')]/parent::span)[1]");
					Thread.sleep(500);
					VerifyValue1(getText(EdaatOR.Admin_PaymentMng_ConfirmationPopupMessage), testdatamap.get("Active").toString());
					Thread.sleep(500);
					WebClick(EdaatOR.Admin_SystemMng_PaymentMng_YesBtn);
					Thread.sleep(500);				
					Log.ReportEvent("PASS", "Activated the Payment Methods status toggle");
					test.log(Status.PASS,"#FUNC-Payment Methods activated " + driver.getTitle()+ " * Payment Methods activated PASS * " );
					}catch(Exception e)	{				
					e.printStackTrace();
					test.log(Status.FAIL,"#FUNC-Payment Methods activated " + driver.getTitle()+ " * Payment Methods activated FAIL * " );
					this.takeScreenShot();
					}
				}
				//Function Summary   : Method to Verify PaymentMethods Add Fixed Fees
				//Parameter Summary  : PaymentsMethods,FixedValue,Percentage
				public void VerifyPaymentMethodsAddFixedFees(Map<Object, Object> testdatamap,Log Log) throws Exception {
					try {
					Thread.sleep(500);
					WebClick("//a[text()='"+testdatamap.get("PaymentMethods").toString()+"']/parent::td/following-sibling::td//a");
					Thread.sleep(500);
					switchToWindow();
					Thread.sleep(500);
					this.takeScreenShot();
					WebClick(EdaatOR.Admin_PaymentMethodMngEditFixedValueCheckbox);
					Thread.sleep(500);
					WebClick(EdaatOR.Admin_PaymentMethodMngEditFixedValueCheckbox);
					Thread.sleep(500);
					WebEdit(EdaatOR.Admin_PaymentMethodMngEditFixedValueAmount,testdatamap.get("FixedValue").toString());
					Thread.sleep(500);
					WebClick(EdaatOR.Admin_PaymentMethodMngEditPercentageCheckbox);
					Thread.sleep(500);
					WebClick(EdaatOR.Admin_PaymentMethodMngEditPercentageCheckbox);
					Thread.sleep(500);
					WebEdit(EdaatOR.Admin_PaymentMethodMngEditPercentageAmount,testdatamap.get("Percentage").toString());		
					Thread.sleep(500);
					WebClick(EdaatOR.Admin_PaymentMethodMngEditSaveButton);
					Thread.sleep(500);
					this.takeScreenShot();
					VerifyValue1(testdatamap.get("FixedValueWithTax").toString(), WebGetTextAttribute(EdaatOR.Admin_PaymentMethodMngEditFixedValueAmountWithTax));
					Thread.sleep(500);
					VerifyValue1(testdatamap.get("PercentageWithTax").toString(), WebGetTextAttribute(EdaatOR.Admin_PaymentMethodMngEditPercentageAmountwithTax));
					
					Log.ReportEvent("PASS", "Verified Add Fixed Fees Payment Methods");									
					
					test.log(Status.PASS,"#FUNC-Payment Methods Added Fixed Fees" + driver.getTitle()+ " * Payment Methods Added Fixed Fees PASS * " );
					}catch(Exception e)	{				
					e.printStackTrace();
					test.log(Status.FAIL,"#FUNC-Payment Methods Added Fixed Fees" + driver.getTitle()+ " * Payment Methods Added Fixed Fees FAIL * " );
					this.takeScreenShot();
					}
				}
				//Function Summary   : Method to Verify Payment Methods Add Fees Based On Invoice
				//Parameter Summary  : PaymentsMethods,FixedValue,Percentage
				public void VerifyPaymentMethodsAddFeesBasedOnInvoice(Map<Object, Object> testdatamap,Log Log) throws Exception {
					try {
					Thread.sleep(500);
					WebClick("//a[text()='"+testdatamap.get("PaymentMethods").toString()+"']/parent::td/following-sibling::td//a");
					Thread.sleep(500);
					switchToWindow();
					Thread.sleep(500);
					ClickOnAddBtn();
					Thread.sleep(500);
					ClickOnInvoiceFeesAddBtn();
					Thread.sleep(4000);
					verifyElementIsPresent(EdaatOR.Admin_PaymentMethod_AddFromAmountErrorMsg);
					this.takeScreenShot();
					Thread.sleep(4000);
					WebEdit(EdaatOR.Admin_PaymentMethod_InvoiceFromAmount,testdatamap.get("FromAmount").toString());
					Thread.sleep(3000);
					WebEdit(EdaatOR.Admin_PaymentMethod_InvoiceToAmount,testdatamap.get("ToAmount").toString());
					Thread.sleep(2000);
					ClickOnInvoiceFeesAddBtn();
					Thread.sleep(4000);
					verifyElementIsPresent(EdaatOR.Admin_PaymentMethod_FixedAndPercentageErrorMsg);
					Thread.sleep(500);
					this.takeScreenShot();
					Thread.sleep(2000);
					WebClick(EdaatOR.Admin_PaymentMethod_InvoiceAmountFreeFixedValueCheckbox);
					Thread.sleep(500);
					WebEdit(EdaatOR.Admin_PaymentMethod_InvoiceAmountFreeFixedValue,testdatamap.get("FixedValue").toString());
					Thread.sleep(500);				
					ClickOnInvoiceFeesAddBtn();
					Thread.sleep(500);					
					Log.ReportEvent("PASS", "Payment Methods Added Fees Based on Invoice");									
					
					test.log(Status.PASS,"#FUNC-Payment Methods Add Fees Based on Invoice" + driver.getTitle()+ " * Payment Methods Add Fees Based on Invoice PASS * " );
					}catch(Exception e)	{				
					e.printStackTrace();
					test.log(Status.FAIL,"#FUNC-Payment Methods Add Fees Based on Invoice" + driver.getTitle()+ " *Payment Methods Add Fees Based on Invoice FAIL * " );
					this.takeScreenShot();
					}
				}
				public void ClickOnAddBtn() {
					WebClickUsingJS(EdaatOR.Admin_PaymentMethod_AddButton);
					waitForPageToLoad();
				}
				public void ClickOnInvoiceFeesAddBtn() {
					WebClickUsingJS(EdaatOR.Admin_PaymentMethod_InvoiceFeesAddButton);
					waitForPageToLoad();
				}
		//Function Summary  : Search biller
		public void searchBiller(Map<Object, Object> testdatamap,Log Log) {
			try {
				WebEdit(EdaatOR.Admin_SystemMng_notApprovedBiller_Searchbillername, testdatamap.get("BillerName").toString());
				WebClickUsingJS(EdaatOR.Admin_SystemMng_notApprovedBiller_ClickOnSearch);
				Thread.sleep(2000);
				Log.ReportEvent("PASS", " search Biller");
				test.log(Status.PASS, "#FUNC-search Biller " + driver.getTitle()+ "searchBiller PASS* " );
			} catch (Exception e) {
				e.printStackTrace();
				test.log(Status.FAIL,"#FUNC-Search Biller Failed" + driver.getTitle()+ " * Search Biller FAIL * " );							
			}
			
		}
		public void navigateToNotApprovedBillers(Log Log) {
			try {
				WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Admin_SystemMng_billerAmangement);
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Admin_SystemMng_billerMgm_notApprovedBiller);
				Log.ReportEvent("PASS", "Naviagate to notApprovedBillers ");
				test.log(Status.PASS, "#FUNC-notApprovedBillers Page is Found" + driver.getTitle()+ " notApprovedBillers Page is Found PASS* " );
			} catch (Exception e) {
				e.printStackTrace();
				test.log(Status.FAIL,"#FUNC-notApprovedBillers Page is not Found" + driver.getTitle()+ " * notApprovedBillers Page is not Found FAIL * " );
			}
		}
		//Function Summary  :Method to clickonEditBtn
		public void clickonEditBtn(Log Log) {
			try {
				WebClickUsingJS(EdaatOR.Admin_SystemMng_notApprovedBiller_EditBTN);
				Thread.sleep(1000);
				Log.ReportEvent("PASS", "Click on Edit Button");
			} catch (Exception e) {
				e.printStackTrace();
				test.log(Status.FAIL,"#FUNC-Click on Edit Button is not Found" + driver.getTitle()+ " * noClick on Edit Button is not Found FAIL * " );
			}
			
		}		
		//Function Summary  :Verify that the default payment method is "PayOutsideEdaat"
		public void VerifythattheDefaultPaymentMethodisPayOutsideEdaat(Map<Object, Object>testdatamap,Log Log) {
			try {
				WebElement element = driver.findElement(By.xpath(EdaatOR.Admin_SystemMng_notApprovedBiller_saveBtn));
				scrollToElement(driver, element);
				
				if (IsSelected(EdaatOR.Admin_SystemMng_notApprovedBiller_PaidOutsideEDAAT)) {
					this.takeScreenShot();
				}
				else {
					Log.ReportEvent("FAIL", "Paid Outside EDAAT checkbox is not selected");
				}
				WebClickUsingJS(EdaatOR.Admin_SystemMng_notApprovedBiller_saveBtn);
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Admin_SystemMng_notApprovedBiller_ConfirmsaveBtn);
				Thread.sleep(1000);
				CheckElementExists(EdaatOR.Admin_SystemMng_notApprovedBiller_AlerteError);
					this.takeScreenShot();
				
				Log.ReportEvent("PASS", "Verify that the default payment method is PayOutsideEdaat");
				test.log(Status.PASS, "#FUNC-Verify that the default payment method is PayOutsideEdaat" + driver.getTitle()+ " Verify that the default payment method is PayOutsideEdaat PASS* " );
				}
			
			 catch (Exception e) {
				e.printStackTrace();
				test.log(Status.FAIL,"#FUNC-Verify that the default payment method is PayOutsideEdaat" + driver.getTitle()+ " * Verify that the default payment method is PayOutsideEdaat FAIL * " );							
					}
} 
		//Function Summary  :Method to editbuttonforpaymentProvider
		public void editbuttonforpaymentProvider(Log Log) throws InterruptedException {
			try {
				WebClickUsingJS(EdaatOR.Admin_SystemMng_editbuttonforpaymentProvider);
				Thread.sleep(1000);
				this.takeScreenShot();
				Log.ReportEvent("PASS", "Click on  edit button for payment Provider");
				test.log(Status.PASS, "#FUNC-Click on edit button for payment Provider" +driver.getTitle()+ "Click on edit button for payment Provider PASS*");
				
			} catch (Exception e) {
				e.printStackTrace();
				test.log(Status.FAIL, "Click on  edit button for payment Provider is Fail" +driver.getTitle()+ "Click on edit button for payment Provider FAIL*");			
				}
		}
		
		//Function Summary  :Method to toUpdateTheNameCodeCR
		public void  toUpdateTheNameCodeCR(Map<Object, Object> testdatamap, Log Log) {
			try {
				WebEdit(EdaatOR.Admin_SystemMng_editPaymentProviderName, testdatamap.get("Name").toString());
				WebEdit(EdaatOR.Admin_SystemMng_editPaymentProviderCode, testdatamap.get("Code").toString());
				WebEdit(EdaatOR.Admin_SystemMng_editPaymentProviderCR, testdatamap.get("CRNumber").toString());
				
				EnterBillerBankCertPath();
				WebClickUsingJS(EdaatOR.Admin_SystemMng_editPaymentProviderSaveButton);
				this.takeScreenShot();
				Log.ReportEvent("PASS", "To update the name, code, CR");
				test.log(Status.PASS, "#FUNC-To update the name, code, CR" +driver.getTitle()+ "To update the name, code, CR PASS*");
			} catch (Exception e) {
				e.printStackTrace();
				test.log(Status.FAIL, "To update the name, code, CR is Fail" +driver.getTitle()+ "To update the name, code, CR FAIL*");			
				}
		}
		//Function Summary   : Method to upload Biller BankCertificate.
	    //Parameter Summary  :N/A.
		public void EnterBillerBankCertPath() throws Exception {
			WebClickUsingActions(EdaatOR.Admin_SystemMng_editPaymentProviderAttachements);
			getAutoItImagePathFile();
			
		}
		public void  getAutoItImagePathFile() throws Exception {
			File classpathRoot = new File(System.getProperty("user.dir"));
			Thread.sleep(800);
			File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//PdfUpload.exe");
			String sFilename = app.toString();
			Thread.sleep(1000);
			Runtime.getRuntime().exec(sFilename);
			Thread.sleep(800);
		}
}
