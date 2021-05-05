package com.gram.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	public void configure(WebSecurity web) throws Exception {
		// static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
		web.ignoring().antMatchers("/assets");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.formLogin()		
        .loginPage("/user/login")
        .loginProcessingUrl("/user/test")
        .failureUrl("/user/login?error")
        .defaultSuccessUrl("/mypage", true)
        .usernameParameter("userId")
        .passwordParameter("userPassword");
		
		// 여기에선 리소스외에 페이지의 인증/비인증/인증권한등을 설정하는게 좋은것 같습니다.
		http.authorizeRequests()
//		.antMatchers("/mypage").authenticated()
		.antMatchers("/**").permitAll()
		.antMatchers("/").permitAll();
		
		
		
	}
	
	
}
