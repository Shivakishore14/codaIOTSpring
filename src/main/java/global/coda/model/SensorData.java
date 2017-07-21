package global.coda.model;

public class SensorData {
	private int sid;
	private String secret;
	private String value;
	private String timestamp;
	public SensorData() {
		
	}
	public SensorData(int sid, String secret, String value, String timestamp) {
		this.sid = sid;
		this.value = value;
		this.secret = secret;
		this.timestamp = timestamp;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timstamp) {
		this.timestamp = timstamp;
	}
}
