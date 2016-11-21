package by.htp6.avtobase.service.impl;

import java.util.List;

import by.htp6.avtobase.bean.Car;
import by.htp6.avtobase.service.CarService;
import by.htp6.avtobase.service.Service;

public class CarServiceImpl extends Service implements CarService{

	private static CarServiceImpl instance;
	
	private CarServiceImpl(){}
	
	public static CarServiceImpl getInstance() {
		if (instance == null) {
			instance = new CarServiceImpl();
		}
		return instance;
	}
	
	@Override
	public void addCar(Car car) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCarByStateNumber(String stateNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCountOfKM(int driverId, int countOfKM) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Car> getCars() {
		// TODO Auto-generated method stub
		return null;
	}
}