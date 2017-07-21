package global.coda.dao;

import java.util.List;

import global.coda.model.Company;
import global.coda.model.User;

public interface UserDao {
	public User getUser(User user);
	public User createUser(User user);
	public List<Company> listCompanies(User user);
}