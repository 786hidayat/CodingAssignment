package weather.ui.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.WeatherInputDataUtil;

public class AccuweatherHomePage extends BasePage{

	private WebDriver driver;
	private WebDriverWait wait;
	
	public AccuweatherHomePage(WebDriver driver) {
		this.driver= driver;
		wait = new WebDriverWait(driver, 5);
		PageFactory.initElements(driver, this);
	
	}
	@FindBy(xpath="//input[@name='query']")
	private WebElement locationInput;
	
	private List<WebElement> elements;
	private void getLocationDropDown() {
		
		//String location= WeatherInputDataUtil.getCity();
		String xpath="//div[contains(text(),'"+WeatherInputDataUtil.getCity()+"')]";
		elements = driver.findElements(By.xpath(xpath));

		
	}
	
	public WeatherDetailsPage clickAndSubmintWeatherDetailsPage() throws Exception
	{
		 waitForPageToLoad(wait, locationInput);
		 locationInput.click();
		 locationInput.sendKeys(WeatherInputDataUtil.getCity());
		 
		 getLocationDropDown();
		 if(elements.size()>0)
		 {
			 elements.stream().filter(element->element.getText().contains(WeatherInputDataUtil.getCountryCode()))
			 .collect(Collectors.toList()).get(0).click();
		 }
		 else
		 {
			 throw new Exception("Location not present in dropdown");
		 }
		 
		 return new WeatherDetailsPage(driver);
	}

}
