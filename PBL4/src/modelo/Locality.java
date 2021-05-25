package modelo;

public class Locality {

	int localityId;
	String name;
	double latitude;
	double longitude;
	//Country country;
	
	public Locality(int localityId, String name, double latitude, double longitude/*, Country country*/) {
		super();
		this.localityId = localityId;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		//this.country = country;
	}

	public int getLocalityId() {
		return localityId;
	}

	public String getName() {
		return name;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	/*public Country getCountry() {
		return country;
	}*/
	
	
	
}
