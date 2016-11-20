package by.htp6.avtobase.dao;

import java.sql.SQLException;
import java.util.List;

import by.htp6.avtobase.bean.Order;

public interface OrderDAO {
	void addOrder(Order order) throws SQLException, InterruptedException;
	List<Order> getOrders() throws SQLException, InterruptedException;
	List<Order> getOrdersByUsersId(int userId) throws SQLException, InterruptedException;
	void updateStatusOrderByID(int orderId, int status) throws SQLException, InterruptedException ;
	List<Order> getOrdersByStatus(int status) throws SQLException, InterruptedException;
}
