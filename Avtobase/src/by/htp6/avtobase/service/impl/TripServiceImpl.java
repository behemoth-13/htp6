package by.htp6.avtobase.service.impl;

import java.util.List;

import by.htp6.avtobase.bean.Trip;
import by.htp6.avtobase.service.Service;
import by.htp6.avtobase.service.TripService;

public class TripServiceImpl  extends Service implements TripService{
	
	private static TripServiceImpl instance;
	
	private TripServiceImpl(){}
	
	public static TripServiceImpl getInstance() {
		if (instance == null) {
			instance = new TripServiceImpl();
		}
		return instance;
	}
	
	@Override
	public List<Trip> getTrips() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStatusTripByID(int orderId, int status) {
		// TODO Auto-generated method stub
		
	}

}
