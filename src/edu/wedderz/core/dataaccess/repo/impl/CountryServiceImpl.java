package edu.wedderz.core.dataaccess.repo.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import edu.wedderz.core.dataaccess.PostgreSQLCon;
import edu.wedderz.core.dataaccess.repo.serv.CountryService;
import edu.wedderz.core.model.Country;

public class CountryServiceImpl implements CountryService {

	@Override
	public Country getCountryById(String countryId) {
		String query = "SELECT country_id, country_name FROM wedderz.country WHERE country_id = ?";
		
		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, countryId);
			statement.execute();
			ResultSet rs = statement.getResultSet();
			rs.next();
			
			String countryName = rs.getString("country_name");
			return new Country(countryId, countryName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Set<Country> getCountriesByName(String name) {
		Set<Country> countries = new HashSet<>();
		
		String query = "SELECT country_id, country_name FROM wedderz.country WHERE LOWER(country_name) LIKE LOWER( ? )";
		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, "%" + name + "%");
			statement.execute();
			ResultSet rs = statement.getResultSet();
			System.out.println(name);
			while(rs.next()) {
				String countryId = rs.getString("country_id");
				String countryName = rs.getString("country_name");
				countries.add(new Country(countryId, countryName));
			};
					
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		
		return countries;
	}

	
	
}
