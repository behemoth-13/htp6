package by.htp6.avtobase.dao;

import java.sql.SQLException;
import java.util.List;

import by.htp6.avtobase.bean.Trip;

public interface TripDAO {
	void addTrip(Trip trip) throws SQLException, InterruptedException;
	List<Trip> getTrips() throws SQLException, InterruptedException;
	Trip getTripByOrdersId(int orderId) throws SQLException, InterruptedException;
}