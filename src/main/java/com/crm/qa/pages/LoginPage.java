package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(xpath="//a[@href='https://ui.freecrm.com']")
	WebElement LOginBtn;
	
	@FindBy(name="email")
    WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[contains(text(),'Login')]")
	WebElement login;
	
	
	
	@FindBy(xpath="//a[@class='brand-name']")
	WebElement crmLogo;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String mail, String pwd){
		
		//JavascriptExecutor js = (JavascriptExecutor)driver;
    	//js.executeScript("arguments[0].click();", LOginBtn);
		LOginBtn.click();
		email.sendKeys(mail);
		password.sendKeys(pwd);
		login.click();
		
		
		    	
		return new HomePage();
	}
	
	

}
