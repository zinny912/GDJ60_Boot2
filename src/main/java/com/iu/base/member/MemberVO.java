package com.iu.base.member;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberVO implements UserDetails {
	
	@NotBlank
	private String username;
	@NotBlank
	@Size(min=6, max=16)
	private String password;
	
	private String passwordCheck;
	
	@NotBlank
	private String name;
	@NotBlank
	@Email
	private String email;
	@Past
	private Date birth;
	
	private boolean enabled;
	
	//private Date lsatTime;
	
	private List<RoleVO> roleVOs;

	
	
	//권한설정 List<RoleVO> 에 있는걸 GrantedAuthority 로 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(RoleVO roleVO:roleVOs) {
			authorities.add(new SimpleGrantedAuthority(roleVO.getRoleName()));
		}
				
		return authorities;
	}
	
//눈에 안보이지만 있는 것들... 
//	@Override
	//ID 반환 , username 반환
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
	//password 반환
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	//계정의 만료여부 
	//true :만료가 안됐다 , false: 계정만료
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	//계정잠김여부 
	//true: 잠기지않음 / false: 계정잠김 -> 로그인 안됨 
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	//비밀번호 만료여부
	//true: 만료되지 않음 / false : 비밀번호 만료 -> 로그인 안됨
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	
	//계정의 사용여부
	//true : 사용가능(계정의 활성화) / false: 사용불가(계정비활성화)
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.enabled;
	}
	
	

}
