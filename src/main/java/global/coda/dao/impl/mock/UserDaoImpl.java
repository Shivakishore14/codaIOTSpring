package global.coda.dao.impl.mock;

import java.util.ArrayList;
import java.util.List;

import global.coda.dao.UserDao;
import global.coda.model.Company;
import global.coda.model.User;

public class UserDaoImpl implements UserDao{

	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		if (user.getId() % 2 == 0)
			return null;
		else
			return new User();
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company> listCompanies(User user) {
		//TODO Auto-generated method stub
		List<Company> list = new ArrayList<Company>();
		list.add(new Company(1,"asd",null,null,null,null,null, null));
		list.add(new Company(2,"asdasd",null,null,null,null,null, null));
		
		return list;
	}
	
}
