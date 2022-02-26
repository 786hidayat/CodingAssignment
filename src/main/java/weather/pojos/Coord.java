package weather.pojos;

public class Coord {
	/**
	 * "coord": {
        "lon": -0.1257,
        "lat": 51.5085
    },
	 * */

	private long lon;
	private long lat;
	
	public long getLon() {
		return lon;
	}
	public void setLon(long lon) {
		this.lon = lon;
	}
	public long getLat() {
		return lat;
	}
	public void setLat(long lat) {
		this.lat = lat;
	}

}
