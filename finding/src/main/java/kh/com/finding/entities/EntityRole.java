package kh.com.finding.entities;

import org.springframework.security.core.GrantedAuthority;

public class EntityRole implements GrantedAuthority{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int      role_cd;
	private String role_name;
	

	
	public int getRole_cd() {
		return role_cd;
	}



	public void setRole_cd(int role_cd) {
		this.role_cd = role_cd;
	}



	public String getRole_name() {
		return role_name;
	}



	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}



	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.role_name;
	}

}
