package global.coda.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import global.coda.constant.SqlConstant;
import global.coda.dao.SensorDao;
import global.coda.model.Sensor;
import global.coda.model.SensorData;

public class SensorDaoImpl implements SensorDao{
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public boolean createSensor(Sensor sensor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public JSONObject getSensorData(Sensor sensor) {
		// TODO Auto-generated method stub
		JSONObject jo = new JSONObject();
        jo.put("message", "done");
        
        try{
        	Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement(SqlConstant.GET_SENSOR_DATA);
            stmt.setInt(1, sensor.getSid());
            ResultSet rs = stmt.executeQuery();
            JSONArray a1 = new JSONArray();
            while (rs.next()){
               JSONObject o = new JSONObject();
               String timestamp = rs.getString("timestamp");
               String value = rs.getString("value");
               
               o.put("timestamp",timestamp);
               o.put("value", value);
                    
               a1.add(o);
            }
            jo.put("data", a1);
        }catch(Exception e){
            e.printStackTrace();
            jo.put("message", "error");
        }
        return jo;
	}

	@Override
	public JSONObject putSensorDara(SensorData sensorData) {
		// TODO Auto-generated method stub
		JSONObject jo = new JSONObject();
        try{
        	Connection con = dataSource.getConnection();
            jo.put("message", "done");
            if (true){ //TODO:change this
                PreparedStatement stmt = con.prepareStatement(SqlConstant.PUT_SENSOR_DATA);
                stmt.setInt(1, sensorData.getSid());
                stmt.setString(2, sensorData.getTimestamp());
                stmt.setString(3, sensorData.getValue());
                
                int t = stmt.executeUpdate();
                if (t != 1){
                    jo.put("message","error inserting value");
                }
            }else{
                jo.put("message","secret doesnt match");
            }
        }catch(Exception e){
            e.printStackTrace();
            jo.put("message","error");
        }
        return jo;
	}

}
