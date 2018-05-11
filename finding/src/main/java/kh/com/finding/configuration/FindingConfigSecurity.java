package kh.com.finding.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

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
	@Autowired 
	private LogoutSuccessHandlers logoutSuccessHandlers;
 
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
				.antMatchers("/"
						    ,"/{locale:en|kh}/"
						    ,"/login"
						    ,"/{locale:en|kh}/login"
						    ,"/{locale:en|kh}/register"
						    ,"/{locale:en|kh}/services/**")
							.permitAll()
				.antMatchers("/{locale:en|kh}/userinfo/**").hasAnyRole("ROLE_USER")
				.antMatchers("/{locale:en|kh}/admin-info/**").hasAnyRole("ROLE_ADMIN")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
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
				.logoutRequestMatcher(new AntPathRequestMatcher("/{locale:en|kh}/logout"))
				.logoutSuccessHandler(logoutSuccessHandlers)
				.permitAll()
				.and()
			//.exceptionHandling().accessDeniedPage("/error/403");
			.exceptionHandling().accessDeniedHandler(customAccessDeniedHandler);
	}


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.authenticationProvider(this.customAuthenticationProvider);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
		web.ignoring().antMatchers("/static/**");
	}
	
	/*@Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        //multipartResolver.setMaxUploadSize(2097152);
        multipartResolver.setMaxUploadSize(5242880);
        return multipartResolver;
    }*/
	
}
