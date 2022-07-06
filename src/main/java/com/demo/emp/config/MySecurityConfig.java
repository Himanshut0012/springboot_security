package com.demo.emp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.demo.emp.services.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailService customUserDetailService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
//				.csrf().disable()    //disable cookies
				.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
				.and()
				.authorizeRequests()
				.antMatchers("/signin").permitAll()
				.antMatchers(HttpMethod.GET,"/public/**").hasRole("NORMAL")
				.antMatchers("/users/**").hasRole("ADMIN")
				.anyRequest()
				.authenticated()
				.and()
//				.httpBasic();        // normal security
				.formLogin()        // form base authentication
				.loginPage("/signin")   // this open login fage
				.loginProcessingUrl("/dologin")
				.defaultSuccessUrl("/users/");
				
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
//		auth.inMemoryAuthentication().withUser("ram").password(this.passwordEncoder().encode("mahadev")).roles("NORMAL");
//		auth.inMemoryAuthentication().withUser("abc").password(this.passwordEncoder().encode("abc")).roles("ADMIN");
	
		auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
	}
	
//	Role - High level overview->NORMAL : READ
//	Authority - permission->READ\
//	ADMIN - read,write,update
	
	
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}   // this is work without mysql
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}

		
}
