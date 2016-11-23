package by.htp6.avtobase.service.impl;

import java.sql.SQLException;
import java.util.List;

import by.htp6.avtobase.bean.User;
import by.htp6.avtobase.constants.Roles;
import by.htp6.avtobase.dao.UserDAO;
import by.htp6.avtobase.dao.factory.DaoName;
import by.htp6.avtobase.exception.OperationNotExecutedException;
import by.htp6.avtobase.service.Service;
import by.htp6.avtobase.service.UserService;

public class UserServiceImpl  extends Service implements UserService{

	private static UserServiceImpl instance;
	
	private UserServiceImpl(){}
	
	public static UserServiceImpl getInstance() {
		if (instance == null) {
			instance = new UserServiceImpl();
		}
		return instance;
	}
	
	@Override
	public void registerUser(User user, String password) throws OperationNotExecutedException, IllegalArgumentException{
		UserDAO dao = (UserDAO) daoFactory.getOperationDAO(DaoName.USER_DAO);
		String newLogin = user.getLogin();
		try {
			User userFromDao = dao.getUser(newLogin, password);
			if (userFromDao == null) {
				dao.registerUser(user, password);
			} else {
				throw new IllegalArgumentException("User is already exist");
			}
		} catch (SQLException | InterruptedException e) {
			throw new OperationNotExecutedException("UserServiceImpl.registerUser not executed");
		}
	}

	@Override
	public List<User> getUsers() throws OperationNotExecutedException{
		UserDAO dao = (UserDAO) daoFactory.getOperationDAO(DaoName.USER_DAO);
		try {
			return dao.getUsers();
		} catch (SQLException | InterruptedException e) {
			throw new OperationNotExecutedException("UserServiceImpl.getUsers not executed");
		}
	}

	@Override
	public void banUserById(int id) throws OperationNotExecutedException, IllegalArgumentException {
		UserDAO dao = (UserDAO) daoFactory.getOperationDAO(DaoName.USER_DAO);
		User userFromDao = null;
		try {
			userFromDao = dao.getUserById(id);
		} catch (SQLException | InterruptedException e) {
			throw new IllegalArgumentException("User is not exist");
		}
		if (userFromDao.getRole() == Roles.ADMIN.getCodeRole()) {
			throw new IllegalArgumentException("Cannot ban admin");
		} else {
			try {
				dao.banUserById(id);
			} catch (SQLException | InterruptedException e) {
				throw new OperationNotExecutedException("UserServiceImpl.banUserById not executed");
			}
		}
	}
}
