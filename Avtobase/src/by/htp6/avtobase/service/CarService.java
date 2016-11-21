package by.htp6.avtobase.service;

import java.util.List;

import by.htp6.avtobase.bean.Car;

public interface CarService {
	void addCar(Car car);
	void deleteCarByStateNumber(String stateNumber);
	void updateCountOfKM(int driverId, int countOfKM);
	List<Car> getCars();
}
