package com.iu.base.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.iu.base.member.MemberVO;

@Configuration // configuration 선
public class MessageConfig implements WebMvcConfigurer {
	
	//cookie, session 선택
	
	//객체생성 : @Annotation / xml 에 <bean>  ----> annotation 의 @Bean = xml 의 <bean> 역할과 동일 
	@Bean
	public LocaleResolver localeResolver() {
		//1.session 이용
		
		SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.KOREA);
		
		//2.cookie 이용 
		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
		cookieLocaleResolver.setDefaultLocale(Locale.KOREAN);
		cookieLocaleResolver.setCookieName("lang");
		
		return cookieLocaleResolver;
	}

	@Bean // 객체생성
	public LocaleChangeInterceptor getLoChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang_opt"); // 파라미터 이름 설정해주기 // 파라미터를 받아서 언어 구분
		
		return localeChangeInterceptor;
	}
}
