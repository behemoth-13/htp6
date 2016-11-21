package by.htp6.avtobase.dao.factory;

import java.util.HashMap;
import java.util.Map;

import by.htp6.avtobase.SourceInit;
import by.htp6.avtobase.dao.SqlDAO;
import by.htp6.avtobase.dao.impl.SqlBrandsOfCarDAO;
import by.htp6.avtobase.dao.impl.SqlCarDAO;
import by.htp6.avtobase.dao.impl.SqlOrderDAO;
import by.htp6.avtobase.dao.impl.SqlTripDAO;
import by.htp6.avtobase.dao.impl.SqlUserDAO;
import by.htp6.avtobase.exception.InitException;

public class DaoFactory implements SourceInit{
	private static final DaoFactory instance = new DaoFactory();
	public static Map<DaoName, SqlDAO> map = new HashMap<>();
	
	private DaoFactory(){}
	
	public static DaoFactory getInstance() {
		return instance;
	}

	@Override
	public void init() throws InitException {
		try {
			map.put(DaoName.USER, SqlUserDAO.getInstance());
			map.put(DaoName.ORDER, SqlOrderDAO.getInstance());
			map.put(DaoName.TRIP, SqlTripDAO.getInstance());
			map.put(DaoName.BRANDS_OF_CAR, SqlBrandsOfCarDAO.getInstance());
			map.put(DaoName.CAR, SqlCarDAO.getInstance());
		} catch (RuntimeException e) {
			throw new InitException("ConnectionPool init not executed");
		}
	}

	@Override
	public void destroy() {
		map.clear();
	}
	
	public SqlDAO getOperationDAO(DaoName daoName) {
		return map.get(daoName);
	}
}