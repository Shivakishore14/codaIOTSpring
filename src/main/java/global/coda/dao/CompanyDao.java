package global.coda.dao;

import java.util.List;

import global.coda.model.Company;
import global.coda.model.Sensor;
import global.coda.model.User;
import global.coda.model.UserCompanyMapping;

public interface CompanyDao {
	public boolean createCompany(Company company);
	public List<User> listUser(Company company);
	public List<Sensor> listSensor(Company company);
	public Company getCompany(int cid);
	public User getAdmin(Company company);
	public boolean addSensor(Sensor sensor);
	public boolean addUserToCompanny(UserCompanyMapping userCompanyMapping);
}
