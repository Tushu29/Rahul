package POM;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Utility;

public class KiteLogin {
	private WebDriver driver;
	
	@FindBy ( xpath = "//input[@id='userid']")
	private WebElement  UserId;
	
	@FindBy ( xpath = "//input[@id='password']")
	private WebElement PassWord;
	
	@FindBy ( xpath = "//button[text() = 'Login ']")
	private WebElement Login;
	
	@FindBy ( xpath = "//input[@id='pin']")
	private WebElement Pin;
	
	@FindBy ( xpath = "//button[text() ='Continue ']")
	private WebElement Continue;
	
	
	public KiteLogin(WebDriver driver )
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
   
	
	public void LogIn() throws EncryptedDocumentException, IOException
	{
		String userid = Utility.excelData("Kite", 0, 1);
		UserId.sendKeys(userid);
		String password = Utility.excelData("Kite", 1, 1);
		PassWord.sendKeys(password);
		Login.click();
		String pin = Utility.excelData("Kite", 2, 1);
		Pin.sendKeys(pin);
		Continue.click();
		
		
	}
}
