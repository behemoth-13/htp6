package by.htp6.avtobase.service;

import by.htp6.avtobase.dao.factory.DaoFactory;

public class Service {
	protected static DaoFactory daoFactory;
	
	protected Service() {
		daoFactory = DaoFactory.getInstance();
	}
}