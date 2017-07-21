package global.coda.service;

import org.json.simple.JSONObject;

import global.coda.model.Company;
import global.coda.model.Sensor;
import global.coda.model.SensorData;

public interface SensorService {
	public boolean createSensor(Sensor sensor);
	public JSONObject putData(SensorData sensorData, Company company);
	public JSONObject getSensorData(Sensor sensor);
}
