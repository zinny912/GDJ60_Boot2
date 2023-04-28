package com.iu.base.security;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserLoginFailHandler implements AuthenticationFailureHandler{
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
//		log.error("=====나는 익셉션 메세지 ==={}========", exception.getMessage());
//		log.error("=====나는 그냥 익셉션^^==={}========", exception);
		
		String errorMessage = "";
		
		// 참조변수명 instanceof 클래스명
				if(exception instanceof BadCredentialsException) {
					errorMessage="아웃!! 비밀번호가 틀렸어요";
				}else if(exception instanceof InternalAuthenticationServiceException) {
					errorMessage="아웃!! 아이디가 틀렸어요";
					
				}else if(exception instanceof DisabledException) {
					errorMessage="유효하지 않은 사용자 다른곳 가세요";
					//enabled가 false인 경우 	
				}else if(exception instanceof CredentialsExpiredException)	{
					errorMessage="비밀번호 만료되었습니다. 변경해주세요";
					//credential false 인경우 : 
				}else if(exception instanceof AccountExpiredException) {	
					errorMessage="휴면계정입니다. 계정풀어주세요.";
					//account false인경우 : 만료계정 
				}else if(exception instanceof AccountStatusException) {
					errorMessage="잠긴계정입니다 잠금해제하고 오세요~";
					//account가 false인 경우 : 잠긴계정인경우 
				}else {
					errorMessage="3아웃!! 로그인 실패";
				}

				//redirect
				errorMessage = URLEncoder.encode(errorMessage, "UTF-8");
				response.sendRedirect("/member/login?errorMessage="+errorMessage);
		
	}
	
	

}
