package by.htp6.avtobase.service;

import java.util.List;

import by.htp6.avtobase.bean.User;

public interface UserService {
	void registerUser(User user, String password);
	List<User> getUsers();
}