package by.htp6.avtobase.service.impl;

import java.util.List;

import by.htp6.avtobase.bean.User;
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
	public void registerUser(User user, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
