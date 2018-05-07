package kh.com.finding.configuration;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import kh.com.finding.utils.CustomRuntimeExcptionUtil;


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	private CustomAuthenticationSerivce customAuthenticationSerivce;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		
		String username = (String) authentication.getName();
		String password = (String) authentication.getCredentials();
		
		UserDetails entityuser =  this.customAuthenticationSerivce.loadUserByUsername(username);
		
		if ( !passwordEncoder.matches(password, entityuser.getPassword())){
			
			throw new UsernameNotFoundException("password not match!!");
			
		}
		
		if ( !entityuser.isEnabled() ) {
			throw new UsernameNotFoundException("User is disabled.");
		}
		
		
		
		Collection< ? extends GrantedAuthority> authorties = entityuser.getAuthorities();		
		return new UsernamePasswordAuthenticationToken(entityuser, entityuser.getPassword(), authorties);
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
