package weather.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.WeatherInputDataUtil;

public class WeatherDetailsPage extends BasePage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public WeatherDetailsPage(WebDriver driver) {

		this.driver= driver;
		wait = new WebDriverWait(driver, 5);
		PageFactory.initElements(driver, this);
	}
	
	

	public String getWeatherDetails() throws Exception
	{
		
		String xpath="//h1[contains(text(),'"+WeatherInputDataUtil.getCity()+"')]/following-sibling::span";
		waitForPageToLoad(wait, driver.findElement(By.xpath(xpath)));
		String temp=driver.findElement(By.xpath(xpath)).getText();
		
		return temp.split("°")[0];
	}
	
}
