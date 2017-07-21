package global.coda.dao.impl.mock;

import java.util.ArrayList;
import java.util.List;

import global.coda.dao.CompanyDao;
import global.coda.model.Company;
import global.coda.model.Sensor;
import global.coda.model.User;
import global.coda.model.UserCompanyMapping;

public class CompanyDaoImpl implements CompanyDao{

	@Override
	public boolean createCompany(Company company) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> listUser(Company company) {
		// TODO Auto-generated method stub
		User user1 = new User(1, "shiva","s","shiva@my.com",null, null);
		User user2 = new User(2, "shiva","s","shiva@my.com",null, null);
		User user3 = new User(3, "shiva","s","shiva@my.com",null, null);
		
		List<User> list = new ArrayList<User>();
		
		list.add(user1);
		list.add(user2);
		list.add(user3);
		
		return list;
	}

	@Override
	public List<Sensor> listSensor(Company company) {
		// TODO Auto-generated method stub
		Sensor sensor1 = new Sensor(1,1,"temp");
		Sensor sensor2 = new Sensor(2,1,"humidity");
		Sensor sensor3 = new Sensor(3,1,"pressure");
		
		List<Sensor> list = new ArrayList<Sensor>();
		list.add(sensor1);
		list.add(sensor2);
		list.add(sensor3);
		
		return list;
	}

	@Override
	public Company getCompany(int cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getAdmin(Company company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addSensor(Sensor sensor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUserToCompanny(UserCompanyMapping ucm) {
		// TODO Auto-generated method stub
		return false;
	}

}
