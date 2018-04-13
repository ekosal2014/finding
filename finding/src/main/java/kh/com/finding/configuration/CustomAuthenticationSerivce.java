package kh.com.finding.configuration;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kh.com.finding.entities.EntityUser;
import kh.com.finding.mappers.UserMapper;

@Service("customAuthenticationSerivce")
public class CustomAuthenticationSerivce implements UserDetailsService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		EntityUser user = userMapper.logInByUserName(username);
		
		if ( user == null ){
			
			throw new UsernameNotFoundException("User Name Not match!!");
			
		}
		
		
		
		return user;
	}

}
