package global.coda.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import global.coda.constant.SqlConstant;
import global.coda.dao.CompanyDao;
import global.coda.model.Company;
import global.coda.model.Sensor;
import global.coda.model.User;
import global.coda.model.UserCompanyMapping;

public class CompanyDaoImpl implements CompanyDao{
    
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
    
	@Override
	public boolean createCompany(Company company) {
		// TODO Auto-generated method stub
		
        try{
        	Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement(SqlConstant.ADD_COMPANY);
            stmt.setString(1, company.getCompanyName());
            stmt.setString(2, company.getSecret());
            stmt.setString(3, company.getAddr1());
            stmt.setString(4, company.getAddr2());
            stmt.setString(5, company.getCity());
            stmt.setString(6, company.getState());
            stmt.setString(7, company.getCountry());
            
            //System.out.println(email+fname+lname+phone+password);
            //stmt.execute();
            int t = stmt.executeUpdate();
            if ( t != 1){
            	return false;
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
	}

	@Override
	public List<User> listUser(Company company) {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<User>();
		
		try{
			Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement(SqlConstant.LIST_USER_OF_COMPANY);
            stmt.setInt(1, company.getCid());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
            	User user1 = new User();
	        	user1.setFirstName( rs.getString("firstname") );
                user1.setSecondName( rs.getString("lastname") );
                user1.setPhone( rs.getString("phone") );
                user1.setId( rs.getInt("id") );
                user1.setEmail(rs.getString("email"));
                list.add(user1);

            }
        }catch(Exception e){
            e.printStackTrace();
        }
		return list;
	}

	@Override
	public List<Sensor> listSensor(Company company) {
		// TODO Auto-generated method stub
		
		List<Sensor> list = new ArrayList<Sensor>();
		try{
			Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement(SqlConstant.LIST_SENSOR_OF_COMPANY);
            stmt.setInt(1,company.getCid());
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
               Sensor sensor = new Sensor();
               sensor.setSid( rs.getInt("id") );
               sensor.setType( rs.getString("type") );
               list.add(sensor);
            }
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Company getCompany(int cid) {
		// TODO Auto-generated method stub
		try {
			Connection con = dataSource.getConnection();
			PreparedStatement stmt = con.prepareStatement(SqlConstant.GET_COMPANY_BY_CID);
	        stmt.setInt(1, cid);
	
	        ResultSet rs=stmt.executeQuery();
	
	        if(rs.next()){

	        	Company c = new Company();
	        	c.setCid(cid);
                c.setCompanyName(rs.getString("name"));
                c.setSecret(rs.getString("secret"));
                return c;
	        }
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public User getAdmin(Company company) {
		// TODO Auto-generated method stub
		try {
			Connection con = dataSource.getConnection();
			PreparedStatement stmt = con.prepareStatement(SqlConstant.GET_ADMIN_OF_COMPANY);
	        stmt.setInt(1, company.getCid());
	
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
		return null;
	}
	@Override
	public boolean addSensor(Sensor sensor) {
		// TODO Auto-generated method stub
		try{
			Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement(SqlConstant.ADD_SENSOR);
            stmt.setString(1, sensor.getType());
            stmt.setInt(2, sensor.getCid());

            int t = stmt.executeUpdate();
            if (t != 1){
            	return false;
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
		return false;
	}
	@Override
	public boolean addUserToCompanny(UserCompanyMapping userCompanyMapping) {
		// TODO Auto-generated method stub
		try{
			Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement("insert into user_company_mapping(userid, cid, role) values(?,?,?);");
            
            stmt.setInt(1, userCompanyMapping.getUid());
            stmt.setInt(2, userCompanyMapping.getCid());
            stmt.setString(3, userCompanyMapping.getRole());
            
            int t = stmt.executeUpdate();
            if (t == 1)
            	return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
	}

}
