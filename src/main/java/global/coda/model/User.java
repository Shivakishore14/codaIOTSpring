package global.coda.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.json.simple.JSONObject;

public class User {
	private int id;
	private String firstName;
	private String secondName;
	@Email
	@NotNull
	private String email;
	@Digits(fraction = 0, integer = 10)
	private String phone;
	@Size(min=3)
	private String password;
	
	public User() {
		
	}
	
	public User(int id, String firstName, String secondName, String email, String phone, String password) {
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("id", this.id);
		jo.put("firstName", this.firstName);
		jo.put("secondName", this.secondName);
		jo.put("email", this.email);
		jo.put("phone", this.phone);
		return jo;
	}
}
