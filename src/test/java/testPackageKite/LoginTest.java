package testPackageKite;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import POM.KiteHomePage;
import POM.KiteLogin;
import basePackage.Pojo;

public class LoginTest extends Pojo{
	WebDriver driver;
	KiteLogin SignUp;
	KiteHomePage LogOut;
	
	 @BeforeTest
	 @Parameters("browser")
	 public void launchbrowser(String browser)
	 {
		 if(browser.equals("Chrome"))
		 {
			 driver = LaunchChrome();
		 }
		 else
		 {
			 if(browser.equals("Firefox"))
			 {
				 driver = LaunchFirefox();
			 }
			 else
			 {
				 driver = LaunchMsEdge();
			 }
		 }
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 driver.get("https://kite.zerodha.com/");
	 }
	 @BeforeClass
	 public void pageObjects()
	 {
		 SignUp = new KiteLogin(driver);
		 LogOut = new KiteHomePage(driver);
	 }
	 
	 @BeforeMethod
	 public void login() throws EncryptedDocumentException, IOException
	 {
		 SignUp.LogIn();
		 
	 }
	 
	 @Test
	 public void loginverification() throws InterruptedException
	 {
		 Thread.sleep(2000);
		 String Actual = driver.getCurrentUrl();
		 Assert.assertEquals(Actual, "https://kite.zerodha.com/dashboard");
	 }
	 
	@AfterMethod
	public void logOut()
	{
		LogOut.logout();
	}
	
	@AfterClass
	public void pageobjectsNull()
	{
		SignUp = null;
		LogOut = null;
		
	}
	
	@AfterTest
	public void browserClosed()
	{
		driver.close();
		driver = null;
	}
}
