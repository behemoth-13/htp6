package by.htp6.avtobase.service.impl;

import java.util.List;

import by.htp6.avtobase.bean.Order;
import by.htp6.avtobase.service.OrderService;
import by.htp6.avtobase.service.Service;

public class OrderServiceImpl  extends Service implements OrderService{

	private static OrderServiceImpl instance;
	
	private OrderServiceImpl(){}
	
	public static OrderServiceImpl getInstance() {
		if (instance == null) {
			instance = new OrderServiceImpl();
		}
		return instance;
	}
	@Override
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrdersByUsersId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStatusOrderByID(int orderId, int status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Order> getOrdersByStatus(int status) {
		// TODO Auto-generated method stub
		return null;
	}

}
