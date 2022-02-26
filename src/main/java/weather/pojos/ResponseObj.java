package weather.pojos;

import java.util.List;

public class ResponseObj {

	/***
	 * 
	 * {
    "coord": {
        "lon": -0.1257,
        "lat": 51.5085
    },
    "weather": [
        {
            "id": 800,
            "main": "Clear",
            "description": "clear sky",
            "icon": "01d"
        }
    ],
    "base": "stations",
    "main": {
        "temp": 9.04,
        "feels_like": 6.77,
        "temp_min": 7.32,
        "temp_max": 10.2,
        "pressure": 1030,
        "humidity": 56
    },
    "visibility": 10000,
    "wind": {
        "speed": 4.12,
        "deg": 290
    },
    "clouds": {
        "all": 2
    },
    "dt": 1645810021,
    "sys": {
        "type": 2,
        "id": 2019646,
        "country": "GB",
        "sunrise": 1645772087,
        "sunset": 1645810365
    },
    "timezone": 0,
    "id": 2643743,
    "name": "London",
    "cod": 200
}
	 * 
	 * */
	
	private Coord coord;
	private List<Weather> weather;
	private String base;
	private Main main;
	private double visibility;
	private Wind wind;
	private Clouds clouds;
	private long dt;
	private Sys sys;
	private int timezone;
	private int id;
	private String name;
	private int cod;
	
	public Coord getCoord() {
		return coord;
	}
	public void setCoord(Coord coord) {
		this.coord = coord;
	}
	public List<Weather> getWeather() {
		return weather;
	}
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public Main getMain() {
		return main;
	}
	public void setMain(Main main) {
		this.main = main;
	}
	public double getVisibility() {
		return visibility;
	}
	public void setVisibility(double visibility) {
		this.visibility = visibility;
	}
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	public Clouds getClouds() {
		return clouds;
	}
	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}
	public long getDt() {
		return dt;
	}
	public void setDt(long dt) {
		this.dt = dt;
	}
	public Sys getSys() {
		return sys;
	}
	public void setSys(Sys sys) {
		this.sys = sys;
	}
	public int getTimezone() {
		return timezone;
	}
	public void setTimezone(int timezone) {
		this.timezone = timezone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	
	
	
}
