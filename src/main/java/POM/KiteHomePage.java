package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteHomePage {
	private Actions a;
	@FindBy (xpath = "//input[@type='text']")
	private WebElement SearchBox;
	
	@FindBy (xpath = "//li[@class='search-result-item selected']")
	private WebElement StockSelection;
	
	@FindBy (xpath = "//span[text()=' Buy']")
	private WebElement BuyStock;
	
	@FindBy ( xpath = "//span[@class=\"user-id\"]")
	private WebElement Account;
	
	@FindBy ( xpath = "//a[text() =' Logout']")
	private WebElement LogOut;
	
	
	
	
	public KiteHomePage(WebDriver driver)
	{
		a = new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	public void buyAStock()
	{
		a.moveToElement(SearchBox).click().build().perform();
		SearchBox.sendKeys("Reliance");
		StockSelection.click();
		BuyStock.click();
	}
	
	public void logout()
	{
		a.moveToElement(Account).click().build().perform();
		a.moveToElement(LogOut).click().build().perform();
	}

}
