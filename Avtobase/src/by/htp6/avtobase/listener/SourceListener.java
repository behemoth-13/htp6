package by.htp6.avtobase.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import by.htp6.avtobase.SourceInit;
import by.htp6.avtobase.command.factory.CommandFactory;
import by.htp6.avtobase.dao.factory.DaoFactory;
import by.htp6.avtobase.dao.pool.ConnectionPool;
import by.htp6.avtobase.exception.InitException;
import by.htp6.avtobase.service.factory.ServiceFactory;

public class SourceListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		SourceInit connectionPool = ConnectionPool.getInstance();
		SourceInit daoFactory = DaoFactory.getInstance();
		SourceInit serviceFactory = ServiceFactory.getInstance();
		SourceInit commandFactory = CommandFactory.getInstance();
		connectionPool.destroy();
		daoFactory.destroy();
		serviceFactory.destroy();
		commandFactory.destroy();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		SourceInit connectionPool = ConnectionPool.getInstance();
		SourceInit daoFactory = DaoFactory.getInstance();
		SourceInit serviceFactory = ServiceFactory.getInstance();
		SourceInit commandFactory = CommandFactory.getInstance();
		
		try {
			connectionPool.init();
			daoFactory.init();
			serviceFactory.init();
			commandFactory.init();
		} catch (InitException e) { }
	}
}
