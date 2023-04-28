package com.iu.base.member;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDAO {
	
	public MemberVO getLogin (MemberVO memberVO) throws Exception;
	
	public MemberVO idDuplicateCheck(MemberVO memberVO)throws Exception;
	
	public int setJoin(MemberVO memberVO) throws Exception;
	
	public int setMemberRole(Map<String, Object> map) throws Exception;
	
	public List<MemberVO> getMemberList() throws Exception;
	
	public int setLastTime(MemberVO memberVO) throws Exception;
	
	public int setEnabledMember() throws Exception;
	
	public List<MemberVO> getMemberBirthday() throws Exception;
	
	public int setNewPassword(MemberVO memberVO) throws Exception;
	
}
