package dev.glinzac.learnapp.models;

public class UserDetailsModel {
	private boolean auth;
	private String role;
	private String fullname;
	
	public UserDetailsModel() {
		
	}
	public UserDetailsModel(boolean auth, String role, String fullname) {
		super();
		this.auth = auth;
		this.role = role;
		this.fullname = fullname;
	}
	public boolean isAuth() {
		return auth;
	}
	public void setAuth(boolean auth) {
		this.auth = auth;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	
	
	
	
}
