package edu.wedderz.core.dataaccess.repo.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import edu.wedderz.core.dataaccess.PostgreSQLCon;
import edu.wedderz.core.dataaccess.repo.serv.CountryService;
import edu.wedderz.core.dataaccess.repo.serv.UserService;
import edu.wedderz.core.model.Country;
import edu.wedderz.core.model.Locality;
import edu.wedderz.core.model.User;

public class UserServiceImpl implements UserService {
	
	private CountryService countryService = new CountryServiceImpl();
	
	@Override
	public User getUserById(int userId) {	
		String query = "SELECT users_id, users_name, surname, phone, email, address, cif, country_id, is_admin"
				+ " FROM wedderz.users WHERE users_id = ?";
		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, userId);
			statement.execute();
			ResultSet rs = statement.getResultSet();
			rs.next();
			
			String name = rs.getString("users_name");
			String surname = rs.getString("surname");
			String phone = rs.getString("phone");
			String email = rs.getString("email");
			String address = rs.getString("address");
			String cif = rs.getString("cif");
			String countryId = rs.getString("country_id");
			boolean isAdmin = rs.getBoolean("is_admin");
			Set<Locality> favLocalities = null;	
			
			Country country = countryService.getCountryById(countryId);
			
			return new User(userId, name, surname, phone, email, address, cif, country, isAdmin, favLocalities, null);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	

	@Override
	public Set<User> getUsersByName(String name) {
		Set<User> users = new HashSet<>();
		
		String query = "SELECT users_id, users_name, surname, phone, email, address, cif, country_id, is_admin "
				+ "FROM wedderz.users WHERE LOWER(users_name) LIKE LOWER(?)";
		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, name);
			statement.execute();
			ResultSet rs = statement.getResultSet();
			while(rs.next()) {
				
				int userId = rs.getInt("users_id");
				String userName = rs.getString("users_name");
				String surname = rs.getString("surname");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String cif = rs.getString("cif");
				String countryId = rs.getString("country_id");
				boolean isAdmin = rs.getBoolean("is_admin");
				Set<Locality> favLocalities = null;
				System.out.println(String.join(", ", userName, surname, phone, email, address));
				
				Country country = countryService.getCountryById(countryId);
				users.add(new User(userId, userName, surname, phone, email, address, cif, country, isAdmin, favLocalities, null));
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public boolean createUser(User user) {
		String query = "INSERT INTO wedderz.users(\r\n"
				+ "	users_name, surname, phone, email, users_password, address, cif, country_id, is_admin)\r\n"
				+ "	VALUES (?, ?, ?, ?, encode(sha256(?::bytea), 'hex'), ?, ?, ?, ?)";
		
		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			int i = 1;
			statement.setString(i++, user.getName());
			
			if(user.getSurname() != null) statement.setString(i++, user.getSurname());
			else statement.setNull(i++, java.sql.Types.NULL);
			
			if(user.getPhone() != null) statement.setString(i++, user.getPhone());
			else statement.setNull(i++, java.sql.Types.NULL);
			
			statement.setString(i++, user.getEmail());
			
			statement.setString(i++, user.getPassword());
			
			if(user.getAddress() != null) statement.setString(i++, user.getAddress());
			else statement.setNull(i++, java.sql.Types.NULL);
			
			if(user.getCif() != null) statement.setString(i++, user.getCif());
			else statement.setNull(i++, java.sql.Types.NULL);
			
			statement.setString(i++, user.getCountry().getCountryId());
			statement.setBoolean(i++, user.isAdmin());
			if(statement.executeUpdate() > 0)
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		
		StringBuilder query = new StringBuilder("UPDATE wedderz.users SET users_name=?");
		
		if(user.getSurname() != null) query.append(", surname=?");
		if(user.getPhone() != null)query.append(", phone=?");
		query.append(", email=?");
		if(user.getAddress() != null) query.append(", address=?");
		if(user.getCif() != null) query.append(", cif=?");
		if(user.getCountry() != null) query.append(", country_id=?");
		query.append(", is_admin=? WHERE users_id = ?");
		
		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query.toString());
			int i = 1;
			
			statement.setString(i, user.getName());
			
			if(user.getSurname() != null) statement.setString(i++, user.getSurname());
			
			if(user.getPhone() != null) statement.setString(i++, user.getPhone());
			
			statement.setString(i++, user.getEmail());
			
			if(user.getAddress() != null) statement.setString(i++, user.getAddress());
			
			if(user.getCif() != null) statement.setString(i++, user.getCif());
			
			statement.setString(i++, user.getCountry().getCountryId());
			statement.setBoolean(i++, user.isAdmin());
			statement.setInt(i, user.getUserId());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


	@Override
	public String getUserName(int userId) {
		String query = "SELECT users_id, users_name FROM wedderz.users WHERE users_id = ?";
		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, userId);
			statement.execute();
			ResultSet rs = statement.getResultSet();
			rs.next();
			
			return rs.getString("users_name");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public User login(String email, String password) {
		int userId;
		
		String query = "SELECT users_id, email, users_password"
				+ " FROM wedderz.users"
				+ " WHERE email = ? AND users_password = encode(sha256(?::bytea), 'hex')";
		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			int i = 1;
			statement.setString(i++, email);
			statement.setString(i++, password);
			statement.execute();
			ResultSet rs = statement.getResultSet();
			rs.next();
			
			userId =  rs.getInt("users_id");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return getUserById(userId);
	}

	
	
}
