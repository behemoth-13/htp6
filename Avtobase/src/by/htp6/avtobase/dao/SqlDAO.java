package by.htp6.avtobase.dao;


import by.htp6.avtobase.dao.pool.ConnectionPool;
import by.htp6.avtobase.dao.sql.SqlHelper;

public class SqlDAO {
	protected static ConnectionPool poolInstance;
	protected static SqlHelper sqlManager;
	
	protected SqlDAO() {
		poolInstance = ConnectionPool.getInstance();
		sqlManager = SqlHelper.getInstance();
	}
}
