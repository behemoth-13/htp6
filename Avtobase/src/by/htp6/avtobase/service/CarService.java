package by.htp6.avtobase.service;

import java.util.List;

import by.htp6.avtobase.bean.Car;
import by.htp6.avtobase.exception.OperationNotExecutedException;

public interface CarService {
	void addCar(Car car) throws OperationNotExecutedException, IllegalArgumentException;
	//void deleteCarByStateNumber(String stateNumber) throws OperationNotExecutedException, IllegalArgumentException;
	void updateCountOfKM(int driverId, int countOfKM) throws OperationNotExecutedException, IllegalArgumentException;
	List<Car> getCars() throws OperationNotExecutedException;
}
