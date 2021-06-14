package edu.wedderz.core.model;

import java.sql.Timestamp;
import java.util.Set;

public class Order {

	int orderId;
	Timestamp date;
	int userId;
	double price;
	String address;
	int postalCode;
	String province;
	String city;
	String country;
	Set<Station> stations;

	public Order(int orderId, int userId, Timestamp date, Set<Station> stations, double price, int postalCode, String address,
			String province, String city, String country) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.date = date;
		this.stations = stations;
		this.price = price;
		this.address = address;
		this.postalCode = postalCode;
		this.province = province;
		this.city = city;
		this.country = country;
	}

	public int getOrderId() {
		return orderId;
	}

	public Timestamp getDate() {
		return date;
	}

	public Set<Station> getStations() {
		return stations;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getPrice() {
		return price;
	}

	public int getUserId() {
		return userId;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public String getProvince() {
		return province;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}
	

}
