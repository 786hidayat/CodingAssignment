package weather.comparator;

import utility.WeatherInputDataUtil;

public class WeatherComparator {

	public static boolean compareTemps(String aPIvalue, String uiValue)  {
		double d=Math.abs(Double.parseDouble(aPIvalue)-Double.parseDouble(uiValue));
		System.out.println("Diiference:"+d);
		
			if (Math.abs(Double.parseDouble(aPIvalue)-Double.parseDouble(uiValue))
					<= Integer.parseInt(WeatherInputDataUtil.getVarienceRange()))
			{
				//throw new Exception();
				return true;
			}
			return false;
		}
	
}
