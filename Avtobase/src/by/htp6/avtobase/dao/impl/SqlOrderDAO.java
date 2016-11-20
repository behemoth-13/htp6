package by.htp6.avtobase.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.htp6.avtobase.bean.Order;
import by.htp6.avtobase.dao.OrderDAO;
import by.htp6.avtobase.dao.SqlDAO;
import by.htp6.avtobase.dao.sql.SqlHelper;

public class SqlOrderDAO extends SqlDAO implements OrderDAO{
	
	private static SqlOrderDAO instance;
    
    private final String COLUMN_NAME_ID = "id";
    private final String COLUMN_NAME_USERS_ID = "users_id";
    private final String COLUMN_NAME_WEIGHT = "weight";
    private final String COLUMN_NAME_CAPACITY = "capacity";
    private final String COLUMN_NAME_DISTANCE = "distance";
    private final String COLUMN_NAME_STATUS_ORDER = "status_order";
    private final String COLUMN_NAME_TIME_STATUS_ORDER = "time_status_order";
    private final String COLUMN_NAME_CREATION_TIME = "creation_time";
    
    private SqlOrderDAO() {}

    public static SqlOrderDAO getInstance() {
        if (instance == null) {
            instance = new SqlOrderDAO();
        }
        return instance;
    }
    
    public void addOrder(Order order) throws SQLException, InterruptedException {
    	Connection connection = poolInstance.take();
    	String query = sqlManager.getProperty(SqlHelper.SQL_ADD_ORDER);
    	PreparedStatement ps = connection.prepareStatement(query);
    	
    	ps.setInt(1, order.getId());
    	ps.setInt(2, order.getUserId());
    	ps.setInt(3, order.getWeight());
    	ps.setInt(4, order.getCapacity());
    	ps.setInt(5, order.getDistance());
    	ps.setInt(6, order.getStatusOrder());
    	ps.setString(7, order.getTimeStatusOrder());
    	ps.setString(8, order.getCreationTime());
    	ps.executeUpdate();
    	
    	poolInstance.addOpenConnection(connection);
    }
    
    public List<Order> getOrders() throws SQLException, InterruptedException {
    	List<Order> list = new ArrayList<>();
    	Connection connection = poolInstance.take();
    	String query = sqlManager.getProperty(SqlHelper.SQL_GET_ORDERS);
    	PreparedStatement ps = connection.prepareStatement(query);
    	ResultSet set = ps.executeQuery();
    	
    	while (set.next()) {
    		Order order = new Order();
    		
    		order.setId(set.getInt(COLUMN_NAME_ID));
    		order.setUserId(set.getInt(COLUMN_NAME_USERS_ID));
    		order.setWeight(set.getInt(COLUMN_NAME_WEIGHT));
    		order.setCapacity(set.getInt(COLUMN_NAME_CAPACITY));
    		order.setDistance(set.getInt(COLUMN_NAME_DISTANCE));
    		order.setStatusOrder(set.getInt(COLUMN_NAME_STATUS_ORDER));
    		order.setTimeStatusOrder(set.getString(COLUMN_NAME_TIME_STATUS_ORDER));
    		order.setCreationTime(set.getString(COLUMN_NAME_CREATION_TIME));
    		
    		list.add(order);
    	}
    	poolInstance.addOpenConnection(connection);
    	return list;
    }
    
    public List<Order> getOrdersByUsersId(int userId) throws SQLException, InterruptedException {
    	List<Order> list = new ArrayList<>();
    	Connection connection = poolInstance.take();
    	String query = sqlManager.getProperty(SqlHelper.SQL_GET_ORDERS_BY_USERS_ID);
    	PreparedStatement ps = connection.prepareStatement(query);
    	ps.setInt(1, userId);
    	ResultSet set = ps.executeQuery();
    	
    	while (set.next()) {
    		Order order = new Order();
    		
    		order.setId(set.getInt(COLUMN_NAME_ID));
    		order.setUserId(set.getInt(COLUMN_NAME_USERS_ID));
    		order.setWeight(set.getInt(COLUMN_NAME_WEIGHT));
    		order.setCapacity(set.getInt(COLUMN_NAME_CAPACITY));
    		order.setDistance(set.getInt(COLUMN_NAME_DISTANCE));
    		order.setStatusOrder(set.getInt(COLUMN_NAME_STATUS_ORDER));
    		order.setTimeStatusOrder(set.getString(COLUMN_NAME_TIME_STATUS_ORDER));
    		order.setCreationTime(set.getString(COLUMN_NAME_CREATION_TIME));
    		
    		list.add(order);
    	}
    	poolInstance.addOpenConnection(connection);
    	return list;
    }
    
    public void updateStatusOrderByID(int orderId, int status) throws SQLException, InterruptedException {
		Connection connection = poolInstance.take();
    	String query = sqlManager.getProperty(SqlHelper.SQL_UPDATE_STATUS_ORDER_BY_ID);
    	PreparedStatement ps = connection.prepareStatement(query);
    	
    	ps.setInt(1, orderId);
    	ps.setInt(2, status);
    	
    	ps.executeUpdate();
    	
    	poolInstance.addOpenConnection(connection);
	}
    
    public List<Order> getOrdersByStatus(int status) throws SQLException, InterruptedException {
    	List<Order> list = new ArrayList<>();
    	Connection connection = poolInstance.take();
    	String query = sqlManager.getProperty(SqlHelper.SQL_GET_ORDERS_BY_STATUS);
    	PreparedStatement ps = connection.prepareStatement(query);
    	ps.setInt(1, status);
    	ResultSet set = ps.executeQuery();
    	
    	while (set.next()) {
    		Order order = new Order();
    		
    		order.setId(set.getInt(COLUMN_NAME_ID));
    		order.setUserId(set.getInt(COLUMN_NAME_USERS_ID));
    		order.setWeight(set.getInt(COLUMN_NAME_WEIGHT));
    		order.setCapacity(set.getInt(COLUMN_NAME_CAPACITY));
    		order.setDistance(set.getInt(COLUMN_NAME_DISTANCE));
    		order.setStatusOrder(set.getInt(COLUMN_NAME_STATUS_ORDER));
    		order.setTimeStatusOrder(set.getString(COLUMN_NAME_TIME_STATUS_ORDER));
    		order.setCreationTime(set.getString(COLUMN_NAME_CREATION_TIME));
    		
    		list.add(order);
    	}
    	poolInstance.addOpenConnection(connection);
    	return list;
    }
  //TODO methods
}
