package com.gram.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gram.user.CustomAuthenticationProvider;
import com.gram.user.UserLoginFailHandler;
import com.gram.user.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	UserService userService;
	@Autowired
	UserLoginFailHandler userLoginFailHandler;
	
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
			http
				.formLogin()
				.loginPage("/user/login")
				.usernameParameter("userId")
				.passwordParameter("userPassword")
				.loginProcessingUrl("/user/loginProcess")
				.defaultSuccessUrl("/", true)
				.failureHandler(userLoginFailHandler);
		
			http
				.authorizeRequests()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/member/**").hasRole("USER")
				.anyRequest().permitAll()
				.and().csrf().disable();
			
			http.logout().logoutUrl("/user/logout").invalidateHttpSession(true).logoutSuccessUrl("/user/login");
			http.exceptionHandling().accessDeniedPage("/user/accessDenied");
		
			
		
		
			
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// ???????????? ??? (????????? ?????? ???)
//      String password = passwordEncoder().encode("1111");
//      auth.inMemoryAuthentication().withUser("user").password(password).roles("USER");
//      auth.inMemoryAuthentication().withUser("manager").password(password).roles("MANAGER");
//      auth.inMemoryAuthentication().withUser("admin").password(password).roles("ADMIN");
		// ????????? ?????? ??????(???????????? ?????? ???)
//		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
		
		// ????????? ?????? ??????2
		auth.authenticationProvider(authenticationProvider());
	}
	
	// customAuthenticationProvider ???????????? ??????
    @Bean
    public AuthenticationProvider authenticationProvider() {
    	System.out.println("asdfasdfasdfasdfsa");
        return new CustomAuthenticationProvider();
    }
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// static ??????????????? ?????? ?????? ????????? ?????? ?????? ( = ???????????? )
		web.ignoring().antMatchers("/assets/**");
	}
	


	
	
}
