package global.coda.service;

import java.util.List;

import org.json.simple.JSONObject;

import global.coda.model.Company;
import global.coda.model.Sensor;
import global.coda.model.User;

public interface CompanyService {
	public JSONObject listUsers(Company company);
	public JSONObject listSensor(Company company);
	public Company getCompany(int cid);
	public JSONObject isAdmin(Company company, User user);
	public JSONObject createCompany(Company company);
	public JSONObject addSensor(Sensor sensor);
	public JSONObject addUser(Company company, User user, String role);
}
