package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtil {
	
private static WebDriver driver;
	
	private WebDriverUtil() {
		
	}
	
	public static WebDriver getInstance(ITestContext context)
	{
		if(driver==null)
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setHeadless(false);
			
			driver= new ChromeDriver(options);
		}
		context.setAttribute("Webdriver", driver);
		
		  driver.get("https://www.accuweather.com/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		return driver;
	}

	public static void closeDriver()
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}

}
