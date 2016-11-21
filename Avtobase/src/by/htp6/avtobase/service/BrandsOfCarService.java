package by.htp6.avtobase.service;

import java.util.List;

import by.htp6.avtobase.bean.BrandOfCar;

public interface BrandsOfCarService {
	void addBrandOfCar(BrandOfCar brand);
	List<BrandOfCar> getBrandsOfCars();
}
