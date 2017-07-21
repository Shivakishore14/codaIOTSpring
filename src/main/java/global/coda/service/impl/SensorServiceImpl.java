package global.coda.service.impl;

import org.json.simple.JSONObject;

import global.coda.dao.SensorDao;
import global.coda.model.Company;
import global.coda.model.Sensor;
import global.coda.model.SensorData;
import global.coda.service.SensorService;

public class SensorServiceImpl implements SensorService{
	private SensorDao sensorDao;
	public SensorDao getSensorDao() {
		return sensorDao;
	}

	public void setSensorDao(SensorDao sensorDao) {
		this.sensorDao = sensorDao;
	}

	@Override
	public boolean createSensor(Sensor sensor) {
		
		return false;
	}

	@Override
	public JSONObject putData(SensorData sensorData, Company company) {
		// TODO Auto-generated method stub
		if (company.getSecret() != null) {
			if (company.getSecret().equals(sensorData.getSecret())) {
				JSONObject jo = sensorDao.putSensorDara(sensorData);
				return jo;
			}
		}
		JSONObject jo = new JSONObject();
		jo.put("message", "secret doesn't match");
		return jo;
	}

	@Override
	public JSONObject getSensorData(Sensor sensor) {
		// TODO Auto-generated method stub
		JSONObject jo = sensorDao.getSensorData(sensor);
		return jo;
	}

}
