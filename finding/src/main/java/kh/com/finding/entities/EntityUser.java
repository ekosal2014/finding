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
	
	
	private List<EntityRole> authorities;
	
	private List<EntityService> servies;
	

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
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
