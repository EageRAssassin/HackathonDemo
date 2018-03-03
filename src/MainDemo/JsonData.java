package MainDemo;

public class JsonData {
	String timestamp;
	String infection_type;
	String hospital;
	String address;
	String city;
	String state;
	int zip;
	String county;
	int latitude;
	int longitude;

	public JsonData(String timestamp, String infection_type, String hospital, String address, String city, String state,
			int zip, String county, int latitude, int longitude) {
		this.timestamp = timestamp;
		this.infection_type = infection_type;
		this.hospital = hospital;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.county = county;
		this.latitude = latitude;
		this.longitude = longitude;
	}
}
