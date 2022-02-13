package basePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Pojo {
	
	public static WebDriver LaunchChrome()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\RP\\Software Testing\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		return driver;
	}
	
	public static WebDriver LaunchFirefox()
	{
		System.setProperty("webdriver.gecko.driver", "D:\\RP\\Software Testing\\Selenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		return driver;
	}
	
	public static WebDriver LaunchMsEdge()
	{
		System.setProperty("webdriver.edge.driver", "D:\\RP\\Software Testing\\Selenium\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		return driver;
	}



}
