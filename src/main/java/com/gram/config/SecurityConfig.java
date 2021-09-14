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
		// 인메모리 식 (확인용 으로 씀)
//      String password = passwordEncoder().encode("1111");
//      auth.inMemoryAuthentication().withUser("user").password(password).roles("USER");
//      auth.inMemoryAuthentication().withUser("manager").password(password).roles("MANAGER");
//      auth.inMemoryAuthentication().withUser("admin").password(password).roles("ADMIN");
		// 서비스 연결 방식(비밀번호 비교 전)
//		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
		
		// 서비스 연결 방식2
		auth.authenticationProvider(authenticationProvider());
	}
	
	// customAuthenticationProvider 오브젝트 생성
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
		// static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
		web.ignoring().antMatchers("/assets/**");
	}
	


	
	
}
