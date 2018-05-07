package kh.com.finding.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kh.com.finding.entities.EntityUser;
import kh.com.finding.mappers.ServiceMappers;
import kh.com.finding.mappers.UserMapper;

@Service("customAuthenticationSerivce")
public class CustomAuthenticationSerivce implements UserDetailsService{

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private ServiceMappers serviceMappers;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		EntityUser entityUser = userMapper.loadingByUserName(username);
		if ( entityUser == null ){
			
			throw new UsernameNotFoundException("User Name Not match!!");
			
		}
		
		
		entityUser.setAuthorities(userMapper.loadingAuthoritiesByName(username));		
		entityUser.setServies(serviceMappers.loadingServiceByUserName(username));
		//System.out.println(entityUser.toString());
		return entityUser;
	}

}
