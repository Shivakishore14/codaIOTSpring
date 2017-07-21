package global.coda.dao;

import org.json.simple.JSONObject;

import global.coda.model.Sensor;
import global.coda.model.SensorData;

public interface SensorDao {
	public boolean createSensor(Sensor sensor);
	public JSONObject getSensorData(Sensor sensor);
	public JSONObject putSensorDara(SensorData sensorData);
}
