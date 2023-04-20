package com.iu.base.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDAO {
	
	public MemberVO getLogin (MemberVO memberVO) throws Exception;
	
	public int setJoin(MemberVO memberVO) throws Exception;
	
	public int setMemberRole(RoleVO roleVO) throws Exception;
	
	

}
