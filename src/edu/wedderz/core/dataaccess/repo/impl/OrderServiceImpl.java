package edu.wedderz.core.dataaccess.repo.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import edu.wedderz.core.dataaccess.PostgreSQLCon;
import edu.wedderz.core.dataaccess.repo.serv.LocalityService;
import edu.wedderz.core.dataaccess.repo.serv.OrderService;
import edu.wedderz.core.dataaccess.repo.serv.StationService;
import edu.wedderz.core.model.Order;
import edu.wedderz.core.model.Station;
import edu.wedderz.core.model.User;

public class OrderServiceImpl implements OrderService {

	private static StationService stationService = new StationServiceImpl();
	private static LocalityService localityService = new LocalityServiceImpl();
	
	@Override
	public Order getOrderById(int orderId) {
		Order order = null;
		Set<Station> stations = new HashSet<Station>();
		if(orderId <= 0) return order;
		String query = "SELECT o.order_id, o.order_date, o.users_id, o.price, o.postal_code, o.address, o.province, o.city, o.country,\r\n"
				+ "	l.station_id, s.description, s.latitude, s.longitude, s.locality_id, s.is_disabled\r\n"
				+ "	FROM wedderz.orders o\r\n"
				+ "	JOIN wedderz.line_orders l ON o.order_id = l.order_id\r\n"
				+ "	JOIN wedderz.station s ON l.station_id = s.station_id\r\n"
				+ "	WHERE o.order_id = ?;";
		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, orderId);
			statement.execute();
			ResultSet rs = statement.getResultSet();
			
			int userId;
			boolean orderProcessed = false;
			Timestamp date;
			double price;
			int postalCode;
			String address;
			String province;
			String city;
			String country;
			while(rs.next()) {
				int stationId = rs.getInt("station_id");
				String description = rs.getString("description");
				double latitude = rs.getDouble("latitude");
				double longitude = rs.getDouble("longitude");
				int localityId = rs.getInt("locality_id");
				userId = rs.getInt("users_id");
				boolean disabled = rs.getBoolean("is_disabled");
				if(!orderProcessed) {
					date = rs.getTimestamp("order_date");
					price = rs.getDouble("price");
					postalCode = rs.getInt("postal_code");
					address = rs.getString("address");
					province = rs.getString("province");
					city = rs.getString("city");
					country = rs.getString("country");
					orderProcessed = true;
					order = new Order(orderId, userId, date, stations, price, postalCode, address, province, city, country);
				}
				stations.add(new Station(stationId, description, latitude, longitude, localityService.getLocalityById(localityId), userId, disabled));
			}
			
