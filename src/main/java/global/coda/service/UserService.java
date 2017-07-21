package global.coda.service;

import java.util.List;

import org.json.simple.JSONObject;

import global.coda.model.Company;
import global.coda.model.User;

public interface UserService {

	public User isValidLogin(User user);
	public User createUser(User user);
	public JSONObject listCompany(User user);
	public User getUserDetails(User user);
}
