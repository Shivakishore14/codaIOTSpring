package global.coda.model;

import org.json.simple.JSONObject;

public class Company {
	private int cid;
	private String companyName;
	private String secret;
	private String addr1;
	private String addr2;
	private String city;
	private String state;
	private String country;
	
	public Company(int cid, String companyName, String secret, String addr1, String addr2, String city, String state,
			String country) {
		this.cid = cid;
		this.companyName = companyName;
		this.secret = secret;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	public Company() {
		
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("cid", this.cid);
		jo.put("companyName", this.companyName);
		jo.put("secret", this.secret);
		jo.put("addr1", this.addr1);
		jo.put("addr2", this.addr2);
		jo.put("city", this.city);
		jo.put("state", this.state);
		jo.put("country", this.country);
		return jo;
	}
}
