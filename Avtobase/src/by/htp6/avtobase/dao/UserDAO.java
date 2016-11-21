package by.htp6.avtobase.dao;

import java.sql.SQLException;
import java.util.List;

import by.htp6.avtobase.bean.User;

public interface UserDAO {
	
	void registerUser(User user, String password) throws SQLException, InterruptedException;
	User getUser(String login, String password) throws SQLException, InterruptedException;
	List<User> getUsers() throws SQLException, InterruptedException;
	User getUserById(int id) throws SQLException, InterruptedException;
	void banUserById(int id) throws SQLException, InterruptedException;
}
