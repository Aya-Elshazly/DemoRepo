package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil  testUtil;
	ContactsPage contactsPage;
	
	String SheetName="Contacts";
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage=homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel()
	{
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
	}
	/*@Test(priority=2)
	public void selectContactsTest()
	{
		contactsPage.selectContactsByName("Aya Elshazly");
	}*/
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
	 Object data[][]=TestUtil.getTestData(SheetName);
	 return data;
	}
	
	@Test(priority=3, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String FirstName,String LastName,String Company)
	{
		contactsPage.clickOnNewContactLink();
		contactsPage.createNewContact(FirstName,LastName,Company);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
