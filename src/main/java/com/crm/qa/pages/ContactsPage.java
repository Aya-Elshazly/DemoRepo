package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	@FindBy(xpath = "//*[text()='New']")
	WebElement newContactLink;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@class='search']//parent::div[@name='company']")
	WebElement company;
	
	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement saveBtn;
	
	// Initializing the Page Objects:
			public ContactsPage() {
				PageFactory.initElements(driver, this);
			}
			
			public boolean verifyContactsLabel()
			{
				return contactsLabel.isDisplayed();
			}
			
			public void selectContactsByName(String name){
			    name="test2 test2";
				driver.findElement(By.xpath("//td[text()='"+name+"']")).click();
			}
			public void clickOnNewContactLink(){
				Actions action = new Actions(driver);
				action.moveToElement(contactsLabel).build().perform();
				newContactLink.click();
				
			}
			public void createNewContact(String ftName, String ltName, String comp){
				//Select select = new Select(driver.findElement(By.name("title")));
				//select.selectByVisibleText(title);
				
				firstName.sendKeys(ftName);
				lastName.sendKeys(ltName);
				company.sendKeys(comp);
				saveBtn.click();
				
			}
		

}
