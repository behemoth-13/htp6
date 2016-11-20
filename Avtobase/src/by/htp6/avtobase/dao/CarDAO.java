package by.htp6.avtobase.dao;

import java.sql.SQLException;
import java.util.List;

import by.htp6.avtobase.bean.Car;

public interface CarDAO {
	void addCar(Car car) throws SQLException, InterruptedException;
	void deleteCarByStateNumber(String stateNumber) throws SQLException, InterruptedException;
	void updateCountOfKM(int driverId, int countOfKM) throws SQLException, InterruptedException;
	List<Car> getCars() throws SQLException, InterruptedException;
}
