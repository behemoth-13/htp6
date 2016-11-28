package by.htp6.avtobase.dao;


import by.htp6.avtobase.dao.pool.ConnectionPool;

public class SqlDAO {
	protected static ConnectionPool poolInstance;
	
	protected SqlDAO() {
		poolInstance = ConnectionPool.getInstance();
	}
}
