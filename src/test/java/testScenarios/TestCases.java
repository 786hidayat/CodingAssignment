package testScenarios;
/**
 * Test class contains 3 test cases to validate  from API and UI 
 * 
 * */

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


import io.restassured.parsing.Parser;
import utility.WeatherInputDataUtil;
import utility.WeatherRequest;
import utils.WebDriverUtil;
import weather.comparator.WeatherComparator;
import weather.pojos.ResponseObj;
import weather.ui.pages.AccuweatherHomePage;

import static io.restassured.RestAssured.*;




public class TestCases {

	/**
	 * This is Rest API call to get Current weather present in the location provided
	 * 
	 * API source: https://openweathermap.org/current
	 * */
	@Test
	public void getWeatherFromAPI(ITestContext context)
	{
		ResponseObj response = 
				given().spec(WeatherRequest.buildRequest()).expect().defaultParser(Parser.JSON).
				when().get(WeatherInputDataUtil.getResourceURI()).
				then().extract().response().as(ResponseObj.class);
		
		System.out.println("Temp:"+response.getMain().getTemp());
		//Add weather to context
		context.setAttribute("APIWeather", response.getMain().getTemp());
	}
	
	/**
	 * This is UI call to get Current weather present in the location provided
	 * 
	 * UI Source: https://www.accuweather.com/
	 * */
	@Test
	public void getWeatherFromUI(ITestContext context) throws Exception {

		AccuweatherHomePage homePage = new AccuweatherHomePage(WebDriverUtil.getInstance(context));
		String weatherDetails = homePage.clickAndSubmintWeatherDetailsPage().getWeatherDetails();
		System.out.println("UIWeather:"+weatherDetails);
		context.setAttribute("UIWeather", weatherDetails);
	}
	
	
	/**
	 * This is Comparator to check if variance between API and UI is in specific range or not
	 * 
	 * **/
	@Test(dependsOnMethods = {"getWeatherFromAPI","getWeatherFromUI"})
	public void compareResults(ITestContext context) throws Exception {
		
		String apiWeather= context.getAttribute("APIWeather").toString();
		String uiWeather= context.getAttribute("UIWeather").toString();
		WeatherComparator.compareTemps(apiWeather,uiWeather);
		System.out.println("apiWeather:"+apiWeather);
		System.out.println("uiWeather:"+uiWeather);
		Assert.assertTrue(WeatherComparator.compareTemps(apiWeather,uiWeather),
				"Varience between API and UI is greater than specified in input value:"+ WeatherInputDataUtil.getVarienceRange());
	}
	
	@AfterTest
	public void tearDown(ITestContext context)
	{
		WeatherInputDataUtil.closeResources();
		WebDriverUtil.closeDriver();
		
	}
	
}
