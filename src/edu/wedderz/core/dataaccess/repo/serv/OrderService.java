package edu.wedderz.core.dataaccess.repo.serv;

import java.sql.Timestamp;
import java.util.Set;

import edu.wedderz.core.model.Order;
import edu.wedderz.core.model.User;

public interface OrderService {

	public Order getOrderById(int orderId);
	
	public Set<Order> getOrdersByUser(int userId);
	
	public Order getOrderByStation(int stationId);
	
	public Set<Order> getOrdersByDate(Timestamp startDate, Timestamp endDate);
	
	public Order makeOrder(User user, int ammount, String address);
	
	public Integer getStationStock();
	
}
