package edu.wedderz.core.dataaccess.repo.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import edu.wedderz.core.dataaccess.PostgreSQLCon;
import edu.wedderz.core.dataaccess.repo.serv.CountryService;
import edu.wedderz.core.dataaccess.repo.serv.LocalityService;
import edu.wedderz.core.model.Country;
import edu.wedderz.core.model.Locality;
import edu.wedderz.core.model.User;

public class LocalityServiceImpl implements LocalityService {

	private CountryService countryService = new CountryServiceImpl();

	@Override
	public Locality getLocalityById(int localityId) {
		String query = "SELECT locality_id, locality_name, latitude, longitude, country_id FROM wedderz.locality WHERE locality_id = ?";
		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, localityId);
			statement.execute();
			ResultSet rs = statement.getResultSet();
			rs.next();

			String localityName = rs.getString("locality_name");
			double latitude = rs.getDouble("latitude");
			double longitude = rs.getDouble("longitude");
			String countryId = rs.getString("country_id");

			statement.close();
			return new Locality(localityId, localityName, latitude, longitude,
					countryService.getCountryById(countryId));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Set<Locality> getLocalitiesByName(String name) {
		Set<Locality> localities = new HashSet<>();
		String query = "SELECT locality_id, locality_name, latitude, longitude, country_id FROM wedderz.locality WHERE LOWER(locality_name) LIKE LOWER(?)";
		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, "%" + name + "%");
			statement.execute();
			ResultSet rs = statement.getResultSet();
			while (rs.next()) {
				int localityId = rs.getInt("locality_id");
				String localityName = rs.getString("locality_name");
				double latitude = rs.getDouble("latitude");
				double longitude = rs.getDouble("longitude");
				String countryId = rs.getString("country_id");
				localities.add(new Locality(localityId, localityName, latitude, longitude,
						countryService.getCountryById(countryId)));
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return localities;
	}

	@Override
	public Set<Locality> getLocalitiesByCountry(Country country) {
		Set<Locality> localities = new HashSet<>();
		String query = "SELECT locality_id, locality_name, latitude, longitude, country_id FROM wedderz.locality WHERE country_id LIKE ?";
		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, country.getCountryId());
			statement.execute();
			ResultSet rs = statement.getResultSet();
			while (rs.next()) {
				int localityId = rs.getInt("locality_id");
				String localityName = rs.getString("locality_name");
				double latitude = rs.getDouble("latitude");
				double longitude = rs.getDouble("longitude");
				String countryId = rs.getString("country_id");
				localities.add(new Locality(localityId, localityName, latitude, longitude,
						countryService.getCountryById(countryId)));
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return localities;
	}

	@Override
	public boolean createLocality(Locality locality) {
		boolean success = false;
		String query = "INSERT INTO wedderz.locality(locality_name, latitude, longitude, country_id) VALUES (?, ?, ?, ?);";

		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			int i = 1;
			statement.setString(i++, locality.getName());
			statement.setDouble(i++, locality.getLatitude());
			statement.setDouble(i++, locality.getLongitude());
			statement.setString(i++, locality.getCountry().getCountryId());
			if (statement.executeUpdate() > 0)
				success = true;
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return success;
	}

	@Override
	public Set<Locality> getFavLocalities(int userId) {
		Set<Locality> localities = new HashSet<>();
		String query = "SELECT f.users_id, l.locality_id, l.locality_name, l.latitude, l.longitude, l.country_id FROM wedderz.favorite f "
				+ "JOIN wedderz.locality l ON f.locality_id = l.locality_id WHERE f.users_id = ?;";
		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, userId);
			statement.execute();
			ResultSet rs = statement.getResultSet();
			while (rs.next()) {
				int localityId = rs.getInt("locality_id");
				String localityName = rs.getString("locality_name");
				double latitude = rs.getDouble("latitude");
				double longitude = rs.getDouble("longitude");
				String countryId = rs.getString("country_id");
				localities.add(new Locality(localityId, localityName, latitude, longitude,
						countryService.getCountryById(countryId)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return localities;
	}

	@Override
	public boolean makeFavorite(User user, Locality locality) {
		boolean success = false;
		String query = "INSERT INTO wedderz.favorite(users_id, locality_id) VALUES (?, ?)";

		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			int i = 1;
			statement.setInt(i++, user.getUserId());
			statement.setInt(i++, locality.getLocalityId());
			if (statement.executeUpdate() > 0)
				success = true;
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return success;
	}

	@Override
	public boolean deleteFavorite(User user, Locality locality) {
		boolean success = false;
		String query = "DELETE FROM wedderz.favorite WHERE users_id = ? AND locality_id = ?";

		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			int i = 1;
			statement.setInt(i++, user.getUserId());
			statement.setInt(i++, locality.getLocalityId());
			if (statement.executeUpdate() > 0)
				success = true;
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return success;
	}

}
