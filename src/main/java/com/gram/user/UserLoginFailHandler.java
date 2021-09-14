package com.gram.user;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class UserLoginFailHandler implements AuthenticationFailureHandler {

	@Autowired
	MessageSource messageSource;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		if (exception instanceof AuthenticationServiceException) {
//			log.info("log1 = AuthenticationServiceException");
			request.setAttribute("loginFailMsg", messageSource.getMessage("error.not.id", null, Locale.getDefault()));
		
		} else if(exception instanceof BadCredentialsException) {
			log.info("log2 = BadCredentialsException");
			request.setAttribute("loginFailMsg", messageSource.getMessage("error.bad.wrong", null, Locale.getDefault()));
			
		} else if(exception instanceof LockedException) {
			log.info("log3 = LockedException");
			request.setAttribute("loginFailMsg", messageSource.getMessage("error.lock", null, Locale.getDefault()));
			
		} else if(exception instanceof DisabledException) {
			log.info("log4 = DisabledException");
			request.setAttribute("loginFailMsg", messageSource.getMessage("error.disable", null, Locale.getDefault()));
			
		} else if(exception instanceof AccountExpiredException) {
			log.info("log5 = AccountExpiredException");
			request.setAttribute("loginFailMsg", messageSource.getMessage("error.not.account", null, Locale.getDefault()));
			
		} else if(exception instanceof CredentialsExpiredException) {
			log.info("log6 = CredentialsExpiredException");
			request.setAttribute("loginFailMsg", messageSource.getMessage("error.not.pw", null, Locale.getDefault()));
		} else if(exception instanceof UsernameNotFoundException) {
			log.info("log7 = UsernameNotFoundException");
			request.setAttribute("loginFailMsg", messageSource.getMessage("error.not.auth", null, Locale.getDefault()));
		}
		
		// 로그인 페이지로 다시 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher("/user/login");
		dispatcher.forward(request, response);

	}

}
