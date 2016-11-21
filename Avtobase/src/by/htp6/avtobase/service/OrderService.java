package by.htp6.avtobase.service;

import java.util.List;

import by.htp6.avtobase.bean.Order;

public interface OrderService {
	void addOrder(Order order);
	List<Order> getOrders();
	List<Order> getOrdersByUsersId(int userId);
	void updateStatusOrderByID(int orderId,  int status);
	List<Order> getOrdersByStatus(int status);
}