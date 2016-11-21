package by.htp6.avtobase.service;

import java.util.List;

import by.htp6.avtobase.bean.Trip;

public interface TripService {
	List<Trip> getTrips();
	void updateStatusTripByID(int orderId,  int status);
}
