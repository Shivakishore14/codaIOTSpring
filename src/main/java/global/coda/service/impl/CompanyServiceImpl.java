package global.coda.service.impl;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import global.coda.dao.CompanyDao;
import global.coda.dao.UserDao;
import global.coda.model.Company;
import global.coda.model.Sensor;
import global.coda.model.User;
import global.coda.model.UserCompanyMapping;
import global.coda.service.CompanyService;
import global.coda.service.UserService;

public class CompanyServiceImpl implements CompanyService{
	private CompanyDao companyDao;
	private UserService userService;
	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	public JSONObject listUsers(Company company) {
		// TODO Auto-generated method stub
		List<User> list = companyDao.listUser(company);
		JSONObject jo = new JSONObject();
		JSONArray jarr = new JSONArray();
		jo.put("message", "done");
		for(User user: list) {
			jarr.add(user.toJSON());
		}
		jo.put("data", jarr);
		return jo;
	}


	@Override
	public JSONObject listSensor(Company company) {
		// TODO Auto-generated method stub
		List<Sensor> list = companyDao.listSensor(company);
		
		JSONObject jo = new JSONObject();
		JSONArray jarr = new JSONArray();
		jo.put("message", "done");
		for(Sensor sensor: list) {
			jarr.add(sensor.toJSON());
		}
		jo.put("data", jarr);
		
		return jo;
	}


	@Override
	public Company getCompany(int cid) {
		// TODO Auto-generated method stub
		Company c = companyDao.getCompany(cid);
		c = (c == null)? new Company(): c;
		return c;
	}


	@Override
	public JSONObject isAdmin(Company company, User user) {
		// TODO Auto-generated method stub
		User admin = companyDao.getAdmin(company);
		JSONObject jo = new JSONObject();
		jo.put("message", "done");
		jo.put("data", false);
		if(admin.getEmail() != null) {
			if(admin.getEmail().equals(user.getEmail()))
				jo.put("data", true);
		}
		return jo;
	}


	@Override
	public JSONObject createCompany(Company company) {
		// TODO Auto-generated method stub
		Boolean isCreated = companyDao.createCompany(company);
		JSONObject jo = new JSONObject();
		jo.put("message", "done");
		if ( !isCreated)
			jo.put("message", "error creating company");
		return jo;
	}


	@Override
	public JSONObject addSensor(Sensor sensor) {
		// TODO Auto-generated method stub
		Boolean isAdded = companyDao.addSensor(sensor);
		JSONObject jo = new JSONObject();
		jo.put("message", "done");
		if (!isAdded) {
			jo.put("message", "error adding sensor");
		}
		return jo;
	}

	public JSONObject inviteUser(Company company, User user) {
		JSONObject jo = new JSONObject();
		jo.put("message", "user to be invited");
		return jo;
	}
	@Override
	public JSONObject addUser(Company company, User user, String role) {
		// TODO Auto-generated method stub
		if (user.getId() == 0) {
			user = userService.getUserDetails(user);
			if (user.getFirstName() == null) {
				return inviteUser(company, user);
			}
		}
		UserCompanyMapping userCompanyMapping = new UserCompanyMapping();
		userCompanyMapping.setCid(company.getCid());
		userCompanyMapping.setUid(user.getId());
		userCompanyMapping.setRole(role);
		Boolean isAdded = companyDao.addUserToCompanny(userCompanyMapping);
		JSONObject jo = new JSONObject();
		jo.put("message","done");
		if (!isAdded)
			jo.put("message", "error adding user");
		return jo;
	}

	
}
