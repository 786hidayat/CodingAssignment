package utility;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class WeatherRequest {

	/**
	 * 	queryParamas.put("q","London");
		queryParamas.put("appid", "a87cbdcbfa7508550c85758cf7ec0d3c");
		queryParamas.put("units","metric");
	 * 
	 * RequestSpecification request = new RequestSpecBuilder()
								.setBaseUri("https://api.openweathermap.org/data/2.5")
								.addQueryParams(queryParamas)
								.build();
	 * */
	
	public static RequestSpecification buildRequest()
	{
		RequestSpecification request = new RequestSpecBuilder()
				.setBaseUri("https://api.openweathermap.org/data/2.5")
				.addQueryParams(WeatherInputDataUtil.getQueryParamas())
				.build();
		return request;
	}
	
	
}
