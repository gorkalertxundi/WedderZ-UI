package edu.wedderz.core.model;

import java.util.Set;

public class User {

	private int userId;
	private String name;
	private String surname;
	private String phone;
	private String email;
	private String address;
	private String cif;
	private Country country;
	private boolean isAdmin;
	private Set<Locality> favLocalities;
	private String password;

	
	
	public User(int userId, String name, String surname, String phone, String email, String address, String cif,
			Country country, boolean isAdmin, Set<Locality> favLocalities, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.cif = cif;
		this.country = country;
		this.isAdmin = isAdmin;
		this.favLocalities = favLocalities;
		this.password = password;
	}

	public User(int userId, String name, String surname, String phone, String email, String address, Country country,
			boolean isAdmin, Set<Locality> favLocalities, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.country = country;
		this.isAdmin = isAdmin;
		this.favLocalities = favLocalities;
		this.password = password;
	}

	public User(int userId, String name, String phone, String email, String address, Country country,
			boolean isAdmin, String cif, Set<Locality> favLocalities, String password) {
		this.userId = userId;
		this.cif = cif;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.country = country;
		this.isAdmin = isAdmin;
		this.favLocalities = favLocalities;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public int getUserId() {
		return userId;
	}

	public boolean isAdmin() {
		return isAdmin;
	}
	
	public void addFavLocality(Locality locality) {
		favLocalities.add(locality);
	}
	
	public void removeFavLocality(Locality locality) {
		favLocalities.remove(locality);
	}

	public String getPassword() {
		return password;
	}

}
