package global.coda.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import global.coda.constant.SqlConstant;
import global.coda.dao.UserDao;
import global.coda.model.Company;
import global.coda.model.User;

public class UserDaoImpl implements UserDao{
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		try {
			Connection con = dataSource.getConnection();
			PreparedStatement stmt = con.prepareStatement(SqlConstant.LOGIN_USER_QUERY);
	        stmt.setString(1, user.getEmail());
	
	        ResultSet rs=stmt.executeQuery();
	
	        if(rs.next()){
	        	User user1 = new User();
	        	user1.setFirstName( rs.getString("firstname") );
                user1.setSecondName( rs.getString("lastname") );
                user1.setPhone( rs.getString("phone") );
                user1.setId( rs.getInt("id") );
                user1.setPassword( rs.getString("password") );
                user1.setEmail(rs.getString("email"));
                
                return user1;
	        }
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new User();
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		try{
			Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement(SqlConstant.CREATE_USER_QUERY);
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getFirstName());
            stmt.setString(3, user.getSecondName());
            stmt.setString(4, user.getPhone());
            stmt.setString(5, user.getPassword());
            
            int t = stmt.executeUpdate();
            if (t == 1)
                return user;
        }catch(Exception e){
            e.printStackTrace();
        }

		return null;
	}

	@Override
	public List<Company> listCompanies(User user) {
		//TODO Auto-generated method stub
		List<Company> list = new ArrayList<Company>();
		try{
			Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement(SqlConstant.LIST_COMPANIES_OF_USER);
            
            stmt.setInt(1, user.getId());
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
            	Company company = new Company();
				company.setCompanyName( rs.getString("name") );
				company.setSecret( rs.getString("secret") );
				company.setCid( rs.getInt("cid") );
				
				list.add(company);
            }
        }catch(Exception e){
            e.printStackTrace();
            list = null;
        }
		return list;
	}
	
}
