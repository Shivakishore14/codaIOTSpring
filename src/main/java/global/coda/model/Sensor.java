package global.coda.model;

import org.json.simple.JSONObject;

public class Sensor {
	private int sid;
	private String type;
	private int cid;
	public Sensor() {
		
	}
	public Sensor(int sid, int cid, String type) {
		this.cid = cid;
		this.sid = sid;
		this.type = type;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("cid", this.cid);
		jo.put("sid", this.sid);
		jo.put("type", this.type);
		return jo;
	}
}
