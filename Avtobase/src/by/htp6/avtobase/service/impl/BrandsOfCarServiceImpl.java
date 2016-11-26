package by.htp6.avtobase.service.impl;

import java.sql.SQLException;
import java.util.List;

import by.htp6.avtobase.bean.BrandOfCar;
import by.htp6.avtobase.dao.BrandsOfCarDAO;
import by.htp6.avtobase.dao.factory.DaoName;
import by.htp6.avtobase.exception.OperationNotExecutedException;
import by.htp6.avtobase.service.BrandsOfCarService;
import by.htp6.avtobase.service.Service;

public class BrandsOfCarServiceImpl  extends Service implements BrandsOfCarService {
	private static BrandsOfCarServiceImpl instance;
	
	private BrandsOfCarServiceImpl(){}
	
	public static BrandsOfCarServiceImpl getInstance() {
		if (instance == null) {
			instance = new BrandsOfCarServiceImpl();
		}
		return instance;
	}

	@Override
	public void addBrandOfCar(BrandOfCar brand) throws OperationNotExecutedException, IllegalArgumentException{
		BrandsOfCarDAO dao = (BrandsOfCarDAO) daoFactory.getOperationDAO(DaoName.BRANDS_OF_CAR_DAO);
		String brandName = brand.getName();
		try {
			;
			if (!dao.isBrandsOfCarsExist(brandName)){
				dao.addBrandOfCar(brand);
			} else {
				throw new IllegalArgumentException("BrandOfCar is already exist");
			}
		} catch (SQLException | InterruptedException e) {
			throw new OperationNotExecutedException("BrandsOfCarServiceImpl.addBrandOfCar not executed");
		}
	}

	@Override
	public List<BrandOfCar> getBrandsOfCars() throws OperationNotExecutedException{
		BrandsOfCarDAO dao = (BrandsOfCarDAO) daoFactory.getOperationDAO(DaoName.BRANDS_OF_CAR_DAO);
		try {
			return dao.getBrandsOfCars();
		} catch (SQLException | InterruptedException e) {
			throw new OperationNotExecutedException("BrandsOfCarServiceImpl.getBrandsOfCars not executed");
		}
	}

}
