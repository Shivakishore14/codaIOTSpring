package global.coda.model;

public class Session {
	private User user;
	private Company lastCompany;
	private boolean isLoggedin;
	
	public Session() {
		this.isLoggedin = false;
		this.user = new User();
		this.lastCompany = new Company();
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
		if(this.user.getEmail() != null) {
			this.isLoggedin = true;
		}else {
			this.isLoggedin = false;
			this.lastCompany = new Company();
		}
	}
	public boolean isLoggedin() {
		return isLoggedin;
	}
	public Company getLastCompany() {
		return lastCompany;
	}
	public void setLastCompany(Company lastCompany) {
		this.lastCompany = lastCompany;
	}
}
