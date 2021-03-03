package dev.fun.examples.dto;

import java.util.List;

public class UserDto {
	
	private Long id;
	private String username;
	private String password;
	private String roleTitle;
	private List<String> authTitles;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRoleTitle() {
		return roleTitle;
	}
	
	public void setRoleTitle(String roleTitle) {
		this.roleTitle = roleTitle;
	}
	
	public List<String> getAuthTitles() {
		return authTitles;
	}
	
	public void setAuthTitles(List<String> authTitles) {
		this.authTitles = authTitles;
	}
	
	public UserDto() {
		
	}
	
}
