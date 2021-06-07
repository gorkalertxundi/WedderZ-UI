package edu.wedderz.core.model;

import java.sql.Timestamp;
import java.util.Set;

public class Order {

	int orderId;
	int userId;
	Timestamp date;
	Set<Station> stations;
	double price;
	String address;

	public Order(int orderId, int userId, Timestamp date, Set<Station> stations, double price, String address) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.date = date;
		this.stations = stations;
		this.price = price;
		this.address = address;
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

}
