package com.example.SpringBootDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http
			.csrf().disable()
			.authorizeRequests()
			//.antMatchers("/normal/login").permitAll() // this way access all role
			//.antMatchers("/normal/login").hasAnyRole("NORMAL") // those access who has a role NORMAL.
			//.antMatchers("/admin/login").hasRole("ADMIN") // those access who has a role ADMIN.
			.anyRequest()
			.authenticated()
			.and()
			//.httpBasic();// it use for simple login without logout contrllos
			.formLogin();//it use for login with logout contrllos.
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Jay").password(this.passwordEnc().encode("123456")).roles("ADMIN");
		auth.inMemoryAuthentication().withUser("nisarg").password(this.passwordEnc().encode("987654")).roles("NORMAL");
	}
	
	@Bean
	public PasswordEncoder passwordEnc() {
		return new BCryptPasswordEncoder(10);
	}


	
	

}
