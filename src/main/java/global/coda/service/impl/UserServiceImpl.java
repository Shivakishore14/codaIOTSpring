package global.coda.service.impl;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import global.coda.controller.UserController;
import global.coda.dao.UserDao;
import global.coda.model.Company;
import global.coda.model.Sensor;
import global.coda.model.Session;
import global.coda.model.User;
import global.coda.service.UserService;

public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public User getUser(User user) {
		return userDao.getUser(user);
	}
	@Override
	public User isValidLogin(User user) {
		User newUser = getUser(user);
		logger.info(user.getPassword() + " ::: "+ newUser.getPassword());
		if (user.getPassword().equals( newUser.getPassword() ))
			return newUser;
		else
			return new User();
	}

	@Override
	public User createUser(User user) {
		user = userDao.createUser(user);
		user = (user == null)? new User(): user;
		return user;
	}
	@Override
	public JSONObject listCompany(User user) {
		// TODO Auto-generated method stub
		List<Company> list = userDao.listCompanies(user);
		JSONObject jo = new JSONObject();
		JSONArray jarr = new JSONArray();
		jo.put("message", "done");
		
		list.forEach(company -> jarr.add(company.toJSON()) );
		
		jo.put("data", jarr);
		
		return jo;
	}
	@Override
	public User getUserDetails(User user) {
		// TODO Auto-generated method stub
		return getUser(user);
	}
}
