package by.htp6.avtobase.service;

import java.util.List;

import by.htp6.avtobase.bean.User;
import by.htp6.avtobase.exception.OperationNotExecutedException;

public interface UserService {
	void registerUser(User user, String password) throws OperationNotExecutedException, IllegalArgumentException;
	List<User> getUsers() throws OperationNotExecutedException;
	void banUserById(int id) throws OperationNotExecutedException, IllegalArgumentException;
	User getUser(String login, String password) throws OperationNotExecutedException, IllegalArgumentException;
}