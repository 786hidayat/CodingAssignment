package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class WeatherInputDataUtil {

	private static final String INPUTPATH = System.getProperty("user.dir")+"\\src\\main\\resources\\InputData.Properties";
	private static FileInputStream fis;
	private static Properties prop;
	public static String getCity() {
		
		return getDataFile().getProperty("city");
	}

	public static String getStateCode() {
		return getDataFile().getProperty("stateCode");
	}

	public static String getCountryCode() {
		return getDataFile().getProperty("countryCode");
	}

	public static String getAppID() {
		return getDataFile().getProperty("API_Key");
	}
	
	public static String getVarienceRange() {
		return getDataFile().getProperty("VarienceRange");
	}
	
	public static Properties getDataFile() 
	{
			if(prop==null)
			{
			
			
			try {
				prop = new Properties();
				fis = new FileInputStream(new File(INPUTPATH));
				System.out.println(INPUTPATH);
				prop.load(fis);
			} catch (IOException e) {
				System.out.println("Input Data file is not present");
			}
			}
		return prop;
		
	}
	
	public static  Map<String, String> getQueryParamas() {
		Map<String, String> queryParamas = new HashMap<String, String>();
		String valueOfLocationAddress=getvalueOfLocationAddress();
		
		queryParamas.put("q",valueOfLocationAddress);
		
		queryParamas.put("appid", WeatherInputDataUtil.getAppID().trim());
		queryParamas.put("units","metric");
		return queryParamas;
	}

	private static String getvalueOfLocationAddress() {
		
		String city=WeatherInputDataUtil.getCity().trim();
		String stateCode=WeatherInputDataUtil.getStateCode().trim();
		String countryCode=WeatherInputDataUtil.getCountryCode().trim();
		 
		String locationValue=city;
		if(!stateCode.isEmpty())
			locationValue=locationValue+","+stateCode;
		if(!countryCode.isEmpty())
			locationValue=locationValue+","+countryCode;
		 
		return locationValue;
	}
	
	
	public static String getResourceURI()
	{
		return "/weather?q="+getvalueOfLocationAddress()+"&appid="+WeatherInputDataUtil.getAppID().trim();
	}
	
	public static void closeResources()
	{
		if(prop!=null)
		{
			try {
				fis.close();
				prop.clear();
				System.out.println("Closed");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			prop.clear();
		}
	}
}
