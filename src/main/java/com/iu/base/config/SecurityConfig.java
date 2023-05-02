package com.iu.base.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.iu.base.member.MemberSocialService;
import com.iu.base.security.UserLoginFailHandler;
import com.iu.base.security.UserLogoutHandler;
import com.iu.base.security.UserLogoutSuccessHandler;
import com.iu.base.security.UserSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserLogoutHandler userLogoutHandler;
	@Autowired
	private LogoutSuccessHandler logoutSuccessHandler;
	@Autowired
	private MemberSocialService memberSocialService;
	
	@Bean
	//public 을 선언하면 default로 바꾸라는 메세지 출력
	WebSecurityCustomizer webSecurityConfig() {
		//Security에서 무시해야하는 URL 패턴 등록
		return web -> web
				.ignoring()
				.antMatchers("/images/**")
				.antMatchers("/js/**")
				.antMatchers("/css/**")
				.antMatchers("/favicon/**")
				;
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.cors()
				//.disable()
				.and()
				.csrf()
				.disable()
			.authorizeRequests()
				//URL과 권한 매칭
				.antMatchers("/").permitAll()
				.antMatchers("/member/join").permitAll()
				.antMatchers("/notice/add").hasRole("MEMBER")
				.antMatchers("/notice/update").hasRole("ADMIN")
				.antMatchers("/notice/delete").hasRole("ADMIN")
				.antMatchers("/notice/*").permitAll()
				.antMatchers("/member/admin/**").hasRole("ADMIN")
				.antMatchers("/qna/add").hasAnyRole("ADMIN","MANAGER","MEMBER")
				//.anyRequest().authenticated()
				.anyRequest().permitAll()
				.and()
			.formLogin()
					.loginPage("/member/login")
					//.defaultSuccessUrl("/")
					//한번쓰고 버릴것들은 이렇게 객체생성해서 사용해도 된다 --> component어노테이션필요없음~
					.successHandler(new UserSuccessHandler())
					//.failureUrl("/member/login")
					.failureHandler(new UserLoginFailHandler())
					.permitAll()
					.and()
			.logout()
					.logoutUrl("/member/logout")
					//.logoutSuccessUrl("/")
					//.addLogoutHandler(userLogoutHandler)
					.logoutSuccessHandler(logoutSuccessHandler)
					//.logoutSuccessHandler(new UserLogoutSuccessHandler())
					.invalidateHttpSession(true)
					.deleteCookies("JSESSIONID")
					.permitAll()
					.and()
			.oauth2Login() //Social Login 설정
					.userInfoEndpoint()
					.userService(memberSocialService)
//				.sessionManagement()
//					.maximumSessions(1) //최대 허용가능한 세션의 수, -1 : 무제한
//					.maxSessionsPreventsLogin(false) //false : 이전 사용자의 세션을 만료시키는 , true:새로운 사용자를 못들어오게	
				;
		
		return httpSecurity.build();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
