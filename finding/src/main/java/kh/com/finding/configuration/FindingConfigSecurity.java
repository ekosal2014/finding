package kh.com.finding.configuration;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class FindingConfigSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomAuthenticationProvider  customAuthenticationProvider;
	
	@Autowired
	private AjaxAutenticationFailureHandler  ajaxAuthenticationFailureHandler;
	@Autowired
	private AjaxAuthenticationSuccessHandler ajaxAuthenticationSuccessHandler;
	@Autowired 
	private CustomAccessDeniedHandler customAccessDeniedHandler;
 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.authenticationProvider(this.customAuthenticationProvider);
	}
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
			.antMatchers("/**","/en/**","/kh/**").permitAll()
			.and()
			.formLogin()
				.loginPage("/{locale:en|kh}/login")
				.usernameParameter("username")
				.passwordParameter("password")
				//.failureUrl("/login?error")
				//.successForwardUrl("/")
				.successHandler(ajaxAuthenticationSuccessHandler)
				.failureHandler(ajaxAuthenticationFailureHandler)
				//.failureForwardUrl("/login")
				.permitAll()
			.and()
				.logout()
				.permitAll()
			.and()
			//.exceptionHandling().accessDeniedPage("/error/403");
			.exceptionHandling().accessDeniedHandler(customAccessDeniedHandler);
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
}
