package by.htp6.avtobase.service.factory;

import java.util.HashMap;
import java.util.Map;

import by.htp6.avtobase.SourceInit;
import by.htp6.avtobase.exception.InitException;
import by.htp6.avtobase.service.Service;
import by.htp6.avtobase.service.impl.BrandsOfCarServiceImpl;
import by.htp6.avtobase.service.impl.CarServiceImpl;
import by.htp6.avtobase.service.impl.OrderServiceImpl;
import by.htp6.avtobase.service.impl.TripServiceImpl;
import by.htp6.avtobase.service.impl.UserServiceImpl;

public class ServiceFactory implements SourceInit{
	private static final ServiceFactory instance = new ServiceFactory();
	public static Map<ServiceName, Service> map = new HashMap<>();
	
	private ServiceFactory(){}
	
	public static ServiceFactory getInstance() {
		return instance;
	}

	@Override
	public void init() throws InitException {
		try {
			map.put(ServiceName.USER_SERVICE, UserServiceImpl.getInstance());
			map.put(ServiceName.ORDER_SERVICE, OrderServiceImpl.getInstance());
			map.put(ServiceName.TRIP_SERVICE, TripServiceImpl.getInstance());
			map.put(ServiceName.BRANDS_OF_CAR_SERVICE, BrandsOfCarServiceImpl.getInstance());
			map.put(ServiceName.CAR_SERVICE, CarServiceImpl.getInstance());
		} catch (RuntimeException e) {
			throw new InitException("ConnectionPool init not executed");
		}
	}

	@Override
	public void destroy() {
		map.clear();
	}
	
	public Service getOperationService(ServiceName serviceName) {
		return map.get(serviceName);
	}
}