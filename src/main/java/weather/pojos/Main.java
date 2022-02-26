package weather.pojos;

//import java.text.DecimalFormat;
//import java.text.NumberFormat;

public class Main {

	/**
	 * "main": {
        "temp": 9.04,
        "feels_like": 6.77,
        "temp_min": 7.32,
        "temp_max": 10.2,
        "pressure": 1030,
        "humidity": 56
    }
	 * */
	
//	double operation = 890d / 1440d;
	private double temp;
	
	private double feels_like;
	private double temp_min;
	private double temp_max;
	private double pressure;
	private double sea_level;
	private double grnd_level ;
	private int humidity;
	
	
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}
	public double getFeels_like() {
		return feels_like;
	}
	public void setFeels_like(double feels_like) {
		this.feels_like = feels_like;
	}
	public double getTemp_min() {
		return temp_min;
	}
	public void setTemp_min(double temp_min) {
		this.temp_min = temp_min;
	}
	public double getTemp_max() {
		return temp_max;
	}
	public void setTemp_max(double temp_max) {
		this.temp_max = temp_max;
	}
	public double getPressure() {
		return pressure;
	}
	public void setPressure(double pressure) {
		this.pressure = pressure;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public double getSea_level() {
		return sea_level;
	}
	public void setSea_level(double sea_level) {
		this.sea_level = sea_level;
	}
	public double getGrnd_level() {
		return grnd_level;
	}
	public void setGrnd_level(double grnd_level) {
		this.grnd_level = grnd_level;
	}
	//NumberFormat format = new DecimalFormat("#.##");
	//format(temp);
    
    
}
