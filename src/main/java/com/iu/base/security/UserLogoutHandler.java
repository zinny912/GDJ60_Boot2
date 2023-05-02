package com.iu.base.security;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.iu.base.member.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserLogoutHandler implements LogoutHandler {
	
	@Value("${spring.security.oauth2.client.registration.kakao.client-id}")
	private String restKey;
	
	@Value("${spring.security.oauth2.client.registration.kakao.redirect-uri}")
	private String redirectUri;
	
	@Value("${spring.security.oauth2.client.registration.kakao.client-secret}")
	private String adminKey;

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		
			this.simpleLogout();
			try {
				response.sendRedirect("/");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
//		//request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
//				MemberVO memberVO=(MemberVO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//				Map<String, Object> atts = memberVO.getAttribute();
//				log.error("{} ATTS ::: ",atts);
//				//map에서 key를 꺼내서 iterator타입으로 바꾸자 
//				Iterator<String> keys = atts.keySet().iterator(); 
//				
//				log.error("{} RestAPI KEY ::: ",restKey);
//				log.error("{} RestAPI URI ::: ",redirectUri);
//				
//				
//				//반복문 돌려서 key값 알아보기
//				while(keys.hasNext()) {
//					String key = keys.next();
//					Object value = atts.get(key);
//					log.error("==============================> key {} :::", key);
//					log.error("==============================> value {} :::", value);
//				}
//		
//				this.logoutAll();
	}
	
	private void simpleLogout() {
		RestTemplate restTemplate = new RestTemplate();
		
		MemberVO memberVO=(MemberVO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		log.error("{}<------------------------------------------ 회원번호",memberVO.getAttribute().get("id"));
		
		
		//header
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK "+adminKey);
		
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		//parameter
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("target_id_type", "user_id");
		params.add("target_id", memberVO.getAttribute().get("id").toString());
		
		HttpEntity<MultiValueMap<String, String>> req = new HttpEntity<>(params,headers);
		
		String id = restTemplate.postForObject("https://kapi.kakao.com/v1/user/logout", req, String.class);
		log.error("{}<----------------------------------------로그아웃 결과.. 어드민키 사용해서..",id);
		
		
	}
	
	
//	private void logoutAll() {
//		// 카카오 계정과 함께 로그아웃
//		//1. 요청객체를 하나 생성 - 요청 준비
//		RestTemplate restTemplate = new RestTemplate();
//		
//		//2. Header - 필요없음
//		
//		//3. Parameter : REST_API_KEY, REDIRECT_ID 필요 / 
//		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//		params.add("client_id", restKey);
//		params.add("logout_redirect_uri", redirectUri);
//		
//		//4. request객체 생성 //null은 헤더값
//		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, null);
//		
//		//5. 요청 발생 (url, 리턴타입, request객체)
//		//1. String response = restTemplate.getForObject("https://kauth.kakao.com/oauth/logout", String.class, request);
//		ResponseEntity<String> response = restTemplate.getForEntity("https://kauth.kakao.com/oauth/logout?client_id="+restKey+"&logout_redirect_uri=http://localhost/member/socialLogout", String.class, request);
//		//response 값이 string이 아니니 String 값으로 변환해주기 
//		String result=response.getBody();
//		log.error("Logout Result :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: {}", result);
//		
//	}

}
