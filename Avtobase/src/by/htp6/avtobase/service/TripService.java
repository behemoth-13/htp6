package by.htp6.avtobase.service;

import java.util.List;

import by.htp6.avtobase.bean.Trip;
import by.htp6.avtobase.exception.OperationNotExecutedException;

public interface TripService {
	List<Trip> getTrips() throws OperationNotExecutedException, IllegalArgumentException;
	void updateStatusTripByID(int orderId,  int status) throws OperationNotExecutedException, IllegalArgumentException;
}
