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
	private String full_name;
	private String user_name;
	private String password;
	private String confirm_password;
	private String email   ;
	private String reg_dt  ;
	private String sts     ;
	private String image   ;
	private List<EntityRole> authorities;	
	private List<EntityService> servies;
	

	public String getUser_cd() {
		return user_cd;
	}


	public void setUser_cd(String user_cd) {
		this.user_cd = user_cd;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFull_name() {
		return full_name;
	}


	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getConfirm_password() {
		return confirm_password;
	}


	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
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
		return this.user_name;
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
		System.out.println(" ======= " + this.sts);
		return this.sts.equals("1") ? true : false;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Full Name = " + this.full_name + "\n" + 
			   "Email     = " + this.email     + "\n" +
		       "User Name = " + this.user_name + "\n" +
			   "Password  = " + this.password  + "\n" +
		       "reg_dt    = " + this.getReg_dt() + "\n" +
			   "sts       = " + this.sts       + "\n" ;
	}

	
	
}
