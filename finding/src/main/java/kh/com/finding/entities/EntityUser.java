package kh.com.finding.entities;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class EntityUser implements UserDetails {	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String user_cd ;
	private String username;
	private String password;
	private String reg_dt  ;
	private String sts     ;
	private List<EntityRole> authorities;	
	private List<EntityService> servies;
	

	public String getUser_cd() {
		return user_cd;
	}


	public void setUser_cd(String user_cd) {
		this.user_cd = user_cd;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getReg_dt() {
		return reg_dt;
	}


	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}


	public String getSts() {
		return sts;
	}


	public void setSts(String sts) {
		this.sts = sts;
	}


	


	public void setAuthorities(List<EntityRole> authorities) {
		this.authorities = authorities;
	}

	
	public List<EntityService> getServies() {
		return servies;
	}


	public void setServies(List<EntityService> servies) {
		this.servies = servies;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return sts ==  "1" ? true : false;
	}

}
