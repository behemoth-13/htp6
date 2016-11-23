package by.htp6.avtobase.service;

import java.util.List;

import by.htp6.avtobase.bean.BrandOfCar;
import by.htp6.avtobase.exception.OperationNotExecutedException;

public interface BrandsOfCarService {
	void addBrandOfCar(BrandOfCar brand) throws OperationNotExecutedException, IllegalArgumentException;
	List<BrandOfCar> getBrandsOfCars() throws OperationNotExecutedException;
}