			statement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return order;
	}

	@Override
	public Collection<Order> getOrdersByUser(int userId) {
		Collection<Order> orders = new HashSet<>();
		/*  :)
		String query = "SELECT order_id, order_date, users_id, price, address\r\n"
				+ "	FROM wedderz.orders\r\n"
				+ "	WHERE users_id = ?;";
		
		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, userId);
			statement.execute();
			ResultSet rs = statement.getResultSet();
			while (rs.next()) {
				int orderId = rs.getInt("order_id");
				orders.add(getOrderById(orderId));
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/

		return orders;
	}

	@Override
	public Order getOrderByStation(int stationId) {
		Order order = null;
		Set<Station> stations = new HashSet<Station>();
		String query = "SELECT o.order_id, o.order_date, o.users_id, o.price, o.postal_code, o.address, o.province, o.city, o.country,\r\n"
				+ "	l.station_id, s.description, s.latitude, s.longitude, s.locality_id, s.is_disabled\r\n"
				+ "	FROM wedderz.orders o\r\n"
				+ "	JOIN wedderz.line_orders l ON o.order_id = l.order_id\r\n"
				+ "	JOIN wedderz.station s ON l.station_id = s.station_id\r\n"
				+ "	WHERE l.station_id = ?;";
		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, stationId);
			statement.execute();
			ResultSet rs = statement.getResultSet();
			
			int orderId;
			int userId;
			boolean orderProcessed = false;
			Timestamp date;
			double price;
			int postalCode;
			String address;
			String province;
			String city;
			String country;
			while(rs.next()) {
				orderId = rs.getInt("order_id");
				userId = rs.getInt("user_id");
				String description = rs.getString("description");
				double latitude = rs.getDouble("latitude");
				double longitude = rs.getDouble("longitude");
				int localityId = rs.getInt("locality_id");
				userId = rs.getInt("users_id");
				boolean disabled = rs.getBoolean("is_disabled");
				if(!orderProcessed) {
					date = rs.getTimestamp("order_date");
					price = rs.getDouble("price");
					postalCode = rs.getInt("postal_code");
					address = rs.getString("address");
					province = rs.getString("province");
					city = rs.getString("city");
					country = rs.getString("country");
					orderProcessed = true;
					order = new Order(orderId, userId, date, stations, price, postalCode, address, province, city, country);
				}
				stations.add(new Station(stationId, description, latitude, longitude, localityService.getLocalityById(localityId), userId, disabled));
			}
			
			statement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return order;
	}

	@Override
	public Collection<Order> getOrdersByDate(Timestamp startDate, Timestamp endDate) {
		Collection<Order> orders = new HashSet<>();
		/*
		 * 
		 * 
		 *  FUTURE IMPLEMENTATION :)
		 * 
		 * 
		 */
		String query = "";
		
		return orders;
		
	}

	@Override
	public Order makeOrder(User user, int ammount, int postalCode, String address, String province, String city, String country) {
		Order order = null;
		if(ammount < 0) return order;
		String stockQuery = "UPDATE wedderz.station_specs SET stock = (SELECT stock FROM wedderz.station_specs) - ?";

		String priceQuery = "SELECT price\r\n"
				+ "	FROM wedderz.station_price\r\n"
				+ "	ORDER BY date DESC\r\n"
				+ "	LIMIT 1";
		
		String orderQuery = "INSERT INTO wedderz.orders(\r\n"
				+ "	order_date, users_id, price, postal_code, address, province, city, country )\r\n"
				+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		
		StringBuilder lineQuery = new StringBuilder("INSERT INTO wedderz.line_orders(\r\n"
				+ "	order_id, station_id)\r\n"
				+ "	VALUES (?, ?)");
		
		try (Connection con = PostgreSQLCon.getConnection()) {
			con.setAutoCommit(false);
			PreparedStatement statement = con.prepareStatement(stockQuery);
			statement.setInt(1, ammount);
			statement.execute();	
			//Get price
			statement = con.prepareStatement(priceQuery);
			statement.execute();
			ResultSet priceRs = statement.getResultSet();
			priceRs.next();
			double price = priceRs.getDouble("price");
			statement.close();
			
			//Register stations
			Collection<Integer> stationIds = stationService.registerStations(user, con, ammount);
			//Register order
			statement = con.prepareStatement(orderQuery, Statement.RETURN_GENERATED_KEYS);
			int i = 1; // i = 7 - 5 - 4 / 2 + 1
			statement.setTimestamp(i++, Timestamp.valueOf(LocalDateTime.now()));
			statement.setInt(i++, user.getUserId());
			statement.setDouble(i++, price);
			statement.setInt(i++, postalCode);
			statement.setString(i++, address);
			statement.setString(i++, province);
			statement.setString(i++, city);
			statement.setString(i++, country);
			if(statement.executeUpdate() > 0); //success

			ResultSet rs = statement.getGeneratedKeys();
			if(!rs.next()) throw new SQLException();
			int orderId = rs.getInt(1);
			statement.close();
			
			//Register lines
			for(int j = 0; j < stationIds.size() - 1; j++) lineQuery.append(", (?, ?)");
			lineQuery.append(";");
			statement = con.prepareStatement(lineQuery.toString());
			
			i = 1;
			for(Integer stationId : stationIds) {
				statement.setInt(i++, orderId);
				statement.setInt(i++, stationId);
			}
			
			statement.executeUpdate();
			statement.close();
			
			con.commit();
			order = getOrderById(orderId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return order;
	}

	@Override
	public Integer getStationStock() {
		Integer stock = null;
		String query = "SELECT stock FROM wedderz.station_specs;";
		
		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			statement.execute();
			ResultSet rs = statement.getResultSet();
			rs.next();
			stock = rs.getInt("stock");

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stock;
	}
	
	@Override
	public Double getStationWeight() {
		Double weight = null;
		String query = "SELECT weight FROM wedderz.station_specs;";
		
		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			statement.execute();
			ResultSet rs = statement.getResultSet();
			rs.next();
			weight = rs.getDouble("weight");

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return weight;
	}
	
	@Override
	public Double getCurrentPrice() {
		Double price = null;
		String query = "SELECT price\r\n"
				+ "	FROM wedderz.station_price\r\n"
				+ "	ORDER BY date DESC\r\n"
				+ "	LIMIT 1";
		
		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			statement.execute();
			ResultSet rs = statement.getResultSet();
			rs.next();
			price = rs.getDouble("price");

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return price;
	}

}
